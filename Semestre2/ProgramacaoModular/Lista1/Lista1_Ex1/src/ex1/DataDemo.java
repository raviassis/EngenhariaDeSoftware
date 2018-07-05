package ex1;


public class DataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data dt = new Data();
		
		System.out.println("Aplica��o Class Data");
		System.out.println("Data de hoje: " + dt.diaDaSemana() + " - " +
							dt.getDia()+"/"+dt.getMes()+"/"+dt.getAno());
		
		System.out.println("Quantidade de dias no mes " + dt.getMes() + ": " +
							dt.diasNoMes() + " dias.");
		
		dt.proximoDia();
		
		System.out.println("Data de amanha: " + dt.diaDaSemana() + " - " +
							dt.getDia()+"/"+dt.getMes()+"/"+dt.getAno());
		
		System.out.print(dt.getAno() + " � bissexto? ");
		if(dt.eBissexto()) System.out.println("Sim");
		else System.out.println("N�o");
		
		dt.adicionaDias(32);
		
		System.out.println("Data daqui 32 dias: " + dt.diaDaSemana() + " - " +
							dt.getDia()+"/"+dt.getMes()+"/"+dt.getAno());
		
		dt = new Data(2018,03,01);
		System.out.println("\nCalend�rio de Mar�o");
		for(int i= 0; i < 30; i++) {
			System.out.print(dt.getDia()+"/"+dt.getMes()+"/"+dt.getAno()+" - ");
			System.out.println(dt.diaDaSemana());
			dt.proximoDia();
		}
		
		
	}

}
