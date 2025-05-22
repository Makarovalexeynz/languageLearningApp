insert into users(username, password, role, email)
values ('user', '$2a$10$WNjeMNEiyFIszBkl.FdCEun.T1q/NuJL26xloV65w8CKjh6ciW3Xe', 'ROLE_USER', 'user@user.ru'), ('admin', '$2a$10$mlXzmxPCXOwMCyV7RObAw.9BSfa2MIiVIZIzRDbxFqqYYxVJW6FNq', 'ROLE_ADMIN', 'admin@admin.ru');

insert into languages(name, user_id)
values ('English', 1), ('Deutsch', 1), ('Татар теле', 1);

insert into flashcards(foreign_word, language_id, user_id)
values ('Flashcard_1', 1, 1), ('Flashcard_2', 1, 1), ('Flashcard_3', 1, 1),
('Karteikarte_1', 2, 1), ('Karteikarte_2', 2, 1), ('Karteikarte_3', 2, 1),
('Флешкарт_1', 3, 1), ('Флешкарт_2', 3, 1), ('Флешкарт_3', 3, 1),('Flashcard_12', 1, 2);

insert into translations(flashcard_id, native_word)
values (1, 'Карточка_1'), (1, 'ДругаяКарточка_1'),
(2, 'Карточка_2'), (2, 'ДругаяКарточка_2'),
(3, 'Карточка_3'), (3, 'ДругаяКарточка_3'),
(4, 'Карточка_1'), (4, 'ДругаяКарточка_1'),
(5, 'Карточка_2'), (5, 'ДругаяКарточка_2'),
(6, 'Карточка_3'), (6, 'ДругаяКарточка_3'),
(7, 'Карточка_1'), (7, 'ДругаяКарточка_1'),
(8, 'Карточка_2'), (8, 'ДругаяКарточка_2'),
(9, 'Карточка_3'), (9, 'ДругаяКарточка_3');

insert into tags (name, user_id)
values ('Тег_1', 1), ('Тег_2', 1), ('Тег_3', 1);

insert into flashcards_tags (flashcard_id, tag_id)
values (1, 1), (2, 2), (3, 3), (4, 1), (5, 2), (6, 3), (7, 1), (8, 2), (9, 3), (1, 2);







