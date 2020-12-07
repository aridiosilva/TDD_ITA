
package courseraita;

public class PontuacaoUsuarios {

	String _usuario;
	String _tipoPonto;
	String _pontos;

	public  PontuacaoUsuarios (String usuario, String tipoPonto, int numeroPontos) {
		
		System.out.println("-> " + usuario + " , " + tipoPonto  + " , " +  numeroPontos);
		
		this._usuario   = usuario.toLowerCase();
		this._tipoPonto = tipoPonto.toLowerCase();
		this._pontos    = Integer.toString(numeroPontos);
	}

	public String getUsuario () {		
		return _usuario;
	}
	public String getTipoPonto () {		
		return _tipoPonto;
	}
	public int getPontos () {		
		return Integer.parseInt(_pontos); 
	}
	public String getPontosEmString () {		
		return _pontos; 
	}

}

