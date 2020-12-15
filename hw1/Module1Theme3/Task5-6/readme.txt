Задание 5
Создайте многомодульный проект. Одни модуль – jar, другой модуль – war. 
Создайте parent модуль. Проверьте процесс сборки и опишите ваши вопросы.

Создал parent модуль:
mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart

В pom.xml добавил <packaging>pom</packaging>

Создал дочерние jar и war модули:
mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp
mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart

Сборка осуществляется успешно.

Задание 6
Настройте зависимость многомодульного проекта на MySQL database driver.
Выполните сборку проекта и проверьте, что она прошла успешно.

Добавил в parent pom.xml зависимость:
      <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
	<version>5.1.2</version>
      </dependency>

Сборка проходит успешно зависимости наследуются дочерними модулями. 

Если добавить в дочерние модули следующие строки(как написано в учебном пособии) 
<dependencies>
      <dependency>
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <scope>test</scope>
      </dependency>
      <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
      </dependency>
 </dependencies>

то при сборке обнаруживаются ошибки(не может найти версию), без них все работает.
[ERROR] [ERROR] Some problems were encountered while processing the POMs:
[ERROR] 'dependencies.dependency.version' for junit:junit:jar is missing. @ line 24, column 17
[ERROR] 'dependencies.dependency.version' for mysql:mysql-connector-java:jar is missing. @ line 29, column 17@


