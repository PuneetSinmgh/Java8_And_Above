package src.debugging.refactoring.transactionreconsiliation.service;


import src.debugging.refactoring.transactionreconsiliation.model.Transaction;
import src.debugging.refactoring.transactionreconsiliation.model.TransactionStatus;
import src.debugging.refactoring.transactionreconsiliation.repository.InMemoryTransactionRepository;
import src.debugging.refactoring.transactionreconsiliation.repository.TransactionRepository;

import java.util.regex.Pattern;

/**
 * Service for adding Transactions
 * Ensures thread safety, and vtransaction validations
 */
public class TransactionService {
    // repository
    private static final TransactionRepository repository = new InMemoryTransactionRepository();


    private static final TransactionService transactionService = new TransactionService();

    // Transaction Id validation pattern
    private static final Pattern ID_PATTERN =
            Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");


    private TransactionService(){}

    public static TransactionService getInstance(){
        return transactionService;
    }

    public static void addTransaction(Transaction t) { // separation of concern
        if (t != null ){
            if (  t.getStatus() == TransactionStatus.PROCCESSED || t.getStatus() == TransactionStatus.COMPLETE ){
                throw new IllegalArgumentException(" Transactions already processed ");
            }

            if ( !ID_PATTERN.matcher( t.getId().toString() ).matches()){
                throw new IllegalArgumentException(" Transactions has invalid Id ");
            }
        }

        repository.save(t);
    }
}
