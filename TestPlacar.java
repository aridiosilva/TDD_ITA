package courseraita;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlacar {

	MockArmazenamento _mock = new MockArmazenamento();
	Placar _placar = new Placar (_mock);
	
	@Test
	void testIncuiPontuacaoPrimeiroUsuario() {

		Usuarios usuario1 = new Usuarios("guerra", "estrela", 10);
		assertEquals (true,_placar.registrarPontosDoUsuario (usuario1));
	}

}
