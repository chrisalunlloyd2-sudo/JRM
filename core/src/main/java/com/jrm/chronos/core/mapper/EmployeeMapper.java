package com.jrm.chronos.core.mapper;

import com.jrm.chronos.core.dto.EmployeeProfileDto;
import com.jrm.chronos.domain.EmployeeProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "departmentId", source = "department.id")
    @Mapping(target = "locationId", source = "location.id")
    EmployeeProfileDto toDto(EmployeeProfile entity);
}
