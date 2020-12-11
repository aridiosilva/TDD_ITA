
package courseraita;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.LinkedList;

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

		DriverArquivoTXT _driver =  new DriverArquivoTXT(false); 
		Armazenamento _a = new Armazenamento(_driver);
		
		_a.armazenarPontuacaoDeUmUsuario(new PontuacaoUsuarios("joana", "estrela", 50));
		_a.armazenarPontuacaoDeUmUsuario(new PontuacaoUsuarios("joana", "estrela", 50));
		_a.armazenarPontuacaoDeUmUsuario(new PontuacaoUsuarios("joana", "comentarios", 80));

		assertEquals (100, _a.recuperarTotaisDePontosDeUmTipoDeUmUsuario("estrela", "joana"));  
		assertEquals (80, _a.recuperarTotaisDePontosDeUmTipoDeUmUsuario("comentarios", "joana"));  
		
		LinkedList<PontuacaoUsuarios> _listaPontos = _a.retornarUsuariosComAlgumTipodePonto();
		
		assertEquals ("joana",   _listaPontos.get(0).getUsuario()); 
		assertEquals ("estrela", _listaPontos.get(0).getTipoPonto());  
		assertEquals (50,        _listaPontos.get(0).getPontos());  

		assertEquals ("joana",   _listaPontos.get(1).getUsuario()); 
		assertEquals ("estrela", _listaPontos.get(1).getTipoPonto());  
		assertEquals (50,        _listaPontos.get(1).getPontos());  
		
		assertEquals ("joana",   _listaPontos.get(2).getUsuario()); 
		assertEquals ("comentarios", _listaPontos.get(2).getTipoPonto());  
		assertEquals (80,        _listaPontos.get(2).getPontos());  
		
		DriverArquivoTXT _driver1 =  new DriverArquivoTXT(true); 
		
//    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "vida", 19));
//    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "energia", 30));
//    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "curtida", 28));
//    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "moeda", 44));
//    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "estrela", 100));
//    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "estrela", -50));
    	
		
	}
	
	

}
