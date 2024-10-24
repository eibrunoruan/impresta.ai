package com.emprestaai.emprestaai_backend.model.response;

public class ComparacaoInvestimentoResponse {
    private double totalPago;
    private double rendimentoPoupanca;
    private double rendimentoCDB;

    public ComparacaoInvestimentoResponse(double totalPago, double rendimentoPoupanca, double rendimentoCDB) {
        this.totalPago = totalPago;
        this.rendimentoPoupanca = rendimentoPoupanca;
        this.rendimentoCDB = rendimentoCDB;
    }

    public double getTotalPago() { return totalPago; }
    public double getRendimentoPoupanca() { return rendimentoPoupanca; }
    public double getRendimentoCDB() { return rendimentoCDB; }
}
