# Ejecución de Pruebas

Este documento describe los comandos para ejecutar los diferentes tipos de pruebas del proyecto.

## Pruebas Funcionales

Para ejecutar las pruebas funcionales (unitarias y de integración) y guardar el log de salida, utiliza el siguiente comando:

```bash
mvn test > evidencias/log_funcional.txt
```

## Pruebas de Carga (JMeter)

Asegúrate de tener el servidor mock corriendo antes de lanzar estas pruebas.

Las pruebas de carga se ejecutan con Apache JMeter desde la línea de comandos. A continuación se muestran ejemplos para simular 10, 50 y 100 usuarios concurrentes.

**Nota:** La ruta al ejecutable `jmeter` puede variar dependiendo de tu sistema operativo y de dónde lo hayas instalado. Ajusta la ruta si es necesario.

### 10 Usuarios

```bash
"C:/Program Files/ApacheJMeter/bin/jmeter" -n -t jmeter/mediplus-carga.jmx -l evidencias/log_jmeter_get_10.jtl -Jusuarios=10
```

### 50 Usuarios

```bash
"C:/Program Files/ApacheJMeter/bin/jmeter" -n -t jmeter/mediplus-carga.jmx -l evidencias/log_jmeter_get_50.jtl -Jusuarios=50
```

### 100 Usuarios

```bash
"C:/Program Files/ApacheJMeter/bin/jmeter" -n -t jmeter/mediplus-carga.jmx -l evidencias/log_jmeter_get_100.jtl -Jusuarios=100
```

## Generación de Evidencias

Para generar un dashboard HTML con los resultados de una ejecución de pruebas de carga, utiliza el siguiente comando. Asegúrate de que el archivo JTL de entrada (parámetro `-g`) exista.

```bash
apache-jmeter/bin/jmeter -g evidencias/log_jmeter_get_10.jtl -o evidencias/dashboard
```

El dashboard se creará en la carpeta `evidencias/dashboard`. Puedes abrir el archivo `index.html` en un navegador para ver el reporte.
