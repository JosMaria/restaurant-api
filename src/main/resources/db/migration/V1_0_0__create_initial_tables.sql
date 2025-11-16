CREATE TABLE waiters (
    id BIGSERIAL  PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    lastname VARCHAR(100),
    phone_number VARCHAR(10)
);

CREATE TABLE tickets (
    id BIGSERIAL PRIMARY KEY,
    waiter_id BIGINT NOT NULL,
    CONSTRAINT fk_ticket_waiter FOREIGN KEY (waiter_id) REFERENCES waiters(id)
);
