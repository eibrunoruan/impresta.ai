package com.emprestaai.emprestaai_backend.model.request;

import com.emprestaai.emprestaai_backend.taxa.TipoEmprestimo;

public class SimulacaoRequest {
    private double valor;
    private double taxaJuros;
    private int parcelas;
    private TipoEmprestimo tipoEmprestimo;

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public double getTaxaJuros() { return taxaJuros; }
    public void setTaxaJuros(double taxaJuros) { this.taxaJuros = taxaJuros; }

    public int getParcelas() { return parcelas; }
    public void setParcelas(int parcelas) { this.parcelas = parcelas; }

    public TipoEmprestimo getTipoEmprestimo() { return tipoEmprestimo; }
    public void setTipoEmprestimo(TipoEmprestimo tipoEmprestimo) {
        this.tipoEmprestimo = tipoEmprestimo;
    }
}

