package hr.digitalnival.insurance.service;

import hr.digitalnival.insurance.model.InsuranceType;
import org.springframework.stereotype.Service;

@Service
public class PriceCalculatorService {

    private InsuranceTypeService insuranceTypeService;

    public PriceCalculatorService(InsuranceTypeService insuranceTypeService) {
        this.insuranceTypeService = insuranceTypeService;
    }

    public Double calculatePrice(Long insuranceTypeId, Double productValue) {
        InsuranceType insuranceType = insuranceTypeService.getInsuranceType(insuranceTypeId);

        return productValue * insuranceType.getRiskPercentage() / 100;
    }

}
