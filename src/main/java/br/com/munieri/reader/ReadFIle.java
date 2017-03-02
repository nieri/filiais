package br.com.munieri.reader;

import br.com.munieri.entity.Movimentacao;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public class ReadFIle {

    public Map<String, List<Movimentacao>> getFile(String fileName) {

        Map<String, List<Movimentacao>> mapa = new LinkedHashMap<>();
        List<Movimentacao> movimentacoes = new ArrayList();
        Movimentacao movimentacao = null;

        try {

            //Get file from resources folder
            ClassLoader classLoader = getClass().getClassLoader();

            FileInputStream stream = new FileInputStream(classLoader.getResource(fileName).getPath());
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader br = new BufferedReader(reader);
            br.readLine();
            String line = br.readLine();
            String periodo;
            while(line != null) {

                periodo = this.getPeriodo(line);
                movimentacoes = inicializaListaDeMovimentaco(mapa, movimentacoes, periodo);

                movimentacao = populaMovimentacao(line);

                movimentacoes.add(movimentacao);
                mapa.put(periodo, movimentacoes);

                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapa;
    }

    private Movimentacao populaMovimentacao(String line) {
        Movimentacao movimentacao;
        movimentacao = new Movimentacao();
        movimentacao.setFilial(getFilial(line));
        movimentacao.setTotal(getTotal(line));
        return movimentacao;
    }

    private List<Movimentacao> inicializaListaDeMovimentaco(Map<String, List<Movimentacao>> mapa, List<Movimentacao> linhas, String periodo) {
        if(!mapa.containsKey(periodo)) {
            linhas = new ArrayList();
        }
        return linhas;
    }

    private Double getTotal(String line) {

        NumberFormat format = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        String total =  line.substring(line.lastIndexOf(" ") + 1, line.length());

        try {
            return format.parse(total.trim()).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getPeriodo(String line) {
        String periodo = line.substring(line.indexOf("  ") + 1, line.lastIndexOf(" "));
        return periodo.trim();
    }

    private String getFilial(String line) {
        String filial = line.substring(0, line.indexOf("  "));
        return filial.trim();
    }
}
