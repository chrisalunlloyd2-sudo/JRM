CREATE TABLE pay_periods (
    id BIGSERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    processed BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);

CREATE TABLE time_entries (
    id BIGSERIAL PRIMARY KEY,
    employee_id BIGINT NOT NULL,
    shift_id BIGINT,
    clock_in TIMESTAMP NOT NULL,
    clock_out TIMESTAMP,
    total_hours DOUBLE PRECISION,
    notes TEXT,
    verified BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    FOREIGN KEY (employee_id) REFERENCES employee_profiles(id),
    FOREIGN KEY (shift_id) REFERENCES shifts(id)
);

CREATE TABLE paychecks (
    id BIGSERIAL PRIMARY KEY,
    employee_id BIGINT NOT NULL,
    pay_period_id BIGINT NOT NULL,
    gross_pay DECIMAL(19, 2) NOT NULL,
    net_pay DECIMAL(19, 2) NOT NULL,
    total_deductions DECIMAL(19, 2) NOT NULL,
    issued_date TIMESTAMP NOT NULL,
    notes TEXT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    FOREIGN KEY (employee_id) REFERENCES employee_profiles(id),
    FOREIGN KEY (pay_period_id) REFERENCES pay_periods(id)
);

-- Audit Tables for Payroll
CREATE TABLE pay_periods_aud (
    id BIGINT NOT NULL,
    rev INTEGER NOT NULL,
    revtype TINYINT,
    start_date DATE,
    end_date DATE,
    processed BOOLEAN,
    PRIMARY KEY (id, rev),
    FOREIGN KEY (rev) REFERENCES revinfo(rev)
);

CREATE TABLE time_entries_aud (
    id BIGINT NOT NULL,
    rev INTEGER NOT NULL,
    revtype TINYINT,
    employee_id BIGINT,
    shift_id BIGINT,
    clock_in TIMESTAMP,
    clock_out TIMESTAMP,
    verified BOOLEAN,
    PRIMARY KEY (id, rev),
    FOREIGN KEY (rev) REFERENCES revinfo(rev)
);

CREATE TABLE paychecks_aud (
    id BIGINT NOT NULL,
    rev INTEGER NOT NULL,
    revtype TINYINT,
    employee_id BIGINT,
    pay_period_id BIGINT,
    gross_pay DECIMAL(19, 2),
    net_pay DECIMAL(19, 2),
    PRIMARY KEY (id, rev),
    FOREIGN KEY (rev) REFERENCES revinfo(rev)
);
