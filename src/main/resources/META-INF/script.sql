-- Table: public.autore

-- DROP TABLE public.autore;

CREATE SCHEMA public;

CREATE TABLE IF NOT EXISTS public.autore
(
    id integer NOT NULL,
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    cognome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    eta integer not NULL,
    CONSTRAINT autore_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.autore
    OWNER to postgres;
-- Table: public.libro

-- DROP TABLE public.libro;

CREATE TABLE IF NOT EXISTS public.libro
(
    id integer NOT NULL,
    titolo character varying(50) COLLATE pg_catalog."default" NOT NULL,
	numero_pagine integer NOT NULL,
    CONSTRAINT libro_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.libro
    OWNER to postgres;

--sequences
-- SEQUENCE: public.autore_sequence

-- DROP SEQUENCE public.autore_sequence;

CREATE SEQUENCE public.autore_sequence
    INCREMENT 1
    START 10
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.libro_sequence
    OWNER TO postgres;
    
