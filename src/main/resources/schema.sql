CREATE TABLE IF NOT EXISTS INSURANCE_TYPES
(
    id                           BIGINT PRIMARY KEY AUTO_INCREMENT,
    name                         VARCHAR(100) NOT NULL UNIQUE,
    description                  VARCHAR(200) NOT NULL,
    risk_percentage              DOUBLE       NOT NULL,
    coverage_amount_bottom_limit DOUBLE       NOT NULL,
    coverage_amount_top_limit    DOUBLE       NOT NULL,
    image_url                    TEXT
);

CREATE TABLE IF NOT EXISTS USERS
(
    id         BIGINT      NOT NULL IDENTITY PRIMARY KEY AUTO_INCREMENT,
    username   VARCHAR(50) NOT NULL UNIQUE,
    password   VARCHAR(50),
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    email      VARCHAR(50) NOT NULl UNIQUE,
    is_user    BOOLEAN     NOT NULL,
    is_admin   BOOLEAN     NOT NULL,
    is_active  BOOLEAN     NOT NULL
);
