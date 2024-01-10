import React, { useEffect } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-icons/font/bootstrap-icons.css'
import Sidebar from './Sidebar'
import Nav from './Navbar'
import { useState } from 'react'



function Dashboard(props) {
  const [toggle, setToggle] = useState(true)
  const Toggle = () => { setToggle(!toggle) }
  useEffect( () => {
    if(window.location.href!="http://localhost:3000/#")
      window.location.href="http://localhost:3000/#"
 }, []);
  return (
    <div className='container-fluid bg-secondary min-vh-100 '>
      <div className='row '>
        {toggle && <div className='col-4 col-md-2 bg-white vh-100 position-fixed'>
          <Sidebar logout={props.logout} />
        </div>}
        {toggle && <div className='col-4 col-md-2'></div>}
        <div className='col'>
          <div className='px-3'>
            <Nav Toggle={Toggle} />
            {props.children}
          </div>
        </div>
      </div>
    </div>
  )
}
export default Dashboard