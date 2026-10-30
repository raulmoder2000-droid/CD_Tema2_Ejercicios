# Ejercicio 1

## 1. Tarjetas CRC

### Tarjeta CRC: `Libro`

| Clase: Libro | |
|---|---|
| **Responsabilidades** | **Colaboradores** |
| Conocer su título, autor e ISBN | — |
| Conocer cuántos ejemplares tiene disponibles | — |
| Prestar un ejemplar | `Préstamo` |
| Recibir la devolución de un ejemplar | `Préstamo` |

### Tarjeta CRC: `Socio`

| Clase: Socio | |
|---|---|
| **Responsabilidades** | **Colaboradores** |
| Conocer su nombre, número de socio y fecha de alta | — |
| Pedir un libro prestado | `Libro`, `Préstamo` |
| Devolver un libro | `Préstamo` |

### Tarjeta CRC: `Préstamo`

| Clase: Préstamo | |
|---|---|
| **Responsabilidades** | **Colaboradores** |
| Saber qué socio tiene qué libro | `Libro`, `Socio` |
| Saber la fecha del préstamo | — |
| Registrar la devolución | `Libro` |

## 2. Prestar un ejemplar

1. El libro mira si tiene ejemplares disponibles.
2. Si tiene, se presta y tiene un ejemplar menos.
3. Si no tiene, no se presta y el libro se queda igual.

## 3. Flujo

1. Se crea un libro con 3 ejemplares (`Libro`).
2. Se crean dos socios (`Socio`).
3. El socio 1 pide el libro: sí puede. Quedan 2.
4. El socio 2 pide el libro: sí puede. Queda 1.
5. El socio 1 devuelve el libro. Quedan 2.
6. El socio 2 lo vuelve a pedir: sí puede. Queda 1.

En los pasos 3, 4 y 6 actúa `Socio`, que usa `Préstamo`, y `Préstamo` le pregunta a `Libro` si hay ejemplares. En el paso 5, `Préstamo` avisa a `Libro` para que sume un ejemplar.
