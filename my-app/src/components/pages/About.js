import React from 'react';
import NavBar from '../layout/Navbar'
const About = () => {

  return (
    <div>
    
    <NavBar/>
    <div className="container">
      <div className="py-4 text-black blocktext">
        <h1>About Us</h1>
        <br></br>
        <p>
          <strong>
            <h2>

          This is website for vehicle service management which can be used by any service station for easily managing all the work.
          With the rapid advancement of the mobility sector, the trend to mobility as a service, the growth of the shared economy
          and the need for sustainable, eco-friendly solutions, We are providing different functionalities for different roles in 
          our project.This will help in the creation of tighter relationships with customers and delivering of a high level of service
          and support
            </h2>
          </strong>
        </p>

        <br></br> <br></br>
        <p>
          <h3>

          Group Name:- Group:113 My Team Details :- Title - Vehicle Servicing
          Management System
          </h3>
        </p>

        <p><h3>Member 1 - Jyotesh Pateria jyoteshpateria@gmail.com</h3></p>
        <p><h3>Member 2 - Akshay Dalvi -dalviaksh001@gmail.com</h3></p>
        <p><h3>Member 3 - Shreyansh Jain Shreyansh@gmail.com</h3></p>
        
      </div>
    </div>
    </div>
  );
};

export default About;
