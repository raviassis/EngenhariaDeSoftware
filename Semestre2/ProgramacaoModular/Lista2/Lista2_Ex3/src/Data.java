

import java.time.LocalDateTime;

public class Data {
	private int ano;
	private int mes;
	private int dia;
	private static final int mesDias[] = {
			31,28,31,30,31,30, 31, 31, 30, 31, 30, 31
	};
	private static final String diasSemana[] = {
			"Sábado",
			"Domingo",
			"Segunda-Feira",
			"Terça-Feira",
			"Quarta-Feira",
			"Quinta-Feira",
			"Sexta-Feira",
			"Sábado"			
	};
	private static final int numMes[]= {
			0,3,3,6,1,4,6,2,5,0,3,5
	};
	
	private static final String nomeMes [] = {
			"janeiro",
			"fevereiro",
			"março",
			"abril",
			"maio",
			"junho",
			"julho",
			"agosto",
			"setembro",
			"outubro",
			"novembro",
			"dezembro"
	};
	
	public Data(){

		LocalDateTime d = LocalDateTime.now();
		mes = d.getMonth().getValue();
		ano = d.getYear();
		dia = d.getDayOfMonth();
		
	}
	
	public Data(int y, int m, int d){
		ano = y;
		mes = m;
		dia = d;
	}
	
	public int getDia() {
		return dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public int getAno() {
		return ano;
	}

	public void adicionaDias (int dias) {
		dia += dias;
		int diasNoMes[] = new int[12];
		
		for (int i=0; i < diasNoMes.length; i++) {
			diasNoMes[i] = mesDias[i];
		}
		
		diasNoMes[1] = (eBissexto()) ? 29 : 28 ;
		
		if (dia > diasNoMes[mes-1]) {
			dia -= diasNoMes[mes-1];
			mes++;
		}
		
		if (mes > 12) {
			mes = 1;
			ano++;
		}
	}

	public boolean eBissexto() {		
		if ( (ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0)) ) return true ;
		
		return false;
	}

	public int diasNoMes() {
		// TODO Auto-generated method stub
		if (eBissexto() && mes == 2) return mesDias[mes-1] + 1; 
		return mesDias[mes-1];
	}

	public String diaDaSemana() {
		// TODO Auto-generated method stub
		int numsSeculos[][] = {
				{1600, 0},
				{1700, 5},
				{1800, 3},
				{1900, 1},
				{2000, 0}
		};
		int nSec=0;
		int mult7;
		int p1 = dia + numMes[mes-1];
		int p2, p3;
		int ano2dig = ano%100;
		int mult28=0;
		int i;
		//System.out.println("p1=" + p1);
		if (p1 > 6) {
			for (mult7 = 7; mult7<= p1-7 ; mult7 += 7 );
			p1 -= mult7;
			//System.out.println("mult7=" + mult7);
			//System.out.println("p1=" + p1);
		}
		
		if (ano2dig >= 28) {
			for (mult28 = 28; mult28 <= ano2dig; mult28 += 28);
		}
		
		p2 = (ano2dig - mult28) + (int)(ano2dig / 4);
		
		for (i = 0; i < 5; i++) {
			if (ano > numsSeculos[i][0]) {
				nSec = numsSeculos[i][1];
				break;
			}
		}
		
		p2 += nSec;
		//System.out.println("p2=" + p2);
		
		if ( (mes == 1 || mes == 2) && eBissexto() ) p2--;
		
		p3 = p1 + p2;
		//System.out.println(p1 + " + " + p2 + " = " + p3);
		
		if (p3 > 6) {
			for (mult7 = 7; mult7<= p3-7 ; mult7 += 7 );
			p3 -= mult7;
		}
		
		//System.out.println("p3=" + p3);
		
		return diasSemana[p3];
	}

	public void proximoDia() {
		adicionaDias(1);
	}

	public String porExtenso() {		
		String resp = Integer.toString( getDia() );
		resp += " de " + nomeMes[ getMes()-1 ];
		resp += " de " + Integer.toString( getAno() );			
		return resp;
	}	
	
}
