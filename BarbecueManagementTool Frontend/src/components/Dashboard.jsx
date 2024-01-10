import React, { useEffect, useState } from 'react'
import { jwtDecode } from 'jwt-decode'
import axios from 'axios'
import './Style.css'
import Cookies from 'js-cookie'
import Moment from 'moment'

function Home() {

    const [info, setInfo] = useState({
        numberOfEvents: 1,
        productsRequested: 0,
        totalExpenses: 0.0,
        events: []
    })

    useEffect(() => {
        const body = JSON.stringify({
            username: jwtDecode(Cookies.get("token")).sub
        })
        axios.post("http://localhost:4000/event/getdashboardinformation", body, {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(resp => {
            if(resp.data != null)
                setInfo(resp.data)
        })
    }, []);

    const handleEventsTable = () => {
        return info.events.map(event => (
            <tr key={event.id}>
                <th scope="row">{event.code}</th>
                <td>{event.name}</td>
                <td>{Moment(new Date(event.date)).format("DD/MM/YYYY kk:mm")}</td>
                <td>{event.expenses}€</td>
                <td>{event.status}</td>
            </tr>
        ))
    }

    return (
        <div>
            <div className='container-fluid'>
                <div className='row g-3 my-2'>
                    <div className='col-md-3 p-1'>
                        <div className='p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded'>
                            <div>
                                <h3 className='fs-2'>{info.numberOfEvents}</h3>
                                <p className='fs-5'>Events</p>
                            </div>
                            <i className='bi bi-table p-3 fs-1'></i>
                        </div>
                    </div>
                    <div className='col-md-3 p-1'>
                        <div className='p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded'>
                            <div>
                                <h3 className='fs-2'>{info.productsRequested}</h3>
                                <p className='fs-5'>Products Requested</p>
                            </div>
                            <i className='bi bi-cup-straw p-3 fs-1'></i>
                        </div>
                    </div>
                    <div className='col-md-3 p-1'>
                        <div className='p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded'>
                            <div>
                                <h3 className='fs-2'>{info.totalExpenses}€</h3>
                                <p className='fs-5'>Total Expenses</p>
                            </div>
                            <i className='bi bi-currency-dollar p-3 fs-1'></i>
                        </div>
                    </div>
                </div>
            </div>
            <table className="table caption-top bg-white rounded mt-2">
                <caption className='text-white fs-4'>Recent Events</caption>
                <thead>
                    <tr>
                        <th scope="col">Code</th>
                        <th scope="col">Event Name</th>
                        <th scope="col">Date</th>
                        <th scope="col">Expenses</th>
                        <th scope="col">Paid</th>
                    </tr>
                </thead>
                <tbody>
                    {handleEventsTable()}
                </tbody>
            </table>
        </div>
    )
}
export default Home