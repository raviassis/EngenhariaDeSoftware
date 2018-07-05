


public class DataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data dt = new Data();
		
		System.out.println("Aplicação Class Data");
		System.out.println("Data de hoje: " + dt.toString());
		
		System.out.println("Quantidade de dias no mes " + dt.getMes() + ": " +
							dt.diasNoMes() + " dias.");
		
		dt.proximoDia();
		
		System.out.println("Data de amanha: " +dt.toString());
		
		System.out.print(dt.getAno() + " é bissexto? ");
		if(dt.eBissexto()) System.out.println("Sim");
		else System.out.println("Não");
		
		dt.adicionaDias(32);
		
		System.out.println("Data daqui 32 dias: " + dt.toString());
		
		dt = new Data(2018,03,01);
		System.out.println("\nCalendário de Março");
		for(int i= 0; i < 31; i++) {
			System.out.println(dt.toString());
			dt.proximoDia();
		}
		
		
	}

}
