import java.time.LocalDateTime;

public class LoggerErro extends Logger {
	public LoggerErro(int nivel) {
		this.nivel = nivel;
	}

	@Override
	protected void escrever(String msg) {
		super.destination.println("(ERROR) " + LocalDateTime.now().toString() + ": " + msg );
	}
}
