package com.project.easysplit.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "expenses")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "expense_amount")
    private BigDecimal expenseAmount;

    @Column(name = "expense_name")
    private String expenseName;

    @ManyToOne
    @JoinColumn(name = "paidbyuserid", referencedColumnName = "id")
    private Users paidByUser;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Groups group;

    public Expenses() {
    }

    public Expenses(Date date, BigDecimal expenseAmount, String expenseName, Optional<Users> user1, Optional<Groups> group1) {
    }

    public Expenses(Date date, BigDecimal expenseAmount, String expenseName, Users paidByUser, Groups group) {
        this.date = date;
        this.expenseAmount = expenseAmount;
        this.expenseName = expenseName;
        this.paidByUser = paidByUser;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Users getPaidByUser() {
        return paidByUser;
    }

    public void setPaidByUser(Users paidByUser) {
        this.paidByUser = paidByUser;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", date=" + date +
                ", expenseAmount=" + expenseAmount +
                ", expenseName='" + expenseName + '\'' +
                ", paidByUser=" + paidByUser +
                ", group=" + group +
                '}';
    }
}
