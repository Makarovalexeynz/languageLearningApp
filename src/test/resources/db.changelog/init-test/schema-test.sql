CREATE TABLE IF NOT EXISTS flashcards (
    id bigserial,
    foreign_word VARCHAR(255) NOT NULL,
    native_word VARCHAR(255) NOT NULL
)
