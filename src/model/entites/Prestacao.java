package model.entites;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestacao {

    private Date dataVencimento;
    private Double quantia;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Prestacao() {

    }

    public Prestacao(Date dataVencimento, Double quantia) {
        this.dataVencimento = dataVencimento;
        this.quantia = quantia;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setQuantia(Double quantia) {
        this.quantia = quantia;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public Double getQuantia() {
        return quantia;
    }

    @Override
    public String toString() {

        return sdf.format(dataVencimento) + " - " + String.format("%.2f", quantia);
    }
}
