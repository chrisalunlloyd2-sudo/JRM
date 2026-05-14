package com.jrm.chronos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.envers.Audited;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "paychecks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class Paycheck extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeProfile employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pay_period_id", nullable = false)
    private PayPeriod payPeriod;

    @NotNull
    private BigDecimal grossPay;

    @NotNull
    private BigDecimal netPay;

    @NotNull
    private BigDecimal totalDeductions;

    @NotNull
    @Builder.Default
    private LocalDateTime issuedDate = LocalDateTime.now();

    private String notes;
}
