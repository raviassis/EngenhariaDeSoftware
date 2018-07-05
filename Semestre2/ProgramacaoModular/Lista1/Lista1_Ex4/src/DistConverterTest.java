import static org.junit.Assert.*;

import org.junit.Test;

public class DistConverterTest {
	private static double DELTA = 0.00000;
	
	@Test
	public void testConverterPesParaMetros() {
		double ft = 10;
		double m = 0.3048;
		assertEquals((ft * m), DistConverter.convertFeetsToMeters(ft),DELTA);		
	}
	
	@Test
	public void testConverterPesParaPolegadas() {
		double ft = 10;
		double in = 12.00;
		assertEquals((ft * in), DistConverter.convertFeetsToInches(ft),DELTA);
	}
	
	@Test
	public void testConverterPesParaCentimetros() {
		double ft = 10;
		double cm = 30.48;
		assertEquals((ft * cm), DistConverter.convertFeetsToCentimeters(ft),DELTA);
	}
	
	@Test
	public void testConverterPolegadasParaMetros() {
		double in = 1;
		double m = 0.0254;
		assertEquals((in * m), DistConverter.convertInchesToMeters(in),DELTA);
	}
	
	@Test
	public void testConverterPolegadasParaPes() {
		double in = 5;
		double ft = 0.083334;
		assertEquals((in * ft), DistConverter.convertInchesToFeets(in),DELTA);
	}
	
	@Test
	public void testConverterPolegadasParaCentimetros() {
		double in = 3;
		double cm = 2.54;
		assertEquals((in * cm), DistConverter.convertInchesToCentimeters(in),DELTA);
	}
	
	@Test
	public void testConverterMetrosParaPes() {
		double m = 4;
		double ft = 3.281;
		assertEquals((m * ft), DistConverter.convertMetersToFeets(m),DELTA);
	}
	
	@Test
	public void testConverterMetrosParaPolegadas() {
		double m = 1;
		double in = 39.37;
		assertEquals((in * m), DistConverter.convertMetersToInches(m),DELTA);
	}
	
	@Test
	public void testConverterMetrosParaCentimetros() {
		double m = 1;
		double cm = 100;
		assertEquals((m * cm), DistConverter.convertMetersToCentimeters(m),DELTA);
	}
	
	@Test
	public void testConverterCentimetrosParaPes() {
		double cm = 1;
		double ft = 0.03281;
		assertEquals((cm * ft), DistConverter.convertCentimetersToFeets(cm),DELTA);
	}
	
	@Test
	public void testConverterCentimetrosParaPolegadas() {
		double cm = 5.5;
		double in = 0.3937;
		assertEquals((in * cm), DistConverter.convertCentimetersToInches(cm),DELTA);
	}
	
	@Test
	public void testConverterCentimetrosParaMetros() {
		double cm = 1000;
		double m = 0.01;
		assertEquals((cm * m), DistConverter.convertCentimetersToMeters(cm),DELTA);
	}
	
	/*Helpers*/
	
	
	
}
