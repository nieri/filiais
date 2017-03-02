package br.com.munieri.calculo;

import br.com.munieri.entity.Movimentacao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MesQueEmpresaMaisVendeu {

    public void calcula(Map<String, List<Movimentacao>> mapa) {

        System.out.println("MES QUE A EMPRESA MAIS VENDEU \n");
        Map<String, Double> mes = new LinkedHashMap<>();
        mapa.forEach((k, v) -> {
            mes.put(k, v.stream().mapToDouble(i -> i.getTotal()).sum());

        });

        System.out.println(mes.entrySet().stream().max((entry1, entry2) ->
                entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey());
    }
}
