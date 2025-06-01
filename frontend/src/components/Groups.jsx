import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Groups = () => {
  const [group_name, setGroupName] = useState('');
  const [groups, setGroups] = useState([]);

  useEffect(() => {
    fetchGroups();
  }, []);

  const fetchGroups = async () => {
    try {
      const response = await axios.get('http://backend.easysplit.local/api/v1/groups');
      setGroups(response.data);
    } catch (error) {
      console.error('Error fetching groups:', error);
      // Handle error, e.g., display error message to the user
    }
  };

  const handleInputChange = (e) => {
    setGroupName(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post('http://backend.easysplit.local/api/v1/groups', {
        groupName: group_name
      });

      console.log('Group added:', response.data);
      setGroupName(''); // Clear input field after successful submission
      fetchGroups(); // Fetch groups again to update the list after adding a new group
    } catch (error) {
      console.error('Error adding group:', error);
      // Handle error, e.g., display error message to the user
    }
  };

  return (
    <div>
      <h2>Add New Group</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="groupName">Group Name:</label>
          <input
            type="text"
            id="groupName"
            value={group_name}
            onChange={handleInputChange}
            required
          />
        </div>
        <button type="submit">Add Group</button>
      </form>

      <h2>Groups</h2>
      <ul>
        {groups.map(group => (
          <li key={group.id}>{group.groupName}</li>
        ))}
      </ul>
    </div>
  );
};

export default Groups;
