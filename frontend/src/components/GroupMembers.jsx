import React, { useState, useEffect } from 'react';
import axios from 'axios';

const GroupMembers = () => {
  const [userId, setUserId] = useState('');
  const [groupId, setGroupId] = useState('');
  const [users, setUsers] = useState([]);
  const [groups, setGroups] = useState([]);
  const [groupMembers, setGroupMembers] = useState([]);

  useEffect(() => {
    fetchUsers();
    fetchGroups();
    fetchGroupMembers();
  }, []);

  const fetchUsers = async () => {
    try {
      const response = await axios.get('http://frontend.easysplit.local/api/v1/users');
      setUsers(response.data);
    } catch (error) {
      console.error('Error fetching users:', error);
      // Handle error
    }
  };

  const fetchGroups = async () => {
    try {
      const response = await axios.get('http://frontend.easysplit.local/api/v1/groups');
      setGroups(response.data);
    } catch (error) {
      console.error('Error fetching groups:', error);
      // Handle error
    }
  };

  const fetchGroupMembers = async () => {
    try {
      const response = await axios.get('http://frontend.easysplit.local/api/v1/groupmembers');
      setGroupMembers(response.data);
    } catch (error) {
      console.error('Error fetching group members:', error);
      // Handle error
    }
  };

  const handleUserChange = (e) => {
    setUserId(e.target.value);
  };

  const handleGroupChange = (e) => {
    setGroupId(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await axios.post('http://frontend.easysplit.local/api/v1/groupmembers', {
        user_id: userId,
        group_id: groupId
      });

      console.log('User added to group successfully');
      fetchGroupMembers(); // Fetch group members again to update the list after adding a new group member
    } catch (error) {
      console.error('Error adding user to group:', error);
      // Handle error
    }
  };

  return (
    <div>
      <h2>Add User to Group</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="userId">Select User:</label>
          <select id="userId" value={userId} onChange={handleUserChange} required>
            <option value="">Select User</option>
            {users.map(user => (
              <option key={user.id} value={user.id}>{user.username}</option>
            ))}
          </select>
        </div>
        <div>
          <label htmlFor="groupId">Select Group:</label>
          <select id="groupId" value={groupId} onChange={handleGroupChange} required>
            <option value="">Select Group</option>
            {groups.map(group => (
              <option key={group.id} value={group.id}>{group.groupName}</option>
            ))}
          </select>
        </div>
        <button type="submit">Add User to Group</button>
      </form>

      <h2>Group Members</h2>
      <ul>
  {groupMembers.map(member => (
    <li key={`${member.id.groupId}-${member.id.userId}`}>
      {member.user.username} - {member.group.groupName}
    </li>
  ))}
</ul>

    </div>
  );
};

export default GroupMembers;
