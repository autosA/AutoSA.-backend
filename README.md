El proyecto consiste en desarrollar una página web para la venta de automóviles llamada " ", que incluye funcionalidades tanto para clientes como para administradores. A continuación, se describen las principales características:

Gestión de Automóviles:

Se podrán obtener todos los automóviles disponibles desde el backend, mostrando detalles como modelo, marca, precio, año y estado (disponible/vendido).
Cada automóvil estará asociado al administrador que lo haya publicado.

Funcionalidades para Clientes:

Los clientes podrán registrarse en la página web.
Un cliente logueado podrá comprar automóviles disponibles. Una vez realizada la compra, el automóvil se asociará al cliente comprador y su estado cambiará a "VENDIDO".

Funcionalidades para Administradores:

Los administradores podrán crear nuevas publicaciones de automóviles, el auto se asocia al id del administrador que lo publica.
Tendrán la capacidad de eliminar publicaciones de automóviles.
Podrán gestionar los clientes registrados, incluyendo la opción de eliminar clientes si es necesario.

Relación entre entidades:

Los automóviles estarán vinculados al administrador que los haya publicado.
Los clientes que compren un automóvil quedarán asociados como propietarios del mismo.
