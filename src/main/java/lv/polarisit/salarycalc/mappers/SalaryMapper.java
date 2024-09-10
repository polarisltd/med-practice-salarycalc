package lv.polarisit.salarycalc.mappers;

import lv.polarisit.salarycalc.controllers.OutputPayload;
import lv.polarisit.salarycalc.entities.SalaryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SalaryMapper {
    SalaryMapper INSTANCE = Mappers.getMapper(SalaryMapper.class);

    SalaryEntity toEntity(OutputPayload outputPayload);
    OutputPayload toOutputPayload(SalaryEntity salaryEntity);
}