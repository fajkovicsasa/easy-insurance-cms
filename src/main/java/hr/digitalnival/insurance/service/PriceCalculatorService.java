package hr.digitalnival.insurance.service;

import hr.digitalnival.insurance.model.InsuranceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PriceCalculatorService {

    private Logger log = LoggerFactory.getLogger(PriceCalculatorService.class);

    private InsuranceTypeService insuranceTypeService;

    public PriceCalculatorService(InsuranceTypeService insuranceTypeService) {
        this.insuranceTypeService = insuranceTypeService;
    }

    /**
     * Returns calculated price for a specific insurance type and product value
     * @param insuranceTypeId
     * @param productValue
     * @return
     */
    public Double returnCalculatedPrice(Long insuranceTypeId, Double productValue) {
        log.info("Calculating price for insurance type: " + insuranceTypeId + " and value " + productValue);

        InsuranceType insuranceType = insuranceTypeService.getInsuranceType(insuranceTypeId);

        Double result =  productValue * insuranceType.getRiskPercentage() / 100;
        log.debug("Calculated price: " + result);

        return result;
    }

}
