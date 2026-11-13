# 🛒 Product AI Assistant

An AI-powered Product Assistant built using **Java, Spring Boot, Spring AI, OpenAI, and Model Context Protocol (MCP)**. The application allows users to interact with an AI assistant through a web interface to explore products and perform product-related operations using MCP tools.

The project follows a client-server architecture, where the AI client communicates with a separately deployed MCP server.

## 🚀 Project Overview

The Product AI Assistant consists of two independent Spring Boot applications:

1. **Product Client** – Provides the web interface and communicates with the AI model.
2. **Product Server** – Exposes product-related functionalities as MCP tools.

The AI client connects to the MCP server using Streamable HTTP and uses the available tools to process product-related user requests.

## 🏗️ Architecture

```text
                  User
                    |
                    v
          Product AI Web Interface
                    |
                    v
             Product Client
             (Spring Boot)
                    |
                    v
              Spring AI
                    |
                    v
                OpenAI
                    |
                    v
              MCP Client
                    |
          Streamable HTTP
                    |
                    v
              MCP Server
             (Spring Boot)
                    |
                    v
             MCP Tool Services
                    |
          +---------+---------+
          |                   |
          v                   v
     Product Service      Cart Service
          |                   |
          +---------+---------+
                    |
                    v
             Product Operations
```

## 📌 Applications

### 1. Product Client – Product-Client1

The Product Client is the user-facing Spring Boot application.

**Responsibilities:**
- Provides an interactive web interface using HTML and Thymeleaf.
- Accepts user queries through a chat interface.
- Integrates OpenAI using Spring AI.
- Connects to the remote MCP server.
- Uses available MCP tools to handle product-related requests.
- Returns AI-generated responses to the user.

**Main technologies:**
- Java
- Spring Boot
- Spring AI
- OpenAI
- Thymeleaf
- HTML and CSS
- Maven

### 2. Product Server – Product-Server

The Product Server is an independent Spring Boot application that exposes product-related operations through MCP tools.

**Responsibilities:**
- Configures the MCP server using Spring AI.
- Exposes product-related tools.
- Handles product operations.
- Handles cart-related operations.
- Communicates with the Product Client through Streamable HTTP.

**Main components:**
- `McpConfig.java` – MCP server configuration.
- `Product.java` – Product model.
- `Cart.java` – Cart model.
- `ProductService.java` – Product-related business logic.
- `CartService.java` – Cart-related business logic.
- `ToolsService.java` – MCP tool implementation.

## ✨ Key Features

- AI-powered product assistance.
- Interactive web-based chat interface.
- Spring AI and OpenAI integration.
- Model Context Protocol (MCP) integration.
- Client-server architecture.
- Remote MCP server communication.
- Streamable HTTP communication.
- Product and cart-related operations.
- Independent deployment of client and server.
- Cloud deployment using Zoho Catalyst AppSail.

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java | Programming language |
| Spring Boot | Backend application development |
| Spring AI | AI integration |
| OpenAI | Language model |
| Model Context Protocol (MCP) | AI-to-tool communication |
| Streamable HTTP | Client-server MCP communication |
| Maven | Dependency and build management |
| Thymeleaf | Dynamic web pages |
| HTML / CSS | User interface |
| Zoho Catalyst | Cloud deployment |
| Git & GitHub | Version control |

## 📂 Project Structure

```text
Product-AI/
│
├── Product-Client1/
│   └── Product-Client1/
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/
│       │   │   │   └── com/iss/Product_Client1/
│       │   │   │       ├── controllers/
│       │   │   │       │   └── ClientController.java
│       │   │   │       ├── services/
│       │   │   │       │   └── ClientService.java
│       │   │   │       └── ProductClient1Application.java
│       │   │   └── resources/
│       │   │       ├── templates/
│       │   │       │   └── aihome.html
│       │   │       └── application.properties
│       │   └── test/
│       ├── pom.xml
│       └── app-config.json
│
├── Product-Server/
│   └── Product-Server/
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/
│       │   │   │   └── com/iss/Product_Server/
│       │   │   │       ├── configs/
│       │   │   │       │   └── McpConfig.java
│       │   │   │       ├── models/
│       │   │   │       │   ├── Cart.java
│       │   │   │       │   └── Product.java
│       │   │   │       ├── services/
│       │   │   │       │   ├── CartService.java
│       │   │   │       │   ├── ProductService.java
│       │   │   │       │   └── ToolsService.java
│       │   │   │       └── ProductServerApplication.java
│       │   │   └── resources/
│       │   │       └── application.properties
│       │   └── test/
│       ├── pom.xml
│       └── app-config.json
│
└── .gitignore
```

## ⚙️ Prerequisites

Before running the project, install:

- Java JDK 17 or compatible version configured for the project.
- Maven.
- IntelliJ IDEA or another Java IDE.
- OpenAI API key.
- Git.

## 🔧 Configuration

Both applications require their own configuration.

### Product Server

Open:

`Product-Server/Product-Server/src/main/resources/application.properties`

Configure your application properties and OpenAI key through environment variables where required.

Example:

```properties
spring.application.name=Product-Server

spring.ai.openai.api-key=${OPENAI_API_KEY}
```

### Product Client

Open:

`Product-Client1/Product-Client1/src/main/resources/application.properties`

Example configuration:

```properties
spring.application.name=Product-Client-Ai

spring.ai.openai.api-key=${OPENAI_API_KEY}

spring.ai.mcp.client.enabled=true
spring.ai.mcp.client.type=SYNC

spring.ai.mcp.client.streamable-http.connections.mcpserver.url=${MCP_SERVER_URL}
```

Set the following environment variables before starting the applications:

```text
OPENAI_API_KEY=your_openai_api_key
MCP_SERVER_URL=your_mcp_server_url
```

**Important:** Never commit API keys, passwords, or other secrets to GitHub.

## ▶️ Running the Project Locally

### Step 1: Clone the Repository

```bash
git clone https://github.com/thayeeb14/Product-AI.git
```

### Step 2: Start the Product Server

Open the Product Server project:

```bash
cd Product-AI/Product-Server/Product-Server
```

Run:

```bash
mvn spring-boot:run
```

Make sure the MCP server starts successfully.

### Step 3: Configure the Product Client

Set `MCP_SERVER_URL` to the address of your running MCP server.

Configure your OpenAI API key as an environment variable.

### Step 4: Start the Product Client

Open another terminal:

```bash
cd Product-AI/Product-Client1/Product-Client1
```

Run:

```bash
mvn spring-boot:run
```

### Step 5: Access the Application

Open the client application in your browser using its configured local port.

For the deployed application, use the link in the Deployment section.

## ☁️ Deployment – Zoho Catalyst

Both applications have been deployed independently using **Zoho Catalyst AppSail**.

### Product Server

**Deployment URL:**

https://product-server-50047574653.development.catalystappsail.in

### Product Client

**Deployment URL:**

https://product-client-ai-50047610662.development.catalystappsail.in

**Application Interface:**

https://product-client-ai-50047610662.development.catalystappsail.in/ai

The Product Client communicates with the hosted Product Server through its MCP Streamable HTTP endpoint.

## 🧠 What I Learned

Through this project, I gained practical experience in:

- Developing applications using Java and Spring Boot.
- Integrating OpenAI with Spring AI.
- Understanding and implementing Model Context Protocol.
- Building MCP tools for backend operations.
- Implementing client-server communication.
- Working with Streamable HTTP.
- Managing Maven-based projects.
- Deploying Spring Boot applications to Zoho Catalyst.
- Configuring environment variables and application properties.
- Managing source code using Git and GitHub.

## 🔮 Future Enhancements

- Database integration for persistent product and cart data.
- User authentication and authorization.
- Product search and filtering.
- Product recommendations using AI.
- Order management and purchase history.
- Improved chat interface and conversation history.
- Additional MCP tools for advanced product operations.

## 👨‍💻 Developer

**Thayeeb**

GitHub: [@thayeeb14](https://github.com/thayeeb14)

Project Repository: [Product-AI](https://github.com/thayeeb14/Product-AI)

---

⭐ If you find this project interesting, feel free to explore the repository and share your feedback.

**Built with Java, Spring Boot, Spring AI, OpenAI and MCP.**