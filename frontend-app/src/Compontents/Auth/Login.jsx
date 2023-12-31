import axios from 'axios';
import React, { useState } from 'react'
import {useNavigate} from 'react-router-dom'
function Login() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();


    async function login(event){
        event.preventDefault();
        await axios.post("http://localhost:8080/api/v1/employee/login",
            {
                email : email,
                password : password
            }
        ).then((res)=>{
            console.log(res);
            if(res.data.message === "Email not Exists")
            {
                alert("Email not exits");
            }
            else if(res.data.message === "Login Success"){
                navigate('/home');
            }
            else
            {
                alert("Incorrect Email and Password not match");
            }
        },fail => {
            console.log(fail); //error!
        });
    }
  return (
    <>
        <div className='container'>
            <div className='row'>
                <h2>Login</h2>
                <hr />
            </div>
            <div className='row' >
                <div className='col-sm-6'>
                    <form>
                        <div className='form-group'>
                            <lable>Email</lable>
                            <input type='email' className='form-control' placeholder='Enter Name'
                                value={email}
                                onChange={(event)=>setEmail(event.target.value)}
                            />
                        </div>
                        <div class="form-group">
                            <label>password</label>
                            <input type="password"  class="form-control" id="password" placeholder="Enter password"
                            value={password}
                            onChange={(event) => {
                            setPassword(event.target.value);
                            }}
                            />
                        </div>
                        <button type="submit" class="btn btn-primary" onClick={login} >Login</button>
                    </form>
                </div>
            </div>
        </div>
    </>
  )
}

export default Login