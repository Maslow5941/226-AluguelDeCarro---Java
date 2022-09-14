package model.service;

import model.entidade.AluguelCarro;
import model.entidade.Fatura;

public class TaxaAluguel {
	
	private Double precoDia;
	private Double precoHora;
	private TaxaBrasil taxaBrasil;
	
	public TaxaAluguel() {
		
	}

	public TaxaAluguel(Double precoDia, Double precoHora, TaxaBrasil taxaBrasil) {
		
		this.precoDia = precoDia;
		this.precoHora = precoHora;
		this.taxaBrasil = taxaBrasil;
	}
	
	public void processamentoFatura(AluguelCarro aluguelCarro) {
		
		long tempo = aluguelCarro.getInicio().getTime();
		long tempo2 = aluguelCarro.getFim().getTime();
		double horas = (tempo2-tempo)/1000/60/60;
	
		double pagamentoBasico;
		if(horas<=12) {
			 pagamentoBasico = Math.ceil(horas)*precoHora;
		}else {
			 pagamentoBasico = Math.ceil(horas/24)*precoDia;
		}
	
		
		double taxa = taxaBrasil.taxa(pagamentoBasico);
		aluguelCarro.setFatura(new Fatura(pagamentoBasico, taxa));
	}
	

}
