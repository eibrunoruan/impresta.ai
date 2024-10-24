package com.emprestaai.emprestaai_backend.model.request;

public class PagamentoAntecipadoRequest {
    private double valor;
    private double taxaJuros;
    private int parcelas;
    private int parcelasPagas;

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public double getTaxaJuros() { return taxaJuros; }
    public void setTaxaJuros(double taxaJuros) { this.taxaJuros = taxaJuros; }

    public int getParcelas() { return parcelas; }
    public void setParcelas(int parcelas) { this.parcelas = parcelas; }

    public int getParcelasPagas() { return parcelasPagas; }
    public void setParcelasPagas(int parcelasPagas) { this.parcelasPagas = parcelasPagas; }
}
