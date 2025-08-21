# MediPlus API - Pruebas Automatizadas y Rendimiento

## Pasos para ejecutar el proyecto

1. Clonar el repositorio o descargar el proyecto.
2. Importar como proyecto Maven en tu IDE favorito (IntelliJ, Eclipse, VS Code).
3. Ejecutar las pruebas con:
   
   mvn test

4. Para pruebas de rendimiento, abrir el archivo JMeter (.jmx) en Apache JMeter y ejecutar los escenarios.

## Estructura del proyecto

- src/test/java: Pruebas automatizadas con REST Assured
- pom.xml: Dependencias y configuración Maven
- ENDPOINTS.md: Documentación de endpoints
- jmeter/: Scripts de pruebas de carga (.jmx)
- evidencias/: Capturas y logs de ejecución
- informe/: Análisis, gráficas y recomendaciones

## Requisitos
- Java 11+
- Maven 3.6+
- Apache JMeter 5.5+

## Nota
Las pruebas usan un servidor mock local (WireMock) en http://localhost:8089 con endpoints simulados: /pacientes, /citas, /medicos. No se llama a servicios externos en las ejecuciones.

## Contacto
Área de calidad - MediPlus
