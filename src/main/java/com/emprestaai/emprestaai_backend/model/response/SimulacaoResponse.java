package com.emprestaai.emprestaai_backend.model.response;

public class SimulacaoResponse {
    private double totalPago;
    private double valorParcela;

    public SimulacaoResponse(double totalPago, double valorParcela) {
        this.totalPago = totalPago;
        this.valorParcela = valorParcela;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public double getValorParcela() {
        return valorParcela;
    }
}
