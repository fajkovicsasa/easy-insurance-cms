package sasa.fajkovic.repository;

import sasa.fajkovic.model.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceTypeRepository extends JpaRepository<InsuranceType, Long> {
}
