# 🧪 Personal Project – Spring Boot Demo con MySQL + MongoDB

Questo progetto è una demo educativa che mostra l'integrazione di due flussi separati con Spring Boot:
- 📦 **Product**: persistenza su **MySQL**
- ✍️ **Review**: persistenza su **MongoDB**

## 🚀 Tecnologie utilizzate

- Java 17
- Spring Boot 3.x
- Spring Data JPA (MySQL)
- Spring Data MongoDB
- MapStruct
- Lombok
- Docker & Docker Compose
- Maven

---

## ⚙️ Avvio del progetto

### 🐳 1. Avvio dei database via Docker

Assicurati di avere **Docker** installato, quindi lancia i servizi:

```bash
docker-compose up -d
```

MySQL sarà disponibile su localhost:3307

MongoDB sarà disponibile su localhost:27017

▶️ 2. Avvio dell'applicazione Spring Boot
Puoi avviare l'app da terminale:

```bash
./mvnw spring-boot:run
```
Oppure da IntelliJ IDEA eseguendo DemoApp.java

📚 Configurazione (application.yml)
La configurazione è già pronta per usare:

jdbc:mysql://localhost:3307/demo_db per MySQL

localhost:27017 per MongoDB

Modifica le porte solo se necessario.

🔗 API attive <br>
📦 ProductController (/api/products) <br>
Metodo	Endpoint	Descrizione <br>
GET	/api/products	Recupera tutti i prodotti <br>
POST	/api/products	Crea un nuovo prodotto

✍️ ReviewController (/api/reviews) <br>
Metodo	Endpoint	Descrizione <br>
GET	/api/reviews	Recupera tutte le recensioni <br>
POST	/api/reviews	Crea una nuova recensione

🧪 Test (in fase di sviluppo)
Saranno aggiunti test unitari e di integrazione per:

Service e Repository layer

Mapper con MapStruct

API REST (controller)

📦 Struttura del progetto

├── controller
├── dto
├── entity
├── mapper
├── repository
├── service
└── docker-compose.yml
👤 Autore
Nome: Pierre Donato Fortunato

GitHub: pdfortunato