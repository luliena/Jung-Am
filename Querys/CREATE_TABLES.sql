-- NOTICES TABLE
CREATE SEQUENCE auto_notices_increment_seq;
CREATE TABLE notices
(
  index integer NOT NULL DEFAULT nextval('auto_notices_increment_seq'::regclass),
  title character varying(80) NOT NULL,
  writer character varying(50) NOT NULL,
  content text,
  hitcount integer DEFAULT 0,
  regidate date NOT NULL DEFAULT now(),
  CONSTRAINT notices_pkey PRIMARY KEY (index)
);


-- NOTICE_FILES TABLE
CREATE SEQUENCE auto_notice_files_increment_seq;
CREATE TABLE notice_files
(
  fileno integer NOT NULL DEFAULT nextval('auto_notices_increment_seq'::regclass),
  index integer NOT NULL,
  path character varying(250) NOT NULL,
  filename character varying(200) NOT NULL,
  contenttype character varying(100),
  CONSTRAINT notice_files_pkey PRIMARY KEY (fileno)
);

CREATE TABLE USERS
(
	ID character varying(50) NOT NULL,
	PASSWORD character varying(50) NOT NULL,
	USER_NAME character varying(50) NOT NULL,
	EMAIL character varying(100),
	PHONE character varying(50),
	LEVELS character varying(5) NOT NULL,
	LAST_DATE date,
	CONSTRAINT users_pkey PRIMARY KEY (id)
)