import React from "react";
import { CssBaseline, Container } from "@mui/material";
import Navbar from "../Components/Navbar"; 
import Footer2 from "./Footer2";
import ReservationForm from "./ReservationForm";
import bg from "../Content/HeroContent2.jpg"

const Abhishek2 = () => {
    return (
        <div
        style={{
            backgroundImage: `url(${bg})`,
            backgroundSize: "cover", // Ensures the image covers the entire div
            backgroundPosition: "center", // Centers the image
            backgroundRepeat: "no-repeat", // Prevents repeating
            height: "100vh", // Ensures it fills the viewport
          }}
        >
          <CssBaseline />
          <Navbar />
          <Container sx={{ flex: "1 0 auto", mt: 8, mb: 4 }}> {/* Push content to take max space */}
            <ReservationForm />
          </Container>
          <Footer2 style={{ flexShrink: 0 }} /> {/* Prevent footer from overlapping */}
        </div>
      );
    };

export default Abhishek2;
