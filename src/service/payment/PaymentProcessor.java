package service.payment;

/**
 * Étape : traite le paiement (simulation).
 */
public class PaymentProcessor extends PaymentHandler {

    @Override
    public void handle(PaymentRequest request) {
        System.out.println("[PaymentProcessor] Processing payment for " + request.getUserId() + " amount " + request.getAmount());
        // simulation simple : toujours valide
        request.setValidated(true);
        if (next != null) next.handle(request);
    }
}

