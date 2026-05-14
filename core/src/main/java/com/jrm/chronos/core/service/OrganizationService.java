package com.jrm.chronos.core.service;

import com.jrm.chronos.core.dto.DepartmentDto;
import com.jrm.chronos.core.dto.LocationDto;
import java.util.List;

public interface OrganizationService {
    LocationDto createLocation(LocationDto locationDto);
    List<LocationDto> findAllLocations();
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    List<DepartmentDto> findDepartmentsByLocation(Long locationId);
}
