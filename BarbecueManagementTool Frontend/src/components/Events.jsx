import React, { useEffect, useState } from 'react'
import { jwtDecode } from 'jwt-decode'
import Cookies from 'js-cookie'
import axios from 'axios'
import { Store } from 'react-notifications-component';
import Moment from 'moment';
import './Style.css'

function Events() {

    const [info, setInfo] = useState({
        "numberOfEvents" : 0,
        "productsRequested" : 0.0,
        "totalExpenses" : 0.0,
        "events" : [ ],
        "eventsPending" : []
      })
    const [code, setCode] = useState("")
    const [eventSelected, setEventSelected] = useState()
    const [createEventFields, setCreateEventFields] = useState({
        id: "",
        code: "",
        name: "",
        date: "",
        hours: ""
    })


    useEffect(() => {
        updateinfo()
    }, []);

    const updateinfo = () => {
        axios.post("http://localhost:4000/event/getdashboardinformation", JSON.stringify({
            username: jwtDecode(Cookies.get("token")).sub
        }), {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(resp => {
            if(resp.data != null)
                setInfo(resp.data)
        })
    }

    const handleEventsTable = () => {
        return info.events.map(event =>
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
        axios.post("http://localhost:4000/event/geteventbycode", JSON.stringify({
            code: code
          }), {
            headers: {
              'Content-Type': 'application/json'
            }
          }).then(eventResponse => updateEventSelected(eventResponse.data))
    )

    const updateEventSelected = data => {
        setEventSelected(data)
        const date = data.event.date
        setCreateEventFields({
            id: data.event.eventId,
            code: data.event.eventCode,
            name:data.event.name,
            date:data.event.date,
            hours:data.event.date,
        })
    }

    const handlePendingEventsTable = () => {
        return info.eventsPending.map(event => (
            <tr key={event.id}>
                <th scope="row">{event.code}</th>
                <td>{event.name}</td>
                <td>{Moment(new Date(event.date)).format("DD/MM/YYYY kk:mm")}</td>
            </tr>
        ))
    }

    const handleJoinEvent = () => {
        const eventId= 1
        axios.post("http://localhost:4000/event/geteventbycode", JSON.stringify({
            code: code
          }), {
            headers: {
              'Content-Type': 'application/json'
            }
          }).then(eventResponse => {
            if(eventResponse.data.event != null){
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
                      updateinfo()
                    })
            } else {
                console.log("Event Not Found")
                return null
            }
          })
        return true
    }

    const handleCreateEvent = () => {
        const body = JSON.stringify({
            name: createEventFields.name,
            date: new Date(createEventFields.date + " " + createEventFields.hours),
            ownerId: jwtDecode(Cookies.get("token")).userId
        })
        if(createEventFields.name === "" || createEventFields.date === "" || createEventFields.hours === ""){
            Store.addNotification({
                title: "Create event Failed!",
                message: "Fill event name and date to proceed",
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
        else{
        const body = JSON.stringify({
            name: createEventFields.name,
            date: new Date(createEventFields.date + " " + createEventFields.hours + ":00"),
            ownerId: jwtDecode(Cookies.get("token")).userId
        })
        axios.post("http://localhost:4000/event/create", body, {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(resp => {
            updateinfo()
        })
    }
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
            {info.eventsPending.length!=0 && <div>
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
                    {handlePendingEventsTable()}
                </tbody>
            </table>
            </div>}
            <h3 className='text-white fs-4 w-100'>Join Event</h3>
            <div className="bg-white rounded mt-2 mb-4 p-2">
                <div className="col-sm-1">
                    <label className="form-label">Code</label>
                    <input type="text" className="form-control" placeholder="Code" value={code} onChange={(e) => setCode(e.target.value)}/>
                </div>
                <button type="button" className="btn btn-primary btn-lg mt-2" onClick={handleJoinEvent}>Join</button>
            </div>
            <h3 className='text-white fs-4 w-100'>Create/Update Event</h3>
            <div className="bg-white rounded mt-2 p-2">
                <div>
                        <div className="d-flex justify-content-between">
                            <h4>Event information</h4>
                            <button className="btn btn-primary btn-m" onClick={() => {setEventSelected(null); setCreateEventFields({id:"", code: "", name: "", date: "", hours: ""})}}>New</button>
                        </div>
                        <div className="row g-3">
                            <div className="col-sm-4">
                                <label htmlFor="id" className="form-label">Id</label>
                                <input type="text" className="form-control" id="id" placeholder="Id" value={createEventFields.id} readOnly />
                            </div>

                            <div className="col-sm-8">
                                <label htmlFor="eventName" className="form-label">Event Name</label>
                                <input type="text" className="form-control" id="eventName" placeholder="Event Name" value={createEventFields.name} onChange={e => setCreateEventFields({ ...createEventFields, name: e.target.value})} required />
                            </div>

                            <div className="col-sm-4">
                                <label htmlFor="eventCode" className="form-label">Event Code</label>
                                <input type="text" className="form-control" id="eventCode" placeholder="Event Code" value={createEventFields.code} readOnly />
                            </div>

                            <div className="col-sm-8">
                                <label htmlFor="Date" className="form-label">Date</label>
                                <div className='D-flex row m-0'>
                                <input type="date" className="form-control w-25" id="date" value={createEventFields.date} onChange={e => setCreateEventFields({ ...createEventFields, date: e.target.value})} required />
                                <input type="time" className="form-control w-25" id="date" value={createEventFields.hours} onChange={e => setCreateEventFields({ ...createEventFields, hours: e.target.value})} required /> 
                                </div>
                              </div>
                        </div>
                        <hr />
                        {eventSelected !=null && <div className="row g-3">
                            <h4>People</h4>
                            <table className="table caption-top bg-white rounded mt-0">
                                <thead>
                                    <tr>
                                        <th scope="col">Name</th>
                                        <th scope="col">Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Antonio</td>
                                        <td>Aproved</td>
                                    </tr>
                                    <tr>
                                        <td>Maria</td>
                                        <td>Not Aproved</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>}
                        {eventSelected !=null && <hr />}
                        {eventSelected !=null && <div className="row g-3">
                            <h4>Products</h4>
                            <table className="table caption-top bg-white rounded mt-0">
                                <thead>
                                    <tr>
                                        <th scope="col">Product Name</th>
                                        <th scope="col">Product Type</th>
                                        <th scope="col">Quatity</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Coca-Cola</td>
                                        <td>Drink</td>
                                        <td>5</td>
                                    </tr>
                                    <tr>
                                        <td>Cow</td>
                                        <td>Food</td>
                                        <td>3</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>}
                        <button className="w-100 btn btn-primary btn-lg mt-2" onClick={()=>handleCreateEvent()}>{eventSelected !=null ? "Update" : "Create"}</button>
                </div>
            </div>
        </div>
    )
}
export default Events