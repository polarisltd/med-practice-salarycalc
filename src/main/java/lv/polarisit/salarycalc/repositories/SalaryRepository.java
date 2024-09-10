package lv.polarisit.salarycalc.repositories;

import lv.polarisit.salarycalc.entities.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<SalaryEntity, Long> {
}
