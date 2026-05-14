package com.jrm.chronos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;

@Entity
@Table(name = "time_entries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class TimeEntry extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeProfile employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_id")
    private Shift shift;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime clockIn;

    private LocalDateTime clockOut;

    private Double totalHours;

    private String notes;

    @Builder.Default
    private boolean verified = false;
}
