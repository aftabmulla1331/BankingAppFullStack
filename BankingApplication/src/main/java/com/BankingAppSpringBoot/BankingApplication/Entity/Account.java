package com.BankingAppSpringBoot.BankingApplication.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_holder_name")
    private String AccountHolderName;
    private double balance;

    public Account(Long id, String accountHolderName, double balance) {
        super();
        this.id = id;
        AccountHolderName = accountHolderName;
        this.balance = balance;
    }

    public Account() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return AccountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        AccountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
