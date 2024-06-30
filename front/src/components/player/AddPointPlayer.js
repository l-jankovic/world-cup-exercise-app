import { useNavigate, useParams } from "react-router-dom"
import { useEffect, useState,useCallback } from "react"
import { Button, Col, Row, Table,Form } from "react-bootstrap";
import Axios from "../../apis/Axios";  
    

//JAKO VAZNO dodavanje poena radi i pokazuje najboljeg igraca, samo ce max player DA kasni nekad sa jednim poenom!

const AddPointPlayer=()=>{

    const routeParams = useParams()
    const repId = routeParams.id;
    const [players,setPlayers]=useState([]);
    const [goalPlayer,setGoalPlayer]=useState({
        id:0
    });
    const getPlayers=()=>{
    Axios.get('/reprezentacije/'+repId+"/igraci").
    then(res=>{
        console.log(res)
        setPlayers(res.data);

    }).catch(err=>{
        console.log(err);
    })

}

      useEffect(()=>{
          getPlayers()
    },[]) 





     const addPoints = (playerId) => {

   
        
            Axios.put("igraci/dodajgo/" + playerId,{
            Headers:{'Content-Type': 'application/json'
            }
            })
            .then(res => {
                
               console.log(res);
               window.location.reload();
                
            })
            .catch(error => {
                console.log(error);
                alert('Error occured please try again!');
            })
    }
     const onIdChange = event => {
        console.log(event.target.value);

        setGoalPlayer({ id: event.target.value});
    }




    return (
        <Col>
        <   Row><h1>Add points to the player</h1></Row>
      <Row><Col>
            
                       <Form>
                        <Form.Group>
                            <Form.Label>Player</Form.Label>
                            <Form.Control as='select' id="id" name="id" onChange={onIdChange} >
                                 <option value={""}>Choose away team</option>
                                       {players.map((player, i) => (
                                        <option key={player.id} value={player.id}>{player.ime+ " "} {player.prezime}</option>
                                    ))}
                            </Form.Control>
                             <br />
                        </Form.Group>
                         <div container='container' style={{ display: 'flex'}}>
                                    
                                    <Button onClick={() => addPoints(goalPlayer.id)}style={{marginTop:'10px'}} className="btn btn-primary"  >Add points</Button>
                                    
                        </div>

                        </Form>

                </Col></Row>
                </Col>

    )

}


export default AddPointPlayer;