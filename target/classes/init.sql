CREATE TABLE IF NOT EXISTS USERS
(
    id BIGINT PRIMARY KEY,
    name VARCHAR(50),
    lastName VARCHAR(50),
    age      INT
);

INSERT INTO USERS (id, name, lastName, age)
VALUES (1, 'John', 'Doe', 30),
       (2, 'Alice', 'Smith', 25),
       (3, 'Bob', 'Johnson', 40),
       (4, 'Emily', 'Brown', 35),
       (5, 'Michael', 'Davis', 28),
       (6, 'Sarah', 'Wilson', 33),
       (7, 'David', 'Martinez', 45),
       (8, 'Jennifer', 'Taylor', 27),
       (9, 'Christopher', 'Anderson', 38),
       (10, 'Jessica', 'Thomas', 31);
