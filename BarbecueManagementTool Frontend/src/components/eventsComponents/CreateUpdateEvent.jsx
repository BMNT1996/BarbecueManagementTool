import React, { useState, useEffect, useReducer } from "react";
import { jwtDecode } from 'jwt-decode'
import Cookies from 'js-cookie'
import axios from 'axios'
import { Store } from 'react-notifications-component';

export default props => {
    // If selectedEvent is available, use its values to set the eventSelected properties, if not use empty values
    const [eventSelected, setEventSelected] = useState(props.eventSelected != null ? {
        id: props.eventSelected.event.eventId,
        code: props.eventSelected.event.eventCode,
        name: props.eventSelected.event.name,
        date: props.eventSelected.event.date,
        hours: props.eventSelected.event.date,
        people: props.eventSelected.people,
        products: props.eventSelected.products
    } : {
        id: "",
        code: "",
        name: "",
        date: "",
        hours: "",
        people: [],
        products: []
    })
    const isOwner = props.eventSelected == null ? false : props.eventSelected.people.find(person => person.eventUserJunctionId.user.userId == jwtDecode(Cookies.get("token")).userId && person.isOwner) != null
    const [productList, setProductList] = useState([])
    const [addProduct, setAddProduct] = useState({
        product: "",
        quantity: ""
    })

    useEffect(() => {
        setEventSelected(props.eventSelected != null ? {
            id: props.eventSelected.event.eventId,
            code: props.eventSelected.event.eventCode,
            name: props.eventSelected.event.name,
            date: props.eventSelected.event.date,
            hours: props.eventSelected.event.date,
            people: props.eventSelected.people,
            products: props.eventSelected.products
        } : {
            id: "",
            code: "",
            name: "",
            date: "",
            hours: "",
            people: [],
            products: []
        })
        axios.get("http://localhost:4000/product/").then(resp => setProductList(resp.data))
    }, [props.eventSelected])

    const handlePeopleTable = () => {
        console.log(addProduct)
        return props.eventSelected.people.map(person =>
            <tr key={person.eventUserJunctionId.user.userId}>
                <td>{person.isOwner ? <b>(Owner) {person.eventUserJunctionId.user.username}</b> : person.eventUserJunctionId.user.username}</td>
                <td>{person.accepted ? "Aproved" : "Not Aproved"}</td>
                {isOwner && <td>
                    {acceptRejectButton(person)}
                </td>}
            </tr>
        )
    }

    const acceptRejectButton = (person) => {
        if (!person.isOwner) {
            if (!person.accepted)
                return (<button type="button" className="btn btn-success" onClick={() => acceptRejectButtonAction(person, true)}>Accept</button>)
            else
                return (<button type="button" className="btn btn-danger" onClick={() => acceptRejectButtonAction(person, false)}>Reject</button>)
        } else
            return
    }

    const acceptRejectButtonAction = (person, accept) => {
        const body = JSON.stringify({
            eventUserJunction: { ...person, accepted: accept }
        })
        axios.post("http://localhost:4000/participation/update", body, {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(() => props.refreshSelectedEvent())

    }

    const handleProductsTable = () => {
        return props.eventSelected.products.map(product =>
            <tr key={product.eventProductJunctionId.product.productId}>
                <td>{product.eventProductJunctionId.product.name}</td>
                <td>{product.eventProductJunctionId.product.productType}</td>
                <td>{product.quantity}</td>
            </tr>
        )
    }

    const handleCreateEvent = () => {
        const body = JSON.stringify({
            name: eventSelected.name,
            date: new Date(eventSelected.date + " " + eventSelected.hours),
            ownerId: jwtDecode(Cookies.get("token")).userId
        })
        if (eventSelected.name === "" || eventSelected.date === "" || eventSelected.hours === "") {
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
        else {
            const body = JSON.stringify({
                name: eventSelected.name,
                date: new Date(eventSelected.date + " " + eventSelected.hours + ":00"),
                ownerId: jwtDecode(Cookies.get("token")).userId
            })
            axios.post("http://localhost:4000/event/create", body, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(resp => {
                props.updateinfo()
            })
        }
    }

    const handleDropdown = () => {
        if(productList.length>0  && addProduct.product=="")
            setAddProduct({...addProduct, product:productList[0].name})
        return (
            <select className="form-control" name="products" id="products" onChange={e => { setAddProduct({ ...addProduct, product: e.target.value }) }}>
                {productList.map(product => (
                    <option value={product.name}>{product.name}</option>
                ))}
            </select>
        )
    }

    const handleAddProduct = () => {
        const productToAdd = productList.find(product => product.name == addProduct.product)
        if(productToAdd != null){
            const body = JSON.stringify(
                {
                event:props.eventSelected.event,
                product:productToAdd,
                quantity:parseFloat(addProduct.quantity),
                price:1,
                divisionType:0,
            })
            console.log(body)
            axios.post("http://localhost:4000/eventproduct/add", body, {
                headers: {
                    'Content-Type': 'application/json'
                }
            })
        }
    }

    return (
            <div>
                <h3 className='text-white fs-4 w-100'>Create/Update Event</h3>
                <div className="bg-white rounded mt-2 p-2">
                    <div>
                        <div className="d-flex justify-content-between">
                            <h4>Event information</h4>
                            <button className="btn btn-primary btn-m" onClick={() => { props.clearEventSelected() }}>New</button>
                        </div>
                        <div className="row g-3">
                            <div className="col-sm-4">
                                <label htmlFor="id" className="form-label">Id</label>
                                <input type="text" className="form-control" id="id" placeholder="Id" value={eventSelected.id} readOnly />
                            </div>

                            <div className="col-sm-8">
                                <label htmlFor="eventName" className="form-label">Event Name</label>
                                <input type="text" className="form-control" id="eventName" placeholder="Event Name" value={eventSelected.name} onChange={e => setEventSelected({ ...eventSelected, name: e.target.value })} required />
                            </div>

                            <div className="col-sm-4">
                                <label htmlFor="eventCode" className="form-label">Event Code</label>
                                <input type="text" className="form-control" id="eventCode" placeholder="Event Code" value={eventSelected.code} readOnly />
                            </div>

                            <div className="col-sm-8">
                                <label htmlFor="Date" className="form-label">Date</label>
                                <div className='D-flex row m-0'>
                                    <input type="date" className="form-control w-25" id="date" value={eventSelected.date} onChange={e => setEventSelected({ ...eventSelected, date: e.target.value })} required />
                                    <input type="time" className="form-control w-25" id="date" value={eventSelected.hours} onChange={e => setEventSelected({ ...eventSelected, hours: e.target.value })} required />
                                </div>
                            </div>
                        </div>
                        <hr />
                        {props.eventSelected != null && <div className="row g-3">
                            <h4>People</h4>
                            <table className="table caption-top bg-white rounded mt-0">
                                <thead>
                                    <tr>
                                        <th scope="col">Name</th>
                                        <th scope="col">Status</th>
                                        {isOwner && <th>Actions</th>}
                                    </tr>
                                </thead>
                                <tbody>
                                    {handlePeopleTable()}
                                </tbody>
                            </table>
                        </div>}
                        {props.eventSelected != null && <hr />}
                        {props.eventSelected != null && <div className="row g-3">
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
                                    {handleProductsTable()}
                                </tbody>
                            </table>
                            <div className="d-flex justify-content-around w-100 col-sm-4 mb-3">
                                <div className="d-flex flex-column ">
                                    <label htmlFor="id" className="form-label">Product</label>
                                    {handleDropdown()}
                                </div>
                                <div>
                                    <label htmlFor="id" className="form-label">Quantity</label>
                                    <input type="number" step=".1" required className="form-control" id="quantity" placeholder="Quantity" value={addProduct.quantity} onChange={e => setAddProduct({ ...addProduct, quantity: e.target.value })} />
                                </div>
                                <button className="w-25 btn btn-success btn-lg mt-2" onClick={() => handleAddProduct()}>Add</button>
                            </div>
                        </div>}
                        <button className="w-100 btn btn-primary btn-lg mt-2" onClick={() => handleCreateEvent()}>{props.eventSelected != null ? "Update" : "Create"}</button>
                    </div>
                </div>
            </div>
        )
    }