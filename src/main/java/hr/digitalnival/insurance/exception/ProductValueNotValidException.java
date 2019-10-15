package hr.digitalnival.insurance.exception;

public class ProductValueNotValidException extends RuntimeException {

    private String message;

    public ProductValueNotValidException(Double productValue, Long insuranceTypeId) {
        this.message = "Value " + productValue + " is not inside the allowed range for insurance type " + insuranceTypeId;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
