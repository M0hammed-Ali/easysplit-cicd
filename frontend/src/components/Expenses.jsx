import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Expenses = () => {
  const [date, setDate] = useState('');
  const [expenseAmount, setExpenseAmount] = useState('');
  const [expenseName, setExpenseName] = useState('');
  const [paidByUserId, setPaidByUserId] = useState('');
  const [groupId, setGroupId] = useState('');
  const [expenses, setExpenses] = useState([]);
  const [groups, setGroups] = useState([]);

  useEffect(() => {
    fetchExpenses();
    fetchGroups();
  }, []);

  const fetchExpenses = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/v1/expenses');
      setExpenses(response.data);
    } catch (error) {
      console.error('Error fetching expenses:', error);
      // Handle error
    }
  };

  const fetchGroups = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/v1/groups');
      setGroups(response.data);
    } catch (error) {
      console.error('Error fetching groups:', error);
      // Handle error
    }
  };

  const handleDateChange = (e) => {
    setDate(e.target.value);
  };

  const handleExpenseAmountChange = (e) => {
    setExpenseAmount(e.target.value);
  };

  const handleExpenseNameChange = (e) => {
    setExpenseName(e.target.value);
  };

  const handlePaidByUserIdChange = (e) => {
    setPaidByUserId(e.target.value);
  };

  const handleGroupChange = (e) => {
    setGroupId(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await axios.post('http://localhost:8080/api/v1/expenses', {
        date: date,
        expenseAmount: expenseAmount,
        expenseName: expenseName,
        paidbyuserid: paidByUserId,
        group_id: groupId
      });

      console.log('Expense added successfully');
      
      // Fetch expenses again to update the list after adding a new expense
      fetchExpenses();
    } catch (error) {
      console.error('Error adding expense:', error);
      // Handle error
    }
  };

  return (
    <div>
      <h2>Add Expense</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="date">Date:</label>
          <input
            type="date"
            id="date"
            value={date}
            onChange={handleDateChange}
            required
          />
        </div>
        <div>
          <label htmlFor="expenseAmount">Expense Amount:</label>
          <input
            type="number"
            id="expenseAmount"
            value={expenseAmount}
            onChange={handleExpenseAmountChange}
            required
          />
        </div>
        <div>
          <label htmlFor="expenseName">Expense Name:</label>
          <input
            type="text"
            id="expenseName"
            value={expenseName}
            onChange={handleExpenseNameChange}
            required
          />
        </div>
        <div>
          <label htmlFor="paidByUserId">Paid By User ID:</label>
          <input
            type="number"
            id="paidByUserId"
            value={paidByUserId}
            onChange={handlePaidByUserIdChange}
            required
          />
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
        <button type="submit">Add Expense</button>
      </form>

      <h2>Expenses</h2>
      <ul>
        {expenses.map(expense => (
          <li key={expense.id}>{expense.expenseName} - ${expense.expenseAmount}</li>
        ))}
      </ul>
    </div>
  );
};

export default Expenses;
