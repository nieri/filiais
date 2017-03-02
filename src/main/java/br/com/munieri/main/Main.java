package br.com.munieri.main;

import br.com.munieri.calculo.FilialQueMaisVendeuNoPeriodo;
import br.com.munieri.calculo.FilialQueTeveMaiorCrescimento;
import br.com.munieri.calculo.FilialQueTeveMenorCrescimento;
import br.com.munieri.calculo.MesQueEmpresaMaisVendeu;
import br.com.munieri.entity.Movimentacao;
import br.com.munieri.reader.ReadFIle;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ReadFIle readFIle = new ReadFIle();
        Map<String, List<Movimentacao>> mapa = readFIle.getFile("files/movimentacoes.txt");

        new FilialQueMaisVendeuNoPeriodo().calcula(mapa);
        System.out.println("\n");

        new FilialQueTeveMaiorCrescimento().calcula(mapa);
        System.out.println("\n");

        new FilialQueTeveMenorCrescimento().calcula(mapa);
        System.out.println("\n");

        new MesQueEmpresaMaisVendeu().calcula(mapa);

    }
}
