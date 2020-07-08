package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.entites.Contrato;
import model.entites.Prestacao;

import model.service.ServicoPagamentoPay;

import model.service.ServicoPrestacao;

public class Program {

    public static void main(String[] args) {
        try {
            Scanner ler = new Scanner(System.in);
            Locale.setDefault(Locale.US);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Entre com os dados do Contrato");
            System.out.print("Número do contrato: ");
            int numContrato = ler.nextInt();
            ler.nextLine();
            System.out.print("Data(dd/MM/yyyy): ");
            Date data = sdf.parse(ler.nextLine());
            System.out.print("Valor do Contrato: ");
            double valor = Double.parseDouble(ler.nextLine());

            Contrato contrato = new Contrato(numContrato, data, valor);

            System.out.print("Numero de Parcelas: ");
            int numParcelas = ler.nextInt();

            ServicoPrestacao sp = new ServicoPrestacao((new ServicoPagamentoPay()));

            sp.ProcessoContrato(contrato, numParcelas);

            for (Prestacao pres : contrato.getPrestacao()) {
                System.out.println(pres.toString());
            }
        } catch (ParseException pex) {
            System.out.println("Erro" + pex.getMessage());
        }
    }

}
