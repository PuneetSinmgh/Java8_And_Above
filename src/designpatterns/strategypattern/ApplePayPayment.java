package src.designpatterns.strategypattern;

public class ApplePayPayment  implements PaymentProcessing {

    @Override
    public void pay( double amount) {
        System.out.println("Apple Pay payment logic");
    }
}