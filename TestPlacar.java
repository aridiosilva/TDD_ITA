package courseraita;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
class TestPlacar {

	MockArmazenamento _mock = new MockArmazenamento();
	Placar _placar = new Placar (_mock);

	@Test
	void test001() throws Exception {
		
		_placar.registrarPontosDoUsuario(new Usuarios("francisco", "estrela", 19));
		assertEquals (19,_mock.recuperarQuantoPontosDeUmTipoTemOUsuario("estrela", "francisco"));
		HashSet<String> _tiposDePontos = _mock.retornarTodosOsTiposDePontosJaRegistradosparaAlgumUsuario();
		assertEquals (1,_tiposDePontos.size());
		assertEquals (true,_tiposDePontos.contains("estrela"));
	}
}
