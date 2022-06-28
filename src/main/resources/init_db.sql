DROP TABLE IF EXISTS Student CASCADE;
CREATE TABLE student(
                        id SERIAL NOT NULL PRIMARY KEY,
                        first_name varchar NOT NULL,
                        last_name varchar NOT NULL,
                        email varchar NOT NULL,
                        password varchar NOT NULL,
                        house_id int NOT NULL,
                        points int NOT NULL
);

DROP TABLE IF EXISTS Teacher CASCADE;
CREATE TABLE Teacher(
                     id SERIAL NOT NULL PRIMARY KEY,
                     first_name varchar NOT NULL,
                     last_name varchar NOT NULL,
                     email varchar NOT NULL,
                     password varchar NOT NULL,
                     subject varchar NOT NULL
);

DROP TABLE IF EXISTS House CASCADE;
CREATE TABLE House(
                       id SERIAL NOT NULL PRIMARY KEY,
                       name varchar NOT NULL,
                       description varchar NOT NULL
);

ALTER TABLE ONLY Student
    ADD CONSTRAINT fk_house_id FOREIGN KEY (house_id) REFERENCES House(id);
