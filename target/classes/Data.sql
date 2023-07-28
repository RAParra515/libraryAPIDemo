DROP TABLE IF EXISTS CUSTOMER;
DROP TABLE IF EXISTS BOOK; 
DROP TABLE IF EXISTS RENTAL;
CREATE TABLE CUSTOMER(ID INT PRIMARY KEY, NAME VARCHAR(255),LAST_NAME VARCHAR(255),ADDRESS VARCHAR(255));
CREATE TABLE BOOK(ID INT PRIMARY KEY, TITLE VARCHAR(255),COPYS INT);
CREATE TABLE RENTAL (ID INT PRIMARY KEY, BOOK_ID INT,START DATE,END DATE);
INSERT INTO BOOK (ID,TITLE,COPYS) VALUES (1,'El quijote de la mancha' , 5);
INSERT INTO BOOK (ID,TITLE,COPYS) VALUES (2,'El Señor de los anillos' , 5);
INSERT INTO CUSTOMER (ID,NAME,LAST_NAME,ADDRESS) VALUES (1,'ALONSO','MAGARZO' ,'MADRID');
INSERT INTO CUSTOMER (ID,NAME,LAST_NAME,ADDRESS) VALUES (2,'ROBERTO','PARRA' ,'QUITO');