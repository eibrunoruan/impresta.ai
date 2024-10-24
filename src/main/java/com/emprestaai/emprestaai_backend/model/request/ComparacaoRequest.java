package com.emprestaai.emprestaai_backend.model.request;

import com.emprestaai.emprestaai_backend.taxa.TipoEmprestimo;

public class ComparacaoRequest {
    private double valorAVista;
    private int parcelas;
    private double taxaJuros;
    private TipoEmprestimo tipoEmprestimo;

    public double getValorAVista() { return valorAVista; }
    public void setValorAVista(double valorAVista) { this.valorAVista = valorAVista; }

    public int getParcelas() { return parcelas; }
    public void setParcelas(int parcelas) { this.parcelas = parcelas; }

    public double getTaxaJuros() { return taxaJuros; }
    public void setTaxaJuros(double taxaJuros) { this.taxaJuros = taxaJuros; }

    public TipoEmprestimo getTipoEmprestimo() { return tipoEmprestimo; }
    public void setTipoEmprestimo(TipoEmprestimo tipoEmprestimo) {
        this.tipoEmprestimo = tipoEmprestimo;
    }
}
