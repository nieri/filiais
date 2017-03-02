package br.com.munieri.entity;

public class Movimentacao {

    private String filial;
    private Double total;

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movimentacao that = (Movimentacao) o;

        if (filial != null ? !filial.equals(that.filial) : that.filial != null) return false;
        return total != null ? total.equals(that.total) : that.total == null;

    }

    @Override
    public int hashCode() {
        int result = filial != null ? filial.hashCode() : 0;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movimentacao{" +
                "filial='" + filial + '\'' +
                ", total=" + total +
                '}';
    }
}
