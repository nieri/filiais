package br.com.munieri.entity;

import java.util.Collections;
import java.util.Comparator;

public enum Ordenar implements Comparator<Movimentacao> {

    porFilial() {
        public int compare(Movimentacao one, Movimentacao other) {
            return one.getFilial().compareTo(other.getFilial());
        }
    },

    porTotal {
        public int compare(Movimentacao one, Movimentacao other) {
            return one.getTotal().compareTo(other.getTotal());
        }
    };

    public abstract int compare(Movimentacao one, Movimentacao other);

    public Comparator asc() {
        return this;
    }

    public Comparator desc() {
        return Collections.reverseOrder(this);
    }
}
