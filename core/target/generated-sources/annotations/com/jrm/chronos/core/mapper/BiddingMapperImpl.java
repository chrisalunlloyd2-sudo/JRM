package com.jrm.chronos.core.mapper;

import com.jrm.chronos.core.dto.ShiftBidDto;
import com.jrm.chronos.domain.EmployeeProfile;
import com.jrm.chronos.domain.Shift;
import com.jrm.chronos.domain.ShiftBid;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-14T23:19:20+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.11 (Termux)"
)
@Component
public class BiddingMapperImpl implements BiddingMapper {

    @Override
    public ShiftBidDto toDto(ShiftBid entity) {
        if ( entity == null ) {
            return null;
        }

        ShiftBidDto.ShiftBidDtoBuilder shiftBidDto = ShiftBidDto.builder();

        shiftBidDto.shiftId( entityShiftId( entity ) );
        shiftBidDto.employeeId( entityEmployeeId( entity ) );
        shiftBidDto.id( entity.getId() );
        shiftBidDto.bidTime( entity.getBidTime() );
        shiftBidDto.status( entity.getStatus() );
        shiftBidDto.notes( entity.getNotes() );

        shiftBidDto.employeeName( entity.getEmployee().getFirstName() + " " + entity.getEmployee().getLastName() );

        return shiftBidDto.build();
    }

    private Long entityShiftId(ShiftBid shiftBid) {
        if ( shiftBid == null ) {
            return null;
        }
        Shift shift = shiftBid.getShift();
        if ( shift == null ) {
            return null;
        }
        Long id = shift.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityEmployeeId(ShiftBid shiftBid) {
        if ( shiftBid == null ) {
            return null;
        }
        EmployeeProfile employee = shiftBid.getEmployee();
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
