package model.service;

public interface ServicoPagamento {

    double cobrancaMes(double quantia);

    double juros(double quantia, int numMes);

}
