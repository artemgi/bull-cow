Реализовать на Java игру бык-корова с web интерфейсом. 
 Описание игры.
   Компьютер загадывает 4-х значное число. Цифры загаданного числа не
   повторяются. Задача пользователя угадать загаданное число. У
   пользователя неограниченное число попыток. В каждую попытку
   пользователь дает компьютеру свой вариант числа. Компьютер сообщает
   сколько цифр точно угадано (бык) и сколько цифр угадано без учета
   позиции (корова). По ответу компьютера пользователь должен за
   несколько ходов угадать число.
   Пример:
   7328 -- загаданное число
   0819 -- 0Б1К
   4073 -- 0Б2К
   5820 -- 0Б1К
   3429 -- 1Б1К
   5960 -- 0Б0К
   7238 -- 2Б2К
   7328 -- 4Б0К (число угадано)
 Функциональные требования.
   Пользователь должен регистрироваться для доступа к системе.
   Пользователь должен видеть свои предыдущие попытки.
   Компьютер ведет рейтинг пользователей (показатель -- среднее число
   попыток до угадывания числа).
   Способ хранения данных - произвольный
   Желательно дать пользователю выбирать число визуально, с помощью мыши.
 Технические требования и использование технологий:
•	Spring MVC, Spring Data, Spring Security, Hibernate ORM. Для работы с базой примените DAO или JPA. 
•	Базу данных использовать не требующую инсталляции, например .H2 (или подобную файловую базу). 
•	Обмен между фронтом и бэком вести через JSON формат. Для фронта можно использовать HTML+CSS+JQuery, либо любой JS CSS Фреймворк - bootstrap, Vue.js, Angular и пр. 
•	Для отладки возможно использование Tomcat embedded, но результатом должно быть WAR приложение для  деплоя под сервер Tomcat 8 и выше.  
•	JavaDoc в коде приветствуется.
•	Исходники для просмотра заливать в GitHub.

