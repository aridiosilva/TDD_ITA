package courseraita;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Placar {

	private  List<IArmazenamento> _arquivo = new ArrayList(); 
	private  IArmazenamento _a; 
	
	public Placar (IArmazenamento arquivo) {
		_arquivo.clear();
		_arquivo.add(arquivo);
		System.out.println("MOCK do ARMAZENAMENTO ADICIONADO");
	}
	
	private void init () {
		_a = _arquivo.get(0);
		if (_arquivo.isEmpty())
			throw new RuntimeException ("Erro Interno na Aplicacao");	
	}
	
	public void registrarPontosDoUsuario(Usuarios u) {
		init();
		_a.armazenarQtePontosDeUmTipoRecebidoPeloUsuario(u);
    }
	
	

}
