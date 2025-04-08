CREATE TABLE users(
    user_id INTEGER NOT NULL PRIMARY KEY,
    username    VARCHAR(255) NOT NULL,
    email    VARCHAR(255),
    password VARCHAR(255),
    city VARCHAR(255),
    country  VARCHAR(255)
);

CREATE TABLE puzzles(
    puzzle_id INTEGER NOT NULL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    category VARCHAR(255),
    company VARCHAR(255),
    pieces_number INTEGER
);

CREATE TABLE completed(
    completed_id INTEGER NOT NULL PRIMARY KEY ,
    user_id INTEGER NOT NULL REFERENCES users,
    puzzle_id INTEGER NOT NULL REFERENCES puzzles,
    date DATE NOT NULL,
    time TIME NOT NULL,
    first_time BOOLEAN NOT NULL
);

