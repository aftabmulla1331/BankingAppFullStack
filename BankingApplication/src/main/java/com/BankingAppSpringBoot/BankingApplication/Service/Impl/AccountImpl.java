package com.BankingAppSpringBoot.BankingApplication.Service.Impl;

import com.BankingAppSpringBoot.BankingApplication.Entity.Account;
import com.BankingAppSpringBoot.BankingApplication.Mapper.AccountMapper;
import com.BankingAppSpringBoot.BankingApplication.Repository.AccountRepository;
import com.BankingAppSpringBoot.BankingApplication.Service.AccountService;
import com.BankingAppSpringBoot.BankingApplication.dto.Accountdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class AccountImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Accountdto createAccount(Accountdto accountdto) {
        Account account=AccountMapper.mapToAccount(accountdto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccCountDto(savedAccount);

    }

    @Override
    public Accountdto getAccountById(Long id) {
       Account acc= accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not Found"));
       return AccountMapper.mapToAccCountDto(acc);
    }

    @Override
    public Accountdto deposit(Long id, double amount) {
    Account account =   accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found") );
    double totalAmount = account.getBalance()+amount;
    account.setBalance(totalAmount);
    Account savedAccount = accountRepository.save(account);
    return AccountMapper.mapToAccCountDto(savedAccount);
    }

    @Override
    public Accountdto withdraw(Long id, double amount) {
       Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));

       if (account.getBalance() < amount){
           throw new RuntimeException("Insufficient amount");
       }else {
           double totalAmount = account.getBalance()-amount;
           account.setBalance(totalAmount);
           Account savedAccountWithdraw = accountRepository.save(account);
           return AccountMapper.mapToAccCountDto(savedAccountWithdraw);
       }

    }

    @Override
    public List<Accountdto> getAllAccount() {
       return  accountRepository.findAll()
               .stream()
               .map(AccountMapper::mapToAccCountDto)
               .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account acc =  accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        accountRepository.delete(acc);
    }
}
