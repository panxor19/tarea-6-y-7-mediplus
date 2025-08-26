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

### Pruebas de Carga GET

### GET 10 Usuarios

```bash
apache-jmeter/bin/jmeter -n -t jmeter/mediplus-get.jmx -l evidencias/log_jmeter_get10.jtl -Jusuarios=10
```

### GET 50 Usuarios

```bash
apache-jmeter/bin/jmeter -n -t jmeter/mediplus-get.jmx -l evidencias/log_jmeter_get10.jtl -Jusuarios=50
```

### GET 100 Usuarios

```bash
apache-jmeter/bin/jmeter -n -t jmeter/mediplus-get.jmx -l evidencias/log_jmeter_get10.jtl -Jusuarios=100
```

### Pruebas de Carga POST

### POST 10 Usuarios

```bash
apache-jmeter/bin/jmeter -n -t jmeter/mediplus-post.jmx -l evidencias/log_jmeter_post10.jtl -Jusuarios=10
```

### POST 50 Usuarios

```bash
apache-jmeter/bin/jmeter -n -t jmeter/mediplus-post.jmx -l evidencias/log_jmeter_post50.jtl -Jusuarios=50
```

### POST 100 Usuarios

```bash
apache-jmeter/bin/jmeter -n -t jmeter/mediplus-post.jmx -l evidencias/log_jmeter_post100.jtl -Jusuarios=100
```

### Pruebas de Carga GET y POST

### GET+POST 10 Usuarios

```bash
apache-jmeter/bin/jmeter -n -t jmeter/mediplus-get-post.jmx -l evidencias/log_jmeter_get_post10.jtl -Jusuarios=10
```

### GET+POST 50 Usuarios

```bash
apache-jmeter/bin/jmeter -n -t jmeter/mediplus-get-post.jmx -l evidencias/log_jmeter_get_post50.jtl -Jusuarios=50
```

### GET+POST 100 Usuarios

```bash
apache-jmeter/bin/jmeter -n -t jmeter/mediplus-get-post.jmx -l evidencias/log_jmeter_get_post100.jtl -Jusuarios=100
```
