# Ejercicio 3

## 1. Modelo de ciclo de vida

Iterativo. El enunciado dice que los requisitos van a cambiar con el feedback de los clientes piloto. En cascada los requisitos se cierran al principio y luego es difícil cambiarlos. Con un modelo iterativo se hace el sistema por partes y se puede cambiar en cada vuelta.

## 2. Metodología

Ágil. Métrica v3 es muy formal y tiene mucha documentación, y va mejor cuando los requisitos están claros desde el principio. Aquí van a cambiar, así que es mejor Ágil, porque se entrega en iteraciones cortas y se tiene en cuenta lo que dice el cliente en cada una.

## 3. Tarjetas CRC

### Tarjeta CRC: `Envío`

| Clase: Envío | |
|---|---|
| **Responsabilidades** | **Colaboradores** |
| Conocer su número de seguimiento | — |
| Conocer su estado actual | — |
| Conocer el repartidor que lo lleva | `Repartidor` |
| Actualizar su estado | `Repartidor` |
| Mostrar su estado al cliente | — |

### Tarjeta CRC: `Repartidor`

| Clase: Repartidor | |
|---|---|
| **Responsabilidades** | **Colaboradores** |
| Conocer su nombre y su número de repartidor | — |
| Conocer los envíos que tiene asignados | `Envío` |
| Cambiar el estado de un envío | `Envío` |

## 4. Actualizar el estado de un `Envío`

- **Qué recibe:** el nuevo estado.
- **Valores posibles:** `"EN_ALMACÉN"`, `"EN_REPARTO"`, `"ENTREGADO"` y `"DEVUELTO"`.
- **Cómo funciona:**
  1. El envío mira si el nuevo estado es uno de esos cuatro.
  2. Si es válido, cambia su estado al nuevo.
  3. Si no es válido, no cambia nada.
- **Qué devuelve:** `true` si el cambio se ha hecho y `false` si no se ha hecho.
