CREATE TABLE shifts (
    id BIGSERIAL PRIMARY KEY,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    location_id BIGINT NOT NULL,
    department_id BIGINT NOT NULL,
    required_role_id BIGINT NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'OPEN',
    notes TEXT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    FOREIGN KEY (location_id) REFERENCES locations(id),
    FOREIGN KEY (department_id) REFERENCES departments(id),
    FOREIGN KEY (required_role_id) REFERENCES roles(id)
);

CREATE TABLE shift_assignments (
    id BIGSERIAL PRIMARY KEY,
    shift_id BIGINT NOT NULL UNIQUE,
    employee_id BIGINT NOT NULL,
    assigned_at TIMESTAMP NOT NULL,
    notes TEXT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    FOREIGN KEY (shift_id) REFERENCES shifts(id),
    FOREIGN KEY (employee_id) REFERENCES employee_profiles(id)
);

CREATE TABLE shift_bids (
    id BIGSERIAL PRIMARY KEY,
    shift_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    bid_time TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    notes TEXT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    FOREIGN KEY (shift_id) REFERENCES shifts(id),
    FOREIGN KEY (employee_id) REFERENCES employee_profiles(id)
);

-- Audit Tables for Scheduling
CREATE TABLE shifts_aud (
    id BIGINT NOT NULL,
    rev INTEGER NOT NULL,
    revtype TINYINT,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    location_id BIGINT,
    department_id BIGINT,
    required_role_id BIGINT,
    status VARCHAR(20),
    PRIMARY KEY (id, rev),
    FOREIGN KEY (rev) REFERENCES revinfo(rev)
);

CREATE TABLE shift_assignments_aud (
    id BIGINT NOT NULL,
    rev INTEGER NOT NULL,
    revtype TINYINT,
    shift_id BIGINT,
    employee_id BIGINT,
    PRIMARY KEY (id, rev),
    FOREIGN KEY (rev) REFERENCES revinfo(rev)
);

CREATE TABLE shift_bids_aud (
    id BIGINT NOT NULL,
    rev INTEGER NOT NULL,
    revtype TINYINT,
    shift_id BIGINT,
    employee_id BIGINT,
    status VARCHAR(20),
    PRIMARY KEY (id, rev),
    FOREIGN KEY (rev) REFERENCES revinfo(rev)
);
