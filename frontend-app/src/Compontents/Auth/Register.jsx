import React, { useState } from 'react'
import axios from 'axios'
function Register() {

    const [employeename, setEmployeename]  = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    async function Save(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8080/api/v1/employee/save",
            {
                name : employeename,
                email: email,
                password: password
            }).then((e)=>{
                if(e.data.message === "User already exists"){
                    alert("user already exists");
                }
                else if(e.data.message === "Registation Successfully"){
                    alert("Employee Registation Successfully");
                }
            });
        } catch (error) {
            alert(error);
        }
    }


  return (
    <div className='container mt-4'>
        <div className='card'>
            <h1>Registation</h1>
        </div>
        <form>
            <div className='form-group'>
                <label>Employee name</label>
                <input type='text' className='form-control' id='employeename' placeholder='Enter Name'
                value={employeename} 
                onChange={(event)=>{setEmployeename(event.target.value);}}
                />
            </div>
            <div class="form-group">
                <label>email</label>
                <input type="email"  class="form-control" id="email" placeholder="Enter Email"
                value={email}
                onChange={(event) => {
                    setEmail(event.target.value);
                }}
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
            <button type='submit' className='btn btn-primary mt-4' onClick={Save} >Save</button>
        </form>
    </div>
  )
}

export default Register