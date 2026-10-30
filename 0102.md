# Ejercicio 2

## Iteración 1

### Tarjeta CRC: `Artículo`

| Clase: Artículo | |
|---|---|
| **Responsabilidades** | **Colaboradores** |
| Conocer su nombre | — |
| Conocer su precio unitario | — |

### Tarjeta CRC: `Carrito`

| Clase: Carrito | |
|---|---|
| **Responsabilidades** | **Colaboradores** |
| Añadir artículos | `Artículo` |
| Calcular el total | `Artículo` |
| Saber cuántos artículos tiene | — |

### Casos de prueba

1. Si el carrito está vacío, el total es 0.
2. Si añado un artículo de 10 € y otro de 5 €, el total es 15 € y el carrito tiene 2 artículos.

## Iteración 2

`Artículo` se queda igual. A `Carrito` se le añaden dos cosas nuevas.

### Tarjeta CRC: `Carrito` (actualizada)

| Clase: Carrito | |
|---|---|
| **Responsabilidades** | **Colaboradores** |
| Añadir artículos | `Artículo` |
| Calcular el total | `Artículo` |
| Saber cuántos artículos tiene | — |
| Eliminar un artículo por nombre | `Artículo` |
| Calcular el total con descuento | `Artículo` |

### Casos de prueba nuevos

3. Si tengo "Pan" (1 €) y "Leche" (2 €) y elimino "Pan", queda 1 artículo y el total es 2 €.
4. Si intento eliminar un artículo que no está, el carrito se queda igual.
5. Si el total es 100 € y aplico un 10 % de descuento, el total con descuento es 90 €.
6. Si el descuento es del 0 %, el total no cambia.
