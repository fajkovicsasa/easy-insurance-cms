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

    /**
     * Updates the #InsuranceType entity
     *
     * @param insuranceType
     */
    public void update(InsuranceType insuranceType) {
        log.debug("Will update: " + insuranceType.toString());

        if (insuranceType.getId() == null) {
            throw new IllegalArgumentException("ID can't be null when performing and update.");
        }

        validateInsuranceType(insuranceType);

        insuranceTypeRepository.save(insuranceType);
    }

    /**
     * Creates an #InsuranceType entity
     *
     * @param insuranceType
     */
    public void create(InsuranceType insuranceType) {
        log.debug("Will create a new entity: " + insuranceType.toString());

        if (insuranceType.getId() != null) {
            throw new IllegalArgumentException("ID must be null when creating a new entity");
        }

        validateInsuranceType(insuranceType);

        insuranceTypeRepository.save(insuranceType);
    }


    /**
     * Creates an #InsuranceType entity
     *
     * @param insuranceTypeId
     */
    public void delete(Long insuranceTypeId) {
        log.debug("Will delete an entity: " + insuranceTypeId);

        insuranceTypeRepository.deleteById(insuranceTypeId);
    }

    /**
     * Validates the insurance type object. If it's not valid, an exception will be thrown
     * @param insuranceType
     */
    private void validateInsuranceType(InsuranceType insuranceType) {
        if (insuranceType.getCoverageAmountBottomLimit() >= insuranceType.getCoverageAmountTopLimit()) {
            throw new IllegalArgumentException("Bottom limit must be lower than top limit for coverage");
        }
    }
}
