# practica-1-IS
Herramientas para el desarrollo de proyectos de Software
instrucciones minimas para la ejecuacion 

# Requisitos: 
* Java 21 
* Maven 3.3.4
* Spring boot
## instalacion 
```
git clone <url_del_repositorio>
cd <directorio_del_proyecto>

```
Recuerda configurar las dependencias, si no puedes utilizar 
```
mvn clean install
```
SI estas en VScode, como es mi caso puedes usar, ==Run java== para que se ejecute el proyecto. 
## Prueba de endpoints 
En el navegador preferido, coloca la sig entrada, para lo que es Cerradura Positiva, en /{n} para cambiar n
```
http://localhost:8080/api/cerradura/positiva/3
```
En el caso de la cerradura estrella usa, de igual forma /{n}  
```
http://localhost:8080/api/cerradura/estrella/2
```
