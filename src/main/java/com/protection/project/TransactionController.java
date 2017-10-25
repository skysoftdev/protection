package com.protection.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Transaction> getAll(){
        return transactionService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody Transaction transaction){
        return transactionService.create(transaction);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public boolean update(@RequestBody Transaction transaction){
        return transactionService.update(transaction);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Transaction get(@PathVariable Long id){
        return transactionService.get(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public boolean delete(@RequestParam Long id){
        return transactionService.delete(id);
    }
}
