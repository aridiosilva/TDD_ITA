package courseraita;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Placar {
 
	private  List<IArmazenamento> _arquivo = new ArrayList<IArmazenamento>(); 
	private  IArmazenamento _a; 

	public Placar (IArmazenamento a) {
			this._arquivo.clear();
			this._arquivo.add(a);
			this._a = _arquivo.get(0);
			System.out.println("\n  (PLACAR) MOCK do ARMAZENAMENTO ADICIONADO");
	}
	public void registrarPontosDoUsuario(PontuacaoUsuarios u) {
		_a.armazenarPontuacaoDeUmUsuario(u);
	}
  	public HashMap<String,String> retornarPontosDoUsuario (String usuario) throws Exception {
	
  		LinkedList<PontuacaoUsuarios> _pu = _a.retornarUsuariosComAlgumTipodePonto();
  		if (_pu.isEmpty())
  			throw new Exception (" (PLACAR) Error: Nenhum Ponto Registrado ainda - Nada a Fazer!!!");
		
		HashMap<String,String>  _novaLista = new HashMap<String,String>();
		
		for (int i = 0; i < _pu.size(); i++) {			
			if ( _pu.get(i).getPontos() > 0  && _pu.get(i).getUsuario().contains(usuario))  { 				
				PontuacaoUsuarios p = new PontuacaoUsuarios(_pu.get(i).getUsuario(), 
						                                    _pu.get(i).getTipoPonto(), 
						                                    _pu.get(i).getPontos());
				exibeListaDePontuacao (p);
				_novaLista.put(_pu.get(i).getTipoPonto(), Integer.toString(_pu.get(i).getPontos()));
			}
		}
		if (_novaLista.isEmpty()) {
			throw new Exception ("Usuario [" + usuario + "] Sem Pontuacao - Nada a Fazer !!!");
		}
		exibePontuacoesDeUmUsuario(_novaLista);
		return _novaLista;  	
	}
	private void exibeListaDePontuacao (PontuacaoUsuarios p) {		
	    System.out.print("(PLACAR) Pontuacao: " + p.getUsuario() + ", " + p.getTipoPonto() + ", " + p.getPontos());
	}
	private void exibePontuacoesDeUmUsuario (HashMap<String,String> h) {		
		System.out.println ("\n (PLACAR) LISTA de PONTOS de Um Usuário ");
		for (String i : h.keySet()) {
		  System.out.print("  key: " + i + " value: " + h.get(i));
		}
	}

}
