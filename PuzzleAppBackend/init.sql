CREATE TABLE users(
    user_id INTEGER NOT NULL PRIMARY KEY,
    username    VARCHAR(255) NOT NULL,
    email    VARCHAR(255),
    password VARCHAR(255),
    country  VARCHAR(255)
);

CREATE TABLE puzzles(
    puzzle_id INTEGER NOT NULL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    category VARCHAR(255),
    company VARCHAR(255),
    pieces_number INTEGER,
    image_url TEXT
);

CREATE TABLE completed(
    completed_id INTEGER NOT NULL PRIMARY KEY ,
    user_id INTEGER NOT NULL REFERENCES users,
    puzzle_id INTEGER NOT NULL REFERENCES puzzles,
    date DATE NOT NULL,
    time TIME NOT NULL,
    first_time BOOLEAN NOT NULL
);

INSERT INTO users VALUES (1, 'Aaaa', 'a@example.com', null, 'Poland');
INSERT INTO users VALUES (2, 'Bbbb', 'b@example.com', null, 'Poland');
INSERT INTO users VALUES (3, 'Cccc', 'c@example.com', null, 'Poland');
INSERT INTO users VALUES (4, 'Dddd', 'd@example.com', null, 'Poland');

INSERT INTO puzzles VALUES (1, 'Beautiful landscape', 'landscapes', 'Ravensburger', 500, 'url-1');
INSERT INTO puzzles VALUES (2, 'Beautiful landscape 2', 'landscapes', 'Ravensburger', 1000, 'url-2');


