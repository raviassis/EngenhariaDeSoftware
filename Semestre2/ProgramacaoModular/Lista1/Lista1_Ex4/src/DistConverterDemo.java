
public class DistConverterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double metros = 230;
		double cm = 40;
		double pes = 150;
		double pol = 550;
		
		
		System.out.println("Aplicação DistConverter");
		System.out.println("\nConverter metros");	
		System.out.println( metros + "m = " + DistConverter.convertMetersToFeets(metros) + "ft");
		System.out.println( metros + "m = " + DistConverter.convertMetersToInches(metros) + "in");
		System.out.println( metros + "m = " + DistConverter.convertMetersToCentimeters(metros) + "cm");
		
		System.out.println("\nConverter centimetros");	
		System.out.println( cm + "cm = " + DistConverter.convertCentimetersToFeets(cm) + "ft");
		System.out.println( cm + "cm = " + DistConverter.convertCentimetersToInches(cm) + "in");
		System.out.println( cm + "cm = " + DistConverter.convertCentimetersToMeters(cm) + "m");
		
		System.out.println("\nConverter pes");	
		System.out.println( pes + "ft = " + DistConverter.convertFeetsToCentimeters(pes) + "cm");
		System.out.println( pes + "ft = " + DistConverter.convertFeetsToInches(pes) + "in");
		System.out.println( pes + "ft = " + DistConverter.convertFeetsToMeters(pes) + "m");
		
		System.out.println("\nConverter polegadas");	
		System.out.println( pol + "in = " + DistConverter.convertInchesToFeets(pol) + "ft");
		System.out.println( pol + "in = " + DistConverter.convertInchesToCentimeters(pol) + "cm");
		System.out.println( pol + "in = " + DistConverter.convertInchesToMeters(pol) + "m");
	}

}
