package hr.digitalnival.insurance.controller.api;

import hr.digitalnival.insurance.exception.InsuranceTypeNotFoundException;
import hr.digitalnival.insurance.service.PriceCalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/price-calculator/v1")
public class PriceCalculatorApi {

    Logger log = LoggerFactory.getLogger(PriceCalculatorApi.class);

    private PriceCalculatorService priceCalculatorService;

    public PriceCalculatorApi(PriceCalculatorService priceCalculatorService) {
        this.priceCalculatorService = priceCalculatorService;
    }

    @GetMapping("")
    public ResponseEntity<Double> calculatePrice(@RequestParam Long serviceId, @RequestParam Double productValue) {
        log.info("Will calculate price for serviceId:" + serviceId + " and productValue: " + productValue);
        try {
            return new ResponseEntity<>(priceCalculatorService.returnCalculatedPrice(serviceId, productValue), HttpStatus.OK);
        } catch (InsuranceTypeNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
