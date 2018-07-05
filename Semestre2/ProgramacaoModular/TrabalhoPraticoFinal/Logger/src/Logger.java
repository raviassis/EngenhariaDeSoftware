import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

public abstract class Logger {
	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERRO = 3;
	private static final Logger INSTANCE = Logger.getChain();
	private PrintStream logFile = null;
	protected PrintStream destination = System.out;
	
	
	protected int nivel;
	protected Logger prox;
	
	private static Logger getChain() {
		// TODO Auto-generated method stub
		Logger errorLogger = new LoggerErro(Logger.ERRO);
		Logger fileLogger = new LoggerArquivo(Logger.DEBUG);
		Logger consoleLogger = new LoggerConsole(Logger.INFO);
		errorLogger.setProximo(fileLogger);
		fileLogger.setProximo(consoleLogger);
		return errorLogger;
	}

	public static Logger getInstance () {
		return INSTANCE;
	}
	
	public void setProximo(Logger proximoLogger) {
		this.prox = proximoLogger;
	}
	
	public void log(int nivel, String msg) {
		//this.destination.println(LocalDateTime.now().toString() + ": " + msg );
		if (this.nivel <= nivel) {
			escrever(msg);
		}
		else if(this.prox != null) {
			this.prox.log(nivel, msg);
		}
	}
	
	public Logger toConsole() {
		this.destination = System.out;
		return INSTANCE;
	}

	public Logger toFile() throws Exception {
		if (logFile == null) {
			this.destination = System.out;
			throw new Exception("Nenhum arquivo configurado. ");
		} else {
			this.destination = this.logFile;
		}
		return INSTANCE;
	}

	public Logger toFile(String fileName) throws Exception {
		if (this.logFile != null) {
			this.closeLogFile();
		}
		this.logFile = new PrintStream(new FileOutputStream(fileName, true), true, "UTF-8");
		this.destination = this.logFile;
		return INSTANCE;
	}

	public void closeLogFile() {
		this.destination = System.out;
		if (this.logFile != null) {
			this.logFile.close();
			this.logFile = null;
		}
		
	}
	
	abstract protected void escrever(String mensagem);
}
