import React from 'react'
import DashNavbar from '../../../layout/DashNavbar'
import DashMenuBar from '../CustomerDashMenuBar'
import { Row, Col, Form, FormGroup, Label, Input } from 'reactstrap'
import CustomerFunctions from '../../../../Axios/CustomerAxios'
import { useHistory } from 'react-router-dom';

const NewEnquiry = () => {

  const history = useHistory()

  
 const addEnquiry =(e) =>{
 
  e.preventDefault()
  console.log('hiiii')
   const subject=e.target.elements.select.value
   const desc=e.target.elements.description.value

   const customer=sessionStorage.getItem('user')
   const temp=JSON.parse(customer)
   
    const body={
      subject:subject,
      description:desc,
      custId:temp.id,
      customerName:temp.name
    }
   //console.log(subject,desc)
    CustomerFunctions.addNewEnquiry(body).then((res)=>{
      console.log(res.data)
      history.push('customer-dash')
    })

 }

 
  return (
    <div>
      <DashNavbar />
      <div className="py-5">
        <Row>
          <Col md={2}>
            <DashMenuBar />
          </Col>
          <Col md={10}>
            <h4 className="text-center">Add New Enquiry Here!</h4>
            <br />
            <Form onSubmit={addEnquiry}>
              <FormGroup row>
                <Label htmlFor="exampleSelect" sm={2}>
                  Select Subject
                </Label>
                <Col sm={8}>
                  <Input type="select" name="select" id="exampleSelect">
                    <option>Vehicle Related Enquiry</option>
                    <option>Service Related Enquiry</option>
                    <option>Parts Related Enquiry</option>
                    <option>Price Related Enquiry</option>
                    <option>Others</option>
                  </Input>
                </Col>
              </FormGroup>

              <FormGroup row>
                <Label htmlFor="exampleText" sm={2}>
                  Description
                </Label>
                <Col sm={8}>
                  <Input type="textarea" name="description" id="exampleText" />
                </Col>
                <hr></hr>
                <button type="submit" className="btn btn-danger btn-block">
               Add Enquiry
              </button>
              </FormGroup>
            </Form>
          </Col>
        </Row>
      </div>
    </div>
  )
}

export default NewEnquiry
