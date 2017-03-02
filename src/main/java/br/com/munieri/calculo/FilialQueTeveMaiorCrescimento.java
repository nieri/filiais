package br.com.munieri.calculo;

import br.com.munieri.entity.Movimentacao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilialQueTeveMaiorCrescimento {

    public void calcula(Map<String, List<Movimentacao>> mapa) {
        System.out.println("FILIAL QUE TEVE O MAIOR CRESCIMENTO \n");

        Map<String, Double> filiais = new LinkedHashMap<>();
        for (Map.Entry<String, List<Movimentacao>> entry : mapa.entrySet()) {

            filiais = entry.getValue().stream().collect(Collectors
                    .groupingBy(Movimentacao::getFilial, Collectors.summingDouble(Movimentacao::getTotal)));

        }

        System.out.println(filiais.entrySet().stream().max((entry1, entry2) ->
                entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey());
    }
}

