package src.debugging.refactoring.transactionreconsiliation.util;

import src.debugging.refactoring.transactionreconsiliation.model.Transaction;

import java.util.List;

/**
 * Util Interface for utility methods
 * Ensures thread safety, and vtransaction validations
 */
public interface TransactionUtil{
    public List<Transaction> findDuplicates(List<Transaction> list);
}