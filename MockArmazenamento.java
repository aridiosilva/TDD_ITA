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

 	
	private void veSeFazAdicoesComplementares (PontuacaoUsuarios p) {
		
		if ( p.getPontos() > 0 ) { 
			
			if (!_usuariosCadastrados.contains(p.getUsuario()))				
				_usuariosCadastrados.add(p._usuario);
			
			if (!_diferentesTiposDePontos.contains(p._tipoPonto))				
				_diferentesTiposDePontos.add (p._tipoPonto);
			
			if (!_usuariosETiposDePontos.containsKey(p._usuario) ||
				!_usuariosETiposDePontos.containsValue(p._tipoPonto) )
				_usuariosETiposDePontos.put(p._usuario, p._tipoPonto);
		}
		exibeUsuariosETiposDePontosCadastrados (_usuariosETiposDePontos);
		exibeUsuariosCadastrados (_usuariosCadastrados);
		exibeTiposPontosCadastrados(_diferentesTiposDePontos);
	}
	
	@Override
	public void armazenarPontuacaoDeUmUsuario(PontuacaoUsuarios p) {
		_pontuacaoUsuarios.add (p);
		veSeFazAdicoesComplementares (p);
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
		
		LinkedList<PontuacaoUsuarios> _pu = _pontuacaoUsuarios;
		LinkedList<PontuacaoUsuarios> _novaLista = new LinkedList<PontuacaoUsuarios>();
		
		for (int i = 0; i < _pu.size(); i++) {			
			if ( _pu.get(i).getPontos() > 0)  { 				
				PontuacaoUsuarios p = new PontuacaoUsuarios(_pu.get(i).getUsuario(), 
						                                    _pu.get(i).getTipoPonto(), 
						                                    _pu.get(i).getPontos());
				exibeDadosUsuarios (p);
				_novaLista.add (p);	
			}
		}
		if (_novaLista.isEmpty()) {
			throw new Exception ("Error: Arquivo Não Vazio - Porém Nenhum Usuario com Pontuacao maior que Zero");
		}
		exibePontuacao(_novaLista);
		return _pu;
	}
  
	@Override
	public int recuperarPontosDeUmTipoDeUmUsuario(String tipoPonto, String usuario) throws Exception {
		if (_pontuacaoUsuarios.isEmpty())
			throw new Exception ("Error: Arquivo Vazio - Nenhuma Pontuacao de Usuarios");
		exibe("Procurar por -> " + usuario  + " , " + tipoPonto);
		int _totalPontos = 0;
		boolean usuarioNaoEncontrado = true;	
		for (int i = 0; i < _pontuacaoUsuarios.size(); i++) {
			String name       = (String) _pontuacaoUsuarios.get(i).getUsuario();
			String typePoints = (String) _pontuacaoUsuarios.get(i).getTipoPonto();
			int points        = (int)    _pontuacaoUsuarios.get(i).getPontos();
			System.out.println(" REG=" + i + " -->)" + name + " , " + typePoints + " , " + points );
			if (name.contains(usuario)) {
				usuarioNaoEncontrado = false;
				if (typePoints.contains(tipoPonto)) {
					_totalPontos += points;
					System.out.println (" acumulado pontos do tipo = " + tipoPonto + " = " + _totalPontos );
				}
			}
		}
		if (usuarioNaoEncontrado) {
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

	private void exibeUsuariosETiposDePontosCadastrados (HashMap<String,String> h) {		
		System.out.println ("\n (ST) LISTA DE USUARIOS E PONTOS CADASTRADOS: ");
		for (String i : h.keySet()) {
		  System.out.print("  key: " + i + " value: " + h.get(i));
		}
	}
	private void exibeUsuariosCadastrados (HashSet<String> u) {		
		System.out.println ("\n (ST) LISTA DE USUARIOS CADASTRADOS:");
		for (String s : u) {
			  System.out.print(" -> " + s);
		}
	}
	private void exibeTiposPontosCadastrados (HashSet<String>  p) {		
		System.out.println ("\n (ST) LISTA DE DIFERENTES TIPOS DE PONTOS CADASTRADOS: ");
		for (String s : p) {
			  System.out.print(" -> " + s);
		}
	}
	private void exibePontuacao (LinkedList<PontuacaoUsuarios> p) {		
		System.out.println ("\n (ST) LISTA TOTAL USUARIOS COM PONTUACAO: ");
		for (int i=0; i < p.size(); i++) {			
			  System.out.print("(" + i + ") " + p.get(i).getUsuario() +
					           ", " + p.get(i).getTipoPonto() + 
					           ", " + p.get(i).getPontos());
		}
	}
	private void exibeDadosUsuarios (PontuacaoUsuarios p) {		
	  System.out.print("(ST) DADOS REG USER " + p.getUsuario() + ", " + p.getTipoPonto() + ", " + p.getPontos());
	}

}
