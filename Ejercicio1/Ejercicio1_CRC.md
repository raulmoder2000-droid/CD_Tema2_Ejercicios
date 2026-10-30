# Ejercicio 1 - Tarjetas CRC

## 1. Tarjetas CRC

### Tarjeta CRC: `Libro`

| Clase: Libro | |
|---|---|
| **Responsabilidades** | **Colaboradores** |
| Conocer su título, autor e ISBN | — |
| Conocer el número de ejemplares disponibles | — |
| Prestar un ejemplar (si hay disponibles) | `Préstamo` |
| Recibir la devolución de un ejemplar | `Préstamo` |

### Tarjeta CRC: `Socio`

| Clase: Socio | |
|---|---|
| **Responsabilidades** | **Colaboradores** |
| Conocer su nombre, número de socio y fecha de alta | — |
| Solicitar el préstamo de un libro | `Libro`, `Préstamo` |
| Devolver un libro prestado | `Préstamo` |

### Tarjeta CRC: `Préstamo`

| Clase: Préstamo | |
|---|---|
| **Responsabilidades** | **Colaboradores** |
| Conocer qué libro y qué socio están implicados | `Libro`, `Socio` |
| Conocer la fecha de inicio del préstamo | — |
| Comprobar si el libro tiene ejemplares antes de prestarlo | `Libro` |
| Registrar la devolución del préstamo | `Libro` |

## 2. Prestar un ejemplar en `Libro`

Primero el libro mira si tiene ejemplares disponibles (más de 0).

- Si tiene, se presta y los ejemplares bajan en 1.
- Si no tiene, no se presta y el libro se queda igual.

Los ejemplares nunca pueden ser negativos.

## 3. Flujo

1. Se crea un libro con 3 ejemplares. Lo hace la clase `Libro`, no necesita a nadie más.
2. Se crean dos socios. Lo hace la clase `Socio`, tampoco necesita colaboradores.
3. El socio 1 pide el libro. `Socio` usa `Préstamo`, y `Préstamo` le pregunta a `Libro` si hay ejemplares. Hay 3, así que sí se lo lleva. Quedan 2.
4. El socio 2 pide el mismo libro. Pasa lo mismo: hay 2, así que también se lo lleva. Queda 1.
5. El socio 1 devuelve el libro. El `Préstamo` se termina y avisa a `Libro`, que suma 1. Quedan 2.
6. El socio 2 lo vuelve a pedir. Hay 2, así que sí puede. Queda 1.

Como el libro tiene 3 ejemplares, todos los préstamos salen bien. Si solo tuviera 1, el socio 2 no podría cogerlo en el paso 4, pero en el paso 6 sí, porque el socio 1 ya lo habría devuelto.
