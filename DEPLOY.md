# Despliegue y ejecución de una aplicación Spring Boot desde la terminal y Visual Studio Code

## 1. Despliegue y ejecución desde la terminal

El despliegue y la ejecución de una aplicación Spring Boot se pueden realizar directamente desde la terminal utilizando Maven Wrapper.

### 1.1. Comprobar la versión de Java

Antes de realizar el despliegue, es importante comprobar que la versión de Java instalada en el ordenador coincide con la versión especificada en el proyecto.

En el archivo `pom.xml`, dentro de `<properties>`, se encuentra la propiedad `java.version`:

```xml
<properties>
    <java.version>26</java.version>
</properties>
```

La versión indicada debe coincidir con la versión de Java instalada en el sistema.

Para comprobar la versión de Java:

```bash
java --version
```

Y para comprobar la versión del compilador:

```bash
javac --version
```

En este caso, ambas deben mostrar la versión 26.

### 1.2. Acceder a la raíz del proyecto

Desde la terminal hay que situarse en la carpeta raíz del proyecto, donde se encuentra el archivo `pom.xml`.

```bash
cd ruta/del/proyecto
```

### 1.3. Ejecutar `clean`

En Windows:

```cmd
mvnw.cmd clean
```

En Linux y macOS:

```bash
./mvnw clean
```

El comando `clean` elimina los archivos generados por compilaciones anteriores, principalmente la carpeta `target`.

Esto permite realizar una nueva compilación partiendo de un estado limpio.

### 1.4. Ejecutar `package`

En Windows:

```cmd
mvnw.cmd package
```

En Linux y macOS:

```bash
./mvnw package
```

El comando `package` compila el proyecto y empaqueta la aplicación. En un proyecto Spring Boot, normalmente genera un archivo `.jar` dentro de la carpeta `target`.

### 1.5. Comprobar el contenido de `target`

Después de ejecutar `package`, se accede a la carpeta `target`:

```bash
cd target
```

Y se puede comprobar su contenido mediante:

```bash
ls
```

En Windows:

```cmd
dir
```

Dentro de esta carpeta aparecerán los archivos generados por Maven, entre ellos el archivo `.jar`.

En este proyecto:

```text
SpringBoot-web-0.0.1-SNAPSHOT.jar
```

### 1.6. Ejecutar el archivo `.jar`

Desde la carpeta `target` se ejecuta:

```bash
java -jar ./SpringBoot-web-0.0.1-SNAPSHOT.jar
```

El comando `java -jar` inicia la aplicación contenida en el archivo `.jar`.

Si todo funciona correctamente, Spring Boot iniciará el servidor y la aplicación quedará ejecutándose.

---

# 2. Despliegue utilizando Visual Studio Code

El proceso también se puede realizar de una manera más visual utilizando Visual Studio Code y las extensiones necesarias para trabajar con Java y Maven.

## 2.1. Instalar las extensiones

Para trabajar cómodamente con un proyecto Spring Boot es necesario instalar las extensiones de Java y Maven correspondientes.

Entre ellas se encuentra la extensión:

**Maven for Java**

Estas extensiones permiten gestionar el proyecto Maven directamente desde el entorno de Visual Studio Code, sin tener que escribir todos los comandos manualmente en la terminal.

## 2.2. Acceder al apartado Maven

Una vez instaladas las extensiones y abierto el proyecto Spring Boot en Visual Studio Code, en el explorador de archivos aparecerá el apartado:

**JAVA PROJECTS**

Dentro de este apartado se puede visualizar el proyecto Java/Spring Boot.

También aparecerá un apartado denominado:

**Maven**

Dentro de Maven aparecerá el proyecto Spring Boot.

Al abrir el proyecto se muestran diferentes apartados relacionados con la configuración y construcción del proyecto.

Entre ellos se encuentra:

**Lifecycle**

El apartado `Lifecycle` contiene las diferentes fases del ciclo de vida de Maven.

También existen otros apartados que permiten gestionar diferentes elementos del proyecto, como dependencias y plugins, de una forma más visual.

## 2.3. Ejecutar `clean` desde Visual Studio Code

Dentro de:

```text
Maven
└── SpringBoot-web
    └── Lifecycle
```

aparecerá la fase:

```text
clean
```

Al situarnos sobre `clean` aparecerá la opción **Run**.

Al pulsar **Run**, Visual Studio Code ejecutará la tarea equivalente a:

```bash
mvn clean
```

De esta forma se eliminan los archivos generados anteriormente, incluyendo el contenido generado dentro de la carpeta `target`.

No es necesario escribir manualmente `mvnw.cmd clean` en la terminal.

## 2.4. Ejecutar `package` desde Visual Studio Code

Después de ejecutar `clean`, dentro de `Lifecycle` también aparecerá:

```text
package
```

Al pulsar **Run** sobre `package`, Maven realizará el proceso de compilación y empaquetado del proyecto.

El resultado será equivalente a ejecutar manualmente:

```bash
mvn package
```

Una vez finalizado el proceso, se generará nuevamente la carpeta `target` con los archivos correspondientes, incluyendo el archivo `.jar` de la aplicación.

Por ejemplo:

```text
target/
├── ...
├── SpringBoot-web-0.0.1-SNAPSHOT.jar
└── ...
```

Si la carpeta `target` ya se encuentra limpia y no contiene archivos de una compilación anterior, también se puede ejecutar directamente `package` sin necesidad de ejecutar previamente `clean`.

## 2.5. Ejecutar el `.jar`

Una vez generado el archivo `.jar`, se puede acceder a la carpeta `target` desde Visual Studio Code o desde la terminal.

Desde la terminal, situándose dentro de `target`, se ejecuta:

```bash
java -jar ./SpringBoot-web-0.0.1-SNAPSHOT.jar
```

A partir de ese momento, Spring Boot iniciará la aplicación y levantará el servidor.

De esta forma, las fases `clean` y `package` pueden ejecutarse desde la interfaz de Visual Studio Code sin necesidad de escribir manualmente los comandos de Maven Wrapper.

El resultado final es el mismo: se genera el archivo `.jar` dentro de `target` y este archivo se ejecuta mediante Java para levantar el servidor de la aplicación Spring Boot.
