package com.emprestaai.emprestaai_backend.model.response;

public class ComparacaoResponse {
    private String melhorOpcao;
    private double valorFuturo;
    private double totalParcelado;

    public ComparacaoResponse(String melhorOpcao, double valorFuturo, double totalParcelado) {
        this.melhorOpcao = melhorOpcao;
        this.valorFuturo = valorFuturo;
        this.totalParcelado = totalParcelado;
    }

    // Getters
    public String getMelhorOpcao() { return melhorOpcao; }
    public double getValorFuturo() { return valorFuturo; }
    public double getTotalParcelado() { return totalParcelado; }
}

