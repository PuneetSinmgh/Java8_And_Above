package src.designpatterns.strategypattern;

public class PaymentApplication {


    public static void main(String[] args) {
        PaymentProcessing paymentProcessingCreditCard =  new CreditCardPayment();
        paymentProcessingCreditCard.pay(1.0);

        PaymentProcessing credit = new CreditCardPayment();
        PaymentProcessing paypal = new PayPalPayment();

        PaymentService service = new PaymentService(credit);
        service.makePayment(100.0);  // Credit card logic runs

        service.setPaymentMethod(paypal);
        service.makePayment(200.0);  // PayPal logic runs
    }
}
