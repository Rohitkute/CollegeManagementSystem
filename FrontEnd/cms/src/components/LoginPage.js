
import React, { useReducer, useState } from "react"
import { useNavigate } from "react-router-dom";

export default function (props) {
  const init={
    username:"",
    password:""
  }
  const reducer=(state,action)=>{
    switch(action.type)
    {
      case 'update':
        return {...state,[action.fld]:action.val}
      case 'reset':
        return init;
    }
  }
  const [info,dispatch]=useReducer(reducer,init);
  const [msg,setMSG]= useState("");
  const navigate = useNavigate();

  const sendData = (e)=>{
    e.preventDefault();
    const reqOptions={
      method:"POST",
      headers:{'content-type':'application/JSON'},
      body:JSON.stringify(info)
    }
    fetch("http://localhost:8080/chkLogin",reqOptions)
    .then(resp=>{
            if(resp.ok)
            {
              console.log(resp.status)
              return resp.json();
            }
            else
            {
              console.log(resp.status)  
              throw new Error("Server Error");
            }
    })
    
    .then(obj=>{
      if(Object.keys(obj).length===0)
      {
        setMSG("Plese Check Username And Password");
      }
      else
      {
         if(obj.status===false)
         {
          alert("Request has been Approved");
         }
         else
         {
          if(obj.role_id.role_id===1)
          {
              navigate("/Admin_Home");
          }
          else if(obj.role_id.role_id===2)
          {
            navigate("/Student_Home");
          }
          else if(obj.role_id.role_id===3)
          {
            navigate("/Professor_Home");
          }
         }
      }
    })
    .catch((error)=>alert("server error.Try After Some Time"));
  }
  
  return (
    <div className="Auth-form-container">
      <form className="Auth-form">
        <div className="Auth-form-content">
          <h3 className="Auth-form-title">Sign In</h3>
          <div className="form-group mt-3">
            <label>UserName</label>
            <input
              type="text"
              id="username"
              value={info.username}
              name="username"
              className="form-control mt-1"
              placeholder="Enter User Name"
              onChange={(e)=>{dispatch({type:'update',fld:'username',val:e.target.value})}}
            />
            <div id="userdiv">....</div>
          </div>
          <div className="form-group mt-3">
            <label>Password</label>
            <input
              type="password"
              id="password"
              name="password"
              value={info.password}
              className="form-control mt-1"
              placeholder="Enter password"
              onChange={(e)=>{dispatch({type:'update',fld:'password',val:e.target.value})}}
            />
            <div>...</div>
          </div>
          <div className="d-grid gap-2 mt-3">
            <button type="submit" className="btn btn-primary" onClick={(e)=>{sendData(e)}}>
              Submit
            </button>
          </div>
          <p className="forgot-password text-right mt-2">
            Forgot <a href="#">password?</a>
          </p>
        </div>
        <div>{msg}</div>
      </form>
      <p>{JSON.stringify(info)}</p>
    </div>
  )
}