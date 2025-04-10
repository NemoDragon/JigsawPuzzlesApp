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

INSERT INTO puzzles VALUES (1, 'Beautiful landscape', 'landscapes', 'Ravensburger', 500, 'https://www.jigsawexplorer.com/puzzles/subjects/dolmites-landscape-500x252.jpg');
INSERT INTO puzzles VALUES (2, 'Beautiful landscape 2', 'landscapes', 'Ravensburger', 1000, 'https://images.fineartamerica.com/images/artworkimages/medium/1/6-seceda-italy-joana-kruse.jpg');
INSERT INTO puzzles VALUES (3, 'Dog', 'animals', 'Ravensburger', 500, 'https://m.media-amazon.com/images/I/516cyIvD4gL._AC_UF894,1000_QL80_.jpg');
INSERT INTO puzzles VALUES (4, 'Marzamemi, Sicily', 'landscapes', 'Ravensburger', 500, 'https://img.myspeedpuzzling.com/puzzle/thumbnails/puzzle_medium/ravensburger-marzamemi-500.jpg');
INSERT INTO puzzles VALUES (5, 'Spring in Paris', 'cities', 'Ravensburger', 500, 'https://img.myspeedpuzzling.com/puzzle/thumbnails/puzzle_medium/ravensburger-paris-500.jpeg');
INSERT INTO puzzles VALUES (6, 'Floral Reflections', 'nature', 'Ravensburger', 500, 'https://img.myspeedpuzzling.com/puzzle/thumbnails/puzzle_medium/ravensburger-floral-reflections-500.jpeg');
INSERT INTO puzzles VALUES (7, 'Rainbow Cats', 'animals', 'Ravensburger', 500, 'https://img.myspeedpuzzling.com/puzzle/thumbnails/puzzle_medium/cobble-hill-rainbow-cats-500.png');
INSERT INTO puzzles VALUES (8, 'Landscape - Scandinavian Idyll', 'landscapes', 'Ravensburger', 500, 'https://img.myspeedpuzzling.com/puzzle/thumbnails/puzzle_medium/ravensburger-landscape-500.jpeg');
INSERT INTO puzzles VALUES (9, 'Volkswagen T1 Camper Van', 'vehicles', 'Ravensburger', 1000, 'https://img.myspeedpuzzling.com/puzzle/thumbnails/puzzle_medium/ravensburger-volkswagen-t1-camper-van-1000.jpeg');
INSERT INTO puzzles VALUES (10, 'I am New York', 'cities', 'Ravensburger', 1000, 'https://img.myspeedpuzzling.com/puzzle/thumbnails/puzzle_medium/ravensburger-i-am-new-york-17594-1000.png');

