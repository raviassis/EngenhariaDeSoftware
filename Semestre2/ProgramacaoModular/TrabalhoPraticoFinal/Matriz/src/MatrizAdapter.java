
public class MatrizAdapter implements InterfaceMatriz {

	@Override
	public Matriz somar(Matriz l, Matriz r) {
		// TODO Auto-generated method stub
		return Matriz.mais(l, r);
	}

	@Override
	public Matriz subtrair(Matriz l, Matriz r) {
		// TODO Auto-generated method stub
		return Matriz.menos(l, r);
	}

}
