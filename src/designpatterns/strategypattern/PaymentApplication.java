package src.designpatterns.strategypattern;

public class PaymentApplication {


    public static void main(String[] args) {
        PaymentProcessing paymentProcessingCreditCard =  new CreditCardPayment();
        paymentProcessingCreditCard.pay(1.0);
    }
}
