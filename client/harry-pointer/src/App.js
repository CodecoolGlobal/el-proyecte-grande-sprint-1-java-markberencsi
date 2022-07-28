import './App.css';
import Navbar from './Navbar';
import{ Heading } from './Navbar';
import Houses from './houses/Houses'
import { Route, BrowserRouter, Routes, Outlet } from 'react-router-dom';
import {ProjectCardsFlip} from "./Teacher";
import {SignupForm} from "./Signup";
import {LoginForm} from "./Login";

import Students from "./Students";
import Leaderboard from './houses/Leaderboard';
import HouseDetail from './houses/HouseDetail';
import AuthProvider from './authentication/AuthProvider';
import RequiredAuth from './authentication/RequiredAuth';

function App() {
  return (
    <div className="App">
      <AuthProvider>
        <BrowserRouter>
          <Navbar />
          <Routes>
            <Route exact path='/' element={<Heading />} />
            <Route path='/' element={<RequiredAuth />} >
              <Route path='/houses' element={<Outlet />}>
                <Route index element={<Houses/>}/>
                <Route path=':name' element={<HouseDetail />}/>
              </Route>
              <Route path='/teachers' element={<ProjectCardsFlip/>}/>
              <Route path='/students' element={<Students />} />
              <Route path='/leaderboard' element={<Leaderboard />} />
            </Route>
            <Route path='/signup' element={<SignupForm />} />
            <Route path='/login' element={<LoginForm />} />
          </Routes>
        </BrowserRouter>
      </AuthProvider>
    </div>
  );
}

export default App;
