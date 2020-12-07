package courseraita;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
class TestPlacar {

	MockArmazenamento _mock = new MockArmazenamento();
	Placar _placar;
	 
	@Test
	void test001() throws Exception {
    	_placar = new Placar (_mock);
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("francisco", "estrela", 19));
		assertEquals (19,_mock.recuperarPontosDeUmTipoDeUmUsuario("estrela", "francisco"));
	}
	@Test
	void test002() throws Exception {
    	_placar = new Placar (_mock);
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("francisco", "comentario", 5));
		assertEquals (5,_mock.recuperarPontosDeUmTipoDeUmUsuario("comentario", "francisco"));
	}
	@Test
	void test003() throws Exception {
    	_placar = new Placar (_mock);
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("francisco", "vida", 45));
		assertEquals (45,_mock.recuperarPontosDeUmTipoDeUmUsuario("vida", "francisco"));
	}

	@Test
	void test004() throws Exception {
	    _placar = new Placar (_mock);
		HashMap<String,String> _pontosDoUsuario = _placar.retornarPontosDoUsuario ("francisco");
		assertEquals (true,_pontosDoUsuario.containsKey("comentario"));
		assertEquals (true,_pontosDoUsuario.containsValue("5"));
		assertEquals (true,_pontosDoUsuario.containsKey("estrela"));
		assertEquals (true,_pontosDoUsuario.containsValue("19"));
		assertEquals (true,_pontosDoUsuario.containsKey("vida"));
		assertEquals (true,_pontosDoUsuario.containsValue("45"));

	}
	@Test
	void test005() throws Exception {
	    _placar = new Placar (_mock);
	    List<RankingPontos> _ranking = _placar.retornarRankingUsuariosDeUmTipoDePonto ("estrela");
		assertEquals (false,_ranking.isEmpty());
		assertEquals (true,_ranking.listIterator().equals("francisco"));
//		assertEquals (true,_pontosDoUsuario.containsValue("5"));
//		assertEquals (true,_pontosDoUsuario.containsKey("estrela"));
//		assertEquals (false,_ranking.contains("19"));
//		assertEquals (true,_pontosDoUsuario.containsKey("vida"));
//		assertEquals (true,_pontosDoUsuario.containsValue("45"));
	}
		

}
