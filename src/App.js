import { useEffect, useState } from 'react';
import './App.css';

import React, {Component} from 'react';
import styled from 'styled-components';
import {  Route, Switch, NavLink} from 'react-router-dom';

import MainHeader from './components/MainHeader/MainHeader.js';
import Header from './components/Header.js';
import Login from './components/Login.js';
import SignIn from './components/SignIn';
import Home from './components/Home';

import 'react-calendar/dist/Calendar.css';

const NavStyle=styled.div`
    
  width: 100%;
  text-align : right;  
  background: #00a99d;
  margin-top:6%
    
`;

const MenuStyle=styled.div`
    
  width: 20%;
  
  background: #ddd;
  
`;

const ChatStyle=styled.div`
    
width: 20%;
  float: right
    
`;

function Contact(){
  return(
    <div>
      <h2>stevekim97g@gmail.com</h2>
    </div>
  )
}


function App() { 
  
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  
  useEffect(()=> {
    const stroedUserLoggedInInformation = localStorage.getItem('isLoggedIn') ;
    if (stroedUserLoggedInInformation === '1'){
      setIsLoggedIn(true);
    }  

  }, []);

    const loginHandler = (email, password) => {
      localStorage.setItem('isLoggedIn', '1'); //loggedin 1 loggedout 0 
      setIsLoggedIn(true);
    };

    
    const logoutHandler = () => {
      localStorage.removeItem('isLoggedIn');
      setIsLoggedIn(false);
    };
    return (
      <>        
        
      <MainHeader isAuthenticated={isLoggedIn} onLogout={logoutHandler} />
      

      
      <main>
        {!isLoggedIn && <Login onLogin={loginHandler} />}
        {isLoggedIn && <Home onLogout={logoutHandler} />}
      </main>
      
     

      <div>
          
      </div>      

       
    </>
    );
  
}

export default App;
