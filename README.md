# Empresta-Ai

**Projeto de POO - Universidade Católica de Santa Catarina**  
Bem-vindo ao repositório do **Empresta-Ai**, uma API desenvolvida para gerenciar e organizar empréstimos de itens de forma simples e eficiente. Este projeto é parte do curso de Programação Orientada a Objetos (POO).

---

## 📘 **Descrição**

O **Empresta-Ai** é uma API

- Simular empréstimo.
- Simular pagamentos antecipados no empréstimo.

---

## 🚀 **Endpoints**

### 1. Simular Empréstimo

- **Endpoint**: `POST https://imprestaai-api.up.railway.app/api/emprestimos/simular`
- **Descrição**: Este endpoint simula o cálculo de um empréstimo com base nas condições fornecidas. Ele retorna o valor das parcelas e outros detalhes do empréstimo.

##### **Exemplo de Request Body**:

```json
{
  "valor": 20000,
  "taxaJuros": 2.54,
  "parcelas": 24,
  "tipoEmprestimo": "PESSOAL" //TIPOS: CONSIGNADO, PESSOAL, FGTS
}
```
### 2. Simular Pagamento Antecipado

- **Endpoint**: `POST https://imprestaai-api.up.railway.app/api/emprestimos/pagamento-antecipado`
- **Descrição**: Este endpoint simula o cálculo de pagamento antecipado no empréstimo.

  ##### **Exemplo de Request Body**:

```json
{
  "valor": 20000,
  "taxaJuros": 2.54,
  "parcelas": 24,
  "parcelasPagas": 10
}
```

