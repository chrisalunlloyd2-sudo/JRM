package com.jrm.chronos.core.mapper;

import com.jrm.chronos.core.dto.EmployeeProfileDto;
import com.jrm.chronos.domain.Department;
import com.jrm.chronos.domain.EmployeeProfile;
import com.jrm.chronos.domain.Location;
import com.jrm.chronos.domain.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-14T23:19:20+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.11 (Termux)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeProfileDto toDto(EmployeeProfile entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeProfileDto.EmployeeProfileDtoBuilder employeeProfileDto = EmployeeProfileDto.builder();

        employeeProfileDto.userId( entityUserId( entity ) );
        employeeProfileDto.departmentId( entityDepartmentId( entity ) );
        employeeProfileDto.locationId( entityLocationId( entity ) );
        employeeProfileDto.id( entity.getId() );
        employeeProfileDto.firstName( entity.getFirstName() );
        employeeProfileDto.lastName( entity.getLastName() );
        employeeProfileDto.employeeNumber( entity.getEmployeeNumber() );
        employeeProfileDto.dateOfBirth( entity.getDateOfBirth() );
        employeeProfileDto.hireDate( entity.getHireDate() );

        return employeeProfileDto.build();
    }

    private Long entityUserId(EmployeeProfile employeeProfile) {
        if ( employeeProfile == null ) {
            return null;
        }
        User user = employeeProfile.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityDepartmentId(EmployeeProfile employeeProfile) {
        if ( employeeProfile == null ) {
            return null;
        }
        Department department = employeeProfile.getDepartment();
        if ( department == null ) {
            return null;
        }
        Long id = department.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityLocationId(EmployeeProfile employeeProfile) {
        if ( employeeProfile == null ) {
            return null;
        }
        Location location = employeeProfile.getLocation();
        if ( location == null ) {
            return null;
        }
        Long id = location.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
