import { useNavigate } from "react-router-dom"
import { useEffect, useState,useCallback } from "react"
import { Button, Col, Row, Table,Form } from "react-bootstrap";
import Axios from "../../apis/Axios";
import ShowMatches from "./ShowMatches";
import { Role } from "../../services/auth";


const  Matches = () =>{
    const [pageNo, setPageNo] = useState(0) // state za trenutni broj stranice
    const [maxPages, setMaxPages] = useState(0) 
    const [matches,setMatches]=useState([]);
    const [teams,setTeams]=useState([]);
    const [players,setPlayers]=useState([]); 
     const [searchParams, setSearchParams] = useState({
        hostId:"",
        awayId:""
    });

     const navigate= useNavigate();


    const getMatches=useCallback(()=>{
        Axios.get(`/utakmice?pageNo=${pageNo}`,{
             Headers:{'Content-Type': 'application/json'
            },
            data: {},
            params:{
               repAId:searchParams.hostId,
               repBId:searchParams.awayId,
            }
        }).then(res =>{
            console.log(res)
            setMaxPages(res.headers["total-pages"])
            setMatches(res.data)
         
        }).catch(err =>{
               if(err.response.status==500){
            alert("NE MOGU SE PRETRAZIVATE ISTE REPREZENTACIJE")
            }
            console.log(err.data)
        })
    },[searchParams,pageNo])

    


    const getTeams=()=>{
    Axios.get('/reprezentacije').
    then(res=>{
        console.log(res)
        setTeams(res.data);

    }).catch(err=>{
        console.log(err);
    })

}

    const getPlayers=()=>{
    Axios.get("/igraci").
    then(res=>{
        console.log(res)
        setPlayers(res.data);

    }).catch(err=>{
        console.log(err);
    })

}


    const maxPoints= LargestElement(players);
    const maxPlayer= top(players);
    function LargestElement(players) { 
    if (players.length === 0) { 
        console.log("Array is empty"); 
    }

    const  points=[];
    for(let it in players){
        points.push(players[it].ukupnoGolova)
    } 
  
    return Math.max.apply(null, points); 
} 



    function top(players){
    
    let topPlayer="";
    for(let it in players){
        if(players[it].ukupnoGolova===maxPoints){
            topPlayer=players[it].ime;
        }
    } 

    return topPlayer;
    }



    useEffect(()=>{
     getMatches()
     getTeams()
     getPlayers()
    },[pageNo]);
    
    




 
      const handleChange=(e)=>{
        const {name,value}=e.target;


       


        setSearchParams({ ...searchParams,[name]:value});
        console.log(e.target.value);

       
    } 

    const handleSearch=()=>{
      getMatches()
    }







const renderMatches = () =>{

    return matches.map((match,index)=>{
        
        return <ShowMatches key={match.id}  match={match}  ></ShowMatches>
    })
} 

        const goToCreate= ()=>{

        navigate("/matches/create");

    }
const handleEnterKeyPressPass = (event) => {
    if (event.key === 'Enter') {
        getMatches()
    }
};
return (
      
    <Col>
        < Row><h1>Matches</h1></Row>
                                <Row>
            
                        <div container="container">
                           
                            <Col>

                                <Form>
                                <Row>
                                    <Col>      
                                     <Form.Group>
                                        <Form.Label> Away team</Form.Label>
                                        <Form.Control as='select' id=" awayId" name="awayId" onChange={handleChange}  onKeyDown={handleEnterKeyPressPass}>
                                            <option value={""}>Choose away team</option>
                                                {teams.map((team, i) => (
                                                    <option key={team.id} value={team.id}>{team.skraceniNaziv}</option>
                                                ))}
                                        </Form.Control>
                                        </Form.Group>
                                        </Col>   
                                        <br />
                                        <Col>
                                     <Form.Group>
                                        <Form.Label>Home team</Form.Label>
                                        <Form.Control as='select' id="hostId" name="hostId" onChange={handleChange} onKeyDown={handleEnterKeyPressPass} >
                                            <option value={""}>Choose home team</option>
                                                {teams.map((team, i) => (
                                                    <option key={team.id} value={team.id}>{team.skraceniNaziv}</option>
                                                ))}
                                        </Form.Control>
                                        <br />
                                    </Form.Group>
                                    </Col>
                                    </Row>

                                    
                                </Form>

                                 <div container='container' style={{ display: 'flex'}}>
                                    
                                    <Button onClick={handleSearch} style={{marginTop:'30px'}} className="btn btn-primary"  >Search</Button>
                                    
                                </div>
                                
                            </Col>
                        </div>
                    </Row>      

                              <br/> <br/> <br/>
                    
               
  
               <Row><Col> 
                <div style={{ display: 'flex', justifyContent: "space-between",marginBottom:'5px' }}>

                        <div>
                        {Role() === 'isAdmin' &&
                            <Button  variant="primary" onClick={goToCreate} >Create Match</Button>
                        }
                    </div>
                    <div>
                        <Button disabled={pageNo <= 0} onClick={() => setPageNo(pageNo - 1)} className="btn btn-info" style={{ color: 'white' }}>Previous</Button>
                        <Button disabled={maxPages === -1 || pageNo >= maxPages - 1} onClick={() => setPageNo(pageNo + 1)} className="btn btn-info" style={{ color: 'white', marginLeft: '4px' }}>Next</Button>
                    </div>


                </div>            
                <Table id="assigment-table"className="table-striped table-bordered table-hover"  >
                   <thead className="table-dark" >
                        <tr >
                            <th>Team A</th>
                            <th>Team B</th>
                            <th>Points A</th>
                            <th>Points B</th>
                            <th></th>
                            <th></th>
                             {Role()=='isAdmin'&&
                            <th></th>}
                         
                        </tr>
                    </thead>
                    <tbody >
                        {renderMatches()}
                            
                    </tbody>                  
                </Table>
                 <Button onClick={()=>alert("Best player " + maxPlayer + " POINTS " + maxPoints)}  className="btn btn-success"  >Best player</Button>
  
                                    
           
                                    
              
                </Col></Row>
                
               
              </Col>
       
    )








}



export default Matches;