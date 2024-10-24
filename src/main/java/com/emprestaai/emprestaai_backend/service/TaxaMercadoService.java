package com.emprestaai.emprestaai_backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TaxaMercadoService {

    private static final String URL_SELIC = "https://api.bcb.gov.br/dados/serie/bcdata.sgs.11/dados/ultimos/1?formato=json";

    private final RestTemplate restTemplate;

    public TaxaMercadoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double obterTaxaSelicAtual() {
        String url = UriComponentsBuilder.fromHttpUrl(URL_SELIC).toUriString();

        try {
            TaxaResponse[] response = restTemplate.getForObject(url, TaxaResponse[].class);
            if (response != null && response.length > 0) {
                return Double.parseDouble(response[0].getValor());
            }
        } catch (HttpClientErrorException e) {
            System.err.println("Erro HTTP ao obter a taxa SELIC: " + e.getStatusCode());
        } catch (Exception e) {
            System.err.println("Erro ao obter a taxa SELIC: " + e.getMessage());
        }
        return 0.0;
    }
}

class TaxaResponse {
    private String data;
    private String valor;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
