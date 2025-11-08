package service.payment;

/**
 * Handler abstrait pour la chaîne de responsabilité.
 */
public abstract class PaymentHandler {
    protected PaymentHandler next;

    public PaymentHandler setNext(PaymentHandler next) {
        this.next = next;
        return next;
    }

    public abstract void handle(PaymentRequest request);
}

