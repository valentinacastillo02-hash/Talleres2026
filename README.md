### Descripciòn

El proyecto consiste en desarrollar un programa en Java  que permita registrar, administrar y calcular métricas sobre los choripanes comidos y los terremotos tomados por un grupo de personas La idea principal es crear un sistema interactivo mediante un menú, que lea información desde archivos de texto, permita modificarla y guarde los cambios para que no se pierdan al cerrar el programa.

### Integrantes

• Nombre: Catalina Fica | RUT: 21.779.663-6 | Usuario GitHub: panconmayo-pixel (https://github.com/panconmayo-pixel) | Carrera: Ingeniería Civil en Computación e Informática

•Nombre: Valentina Castillo | RUT: 15.166.692-2 | Usuario GitHub: valentinacastillo02-hash(https://(https://github.com/valentinacastillo02-hash) | Carrera: Ingeniería en tecnologias de informaciòn
### Estructura repositorio
Package/
├── src/
│   ├── Choripan.java
│   ├── Consumidor.java
│   ├── GestorConsumo.java
│   ├── Terremoto.java
│   └── taller_2.java
├── bin/
├── Consumido.txt
├── Participantes (1).txt
├── .project
└── README.md
### Descripciòn archivos
- Choripan.java: representa un consumo de choripán y almacena sus datos.
- Consumidor.java: representa a un participante y permite consultar información asociada a sus consumos.
- GestorConsumo.java: administra los registros, incluyendo operaciones de consulta, creación, edición, eliminación y persistencia.
- Terremoto.java: representa un consumo de terremoto y almacena sus datos.
- taller_2.java: contiene el método principal, los menús interactivos, la lectura de archivos y la coordinación de las funcionalidades.
- Consumido.txt: almacena los registros de consumo.
- Participantes.txt: contiene los nombres de los participantes, uno por línea.
- bin/: almacena los archivos compilados .class.
- .project: contiene la configuración del proyecto para Eclipse.
### Funcionalidades principales
 Ver registros
- Visualizar los registros de choripanes.
- Visualizar los registros de terremotos.

 Actualizar registros
- Agregar nuevos consumos.
- Editar registros existentes.
- Eliminar registros.
- Guardar las modificaciones en Consumido.txt.

 Metricas
- Cantidad total de choripanes consumidos.
- Cantidad total de terremotos tomados.
- Cantidad de choripanes por usuario.
- Cantidad de terremotos por usuario.
- Kilocalorías consumidas por usuario.
- Días ebrio por usuario.
- Reglas de cálculo
- Las métricas utilizan las siguientes fórmulas:
- Kilocalorías de un choripán:
- Kcal = (Largo * Ancho) / 3
- Kilocalorías de un terremoto:
- Kcal = (Litros * 10) / 3
- Días ebrio: se cuenta un día cuando un participante consume 2 litros de terremoto o más durante una misma fecha. Se deben sumar todos los registros de terremoto de esa persona correspondientes a ese día.
### Requisitos de entorno
- Java JDK instalado.
- Eclipse IDE o una terminal compatible con Java.
- Archivos Participantes.txt y Consumido.txt disponibles en el directorio de trabajo.
- Consola para interactuar con los menús del programa.
### Tecnologias utilizadas
- Java
- Programación Orientada a Objetos (POO)
- Manejo de archivos de texto
- Arreglos y estructuras de datos
- Menús interactivos por consola

