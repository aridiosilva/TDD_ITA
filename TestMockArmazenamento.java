package courseraita;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
class TestMockArmazenamento {

	MockArmazenamento _mock = new MockArmazenamento();
	
	@Test
	void testArmazenarQtePontosDeUmTipoRecebidoPeloUsuario001() throws Exception {
		_mock.armazenarQtePontosDeUmTipoRecebidoPeloUsuario(new Usuarios("FERNANDES", "ESTRELA", 19));
		assertEquals (19,_mock.recuperarQuantoPontosDeUmTipoTemOUsuario("estrela", "fernandes"));
		HashSet<String> _tiposDePontos = _mock.retornarTiposDePontosRegistrados();
		assertEquals (1,_tiposDePontos.size());
		assertEquals (true,_tiposDePontos.contains("estrela"));
	}
	@Test
	void testArmazenarQtePontosDeUmTipoRecebidoPeloUsuario002() throws Exception {
		_mock.armazenarQtePontosDeUmTipoRecebidoPeloUsuario(new Usuarios("TOCO", "ESTRELA", 20));
		assertEquals (209,_mock.recuperarQuantoPontosDeUmTipoTemOUsuario("estrela", "toco"));
		HashSet<String> _tiposDePontos = _mock.retornarTiposDePontosRegistrados();
		assertEquals (1,_tiposDePontos.size());
		assertEquals (true,_tiposDePontos.contains("estrela"));
	}
	@Test
	void testArmazenarQtePontosDeUmTipoRecebidoPeloUsuario003() throws Exception {
		_mock.armazenarQtePontosDeUmTipoRecebidoPeloUsuario(new Usuarios("rodrigo", "estrela", 17));
		assertEquals (17,_mock.recuperarQuantoPontosDeUmTipoTemOUsuario("estrela", "rodrigo"));
		HashSet<String> _tiposDePontos = _mock.retornarTiposDePontosRegistrados();
		assertEquals (1,_tiposDePontos.size());
		assertEquals (true,_tiposDePontos.contains("estrela"));
	}
	@Test
	void testArmazenarQtePontosDeUmTipoRecebidoPeloUsuario004() throws Exception {
		_mock.armazenarQtePontosDeUmTipoRecebidoPeloUsuario(new Usuarios("rodrigo", "energia", 15));
		assertEquals (15,_mock.recuperarQuantoPontosDeUmTipoTemOUsuario("energia", "rodrigo"));
		HashSet<String> _tiposDePontos = _mock.retornarTiposDePontosRegistrados();
		assertEquals (1,_tiposDePontos.size());
		assertEquals (true,_tiposDePontos.contains("energia"));
	}

	
}
