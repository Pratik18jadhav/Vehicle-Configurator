import React from "react";
import { Container, Grid, TextField, Button, Typography, Box } from "@mui/material";

const Footer2 = () => {
  const year = new Date().getFullYear();

  return (
    <Box
      component="footer"
      sx={{
        backgroundColor: "#333",
        color: "#fff",
        padding: "40px 20px",
        textAlign: "center",
        width: "100%",
        marginTop: "auto",
      }}
    >
      <Container>
        <Grid container spacing={4} justifyContent="center">
          {/* About Section */}
          <Grid item xs={12} md={4}>
            <Typography variant="h5" gutterBottom>
              About Us
            </Typography>
            <Typography variant="body2">
              Lorem ipsum dolor sit amet consectetur adipisicing elit.
              Consequuntur, distinctio, itaque reiciendis ab cupiditate harum ex
              quam veniam, omnis expedita animi quibusdam obcaecati mollitia?
              Delectus et ad illo recusandae temporibus?
            </Typography>
          </Grid>

          {/* Quick Links */}
          <Grid item xs={12} md={2}>
            <Typography variant="h5" gutterBottom>
              Quick Links
            </Typography>
            <Typography variant="body2">
              <a href="/home" style={{ color: "#fff", textDecoration: "none" }}>
                Home
              </a>
            </Typography>
            <Typography variant="body2">
              <a href="/about" style={{ color: "#fff", textDecoration: "none" }}>
                About Us
              </a>
            </Typography>
            <Typography variant="body2">
              <a href="/services" style={{ color: "#fff", textDecoration: "none" }}>
                Services
              </a>
            </Typography>
            <Typography variant="body2">
              <a href="/contact" style={{ color: "#fff", textDecoration: "none" }}>
                Contact
              </a>
            </Typography>
          </Grid>

          {/* Contact Information */}
          <Grid item xs={12} md={3}>
            <Typography variant="h5" gutterBottom>
              Head Office
            </Typography>
            <Typography variant="body2">47, Shajapur, Madhya Pradesh</Typography>
            <Typography variant="body2">Phone: +91 6263254158</Typography>
            <Typography variant="body2">Email: balramgothi9@gmail.com</Typography>
            <Typography variant="body2">Office Time: 10am - 7pm</Typography>
          </Grid>

          {/* Newsletter */}
          <Grid item xs={12} md={3}>
            <Typography variant="h5" gutterBottom>
              Newsletter
            </Typography>
            <Typography variant="body2">Subscribe to our newsletter</Typography>
            <Box display="flex" mt={2}>
              <TextField
                variant="outlined"
                size="small"
                placeholder="Enter your email"
                sx={{ flexGrow: 1, backgroundColor: "#fff", borderRadius: "4px" }}
              />
              <Button
                variant="contained"
                sx={{
                  backgroundColor: "#ff9800",
                  color: "#fff",
                  ml: 1,
                  "&:hover": { backgroundColor: "#e68900" },
                }}
              >
                Subscribe
              </Button>
            </Box>
          </Grid>
        </Grid>

        {/* Footer Bottom */}
        <Box mt={4} pt={2} borderTop="1px solid #555">
          <Typography variant="body2">
            &copy; {year} Developed by Lemon Chushi. All rights reserved.
          </Typography>
        </Box>
      </Container>
    </Box>
  );
};

export default Footer2;
