import React, { useState } from 'react'
import { jwtDecode } from 'jwt-decode'
import Cookies from 'js-cookie'
import axios from 'axios'
import { Store } from 'react-notifications-component';

export default props => {
    const [code, setCode] = useState("")

    const handleJoinEvent = () => {
        const eventId = 1
        axios.post("http://localhost:4000/event/geteventbycode", JSON.stringify({
            code: code
        }), {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(eventResponse => {
            if (eventResponse.data.event != null) {
                axios.post("http://localhost:4000/participation/add", JSON.stringify({
                    eventId: eventResponse.data.event.eventId,
                    userId: jwtDecode(Cookies.get("token")).userId,
                    accepted: false
                }), {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                    .then(resp => {
                        props.updateinfo()
                    })
            } else {
                Store.addNotification({
                    title: "Join event Failed!",
                    message: "Event not found",
                    type: "danger",
                    insert: "top",
                    container: "top-right",
                    animationIn: ["animate__animated", "animate__fadeIn"],
                    animationOut: ["animate__animated", "animate__fadeOut"],
                    dismiss: {
                        duration: 2000,
                        onScreen: true
                    }
                })
            }
        })
        return true
    }

    return (
        <div>
            <h3 className='text-white fs-4 w-100'>Join Event</h3>
            <div className="bg-white rounded mt-2 mb-4 p-2">
                <div className="col-sm-1">
                    <label className="form-label">Code</label>
                    <input type="text" className="form-control" placeholder="Code" value={code} onChange={(e) => setCode(e.target.value)} />
                </div>
                <button type="button" className="btn btn-primary btn-lg mt-2" onClick={handleJoinEvent}>Join</button>
            </div>
        </div>
    )
}