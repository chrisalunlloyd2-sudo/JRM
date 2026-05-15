package com.jrm.chronos.core.mapper;

import com.jrm.chronos.core.dto.DepartmentDto;
import com.jrm.chronos.core.dto.LocationDto;
import com.jrm.chronos.domain.Department;
import com.jrm.chronos.domain.Location;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-14T23:19:20+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.11 (Termux)"
)
@Component
public class OrganizationMapperImpl implements OrganizationMapper {

    @Override
    public LocationDto toDto(Location location) {
        if ( location == null ) {
            return null;
        }

        LocationDto.LocationDtoBuilder locationDto = LocationDto.builder();

        locationDto.id( location.getId() );
        locationDto.name( location.getName() );
        locationDto.address( location.getAddress() );

        return locationDto.build();
    }

    @Override
    public Location toEntity(LocationDto locationDto) {
        if ( locationDto == null ) {
            return null;
        }

        Location.LocationBuilder location = Location.builder();

        location.id( locationDto.getId() );
        location.name( locationDto.getName() );
        location.address( locationDto.getAddress() );

        return location.build();
    }

    @Override
    public DepartmentDto toDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto.DepartmentDtoBuilder departmentDto = DepartmentDto.builder();

        departmentDto.locationId( departmentLocationId( department ) );
        departmentDto.id( department.getId() );
        departmentDto.name( department.getName() );

        return departmentDto.build();
    }

    @Override
    public Department toEntity(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department.DepartmentBuilder department = Department.builder();

        department.location( departmentDtoToLocation( departmentDto ) );
        department.id( departmentDto.getId() );
        department.name( departmentDto.getName() );

        return department.build();
    }

    private Long departmentLocationId(Department department) {
        if ( department == null ) {
            return null;
        }
        Location location = department.getLocation();
        if ( location == null ) {
            return null;
        }
        Long id = location.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Location departmentDtoToLocation(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Location.LocationBuilder location = Location.builder();

        location.id( departmentDto.getLocationId() );

        return location.build();
    }
}
