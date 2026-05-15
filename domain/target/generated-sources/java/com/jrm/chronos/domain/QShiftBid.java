package com.jrm.chronos.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShiftBid is a Querydsl query type for ShiftBid
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShiftBid extends EntityPathBase<ShiftBid> {

    private static final long serialVersionUID = 832156081L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShiftBid shiftBid = new QShiftBid("shiftBid");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final DateTimePath<java.time.LocalDateTime> bidTime = createDateTime("bidTime", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final QEmployeeProfile employee;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath notes = createString("notes");

    public final QShift shift;

    public final EnumPath<com.jrm.chronos.domain.enums.BidStatus> status = createEnum("status", com.jrm.chronos.domain.enums.BidStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QShiftBid(String variable) {
        this(ShiftBid.class, forVariable(variable), INITS);
    }

    public QShiftBid(Path<? extends ShiftBid> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShiftBid(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShiftBid(PathMetadata metadata, PathInits inits) {
        this(ShiftBid.class, metadata, inits);
    }

    public QShiftBid(Class<? extends ShiftBid> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.employee = inits.isInitialized("employee") ? new QEmployeeProfile(forProperty("employee"), inits.get("employee")) : null;
        this.shift = inits.isInitialized("shift") ? new QShift(forProperty("shift"), inits.get("shift")) : null;
    }

}

