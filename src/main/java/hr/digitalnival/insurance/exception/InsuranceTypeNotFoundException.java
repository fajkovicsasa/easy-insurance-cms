package hr.digitalnival.insurance.exception;

public class InsuranceTypeNotFoundException extends RuntimeException {

    private String message;

    public InsuranceTypeNotFoundException(Long insuranceTypeId) {
        this.message = "Insurance type with ID " + insuranceTypeId + " not found!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
