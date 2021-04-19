# user_registration

**Простейшее CRUD API RESTfull приложение.**

С его помщью можно манипулировать с данными пользователя в базе данных (Добавить, удалить, изменить, прочитать).
Данные пользователя содержат:
- id;
- Имя;
- Фамилия;

**Инструкция сборки:**

Для запуска приложения необходим Docker, в папке с файлом docker-compose.yml необходимо выполнить команду docker-compose up. 
После запуска поднимается база данных postgres на порте 5432 и запуститься веб-сервис по локальному адресу http://localhost:8080/users.  
Вся документация об используемых api находится в swagger'e по ссылке http://localhost:8080/users/swagger-ui.html.

**Используемые технологии**
- Java;
- Spring-boot;
- Postgres;
- Swagger 3.0;
- Docker;
- REST.


**Edit By** *Tunkenov Nikolay* 

***https://vk.com/nik0sh***
