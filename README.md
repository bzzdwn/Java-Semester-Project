# Java-Semester-Project
## Логика
Основная бизнес-логика проекта представляет собой консольное приложение, которое выполняет следующие действия:
* Чтение файла (поддерживаемые форматы txt/json/xml) и парсинг из этих файлов математических выражений. Есть на выбор 2 механизма для парсинга: 
* * с помощью сведения выражения к постфиксной форме записи и подсчету значения по правилам постфиксной формы записи (сложность выражения: сложение, вычитание, умножение, деление и поддержка скобок);
* * с помощью библиотеки exp4j (сложность выражения: любая).
* Запись вычисленных математических выражений в файл (поддерживаемые форматы txt/json/xml).
* Архивация файла (поддерживаемые форматы zip/rar/jar).
* Извлечение из архива файла (поддерживаемые форматы zip/rar/jar).
* Шифрование/расшифрование файла (алгоритм AES).

**Для каждого пункта написаны Unit-Тесты с помощью библиотеки JUnit.**

_Примечания:_
* _Конвертация файла в определенный формат (txt/json/xml или zip/rar/jar) реализована шаблоном проектирования Builder._
* _Для работы с JSON расширением используется Maven-библиотека Jackson._
* _Для работы с XML расширением используется технология Streaming API for XML (StAX)._
* _Для работы с ZIP, RAR, JAR расширениями используются стандартные Java-утилиты._
* _Примеры структуры файлов для парсинга находятся в папке examples._

## Console Line Interface
Вся логика поддерживается стандартным консольным интерфейсом. Для его активации необходимо в качестве запускаемой конфигурации установить файл _src/main/java/exam/project/cli/Main.java_. 

Работа выполняется с файлами, лежащими в основной директории проекта.

## Web User Interface
Вся логика поддерживается Web-интерфейсом. Реализован WebUI с помощью технологии Spring Model-View-Controller на основе Tomcat 9.0. 
* BackEnd-часть реализована с помощью Spring Framework и архитектуры REST (поддерживаются GET-запросы для получения инфорации об элементе меню и POST-запросы для выгрузки файлов на сервер).
* FrontEnd-часть реализована с помощью HTML & немного CSS.

![780zh5](https://user-images.githubusercontent.com/93089691/213475088-afc046ac-e88b-4bae-b05e-3eb37a27cf56.gif)


