import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Users = () => {
  const [username, setUsername] = useState('');
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/v1/users');
      setUsers(response.data);
    } catch (error) {
      console.error('Error fetching users:', error);
      // Handle error, e.g., display error message to the user
    }
  };

  const handleInputChange = (e) => {
    setUsername(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post('http://localhost:8080/api/v1/users', {
        username: username
      });

      console.log('User added:', response.data);
      setUsername(''); // Clear input field after successful submission
      fetchUsers(); // Fetch users again to update the list after adding a new user
    } catch (error) {
      console.error('Error adding user:', error);
      // Handle error, e.g., display error message to the user
    }
  };

  return (
    <div>
      <h2>Add New User</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="username">Username:</label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={handleInputChange}
            required
          />
        </div>
        <button type="submit">Add User</button>
      </form>

      <h2>Users</h2>
      <ul>
        {users.map(user => (
          <li key={user.id}>{user.username}</li>
        ))}
      </ul>
    </div>
  );
};

export default Users;
