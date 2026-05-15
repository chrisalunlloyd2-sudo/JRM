package com.jrm.chronos.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmployeeProfile is a Querydsl query type for EmployeeProfile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmployeeProfile extends EntityPathBase<EmployeeProfile> {

    private static final long serialVersionUID = 821544389L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmployeeProfile employeeProfile = new QEmployeeProfile("employeeProfile");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final DatePath<java.time.LocalDate> dateOfBirth = createDate("dateOfBirth", java.time.LocalDate.class);

    public final QDepartment department;

    public final StringPath employeeNumber = createString("employeeNumber");

    public final StringPath firstName = createString("firstName");

    public final DatePath<java.time.LocalDate> hireDate = createDate("hireDate", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    public final QLocation location;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final QUser user;

    public QEmployeeProfile(String variable) {
        this(EmployeeProfile.class, forVariable(variable), INITS);
    }

    public QEmployeeProfile(Path<? extends EmployeeProfile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEmployeeProfile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEmployeeProfile(PathMetadata metadata, PathInits inits) {
        this(EmployeeProfile.class, metadata, inits);
    }

    public QEmployeeProfile(Class<? extends EmployeeProfile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new QDepartment(forProperty("department"), inits.get("department")) : null;
        this.location = inits.isInitialized("location") ? new QLocation(forProperty("location")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

