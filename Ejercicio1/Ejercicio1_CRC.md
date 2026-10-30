# Ejercicio 1 - Tarjetas CRC

## 1. Tarjetas CRC

### Libro

| Responsabilidades | Colaboradores |
|---|---|
| Saber su titulo, autor, ISBN y ejemplares disponibles | Prestamo |
| Comprobar si quedan ejemplares | |
| Restar un ejemplar cuando se presta | |
| Sumar un ejemplar cuando se devuelve | |

### Socio

| Responsabilidades | Colaboradores |
|---|---|
| Saber su nombre, numero de socio y fecha de alta | Prestamo |
| Pedir un libro prestado | Libro |
| Devolver un libro | |

### Prestamo

| Responsabilidades | Colaboradores |
|---|---|
| Saber que socio tiene que libro | Socio |
| Saber la fecha del prestamo | Libro |
| Saber si el libro ya se ha devuelto | |
| Hacer el prestamo si hay ejemplares | |
| Terminar el prestamo cuando se devuelve el libro | |

## 2. Prestar un ejemplar en Libro

Primero el libro mira si tiene ejemplares disponibles (mas de 0).

- Si tiene, se presta y los ejemplares bajan en 1.
- Si no tiene, no se presta y el libro se queda igual.

Los ejemplares nunca pueden ser negativos.

## 3. Flujo

1. Se crea un libro con 3 ejemplares. Lo hace la clase Libro, no necesita a nadie mas.
2. Se crean dos socios. Lo hace la clase Socio, tampoco necesita colaboradores.
3. El socio 1 pide el libro. Socio usa Prestamo, y Prestamo le pregunta a Libro si hay ejemplares. Hay 3, asi que si se lo lleva. Quedan 2.
4. El socio 2 pide el mismo libro. Pasa lo mismo: hay 2, asi que tambien se lo lleva. Queda 1.
5. El socio 1 devuelve el libro. El Prestamo se termina y avisa a Libro, que suma 1. Quedan 2.
6. El socio 2 lo vuelve a pedir. Hay 2, asi que si puede. Queda 1.

Como el libro tiene 3 ejemplares, todos los prestamos salen bien. Si solo tuviera 1, el socio 2 no podria cogerlo en el paso 4, pero en el paso 6 si, porque el socio 1 ya lo habria devuelto.
