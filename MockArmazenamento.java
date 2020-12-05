package courseraita;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class MockArmazenamento implements IArmazenamento {

	private TreeSet<Usuarios> _pontuacaoUsuarios;
	private HashSet<String> _tiposDePontos;
	private HashSet<String> _UsuariosCadastrados;

	public MockArmazenamento () {
		this._pontuacaoUsuarios = new TreeSet<Usuarios>();
		this._tiposDePontos = new HashSet<String>();
		_UsuariosCadastrados = new HashSet<String>();
	}

	@Override
	public void armazenarQtePontosDeUmTipoRecebidoPeloUsuario(Usuarios u) {
		_pontuacaoUsuarios.add (u);
		_tiposDePontos.add (u._tipoPonto);
		_UsuariosCadastrados.add(u._usuario);
		
		System.out.println("adicinado pontos no ARQUIVO" +
		                   " User = " + u.getUsuario()  + 
		                   " Ponto = " + u.getTipoPonto() + 
		                   " pontos =" + u.getPontos() + "\n");
	}

	@Override
	public HashSet<String> retornarTiposDePontosRegistrados() {
	    System.out.println("tipo de pontos existentes: \n" + _tiposDePontos + "\n");
		return _tiposDePontos;
	}

	@Override
	public List<Usuarios> retornarUsuariosComPontosDiferenteZero() {
		return null;
	}

	@Override
	public int recuperarQuantoPontosDeUmTipoTemOUsuario(String tipoPonto, String usuario) throws Exception {
		if (_pontuacaoUsuarios.isEmpty())			
			throw new Exception ("Arquivo Vazio - Nenhuma Pontuacao de Usuario");
		
		int _totalPontos = 0;		
		Iterator itr = (Iterator) _pontuacaoUsuarios.iterator();
		while (itr.hasNext()) {
    	    Usuarios _u = (Usuarios) itr.next();
			System.out.println("Registro Lido do Arquivo" + " User = " + _u.getUsuario()  + 
	                   " Ponto = " + _u.getTipoPonto() + " pontos =" + _u.getPontos() + "\n");
    		
			if (_u.getUsuario().contains(usuario) && _u.getTipoPonto().contains(tipoPonto)) {
				_totalPontos += _u.getPontos();
    		}
			if (_totalPontos == 0) 
    			throw new Exception ("Usuario: " + usuario + " e Tipo de Pontuação: " +  
    					             tipoPonto + " não Existe no Arquivo!!! ");
    	}
		return _totalPontos;
	}

}
