package br.com.munieri.calculo;

import br.com.munieri.entity.Movimentacao;

import java.util.List;
import java.util.Map;

import static br.com.munieri.entity.Ordenar.porTotal;

public class FilialQueMaisVendeuNoPeriodo {

    public void calcula(Map<String, List<Movimentacao>> mapa) {

        System.out.println("FILIAL QUE MAIS VENDEU NO PERIODO \n");
        for(Map.Entry<String, List<Movimentacao>> entry : mapa.entrySet()) {

            entry.getValue().sort(porTotal.desc());
            System.out.println(entry.getKey() + " " +
                    entry.getValue().get(0).getFilial() + " " +
                    entry.getValue().get(0).getTotal());

        }
    }
}
