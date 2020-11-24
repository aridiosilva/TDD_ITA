
package cxeletronico;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MockServicoRemotoTest {

	MockServicoRemoto _mock = new MockServicoRemoto();

	@Test
	public void testa001recuperarPrimeiraContaCorrente( ) {
		_mock.persistirConta(new ContaCorrente ("9998", 100.0f, "XYZabc"));
		ContaCorrente _cc = _mock.recuperarConta("9998");
		assertEquals ("9998", _cc.getNumeroConta());
		assertEquals (100.0f, _cc.getSaldo());
		assertEquals ("XYZabc", _cc.getSenha());
	}
	@Test
	public void testa002recuperarSegundaContaCorrente( ) {
		_mock.persistirConta(new ContaCorrente ("124578", 200.0f, "@CC"));
		ContaCorrente _cc = _mock.recuperarConta("124578");
		assertEquals ("124578", _cc.getNumeroConta());
		assertEquals (200.0f, _cc.getSaldo());
		assertEquals ("@CC", _cc.getSenha());
	}
	@Test
	public void testa003recuperarTerceiraContaCorrente( ) {
		_mock.persistirConta(new ContaCorrente ("121212",  50.0f, "senha1"));
		ContaCorrente _cc = _mock.recuperarConta("121212");
		assertEquals ("121212", _cc.getNumeroConta());
		assertEquals (50.0f, _cc.getSaldo());
		assertEquals ("senha1", _cc.getSenha());
	}
	@Test
	public void testa004recuperarQuartaContaCorrente( ) {		
		_mock.persistirConta(new ContaCorrente ("232323",   0.0f, "senha33"));
		ContaCorrente _cc = _mock.recuperarConta("232323");
		assertEquals ("232323", _cc.getNumeroConta());
		assertEquals (0.0f, _cc.getSaldo());
		assertEquals ("senha33", _cc.getSenha());
	}
	@Test
	public void testa005recuperarQuintaContaCorrente( ) {		
		_mock.persistirConta(new ContaCorrente ("414141", 300.0f, "senha21"));
		ContaCorrente _cc = _mock.recuperarConta("414141");
		assertEquals ("414141", _cc.getNumeroConta());
		assertEquals (300.0f, _cc.getSaldo());
		assertEquals ("senha21", _cc.getSenha());
	}
	@Test
	public void testa006recuperarSextaContaCorrente( ) {		
		_mock.persistirConta(new ContaCorrente ("515151", 150.0f, "senha99"));
		ContaCorrente _cc = _mock.recuperarConta("515151");
		assertEquals ("515151", _cc.getNumeroConta());
		assertEquals (150.0f, _cc.getSaldo());
		assertEquals ("senha99", _cc.getSenha());
	}
	@Test
	public void testa007recuperarSetimaContaCorrente( ) {		
		_mock.persistirConta(new ContaCorrente ("616161",  90.0f, "senha13"));
		ContaCorrente _cc = _mock.recuperarConta("616161");
		assertEquals ("616161", _cc.getNumeroConta());
		assertEquals (90.0f, _cc.getSaldo());
		assertEquals ("senha13", _cc.getSenha());
	}
	@Test
	public void testa008recuperarOitavaContaCorrente( ) {
		_mock.persistirConta(new ContaCorrente ("646464", -450.0f, "senha66"));
		ContaCorrente _cc = _mock.recuperarConta("646464");
		assertEquals ("646464", _cc.getNumeroConta());
		assertEquals (-450.0f, _cc.getSaldo());
		assertEquals ("senha66", _cc.getSenha());
	}
	
}

