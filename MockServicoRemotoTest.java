package cxeletronico;

import static org.junit.Assert.*;

import org.junit.Test;

public class MockServicoRemotoTest {

	@Test
	public void recuperarPrimeiraContaCorrente( ) {
		MockServicoRemoto _mock = new MockServicoRemoto();
	    _mock.persistirConta(new ContaCorrente ("1234", 100.0f, "senha1"));
	    ContaCorrente _cc = _mock.recuperarConta("1234");
		assertEquals ("1234", _cc.getNumeroConta());
		assertEquals (100.0f, _cc.getSaldo());
		assertEquals ("senha1", _cc.getSenha());
	}
	
	@Test
	public void recuperarSegundaContaCorrente( ) {
		MockServicoRemoto _mock = new MockServicoRemoto();
	    _mock.persistirConta(new ContaCorrente ("22222", 200.0f, "xyz"));
	    ContaCorrente _cc = _mock.recuperarConta("22222");
		assertEquals ("22222", _cc.getNumeroConta());
		assertEquals (200.0f, _cc.getSaldo());
		assertEquals ("xyz", _cc.getSenha());
	}

}
