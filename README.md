# programa
test-davidpeces

Ejecución del programa:

Abrir una consola  o terminal.
Posicionarnos en el directorio donde se encuentra nuestro "programa.jar".

Ejecutar > java -jar programa.jar 4    --> El cliente no tiene proveedores asignados.
Ejecutar > java -jar programa.jar asdf --> Error, Introducir un código de cliente correcto.
Ejecutar > java -jar programa.jar 5.   --> Muestra por consola los clientes y crea el fichero plano proveedores_5.txt.
Ejecutar > java -jar programa.jar 6.   --> Muestra por consola los clientes y crea el fichero plano proveedores_6.txt.

Ejemplo en el directorio, con las posibilidades.


Creación del fichero plano:

En Mac, se creará en el mismo directorio donde se encuentre "programa.jar".
En Windows, se creará en C:/.

Dependencias utilizadas:

- Conector OBDJ MySql
mysql-connector-java-8.0.23.java
