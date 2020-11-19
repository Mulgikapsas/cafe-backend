CREATE TABLE items
(
    id      INT PRIMARY KEY NOT NULL,
    payload JSONB           NOT NULL
);

CREATE TABLE customers
(
    uid  INT PRIMARY KEY NOT NULL,
    name TEXT            NOT NULL
);

CREATE TABLE assignees
(
    uid  INT PRIMARY KEY NOT NULL,
    name TEXT            NOT NULL
);

CREATE TABLE orders
(
    id      INT PRIMARY KEY NOT NULL,
    payload JSONB           NOT NULL
);
