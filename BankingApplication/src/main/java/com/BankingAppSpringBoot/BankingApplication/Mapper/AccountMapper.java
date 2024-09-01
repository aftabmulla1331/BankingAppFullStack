package com.BankingAppSpringBoot.BankingApplication.Mapper;

import com.BankingAppSpringBoot.BankingApplication.Entity.Account;
import com.BankingAppSpringBoot.BankingApplication.dto.Accountdto;

public class AccountMapper {

    public static Account mapToAccount(Accountdto accountdto){
        Account account = new Account(
                accountdto.getId(),
                accountdto.getAccountHolderName(),
                accountdto.getBalance()
        );

        return account;
    }

    public static Accountdto mapToAccCountDto(Account account){
        Accountdto accountdto = new Accountdto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountdto;
    }



}
