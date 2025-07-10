package src.designpatterns.strategypattern;

public class PaymentService {
    private PaymentProcessing paymentMethod;

    public PaymentService(PaymentProcessing paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentMethod(PaymentProcessing paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void makePayment(double amount) {
        paymentMethod.pay(amount);
    }
}
