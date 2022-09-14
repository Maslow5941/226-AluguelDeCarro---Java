package aplicacao;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import model.entidade.AluguelCarro;
import model.entidade.Veiculo;
import model.service.TaxaAluguel;
import model.service.TaxaBrasil;

import java.text.ParseException;
import java.util.Date;



public class Programa {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.println("Qual a data do aluguel?");
		System.out.print("Modelo do carro: ");
		String modeloCarro = sc.nextLine();
		System.out.print("Retirada do carro (dd/MM/yyyy HH:mm): ");
		Date inicio = dateFormat.parse(sc.nextLine());
		System.out.print("Retorno do carro (dd/MM/yyyy HH:mm): ");
		Date fim = dateFormat.parse(sc.nextLine());
		
		AluguelCarro carro =  new AluguelCarro(inicio, fim, new Veiculo(modeloCarro)); 
		
		
		System.out.print("Preço por hora:  ");
		double precoHora = sc.nextDouble();
		System.out.print("Preço por dia: ");
		double precoDia = sc.nextDouble();
		
		TaxaAluguel aluguel = new TaxaAluguel(precoDia, precoHora, new TaxaBrasil());
		
		aluguel.processamentoFatura(carro);
		
		System.out.println("Fatura:");
		System.out.println("Pagamento Basicot: " + String.format("%.2f", carro.getFatura().getPagamentoBasico()));
		System.out.println("Tax: " + String.format("%.2f", carro.getFatura().getTaxa()));
		System.out.println("Total payment: " + String.format("%.2f", carro.getFatura().getPagamentoTotal()));
		
		
		sc.close();

	}

}
