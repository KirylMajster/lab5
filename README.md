##Projekt aplikacji okienkowej Java na przykładzie prostego problemu
 optymalizacyjnego


## Opis

Aplikacja konsolowa w języku Java rozwiązująca **nieograniczony problem plecakowy** metodą zachłanną.

Zawiera:
- losowy generator instancji problemu,
- prosty solver (sortowanie po value/weight),
- testy jednostkowe (JUnit 5).


## Zasada działania

Dany jest zbiór przedmiotów `{wagi, wartości}`. Można brać **dowolną liczbę** sztuk każdego.  
Celem jest **zmaksymalizowanie wartości** plecaka przy ograniczeniu jego pojemności `C`.

Algorytm:
1. Oblicza opłacalność `v/w` dla każdego przedmiotu.
2. Sortuje malejąco.
3. Pakuje tyle sztuk każdego przedmiotu, ile się zmieści, aż do zapełnienia plecaka.

## Technologie

- Java 24
- Maven
- IntelliJ IDEA
- JUnit 5

---

## Testy jednostkowe

Testy napisane z użyciem JUnit sprawdzają m.in.:
- poprawność generatora,
- zakres wag/wartości,
- działanie solvera dla nietrywialnych przypadków.




