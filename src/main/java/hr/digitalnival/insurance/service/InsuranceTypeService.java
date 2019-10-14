package hr.digitalnival.insurance.service;

import hr.digitalnival.insurance.exception.InsuranceTypeNotFoundException;
import hr.digitalnival.insurance.model.InsuranceType;
import hr.digitalnival.insurance.repository.InsuranceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceTypeService {

    private InsuranceTypeRepository insuranceTypeRepository;

    public InsuranceTypeService(InsuranceTypeRepository insuranceTypeRepository) {
        this.insuranceTypeRepository = insuranceTypeRepository;
    }

    /**
     * Returns an insurance type object. If no insurance type is found, an exception will be thrown.
     *
     * @param id
     * @return
     * @throws InsuranceTypeNotFoundException
     */
    public InsuranceType getInsuranceType(Long id) throws InsuranceTypeNotFoundException {
        Optional<InsuranceType> optional = insuranceTypeRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }
        throw new InsuranceTypeNotFoundException(id);
    }

    public List<InsuranceType> getAll() {
        return insuranceTypeRepository.findAll();
    }
}
