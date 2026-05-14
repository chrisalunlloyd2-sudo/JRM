package com.jrm.chronos.core.mapper;

import com.jrm.chronos.core.dto.ShiftAssignmentDto;
import com.jrm.chronos.core.dto.ShiftCreateDto;
import com.jrm.chronos.core.dto.ShiftDto;
import com.jrm.chronos.domain.Shift;
import com.jrm.chronos.domain.ShiftAssignment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShiftMapper {
    @Mapping(target = "locationId", source = "location.id")
    @Mapping(target = "locationName", source = "location.name")
    @Mapping(target = "departmentId", source = "department.id")
    @Mapping(target = "departmentName", source = "department.name")
    @Mapping(target = "requiredRoleId", source = "requiredRole.id")
    @Mapping(target = "requiredRoleName", source = "requiredRole.name")
    ShiftDto toDto(Shift entity);

    @Mapping(target = "location.id", source = "locationId")
    @Mapping(target = "department.id", source = "departmentId")
    @Mapping(target = "requiredRole.id", source = "requiredRoleId")
    Shift toEntity(ShiftCreateDto dto);

    @Mapping(target = "shiftId", source = "shift.id")
    @Mapping(target = "employeeId", source = "employee.id")
    @Mapping(target = "employeeName", expression = "java(entity.getEmployee().getFirstName() + \" \" + entity.getEmployee().getLastName())")
    ShiftAssignmentDto toDto(ShiftAssignment entity);
}
