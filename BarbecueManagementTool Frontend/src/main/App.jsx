import React, { useState } from "react"
import "./App.css"
import { HashRouter, Routes, Route } from "react-router-dom"
import { ReactNotifications } from 'react-notifications-component'
import Cookies from "js-cookie"

import Main from '../components/Main.jsx'
import WelcomeScreen from '../components/WelcomeScreen.jsx'
import Login from '../components/Login.jsx'
import Home from '../components/Dashboard.jsx'
import Events from "../components/Events.jsx"
import Products from "../components/Products.jsx"

import 'react-notifications-component/dist/theme.css'

export default props => {
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    function login() {
        setIsLoggedIn(true)
    }

    function logout() {
        setIsLoggedIn(false)
    }

    return (
        <HashRouter>
            <div className="app">
                <ReactNotifications />
                <Routes>
                    <Route exact path="/" element={Cookies.get('token')!=null && Cookies.get('token')!="" ? <Main logout={logout}><Home /></Main> : <WelcomeScreen />} />
                    <Route exact path="/login" element={Cookies.get('token')!=null && Cookies.get('token')!="" ? <Main logout={logout}><Home /></Main> : <Login login={login}/>} />
                    <Route exact path="/Main" element={Cookies.get('token')!=null && Cookies.get('token')!="" ? <Main logout={logout}><Home /></Main> : <WelcomeScreen />} />
                    <Route exact path="/events" element={<Main logout={logout}><Events /></Main>} />
                    <Route exact path="/products" element={<Main logout={logout}><Products /></Main>} />
                    <Route path="*" element={Cookies.get('token')!=null && Cookies.get('token')!="" ? <Main logout={logout}><WelcomeScreen /></Main> : <WelcomeScreen />} />
                </Routes>
            </div>
        </HashRouter>
    )
}

