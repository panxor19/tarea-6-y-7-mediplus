# Simulación de Seguridad y Autenticación

La autenticación de la API MediPlus se simula mediante el uso de un token tipo Bearer en la cabecera "Authorization". Para efectos de pruebas, se consideran dos valores:

- Token válido: "token_valido_simulado"
- Token inválido: "token_invalido_simulado"

Todas las pruebas automatizadas incluyen validaciones de acceso con ambos tipos de token, verificando el comportamiento esperado ante credenciales correctas e incorrectas.
