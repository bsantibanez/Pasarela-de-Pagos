# Credit Card Validator

[![Angular](https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white)](https://angular.io/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![Nginx](https://img.shields.io/badge/Nginx-009639?style=for-the-badge&logo=nginx&logoColor=white)](https://nginx.org/)

Una aplicación robusta y escalable diseñada para la validación y gestión de tarjetas de crédito, construida sobre una arquitectura de microservicios con balanceo de carga y contenedorización integral.

---

## Arquitectura del Sistema

El proyecto implementa un proxy inverso y balanceador de carga que distribuye el tráfico entre múltiples instancias del backend para garantizar alta disponibilidad.

```mermaid
graph TD
    Client[Cliente / Navegador] -->Angular[Frontend Angular]
    Angular[Frontend Angular] -->|HTTP| Nginx[Proxy Inverso Nginx]
    Nginx -->|Balanceo de Carga| Spring1[Backend Spring Boot - Réplica 1]
    Nginx -->|Balanceo de Carga| Spring2[Backend Spring Boot - Réplica 2]
    Spring1 --> PostgreSQL[(Base de Datos PostgreSQL)]
    Spring2 --> PostgreSQL
```

## Tecnologías Utilizadas

* **Frontend:** Angular con TypeScript y estilos modernos.
* **Backend:** Spring Boot (Java) con arquitectura RESTful.
* **Base de Datos:** PostgreSQL para persistencia de datos relacionales.
* **Infraestructura:** Docker y Docker Compose para la orquestación de contenedores.
* **Servidor Web / Proxy:** Nginx configurado para balanceo de carga (*Load Balancing*) entre las réplicas del backend.


## Despliegue y Ejecución

### Requisitos Previos

Asegúrate de tener instalados los siguientes componentes en tu sistema:
* **Docker**
* **Docker Compose**

### 1. Configuración del Entorno

Clona este repositorio y crea un archivo llamado `.env` en la raíz del proyecto con las siguientes variables de entorno:

```env
# Configuración de la Base de Datos
DB_NAME=credit_card_validator
DB_USER=postgres
DB_PASSWORD=password
DB_URL=jdbc:postgresql://postgres:5432/credit_card_validator
```
### 2. Construcción y Arranque

Ejecuta el siguiente comando en tu terminal para compilar las imágenes e iniciar todos los servicios (Frontend, Réplicas del Backend, Base de Datos y Nginx) en segundo plano:

```
docker compose up --build -d
```
### 3. Acceso a la Aplicación

Una vez que todos los contenedores estén en estado Running, puedes acceder a la interfaz web abriendo tu navegador e ingresando a:

```
http://IP_SERVIDOR
```

