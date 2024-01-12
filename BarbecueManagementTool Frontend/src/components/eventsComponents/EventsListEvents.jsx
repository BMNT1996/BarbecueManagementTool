import React, { useEffect, useState } from 'react'
import { jwtDecode } from 'jwt-decode'
import Cookies from 'js-cookie'
import axios from 'axios'
import Moment from 'moment';

export default props => {

    const handleEventsTable = () => {
        return props.info.events.map(event =>
            <tr key={event.id} onClick={() => handleRowClicked(event.code)}>
                <th scope="row">{event.code}</th>
                <td>{event.name}</td>
                <td>{Moment(new Date(event.date)).format("DD/MM/YYYY kk:mm")}</td>
                <td>{event.expenses}€</td>
                <td>{event.status}</td>
            </tr>
        )
    }

    const handleRowClicked = code => (
        axios.post("http://localhost:4000/event/geteventpeopleandproductsbyeventcode", JSON.stringify({
            code: code
        }), {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(eventResponse => props.setEventSelected(eventResponse.data))
    )

    const handlePendingEventsTable = () => {
        return props.info.eventsPending.map(event => (
            <tr key={event.id}>
                <th scope="row">{event.code}</th>
                <td>{event.name}</td>
                <td>{Moment(new Date(event.date)).format("DD/MM/YYYY kk:mm")}</td>
            </tr>
        ))
    }

    return (
        <div>
            <h3 className='text-white fs-4 w-100'>List of Events</h3>
            <table className="table caption-top bg-white rounded mt-2">
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
            {props.info.eventsPending.length != 0 && <div>
                <h3 className='text-white fs-4 w-100'>List of Events Pending</h3>
                <table className="table caption-top bg-white rounded mt-2">
                    <thead>
                        <tr>
                            <th scope="col">Code</th>
                            <th scope="col">Event Name</th>
                            <th scope="col">Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        {handlePendingEventsTable(createEventFields.people)}
                    </tbody>
                </table>
            </div>}
        </div>
    )
}