// src/components/Navbar.js
import React from 'react';
import '../CSS/Navbar.css';

const Navbar = () => {
    return (
        <header className="header-navbar">
            <nav className="navbar">
                {/* Company Name */}
                <div className="navbar-brand">
                    <h2 style={{color : "white"}}>Hire & Go</h2>
                </div>

                <div className="navbar-left">
                    <a href="/">Home</a>
                    <a href="/modify-cancel">Modify/Cancel Booking</a>
                    <a href="/membership">Membership Registration</a>
                    <a href="/about">About us</a>
                    <a href="/customer-care">Customer Care</a>
                </div>

                <div className="navbar-right">
                    <a href="/login">Login</a>
                    <a href="/login">Staff Login</a>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;
