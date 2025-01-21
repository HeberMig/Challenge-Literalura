Catálogo de Libros
Este proyecto consiste en un Catálogo de Libros que permite a los usuarios interactuar mediante la consola. El catálogo consulta una API externa para obtener información sobre libros y proporciona al menos 5 opciones de interacción diferentes para facilitar la búsqueda y visualización de los mismos.

Objetivo
El objetivo principal de este proyecto fue desarrollar una aplicación en Java que ofrezca una interfaz textual a través de la consola, donde los usuarios puedan interactuar con un catálogo de libros. Para lograrlo, el sistema consume una API específica para obtener datos de libros y luego muestra estos resultados de manera estructurada.

Funcionalidades Implementadas
El sistema permite realizar las siguientes acciones a los usuarios:

Buscar libros por título.
Consultar detalles de un libro específico.
Mostrar una lista de libros recomendados.
Filtrar libros por autor o categoría.
Ver las reseñas de un libro seleccionado.
Estas interacciones se manejan a través de un menú de opciones que se presenta al usuario, quien puede seleccionar la acción deseada mediante números.

Tecnologías Utilizadas
Java: Lenguaje principal para el desarrollo de la aplicación.
API de Libros: Se utiliza para obtener los datos de los libros (título, autor, descripción, etc.).
JSON: El formato de respuesta de la API es en JSON, el cual es procesado para mostrar la información correspondiente.
Base de Datos: La aplicación inserta y consulta datos en una base de datos local para almacenar los libros obtenidos y facilitar búsquedas rápidas.
Proceso de Desarrollo
El proceso de desarrollo siguió los siguientes pasos:

Configuración del Ambiente Java: Se configuró el entorno de desarrollo para Java, incluyendo dependencias y librerías necesarias.
Creación del Proyecto: Se estructuró el proyecto y se organizó el código de manera modular.
Consumo de la API: Se integró la API externa para obtener información sobre los libros.
Análisis de la Respuesta JSON: Se procesó la respuesta de la API para extraer los datos relevantes.
Inserción y Consulta en la Base de Datos: Los datos de los libros fueron almacenados en una base de datos para permitir consultas eficientes.
Exhibición de Resultados al Usuario: Finalmente, se diseñó la interfaz de usuario basada en consola para permitir la interacción con el catálogo.
Cómo Ejecutar el Proyecto
Clona el repositorio en tu máquina local.
Asegúrate de tener Java instalado (se recomienda la versión 11 o superior).
Ejecuta el archivo principal (Main.java) desde la terminal o tu IDE favorito.
Sigue las instrucciones en consola para interactuar con el catálogo de libros.
Contribuciones
Si deseas contribuir a este proyecto, siéntete libre de enviar tus pull requests. Estaré encantado de revisar y colaborar en la mejora del catálogo.
