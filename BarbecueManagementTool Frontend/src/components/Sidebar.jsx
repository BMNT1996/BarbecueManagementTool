import React from 'react'
import { useNavigate } from 'react-router-dom';
import './Style.css'
import mainLogo from '../assets/icon.png'
import Cookies from 'js-cookie'

export default props => {

    let navigate = useNavigate()
    
    const handleLogout = () => {
        Cookies.remove("token")
        window.location.reload(false);
    }

    return (
    <div className='bg-white sidebar p-2'>
            <div className='m-2'>
                <div className='d-flex justify-content-center'>
                    <a href="#"><img className='icon' href="#"></img></a>
                </div>
            </div>
            <hr className='text-dark' />
            <div className='list-group list-group-flush'>
                <a className='d-flex flex-column align-items-center list-group-item py-2' href="#">
                    <i className='bi bi-speedometer2 fs-5'></i>
                    <span>Dashboard</span>
                </a>
                <a className='d-flex flex-column align-items-center list-group-item py-2' href="#events">
                    <i className='bi bi-table fs-5'></i>
                    <span>Events</span>
                </a>
                <a className='d-flex flex-column align-items-center list-group-item py-2' href="#products">
                    <i className='bi bi-cup-straw fs-5'></i>
                    <span >Products</span>
                </a>
                <a className='d-flex flex-column align-items-center list-group-item py-2' onClick={handleLogout} href="#">
                    <i className='bi bi-power fs-5'></i>
                    <span >Logout</span>
                </a>
            </div>
        </div>
    )
}