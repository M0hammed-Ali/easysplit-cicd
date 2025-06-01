import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Balances = () => {
  const [groupMembers, setGroupMembers] = useState([]);
  const [selectedGroup, setSelectedGroup] = useState('');
  const [expenses, setExpenses] = useState([]);
  const [groupBalances, setGroupBalances] = useState([]);

  useEffect(() => {
    fetchGroupMembers();
    fetchExpenses();
  }, []);

  const fetchGroupMembers = async () => {
    try {
      const response = await axios.get('http://backend.easysplit.local/api/v1/groupmembers');
      setGroupMembers(response.data);
    } catch (error) {
      console.error('Error fetching group members:', error);
      // Handle error
    }
  };

  const fetchExpenses = async () => {
    try {
      const response = await axios.get('http://backend.easysplit.local/api/v1/expenses');
      setExpenses(response.data);
    } catch (error) {
      console.error('Error fetching expenses:', error);
      // Handle error
    }
  };

  const handleGroupSelect = (e) => {
    setSelectedGroup(e.target.value);
  };

  const calculateBalances = () => {
    if (groupMembers.length === 0 || expenses.length === 0 || selectedGroup === '') {
      console.error('Group members, expenses, or selected group are not loaded yet.');
      return;
    }

    const filteredGroupMembers = groupMembers.filter(member => member.group.id === parseInt(selectedGroup));
    const totalAmount = expenses.filter(expense => expense.group.id === parseInt(selectedGroup))
                                 .reduce((total, expense) => total + parseFloat(expense.expenseAmount), 0);
    const groupCount = filteredGroupMembers.length;

    const updatedBalances = filteredGroupMembers.map(member => {
      const expensesForMember = expenses.filter(expense => expense.group.id === parseInt(selectedGroup) && expense.paidByUser.id === member.user.id)
                                          .reduce((total, expense) => total + parseFloat(expense.expenseAmount), 0);
      const amountOwed = (totalAmount / groupCount) - expensesForMember;
      
      return {
        userId: member.user.id,
        userName: member.user.username,
        groupId: member.group.id,
        groupName: member.group.groupName,
        amountOwed: amountOwed
      };
    });

    setGroupBalances(updatedBalances);
  };

  return (
    <div>
      <h2>User Balances</h2>
      <div>
        <label htmlFor="groupSelect">Select Group: </label>
        <select id="groupSelect" value={selectedGroup} onChange={handleGroupSelect}>
          <option value="">Select a group</option>
          {groupMembers.map(member => (
            <option key={member.group.id} value={member.group.id}>{member.group.groupName}</option>
          ))}
        </select>
        <button onClick={calculateBalances}>Calculate Balances</button>
      </div>
      <table>
        <thead>
          <tr>
            <th>User Name</th>
            <th>Group Name</th>
            <th>Amount Owed</th>
          </tr>
        </thead>
        <tbody>
          {groupBalances.map(member => (
            <tr key={`${member.userId}-${member.groupId}`}>
              <td>{member.userName}</td>
              <td>{member.groupName}</td>
              <td>{member.amountOwed}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Balances;
