package hr.digitalnival.insurance.controller.api;

import hr.digitalnival.insurance.exception.InsuranceTypeNotFoundException;
import hr.digitalnival.insurance.exception.ProductValueNotValidException;
import hr.digitalnival.insurance.model.InsuranceType;
import hr.digitalnival.insurance.service.InsuranceTypeService;
import hr.digitalnival.insurance.service.PriceCalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/price-calculator/v1")
public class PriceCalculatorApi {

    Logger log = LoggerFactory.getLogger(PriceCalculatorApi.class);

    private PriceCalculatorService priceCalculatorService;
    private InsuranceTypeService insuranceTypeService;

    public PriceCalculatorApi(PriceCalculatorService priceCalculatorService, InsuranceTypeService insuranceTypeService) {
        this.priceCalculatorService = priceCalculatorService;
        this.insuranceTypeService = insuranceTypeService;
    }

    @GetMapping("")
    public ResponseEntity<Double> calculatePrice(@RequestParam Long insuranceTypeId, @RequestParam Double productValue) {
        log.info("Will calculate price for serviceId:" + insuranceTypeId + " and productValue: " + productValue);

        try {
            InsuranceType insuranceType = insuranceTypeService.getInsuranceType(insuranceTypeId);

            if (productValue < insuranceType.getCoverageAmountBottomLimit() || productValue > insuranceType.getCoverageAmountTopLimit()) {
                log.error("Input value is higher then allowed. Value: " + productValue);
                log.error("Bottom coverage limit: " + insuranceType.getCoverageAmountBottomLimit() + " - Top coverage limit:" + insuranceType.getCoverageAmountTopLimit());
                throw new ProductValueNotValidException(productValue, insuranceTypeId);
            }

            return new ResponseEntity<>(priceCalculatorService.returnCalculatedPrice(insuranceTypeId, productValue), HttpStatus.OK);
        } catch (InsuranceTypeNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
