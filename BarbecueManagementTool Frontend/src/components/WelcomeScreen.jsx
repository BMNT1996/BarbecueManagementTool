import React from "react"
import 'bootstrap/dist/css/bootstrap.min.css';
import './WelcomeScreen.css';

export default props =>
    <div className="bodyContainer d-flex align-items-center h-100 text-center text-bg-dark">
        <div className="cover-container d-flex mw-100 p-3 mx-auto flex-column">
            <main className="px-3">
                <h1 className="title">Barbecue Management Tool</h1>
                <p className="subtitle">Welcome to a new tool to manage your barbecues</p>
                <p className="subtitle">
                    <a href="#login" className="btn btn-lg btn-light fw-bold border-white bg-white">Login / Register</a>
                </p>
            </main>
        </div>
    </div>