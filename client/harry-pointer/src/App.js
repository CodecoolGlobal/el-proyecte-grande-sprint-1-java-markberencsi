import './App.css';
import Navbar from './Navbar';
import{ Heading } from './Navbar';
import Houses from './houses/Houses'
import { fetchGetAll } from './houses/api/houseApi';
import { Route, BrowserRouter, Routes, Outlet } from 'react-router-dom';
import {ProjectCardsFlip} from "./Teacher";

import Students from "./Students";
import Leaderboard from './houses/Leaderboard';
import HouseDetail from './houses/HouseDetail';

function App() {
  fetchGetAll();
  return (
    <div className="App">
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route exact path='/' element={<Heading />} />
          <Route path='/houses' element={<Outlet />}>
            <Route index element={<Houses/>}/>
            <Route path=':name' element={<HouseDetail />}/>
          </Route>
          <Route path='/teachers' element={<ProjectCardsFlip/>}/>
          <Route path='/students' element={<Students />} />
          <Route path='/leaderboard' element={<Leaderboard />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
