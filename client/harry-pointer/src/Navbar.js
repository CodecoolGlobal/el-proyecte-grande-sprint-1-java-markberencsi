import React from 'react';
import {
  MDBNavbar,
  MDBNavbarNav,
  MDBNavbarItem,
  MDBNavbarToggler,
  MDBContainer,
  MDBIcon
} from 'mdb-react-ui-kit';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Link} from 'react-router-dom';

export default function Navbar() {
  return (
    <header>
      <MDBNavbar expand='lg' light bgColor='white'>
        <MDBContainer fluid>
          <MDBNavbarToggler
            aria-controls='navbarExample01'
            aria-expanded='false'
            aria-label='Toggle navigation'
          >
            <MDBIcon fas icon='bars' />
          </MDBNavbarToggler>
          <div className='collapse navbar-collapse' id='navbarExample01'>
            <MDBNavbarNav right className='mb-2 mb-lg-0'>
              <MDBNavbarItem active>
                <Link to='/' className='nav-link'>Home</Link>
              </MDBNavbarItem>
              <MDBNavbarItem>
                <Link to='/students' className='nav-link'>Students</Link>
              </MDBNavbarItem>
              <MDBNavbarItem>
                <Link to='/teachers' className='nav-link'>Teachers</Link>
              </MDBNavbarItem>
              <MDBNavbarItem>
                <Link to='/houses' className='nav-link'>Houses</Link>
              </MDBNavbarItem>
            </MDBNavbarNav>
          </div>
        </MDBContainer>
      </MDBNavbar>
    </header>
  );
}

export const Heading = () => {
    return  <div className='p-5 text-center bg-dark'
    style={{ 
        margin: "40px 50px 0",
        borderRadius: "10px"
    }}>
                <h1 className='mb-3'>Welcome to Hogwarts School of Witchcraft and Wizardry!</h1>
                
                <a className='btn btn-primary' href='/' role='button'>
                    Become a wizard
                </a>
            </div>;
};
