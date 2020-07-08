package model.service;

import java.util.Calendar;
import java.util.Date;
import model.entites.Contrato;
import model.entites.Prestacao;

public class ServicoPrestacao {

    private ServicoPagamento servicoPagamento;

    public ServicoPrestacao(ServicoPagamento servicoPagamento) {
        this.servicoPagamento = servicoPagamento;
    }

    public ServicoPagamento getServicoPagamento() {
        return servicoPagamento;
    }

    public void setServicoPagamento(ServicoPagamento servicoPagamento) {
        this.servicoPagamento = servicoPagamento;
    }

    public void ProcessoContrato(Contrato contrato, int mes) {

        double valor = contrato.getValorTotal() / mes;

        for (int i = 1; i <= mes; i++) {

            Date data = addMes(contrato.getData(), i);

            double atualizarValor = valor + servicoPagamento.juros(valor, i);
            double valorTotal = atualizarValor + servicoPagamento.cobrancaMes(atualizarValor);
            contrato.addPrestacao(new Prestacao(data, valorTotal));

        }

    }

    private Date addMes(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }
}
