import React, { useState } from 'react';
import { Box, TextField, Button, Typography, CardContent } from '@mui/material';
import { Register_User } from "../Services/user";




const Gst_rex = "\d{2}[A-Z]{5}\d{4}[A-Z]{1}[A-Z\d]{1}[Z]{1}[A-Z\d]{1}"


export default function FormComponent() {
  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: '',
    fullName: '',
    designation: '',
    companyName: '',
    gstNo: '',
    contactNo: '',
    telephoneNo: '', // optional
    addressLine1: '',
    addressLine2: '', // optional
    city: '',
    state: '',
    pincode: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    
    const gstRegex = /^\d{2}[A-Z]{5}\d{4}[A-Z]{1}[A-Z\d]{1}[Z]{1}[A-Z\d]{1}$/;
    const contactRegex = /^\d{10}$/;
    const usernameRegex = /^[a-zA-Z0-9_]{3,16}$/;
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    const passwordRegex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@$!%*?&#])[A-Za-z\d@$!%*?&#]{8,}$/;
    const fullnameRegex = /^[a-zA-Z\s]{1,50}$/;
    const designationRegex = /^[a-zA-Z\s]{1,50}$/;
    const companyRegex = /^[a-zA-Z0-9\s,.-]{1,100}$/;
    const add1Regex = /^[a-zA-Z0-9\s,.-]{1,150}$/;
    const pinRegex = /^[1-9][0-9]{5}$/;




    // if (!usernameRegex.test(formData.username)) {
    //     alert("Invalid User Name format.");
    //     return;
    // }
    // else if(!emailRegex.test(formData.email)){
    //     alert("Invalid Email format.");
    //     return;
    // }
    // else if(!passwordRegex.test(formData.password)){
    //     alert("Invalid Password format.");
    //     return;
    // }
    // else if(!fullnameRegex.test(formData.fullName)){
    //     alert("Invalid Full Name format.");
    //     return;
    // }
    // else if(!designationRegex.test(formData.designation)){
    //     alert("Invalid Designation format.");
    //     return;
    // }
    // else if(!companyRegex.test(formData.companyName)){
    //     alert("Invalid Company Name format.");
    //     return;
    // }
    // else if(!gstRegex.test(formData.gstNo)){
    //     alert("Invalid GST Number format.");
    //     return;
    // }
    // else if(!contactRegex.test(formData.contactNo)){
    //     alert("Invalid Contact Number format.");
    //     return;
    // }
    // else if(!add1Regex.test(formData.addressLine1)){
    //     alert("Invalid Address format.");
    //     return;
    // }
    // else if(!pinRegex.test(formData.pincode)){
    //     alert("Invalid PinCode format.");
    //     return;
    // }


    try {
        const response = await Register_User(formData);
        console.log('Response:', response);
        alert('Registration successful!');
    } catch (error) {
        console.error('Error during sign-up:', error);
        alert('Registration failed!');
    }
};



  return (
    <Box
      sx={{
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        minHeight: '100vh',
        backgroundImage: 'linear-gradient(0deg, #FFDEE9 0%, #B5FFFC 100%)',
      }}
    >
      <Box
        sx={{
          width: { xs: '100%', sm: 1000 },
          backgroundColor: 'white',
          padding: 4,
          borderRadius: 2,
          boxShadow: 3,
        }}
      >
        <Typography
          variant="h3"
          fontWeight="bold"
          color="#e7790f"
          textAlign="center"
          fontFamily="Marker Felt, fantasy"
          gutterBottom
        >
          Registeration
        </Typography>
        <CardContent>
          <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'row', flexWrap: 'wrap' }}>
            {/* Left Column */}
            <div style={{ display: 'flex', flexDirection: 'column', gap: '16px', flex: 1, marginRight: '16px' }}>
              <TextField
                label="Username"
                name="username"
                value={formData.username}
                onChange={handleChange}
                required
                fullWidth
              />
              <TextField
                type="email"
                label="Email"
                name="email"
                value={formData.email}
                onChange={handleChange}
                required
                fullWidth
              />
              <TextField
                type="password"
                label="Password"
                name="password"
                value={formData.password}
                onChange={handleChange}
                required
                fullWidth
              />
              <TextField
                label="Full Name"
                name="fullName"
                value={formData.fullName}
                onChange={handleChange}
                required
                fullWidth
              />
              <TextField
                label="Designation"
                name="designation"
                value={formData.designation}
                onChange={handleChange}
                required
                fullWidth
              />
              <TextField
                label="Company Name"
                name="companyName"
                value={formData.companyName}
                onChange={handleChange}
                required
                fullWidth
              />
              <TextField
                label="GST No"
                name="gstNo"
                value={formData.gstNo}
                onChange={handleChange}
                required
                fullWidth
              />
            </div>

            {/* Right Column */}
            <div style={{ display: 'flex', flexDirection: 'column', gap: '16px', flex: 1 }}>
              <TextField
                label="Contact No"
                name="contactNo"
                value={formData.contactNo}
                onChange={handleChange}
                required
                fullWidth
              />
              <TextField
                label="Telephone No (Optional)"
                name="telephoneNo"
                value={formData.telephoneNo}
                onChange={handleChange}
                fullWidth
              />
              <TextField
                label="Address Line 1"
                name="addressLine1"
                value={formData.addressLine1}
                onChange={handleChange}
                required
                fullWidth
              />
              <TextField
                label="Address Line 2 (Optional)"
                name="addressLine2"
                value={formData.addressLine2}
                onChange={handleChange}
                fullWidth
              />
              <TextField
                label="City"
                name="city"
                value={formData.city}
                onChange={handleChange}
                required
                fullWidth
              />
              <TextField
                label="State"
                name="state"
                value={formData.state}
                onChange={handleChange}
                required
                fullWidth
              />
              <TextField
                label="Pincode"
                name="pincode"
                value={formData.pincode}
                onChange={handleChange}
                required
                fullWidth
              />
            </div>
            <Button
              type="submit"
              variant="contained"
              color="primary"
              style={{ marginTop: '16px', width: '100%' }}
              onClick={handleSubmit}
            >
              Submit
            </Button>
          </form>
        </CardContent>
      </Box>
    </Box>
  );
}
