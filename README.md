# CRUD SERVLET JDBC

Sistema para visualizacion de productos con autenticación básica

## Requisitos

Se debe generar un war con el proyecto y subirla en un tomcat

## Configuraciones

1. **Clonar el repositorio**

   Abre una terminal y ejecuta el siguiente comando:

   ```bash
   git clone https://github.com/Ernestolop/rest_spring_crud.git

2. **Base de datos**
   Crea una base de datos postgres, y modifica las credenciales correspondientes en el context.xml

3. **Datos**
   Crea un usuario 

    ```bash
   insert into users(id, name, password, email) values(1, 'admin', '123456', 'correo@correo.com');

    Inserta algunos productos

4. **Genera el War y subelo en un tomcat**
    Puedes probar la aplicación