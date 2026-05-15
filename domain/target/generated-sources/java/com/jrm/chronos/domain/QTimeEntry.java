package com.jrm.chronos.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTimeEntry is a Querydsl query type for TimeEntry
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTimeEntry extends EntityPathBase<TimeEntry> {

    private static final long serialVersionUID = -853274673L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTimeEntry timeEntry = new QTimeEntry("timeEntry");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final DateTimePath<java.time.LocalDateTime> clockIn = createDateTime("clockIn", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> clockOut = createDateTime("clockOut", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final QEmployeeProfile employee;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath notes = createString("notes");

    public final QShift shift;

    public final NumberPath<Double> totalHours = createNumber("totalHours", Double.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final BooleanPath verified = createBoolean("verified");

    public QTimeEntry(String variable) {
        this(TimeEntry.class, forVariable(variable), INITS);
    }

    public QTimeEntry(Path<? extends TimeEntry> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTimeEntry(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTimeEntry(PathMetadata metadata, PathInits inits) {
        this(TimeEntry.class, metadata, inits);
    }

    public QTimeEntry(Class<? extends TimeEntry> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.employee = inits.isInitialized("employee") ? new QEmployeeProfile(forProperty("employee"), inits.get("employee")) : null;
        this.shift = inits.isInitialized("shift") ? new QShift(forProperty("shift"), inits.get("shift")) : null;
    }

}

