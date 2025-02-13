# Language Learning App API

Это API предоставляет функции для создания мобильного приложения или 
веб-сайта для изучения иностранных языков. 
Он позволяет совершать CRUD операции с Карточками, переводами, тегами и языкоми.

## Краткое описание

Приложение предоставляет интерактивный способ изучения языков с 
помощью карточек.  Пользователи могут создавать свои собственные 
колоды карточек, добавляя слова и фразы на разных языках, а также их переводы.

## API Endpoints

'api/v1/translations': GET - Возвращает список всех переводов. , POST - Создает новый перевод.

'api/v1/translations/{id}': GET - Возвращает перевод по ID.   DELETE - Удаляет перевод по ID.    PUT - Обновляет перевод по ID.

'api/v1/translations/flashcard/{flashcardId}':GET - Возвращает список переводов для указанной flashcard.

'api/v1/flashcards': GET - Возвращает список всех карточек, POST- Добавляет новую карточку

'api/v1/flashcards/{id}': GET - Возвращает карточку по ИД, DELETE - удаляет карточку по ИД, PUT - корректирует карточку по ИД


'/api/v1/languages': GET - Извлечь все языки

'/api/v1/languages/{id}': GET - Извлечь определенный язык по ИД. DELETE - удалить язык по ИД

'api/v1/language/{name}': GET - Извлечь определенный язык по имени

'api/v1/tags': GET - Извлечь все теги, POST - добавить новый тег

'api/v1/tags/{id}' : GET - Извлечь Тег по ИД, DELETE - удалить Тег по ИД, PUT - корректировать тег

'api/v1/tags/{name}': GET - Извлечь тег по имени

