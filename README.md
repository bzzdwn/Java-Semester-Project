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

**Для каждого пункта написаны Unit-Тесты с помощью библиотеки JUnit (в папке src/test 49 тестов).**

_Примечания:_
* _Конвертация файла в определенный формат (txt/json/xml или zip/rar/jar) реализована шаблоном проектирования Builder._
* _Для работы с JSON расширением используется Maven-библиотека Jackson._
* _Для работы с XML расширением используется технология Streaming API for XML (StAX)._
* _Для работы с ZIP, RAR, JAR расширениями используются стандартные Java-утилиты._
* _Примеры структуры файлов для парсинга находятся в папке examples._
* _Вложенность любая (например архивация + архивация + шифрование + архивация)._

## Console Line Interface
_Директория ExamProjectWebUI._

Вся логика поддерживается стандартным консольным интерфейсом. Для его активации необходимо в качестве запускаемой конфигурации установить файл _src/main/java/exam/project/cli/Main.java_. 

Работа выполняется с файлами, лежащими в основной директории проекта.

## Graphic User Interface
_Директория ExamProjectGraphicUI._

Вся логика поддерживается Desktop-интерфейсом. Интерфейс реализован при помощи библиотеки JavaFX. Спектр возможностей шире чем у CLI, так как при нажатии на кнопку "Choose File" пользователю предлагается выбрать файл из любой директории на компьютере. Результат сохраняется в ту же директорию, в которой находился исходный файл.

Ниже представлен внешний вид GUI:

![image](https://user-images.githubusercontent.com/93089691/213578994-9fa1a2b7-11d1-4570-a7e1-4ad95720b5df.png)


## Web User Interface
_Директория ExamProjectWebUI._

Вся логика поддерживается Web-интерфейсом. Реализован WebUI с помощью технологии Spring Model-View-Controller на основе Tomcat 9.0 (используемое ядро находится в папке server). 
* BackEnd-часть реализована с помощью Spring Framework и архитектуры REST (поддерживаются GET-запросы для получения инфорации об элементе меню и POST-запросы для выгрузки файлов на сервер).
* FrontEnd-часть реализована с помощью HTML & немного CSS.
* 
Спектр возможностей шире чем у GUI, так как пользователь может выбрать для загрузки на сервер файл из любой директории и также скачать файл-результат в любую директорию.

**Для функционала WebUI, в частности MVC, написаны Unit-Тесты с помощью библиотеки JUnit + MockMVC (Mock Framework) (Файл MVCTests.java, 12 тестов).**

Ниже GIF, демонстрирующее работу WebUI:

![780zh5](https://user-images.githubusercontent.com/93089691/213475088-afc046ac-e88b-4bae-b05e-3eb37a27cf56.gif)


