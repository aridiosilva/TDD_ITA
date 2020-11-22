package cxeletronico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CaixaEletronicoTest {

	private MockHardware _mockHD = new MockHardware(); 
	private MockServicoRemoto _mockSR = new MockServicoRemoto();
	private CaixaEletronico _cxe = new CaixaEletronico ();

	@Before
	public void init() {
		_cxe.adicionarHardware(_mockHD);
		_cxe.adicionarServicoRemoto(_mockSR);
	}

	@Test
	public void testaPrimeiroLogin() {
		_mockSR.persistirConta(new ContaCorrente ("22222", 200.0f, "xyz"));
		ContaCorrente _cc = _mockSR.recuperarConta("22222");
		assertEquals ("22222", _cc.getNumeroConta());
		assertEquals (200.0f, _cc.getSaldo());
		assertEquals ("xyz", _cc.getSenha());
		assertEquals ( true, _cxe.logar());      	
	}
	@Test
	public void testaSegundoLogin() {
		_mockSR.persistirConta(new ContaCorrente ("1234", 100.0f, "senha1"));
		ContaCorrente _cc = _mockSR.recuperarConta("1234");
		assertEquals ("1234", _cc.getNumeroConta());
		assertEquals (100.0f, _cc.getSaldo());
		assertEquals ("senha1", _cc.getSenha());
		assertEquals ( true, _cxe.logar());      	
	}
	@Test
	public void testaTerceiroLogin() {
		_mockSR.persistirConta(new ContaCorrente ("999999", 200.0f, "Senha99"));
		ContaCorrente _cc = _mockSR.recuperarConta("999999");
		assertEquals ("999999", _cc.getNumeroConta());
		assertEquals (200.0f, _cc.getSaldo());
		assertEquals ("Senha99", _cc.getSenha());
		assertEquals ( true, _cxe.logar());      	
	}
	@Test
	public void testaQuartoLogin() {
		_mockSR.persistirConta(new ContaCorrente ("777777", 350.0f, "Senha98"));
		ContaCorrente _cc = _mockSR.recuperarConta("777777");
		assertEquals ("777777", _cc.getNumeroConta());
		assertEquals (350.0f, _cc.getSaldo());
		assertEquals ("Senha98", _cc.getSenha());
		assertEquals ( true, _cxe.logar());      	
	}
	@Test
	public void testaQuintoLogin() {
		_mockSR.persistirConta(new ContaCorrente ("666666", 190.0f, "Senha97"));
		ContaCorrente _cc = _mockSR.recuperarConta("666666");
		assertEquals ("666666", _cc.getNumeroConta());
		assertEquals (190.0f, _cc.getSaldo());
		assertEquals ("Senha97", _cc.getSenha());
		assertEquals ( true, _cxe.logar());      	
	}
	@Test
	public void testaSextoLogin() {
		_mockSR.persistirConta(new ContaCorrente ("888888", -250.0f, "Senha96"));
		ContaCorrente _cc = _mockSR.recuperarConta("888888");
		assertEquals ("888888", _cc.getNumeroConta());
		assertEquals (-250.0f, _cc.getSaldo());
		assertEquals ("Senha96", _cc.getSenha());
		assertEquals ( true, _cxe.logar());      	
	}
	@Test
	public void testaSetimoLogin() {
		_mockSR.persistirConta(new ContaCorrente ("555555", 0.0f, "Senha95"));
		ContaCorrente _cc = _mockSR.recuperarConta("555555");
		assertEquals ("555555", _cc.getNumeroConta());
		assertEquals (0.0f, _cc.getSaldo());
		assertEquals ("Senha95", _cc.getSenha());
		assertEquals ( true, _cxe.logar());      	
	}
	@Test
	public void saqueComSaldoSuficienteTeste01() {
		assertEquals ( true, _cxe.sacar("999999", 200.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("999999");
		assertEquals ("999999", _cc.getNumeroConta());
		assertEquals (0.0f, _cc.getSaldo());
		assertEquals ("Senha99", _cc.getSenha());
	}
	@Test
	public void saqueComSaldoSuficienteTeste02() {
		assertEquals ( true, _cxe.sacar("777777", 100.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("777777");
		assertEquals ("777777", _cc.getNumeroConta());
		assertEquals (250.0f, _cc.getSaldo());
		assertEquals ("Senha98", _cc.getSenha());
	}
	@Test
	public void saqueComSaldoSuficienteTeste03() {
		assertEquals ( true, _cxe.sacar("666666", 40.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("666666");
		assertEquals ("666666", _cc.getNumeroConta());
		assertEquals (150.0f, _cc.getSaldo());
		assertEquals ("Senha97", _cc.getSenha());
	}
	@Test
	public void saqueComSaldoNegativoTeste01() {
		assertEquals ( false, _cxe.sacar("888888", 140.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("888888");
		assertEquals ("888888", _cc.getNumeroConta());
		assertEquals (-250.0f, _cc.getSaldo());
		assertEquals ("Senha96", _cc.getSenha());
	}
	@Test
	public void saqueComSaldoZeradoTeste01() {
		assertEquals ( false, _cxe.sacar("555555", 80.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("555555");
		assertEquals ("555555", _cc.getNumeroConta());
		assertEquals (0.0f, _cc.getSaldo());
		assertEquals ("Senha95", _cc.getSenha());
	}

	@Test
	public void depositoContaSaldoMaiorPositivoTeste01() {
		assertEquals ( true, _cxe.depositar("1234", 500.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("1234");
		assertEquals ("1234", _cc.getNumeroConta());
		assertEquals (600.0f, _cc.getSaldo());
		assertEquals ("senha1", _cc.getSenha());
	}

		
	
}

