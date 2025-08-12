package java8.src.collection.cryptotransactionledger;


/*
* User case:
* 1. Adds a transaction for a given user. Positive amounts mean deposit, negative means withdrawal.
* 2. Returns a list of all transactions (in insertion order) for that user.
* 3. Removes the most recent transaction for that user and adjusts their balance.
* 4. Modify the design so transactions can also store currency type (e.g., "BTC", "ETH") and each user can have balances per currency.
*
* Class Structure
*
* Transaction
*   - Timestamp
*   - amount (pos/neg ))
*
* UserTransactions
*   - Balance
*   -currency
*   - userId
*   -ListOf Transactions
*
*
*
*
* */

import src.debugging.refactoring.transactionreconsiliation.model.Transaction;

import java.util.*;




public class CryptoTransactionLedgerApp {

    static class Transaction{
        int timestamp;
        double amount;

        Transaction(int time, double amount){
            this.timestamp = time;
            this.amount = amount;
        }

    }

    static class UserTransactions{
        double balance;
        String userid;
        String currency;
        List<Transaction> transactions;

        public UserTransactions(String userid, String currency) {
            this.balance = 0.0;
            this.userid = userid;
            this.currency = currency;
            this.transactions = new LinkedList<>();
        }
    }

    // with multi-currency support
    private static Map<String, Map<String, UserTransactions >> mapOfTransactions = new HashMap<>();

    // without multi currency support
    //private static Map<String, List< UserTransactions >> mapOfTransactions = new HashMap<>();

    public static void main(String[] args) {

    }

    public static void addTransaction(String userId, String currency,  double amount){

        if (currency.isBlank()){
            currency = "default";
        }

        Map<String, UserTransactions > map = mapOfTransactions.getOrDefault(userId, new HashMap<>() );

        // first transaction
        UserTransactions userTransact = map.getOrDefault(currency, new UserTransactions( userId, currency));
        if ( amount < 0){
           userTransact.balance -= amount;
        } else {
           userTransact.balance += amount;
        }

        userTransact.transactions.addLast(new Transaction( 1, amount ));

    }

    public static List<Transaction> getTransactionHistory(String userId){

        if ( mapOfTransactions.containsKey(userId) ){

            UserTransactions userTransact = mapOfTransactions.get(userId).get("USD");

            return userTransact.transactions;
        }

        return List.of();
    }

    public static void undoLastTransaction(String userId){

        if ( mapOfTransactions.containsKey(userId) ) {

            UserTransactions userTransact = mapOfTransactions.get(userId).get("USD");
            Transaction t = userTransact.transactions.removeLast();

            if (t.amount < 0) {
                userTransact.balance += -1 * t.amount;
            } else {
                userTransact.balance -= t.amount;
            }

        }
    }

}
