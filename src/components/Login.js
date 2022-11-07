import React, {useState, useEffect} from "react";
import styled from "styled-components";
import { Route, Switch, NavLink} from 'react-router-dom';
import SignIn from "./SignUp";

import Card from './UI/Card/Card';
import classes from './Login.module.css';
import Button from './UI/Button/Button';

const Login = (props) => {
    const [enteredEmail, setEnteredEmail] = useState('');
    const [emailIsValid, setEmailIsValid] = useState();
    const [enteredPassword, setEnteredPassword] = useState('');
    const [passwordIsValid, setPasswordIsValid] = useState();
    const [formIsValid, setFormIsValid] = useState(false);
    useEffect(()=> {
        setFormIsValid(
        enteredEmail.includes('@') && enteredPassword.trim().length > 6);
    },[setFormIsValid, enteredEmail, enteredPassword]);
    const emailChangeHandler = (event) => {
      setEnteredEmail(event.target.value);
         
      
    };
  
    const passwordChangeHandler = (event) => {
      setEnteredPassword(event.target.value);
  
      setFormIsValid(
        event.target.value.trim().length > 6 && enteredEmail.includes('@')
      );
    };
  
    const validateEmailHandler = () => {
      setEmailIsValid(enteredEmail.includes('@'));
    };
  
    const validatePasswordHandler = () => {
      setPasswordIsValid(enteredPassword.trim().length > 6);
    };
  
    const submitHandler = (event) => {
      event.preventDefault();
      props.onLogin(enteredEmail, enteredPassword);
    };
    
    return (
      <Card className={classes.login}>
        <form onSubmit={submitHandler}>
          <div
            className={`${classes.control} ${
              emailIsValid === false ? classes.invalid : ''
            }`}
          >
            <label htmlFor="email">E-Mail</label><br/>
            <input
              type="email"
              id="email"
              value={enteredEmail}
              onChange={emailChangeHandler}
              onBlur={validateEmailHandler}
            />
          </div>
          <div
            className={`${classes.control} ${
              passwordIsValid === false ? classes.invalid : ''
            }`}
          >
            <label htmlFor="password">Password</label><br/>
            <input
              type="password"
              id="password"
              value={enteredPassword}
              onChange={passwordChangeHandler}
              onBlur={validatePasswordHandler}
            />
          </div>
          <div className={classes.actions}>
            <Button type="submit" className={classes.btn} disabled={!formIsValid}>
              Login
            </Button><br/>
            <a href="/signin"> 회원가입</a>
        
          </div>
        </form>
        
      </Card>
    );
  };
  
  export default Login;
/*

        <SignInButtonStyle>
        
        <div >
        <NavLink to="/signin">SIGN IN</NavLink>
        
        </div>
        
        <Switch>
        <Route path="/signin"><SignIn/></Route>
        </Switch>
        </SignInButtonStyle>
        </div>

        <form method="post">
        <div >
            <div class="alert alert-danger">
                사용자ID 또는 비밀번호를 확인해 주세요.
            </div>
        </div>
        <div class="mb-3">
            <label for="username" class="form-label">사용자ID</label>
            <input type="text" name="username" id="username" class="form-control"/>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">비밀번호</label>
            <input type="password" name="password" id="password" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-primary">로그인</button>
    </form>
		</>
    )

}
export default Login;*/