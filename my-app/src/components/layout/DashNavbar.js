import React from 'react'
import { Link, NavLink } from 'react-router-dom'
import { Button } from 'reactstrap'

const DashNavbar = () => {

  const onLogout=()=>{
    sessionStorage.removeItem('user')
  }
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light" style={{backgroundColor:"#e3f2fd"}}>
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
              <NavLink className="nav-link" exact to="/myprofile">
                <Button outline color="danger">
                  My Profile
                </Button>
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink className="nav-link" exact to="/">
                <Button outline color="danger" onClick={onLogout}>
                  Logout
                </Button>
              </NavLink>
            </li> 
         
      </ul>
      
    </div>
  </div>
</nav>
  )
}

export default DashNavbar
{/* <nav class="navbar navbar-expand-md navbar-light bg-light">
      <div className="container">
        <Link className="navbar-brand"  style={{color:"#eb345b"}}href="/">
          Vehicle Servicing Management
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" style={{ marginLeft: 620 }}>
          <ul className="navbar-nav mr-auto"></ul>
          <ul className="navbar-nav mr-auto justify-content-end">
            <li className="nav-item">
              <NavLink className="nav-link" exact to="/myprofile">
                <Button outline color="danger">
                  My Profile
                </Button>
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink className="nav-link" exact to="/">
                <Button outline color="danger" onClick={onLogout}>
                  Logout
                </Button>
              </NavLink>
            </li>
          </ul>
        </div>
      </div>
    </nav> */}