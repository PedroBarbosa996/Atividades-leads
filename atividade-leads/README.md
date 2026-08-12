
Leads API (esqueleto)
=====================

Endpoints:
- `GET /` → health (OK)
- `POST /leads` → cria lead (ver regra de classificação)
- `GET /leads` → lista leads classificados

Como rodar localmente (Windows):

Com Maven wrapper:
```powershell
.\mvnw.cmd spring-boot:run
```

Com o jar gerado:
```powershell
mvn -DskipTests package
java -jar target\atividade-leads-0.0.1-SNAPSHOT.jar
```

Exemplo de criação de lead:
```bash
curl -X POST http://localhost:8080/leads -H "Content-Type: application/json" -d '{"nome":"Bruno","email":"bruno@example.com","telefone":"11999999999","cpf":"12345678901","consumoMedio":800}'
```
