# Informe de Pruebas

## Resumen Ejecutivo

Se realizaron pruebas funcionales y de rendimiento sobre la API REST de MediPlus. Se validó el correcto funcionamiento de los endpoints principales y la respuesta del sistema bajo diferentes niveles de carga.

## Resultados de Pruebas de Rendimiento

**Nota:** Se ha introducido un retardo (delay) aleatorio en el endpoint `/pacientes` a nivel del mock (WireMock) utilizando `withLogNormalRandomDelay(400, 0.2)`. Este método genera retardos que siguen una distribución log-normal, simulando tiempos de respuesta más realistas donde la mayoría de las respuestas son rápidas pero algunas pueden ser significativamente más lentas, observando así su impacto en las pruebas de carga.

GET Masivo: 10 Usuarios (60 segundos)

| Label         | # Samples | Average | Median | 90% Line | 95% Line | 99% Line | Min | Max | Error % | Throughput | Received KB/sec | Sent KB/sec |
|---------------|-----------|---------|--------|----------|----------|----------|-----|-----|---------|------------|----------------|------------|
| GET /pacientes | 1400      | 413     | 404    | 523      | 565      | 636      | 219 | 930 | 0.000%  | 23.15351   | 4.64           | 3.84       |
| TOTAL         | 1400      | 413     | 404    | 523      | 565      | 636      | 219 | 930 | 0.000%  | 23.15351   | 4.64           | 3.84       |


GET Masivo: 50 Usuarios (60 segundos)

| Label         | # Samples | Average | Median | 90% Line | 95% Line | 99% Line | Min | Max | Error % | Throughput | Received KB/sec | Sent KB/sec |
|---------------|-----------|---------|--------|----------|----------|----------|-----|-----|---------|------------|----------------|------------|
| GET /pacientes | 1395      | 415     | 407    | 525      | 561      | 627      | 217 | 721 | 0.000%  | 23.09297   | 4.62           | 3.83       |
| TOTAL         | 1395      | 415     | 407    | 525      | 561      | 627      | 217 | 721 | 0.000%  | 23.09297   | 4.62           | 3.83       |


GET Masivo: 100 Usuarios (60 segundos)

**Nota:** Aqui se introdujo un delay aun mas grande para simular la carga de 100 usuarios simultaneos con `.withLogNormalRandomDelay(1400, 0.3)` de 1400ms

| Label         | # Samples | Average | Median | 90% Line | 95% Line | 99% Line | Min | Max | Error % | Throughput | Received KB/sec | Sent KB/sec |
|---------------|-----------|---------|--------|----------|----------|----------|-----|-----|---------|------------|----------------|------------|
| GET /pacientes | 970       | 6337    | 1517   | 28697    | 34148    | 36140    | 600 | 36683 | 8.247%  | 14.18958   | 4.97           | 2.16       |
| TOTAL         | 970       | 6337    | 1517   | 28697    | 34148    | 36140    | 600 | 36683 | 8.247%  | 14.18958   | 4.97           | 2.16       |


## Hallazgos

- El tiempo de respuesta promedio para el endpoint `/pacientes` se mantiene alrededor de 415ms para 10 y 50 usuarios, pero se dispara a 6337ms con 100 usuarios, indicando una degradación severa del rendimiento.
- Se observa un incremento significativo en la tasa de error (8.247%) al alcanzar los 100 usuarios concurrentes, lo que sugiere problemas de estabilidad o capacidad bajo alta carga.
- La tasa de error aumenta ligeramente con alta concurrencia.

## Recomendaciones

1. Optimizar el endpoint GET /pacientes para mejorar el rendimiento bajo alta carga.
2. Revisar la gestión de concurrencia en la base de datos para reducir errores en escenarios masivos.

## Evidencias

Los archivos .csv se encuentran en la carpeta `evidencias/`.
