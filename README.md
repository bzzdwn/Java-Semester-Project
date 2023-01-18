# Java-Semester-Project
## Логика
Основная бизнес-логика проекта представляет собой консольное приложение, которое выполняет следующие действия:
* Чтение файла (поддерживаемые форматы txt/json/xml) и парсинг из этих фалов математических выражений. Есть на выбор 2 механизма для парсинга: 
* * с помощью сведения выражения к постфиксной форме записи и подсчету значения по правилам постфиксной формы записи (сложность выражения: сложение, вычитание, умножение, деление и поддержка скобок);
* * с помощью библиотеки exp4j (сложность выражения: любая).
* Запись вычисленных математических выражений в файл (поддерживаемые форматы txt/json/xml).
* Архивация файла (поддерживаемые форматы zip/rar/jar).
* Извлечение из архива файла (поддерживаемые форматы zip/rar/jar).
* Шифрование/расшифрование файла.

_Примечания:_
* _Конвертация файла в определенный формат (txt/json/xml или zip/rar/jar) реализована шаблоном проектирования Builder;_
* _Для работы с JSON расширением используется Maven-библиотека Jackson._
* _Для работы с XML расширением используется технология Streaming API for XML (StAX)._
* _Для работы с ZIP, RAR, JAR расширениями используются стандартные Java-утилиты._

## Console Line Interface
Вся логика поддерживается стандартным консольным интерфейсом. Для запуска необходимо в качестве запускаемой конфигурации установить файл _src/main/java/exam/project/cli/Main.java_. Выглядит консольный интерфейс следующим образом:
![image](https://user-images.githubusercontent.com/93089691/213317731-1ec399f6-0300-48b9-8e88-6e28b1a7e153.png)

Работа выполняется с файлами, лежащими в основной директории проекта.
