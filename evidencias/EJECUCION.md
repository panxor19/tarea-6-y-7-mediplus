# Ejemplo de comando para ejecutar pruebas funcionales

mvn test > evidencias/log_funcional.txt

# Ejemplo de comando para ejecutar pruebas de carga en JMeter

"C:/Program Files/ApacheJMeter/bin/jmeter" -n -t jmeter/mediplus-carga.jmx -l evidencias/log_jmeter_get_10.jtl -Jusuarios=10
"C:/Program Files/ApacheJMeter/bin/jmeter" -n -t jmeter/mediplus-carga.jmx -l evidencias/log_jmeter_get_50.jtl -Jusuarios=50
"C:/Program Files/ApacheJMeter/bin/jmeter" -n -t jmeter/mediplus-carga.jmx -l evidencias/log_jmeter_get_100.jtl -Jusuarios=100

# Guardar capturas de pantalla de resultados y gráficas en la carpeta evidencias/
