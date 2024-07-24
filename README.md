## ДИПЛОМНЫЙ ПРОЕКТ ЧАСТЬ 2. API-ТЕСТЫ


Автоматизирует проверку [Сервиса Stellar Burger](https://stellarburgers.nomoreparties.site) 5 сервисов:
* `POST /api/auth/register` Создание пользователя;
* `POST /api/auth/login` Логин пользователя;
* `PATCH /api/auth/user` Изменение пользоватея;
* `GET /api/orders` Получение списка закаов пользователя;
* `POST /api/orders` Создание заказа.

Используемый стек:
* java 11
* apache-maven ver 3.9.6
* junit 4.13.2
* allure-junit4 2.15.0
* allure-rest-assured 5.3.2
* gson 2.8.9