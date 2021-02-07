--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

-- Started on 2021-01-31 22:14:26

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3016 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 201 (class 1259 OID 16400)
-- Name: buyerscc; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.buyerscc (
    id_buyer integer NOT NULL,
    name_buyer character varying(25),
    surname_buyer character varying(25),
    acquisitions real,
    discount integer
);


ALTER TABLE public.buyerscc OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16395)
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employees (
    id_employee integer NOT NULL,
    name_empl character varying(25),
    surname_empl character varying(25),
    "position" character varying(20),
    age integer,
    salary double precision
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16405)
-- Name: product_groups; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_groups (
    id_group integer NOT NULL,
    group_name character varying(25),
    units_number integer
);


ALTER TABLE public.product_groups OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16410)
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id_product integer NOT NULL,
    name_product character varying(25),
    id_group integer,
    price double precision
);


ALTER TABLE public.products OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16420)
-- Name: sales; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sales (
    id_sale integer NOT NULL,
    id_product integer,
    discount integer
);


ALTER TABLE public.sales OWNER TO postgres;

--
-- TOC entry 3007 (class 0 OID 16400)
-- Dependencies: 201
-- Data for Name: buyerscc; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.buyerscc VALUES (1, 'Emelia', 'Finnegan', 24000, 10);
INSERT INTO public.buyerscc VALUES (2, 'Charles', 'Dixon', 51000, 15);


--
-- TOC entry 3006 (class 0 OID 16395)
-- Dependencies: 200
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employees VALUES (1, 'Virgil', 'Sanford', 'Director', 31, 14300);
INSERT INTO public.employees VALUES (2, 'Ellen', 'Rangel', 'Manager', 28, 11000);
INSERT INTO public.employees VALUES (3, 'Matthew', 'Witt', 'Vendor', 21, 4000);
INSERT INTO public.employees VALUES (4, 'Leela', 'Almond', 'Vendor', 23, 4500);


--
-- TOC entry 3008 (class 0 OID 16405)
-- Dependencies: 202
-- Data for Name: product_groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.product_groups VALUES (1, 'Laptop', 20);
INSERT INTO public.product_groups VALUES (2, 'Smartphones', 50);
INSERT INTO public.product_groups VALUES (3, 'Accessories', 78);


--
-- TOC entry 3009 (class 0 OID 16410)
-- Dependencies: 203
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.products VALUES (1, 'Asus_TUF', 1, 16000);
INSERT INTO public.products VALUES (2, 'Lenovo_Ideapad', 1, 9990);
INSERT INTO public.products VALUES (3, 'Samsung_Galaxy_20', 2, 19000);
INSERT INTO public.products VALUES (4, 'Xiaomi_Redmi_N8', 2, 3399);
INSERT INTO public.products VALUES (5, 'Mi_Band_3', 3, 599);
INSERT INTO public.products VALUES (6, 'JBL_Headphones', 3, 1400);


--
-- TOC entry 3010 (class 0 OID 16420)
-- Dependencies: 204
-- Data for Name: sales; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.sales VALUES (1, 1, 15);
INSERT INTO public.sales VALUES (2, 4, 10);
INSERT INTO public.sales VALUES (3, 5, 15);


--
-- TOC entry 2867 (class 2606 OID 16404)
-- Name: buyerscc buyerscc_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buyerscc
    ADD CONSTRAINT buyerscc_pk PRIMARY KEY (id_buyer);


--
-- TOC entry 2865 (class 2606 OID 16399)
-- Name: employees employees_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pk PRIMARY KEY (id_employee);


--
-- TOC entry 2869 (class 2606 OID 16409)
-- Name: product_groups product_groups_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_groups
    ADD CONSTRAINT product_groups_pk PRIMARY KEY (id_group);


--
-- TOC entry 2871 (class 2606 OID 16414)
-- Name: products products_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pk PRIMARY KEY (id_product);


--
-- TOC entry 2873 (class 2606 OID 16424)
-- Name: sales sales_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sales
    ADD CONSTRAINT sales_pk PRIMARY KEY (id_sale);


--
-- TOC entry 2874 (class 2606 OID 16440)
-- Name: products products_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_fk FOREIGN KEY (id_group) REFERENCES public.product_groups(id_group) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2875 (class 2606 OID 16435)
-- Name: sales sales_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sales
    ADD CONSTRAINT sales_fk FOREIGN KEY (id_product) REFERENCES public.products(id_product) ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2021-01-31 22:14:26

--
-- PostgreSQL database dump complete
--

