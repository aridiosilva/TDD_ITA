
package courseraita;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;
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
	void testSet001PrimeiroUsuarioComPontosPositivosENegativos() throws Exception {
		
    	_placar = new Placar (_mock);
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("francisco", "estrela", 50));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("francisco", "comentarios", 80));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("francisco", "vida", 19));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("francisco", "energia", 30));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("francisco", "curtida", 28));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("francisco", "moeda", 44));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("francisco", "estrela", 100));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("francisco", "estrela", -50));
		
		HashMap<String,String> _pontosUsuario = _placar.retornarPontosDoUsuario("francisco");
		assertEquals (true,_pontosUsuario.containsKey("moeda"));  
		assertEquals (true,_pontosUsuario.containsValue("44"));
		
		assertEquals (true,_pontosUsuario.containsKey("estrela"));
		assertEquals (true,_pontosUsuario.containsValue("100"));    // Como teve 50 + 100 - 50 o saldo de pontos = 100
		
		assertEquals (true,_pontosUsuario.containsKey("vida"));
		assertEquals (true,_pontosUsuario.containsValue("19"));
		
		assertEquals (true,_pontosUsuario.containsKey("energia"));
		assertEquals (true,_pontosUsuario.containsValue("30"));

		assertEquals (true,_pontosUsuario.containsKey("comentarios"));
		assertEquals (true,_pontosUsuario.containsValue("80"));

		assertEquals (true,_pontosUsuario.containsKey("curtida"));
		assertEquals (true,_pontosUsuario.containsValue("28"));
		
//		assertEquals (44,_mock.recuperarTotaisDePontosDeUmTipoDeUmUsuario("moeda", "francisco"));  
//		assertEquals (100,_mock.recuperarTotaisDePontosDeUmTipoDeUmUsuario("estrela", "francisco"));  // 50 + 100 - 140 = 10 (saldo de pontos p/estrela)
//		assertEquals (19,_mock.recuperarTotaisDePontosDeUmTipoDeUmUsuario("vida", "francisco"));  
//		assertEquals (30,_mock.recuperarTotaisDePontosDeUmTipoDeUmUsuario("energia", "francisco")); 
//		assertEquals (80,_mock.recuperarTotaisDePontosDeUmTipoDeUmUsuario("comentarios", "francisco")); 
//		assertEquals (28,_mock.recuperarTotaisDePontosDeUmTipoDeUmUsuario("curtida", "francisco"));  
	

	}
 
	@Test
	void testSet002SOutrosUsuariosComMultiplosPontos() throws Exception {
   	
		_placar = new Placar (_mock);
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("fernanda", "estrela", 50));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("fernanda", "estrela", 100));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("fernanda", "estrela", -140));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("antonio", "vida", 20));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("antonio", "curtida", 45));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("antonio", "moeda", 30));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("pedro", "vida", 19));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("pedro", "vida", 20));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("toco", "energia", 30));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("rodrigo", "curtida", 28));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("maria", "moeda", 44));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("maria", "estrela", 100));
		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("rafael", "vida", -50));
		
//		assertEquals (10,_mock.recuperarTotaisDePontosDeUmTipoDeUmUsuario("estrela", "fernanda"));  // 50 + 100 - 140 = 10 (saldo de pontos p/estrela) 
//		assertEquals (45,_mock.recuperarTotaisDePontosDeUmTipoDeUmUsuario("curtida", "antonio"));  
//		assertEquals (30,_mock.recuperarTotaisDePontosDeUmTipoDeUmUsuario("moeda", "antonio"));  
//		assertEquals (39,_mock.recuperarTotaisDePontosDeUmTipoDeUmUsuario("vida", "pedro"));      // 19 + 20 = 39 (saldo de pontos p/vida)
//		assertEquals (30,_mock.recuperarTotaisDePontosDeUmTipoDeUmUsuario("energia", "toco"));  
//		assertEquals (28,_mock.recuperarTotaisDePontosDeUmTipoDeUmUsuario("curtida", "rodrigo"));  
//		assertEquals (44,_mock.recuperarTotaisDePontosDeUmTipoDeUmUsuario("moeda", "maria")); 
//		assertEquals (100,_mock.recuperarTotaisDePontosDeUmTipoDeUmUsuario("estrela", "maria")); 

		// Conferindo dos Pontos da Fernanda

		HashMap<String,String> _pontosUsuario = _placar.retornarPontosDoUsuario("fernanda");
		assertEquals (true,_pontosUsuario.containsKey("estrela"));  
		assertEquals (true,_pontosUsuario.containsValue("10"));          // 50 + 100 - 140 = 10 (saldo de pontos p/estrela) 

		// Conferindo dos Pontos do Antonio 

		_pontosUsuario = _placar.retornarPontosDoUsuario("antonio");
		assertEquals (true,_pontosUsuario.containsKey("vida"));
		assertEquals (true,_pontosUsuario.containsValue("20"));    
		assertEquals (true,_pontosUsuario.containsKey("curtida"));
		assertEquals (true,_pontosUsuario.containsValue("45"));
		assertEquals (true,_pontosUsuario.containsKey("moeda"));
		assertEquals (true,_pontosUsuario.containsValue("30"));

		// Conferindo dos Pontos do Pedro 

		_pontosUsuario = _placar.retornarPontosDoUsuario("pedro");
		assertEquals (true,_pontosUsuario.containsKey("vida"));
		assertEquals (true,_pontosUsuario.containsValue("39"));

		// Conferindo dos Pontos do Toco 

		_pontosUsuario = _placar.retornarPontosDoUsuario("toco");
		assertEquals (true,_pontosUsuario.containsKey("energia"));
		assertEquals (true,_pontosUsuario.containsValue("30"));

		// Conferindo dos Pontos do Rodrigo

		_pontosUsuario = _placar.retornarPontosDoUsuario("rodrigo");
		assertEquals (true,_pontosUsuario.containsKey("curtida"));
		assertEquals (true,_pontosUsuario.containsValue("28"));

		// Conferindo dos Pontos da Maria

		_pontosUsuario = _placar.retornarPontosDoUsuario("maria");
		assertEquals (true,_pontosUsuario.containsKey("moeda"));
		assertEquals (true,_pontosUsuario.containsValue("44"));
		assertEquals (true,_pontosUsuario.containsKey("estrela"));
		assertEquals (true,_pontosUsuario.containsValue("100"));
	
		// Conferindo dos Pontos do Francisco inseridos no TesteSet001
		
		_pontosUsuario = _placar.retornarPontosDoUsuario("francisco");
		
		assertEquals (true,_pontosUsuario.containsKey("moeda"));
		assertEquals (true,_pontosUsuario.containsValue("44"));
		
		assertEquals (true,_pontosUsuario.containsKey("estrela"));
		assertEquals (true,_pontosUsuario.containsValue("100"));       // 50 + 100 - 140 = 10 (saldo de pontos p/estrela)
		
		assertEquals (true,_pontosUsuario.containsKey("vida"));
		assertEquals (true,_pontosUsuario.containsValue("19"));
		
		assertEquals (true,_pontosUsuario.containsKey("energia"));
		assertEquals (true,_pontosUsuario.containsValue("30"));
		
		assertEquals (true,_pontosUsuario.containsKey("comentarios"));
		assertEquals (true,_pontosUsuario.containsValue("80"));
		
		assertEquals (true,_pontosUsuario.containsKey("curtida"));
		assertEquals (true,_pontosUsuario.containsValue("28"));
			 
		
		System.out.print("\n\n +++++++++ Pontos do francisco +++++++++++++++");
		for (String i : _pontosUsuario.keySet()) {
			System.out.print("\n  key: " + i + " value: " + _pontosUsuario.get(i));
		}
		System.out.print("\n\n");

		
		// Conferindo o Ranking de Pontos do Tipo  "vida"
		
		List<RankingPontos> _rankingOrdemDecrescente = _placar.retornarRankingUsuariosDeUmTipoDePonto ("vida");
		assertEquals (false,_rankingOrdemDecrescente.isEmpty());
		assertEquals (true,_rankingOrdemDecrescente.get(0).getUsuario().equals("francisco "));
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

	//	@Test
//	void test003() throws Exception {
//   	_placar = new Placar (_mock);
//		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("francisco", "vida", 45));
//		assertEquals (45,_mock.recuperarPontosDeUmTipoDeUmUsuario("vida", "francisco"));
//	}
//	@Test
//	void test004() throws Exception {
//   	_placar = new Placar (_mock);
//		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("fernanda", "vida ", 48));
//		assertEquals (48,_mock.recuperarPontosDeUmTipoDeUmUsuario("vida ", "fernanda"));
//	}
//	@Test
//	void test005() throws Exception {
//   	_placar = new Placar (_mock);
//		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("antonio", "vida", 145));
//		assertEquals (145,_mock.recuperarPontosDeUmTipoDeUmUsuario("vida", "antonio"));
//	}
//	@Test
//	void test006() throws Exception {
//   	_placar = new Placar (_mock);
//		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("rafael", "vida", 140));
//		assertEquals (140,_mock.recuperarPontosDeUmTipoDeUmUsuario("vida", "rafael"));
//	}
//	@Test
//	void test007() throws Exception {
//   	_placar = new Placar (_mock);
//		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("antonieta", "vida", 300));
//		assertEquals (300,_mock.recuperarPontosDeUmTipoDeUmUsuario("vida", "antonieta"));
//	}
//	@Test
//	void test008() throws Exception {
//   	_placar = new Placar (_mock);
//		_placar.registrarPontosDoUsuario(new PontuacaoUsuarios("pereira", "vida", 125));
//		assertEquals (125,_mock.recuperarPontosDeUmTipoDeUmUsuario("vida", "pereira"));
//	}
//	@Test
//	void test009() throws Exception {
//	    _placar = new Placar (_mock);
//		HashMap<String,String> _pontosDoUsuario = _placar.retornarPontosDoUsuario ("francisco");
//		assertEquals (true,_pontosDoUsuario.containsKey("comentario"));
//		assertEquals (true,_pontosDoUsuario.containsValue("5"));
//		assertEquals (true,_pontosDoUsuario.containsKey("star"));
//		assertEquals (true,_pontosDoUsuario.containsValue("19"));
//		assertEquals (true,_pontosDoUsuario.containsKey("vida"));
//		assertEquals (true,_pontosDoUsuario.containsValue("45"));
//
//	}
//	@Test
//	void test010() throws Exception {
//		_placar = new Placar (_mock);
//		List<RankingPontos> _rankingOrdemDecrescente = _placar.retornarRankingUsuariosDeUmTipoDePonto ("vida");
//		assertEquals (false,_rankingOrdemDecrescente.isEmpty());
//		assertEquals (true,_rankingOrdemDecrescente.get(0).getUsuario().equals("antonieta"));
//		assertEquals (300l,_rankingOrdemDecrescente.get(0).getPontos());
//		assertEquals (true,_rankingOrdemDecrescente.get(1).getUsuario().equals("antonio"));
//		assertEquals (145l,_rankingOrdemDecrescente.get(1).getPontos());
//		assertEquals (true,_rankingOrdemDecrescente.get(2).getUsuario().equals("rafael"));
//		assertEquals (140l,_rankingOrdemDecrescente.get(2).getPontos());
//		assertEquals (true,_rankingOrdemDecrescente.get(3).getUsuario().equals("pereira"));;
//		assertEquals (125l,_rankingOrdemDecrescente.get(3).getPontos());
//		assertEquals (true,_rankingOrdemDecrescente.get(4).getUsuario().equals("fernanda"));
//		assertEquals (48l,_rankingOrdemDecrescente.get(4).getPontos());
//		assertEquals (true,_rankingOrdemDecrescente.get(5).getUsuario().equals("francisco"));
//		assertEquals ( 45l,_rankingOrdemDecrescente.get(5).getPontos());
//	}
}


