package hr.digitalnival.insurance.service;

import hr.digitalnival.insurance.exception.InsuranceTypeNotFoundException;
import hr.digitalnival.insurance.model.InsuranceType;
import hr.digitalnival.insurance.repository.InsuranceTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceTypeService {

    private Logger log = LoggerFactory.getLogger(InsuranceTypeService.class);

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

    /**
     * Returns all insurance types from the database.
     *
     * @return
     */
    public List<InsuranceType> getAll() {
        log.info("Will return all insurance types,");
        return insuranceTypeRepository.findAll();
    }
}
