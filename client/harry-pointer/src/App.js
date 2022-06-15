import './App.css';
import Navbar from './Navbar';
import{ Heading } from './Navbar';
import background from './hogwarts.jpg'
import Houses from './houses/Houses'
import { fetchGetAll } from './houses/api/houseApi';
import { Route, BrowserRouter, Routes } from 'react-router-dom';
import {ProjectCardsFlip, TeacherList} from "./Teacher";

import Students from "./Students";
import api from "./api";

function App() {
  fetchGetAll();
  return (
    <div className="App">
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route exact path='/' element={<Heading />} />
          <Route path='/houses' element={<Houses />} />
          <Route path='/teachers' element={<ProjectCardsFlip/>}/>
            <Route path='/students' element={<Students />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
