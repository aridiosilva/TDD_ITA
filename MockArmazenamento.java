package courseraita;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class MockArmazenamento implements IArmazenamento {

	private static LinkedList<Usuarios>    _pontuacaoUsuarios      = new LinkedList<Usuarios>();
	private static HashSet<String>        _diferentesTiposDePontos = new HashSet<String>();
	private static HashSet<String>        _usuariosCadastrados     = new HashSet<String>();
	private static HashMap<String,String> _usuariosETiposDePontos  = new HashMap<String,String>();
	final int SEM_PONTUACAO = 0;

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
	public HashSet<String> retornarTodosOsTiposDePontosJaRegistradosparaAlgumUsuario() {
		System.out.println( _diferentesTiposDePontos + "\n");
		return _diferentesTiposDePontos;
	}

	@Override
	public LinkedList<Usuarios> retornarTodosUsuariosComAlgumTipodePonto() throws Exception {
		if (_pontuacaoUsuarios.isEmpty())
			throw new Exception ("Arquivo Vazio - Nenhuma Pontuacao de Usuario");
		LinkedList<Usuarios> _usuariosEncontrados = _pontuacaoUsuarios;
		boolean acheiUser = false;
		for (int i = 0; i < _usuariosEncontrados.size(); i++) {
		    String name       = (String) _usuariosEncontrados.get(i).getUsuario();
		    String typePoints = (String) _usuariosEncontrados.get(i).getTipoPonto();
		    int points        = (int)    _usuariosEncontrados.get(i).getPontos();
		    System.out.println(" REG=" + i + " -->)" + name + " , " + typePoints + " , " + points );
			if (points == SEM_PONTUACAO || points < SEM_PONTUACAO) {
				_usuariosEncontrados.remove(i);	
		        System.out.println (" Reg.Pontuaçao Zero ou Negativo Removidos da Lista-Usuarios = " + name + " , " + typePoints );
			}
			else acheiUser = true;
		}
		if (!acheiUser) {
			throw new Exception ("Arquivo Não Vazio - Porém Nenhum Usuario com Pontuacao maior do que Zero");
		}
		System.out.println(_usuariosEncontrados);
		return _usuariosEncontrados;
	}
	
	@Override
	public int recuperarQuantoPontosDeUmTipoTemOUsuario(String tipoPonto, String usuario) throws Exception {
		if (_pontuacaoUsuarios.isEmpty())
			throw new Exception ("Arquivo Vazio - Nenhuma Pontuacao de Usuario");
		exibe("Procurar por -> " + usuario  + " , " + tipoPonto);
		int _totalPontos = 0;
		boolean acheiUser = false;	
		for (int i = 0; i < _pontuacaoUsuarios.size(); i++) {
		    String name       = (String) _pontuacaoUsuarios.get(i).getUsuario();
		    String typePoints = (String) _pontuacaoUsuarios.get(i).getTipoPonto();
		    int points        = (int)    _pontuacaoUsuarios.get(i).getPontos();
		    System.out.println(" REG=" + i + " -->)" + name + " , " + typePoints + " , " + points );
			if (name.contains(usuario)) {
				acheiUser = true;
				if (typePoints.contains(tipoPonto)) {
				    _totalPontos += points;
			        System.out.println (" contador = " + _totalPontos );
				}
			}
		}
		if (!acheiUser) {
			System.out.println ("nao achei o usuario " + usuario );
			return 0;
		}
		return _totalPontos;
	}
	
	private void exibe (String msg) {
		System.out.println(msg);
	}


}
