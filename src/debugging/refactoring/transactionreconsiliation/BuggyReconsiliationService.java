package src.debugging.refactoring.transactionreconsiliation;

import java.util.ArrayList;
import java.util.List;

public class BuggyReconsiliationService {
}
// No validations
// No tests
// No documentation
class TransactionService {
    private List<Transaction> transactionList = new ArrayList<>(); // concurrency modification exception as not thread safe

    public void addTransaction(Transaction t) { // separation of concern
        if (t != null) // no input validaiton
            transactionList.add(t);
    }

    public List<Transaction> findDuplicates() {
        List<Transaction> duplicates = new ArrayList<>();

        for (int i = 0; i < transactionList.size(); i++) { // inefficient dedupe logic for large size
            Transaction t1 = transactionList.get(i);
            for (int j = i+1; j < transactionList.size(); j++) { // when i is at last index j will be equal to size of transaction list  and throw
                Transaction t2 = transactionList.get(j);
                if (t1.getId() == t2.getId()) { // potential issue is Id is of type UUID
                    if (!duplicates.contains(t1))
                        duplicates.add(t1);
                    if (!duplicates.contains(t2))
                        duplicates.add(t2);
                }
            }
        }

        return duplicates;
    }
}

class Transaction {
    private long id;
    private double amount;
    private String status; // should be of type enum

    public Transaction(long id, double amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    // no equals or no hashcode method , list operations will not work
}

