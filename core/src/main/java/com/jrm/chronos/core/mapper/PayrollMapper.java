package com.jrm.chronos.core.mapper;

import com.jrm.chronos.core.dto.PayPeriodDto;
import com.jrm.chronos.core.dto.PaycheckDto;
import com.jrm.chronos.domain.PayPeriod;
import com.jrm.chronos.domain.Paycheck;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PayrollMapper {
    PayPeriodDto toDto(PayPeriod entity);
    
    @Mapping(target = "employeeId", source = "employee.id")
    @Mapping(target = "employeeName", expression = "java(entity.getEmployee().getFirstName() + \" \" + entity.getEmployee().getLastName())")
    @Mapping(target = "payPeriodId", source = "payPeriod.id")
    PaycheckDto toDto(Paycheck entity);
}
