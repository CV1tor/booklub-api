CREATE TABLE book (
    id UUID PRIMARY KEY DEFAULT (UUID()),
    title VARCHAR(150) NOT NULL,
    author VARCHAR(50),
    genre TINYINT NOT NULL,
    pages INT NOT NULL,
    price INT NOT NULL,
    quantity INT NOT NULL
)