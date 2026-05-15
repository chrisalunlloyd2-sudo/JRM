package com.jrm.chronos.core.mapper;

import com.jrm.chronos.core.dto.TimeEntryDto;
import com.jrm.chronos.domain.EmployeeProfile;
import com.jrm.chronos.domain.Shift;
import com.jrm.chronos.domain.TimeEntry;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-14T23:19:19+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.11 (Termux)"
)
@Component
public class TimeEntryMapperImpl implements TimeEntryMapper {

    @Override
    public TimeEntryDto toDto(TimeEntry entity) {
        if ( entity == null ) {
            return null;
        }

        TimeEntryDto.TimeEntryDtoBuilder timeEntryDto = TimeEntryDto.builder();

        timeEntryDto.employeeId( entityEmployeeId( entity ) );
        timeEntryDto.shiftId( entityShiftId( entity ) );
        timeEntryDto.id( entity.getId() );
        timeEntryDto.clockIn( entity.getClockIn() );
        timeEntryDto.clockOut( entity.getClockOut() );
        timeEntryDto.totalHours( entity.getTotalHours() );
        timeEntryDto.verified( entity.isVerified() );
        timeEntryDto.notes( entity.getNotes() );

        timeEntryDto.employeeName( entity.getEmployee().getFirstName() + " " + entity.getEmployee().getLastName() );

        return timeEntryDto.build();
    }

    private Long entityEmployeeId(TimeEntry timeEntry) {
        if ( timeEntry == null ) {
            return null;
        }
        EmployeeProfile employee = timeEntry.getEmployee();
        if ( employee == null ) {
            return null;
        }
        Long id = employee.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityShiftId(TimeEntry timeEntry) {
        if ( timeEntry == null ) {
            return null;
        }
        Shift shift = timeEntry.getShift();
        if ( shift == null ) {
            return null;
        }
        Long id = shift.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
