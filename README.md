# MediPlus API - Pruebas Automatizadas y Rendimiento

## Pasos para ejecutar el proyecto

1. Clonar el repositorio o descargar el proyecto.
2. Abre el proyecto con tu IDE favorito (IntelliJ, Eclipse, VS Code).
3. Instalar las dependencias y compilar el proyecto ejecutando:
   
   ```bash
   mvn clean install
   ```

4. Ejecutar las pruebas unitarias y de integración con:
   
   ```bash
   mvn test
   ```

5. Para pruebas de rendimiento y carga, primero es necesario levantar el servidor mock. Ejecuta el siguiente comando y mantenlo corriendo en una terminal separada:
   
   ```bash
   mvn test-compile exec:java -Dexec.mainClass="com.mediplus.mock.LanzadorMock" -Dexec.classpathScope="test"
   ```

6. Con el servidor mock activo, seguir las instrucciones del archivo [evidencias/README.md](evidencias/README.md) para ejecutar las pruebas de carga con JMeter desde la terminal.

## Estructura del proyecto

- src/test/java: Pruebas automatizadas con REST Assured
- pom.xml: Dependencias y configuración Maven
- jmeter/: Scripts de pruebas de carga (.jmx)
- evidencias/: Capturas y logs de ejecución
- informe/: Análisis, gráficas y recomendaciones

Para ver el informe de resultados, consulta el archivo [INFORME.md](INFORME.md).

## Requisitos
- Java 11+
- Maven 3.6+
- Apache JMeter 5.5+

## Endpoints de la API

| Método | Endpoint                | Descripción                        | Parámetros principales         | Autenticación |
|--------|------------------------|------------------------------------|-------------------------------|---------------|
| GET    | /pacientes             | Lista todos los pacientes          | page, size                    | Token         |
| POST   | /pacientes             | Registra un nuevo paciente         | nombre, apellido, fechaNac    | Token         |
| GET    | /citas                 | Lista todas las citas              | fecha, medicoId, pacienteId   | Token         |
| POST   | /citas                 | Agenda una nueva cita              | pacienteId, medicoId, fecha   | Token         |
| PUT    | /medicos/{id}          | Actualiza datos de un médico       | id, nombre, especialidad      | Token         |
| DELETE | /citas/{id}            | Elimina una cita                   | id                            | Token         |

Tabla de endpoints simulados servidos por WireMock en http://localhost:8089. Operaciones CRUD sobre pacientes, citas y médicos. Todos requieren cabecera Authorization: Bearer token_valido_simulado.

## Simulación de Seguridad

La autenticación de la API MediPlus se simula mediante el uso de un token tipo Bearer en la cabecera "Authorization". Para efectos de pruebas, se consideran dos valores:

- Token válido: "token_valido_simulado"
- Token inválido: "token_invalido_simulado"

Todas las pruebas automatizadas incluyen validaciones de acceso con ambos tipos de token, verificando el comportamiento esperado ante credenciales correctas e incorrectas.

## Nota
Las pruebas usan un servidor mock local (WireMock) en http://localhost:8089 con endpoints simulados: /pacientes, /citas, /medicos. No se llama a servicios externos en las ejecuciones.

## Contacto
Área de calidad - MediPlus
