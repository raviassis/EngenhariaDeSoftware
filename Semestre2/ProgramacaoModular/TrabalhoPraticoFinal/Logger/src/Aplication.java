
public class Aplication {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Logger log = Logger.getInstance();
		
		log.log(Logger.INFO,"testeInfo");
		log.log(Logger.DEBUG,"testeDebug");
		log.log(Logger.ERRO,"testeError");
		
		log.toFile("teste.txt");
		
		log.log(Logger.INFO,"testeInfo");
		log.log(Logger.DEBUG,"testeDebug");
		log.log(Logger.ERRO,"testeError");
		
		
		log.closeLogFile();
		
	}

}
