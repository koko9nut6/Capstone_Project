import React, {useState} from "react";

import styled from "styled-components";
import {  Route, Switch, NavLink} from 'react-router-dom';
import Button from "./UI/Button/Button";
const SignUp= (props) => {

  const [inputs, setInputs] = useState({
		
		email: "",
		password: "",
    name: "",
    phonenumber: "",
    store: ""

	});
  const [email, setEnteredEmail] = useState('');  
  const [password, setEnteredPassword] = useState('');
  const [passwordCheck, setEnteredPasswordCheck] = useState('');
  
  const [name, setEnteredName] = useState('');
  const [phonenumber, setEnteredNumber] = useState('');
  const [store, setEnteredStore] = useState('');
  const addUserHandler = (event) => {
    event.preventDefault();
    console.log(email, password);
  };

  const emailChangeHandler = (event) => {
    setEnteredEmail(event.target.value);
  };

  const passwordChangeHandler = (event) => {
    setEnteredPassword(event.target.value);
  };

  const onChange = (e) => {
		const { value, name } = e.target;
		setInputs({
			...inputs,
			[name]: value,
		});
	};


    return(
    
    <>
    
    
    <form style={{display: 'flex', alignItems:'center', flexDirection: 'column', marginTop: '5%'}} onSubmit={addUserHandler}>
    <label htmlFor="email">아메일 주소 </label>
      <input type="text"  placeholder="email" 
      value={email} onChange={emailChangeHandler}/>  <br></br>
      <label htmlFor="email">비밀번호 </label>
      <input type="password" placeholder="password"  
      value={password} onChange={passwordChangeHandler}></input>  <br></br>
      <label htmlFor="password">비밀번호 확인</label>
      <input type="password"  placeholder="password confirm"  
       ></input>  <br></br>
      <label htmlFor="name">이름</label>
      <input type="text"   placeholder="Name"  className="name"></input>  
      value={name}<br/>
      <label htmlFor="phonenumber">전화번호</label>
      <input type="text"   placeholder="phoneNumber"  
      value={phonenumber}></input>  <br/>
      <label htmlFor="store">매장</label>
      <input type="text"  placeholder="매장위치"  
      value={store}></input>  <br></br>

      <Button class="button" type="submit">회원가입</Button>
      </form>  
      
    </>
        
    )
}




export default SignUp;