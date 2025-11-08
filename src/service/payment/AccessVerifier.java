package service.payment;

/**
 * Étape : vérifie que le paiement a été validé pour donner l'accès.
 */
public class AccessVerifier extends PaymentHandler {

    @Override
    public void handle(PaymentRequest request) {
        if (!request.isValidated()) {
            System.out.println("[AccessVerifier] Payment not validated. Access denied.");
            return;
        }
        System.out.println("[AccessVerifier] Access granted for " + request.getUserId());
        if (next != null) next.handle(request);
    }
}

