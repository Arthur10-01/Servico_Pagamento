package model.service;

public class ServicoPagamentoPay implements ServicoPagamento {

    private static final double PORCENTAGEM_TAXA = 0.02;
    private static final double JUROS_MENSAL = 0.01;

    @Override
    public double cobrancaMes(double quantia) {
        return quantia * PORCENTAGEM_TAXA;
    }

    @Override
    public double juros(double quantia, int numMes) {
        return quantia * JUROS_MENSAL * numMes;
    }
}
