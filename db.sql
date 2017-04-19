CREATE TABLE users(
    ID SERIAL PRIMARY KEY, email VARCHAR(200) NOT NULL, fullname VARCHAR(50) NOT NULL, pass VARCHAR(50) NOT NULL
);

CREATE TABLE timestamps(
    ID SERIAL PRIMARY KEY, USER_ID INTEGER REFERENCES users, startDate TIMESTAMP NOT NULL, endDate TIMESTAMP
);


UPDATE users SET email = 'test@test.com', fullname = 'Test Testsson', pass = 'letmein' ;

ALTER TABLE timestamps ALTER startDate SET DEFAULT NOW();


INSERT INTO users (email, fullname, pass)
VALUES('ASDAD@SDFF.COM','EMMA LIEWENBORG','FISK');

INSERT INTO timestamps (USER_ID)
VALUES (1);

INSERT INTO timestamps (USER_ID, startDate)
VALUES (1, '2020-12-12 00:00:00');

SELECT * FROM timestamps;
SELECT * FROM users;