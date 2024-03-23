import React from 'react';
import { Link, Outlet } from 'react-router-dom'; // Assuming you're using React Router
import './Navbar.css';
import { Fragment } from 'react';
 // You can define your styles in a separate CSS file

const Navbar = () => {
  return (
    <Fragment>
    <nav className="navbar">
      <div className="navbar-logo">
      <span style={{ fontWeight: 'bold' }}>EasySplit</span>
      </div>
      <ul className="navbar-links">
        <li>
          <Link to="/users">Users</Link>
        </li>
        <li>
          <Link to="/groups">Groups</Link>
        </li>
        <li>
          <Link to="/groupmembers">Group Members</Link>
        </li>
        <li>
          <Link to="/expenses">Expenses</Link>
        </li>
        <li>
          <Link to="/balances">Split Balance</Link>
        </li>
      </ul>
    </nav>
    <Outlet/>
    </Fragment>
  );
};

export default Navbar;
