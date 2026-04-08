# Despliegue con Docker, Render y Aiven

## Estructura

El proyecto Spring Boot vive dentro de `db/`.

## Archivo principal de despliegue

Usa `Dockerfile` desde la raíz del repositorio.

## Variables de entorno en Render

Puedes usar una de estas dos opciones:

### Opción recomendada

- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`

### Opción por partes

- `HOST`
- `DATABASE_PORT`
- `NAME`
- `DATABASE_USERNAME`
- `DATABASE_PASSWORD`

También puedes usar `USER` y `PASSWORD`, pero es mejor `DATABASE_USERNAME` y `DATABASE_PASSWORD` para evitar confusión.

## Aiven

1. Crea un servicio MySQL.
2. Crea una base de datos, por ejemplo `fifa`.
3. Crea un usuario para esa base.
4. Copia host, puerto, usuario y contraseña.
5. Usa una URL JDBC como esta:

```text
jdbc:mysql://HOST:PUERTO/fifa?ssl-mode=REQUIRED&serverTimezone=UTC
```

Ejemplo:

```text
jdbc:mysql://mysql-xxxxx.aivencloud.com:12345/fifa?ssl-mode=REQUIRED&serverTimezone=UTC
```

## Render

1. Crea un Web Service nuevo.
2. Elige despliegue con Docker.
3. Usa este repositorio como origen.
4. Asegúrate de que Render detecte el `Dockerfile`.
5. Agrega las variables de entorno de Aiven.
6. Despliega.

## Si sigue fallando

Revisa estos puntos:

- La URL JDBC debe apuntar a Aiven, no a `localhost`.
- El usuario y la contraseña deben ser los de Aiven.
- Aiven debe permitir conexiones desde Render.
- La base de datos debe existir.

## Probar localmente

```powershell
docker build -t crud-jugadores-entrenadores .
docker run -p 8080:8080 -e SPRING_DATASOURCE_URL="jdbc:mysql://HOST:PUERTO/fifa?ssl-mode=REQUIRED&serverTimezone=UTC" -e SPRING_DATASOURCE_USERNAME="TU_USUARIO" -e SPRING_DATASOURCE_PASSWORD="TU_PASSWORD" crud-jugadores-entrenadores
```

