# Plantilla de Informe de Pruebas

## Resumen Ejecutivo

Se realizaron pruebas funcionales y de rendimiento sobre la API REST de MediPlus. Se validó el correcto funcionamiento de los endpoints principales y la respuesta del sistema bajo diferentes niveles de carga.

## Resultados de Pruebas de Rendimiento

| Escenario           | Usuarios | Tiempo promedio (ms) | p90 (ms) | p95 (ms) | Throughput (req/s) | Tasa de error (%) |
|---------------------|----------|----------------------|----------|----------|--------------------|-------------------|
| GET masivo          | 10       |                      |          |          |                    |                   |
| POST masivo         | 10       |                      |          |          |                    |                   |
| GET+POST combinado  | 10       |                      |          |          |                    |                   |
| GET masivo          | 50       |                      |          |          |                    |                   |
| POST masivo         | 50       |                      |          |          |                    |                   |
| GET+POST combinado  | 50       |                      |          |          |                    |                   |
| GET masivo          | 100      |                      |          |          |                    |                   |
| POST masivo         | 100      |                      |          |          |                    |                   |
| GET+POST combinado  | 100      |                      |          |          |                    |                   |

## Gráficas

- [ ] Tiempo de respuesta vs usuarios
- [ ] Throughput vs usuarios

## Hallazgos

- 
- 

## Recomendaciones

1. 
2. 

## Evidencias

Adjuntar capturas de pantalla y logs relevantes en la carpeta `evidencias/`.
