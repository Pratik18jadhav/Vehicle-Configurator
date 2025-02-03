import axios from 'axios'



// User registration
 export async function Register_User (user_Reg)
 {
    console.log(user_Reg);
  let response =  await axios.post("http://localhost:8080/signup", user_Reg);
  console.log(user_Reg);
   //return response;
 }


// User Login
 export async function ussignIn (signInObj)

 {
  let response = await axios.post("http://localhost:5000/api/v1/users/Userlogin",signInObj);
  return response;
 }