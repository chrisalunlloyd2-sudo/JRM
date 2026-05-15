package com.jrm.chronos.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShiftAssignment is a Querydsl query type for ShiftAssignment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShiftAssignment extends EntityPathBase<ShiftAssignment> {

    private static final long serialVersionUID = 1476681625L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShiftAssignment shiftAssignment = new QShiftAssignment("shiftAssignment");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final DateTimePath<java.time.LocalDateTime> assignedAt = createDateTime("assignedAt", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final QEmployeeProfile employee;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath notes = createString("notes");

    public final QShift shift;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QShiftAssignment(String variable) {
        this(ShiftAssignment.class, forVariable(variable), INITS);
    }

    public QShiftAssignment(Path<? extends ShiftAssignment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShiftAssignment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShiftAssignment(PathMetadata metadata, PathInits inits) {
        this(ShiftAssignment.class, metadata, inits);
    }

    public QShiftAssignment(Class<? extends ShiftAssignment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.employee = inits.isInitialized("employee") ? new QEmployeeProfile(forProperty("employee"), inits.get("employee")) : null;
        this.shift = inits.isInitialized("shift") ? new QShift(forProperty("shift"), inits.get("shift")) : null;
    }

}

