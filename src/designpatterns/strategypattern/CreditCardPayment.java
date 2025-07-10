package src.designpatterns.strategypattern;

public class CreditCardPayment implements PaymentProcessing {
    @Override
    public void pay(double amount) {
        System.out.println("Credit card processed for : " + amount);
    }
}
