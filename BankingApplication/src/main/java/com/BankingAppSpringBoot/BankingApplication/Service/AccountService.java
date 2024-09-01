package com.BankingAppSpringBoot.BankingApplication.Service;

import com.BankingAppSpringBoot.BankingApplication.Entity.Account;
import com.BankingAppSpringBoot.BankingApplication.dto.Accountdto;

import java.util.List;

public interface AccountService {
    Accountdto createAccount(Accountdto account);

    Accountdto getAccountById(Long id);

    Accountdto deposit(Long id, double amount);

    Accountdto withdraw(Long id, double amount);

    List<Accountdto> getAllAccount();

    void deleteAccount(Long id);
}
