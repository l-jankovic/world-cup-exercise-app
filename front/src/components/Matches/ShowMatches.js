import Axios from "../../apis/Axios"
import { useNavigate } from "react-router-dom"
import { Button, Col, Row } from "react-bootstrap"

import { Role } from "../../services/auth";
const ShowMatches =(props) =>{

 
 var navigate = useNavigate()

  

    const deleteMatch = (matchId) => {

   
    
            Axios.delete("/utakmice/" + matchId)
            .then(res => {
               
                console.log(res);
                alert("Match was deleted")
                window.location.reload()
            })
            .catch(error => {
                console.log(error);
                alert('Error occured please try again!');
            })

    }


    
    const addPointA = (matchId,teamId) => {

   
        
            Axios.put("/utakmice/goa/" + matchId,{
            Headers:{'Content-Type': 'application/json'
            }
            })
            .then(res => {
               
                console.log(res);
                  alert("Points  updated TEAM A")
        
                navigate("/player/"+teamId);
            })
            .catch(error => {
                console.log(error);
                alert('Error occured please try again!');
            })

    }


     const addPointB = (matchId,teamId) => {

   
        
            Axios.put("/utakmice/gob/" + matchId,{
            Headers:{'Content-Type': 'application/json'
            }
            })
            .then(res => {
               
                console.log(res);
                alert("Points  updated TEAM B")
               navigate("/player/"+teamId);
            })
            .catch(error => {
                console.log(error);
                alert('Error occured please try again!');
            })
    }

//Ako  ne iniciramo u stateu nista onda Movie && Movie.naziv da ne bi pucalo null, tako za svaki parametar
  return (
           <tr>
           <td>{props.match.reprezentacijaANaziv}</td>
           <td>{props.match.reprezentacijaBNaziv}</td>
           <td>{props.match.brojGolovaA}</td>
           <td>{props.match.brojGolovaB}</td>
          
            <td><Button className="btn btn-primary" onClick={() => addPointA(props.match.id,props.match.reprezentacijaAId)}>A+1</Button></td>
            <td><Button className="btn btn-primary" onClick={() => addPointB(props.match.id,props.match.reprezentacijaBId)}>B+1</Button></td>
            {Role()=='isAdmin'&&
           <td><Button className="btn btn-danger" onClick={() => deleteMatch(props.match.id)}>Delete</Button></td>
            }
        </tr>
    )
}
     




export default ShowMatches;