package src.designpatterns.strategypattern;

public class PayPalPayment  implements PaymentProcessing {

    @Override
    public void pay( double amount) {
        System.out.println("PayPal payment processed : "+ amount);
    }
}