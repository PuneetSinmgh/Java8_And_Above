package src.debugging.refactoring.transactionreconsiliation.model;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;


/**
 * transaction model class
 * Ensures equals and Hashcode contract
 */
public class Transaction {
    private UUID id;
    private double amount;
    private TransactionStatus status;

    public Transaction(UUID id, double amount, TransactionStatus status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        // 1. Check for reference equality
        if (this == o) {
            return true;
        }
        // 2. Check for null and class type
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        // 3. Cast the object to the correct type
        Transaction that = (Transaction) o;
        // 4. Compare the significant field(s) for equality
        return id.equals(that.id); // Comparing only the 'id' for logical equality
    }

    @Override
    public int hashCode() {
        // Generate the hash code based on the same field(s) used in equals()
        return Objects.hash(id); // Generates hash based on the 'id' field
    }
}


