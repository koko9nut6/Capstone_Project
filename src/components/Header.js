import { render } from "@testing-library/react";
import React from "react";
import styled from "styled-components";


const HeaderStyle=styled.div`

padding-left: 32px;
padding-right: 32px;

border-bottom: 1px solid #e9ecef;
h1 {
    text-align: center;
    margin: 0;
    font-size: 36px;
    color: #397CA8;
}
.day {
  margin-top: 4px;
  color: #868e96;
  font-size: 21px;
}
.tasks-left {
  color: #20c997;
  font-size: 18px;
  margin-top: 40px;
  font-weight: bold;
}
`;


function Header () {
    const today = new Date();
    const dateString = today.toLocaleDateString('ko-KR', {
    year: 'numeric',
    month: 'long',
    day: 'numeric'
    });
    const dayName = today.toLocaleDateString('ko-KR', { weekday: 'long' });

    return(
        <div>
        <HeaderStyle> 
        <h1>알바 24</h1>
        <h3>{dateString} {dayName}</h3>
        
        </HeaderStyle>
        </div>
    );
}

export default Header;




