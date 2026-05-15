package com.jrm.chronos.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShift is a Querydsl query type for Shift
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShift extends EntityPathBase<Shift> {

    private static final long serialVersionUID = -1240554580L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShift shift = new QShift("shift");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final QDepartment department;

    public final DateTimePath<java.time.LocalDateTime> endTime = createDateTime("endTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QLocation location;

    public final StringPath notes = createString("notes");

    public final QRole requiredRole;

    public final DateTimePath<java.time.LocalDateTime> startTime = createDateTime("startTime", java.time.LocalDateTime.class);

    public final EnumPath<com.jrm.chronos.domain.enums.ShiftStatus> status = createEnum("status", com.jrm.chronos.domain.enums.ShiftStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QShift(String variable) {
        this(Shift.class, forVariable(variable), INITS);
    }

    public QShift(Path<? extends Shift> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShift(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShift(PathMetadata metadata, PathInits inits) {
        this(Shift.class, metadata, inits);
    }

    public QShift(Class<? extends Shift> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new QDepartment(forProperty("department"), inits.get("department")) : null;
        this.location = inits.isInitialized("location") ? new QLocation(forProperty("location")) : null;
        this.requiredRole = inits.isInitialized("requiredRole") ? new QRole(forProperty("requiredRole")) : null;
    }

}

