package com.protection.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAll(){
        return transactionRepository.findAll();
    }

    public boolean create(Transaction transaction){
        transactionRepository.save(transaction);
        return true;
    }

    public boolean update(Transaction transaction){
        if (transaction.getId() == null || transaction.getId() == 0)
            return false;

        transactionRepository.save(transaction);
        return true;
    }

    public Transaction get(Long id){
        return transactionRepository.findOne(id);
    }

    public boolean delete(Long id){
        if(id == null || id == 0)
            return false;

        transactionRepository.delete(id);
        return true;
    }
}
