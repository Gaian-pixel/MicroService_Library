CREATE DATABASE "customer" OWNER postgres;
\connect customer
ALTER DATABASE "customer" SET TIMEZONE TO 'Europe/Rome';
SET TIMEZONE TO 'Europe/Rome';

CREATE TABLE "customers"
(
    customer_id integer PRIMARY KEY,
    name character varying NOT NULL,
    surname character varying NOT NULL,
    address character varying,
    telephone character varying
) TABLESPACE pg_default;

ALTER TABLE "customers"
    OWNER to postgres;
