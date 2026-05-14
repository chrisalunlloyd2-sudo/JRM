package com.jrm.chronos.core.mapper;

import com.jrm.chronos.core.dto.DepartmentDto;
import com.jrm.chronos.core.dto.LocationDto;
import com.jrm.chronos.domain.Department;
import com.jrm.chronos.domain.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrganizationMapper {
    LocationDto toDto(Location location);
    Location toEntity(LocationDto locationDto);

    @Mapping(target = "locationId", source = "location.id")
    DepartmentDto toDto(Department department);
    @Mapping(target = "location.id", source = "locationId")
    Department toEntity(DepartmentDto departmentDto);
}
