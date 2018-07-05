import java.time.LocalDateTime;

public class LoggerArquivo extends Logger {
	public LoggerArquivo(int nivel) {
		this.nivel = nivel;
	}

	@Override
	protected void escrever(String msg) {
		super.destination.println(LocalDateTime.now().toString() + ": " + msg );
	}
}
