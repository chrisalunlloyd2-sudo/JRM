package com.jrm.chronos.core.mapper;

import com.jrm.chronos.core.dto.TimeEntryDto;
import com.jrm.chronos.domain.TimeEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TimeEntryMapper {
    @Mapping(target = "employeeId", source = "employee.id")
    @Mapping(target = "employeeName", expression = "java(entity.getEmployee().getFirstName() + \" \" + entity.getEmployee().getLastName())")
    @Mapping(target = "shiftId", source = "shift.id")
    TimeEntryDto toDto(TimeEntry entity);
}
