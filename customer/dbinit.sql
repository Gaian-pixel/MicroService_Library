CREATE DATABASE "customer" OWNER mariadb;
\connect customer
ALTER DATABASE "customer" SET TIMEZONE TO 'Europe/Rome';
SET TIMEZONE TO 'Europe/Rome';

CREATE TABLE "customers"
(
    customer_id character varying,
    name character varying,
    surname character varying,
    address character varying,
    telNum character varying
) TABLESPACE pg_default;

ALTER TABLE "customers"
    OWNER to mariadb;
