import static org.junit.Assert.*;

import org.junit.Test;

public class FuncionarioTest {

	@Test
	public void testConstrutor() {
		String nome = "Ravi";
		int idade = 24;
		String genero = "Masculino";
		String cpf = "98765412385";
		String cargo = "Engenheiro de Software";
		double salario = 6500.00;
		Funcionario tal = new Funcionario(nome, idade, genero, cpf, cargo, salario);
		assertEquals(cargo, tal.getCargo());
		assertEquals(salario, tal.getSalario(), 0);
	}

}
