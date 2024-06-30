import Axios from "../../apis/Axios"
import {  useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"
import { Row, Col, Form, Button } from "react-bootstrap";


const CreateMatch=()=>{




    const[createdMatch,setCreatedMatch]=useState({
        hostId:-1,
        awayId:-1

    });
      const [teams,setTeams]=useState([]);
    
    var navigate = useNavigate();

    
    const getTeams=()=>{
    Axios.get('/reprezentacije').
    then(res=>{
        console.log(res)
        setTeams(res.data);

    }).catch(err=>{
        console.log(err);
    })

}





     useEffect(()=>{
        getTeams();
   
    },[])

 



    const addMatch = () =>{

   
        const dto={
                    reprezentacijaAId:createdMatch.hostId,
                    reprezentacijaBId:createdMatch.awayId


        }


        console.log(dto);

        Axios.post('/utakmice',dto).then(res =>{

        console.log(res);
        navigate("/matches")

    }).catch(err =>{
        console.error("Status kod:", err.response.status);
        console.error("Poruka:", err.response.data);
         console.error("AxiosError:", err);

        alert("Doslo je do greske");
    })

}

  const onValueChange=(e)=>{
        const {name,value}=e.target;




        setCreatedMatch({ ...createdMatch,[name]:value});
        console.log(e.target.value);
    }  


    

         return (
            
            <Row >
                <Col></Col>
                <Col xs="12" sm="10" md="8">
          
                    <Form>
                        <Form.Group>
                            <Form.Label> Away team</Form.Label>
                            <Form.Control as='select' id=" awayId" name="awayId" onChange={(e) => onValueChange(e)} >
                                 <option value={""}>Choose away team</option>
                                       {teams.map((team, i) => (
                                        <option key={team.id} value={team.id}>{team.skraceniNaziv}</option>
                                    ))}
                            </Form.Control>
                             <br />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label> Home team</Form.Label>
                            <Form.Control as='select' id="hostId" name="hostId" onChange={(e) => onValueChange(e)} >
                                 <option value={""}>Choose home team</option>
                                       {teams.map((team, i) => (
                                        <option key={team.id} value={team.id}>{team.skraceniNaziv}</option>
                                    ))}
                            </Form.Control>
                             <br />
                        </Form.Group>
                    <Button className="btn btn-primary btn-block" onClick={addMatch}>Add</Button>
                    </Form>
                </Col>
                <Col></Col>
          
            </Row>
    )   
}


export default CreateMatch;