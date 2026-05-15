package com.jrm.chronos.core.mapper;

import com.jrm.chronos.core.dto.ShiftAssignmentDto;
import com.jrm.chronos.core.dto.ShiftCreateDto;
import com.jrm.chronos.core.dto.ShiftDto;
import com.jrm.chronos.domain.Department;
import com.jrm.chronos.domain.EmployeeProfile;
import com.jrm.chronos.domain.Location;
import com.jrm.chronos.domain.Role;
import com.jrm.chronos.domain.Shift;
import com.jrm.chronos.domain.ShiftAssignment;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-14T23:19:20+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.11 (Termux)"
)
@Component
public class ShiftMapperImpl implements ShiftMapper {

    @Override
    public ShiftDto toDto(Shift entity) {
        if ( entity == null ) {
            return null;
        }

        ShiftDto.ShiftDtoBuilder shiftDto = ShiftDto.builder();

        shiftDto.locationId( entityLocationId( entity ) );
        shiftDto.locationName( entityLocationName( entity ) );
        shiftDto.departmentId( entityDepartmentId( entity ) );
        shiftDto.departmentName( entityDepartmentName( entity ) );
        shiftDto.requiredRoleId( entityRequiredRoleId( entity ) );
        shiftDto.requiredRoleName( entityRequiredRoleName( entity ) );
        shiftDto.id( entity.getId() );
        shiftDto.startTime( entity.getStartTime() );
        shiftDto.endTime( entity.getEndTime() );
        shiftDto.status( entity.getStatus() );
        shiftDto.notes( entity.getNotes() );

        return shiftDto.build();
    }

    @Override
    public Shift toEntity(ShiftCreateDto dto) {
        if ( dto == null ) {
            return null;
        }

        Shift.ShiftBuilder shift = Shift.builder();

        shift.location( shiftCreateDtoToLocation( dto ) );
        shift.department( shiftCreateDtoToDepartment( dto ) );
        shift.requiredRole( shiftCreateDtoToRole( dto ) );
        shift.startTime( dto.getStartTime() );
        shift.endTime( dto.getEndTime() );
        shift.notes( dto.getNotes() );

        return shift.build();
    }

    @Override
    public ShiftAssignmentDto toDto(ShiftAssignment entity) {
        if ( entity == null ) {
            return null;
        }

        ShiftAssignmentDto.ShiftAssignmentDtoBuilder shiftAssignmentDto = ShiftAssignmentDto.builder();

        shiftAssignmentDto.shiftId( entityShiftId( entity ) );
        shiftAssignmentDto.employeeId( entityEmployeeId( entity ) );
        shiftAssignmentDto.id( entity.getId() );
        shiftAssignmentDto.assignedAt( entity.getAssignedAt() );
        shiftAssignmentDto.notes( entity.getNotes() );

        shiftAssignmentDto.employeeName( entity.getEmployee().getFirstName() + " " + entity.getEmployee().getLastName() );

        return shiftAssignmentDto.build();
    }

    private Long entityLocationId(Shift shift) {
        if ( shift == null ) {
            return null;
        }
        Location location = shift.getLocation();
        if ( location == null ) {
            return null;
        }
        Long id = location.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityLocationName(Shift shift) {
        if ( shift == null ) {
            return null;
        }
        Location location = shift.getLocation();
        if ( location == null ) {
            return null;
        }
        String name = location.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long entityDepartmentId(Shift shift) {
        if ( shift == null ) {
            return null;
        }
        Department department = shift.getDepartment();
        if ( department == null ) {
            return null;
        }
        Long id = department.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityDepartmentName(Shift shift) {
        if ( shift == null ) {
            return null;
        }
        Department department = shift.getDepartment();
        if ( department == null ) {
            return null;
        }
        String name = department.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long entityRequiredRoleId(Shift shift) {
        if ( shift == null ) {
            return null;
        }
        Role requiredRole = shift.getRequiredRole();
        if ( requiredRole == null ) {
            return null;
        }
        Long id = requiredRole.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityRequiredRoleName(Shift shift) {
        if ( shift == null ) {
            return null;
        }
        Role requiredRole = shift.getRequiredRole();
        if ( requiredRole == null ) {
            return null;
        }
        String name = requiredRole.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    protected Location shiftCreateDtoToLocation(ShiftCreateDto shiftCreateDto) {
        if ( shiftCreateDto == null ) {
            return null;
        }

        Location.LocationBuilder location = Location.builder();

        location.id( shiftCreateDto.getLocationId() );

        return location.build();
    }

    protected Department shiftCreateDtoToDepartment(ShiftCreateDto shiftCreateDto) {
        if ( shiftCreateDto == null ) {
            return null;
        }

        Department.DepartmentBuilder department = Department.builder();

        department.id( shiftCreateDto.getDepartmentId() );

        return department.build();
    }

    protected Role shiftCreateDtoToRole(ShiftCreateDto shiftCreateDto) {
        if ( shiftCreateDto == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.id( shiftCreateDto.getRequiredRoleId() );

        return role.build();
    }

    private Long entityShiftId(ShiftAssignment shiftAssignment) {
        if ( shiftAssignment == null ) {
            return null;
        }
        Shift shift = shiftAssignment.getShift();
        if ( shift == null ) {
            return null;
        }
        Long id = shift.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityEmployeeId(ShiftAssignment shiftAssignment) {
        if ( shiftAssignment == null ) {
            return null;
        }
        EmployeeProfile employee = shiftAssignment.getEmployee();
        if ( employee == null ) {
            return null;
        }
        Long id = employee.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
