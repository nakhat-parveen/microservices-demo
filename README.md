# Microservices Demo

A multi service Spring Boot application demonstrating a microservices architecture. I built it to explore service discovery, API routing, circuit breaking, and inter service security patterns used in real enterprise systems.

---

## Services Overview

```
                        ┌─────────────────┐
                        │   API Gateway   │  ← Single entry point for all clients
                        │   (Port 8989)   │
                        └────────┬────────┘
                                 │
              ┌──────────────────┼──────────────────┐
              │                  │                  │
   ┌──────────▼────────┐ ┌───────▼────────┐ ┌──────▼──────────────┐
   │ Citizen Service   │ │ Vaccination    │ │  Spring Security    │
   │ (Port 8069)       │ │ Service        │ │  (Auth Service)     │
   │                   │ │ (Port 8065)    │ │  (Port 8001)        │
   └───────────────────┘ └────────────────┘ └─────────────────────┘
              │                  │
              └──────────────────┘
                        │
              ┌──────────▼────────┐
              │   Eureka Server   │  ← Service registry and discovery
              │   (Port 8761)     │
              └───────────────────┘
```

---

## Services

### API Gateway
Routes all incoming client requests to the appropriate microservice. Acts as the single entry point, clients never call individual services directly.

### Eureka Server
Service registry. Each microservice registers itself on startup. The API Gateway uses Eureka to discover service locations dynamically, so no hardcoded URLs are needed between services.

### Citizen Microservice
Manages citizen records. Exposes REST endpoints for creating, reading, updating, and deleting citizen data.

### Vaccination Service
Manages vaccination records linked to citizens. Communicates with the Citizen Service via REST to validate citizen data before recording vaccinations.

### Spring Security Service
Handles authentication and authorisation across the system. Demonstrates how to secure microservice endpoints.

### Resilience4j (Circuit Breaker)
Implements fault tolerance using the circuit breaker pattern. If a downstream service is unavailable, the circuit opens and returns a fallback response, preventing cascading failures across the system.

---

## Tech Stack

| Component | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot |
| Service Discovery | Spring Cloud Netflix Eureka |
| API Gateway | Spring Cloud Gateway |
| Security | Spring Security |
| Fault Tolerance | Resilience4j |
| Build Tool | Maven |
| API Style | RESTful |

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+

### 1. Clone the repository

```bash
git clone https://github.com/nakhat-parveen/microservices-demo.git
cd microservices-demo
```

### 2. Start services in order

Services must start in this order because of Eureka dependency:

```bash
# 1. Start Eureka Server first
cd eureka-server && mvn spring-boot:run

# 2. Start the Auth service
cd ../spring-security && mvn spring-boot:run

# 3. Start the Citizen microservice
cd ../citizen-microservice && mvn spring-boot:run

# 4. Start the Vaccination service
cd ../vaccination-service && mvn spring-boot:run

# 5. Start the API Gateway last
cd ../api-gateway && mvn spring-boot:run
```

### 3. Verify Eureka dashboard

Open `http://localhost:8761` in your browser. All running services should be listed as registered instances.

### 4. Call services through the gateway

All requests go through the API Gateway on port 8989:

```
GET  http://localhost:8989/citizens
POST http://localhost:8989/citizens
GET  http://localhost:8989/vaccinations
POST http://localhost:8989/vaccinations
```

---

## Key Concepts Demonstrated

**Service Discovery** — Services register with Eureka on startup and discover each other by name, not hardcoded IP. This is how scalable production systems avoid tight coupling between services.

**API Gateway** — A single entry point for clients. Routes requests, can handle rate limiting, authentication, and logging in one place.

**Circuit Breaker (Resilience4j)** — If a service call fails repeatedly, the circuit opens and a fallback is returned. Prevents one failing service from bringing down the entire system.

**Separation of Concerns** — Each service owns its own domain (citizens vs vaccinations), communicates via REST, and can be deployed and scaled independently.

---

## Author

**Nakhat Parveen** — Java Software Engineer, Berlin  
[LinkedIn](https://www.linkedin.com/in/nakhat-parveen-915483129) · [GitHub](https://github.com/nakhat-parveen)
