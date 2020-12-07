
package courseraita;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
				PontuacaoUsuarios p = new PontuacaoUsuarios(_pu.get(i).getUsuario(),_pu.get(i).getTipoPonto(), _pu.get(i).getPontos());
				_novaLista.put(_pu.get(i).getTipoPonto(), _pu.get(i).getPontosEmString());
			}
		}
		if (_novaLista.isEmpty()) {
			throw new Exception ("Usuario [" + usuario + "] Sem Pontuacao - Nada a Fazer !!!");
		}
		return _novaLista;  	
	}
	public List<RankingPontos> retornarRankingUsuariosDeUmTipoDePonto (String tipoPonto) throws Exception {
		ArrayList<RankingPontos> _ranking = getRankingNaoClassificado (tipoPonto);
		Comparator<RankingPontos> compareByPoints = 
				Comparator.comparing(RankingPontos::getPontos).reversed().
				thenComparing(RankingPontos::getUsuario);
		List<RankingPontos> _sortedRanking = 
				_ranking.stream().sorted(compareByPoints).collect(Collectors.toList());
		return _sortedRanking;
	}
	private ArrayList<RankingPontos> getRankingNaoClassificado(String tipoPonto) throws Exception 
	{
		LinkedList<PontuacaoUsuarios> _pontuacaoUsuarios = _a.retornarUsuariosComAlgumTipodePonto();
		if (_pontuacaoUsuarios.isEmpty())
			throw new Exception (" (PLACAR) Error: Nenhum Ponto Registrado ainda - Nenhum Ranking!!!");
		ArrayList<RankingPontos> _list = new ArrayList<>();
		for (int i=0; i < _pontuacaoUsuarios.size(); i++ ) {
			String name       = (String) _pontuacaoUsuarios.get(i).getUsuario();
			String typePoints = (String) _pontuacaoUsuarios.get(i).getTipoPonto();
			long points        = (long)  _pontuacaoUsuarios.get(i).getPontos();
			System.out.println ("\nLIDO = tipo de ponto = " + typePoints + " " + name + " " + points );
			if (typePoints.contains(tipoPonto)) 	
				_list.add( new RankingPontos(name, points));
		}		
 		return _list;
	}
	private void exibeListaDePontuacao (PontuacaoUsuarios p) {		
		System.out.print("(1)(PLACAR) Pontuacao: " + p.getUsuario() + ", " + p.getTipoPonto() + ", " + p.getPontos());
	}
	private void exibePontuacoesDeUmUsuario (HashMap<String,String> h) {		
		System.out.println ("\n(2)(PLACAR) LISTA de PONTOS de Um Usuário ");
		for (String i : h.keySet()) {
			System.out.print("  key: " + i + " value: " + h.get(i));
		}
	}
	private void exibePontuacao (LinkedList<PontuacaoUsuarios> pu) {		
		System.out.println ("\n(3) (PLACAR) Lista de Usuarios Com Pontuação: ");
		for (int i=0; i < pu.size(); i++) {			
			exibeListaDePontuacao (new PontuacaoUsuarios(pu.get(i).getUsuario(),pu.get(i).getTipoPonto(),pu.get(i).getPontos()));
		}
	}

}


