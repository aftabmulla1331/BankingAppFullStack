package com.BankingAppSpringBoot.BankingApplication.dto;

public class Accountdto {
    private Long id;
    private String accountHolderName;
    private  double balance;

    public Accountdto(Long id, String accountHolderName, double balance) {
        super();
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public Accountdto() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
