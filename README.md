# challenge-cristeche-ezequiel

Para el proyecto se eligio una arquitectura Hexagonal con DDD (Domain Driven Design) el cual pone todo el foco del proyecto en el nucleo y la logica del dominio.

Sus principios se basan en:

- Colocar los modelos y reglas de negocio de la organización, en el core de la aplicación
- Basar nuestro dominio complejo, en un modelo de software.
- Se utiliza para tener una mejor perspectiva a nivel de colaboración entre expertos del dominio y los desarrolladores, para concebir un software con los objetivos bien claros.

Las ventajas que presenta utilizar arquitectura Hexagonal:

- permite desacoplar nuestra lógica de negocio de nuestro método de entrega, mediante los adaptadores.
- Como cualquier arquitectura basada la inyección de dependencias, nos permite realizar mejores test unitarios a nuestros diferentes componentes.


Dicho esto, el proyecto es un proyecto multi modulo de maven, el cual los modulos estan definidos de la siguiente manera:

- Core : 
  - Domain (cuele ser una representacion de la entities con logica de negocio, pero sin annotations propias del framework que los utilice)
  - Repository (conocido como el adaptador que conectara el modelo de negocio con la capa de infraestructura)
  - Services (nuestros casos de uso. (CreateListing, DeleteListing, UpdateListing, etc)
  
- Web:
  - Controllers (endpoints que comunican la logica del negocio (core) con la capa de implementación (infra)
  - DTOS (Objetos para modelar la información enviada a traves de los endpoints)
  
- Infra:
  - Entity (todas las tablas de la BD que vayamos a implementar con las propias annotations de Spring)
  - Adapter (contiene la implementación que vayamos a utilizar segun nuestro BBDD o lo que sea que implementemos en la capa de Infraestructura que por cuestions de costos o del            negocio necesitemos modificar cambiar)
  - Mapper (Mapea los objetos de Domain a Entity y viceversa)
  - Repository (Es la interfaz que extiende en este caso de JpaRepository para poder acceder a los métodos CRUD que proporciona el mismo)


En este tipo de arquitectura lo que se busca basicamente es que el core (Logica del negocio) sufra lo menos posible cualquier tipo de cambio a nivel infraestructura o proyecto (Cambiar la BD, cambiar el framework)


  
