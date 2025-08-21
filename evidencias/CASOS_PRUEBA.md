# Casos de Prueba Automatizados

| Caso | Endpoint         | Método | Descripción                                      | Tipo        | Resultado esperado           |
|------|------------------|--------|--------------------------------------------------|-------------|-----------------------------|
| 1    | /pacientes       | GET    | Obtener lista de pacientes                        | Positivo    | 200, lista no vacía         |
| 2    | /pacientes       | POST   | Registrar paciente válido                         | Positivo    | 201, datos coinciden        |
| 3    | /pacientes       | POST   | Registrar paciente con datos inválidos            | Negativo    | 400, mensaje de error       |
| 4    | /citas           | GET    | Obtener lista de citas                            | Positivo    | 200, lista                  |
| 5    | /citas           | POST   | Agendar cita válida                              | Positivo    | 201, datos coinciden        |
| 6    | /citas/99999     | DELETE | Eliminar cita inexistente                         | Negativo    | 404, mensaje de error       |
| 7    | /medicos/2       | PUT    | Actualizar datos de médico                        | Positivo    | 200, datos actualizados     |
| 8    | /pacientes       | GET    | Acceso con token válido                           | Seguridad   | 200                        |
| 9    | /pacientes       | GET    | Acceso con token inválido                         | Seguridad   | 401, mensaje no autorizado  |
| 10   | /pacientes       | POST   | Registrar paciente con token válido               | Seguridad   | 201                        |
| 11   | /pacientes       | POST   | Registrar paciente con token inválido             | Seguridad   | 401, mensaje no autorizado  |

## Evidencias

Colocar capturas de pantalla de la ejecución de pruebas en la carpeta `evidencias/`.

## Logs

Guardar los logs de ejecución de JMeter y Maven en la carpeta `evidencias/` para su análisis.
