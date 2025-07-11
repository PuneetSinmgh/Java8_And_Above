package src.debugging.refactoring.transactionreconsiliation.util;

/**
 * Util class implementation
 * with FindDuplicates method
 */



import src.debugging.refactoring.transactionreconsiliation.model.Transaction;
import src.debugging.refactoring.transactionreconsiliation.repository.InMemoryTransactionRepository;
import src.debugging.refactoring.transactionreconsiliation.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionReconciliationUtil implements TransactionUtil {

    private static final TransactionRepository repository = new InMemoryTransactionRepository();
    /**
     *
     * with FindDuplicates method
     * @param   transactions list of Transactions to check
     * @return  list of duplicate transactions in the input
     */

    @Override
    public List<Transaction> findDuplicates(List<Transaction> transactions){

        List<Transaction> duplicates = new ArrayList<>();

        for ( Transaction t : transactions) {
            if ( !repository.findById( t.getId() ).isEmpty()) {
                duplicates.add( t );
            }
        }

        return duplicates;
    }
}
