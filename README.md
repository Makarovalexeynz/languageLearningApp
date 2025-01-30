# Language Learning App API

A RESTful API for creating and managing flashcards for language learning.


## API Endpoints

'/api/v1/languages': GET - Извлечь все языки

'/api/v1/languages/{id}': GET - Извлечь определенный язык по ИД. DELETE - удалить язык по ИД

'api/v1/language/{name}': GET - Извлечь определенный язык по имени

'api/v1/tags': GET - Извлечь все теги, POST - добавить новый тег

'api/v1/tags/{id}' : GET - Извлечь Тег по ИД, DELETE - удалить Тег по ИД, PUT - корректировать тег

'api/v1/tags/{name}': GET - Извлечь тег по имени

'api/v1/translations': GET - Извлечь все переводы

'pi/v1/translations/{flashcardId}': GET - извлечь все переводы оп Id карточки