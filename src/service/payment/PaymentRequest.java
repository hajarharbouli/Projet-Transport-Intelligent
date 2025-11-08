package service.payment;

/**
 * Représente une requête de paiement.
 */
public class PaymentRequest {
    private String userId;
    private double amount;
    private boolean validated = false;

    public PaymentRequest(String userId, double amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public String getUserId() { return userId; }
    public double getAmount() { return amount; }

    public boolean isValidated() { return validated; }
    public void setValidated(boolean validated) { this.validated = validated; }
}

