ALTER table book
    ADD COLUMN author_id UUID;

ALTER TABLE book
    ADD FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE SET NULL;

ALTER TABLE book
    DROP COLUMN author;