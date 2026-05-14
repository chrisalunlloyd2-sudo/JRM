package com.jrm.chronos.core.service.impl;

import com.jrm.chronos.core.dto.DepartmentDto;
import com.jrm.chronos.core.dto.LocationDto;
import com.jrm.chronos.core.mapper.OrganizationMapper;
import com.jrm.chronos.core.service.OrganizationService;
import com.jrm.chronos.domain.Department;
import com.jrm.chronos.domain.Location;
import com.jrm.chronos.domain.repository.DepartmentRepository;
import com.jrm.chronos.domain.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrganizationServiceImpl implements OrganizationService {

    private final LocationRepository locationRepository;
    private final DepartmentRepository departmentRepository;
    private final OrganizationMapper organizationMapper;

    @Override
    @Transactional
    public LocationDto createLocation(LocationDto locationDto) {
        Location location = organizationMapper.toEntity(locationDto);
        return organizationMapper.toDto(locationRepository.save(location));
    }

    @Override
    public List<LocationDto> findAllLocations() {
        return locationRepository.findAll().stream()
                .map(organizationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = organizationMapper.toEntity(departmentDto);
        return organizationMapper.toDto(departmentRepository.save(department));
    }

    @Override
    public List<DepartmentDto> findDepartmentsByLocation(Long locationId) {
        return departmentRepository.findByLocationId(locationId).stream()
                .map(organizationMapper::toDto)
                .collect(Collectors.toList());
    }
}
