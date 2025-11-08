package service.payment;

/**
 * Étape : réalise des contrôles de sécurité supplémentaires.
 */
public class SecurityChecker extends PaymentHandler {

    @Override
    public void handle(PaymentRequest request) {
        System.out.println("[SecurityChecker] Performing security checks for " + request.getUserId());
        // simulation ok
        if (next != null) next.handle(request);
    }
}

