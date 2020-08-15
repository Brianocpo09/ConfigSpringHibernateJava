--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-08-15 10:44:01

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 16682)
-- Name: s_tipo_usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.s_tipo_usuario (
    codigo_tus integer NOT NULL,
    nombre_tus character varying(25)
);


ALTER TABLE public.s_tipo_usuario OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16680)
-- Name: s_tipo_usuario_codigoTus_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."s_tipo_usuario_codigoTus_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."s_tipo_usuario_codigoTus_seq" OWNER TO postgres;

--
-- TOC entry 2835 (class 0 OID 0)
-- Dependencies: 202
-- Name: s_tipo_usuario_codigoTus_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."s_tipo_usuario_codigoTus_seq" OWNED BY public.s_tipo_usuario.codigo_tus;


--
-- TOC entry 205 (class 1259 OID 16690)
-- Name: s_usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.s_usuario (
    codigo_usu integer NOT NULL,
    nombre_usu character varying(50),
    usuario_usu character varying(15),
    clave_usu character varying(10),
    estado_usu boolean,
    codigo_tus integer
);


ALTER TABLE public.s_usuario OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16688)
-- Name: s_usuario_codigo_usu_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.s_usuario_codigo_usu_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.s_usuario_codigo_usu_seq OWNER TO postgres;

--
-- TOC entry 2836 (class 0 OID 0)
-- Dependencies: 204
-- Name: s_usuario_codigo_usu_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.s_usuario_codigo_usu_seq OWNED BY public.s_usuario.codigo_usu;


--
-- TOC entry 2693 (class 2604 OID 16685)
-- Name: s_tipo_usuario codigo_tus; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.s_tipo_usuario ALTER COLUMN codigo_tus SET DEFAULT nextval('public."s_tipo_usuario_codigoTus_seq"'::regclass);


--
-- TOC entry 2694 (class 2604 OID 16693)
-- Name: s_usuario codigo_usu; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.s_usuario ALTER COLUMN codigo_usu SET DEFAULT nextval('public.s_usuario_codigo_usu_seq'::regclass);


--
-- TOC entry 2827 (class 0 OID 16682)
-- Dependencies: 203
-- Data for Name: s_tipo_usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.s_tipo_usuario (codigo_tus, nombre_tus) FROM stdin;
1	ROLE_ADMIN
\.


--
-- TOC entry 2829 (class 0 OID 16690)
-- Dependencies: 205
-- Data for Name: s_usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.s_usuario (codigo_usu, nombre_usu, usuario_usu, clave_usu, estado_usu, codigo_tus) FROM stdin;
1	admin	admin	\N	t	1
\.


--
-- TOC entry 2837 (class 0 OID 0)
-- Dependencies: 202
-- Name: s_tipo_usuario_codigoTus_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."s_tipo_usuario_codigoTus_seq"', 1, true);


--
-- TOC entry 2838 (class 0 OID 0)
-- Dependencies: 204
-- Name: s_usuario_codigo_usu_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.s_usuario_codigo_usu_seq', 1, true);


--
-- TOC entry 2696 (class 2606 OID 16687)
-- Name: s_tipo_usuario s_tipo_usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.s_tipo_usuario
    ADD CONSTRAINT s_tipo_usuario_pkey PRIMARY KEY (codigo_tus);


--
-- TOC entry 2698 (class 2606 OID 16695)
-- Name: s_usuario s_usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.s_usuario
    ADD CONSTRAINT s_usuario_pkey PRIMARY KEY (codigo_usu);


--
-- TOC entry 2699 (class 2606 OID 16696)
-- Name: s_usuario FK_s_usuario_vs_tipo_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.s_usuario
    ADD CONSTRAINT "FK_s_usuario_vs_tipo_usuario" FOREIGN KEY (codigo_usu) REFERENCES public.s_tipo_usuario(codigo_tus) NOT VALID;


-- Completed on 2020-08-15 10:44:02

--
-- PostgreSQL database dump complete
--

