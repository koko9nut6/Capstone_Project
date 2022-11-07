import React, { useState } from "react";
import styled from 'styled-components';
import {  Route, Switch, NavLink} from 'react-router-dom';
import Calendar from 'react-calendar';

const NavStyle=styled.div`
    
  width: 100%;
  text-align : right;  
  background: #00a99d;
 
    
`;

const MenuStyle=styled.div`
  margin-top: 5%;

  width: 30%;
  
  background: #ddd;
  
`;

const ChatStyle=styled.div`
    
width: 20%;
  float: right  
  
`;
function Home(){
    const [value, onChange] = useState(new Date());
  
    return (
      <>
        <MenuStyle >
        
        <ul style={{ listStyleType: "none" }}>        
          
          <li><NavLink to="/workerInfo" style={{ textDecoration: 'none' }}>직원 조회</NavLink></li>
          <li><NavLink to="/myworkInfo" style={{ textDecoration: 'none' }}>근무 일정</NavLink></li>
          <li><NavLink to="/inventory"  style={{ textDecoration: 'none' }}>재고관리</NavLink></li>
          <li><NavLink to="/profile" style={{ textDecoration: 'none' }}>내 프로필</NavLink></li>
        </ul>
        </MenuStyle>
        <Calendar onChange={onChange} value={value} />
        <ChatStyle>
        
        </ChatStyle>
      </>
    )
  
  }

  export default Home