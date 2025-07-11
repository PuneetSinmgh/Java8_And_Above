package src.debugging.refactoring.transactionreconsiliation.repository;

import src.debugging.refactoring.transactionreconsiliation.model.Transaction;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Repository Interface Implementation encapsulating storage for all transactions
 * Ensures thread safety
 */
public class InMemoryTransactionRepository implements TransactionRepository {

    private final ConcurrentHashMap<UUID, Transaction> currentTransactions = new ConcurrentHashMap<>();

    @Override
    public Transaction save(Transaction transaction) {
        currentTransactions.put(transaction.getId(), transaction);
        return transaction;
    }

    @Override
    public Optional<Transaction> findById(UUID id) {
        return Optional.ofNullable(currentTransactions.get(id));
    }
}
