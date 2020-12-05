package courseraita;

import java.util.List;
import java.util.TreeSet;

public class MockArmazenamento implements IArmazenamento {

	private TreeSet<Usuarios> _repositorioUsuarios;

	public MockArmazenamento () {
		_repositorioUsuarios = new TreeSet<Usuarios>();
	}

	@Override
	public void armazenarQtePontosDeUmTipoRecebidoPeloUsuario(Usuarios u) {

		_repositorioUsuarios.add (u);
		System.out.println (" User = " + u.getUsuario() +
				" TipoPonto = " + u.getTipoPonto() +
				" Pontos = " + u.getPontos() );
		return true;
	}

	@Override
	public List<String> retornarTiposDePontosRegistrados() {

		return null;
	}

	@Override
	public List<String> retornarUsuariosComPontosDiferenteZero() {

		return null;
	}

	@Override
	public int recuperarQuantoPontosDeUmTipoTemOUsuario(String tipoPonto, String Usuario) {

		return 0;
	}

}
