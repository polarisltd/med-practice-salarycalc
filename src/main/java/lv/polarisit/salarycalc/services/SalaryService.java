package lv.polarisit.salarycalc.services;

import lv.polarisit.salarycalc.controllers.OutputPayload;
import lv.polarisit.salarycalc.entities.SalaryEntity;
import lv.polarisit.salarycalc.mappers.SalaryMapper;
import lv.polarisit.salarycalc.repositories.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    public SalaryEntity saveSalary(OutputPayload outputPayload) {
        SalaryEntity salaryEntity = SalaryMapper.INSTANCE.toEntity(outputPayload);
        return salaryRepository.save(salaryEntity);
    }
}
