import React from 'react'
import { Link, NavLink } from 'react-router-dom'
import { Button } from 'reactstrap'




const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-light" style={{backgroundColor:"#e3f2fd"}}>
  <div className="container-fluid">
  <a className="navbar-brand" href="/">
      <div className="logo-image">
            <img src="/images/images.jpg" className="img-fluid"/>
      </div>
</a>
    <a className="navbar-brand" href="/">Vehicle Service Management</a>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarSupportedContent">
      <ul className="navbar-nav me-auto mb-2 mb-lg-0">
        
        <li className="nav-item">
              <NavLink className="nav-link" exact to="/">
              <Button outline color="success">
                  Home
                </Button>
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink className="nav-link" exact to="/customer">
              <Button outline color="info">
                  New Customer
                </Button>
                
              </NavLink>
            </li>

            <li className="nav-item">
              <NavLink className="nav-link" exact to="/service-advisor">
                
              <Button outline color="info">
              New Service Advisor
                </Button>
                
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink className="nav-link" exact to="/mechanic">
                
              <Button outline color="info">
              New Mechanic
                </Button>
                
              </NavLink>
            </li>


  <li className="nav-item">
              <NavLink className="nav-link" exact to="/login">
                <Button outline color="danger">
                  Log-In
                </Button>
              </NavLink>
            </li>

           
            <li className="nav-item">
              <NavLink className="nav-link" exact to="/about-us">
              <Button outline color="secondary">
              About Us
                </Button>
                
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink className="nav-link" exact to="/contact-us">
              <Button outline color="secondary">
              Contact Us
                </Button>
                
              </NavLink>
            </li>
         
      </ul>

      
      
    </div>
  </div>
</nav>
  )
}

export default Navbar
