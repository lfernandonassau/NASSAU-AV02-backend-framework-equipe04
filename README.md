# Projeto BackEnd  AV2- Sistema de Agendamento de Consultas

 Esta API foi desenvolvida em **Spring Boot** para gerenciamento de usuários,pacientes,médicos,agendamentos, disponibilidades de salas. Incluindo autenticação, cadastro e fluxo completo de redefinição de senha por e-mail.

## 🚀 Tecnologias Utilizadas

-   **Java 21**
-   **Spring Boot 3**
-   **Spring Security** (Autenticação e Autorização)
-   **Spring Data JPA**
-   **JWT (JSON Web Token)**
-   **Java Mail Sender** (Envio de e-mails)
-   **Maven**
-   **H2 Database / PostgreSQL** 

## ⚙️ Configuração

Para rodar o projeto, você precisa configurar as variáveis de ambiente ou ajustar o arquivo `src/main/resources/application.properties`.

### Configuração de E-mail, Segurança e Conexão com o Banco de Dados
Certifique-se de definir as propriedades abaixo para que o envio de token funcione:

```properties
spring.application.name=ProjetoBackEnd
spring.datasource.url=jdbc:postgresql://localhost:5432/bancobackend
spring.datasource.username=postgres
spring.datasource.password=1234
spring.main.allow-bean-definition-overriding=true
#JPA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=seu-email@gmail.com
spring.mail.password=sua-senha-de-app
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# Configuração JWT
api.security.token.secret=SuaChaveSecreta
api.security.token.expiration=86400000

# URL do Frontend para o link do e-mail
app.reset.base-url=http://localhost:5173/reset-password

##  Como Rodar o Projeto

- **git clone https://github.com/seu-usuario/nome-do-repositorio.git**
- **cd nome-do-repositorio**
- **mvn spring-boot:run**

Autores:
Esse projeto foi realizado por: Celso, João Gabriel,Cauãn e Wlademir. O objetivo de aplicar os conhecimentos dados pelo professor fernando para serem avaliados de forma referente a nota da AV2.
