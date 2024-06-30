import React from 'react'
import { Link, NavLink, Route, BrowserRouter as Router, Routes } from 'react-router-dom'
import { Button, Container, Nav, Navbar, NavbarText, Row } from 'react-bootstrap';
import Home from './components/Home';
import NotFound from './NotFound';
import 'bootstrap/dist/css/bootstrap.min.css';
import Login from './authorization/Login';
import auth from './services/auth'
import Users from './components/users/Users'
import EditUser from './components/users/EditUser'
import { Role } from './services/auth';
import { IsLoggedIn } from './services/auth';
import { Username } from './services/auth';
import 'bootstrap/dist/css/bootstrap.min.css';
import EditActiveUser from './components/users/EditActiveUser';
import CreateUser from './components/users/CreateUser';
import CreateMatch from './components/Matches/CreateMatches';
import './App.css';
import Matches from './components/Matches/Matches';
import AddPointPlayer from './components/player/AddPointPlayer';

const App=()=>{



  
  if(IsLoggedIn()){
  return(

      
        <Router>
               <Navbar className="navbar-extraLarge" expand bg="dark" variant="dark" >
              <Navbar.Brand as={Link} to="/"  style={{ marginLeft:'20px' }}  ><b>Copmetitions</b></Navbar.Brand>
              <Nav className="navbar-links-center">
              
              {Role()=='isAdmin'&&
             <Nav.Link as={Link} to="/users">Users</Nav.Link>
                     }  
               <Nav.Link as={Link} to="/matches">Matches</Nav.Link>                
             </Nav>
                <Nav  className="justify-content-end" style={{ width: "100%",marginRight:'30px' }}>
                   <NavbarText className='text-info' style={{ display: 'inline' }}>
                      Welcome:
                        <Nav.Link as={Link} to={'/user'} style={{ display: 'inline' }}>
                              <NavbarText className='text-danger'><strong>{Username()}</strong></NavbarText>
                        </Nav.Link>
                 </NavbarText>
             </Nav>

               <Nav  style={{ marginRight:'30px' }} >
               <Button size="sm" variant="secondary" onClick={auth.logout}>Logout</Button>
               </Nav>

            </Navbar>
              <Container style={{paddingTop:"20px" }} >
                 <Routes>
                    <Route path="/" element={<Home/>}/>
                     <Route path="/player/:id" element={<AddPointPlayer/>}/>
                      <Route path="/matches" element={<Matches/>}/>
                    <Route path="/matches/create" element={<CreateMatch/>}/>
                      <Route path="/users" element={<Users/>}/>
                      <Route path="/user" element={<EditActiveUser/>}/>
                       <Route path="/users/:id" element={<EditUser/>}/>
                      <Route path="/registration" element={<CreateUser/>}/>
                    <Route path="*" element={<NotFound/>} />
                 </Routes>
                </Container>
                </Router>
             
        )
      }else{
        return(

          <Router>
               <Navbar  expand bg="dark" variant="dark">
              <Navbar.Brand as={Link} to="/"  style={{ marginLeft:'20px' }}><b>Copmetitions</b></Navbar.Brand>
            <Nav>
            <Nav.Link as={Link} to="/registration">Registration</Nav.Link>
             </Nav>

             <Nav  className="justify-content-end" style={{ width: "100%",marginRight:'30px' }}>
               <Nav.Link as={Link} to="/login"><b style={{color:'turquoise',textDecorationLine:'overline'}}>Login</b></Nav.Link>

             </Nav>
             
            </Navbar>
              <Container style={{paddingTop:"10px"}}>
                 <Routes>
                 
                    <Route path="/" element={<Home/>}/>
                    <Route path='/login' element={<Login/>}></Route>
                     <Route path="/registration" element={<CreateUser/>}/>

                    <Route path="*" element={<NotFound/>} />
                 </Routes>
                </Container>
                </Router>

        )
      }

}

export default App;
