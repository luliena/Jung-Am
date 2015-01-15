-- NOTICES TABLE
CREATE SEQUENCE auto_notices_increment_seq;
CREATE TABLE NOTICES (
INDEX INT NOT NULL DEFAULT nextval('auto_notices_increment_seq'::regclass) primary key,
TITLE VARCHAR(80) NOT NULL,
WRITER VARCHAR(50) NOT NULL,
CONTENT TEXT,
HITCOUNT INT DEFAULT 0 );

insert into notices(title, writer, content, hitcount) values('aaa', 'bbb', 'akjdfkjakdf', 0);
commit;

drop table notices;
-- USERS TABLE
