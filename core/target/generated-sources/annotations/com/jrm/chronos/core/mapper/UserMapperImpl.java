package com.jrm.chronos.core.mapper;

import com.jrm.chronos.core.dto.RoleDto;
import com.jrm.chronos.core.dto.UserDto;
import com.jrm.chronos.domain.Role;
import com.jrm.chronos.domain.User;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-14T23:19:20+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.11 (Termux)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.id( user.getId() );
        userDto.username( user.getUsername() );
        userDto.email( user.getEmail() );
        userDto.enabled( user.isEnabled() );
        userDto.roles( roleSetToRoleDtoSet( user.getRoles() ) );

        return userDto.build();
    }

    @Override
    public RoleDto toDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto.RoleDtoBuilder roleDto = RoleDto.builder();

        roleDto.id( role.getId() );
        roleDto.name( role.getName() );

        return roleDto.build();
    }

    protected Set<RoleDto> roleSetToRoleDtoSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleDto> set1 = new LinkedHashSet<RoleDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( toDto( role ) );
        }

        return set1;
    }
}
