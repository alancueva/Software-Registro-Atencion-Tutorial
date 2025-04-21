# Software de Registro y Atención Tutorial

El software desarrollado es un sistema de Registro y Atención Tutorial diseñado para gestionar la información de tutores en una institución educativa

# 🚀 Proyecto Java 8 con JDK 17 en NetBeans 12.6

Este proyecto está desarrollado en **Java 8** utilizando el **JDK 17** y el IDE **NetBeans 12.6**.

## 📚 Librerías Usadas

El proyecto hace uso de las siguientes librerías:

1. **jcalendar**: Para la selección de fechas en la interfaz gráfica.
2. **json-simple**: Para el manejo de archivos JSON (lectura y escritura).
3. **mysql-connector**: Para la conexión y manipulación de bases de datos MySQL.
4. **poi**: Para la generación y manipulación de archivos de Microsoft Office (Excel, Word).
5. **ICMComponentsMetroUI**: Para componentes de interfaz gráfica con estilo Metro.
6. **RSCalendar**: Para calendarios personalizados en la interfaz gráfica.
7. **RSTableMetro**: Para tablas con estilo Metro en la interfaz gráfica.
8. **itextpdf**: Para la generación de archivos PDF.

### Cómo agregar librerías en NetBeans:

1. Haz clic derecho en el proyecto.
2. Selecciona `Properties`.
3. En la sección `Libraries`, haz clic en `Add JAR/Folder`.
4. Selecciona los archivos `.jar` de las librerías que deseas agregar.

### 📦 Empaquetado para un Instalador
Para empaquetar el proyecto y generar un instalador, seguiremos los siguientes pasos:

1. Crear un JAR Ejecutable
   - En NetBeans, haz clic derecho en el proyecto.
   - Selecciona Clean and Build.
   - NetBeans generará un archivo .jar en la carpeta dist del proyecto.

2. Generar un Instalador con Herramientas Externas
   - Si prefieres usar una herramienta externa, puedes utilizar Inno Setup (para Windows) o Install4j (multi-plataforma) para crear un instalador más personalizado.

### Usar `jpackage` (JDK 14+)
`jpackage` es una herramienta incluida en el JDK 17 que permite crear instaladores nativos.

1. Abre una terminal en la carpeta donde se encuentra el archivo `.jar`.
2. Ejecuta el siguiente comando:

   ```bash
   jpackage --name MiAplicacion --input dist --main-jar MiAplicacion.jar --main-class com.miaplicacion.Main --type exe --win-menu

