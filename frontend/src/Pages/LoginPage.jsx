import React, { useState } from 'react';
import { Box, TextField, Typography, Button, Alert } from '@mui/material';
import { Link } from 'react-router-dom'; // Import Link for navigation
import logo from '../Content/logo.png';

export const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!email || !password) {
      setError('Both email and password are required!');
    } else {
      setError('');
      alert(`Logged in as: ${email}`);
    }
  };

  return (
    <Box
      sx={{
        display: 'flex',
        justifyContent: 'space-evenly',
        alignItems: 'center',
        minHeight: '100vh',
        backgroundColor: '#FFDEE9',
        backgroundImage: 'linear-gradient(0deg, #FFDEE9 0%, #B5FFFC 100%)',
      }}
    >
      <div
        style={{
          width: 400,
          height: 400,
          padding: 0,
          borderRadius: '8px',
          backgroundImage: `url(${logo})`,
          backgroundSize: 'cover',
          backgroundPosition: 'center',
        }}
      ></div>

      <Box
        component="form"
        onSubmit={handleSubmit}
        sx={{
          width: 400,
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
          Login
        </Typography>
        {error && (
          <Alert severity="error" sx={{ mb: 2 }}>
            {error}
          </Alert>
        )}

        <TextField
          label="Email"
          type="email"
          variant="outlined"
          fullWidth
          margin="normal"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <TextField
          label="Password"
          type="password"
          variant="outlined"
          fullWidth
          margin="normal"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />

        <Button
          type="submit"
          variant="contained"
          color="primary"
          fullWidth
          sx={{ mt: 2, py: 1 }}
        >
          Login
        </Button>

        <Typography
          variant="body2"
          color="#1664C0"
          textAlign="center"
          sx={{ mt: 2, cursor: 'pointer' }}
        >
          Don't have an account?{' '}
          <Link to="/RegisterPage" style={{ textDecoration: 'none', color: '#1664C0' }}>
            Register here.
          </Link>
        </Typography>
      </Box>
    </Box>
  );
};
