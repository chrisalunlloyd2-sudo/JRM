package com.jrm.chronos.api.controller;

import com.jrm.chronos.core.dto.DepartmentDto;
import com.jrm.chronos.core.dto.LocationDto;
import com.jrm.chronos.core.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/org")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping("/locations")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto locationDto) {
        return ResponseEntity.ok(organizationService.createLocation(locationDto));
    }

    @GetMapping("/locations")
    public ResponseEntity<List<LocationDto>> findAllLocations() {
        return ResponseEntity.ok(organizationService.findAllLocations());
    }

    @PostMapping("/departments")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(organizationService.createDepartment(departmentDto));
    }

    @GetMapping("/locations/{locationId}/departments")
    public ResponseEntity<List<DepartmentDto>> findDepartmentsByLocation(@PathVariable Long locationId) {
        return ResponseEntity.ok(organizationService.findDepartmentsByLocation(locationId));
    }
}
