--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.13
-- Dumped by pg_dump version 9.5.13

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE IF EXISTS wedding_secretary;
--
-- Name: wedding_secretary; Type: DATABASE; Schema: -; Owner: wedding_admin
--

CREATE DATABASE wedding_secretary WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'ru_RU.UTF-8' LC_CTYPE = 'ru_RU.UTF-8';


ALTER DATABASE wedding_secretary OWNER TO wedding_admin;

\connect wedding_secretary

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: articles; Type: TABLE; Schema: public; Owner: wedding_admin
--

CREATE TABLE public.articles (
    id integer NOT NULL,
    title text,
    text text,
    preview text,
    code text NOT NULL,
    icon_link text
);


ALTER TABLE public.articles OWNER TO wedding_admin;

--
-- Name: article_id_seq; Type: SEQUENCE; Schema: public; Owner: wedding_admin
--

CREATE SEQUENCE public.article_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.article_id_seq OWNER TO wedding_admin;

--
-- Name: article_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: wedding_admin
--

ALTER SEQUENCE public.article_id_seq OWNED BY public.articles.id;


--
-- Name: cities; Type: TABLE; Schema: public; Owner: wedding_admin
--

CREATE TABLE public.cities (
    id integer NOT NULL,
    code text NOT NULL,
    name text,
    time_zone_offset integer
);


ALTER TABLE public.cities OWNER TO wedding_admin;

--
-- Name: cities_id_seq; Type: SEQUENCE; Schema: public; Owner: wedding_admin
--

CREATE SEQUENCE public.cities_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cities_id_seq OWNER TO wedding_admin;

--
-- Name: cities_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: wedding_admin
--

ALTER SEQUENCE public.cities_id_seq OWNED BY public.cities.id;


--
-- Name: contacts; Type: TABLE; Schema: public; Owner: wedding_admin
--

CREATE TABLE public.contacts (
    code text NOT NULL,
    description text,
    icon_link text,
    type text,
    specialist_code text NOT NULL
);


ALTER TABLE public.contacts OWNER TO wedding_admin;

--
-- Name: images; Type: TABLE; Schema: public; Owner: wedding_admin
--

CREATE TABLE public.images (
    article_code text NOT NULL,
    link text NOT NULL
);


ALTER TABLE public.images OWNER TO wedding_admin;

--
-- Name: orders; Type: TABLE; Schema: public; Owner: wedding_admin
--

CREATE TABLE public.orders (
    id integer NOT NULL,
    name text,
    email text,
    phone text,
    partition text,
    city_code text,
    code text NOT NULL
);


ALTER TABLE public.orders OWNER TO wedding_admin;

--
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: wedding_admin
--

CREATE SEQUENCE public.orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orders_id_seq OWNER TO wedding_admin;

--
-- Name: orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: wedding_admin
--

ALTER SEQUENCE public.orders_id_seq OWNED BY public.orders.id;


--
-- Name: photo; Type: TABLE; Schema: public; Owner: wedding_admin
--

CREATE TABLE public.photo (
    specialist_code text NOT NULL,
    photo_link text NOT NULL
);


ALTER TABLE public.photo OWNER TO wedding_admin;

--
-- Name: professional_categories; Type: TABLE; Schema: public; Owner: wedding_admin
--

CREATE TABLE public.professional_categories (
    id integer NOT NULL,
    name text,
    description text,
    code text NOT NULL
);


ALTER TABLE public.professional_categories OWNER TO wedding_admin;

--
-- Name: professional_categories_id_seq; Type: SEQUENCE; Schema: public; Owner: wedding_admin
--

CREATE SEQUENCE public.professional_categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.professional_categories_id_seq OWNER TO wedding_admin;

--
-- Name: professional_categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: wedding_admin
--

ALTER SEQUENCE public.professional_categories_id_seq OWNED BY public.professional_categories.id;


--
-- Name: specialists; Type: TABLE; Schema: public; Owner: wedding_admin
--

CREATE TABLE public.specialists (
    id integer NOT NULL,
    name text,
    description text,
    category_code text,
    code text NOT NULL
);


ALTER TABLE public.specialists OWNER TO wedding_admin;

--
-- Name: specialists_id_seq; Type: SEQUENCE; Schema: public; Owner: wedding_admin
--

CREATE SEQUENCE public.specialists_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.specialists_id_seq OWNER TO wedding_admin;

--
-- Name: specialists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: wedding_admin
--

ALTER SEQUENCE public.specialists_id_seq OWNED BY public.specialists.id;


--
-- Name: video_links; Type: TABLE; Schema: public; Owner: wedding_admin
--

CREATE TABLE public.video_links (
    specialist_code text NOT NULL,
    video_link text NOT NULL
);


ALTER TABLE public.video_links OWNER TO wedding_admin;

--
-- Name: id; Type: DEFAULT; Schema: public; Owner: wedding_admin
--

ALTER TABLE ONLY public.articles ALTER COLUMN id SET DEFAULT nextval('public.article_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: wedding_admin
--

ALTER TABLE ONLY public.cities ALTER COLUMN id SET DEFAULT nextval('public.cities_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: wedding_admin
--

ALTER TABLE ONLY public.orders ALTER COLUMN id SET DEFAULT nextval('public.orders_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: wedding_admin
--

ALTER TABLE ONLY public.professional_categories ALTER COLUMN id SET DEFAULT nextval('public.professional_categories_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: wedding_admin
--

ALTER TABLE ONLY public.specialists ALTER COLUMN id SET DEFAULT nextval('public.specialists_id_seq'::regclass);


--
-- Name: article_id_seq; Type: SEQUENCE SET; Schema: public; Owner: wedding_admin
--

SELECT pg_catalog.setval('public.article_id_seq', 4, true);


--
-- Data for Name: articles; Type: TABLE DATA; Schema: public; Owner: wedding_admin
--

COPY public.articles (id, title, text, preview, code, icon_link) FROM stdin;
1	title	text	pr	1	1
\.


--
-- Data for Name: cities; Type: TABLE DATA; Schema: public; Owner: wedding_admin
--

COPY public.cities (id, code, name, time_zone_offset) FROM stdin;
1	123	Новосибирск	7
\.


--
-- Name: cities_id_seq; Type: SEQUENCE SET; Schema: public; Owner: wedding_admin
--

SELECT pg_catalog.setval('public.cities_id_seq', 4, true);


--
-- Data for Name: contacts; Type: TABLE DATA; Schema: public; Owner: wedding_admin
--

COPY public.contacts (code, description, icon_link, type, specialist_code) FROM stdin;
1	1	1	1	1
\.


--
-- Data for Name: images; Type: TABLE DATA; Schema: public; Owner: wedding_admin
--

COPY public.images (article_code, link) FROM stdin;
1	1
1	2
\.


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: wedding_admin
--

COPY public.orders (id, name, email, phone, partition, city_code, code) FROM stdin;
\.


--
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: wedding_admin
--

SELECT pg_catalog.setval('public.orders_id_seq', 5, true);


--
-- Data for Name: photo; Type: TABLE DATA; Schema: public; Owner: wedding_admin
--

COPY public.photo (specialist_code, photo_link) FROM stdin;
\.


--
-- Data for Name: professional_categories; Type: TABLE DATA; Schema: public; Owner: wedding_admin
--

COPY public.professional_categories (id, name, description, code) FROM stdin;
\.


--
-- Name: professional_categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: wedding_admin
--

SELECT pg_catalog.setval('public.professional_categories_id_seq', 22, true);


--
-- Data for Name: specialists; Type: TABLE DATA; Schema: public; Owner: wedding_admin
--

COPY public.specialists (id, name, description, category_code, code) FROM stdin;
\.


--
-- Name: specialists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: wedding_admin
--

SELECT pg_catalog.setval('public.specialists_id_seq', 25, true);


--
-- Data for Name: video_links; Type: TABLE DATA; Schema: public; Owner: wedding_admin
--

COPY public.video_links (specialist_code, video_link) FROM stdin;
\.


--
-- Name: article_pkey; Type: CONSTRAINT; Schema: public; Owner: wedding_admin
--

ALTER TABLE ONLY public.articles
    ADD CONSTRAINT article_pkey PRIMARY KEY (id);


--
-- Name: cities_pkey; Type: CONSTRAINT; Schema: public; Owner: wedding_admin
--

ALTER TABLE ONLY public.cities
    ADD CONSTRAINT cities_pkey PRIMARY KEY (id);


--
-- Name: contacts_code_specialist_code_pk; Type: CONSTRAINT; Schema: public; Owner: wedding_admin
--

ALTER TABLE ONLY public.contacts
    ADD CONSTRAINT contacts_code_specialist_code_pk PRIMARY KEY (code, specialist_code);


--
-- Name: image_link_table_code_link_pk; Type: CONSTRAINT; Schema: public; Owner: wedding_admin
--

ALTER TABLE ONLY public.images
    ADD CONSTRAINT image_link_table_code_link_pk PRIMARY KEY (article_code, link);


--
-- Name: orders_pkey; Type: CONSTRAINT; Schema: public; Owner: wedding_admin
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- Name: photes_specialist_code_photo_link_pk; Type: CONSTRAINT; Schema: public; Owner: wedding_admin
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT photes_specialist_code_photo_link_pk PRIMARY KEY (specialist_code, photo_link);


--
-- Name: professional_categories_pkey; Type: CONSTRAINT; Schema: public; Owner: wedding_admin
--

ALTER TABLE ONLY public.professional_categories
    ADD CONSTRAINT professional_categories_pkey PRIMARY KEY (id);


--
-- Name: specialists_pkey; Type: CONSTRAINT; Schema: public; Owner: wedding_admin
--

ALTER TABLE ONLY public.specialists
    ADD CONSTRAINT specialists_pkey PRIMARY KEY (id);


--
-- Name: video_links_specialist_code_video_link_pk; Type: CONSTRAINT; Schema: public; Owner: wedding_admin
--

ALTER TABLE ONLY public.video_links
    ADD CONSTRAINT video_links_specialist_code_video_link_pk PRIMARY KEY (specialist_code, video_link);


--
-- Name: article_id_uindex; Type: INDEX; Schema: public; Owner: wedding_admin
--

CREATE UNIQUE INDEX article_id_uindex ON public.articles USING btree (id);


--
-- Name: articles_code_uindex; Type: INDEX; Schema: public; Owner: wedding_admin
--

CREATE UNIQUE INDEX articles_code_uindex ON public.articles USING btree (code);


--
-- Name: cities_code_uindex; Type: INDEX; Schema: public; Owner: wedding_admin
--

CREATE UNIQUE INDEX cities_code_uindex ON public.cities USING btree (code);


--
-- Name: cities_id_uindex; Type: INDEX; Schema: public; Owner: wedding_admin
--

CREATE UNIQUE INDEX cities_id_uindex ON public.cities USING btree (id);


--
-- Name: contacts_code_uindex; Type: INDEX; Schema: public; Owner: wedding_admin
--

CREATE UNIQUE INDEX contacts_code_uindex ON public.contacts USING btree (code);


--
-- Name: contacts_specialist_code_uindex; Type: INDEX; Schema: public; Owner: wedding_admin
--

CREATE UNIQUE INDEX contacts_specialist_code_uindex ON public.contacts USING btree (specialist_code);


--
-- Name: orders_code_uindex; Type: INDEX; Schema: public; Owner: wedding_admin
--

CREATE UNIQUE INDEX orders_code_uindex ON public.orders USING btree (code);


--
-- Name: orders_id_uindex; Type: INDEX; Schema: public; Owner: wedding_admin
--

CREATE UNIQUE INDEX orders_id_uindex ON public.orders USING btree (id);


--
-- Name: photes_photo_link_uindex; Type: INDEX; Schema: public; Owner: wedding_admin
--

CREATE UNIQUE INDEX photes_photo_link_uindex ON public.photo USING btree (photo_link);


--
-- Name: photes_specialist_code_uindex; Type: INDEX; Schema: public; Owner: wedding_admin
--

CREATE UNIQUE INDEX photes_specialist_code_uindex ON public.photo USING btree (specialist_code);


--
-- Name: professional_categories_code_uindex; Type: INDEX; Schema: public; Owner: wedding_admin
--

CREATE UNIQUE INDEX professional_categories_code_uindex ON public.professional_categories USING btree (code);


--
-- Name: professional_categories_id_uindex; Type: INDEX; Schema: public; Owner: wedding_admin
--

CREATE UNIQUE INDEX professional_categories_id_uindex ON public.professional_categories USING btree (id);


--
-- Name: specialists_code_uindex; Type: INDEX; Schema: public; Owner: wedding_admin
--

CREATE UNIQUE INDEX specialists_code_uindex ON public.specialists USING btree (code);


--
-- Name: specialists_id_uindex; Type: INDEX; Schema: public; Owner: wedding_admin
--

CREATE UNIQUE INDEX specialists_id_uindex ON public.specialists USING btree (id);


--
-- Name: video_links_specialist_code_uindex; Type: INDEX; Schema: public; Owner: wedding_admin
--

CREATE UNIQUE INDEX video_links_specialist_code_uindex ON public.video_links USING btree (specialist_code);


--
-- Name: video_links_video_link_uindex; Type: INDEX; Schema: public; Owner: wedding_admin
--

CREATE UNIQUE INDEX video_links_video_link_uindex ON public.video_links USING btree (video_link);


--
-- Name: orders_cities_code_fk; Type: FK CONSTRAINT; Schema: public; Owner: wedding_admin
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_cities_code_fk FOREIGN KEY (city_code) REFERENCES public.cities(code);


--
-- Name: specialists_professional_categories_code_fk; Type: FK CONSTRAINT; Schema: public; Owner: wedding_admin
--

ALTER TABLE ONLY public.specialists
    ADD CONSTRAINT specialists_professional_categories_code_fk FOREIGN KEY (category_code) REFERENCES public.professional_categories(code);


--
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

