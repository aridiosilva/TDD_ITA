package courseraita;

public class Usuarios implements Comparable<Object> {

	String _usuario;
	String _tipoPonto;
	String _pontos;

	public  Usuarios (String usuario, String tipoPonto, int totalPontos) {
		this._usuario = usuario.toLowerCase();
		this._tipoPonto = tipoPonto.toLowerCase();
		this._pontos = Integer.toString(totalPontos);
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
	
	@Override
	public boolean equals (Object o) {		
		return false;
	}
	@Override
	public String toString() {
		return null;
	}
	@Override
	public int compareTo(Object o) {
		return 0;
	}

	
}
