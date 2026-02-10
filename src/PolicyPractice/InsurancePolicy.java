package PolicyPractice;

class InsurancePolicy {

    int policyNumber;
    String customerName;
    PolicyType policyType;
    int customerAge;
    double basePremium;
    double finalPremium;
    PolicyStatus status;

    public InsurancePolicy(int policyNumber,
                           String customerName,
                           String policyType,
                           int customerAge,
                           double basePremium,
                           String status) throws InvalidPolicyException {

        try {
            this.policyType = PolicyType.valueOf(policyType.toUpperCase());
            this.status = PolicyStatus.valueOf(status.toUpperCase());
        } 
        catch (IllegalArgumentException e) {
            throw new InvalidPolicyException("Invalid Policy Type or Status");
        }

        this.policyNumber = policyNumber;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.basePremium = basePremium;

        calculatePremium();
    }

    public void calculatePremium() {
        switch (policyType) {
            case HEALTH:
                finalPremium = basePremium + (basePremium * 0.20);
                break;
            case LIFE:
                finalPremium = basePremium + (basePremium * 0.35);
                break;
            case VEHICLE:
                finalPremium = basePremium + (basePremium * 0.15);
                break;
            case TRAVEL:
                finalPremium = basePremium + (basePremium * 0.10);
                break;
        }
    }

    @Override
    public String toString() {
        return "Policy No: " + policyNumber +
               ", Name: " + customerName +
               ", Type: " + policyType +
               ", Premium: " + finalPremium +
               ", Status: " + status;
    }
}
