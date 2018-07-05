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
		PessoaFisica pf = new PessoaFisica(nome, idade, genero, cpf);
		Funcionario funcionario = new Funcionario(pf, cargo, salario);
		//assertTrue( pf.equals(funcionario.getPessoaFisica()) );
		assertEquals(pf, funcionario.getPessoaFisica());
	}

}
