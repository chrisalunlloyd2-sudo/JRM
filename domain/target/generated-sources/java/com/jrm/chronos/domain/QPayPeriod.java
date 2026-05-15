package com.jrm.chronos.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPayPeriod is a Querydsl query type for PayPeriod
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPayPeriod extends EntityPathBase<PayPeriod> {

    private static final long serialVersionUID = -1782413645L;

    public static final QPayPeriod payPeriod = new QPayPeriod("payPeriod");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final DatePath<java.time.LocalDate> endDate = createDate("endDate", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath processed = createBoolean("processed");

    public final DatePath<java.time.LocalDate> startDate = createDate("startDate", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QPayPeriod(String variable) {
        super(PayPeriod.class, forVariable(variable));
    }

    public QPayPeriod(Path<? extends PayPeriod> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPayPeriod(PathMetadata metadata) {
        super(PayPeriod.class, metadata);
    }

}

