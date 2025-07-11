package src.debugging.refactoring.transactionreconsiliation.repository;

import src.debugging.refactoring.transactionreconsiliation.model.Transaction;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository Interface encapsulating storage for all transactions
 * Ensures thread safety
 */
public interface TransactionRepository {
    Transaction save(Transaction transaction);
    Optional<Transaction> findById(UUID id);
}