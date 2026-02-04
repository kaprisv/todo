ToDo aplikacija sa CRUD funkcijama bez frontend dela.

Ovo su EndPointi koje sam testirao kroz POSTMAN jer nema frontenda:

1 Kreiranje ToDo-a (POST)
URL: `http://localhost:8080/api/todos`
Npr. JSON 
  "title": "Kupiti namirnice",
  "description": "Mleko, jaja, hleb"

2 Pregled svih ToDo-a (GET)
URL: `http://localhost:8080/api/todos`

3 Kreiranje još jednog ToDo-a (POST)
URL: `http://localhost:8080/api/todos`
  "title": "Završiti projekat",
  "description": "Kompletirati Spring Boot ToDo aplikaciju"

4 Pregled jednog ToDo po ID (GET)
URL: `http://localhost:8080/api/todos/1`

5 Ažuriranje ToDo (PUT)
URL `http://localhost:8080/api/todos/1`
Body (raw → JSON):
Ja sam koristio ovako JSON
  "title": "Kupiti namirnice - završeno",
  "description": "Kupio mleko, jaja i hleb"

6 Brisanje ToDo-a (DELETE)
URL: `http://localhost:8080/api/todos/2`

Struktura projekta

entity       ToDo klasa
repository   Komunikacija sa bazom
service      Logika
controller   REST API endpointi

Tehnologije
Spring Boot 3.5.10
Java 21
H2 baza podataka
Spring Data JPA
Lombok
Maven