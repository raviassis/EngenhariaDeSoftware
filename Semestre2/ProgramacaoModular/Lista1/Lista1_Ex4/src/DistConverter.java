
public class DistConverter {
	
	public static final double FT_TO_M  = 0.3048;
	public static final double FT_TO_IN = 12.00;
	public static final double FT_TO_CM = 30.48;
	public static final double IN_TO_M  = 0.0254;
	public static final double IN_TO_FT = 0.083334;
	public static final double IN_TO_CM = 2.54;
	public static final double M_TO_FT  = 3.281;
	public static final double M_TO_IN  = 39.37;
	public static final double M_TO_CM  = 100.0;
	public static final double CM_TO_FT = 0.03281;
	public static final double CM_TO_IN = 0.3937;
	public static final double CM_TO_M  = 0.01;
	
	public static double convertFeetsToMeters(double ft) {return FT_TO_M * ft;}

	public static double convertFeetsToInches(double ft) {return FT_TO_IN * ft;	}

	public static double convertFeetsToCentimeters(double ft) {	return FT_TO_CM * ft;}

	public static double convertInchesToMeters(double in) {	return IN_TO_M * in;}

	public static double convertInchesToFeets(double in) {return IN_TO_FT * in;	}

	public static double convertInchesToCentimeters(double in) {return IN_TO_CM * in;	}

	public static double convertMetersToFeets(double m) {return M_TO_FT * m;	}

	public static double convertMetersToInches(double m) {return M_TO_IN * m;}

	public static double convertMetersToCentimeters(double m) {return M_TO_CM * m;	}

	public static double convertCentimetersToFeets(double cm) {return CM_TO_FT * cm;	}

	public static double convertCentimetersToInches(double cm) {return CM_TO_IN * cm;	}

	public static double convertCentimetersToMeters(double cm) {return CM_TO_M * cm;	}
	
	

}
