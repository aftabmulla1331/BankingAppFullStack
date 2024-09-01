package com.BankingAppSpringBoot.BankingApplication.Controller;

import com.BankingAppSpringBoot.BankingApplication.Service.AccountService;
import com.BankingAppSpringBoot.BankingApplication.dto.Accountdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    //add acc rest api
    @PostMapping
    public ResponseEntity<Accountdto> addAccount(@RequestBody Accountdto accountdto){
        System.out.println(accountdto);

    return new ResponseEntity<>(accountService.createAccount(accountdto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accountdto> getAccountById(@PathVariable Long id){
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

//    @PutMapping("/deposit/{id}/{bal}")
//    public ResponseEntity<Accountdto> addDeposit(@PathVariable Long id, @PathVariable Double bal){
//        return new ResponseEntity<>(accountService.deposit(id, bal), HttpStatus.OK);
//    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<Accountdto> addDeposit(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double bal = request.get("amount");
        Accountdto accountdto = accountService.deposit(id, bal);
        return ResponseEntity.ok(accountdto);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<Accountdto> withdrawAmount(@PathVariable  Long id, @RequestBody Map<String, Double> req){
        Double withdrawAmount = req.get("amount");
        Accountdto accountdto = accountService.withdraw(id, withdrawAmount);
        return ResponseEntity.ok(accountdto);
    }

    @GetMapping
    public ResponseEntity<List<Accountdto>> allAccounts(){
        return new ResponseEntity<>(accountService.getAllAccount(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAccount/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account Deleted Successfully");
    }
}
