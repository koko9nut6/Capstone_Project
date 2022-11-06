import React, {useState} from "react";

import styled from "styled-components";
import {  Route, Switch, NavLink} from 'react-router-dom';

const SignIn= (props) => {
  const [enteredEmail, setEnteredEmail] = useState('');  
  const [enteredPassword, , setEnteredPassword] = useState('');
  const [enteredPasswordCheck, , setEnteredPasswordCheck] = useState('');

  const [enteredName, setEnteredName] = useState('');

  const addUserHandler = (event) => {
    event.preventDefault();
    console.log(enteredEmail, enteredPassword);
  };

  const emailChangeHandler = (event) => {
    setEnteredEmail(event.target.value);
  };

  const passwordChangeHandler = (event) => {
    setEnteredPassword(event.target.value);
  };


    return(
    
    <>
    
    
    <form style={{display: 'flex', alignItems:'center', flexDirection: 'column', marginTop: '5%'}} onSubmit={addUserHandler}>
    <label htmlFor="email">아메일 주소 </label>
      <input type="text"  placeholder="email"  className="email" 
      value={enteredEmail} onChange={emailChangeHandler}/>  <br></br>
      <label htmlFor="email">비밀번호 </label>
      <input type="text" placeholder="password"  className="password" 
      ></input>  <br></br>
      <label htmlFor="email">비밀번호 확인</label>
      <input type="text"  placeholder="password confirm"  className="passwordcheck"
       ></input>  <br></br>
      <label htmlFor="email">이름</label>
      <input type="text"   placeholder="Name"  className="name"></input>  <br></br>
      <label htmlFor="email">전화번호</label>
      <input type="text"   placeholder="phoneNumber"  className="phoneNumber"></input>  <br></br>
      <label htmlFor="email">매장</label>
      <input type="text"  data-text-content="true" placeholder="매장위치"  className=""></input>  <br></br>

      <button class="button" type="submit">회원가입</button>
      </form>  
      
    </>
        
    )
}




export default SignIn;