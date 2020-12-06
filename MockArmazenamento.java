package courseraita;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class MockArmazenamento implements IArmazenamento {

	private static LinkedList<PontuacaoUsuarios> _pontuacaoUsuarios = new LinkedList<PontuacaoUsuarios>();
	private static HashSet<String>         _diferentesTiposDePontos = new HashSet<String>();
	private static HashSet<String>             _usuariosCadastrados = new HashSet<String>();
	private static HashMap<String,String>   _usuariosETiposDePontos = new HashMap<String,String>();
	final int SEM_PONTUACAO = 0;

	@Override
	public void armazenarPontuacaoDeUmUsuario(PontuacaoUsuarios p) {
		_pontuacaoUsuarios.add (p);
		_diferentesTiposDePontos.add (p._tipoPonto);
		_usuariosCadastrados.add(p._usuario);
		_usuariosETiposDePontos.put(p._usuario, p._tipoPonto);		
		 exibeDadosPontuacao (p);
	}

	@Override
	public HashSet<String> retornarTiposDePontosJaRegistrados() {
		System.out.println( _diferentesTiposDePontos + "\n");
		return _diferentesTiposDePontos;
	}

	@Override
	public LinkedList<PontuacaoUsuarios> retornarUsuariosComAlgumTipodePonto() throws Exception {
		if (_pontuacaoUsuarios.isEmpty())
			throw new Exception ("Error: Arquivo Vazio - Nenhuma Pontuacao de Usuarios");
		LinkedList<PontuacaoUsuarios> _usuariosEncontrados = _pontuacaoUsuarios;
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
			throw new Exception ("Error: Arquivo Não Vazio - Porém Nenhum Usuario com Pontuacao maior que Zero");
		}
		System.out.println(_usuariosEncontrados);
		return _usuariosEncontrados;
	}

	@Override
	public int recuperarPontosDeUmTipoDeUmUsuario(String tipoPonto, String usuario) throws Exception {
		if (_pontuacaoUsuarios.isEmpty())
			throw new Exception ("Error: Arquivo Vazio - Nenhuma Pontuacao de Usuarios");
		exibe("Procurar por -> " + usuario  + " , " + tipoPonto);
		int _totalPontos = 0;
		boolean NaocheiUser = true;	
		for (int i = 0; i < _pontuacaoUsuarios.size(); i++) {
			String name       = (String) _pontuacaoUsuarios.get(i).getUsuario();
			String typePoints = (String) _pontuacaoUsuarios.get(i).getTipoPonto();
			int points        = (int)    _pontuacaoUsuarios.get(i).getPontos();
			System.out.println(" REG=" + i + " -->)" + name + " , " + typePoints + " , " + points );
			if (name.contains(usuario)) {
				NaocheiUser = false;
				if (typePoints.contains(tipoPonto)) {
					_totalPontos += points;
					System.out.println (" contador = " + _totalPontos );
				}
			}
		}
		if (NaocheiUser) {
			System.out.println ("nao achei o usuario " + usuario );
			throw new Exception ("Error: Usuario Nao Encontrado!!! ");
		}
		return _totalPontos;
	}

	private void exibeDadosPontuacao (PontuacaoUsuarios p) {
		exibe (	"\n Registro Adicionado -> " + p.getUsuario()  + ", " + p.getTipoPonto() +  ", " + p.getPontos());
		exibe ("tipos de pontos = " + _diferentesTiposDePontos);
		System.out.println("Lista de Usuarios= " +  _usuariosCadastrados );
	}
	private void exibe (String msg) {
		System.out.println(msg);
	}

}
