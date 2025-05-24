import './App.css';
import Navbar from './components/Navbar';
import Users from './components/Users';
import Groups from './components/Groups';
import { Routes, Route } from 'react-router-dom';
import GroupMembers from './components/GroupMembers';
import Expenses from './components/Expenses';
import Balances from './components/Balances';
function App() {
  return (
    <div className="App">
      <Routes>
        <Route path= "/" element={<Navbar/>}>
          <Route path='users' element={<Users/>}></Route>
          <Route path='groups' element={<Groups/>}></Route>
          <Route path='groupmembers' element={<GroupMembers/>}></Route>
          <Route path='expenses' element={<Expenses/>}></Route>
          <Route path='balances' element={<Balances/>}></Route>
        </Route>
      </Routes>
    </div>
  );
}

export default App;
