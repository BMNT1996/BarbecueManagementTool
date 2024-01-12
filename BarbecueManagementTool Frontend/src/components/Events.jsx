import React, { useEffect, useState } from 'react'
import { jwtDecode } from 'jwt-decode'
import Cookies from 'js-cookie'
import axios from 'axios'
import CreateUpdateEvent from './eventsComponents/CreateUpdateEvent';
import JoinEvent from './eventsComponents/JoinEvent';
import EventsListEvents from './eventsComponents/EventsListEvents';

function Events() {

    const [info, setInfo] = useState({
        "numberOfEvents": 0,
        "productsRequested": 0.0,
        "totalExpenses": 0.0,
        "events": [],
        "eventsPending": []
    })
    const [eventSelected, setEventSelected] = useState()

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
            if (resp.data != null)
                setInfo(resp.data)
        })
    }

    const refreshSelectedEvent = () => {
        if(eventSelected != null){
            axios.post("http://localhost:4000/event/geteventpeopleandproductsbyeventcode", JSON.stringify({
                code: eventSelected.event.eventCode
            }), {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(eventResponse => setEventSelected(eventResponse.data))
        }
    }

    const clearEventSelected = () =>{
        setEventSelected(null)
    }

    const handleCreateUpdateEvent = () => {
        return(
            <CreateUpdateEvent 
                eventSelected={eventSelected} 
                clearEventSelected= {clearEventSelected} 
                updateinfo={updateinfo}
                refreshSelectedEvent={refreshSelectedEvent}/>
        )
    } 

    return (
        <div>
            <EventsListEvents info={info} setEventSelected={setEventSelected}/>
            <JoinEvent updateinfo={updateinfo}/>
            {handleCreateUpdateEvent()}
        </div>
    )
}
export default Events