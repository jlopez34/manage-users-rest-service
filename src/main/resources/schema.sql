DROP TABLE IF EXISTS USERS_PHONES;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS PHONES;

CREATE TABLE USERS(
        user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL,
        created TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
        modified TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
        last_login TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
        token VARCHAR(500) NOT NULL,
        active BOOLEAN NOT NULL
);

CREATE TABLE PHONES(
        phone_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        number VARCHAR(255) NOT NULL,
        city_code VARCHAR(255) NOT NULL,
        country_code VARCHAR(255) NOT NULL
);

CREATE TABLE USERS_PHONES(
          USER_USER_ID INT NOT NULL,
          PHONES_PHONE_ID INT NOT NULL,
          PRIMARY KEY (USER_USER_ID, PHONES_PHONE_ID),
          FOREIGN KEY (USER_USER_ID) REFERENCES USERS (user_id),
          FOREIGN KEY (PHONES_PHONE_ID) REFERENCES PHONES (phone_id)
);


INSERT INTO USERS (name, email, password, created, modified, last_login, token, active) VALUES
('Juan Rodriguez','juan@rodiguez.org', 'hunter2', now(), now(), now(), 'token', 1);

INSERT INTO PHONES (number, city_code, country_code) VALUES ('12312313','1', '57');
INSERT INTO PHONES (number, city_code, country_code) VALUES ('12312313','2', '56');

INSERT INTO USERS_PHONES (USER_USER_ID, PHONES_PHONE_ID) VALUES (1,1);
INSERT INTO USERS_PHONES (USER_USER_ID, PHONES_PHONE_ID) VALUES (1,2);
