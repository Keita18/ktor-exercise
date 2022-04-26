## Тестовое задание Kotlin/Java Seven Winds Studio

Простое приложение по чтению и записи в БД.

На вход - POST / GET запросы, фронтенд писать не нужно. Принять данные от пользователя, записать их в БД. Потом для другого запроса отдать обратно.
Данные для передачи: e-mail, фамилия, имя, отчество, номер телефона.
Библиотеки и инструменты для подключения

* Flyway для управления структурой БД. Т.е. чтобы не спринг создавал таблицы так как сам считает нужным, а мы сами имели контроль над этим процессом

* Swagger для построения и отображения публичного апи
  
* Вести разработку с использованием системы контроля версий Git
  1-2 Unit теста на получившийся код

P.S. Предпочтительнее реализация тестового на Kotlin. Просьба, не увлекаться использованием коробочных фич Spring для CRUD, предпочтительнее Ktor+Exposed :-P

### Docker

1) Download the project to yourself.
2) Run command:
    - docker-compose up --build
    - docker exec -t -i ktor-gradle-app ./gradlew

### Postman
    - all user: Get --> http://localhost:8080/users/
    - UserbyId: Get --> http://localhost:8080/users/{id}
    - add new user: Post -->  http://localhost:8080/users/{user}

swagger also available



