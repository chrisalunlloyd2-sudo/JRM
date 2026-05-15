package com.jrm.chronos.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPaycheck is a Querydsl query type for Paycheck
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPaycheck extends EntityPathBase<Paycheck> {

    private static final long serialVersionUID = -1563894282L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPaycheck paycheck = new QPaycheck("paycheck");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final QEmployeeProfile employee;

    public final NumberPath<java.math.BigDecimal> grossPay = createNumber("grossPay", java.math.BigDecimal.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> issuedDate = createDateTime("issuedDate", java.time.LocalDateTime.class);

    public final NumberPath<java.math.BigDecimal> netPay = createNumber("netPay", java.math.BigDecimal.class);

    public final StringPath notes = createString("notes");

    public final QPayPeriod payPeriod;

    public final NumberPath<java.math.BigDecimal> totalDeductions = createNumber("totalDeductions", java.math.BigDecimal.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QPaycheck(String variable) {
        this(Paycheck.class, forVariable(variable), INITS);
    }

    public QPaycheck(Path<? extends Paycheck> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPaycheck(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPaycheck(PathMetadata metadata, PathInits inits) {
        this(Paycheck.class, metadata, inits);
    }

    public QPaycheck(Class<? extends Paycheck> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.employee = inits.isInitialized("employee") ? new QEmployeeProfile(forProperty("employee"), inits.get("employee")) : null;
        this.payPeriod = inits.isInitialized("payPeriod") ? new QPayPeriod(forProperty("payPeriod")) : null;
    }

}

