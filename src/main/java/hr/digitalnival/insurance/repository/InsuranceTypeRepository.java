package hr.digitalnival.insurance.repository;

import hr.digitalnival.insurance.model.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceTypeRepository extends JpaRepository<InsuranceType, Long> {
}
