package courseraita;

public class RankingPontos {

	String _usuario;
	long _pontos;

	public  RankingPontos (String usuario, long numeroPontos) {
		System.out.println("Item do Ranking -> " + usuario + " , "  +  numeroPontos);
		this._usuario   = usuario.toLowerCase();
		this._pontos    = numeroPontos;
	}
	public String getUsuario () {		
		return _usuario;
	}
	public long getPontos () {		
		return _pontos; 
	}
}
