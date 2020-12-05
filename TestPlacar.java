package courseraita;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

class TestPlacar {

	MockArmazenamento _mock = new MockArmazenamento();
	Placar _placar = new Placar (_mock);

	@Test
	void testIncuiPontuacaoPrimeiroUsuario() throws Exception {
		_placar.registrarPontosDoUsuario (new Usuarios("guerra", "estrela", 10));
		assertEquals (10,_mock.recuperarQuantoPontosDeUmTipoTemOUsuario("estrela", "guerra"));
		HashSet<String> _tiposDePontos =  _mock.retornarTiposDePontosRegistrados();
		assertEquals (1,_tiposDePontos.size());
		assertEquals (true,_tiposDePontos.contains("estrela"));
	}

	
}
