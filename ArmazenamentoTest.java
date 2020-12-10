package courseraita;

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

		Armazenamento _a = new Armazenamento();
		DriverArquivoTXT _f =  new DriverArquivoTXT(1, _a); 
    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "estrela", 50));
    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "estrela", 50));
    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "comentarios", 80));
    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "vida", 19));
    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "energia", 30));
    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "curtida", 28));
    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "moeda", 44));
    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "estrela", 100));
    	_f.extendeArquivotextoPontuacao(new PontuacaoUsuarios("francisco", "estrela", -50));
	
		
		
	}
	
	

}
