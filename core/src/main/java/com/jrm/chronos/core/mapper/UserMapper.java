package com.jrm.chronos.core.mapper;

import com.jrm.chronos.core.dto.RoleDto;
import com.jrm.chronos.core.dto.UserDto;
import com.jrm.chronos.domain.Role;
import com.jrm.chronos.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserDto toDto(User user);
    RoleDto toDto(Role role);
}
