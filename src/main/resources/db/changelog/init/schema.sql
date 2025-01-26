CREATE TABLE IF NOT EXISTS languages (
id bigserial PRIMARY KEY,
name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS flashcards (
id bigserial PRIMARY KEY,
foreign_word VARCHAR(255) NOT NULL,
language_id bigint references languages (id) NOT NULL
);

CREATE TABLE IF NOT EXISTS translations (
id bigserial PRIMARY KEY,
flashcard_id bigint references flashcards (id) NOT NULL,
native_word VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tags (
id bigserial PRIMARY KEY,
name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS flashcards_tags (
    flashcard_id BIGINT REFERENCES flashcards(id) NOT NULL,
    tag_id BIGINT REFERENCES tags(id) NOT NULL,
    PRIMARY KEY (flashcard_id, tag_id)
);