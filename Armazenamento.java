
package courseraita;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Armazenamento implements IArmazenamento {

	DriverArquivoTXT driveTXT = new DriverArquivoTXT(1, this);
	
	private static LinkedList<PontuacaoUsuarios> _pontuacaoUsuarios = new LinkedList<PontuacaoUsuarios>();
	private static HashSet<String>         _diferentesTiposDePontos = new HashSet<String>();

	public Armazenamento () throws Exception, IOException  {

		driveTXT.LerArquivoTextoEInicializarCacheMemoria();
	}
	
	@Override
	public void armazenarPontuacaoDeUmUsuario( PontuacaoUsuarios p) throws IOException, Exception {
		
		_pontuacaoUsuarios.add (p);
		
		if ( p.getPontos() != 0 && !_diferentesTiposDePontos.contains(p._tipoPonto))	
		
			_diferentesTiposDePontos.add (p._tipoPonto);
		
		driveTXT.extendeArquivotextoPontuacao(p);
		
	}

	@Override
	public HashSet<String> retornarTiposDePontosJaRegistrados() {		
//		System.out.println( _diferentesTiposDePontos + "\n");
		return _diferentesTiposDePontos;
	}

	@Override
	public LinkedList<PontuacaoUsuarios> retornarUsuariosComAlgumTipodePonto() throws Exception {
		if (_pontuacaoUsuarios.isEmpty())
			throw new Exception ("Error: Arquivo Vazio - Nenhuma Pontuacao de Usuarios");		
		return _pontuacaoUsuarios;
	}

	@Override
	public int recuperarTotaisDePontosDeUmTipoDeUmUsuario(String tipoPonto, String usuario) throws Exception {
		
		if (_pontuacaoUsuarios.isEmpty())
			throw new Exception ("Error: Arquivo Vazio - Nenhuma Pontuacao de Usuarios");
		
		int _totalPontos = 0;
		boolean usuarioNaoEncontrado = true;			
		for (int i = 0; i < _pontuacaoUsuarios.size(); i++) {			
			if (((String) _pontuacaoUsuarios.get(i).getUsuario()).contains(usuario)) {				
				usuarioNaoEncontrado = false;				
				if (((String) _pontuacaoUsuarios.get(i).getTipoPonto()).contains(tipoPonto)) 					
					_totalPontos += (int)    _pontuacaoUsuarios.get(i).getPontos();
			}
		}
		if (usuarioNaoEncontrado) {			
			throw new Exception ("Error: Usuario Nao Encontrado!!! ");
		}
		return _totalPontos;
	}
	
	private void exibeDadosPontuacao (PontuacaoUsuarios p) {
//		exibe (	"\n Registro Adicionado -> " + p.getUsuario()  + ", " + p.getTipoPonto() +  ", " + p.getPontos());
//		exibe ("tipos de pontos = " + _diferentesTiposDePontos);
//		System.out.println("Lista de Usuarios= " +  _usuariosCadastrados );
	}
	private void exibe (String msg) {
//		System.out.println(msg);
	}

	private void exibeUsuariosETiposDePontosCadastrados (HashMap<String,String> h) {		
//		System.out.println ("\n (ST) LISTA DE USUARIOS E PONTOS CADASTRADOS: ");
//		for (String i : h.keySet()) {
//		  System.out.print("  key: " + i + " value: " + h.get(i));
//		}
	}
	private void exibeUsuariosCadastrados (HashSet<String> u) {		
//		System.out.println ("\n (ST) LISTA DE USUARIOS CADASTRADOS:");
//		for (String s : u) {
//			  System.out.print(" -> " + s);
//		}
	}
	private void exibeTiposPontosCadastrados (HashSet<String>  p) {		
//		System.out.println ("\n (ST) LISTA DE DIFERENTES TIPOS DE PONTOS CADASTRADOS: ");
//		for (String s : p) {
//			  System.out.print(" -> " + s);
//		}
	}
	private void exibePontuacao (LinkedList<PontuacaoUsuarios> p) {		
//		System.out.println ("\n (ST) LISTA TOTAL USUARIOS COM PONTUACAO: ");
//		for (int i=0; i < p.size(); i++) {			
//			  System.out.print("\n(" + i + ") " + p.get(i).getUsuario() + ", " + p.get(i).getTipoPonto() + ", " + p.get(i).getPontos());
//		}
	}
	private void exibeDadosUsuarios (PontuacaoUsuarios p) {		
//	  System.out.print("(ST) DADOS REG USER " + p.getUsuario() + ", " + p.getTipoPonto() + ", " + p.getPontos());
	}

}

