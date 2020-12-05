package courseraita;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class MockArmazenamento implements IArmazenamento {

	private static LinkedList<Usuarios>    _pontuacaoUsuarios      = new LinkedList<Usuarios>();
	private static HashSet<String>        _diferentesTiposDePontos = new HashSet<String>();
	private static HashSet<String>        _usuariosCadastrados     = new HashSet<String>();
	private static HashMap<String,String> _usuariosETiposDePontos  = new HashMap<String,String>();

	private void exibe (String msg) {
		System.out.println(msg);
	}

	@Override
	public void armazenarQtePontosDeUmTipoRecebidoPeloUsuario(Usuarios u) {

		_pontuacaoUsuarios.add (u);
		_diferentesTiposDePontos.add (u._tipoPonto);
		_usuariosCadastrados.add(u._usuario);
		_usuariosETiposDePontos.put(u._usuario, u._tipoPonto);		

		exibe (	"\n Registro Adicionado -> " + u.getUsuario()  + ", " + u.getTipoPonto() +  ", " + u.getPontos());
		exibe ("tipos de pontos = " + _diferentesTiposDePontos);
 		System.out.println("Lista de Usuarios= " +  _usuariosCadastrados );

	}

	@Override
	public HashSet<String> retornarTiposDePontosRegistrados() {

		System.out.println( _diferentesTiposDePontos + "\n");
		return _diferentesTiposDePontos;
	}

	@Override
	public List<Usuarios> retornarUsuariosComPontosDiferenteZero() {

		return null;
	}
	
	@Override
	public int recuperarQuantoPontosDeUmTipoTemOUsuario(String tipoPonto, String usuario) throws Exception {

		if (_pontuacaoUsuarios.size() == 0)
			throw new Exception ("Arquivo Vazio - Nenhuma Pontuacao de Usuario");

		exibe("Procurar por -> " + usuario  + " , " + tipoPonto);

		int _totalPontos = 0;
		for (int i = 0; i < _pontuacaoUsuarios.size(); i++) {
			
		    System.out.println(" REG=" + i + " -->)" + _pontuacaoUsuarios.get(i).getUsuario() + " , " + 
		    		_pontuacaoUsuarios.get(i).getTipoPonto() + " , " +
		    		_pontuacaoUsuarios.get(i).getPontos() );
		    
			if (_pontuacaoUsuarios.get(i).getUsuario() == usuario &&
				_pontuacaoUsuarios.get(i).getTipoPonto() == tipoPonto) {
				
				int p = _pontuacaoUsuarios.get(i).getPontos();
				_totalPontos += p;
			    System.out.println (" contador = " + _totalPontos );
			}
		}
		return _totalPontos;
	}

}
