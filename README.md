# CRUD SERVLET JDBC

Sistema para visualizacion de productos con autenticación básica

## Requisitos

Se debe generar un war con el proyecto y subirla en un tomcat

## Configuraciones

1. **Clonar el repositorio**

   Abre una terminal y ejecuta el siguiente comando:

   ```bash
   git clone https://github.com/Ernestolop/rest_spring_crud.git
   ```

2. **Base de datos**
   Crea una base de datos postgres, y modifica las credenciales correspondientes en el context.xml

3. **Datos**
   Las tablas están configuradas para crearse y destruirse por cada vez que se levante la app
   Los datos de las tabalas de poblan automáticamente al levantar la app gracias al script import.sql
   Usuario disponible para la prueba: admin, 123456

4. **Genera el War y subelo en un tomcat**
    Puedes probar la aplicación