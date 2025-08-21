# MediPlus API - Documentación de Endpoints

| Método | Endpoint                | Descripción                        | Parámetros principales         | Autenticación |
|--------|------------------------|------------------------------------|-------------------------------|---------------|
| GET    | /pacientes             | Lista todos los pacientes          | page, size                    | Token         |
| POST   | /pacientes             | Registra un nuevo paciente         | nombre, apellido, fechaNac    | Token         |
| GET    | /citas                 | Lista todas las citas              | fecha, medicoId, pacienteId   | Token         |
| POST   | /citas                 | Agenda una nueva cita              | pacienteId, medicoId, fecha   | Token         |
| PUT    | /medicos/{id}          | Actualiza datos de un médico       | id, nombre, especialidad      | Token         |
| DELETE | /citas/{id}            | Elimina una cita                   | id                            | Token         |

## Descripción

Tabla de endpoints simulados servidos por WireMock en http://localhost:8089. Operaciones CRUD sobre pacientes, citas y médicos. Todos requieren cabecera Authorization: Bearer token_valido_simulado.
