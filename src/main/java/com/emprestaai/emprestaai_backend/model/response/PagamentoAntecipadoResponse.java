package com.emprestaai.emprestaai_backend.model.response;

public class PagamentoAntecipadoResponse {
    private double valorEconomizado;
    private double novoValorTotal;

    public PagamentoAntecipadoResponse(double valorEconomizado, double novoValorTotal) {
        this.valorEconomizado = valorEconomizado;
        this.novoValorTotal = novoValorTotal;
    }

    public double getValorEconomizado() { return valorEconomizado; }
    public double getNovoValorTotal() { return novoValorTotal; }
}
