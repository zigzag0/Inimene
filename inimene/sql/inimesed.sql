CREATE SEQUENCE inimene_id ;
CREATE TABLE inimesed
( inimene numeric(10,0) NOT NULL DEFAULT nextval('inimene_id'),
 name varchar(20),
number numeric(5,0),
 CONSTRAINT inimene_pk PRIMARY KEY (inimene)
) ;
INSERT INTO INIMESED (name,number) VALUES ('Andres',001);
INSERT INTO INIMESED (name,number) VALUES ('Liis',002);
INSERT INTO INIMESED (name,number) VALUES ('Huugo',003);
INSERT INTO INIMESED (name,number) VALUES ('Mari',004);
INSERT INTO INIMESED (name,number) VALUES ('Jaanek',005);

inimene_id - id
inimene_number - inimene_number
inimene_name1 - inimene_name1
inimene_name2 - inimene_name2
inimene_bday - inimene_bday