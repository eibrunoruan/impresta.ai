package com.emprestaai.emprestaai_backend.controller;

import com.emprestaai.emprestaai_backend.model.request.ComparacaoRequest;
import com.emprestaai.emprestaai_backend.model.request.PagamentoAntecipadoRequest;
import com.emprestaai.emprestaai_backend.model.request.SimulacaoRequest;
import com.emprestaai.emprestaai_backend.model.response.ComparacaoInvestimentoResponse;
import com.emprestaai.emprestaai_backend.model.response.PagamentoAntecipadoResponse;
import com.emprestaai.emprestaai_backend.model.response.SimulacaoResponse;
import com.emprestaai.emprestaai_backend.service.EmprestimoService;
import com.emprestaai.emprestaai_backend.service.TaxaMercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private TaxaMercadoService taxaMercadoService;

    @PostMapping("/simular")
    public SimulacaoResponse simular(@RequestBody SimulacaoRequest request) {
        validarEntrada(request);
        return emprestimoService.simularEmprestimo(
                request.getValor(),
                request.getTaxaJuros(),
                request.getParcelas(),
                request.getTipoEmprestimo()
        );
    }

    @PostMapping("/pagamento-antecipado")
    public PagamentoAntecipadoResponse pagamentoAntecipado(@RequestBody PagamentoAntecipadoRequest request) {
        validarEntrada(request);
        return emprestimoService.calcularPagamentoAntecipado(
                request.getValor(),
                request.getTaxaJuros(),
                request.getParcelas(),
                request.getParcelasPagas()
        );
    }

    @GetMapping("/taxa-selic")
    public double obterTaxaSelic() {
        return taxaMercadoService.obterTaxaSelicAtual();
    }

    @PostMapping("/comparar-investimento")
    public ComparacaoInvestimentoResponse compararComInvestimento(@RequestBody ComparacaoRequest request) {
        validarComparacao(request);
        return emprestimoService.compararComInvestimento(
                request.getValorAVista(),
                request.getTaxaJuros(),
                request.getParcelas(),
                request.getTipoEmprestimo()
        );
    }

    private void validarEntrada(SimulacaoRequest request) {
        if (request.getValor() <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
        if (request.getParcelas() <= 0) {
            throw new IllegalArgumentException("O número de parcelas deve ser maior que zero.");
        }
        if (request.getTaxaJuros() < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
    }

    private void validarEntrada(PagamentoAntecipadoRequest request) {
        if (request.getParcelasPagas() < 0 || request.getParcelasPagas() >= request.getParcelas()) {
            throw new IllegalArgumentException("O número de parcelas pagas é inválido.");
        }
    }

    private void validarComparacao(ComparacaoRequest request) {
        if (request.getValorAVista() <= 0) {
            throw new IllegalArgumentException("O valor à vista deve ser maior que zero.");
        }
        if (request.getParcelas() <= 0) {
            throw new IllegalArgumentException("O número de parcelas deve ser maior que zero.");
        }
        if (request.getTaxaJuros() < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
    }
}
