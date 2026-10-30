# Ejercicio 1 — Diseño con Tarjetas CRC (Biblioteca)

## 1. Tarjetas CRC

### Clase: Libro

| Responsabilidades | Colaboradores |
|---|---|
| Conocer su título, autor e ISBN | Préstamo |
| Conocer el número de ejemplares disponibles | |
| Comprobar si hay ejemplares disponibles | |
| Prestar un ejemplar (restar 1 a los disponibles) | |
| Recibir una devolución (sumar 1 a los disponibles) | |

### Clase: Socio

| Responsabilidades | Colaboradores |
|---|---|
| Conocer su nombre, número de socio y fecha de alta | Préstamo |
| Solicitar el préstamo de un libro | Libro |
| Devolver un libro prestado | |

### Clase: Préstamo

| Responsabilidades | Colaboradores |
|---|---|
| Conocer qué socio y qué libro intervienen | Socio |
| Conocer la fecha del préstamo (y de devolución) | Libro |
| Saber si está activo o ya se ha devuelto | |
| Crear el préstamo si el libro tiene ejemplares | |
| Finalizar el préstamo y avisar al libro de la devolución | |

## 2. Qué ocurre en `Libro` al prestar un ejemplar

**Antes de prestar**, el libro comprueba si `ejemplaresDisponibles > 0`.

- **Si hay ejemplares (éxito):** se resta 1 a `ejemplaresDisponibles` y se indica que el préstamo se ha realizado (devuelve `true`).
- **Si no hay ejemplares (fallo):** el objeto **no cambia**; los ejemplares siguen en 0 y se indica que no se ha podido prestar (devuelve `false`).

El número de ejemplares nunca puede quedar en negativo.

## 3. Flujo paso a paso

1. **Alta de un libro con 3 ejemplares.** Actúa `Libro`: se crea con título, autor, ISBN y `ejemplaresDisponibles = 3`. No necesita colaboradores.
2. **Alta de dos socios.** Actúa `Socio`: se crean dos objetos con nombre, número de socio y fecha de alta. No necesitan colaboradores.
3. **El primer socio toma prestado el libro.** `Socio` colabora con `Préstamo`, que pregunta a `Libro` si hay ejemplares. Hay 3 → se crea el préstamo y quedan **2**. ✅ **Éxito.**
4. **El segundo socio intenta tomar el mismo libro.** `Socio` → `Préstamo` → `Libro`. Hay 2 → se crea el préstamo y queda **1**. ✅ **Éxito.**
5. **El primer socio devuelve el libro.** `Socio` colabora con su `Préstamo`, que se marca como finalizado y avisa a `Libro`, que suma 1 → quedan **2**.
6. **El segundo socio vuelve a intentar tomar el libro.** `Socio` → `Préstamo` → `Libro`. Hay 2 → se crea el préstamo y queda **1**. ✅ **Éxito.**

**Conclusión:** con 3 ejemplares todos los intentos tienen éxito. El segundo socio solo habría fallado en el paso 4 si el libro tuviera 1 ejemplar; en ese caso, tras la devolución del paso 5, en el paso 6 sí podría tomarlo.

## Implementación en Java

En la carpeta `src/` están las clases `Libro`, `Socio`, `Prestamo` y un `Main` que ejecuta el flujo del apartado 3. Salida:

```
Alta libro: El Quijote -> ejemplares: 3
Alta socios: Ana y Luis
Ana pide el libro: EXITO -> ejemplares: 2
Luis pide el libro: EXITO -> ejemplares: 1
Ana devuelve el libro -> ejemplares: 2
Luis pide el libro: EXITO -> ejemplares: 1
```
