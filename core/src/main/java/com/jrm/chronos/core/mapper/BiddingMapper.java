package com.jrm.chronos.core.mapper;

import com.jrm.chronos.core.dto.ShiftBidDto;
import com.jrm.chronos.domain.ShiftBid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BiddingMapper {
    @Mapping(target = "shiftId", source = "shift.id")
    @Mapping(target = "employeeId", source = "employee.id")
    @Mapping(target = "employeeName", expression = "java(entity.getEmployee().getFirstName() + \" \" + entity.getEmployee().getLastName())")
    ShiftBidDto toDto(ShiftBid entity);
}
