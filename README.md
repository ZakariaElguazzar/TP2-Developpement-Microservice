# Spring Boot Banking Microservice

## 📋 Project Overview
This project is a Spring Boot banking microservice that provides REST and GraphQL APIs for managing bank accounts. It implements a layered architecture with full CRUD operations and supports multiple data formats.

## 🏗️ Architecture

### Project Structure
```
src/
├── controllers/           # API Controllers
│   ├── accountGraphqlController.java  # GraphQL endpoints
│   └── accountRestController.java     # REST endpoints
├── DTOs/                  # Data Transfer Objects
│   ├── AccountRequestDTO.java
│   └── AccountResponseDTO.java
├── Entities/              # JPA Entities
│   ├── Account.java
│   ├── AccountView.java   # Projection interface
│   └── Customer.java
├── Enums/                 # Enumerations
│   ├── AccountType.java
│   └── CurrencyType.java
├── Exceptions/            # Exception handling
│   └── CustomDataFetcherExceptionResolver.java
├── Mappers/               # Object mappers
│   ├── AccountMapper.java
│   └── AccountMapperImpl.java
├── Repositories/          # Data access layer
│   ├── CustomerRepo.java
│   └── accountRepo.java   # Spring Data REST enabled
└── Services/              # Business logic layer
    ├── accountService.java
    └── accountServiceImpl.java
```

## 🚀 Features

### 1. **Dual API Support**
   - **REST API** with OpenAPI/Swagger documentation
   - **GraphQL API** for flexible queries
   - Both APIs support JSON and XML formats

### 2. **Database**
   - **H2 in-memory database** for development
   - **Spring Data JPA** for data access
   - Automatic schema generation

### 3. **API Features**
   - Full CRUD operations for accounts
   - Support for 10 different currencies
   - Account types: SAVING and CURRENT
   - Automatic timestamp generation
   - UUID-based primary keys

## 🔧 Technologies Used

- **Spring Boot 3.x**
- **Spring Data JPA** - Database abstraction
- **H2 Database** - In-memory database
- **Spring Data REST** - Automatic REST endpoints
- **GraphQL** - Flexible query language
- **Swagger/OpenAPI** - API documentation
- **Lombok** - Reduced boilerplate code
- **Spring Web** - RESTful web services

## 📊 Data Models

### Account Entity
```java
@Entity
public class Account {
    private String id;           // UUID
    private Date createdAt;      // Auto-generated
    private Double balance;
    private CurrencyType currency; // USD, EUR, GBP, etc.
    private AccountType accountType; // SAVING or CURRENT
    private Customer customer;   // Many-to-One relationship
}
```

### Customer Entity
```java
@Entity
public class Customer {
    private String id;           // UUID
    private String name;
    private List<Account> accounts; // One-to-Many relationship
}
```

## 🌐 API Endpoints

### REST API (Port: 8080)

| Method | Endpoint | Description | Consumes | Produces |
|--------|----------|-------------|----------|----------|
| POST | `/api/v1/account/save` | Create account | JSON/XML | JSON/XML |
| GET | `/api/v1/account/get/all` | Get all accounts | - | JSON/XML |
| GET | `/api/v1/account/get/{id}` | Get account by ID | - | JSON/XML |
| PUT | `/api/v1/account/update/{id}` | Update account | JSON/XML | JSON/XML |
| DELETE | `/api/v1/account/delete/{id}` | Delete account | - | - |

**Access:**
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI Docs: `http://localhost:8080/v3/api-docs`

### GraphQL API

**Endpoint:** `/graphql/account`

**Queries:**
```graphql
# Get all accounts
query {
  getAllAccounts {
    id
    balance
    accountType
    currency
    createdAt
    customer {
      id
      name
    }
  }
}

# Get account by ID
query {
  accountById(id: "uuid-here") {
    id
    balance
    accountType
    currency
  }
}
```

**Mutations:**
```graphql
# Create account
mutation {
  createAccount(Account: {
    balance: 1000.0
    accountType: SAVING
    currency: USD
  }) {
    id
    balance
  }
}

# Update account
mutation {
  Update(id: "uuid-here", Account: {
    balance: 1500.0
    accountType: CURRENT
    currency: EUR
  }) {
    id
    balance
  }
}

# Delete account
mutation {
  Delete(id: "uuid-here")
}
```

**Access GraphiQL:** `http://localhost:8080/graphiql`

### Spring Data REST API

**Auto-generated endpoints:**
- `GET /accounts` - List all accounts
- `GET /accounts/{id}` - Get specific account
- `POST /accounts` - Create account
- `PUT /accounts/{id}` - Update account
- `DELETE /accounts/{id}` - Delete account
- `GET /accounts/search/by-currency?curr={currency}` - Find by currency

**Projection support:**
- `GET /accounts/{id}?projection=account_projection` - Get specific fields only

## 🛠️ Development Setup

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Installation Steps

1. **Clone and build:**
```bash
git clone <repository-url>
cd tp2
mvn clean install
```

2. **Run the application:**
```bash
mvn spring-boot:run
```

3. **Access development tools:**
   - Application: `http://localhost:8080`
   - H2 Console: `http://localhost:8080/h2-console`
     - JDBC URL: `jdbc:h2:mem:testdb`
     - Username: `sa`
     - Password: (leave empty)

## 📝 Configuration

### `application.properties`
```properties
spring.application.name=TP2
server.port=8080

# H2 Database Configuration
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA Configuration
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

# GraphQL Configuration
spring.graphql.graphiql.enabled=true
```

## 🔍 Testing the APIs

### Using cURL

**1. Create Account (REST):**
```bash
curl -X POST http://localhost:8080/api/v1/account/save \
  -H "Content-Type: application/json" \
  -d '{
    "balance": 1000.0,
    "accountType": "SAVING",
    "currency": "USD"
  }'
```

**2. Get All Accounts (REST):**
```bash
curl -X GET http://localhost:8080/api/v1/account/get/all \
  -H "Accept: application/json"
```

**3. GraphQL Query:**
```bash
curl -X POST http://localhost:8080/graphql/account \
  -H "Content-Type: application/json" \
  -d '{"query": "query { getAllAccounts { id balance } }"}'
```

## 🎯 Project Requirements Checklist

✅ **1. Créer un projet Spring Boot avec les dépendances Web, Spring Data JPA, H2, Lombok**  
✅ **2. Créer l'entité JPA Compte**  
✅ **3. Créer l'interface CompteRepository basée sur Spring Data**  
✅ **4. Tester la couche DAO** (via H2 console and repository methods)  
✅ **5. Créer le Web service Restfull qui permet de gérer des comptes**  
✅ **6. Tester le web micro-service en utilisant un client REST comme Postman**  
✅ **7. Générer et tester le documentation Swagger de des API Rest du Web service**  
✅ **8. Exposer une API Restful en utilisant Spring Data Rest en exploitant des projections**  
✅ **9. Créer les DTOs et Mappers**  
✅ **10. Créer la couche Service (métier) et du micro service**  
✅ **11. Créer un Web service GraphQL pour ce Micro-service**  

## 🔄 Workflow

### Typical Flow
1. **Client** → REST/GraphQL Controller
2. **Controller** → Service Layer
3. **Service** → Mapper → DTO/Entity conversion
4. **Service** → Repository → Database operations
5. **Database** → H2 in-memory storage

### Exception Handling
- Custom GraphQL exception resolver
- Runtime exceptions for missing resources
- Transaction management with `@Transactional`

## 🧪 Testing

### Available Test Points:
1. **H2 Console**: Direct database access
2. **Swagger UI**: Interactive REST API testing
3. **GraphiQL**: Interactive GraphQL testing
4. **Spring Data REST**: Auto-generated endpoints
5. **cURL/Postman**: Manual API testing

## 📈 Performance Considerations

- **Lazy loading** for relationships
- **DTO pattern** to control exposed data
- **Projections** for partial data retrieval
- **In-memory H2** for development speed

## 🔮 Future Enhancements

Potential improvements:
1. Add authentication/authorization
2. Implement caching with Redis
3. Add comprehensive unit/integration tests
4. Containerize with Docker
5. Add metrics and monitoring
6. Implement pagination for large datasets
7. Add audit logging
8. Support for additional currencies
9. Transaction history tracking

## 📚 Learning Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [GraphQL Java](https://www.graphql-java.com/)
- [Swagger/OpenAPI](https://swagger.io/)
- [H2 Database](https://www.h2database.com/html/main.html)

## 🆘 Troubleshooting

### Common Issues:

1. **H2 Console not accessible:**
   - Ensure `spring.h2.console.enabled=true`
   - Check port 8080 is not in use

2. **GraphiQL not loading:**
   - Verify `spring.graphql.graphiql.enabled=true`
   - Clear browser cache

3. **Database schema issues:**
   - Check `spring.jpa.hibernate.ddl-auto=update`
   - Restart application to regenerate schema

4. **XML not working:**
   - Ensure Jackson XML dependency is included
   - Check `produces` and `consumes` annotations

## 👥 Contributors

This project follows standard Spring Boot conventions and best practices for building microservices with multiple API interfaces.

---

**Note**: This is a development/prototype project using H2 in-memory database. For production, configure a persistent database like PostgreSQL or MySQL.
