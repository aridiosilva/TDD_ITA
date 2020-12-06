package courseraita;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
class TestMockArmazenamento {

	MockArmazenamento _mock = new MockArmazenamento();
	
	@Test
	void test001() throws Exception {
		_mock.armazenarPontuacaoDeUmUsuario(new PontuacaoUsuarios("FERNANDES", "ESTRELA", 19));
		assertEquals (19,_mock.recuperarPontosDeUmTipoDeUmUsuario("estrela", "fernandes"));
		HashSet<String> _tiposDePontos = _mock.retornarTiposDePontosJaRegistrados();
		assertEquals (1,_tiposDePontos.size());
		assertEquals (true,_tiposDePontos.contains("estrela"));
	}
	@Test
	void test002() throws Exception {
		_mock.armazenarPontuacaoDeUmUsuario(new PontuacaoUsuarios("TOCO", "ESTRELA", 20));
		assertEquals (20,_mock.recuperarPontosDeUmTipoDeUmUsuario("estrela", "toco"));
		HashSet<String> _tiposDePontos = _mock.retornarTiposDePontosJaRegistrados();
		assertEquals (1,_tiposDePontos.size());
		assertEquals (true,_tiposDePontos.contains("estrela"));
	}
	@Test
	void test003() throws Exception {
		_mock.armazenarPontuacaoDeUmUsuario(new PontuacaoUsuarios("rodrigo", "estrela", 17));
		assertEquals (17,_mock.recuperarPontosDeUmTipoDeUmUsuario("estrela", "rodrigo"));
		HashSet<String> _tiposDePontos = _mock.retornarTiposDePontosJaRegistrados();
		assertEquals (1,_tiposDePontos.size());
		assertEquals (true,_tiposDePontos.contains("estrela"));
	}
	@Test
	void test004() throws Exception {
		_mock.armazenarPontuacaoDeUmUsuario(new PontuacaoUsuarios("rodrigo", "energia", 15));
		assertEquals (15,_mock.recuperarPontosDeUmTipoDeUmUsuario("energia", "rodrigo"));
		HashSet<String> _tiposDePontos = _mock.retornarTiposDePontosJaRegistrados();
		assertEquals (2,_tiposDePontos.size());
		assertEquals (true,_tiposDePontos.contains("energia"));
	}
	@Test
	void test005() throws Exception {
		_mock.armazenarPontuacaoDeUmUsuario(new PontuacaoUsuarios("rodrigo", "energia", 25));
		assertEquals (40,_mock.recuperarPontosDeUmTipoDeUmUsuario("energia", "rodrigo"));
		HashSet<String> _tiposDePontos = _mock.retornarTiposDePontosJaRegistrados();
		assertEquals (2,_tiposDePontos.size());
		assertEquals (true,_tiposDePontos.contains("energia"));
	}
	@Test
	void test006() throws Exception {
		_mock.armazenarPontuacaoDeUmUsuario(new PontuacaoUsuarios("maria", "curtida", 0));
		assertEquals (0,_mock.recuperarPontosDeUmTipoDeUmUsuario("curtida", "maria"));
		HashSet<String> _tiposDePontos = _mock.retornarTiposDePontosJaRegistrados();
		assertEquals (3,_tiposDePontos.size());
		assertEquals (true,_tiposDePontos.contains("energia"));
	}
	@Test
	void test007() throws Exception {
		_mock.armazenarPontuacaoDeUmUsuario(new PontuacaoUsuarios("guerra", "moeda", 5));
		assertEquals (5,_mock.recuperarPontosDeUmTipoDeUmUsuario("moeda", "guerra"));
		HashSet<String> _tiposDePontos = _mock.retornarTiposDePontosJaRegistrados();
		assertEquals (4,_tiposDePontos.size());
		assertEquals (true,_tiposDePontos.contains("moeda"));
	}
	void test008() throws Exception {
		LinkedList<PontuacaoUsuarios> _users = _mock.retornarUsuariosComAlgumTipodePonto();
	    assertEquals (5,_users.size());
	}
	void test009() throws Exception {
		String[] _listaTiposPontos = {"moeda", "estrela", "energia", "curtida"};
		HashSet<String> _diferentesTiposDePontos = _mock.retornarTiposDePontosJaRegistrados();
		assertEquals (_listaTiposPontos.length,_diferentesTiposDePontos.size());
		String stringao1 = null;
		String stringao2 = null;
		for (int i =0; i < _listaTiposPontos.length; i++ ) {
			stringao1 =  stringao1 + _listaTiposPontos[i];
			stringao2 =  stringao2 + _diferentesTiposDePontos.iterator();
		}
		assertEquals (stringao1,stringao2);
	}

	
}
