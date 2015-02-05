# ShareAirMusic
Autores del proyecto:
- Jesús Maillo Hidalgo
- Sergio González Vázquez

Servicio RESTful orientado a compartir información sobre la aplicación en construcción AirMusic.

El servicio se encuentra desplegado y accesible desde internet en la dirección http://share-airmusic.rhcloud.com/ShareAirMusicServer/

Demostración de que el servidor está activo en esta dirección: Consulta del usuario lena. http://share-airmusic.rhcloud.com/ShareAirMusicServer/user/lena

El trabajo se ha desarrollado en el repositorio: https://github.com/OinkEnterprise/ShareAirMusic

En el se encuentra:

- ShareAirMusicServer
  + Es el servidor y dentro de este directorio se encuentra tanto los ficheros fuentes como el despegable .war.
  + No es un proyecto Eclipse, se encuentran los ficheros fuente necesarios para construirlo.

- ShareAirMusicCliente
  + Es el cliente en Java Swing. Se pueden encontrar los fuentes y dos ejecutables .jar.
  + ShareAirMusicCliente.jar conecta con el servicio desplegado en internet.
  + ShareAirMusicClienteLocal.jar conecta con el servicio desplegado en local (Previamente hay que desplegarlo correctamente). http://localhost:8080/ShareAirMusicServer/

Para probar la aplicación se recomienda utilizar el que está orientado al usuario final, "ShareAirMucisCliente.jar", en el cual ya se encuentran introducidos mediante un programa en Java una serie de usuarios, instrumentos y sets. Debido a que las consultas poseen archivos multimedia puede tardar un poco en procesarlo el cliente, se ruega que se tenga paciencia.

El cliente está diseñado de manera óptimizada para una pantalla widescreen de 1920x1080, por lo que se recomienda usarlo de esa manera. En el caso de ejecutarlo en una pantalla con menor resolución, este intentará adaptarse a la misma, aunque no se asegura que todo se vea perfectamente.   

Los usuarios y sus contraseñas son:
- Usuario: lena | Contraseña: 123lena
- Usuario: paquirrin | Contraseña: 123paquirrin
- Usuario: who | Contraseña: 123lwho
- Usuario: skrillex | Contraseña: 123skrillex
- Usuario: koala | Contraseña: 123koala

Al inicio de la aplicación podemos logearnos o registrarnos a la izquierda.
A la derecha, consultar los sets y los instrumentos según su estilo de música haciendo click en las imágenes. No es necesario estar logeado para utilizar esta funcionalidad.
El campo de búsqueda es para buscar todos los instrumentos y sets según su nombre. No es una búsqueda textual, no diferencia mayúsculas y minúsculas, etc.
En la parte superior izquierda encontramos un botón de "home" para volver a la pantalla principal.

Una vez accedemos al usuario podemos:
- Consultar/modificar el perfil.
- Consultar los instrumentos propios y mediante el botón del lápiz y papelera modificarlos o eliminarlos.
- Consultar los sets propios y mediante el botón del lápiz y papelera modificarlos o eliminarlos.
- Cerrar sesión.

Así mismo se podrán reproducir los sonidos de los instrumentos. Al ser de prueba, hay un total de 5 instrumentos por lo que se verán repetidos en estos usuarios.
