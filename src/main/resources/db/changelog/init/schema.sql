CREATE TABLE IF NOT EXISTS users (
id bigserial PRIMARY KEY,
username VARCHAR(255),
password VARCHAR(255),
role VARCHAR(255) NOT NULL,
email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS languages (
id bigserial PRIMARY KEY,
name VARCHAR(255) UNIQUE NOT NULL,
user_id bigint references users(id)
);

CREATE TABLE IF NOT EXISTS flashcards (
id bigserial PRIMARY KEY,
foreign_word VARCHAR(255) NOT NULL,
language_id bigint references languages (id) ON DELETE CASCADE,
user_id bigint references users(id)
);

CREATE TABLE IF NOT EXISTS translations (
id bigserial PRIMARY KEY,
flashcard_id bigint references flashcards (id) ON DELETE CASCADE,
native_word VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tags (
id bigserial PRIMARY KEY,
name VARCHAR(255) UNIQUE NOT NULL,
user_id bigint references users(id)
);

CREATE TABLE IF NOT EXISTS flashcards_tags (
    flashcard_id BIGINT REFERENCES flashcards(id) ON DELETE CASCADE,
    tag_id BIGINT REFERENCES tags(id) ON DELETE CASCADE,
    PRIMARY KEY (flashcard_id, tag_id)
);

