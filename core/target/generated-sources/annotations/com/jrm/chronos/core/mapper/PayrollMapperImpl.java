package com.jrm.chronos.core.mapper;

import com.jrm.chronos.core.dto.PayPeriodDto;
import com.jrm.chronos.core.dto.PaycheckDto;
import com.jrm.chronos.domain.EmployeeProfile;
import com.jrm.chronos.domain.PayPeriod;
import com.jrm.chronos.domain.Paycheck;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-14T23:19:20+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.11 (Termux)"
)
@Component
public class PayrollMapperImpl implements PayrollMapper {

    @Override
    public PayPeriodDto toDto(PayPeriod entity) {
        if ( entity == null ) {
            return null;
        }

        PayPeriodDto.PayPeriodDtoBuilder payPeriodDto = PayPeriodDto.builder();

        payPeriodDto.id( entity.getId() );
        payPeriodDto.startDate( entity.getStartDate() );
        payPeriodDto.endDate( entity.getEndDate() );
        payPeriodDto.processed( entity.isProcessed() );

        return payPeriodDto.build();
    }

    @Override
    public PaycheckDto toDto(Paycheck entity) {
        if ( entity == null ) {
            return null;
        }

        PaycheckDto.PaycheckDtoBuilder paycheckDto = PaycheckDto.builder();

        paycheckDto.employeeId( entityEmployeeId( entity ) );
        paycheckDto.payPeriodId( entityPayPeriodId( entity ) );
        paycheckDto.id( entity.getId() );
        paycheckDto.grossPay( entity.getGrossPay() );
        paycheckDto.netPay( entity.getNetPay() );
        paycheckDto.totalDeductions( entity.getTotalDeductions() );
        paycheckDto.issuedDate( entity.getIssuedDate() );

        paycheckDto.employeeName( entity.getEmployee().getFirstName() + " " + entity.getEmployee().getLastName() );

        return paycheckDto.build();
    }

    private Long entityEmployeeId(Paycheck paycheck) {
        if ( paycheck == null ) {
            return null;
        }
        EmployeeProfile employee = paycheck.getEmployee();
        if ( employee == null ) {
            return null;
        }
        Long id = employee.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityPayPeriodId(Paycheck paycheck) {
        if ( paycheck == null ) {
            return null;
        }
        PayPeriod payPeriod = paycheck.getPayPeriod();
        if ( payPeriod == null ) {
            return null;
        }
        Long id = payPeriod.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
