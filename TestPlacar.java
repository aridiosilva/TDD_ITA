
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
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("francisco", "star", 19));
		assertEquals (19,_mock.recuperarPontosDeUmTipoDeUmUsuario("star", "francisco"));
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
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("fernanda", "vida ", 48));
		assertEquals (48,_mock.recuperarPontosDeUmTipoDeUmUsuario("vida ", "fernanda"));
	}
	@Test
	void test005() throws Exception {
    	_placar = new Placar (_mock);
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("antonio", "vida", 145));
		assertEquals (145,_mock.recuperarPontosDeUmTipoDeUmUsuario("vida", "antonio"));
	}
	@Test
	void test006() throws Exception {
    	_placar = new Placar (_mock);
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("rafael", "vida", 140));
		assertEquals (140,_mock.recuperarPontosDeUmTipoDeUmUsuario("vida", "rafael"));
	}
	@Test
	void test007() throws Exception {
    	_placar = new Placar (_mock);
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("antonieta", "vida", 300));
		assertEquals (300,_mock.recuperarPontosDeUmTipoDeUmUsuario("vida", "antonieta"));
	}
	@Test
	void test008() throws Exception {
    	_placar = new Placar (_mock);
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("pereira", "vida", 125));
		assertEquals (125,_mock.recuperarPontosDeUmTipoDeUmUsuario("vida", "pereira"));
	}
	@Test
	void test009() throws Exception {
	    _placar = new Placar (_mock);
		HashMap<String,String> _pontosDoUsuario = _placar.retornarPontosDoUsuario ("francisco");
		assertEquals (true,_pontosDoUsuario.containsKey("comentario"));
		assertEquals (true,_pontosDoUsuario.containsValue("5"));
		assertEquals (true,_pontosDoUsuario.containsKey("star"));
		assertEquals (true,_pontosDoUsuario.containsValue("19"));
		assertEquals (true,_pontosDoUsuario.containsKey("vida"));
		assertEquals (true,_pontosDoUsuario.containsValue("45"));

	}
	@Test
	void test010() throws Exception {
		_placar = new Placar (_mock);
		List<RankingPontos> _rankingOrdemDecrescente = _placar.retornarRankingUsuariosDeUmTipoDePonto ("vida");
		assertEquals (false,_rankingOrdemDecrescente.isEmpty());
		assertEquals (true,_rankingOrdemDecrescente.get(0).getUsuario().equals("antonieta"));
		assertEquals (300l,_rankingOrdemDecrescente.get(0).getPontos());
		assertEquals (true,_rankingOrdemDecrescente.get(1).getUsuario().equals("antonio"));
		assertEquals (145l,_rankingOrdemDecrescente.get(1).getPontos());
		assertEquals (true,_rankingOrdemDecrescente.get(2).getUsuario().equals("rafael"));
		assertEquals (140l,_rankingOrdemDecrescente.get(2).getPontos());
		assertEquals (true,_rankingOrdemDecrescente.get(3).getUsuario().equals("pereira"));;
		assertEquals (125l,_rankingOrdemDecrescente.get(3).getPontos());
		assertEquals (true,_rankingOrdemDecrescente.get(4).getUsuario().equals("fernanda"));
		assertEquals (48l,_rankingOrdemDecrescente.get(4).getPontos());
		assertEquals (true,_rankingOrdemDecrescente.get(5).getUsuario().equals("francisco"));
		assertEquals ( 45l,_rankingOrdemDecrescente.get(5).getPontos());
	}
}


