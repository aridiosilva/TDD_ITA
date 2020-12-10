
package courseraita;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArmazenamentoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSet001() throws IOException, Exception {

		DriverArquivoTXT _f =  new DriverArquivoTXT(); 
		_f.deletarArquivoTextoDePontuacao();
		Armazenamento _a = new Armazenamento(_f);
		_a.armazenarPontuacaoDeUmUsuario(new PontuacaoUsuarios("joana", "estrela", 50));
		_a.armazenarPontuacaoDeUmUsuario(new PontuacaoUsuarios("joana", "estrela", 50));
		_a.armazenarPontuacaoDeUmUsuario(new PontuacaoUsuarios("joana", "comentarios", 80));

//    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "vida", 19));
//    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "energia", 30));
//    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "curtida", 28));
//    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "moeda", 44));
//    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "estrela", 100));
//    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "estrela", -50));
    	
		assertEquals (280, _a.recuperarTotaisDePontosDeUmTipoDeUmUsuario("estrela", "joana"));  
		
	}
	
	

}
