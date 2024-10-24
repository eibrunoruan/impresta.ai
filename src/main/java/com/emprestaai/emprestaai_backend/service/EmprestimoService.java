package com.emprestaai.emprestaai_backend.service;

import com.emprestaai.emprestaai_backend.taxa.TipoEmprestimo;
import com.emprestaai.emprestaai_backend.model.response.PagamentoAntecipadoResponse;
import com.emprestaai.emprestaai_backend.model.response.SimulacaoResponse;
import com.emprestaai.emprestaai_backend.model.response.ComparacaoInvestimentoResponse;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {
    public SimulacaoResponse simularEmprestimo(double valor, double taxaJuros, int parcelas, TipoEmprestimo tipoEmprestimo) {
        double taxaMensal = taxaJuros / 100;
        double valorParcela = valor * (taxaMensal / (1 - Math.pow(1 + taxaMensal, -parcelas)));
        double totalPago = valorParcela * parcelas;

        return new SimulacaoResponse(totalPago, valorParcela);
    }

    public PagamentoAntecipadoResponse calcularPagamentoAntecipado(
            double valor, double taxaJuros, int parcelas, int parcelasPagas) {

        if (parcelasPagas >= parcelas) {
            throw new IllegalArgumentException("O número de parcelas pagas não pode ser igual ou maior que o total.");
        }

        double taxaMensal = taxaJuros / 100;
        double valorParcela = valor * (taxaMensal / (1 - Math.pow(1 + taxaMensal, -parcelas)));

        double saldoDevedor = valor * Math.pow(1 + taxaMensal, parcelas - parcelasPagas) -
                (valorParcela * ((Math.pow(1 + taxaMensal, parcelasPagas) - 1) / taxaMensal));

        double valorTotalOriginal = valorParcela * parcelas;
        double totalPagoAteAgora = valorParcela * parcelasPagas;
        double valorEconomizado = valorTotalOriginal - (totalPagoAteAgora + saldoDevedor);

        return new PagamentoAntecipadoResponse(valorEconomizado, saldoDevedor);
    }

    public ComparacaoInvestimentoResponse compararComInvestimento(
            double valorAVista, double taxaJuros, int parcelas, TipoEmprestimo tipoEmprestimo) {

        double taxaMensal = taxaJuros / 100;
        double valorParcela = valorAVista * (taxaMensal / (1 - Math.pow(1 + taxaMensal, -parcelas)));
        double totalPago = valorParcela * parcelas;

        double rendimentoPoupanca = valorAVista * Math.pow(1 + 0.005, parcelas);  // 0.5% ao mês (Aqui é o cálculo Julio, n muda!!!)
        double rendimentoCDB = valorAVista * Math.pow(1 + 0.01, parcelas);  // 1% ao mês

        return new ComparacaoInvestimentoResponse(totalPago, rendimentoPoupanca, rendimentoCDB);
    }
}
