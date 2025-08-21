# Ejemplo de análisis de métricas (llenar con datos reales tras ejecución)

| Escenario           | Usuarios | Tiempo promedio (ms) | p90 (ms) | p95 (ms) | Throughput (req/s) | Tasa de error (%) |
|---------------------|----------|----------------------|----------|----------|--------------------|-------------------|
| GET masivo          | 10       | 120                  | 180      | 200      | 50                 | 0                 |
| POST masivo         | 10       | 150                  | 210      | 230      | 48                 | 0                 |
| GET+POST combinado  | 10       | 140                  | 200      | 220      | 49                 | 0                 |
| GET masivo          | 50       | 300                  | 400      | 450      | 240                | 1                 |
| POST masivo         | 50       | 350                  | 420      | 480      | 235                | 2                 |
| GET+POST combinado  | 50       | 320                  | 410      | 470      | 238                | 1                 |
| GET masivo          | 100      | 600                  | 800      | 900      | 480                | 3                 |
| POST masivo         | 100      | 700                  | 900      | 1000     | 470                | 4                 |
| GET+POST combinado  | 100      | 650                  | 850      | 950      | 475                | 3                 |

## Gráficas

![Tiempo de respuesta](grafica_tiempo.png)
![Throughput](grafica_throughput.png)

## Hallazgos

- El tiempo de respuesta se mantiene bajo 500 ms hasta 50 usuarios, pero supera 600 ms con 100 usuarios.
- La tasa de error aumenta ligeramente con alta concurrencia, principalmente en POST.

## Recomendaciones

1. Optimizar el endpoint POST /citas para mejorar el rendimiento bajo alta carga.
2. Revisar la gestión de concurrencia en la base de datos para reducir errores en escenarios masivos.
