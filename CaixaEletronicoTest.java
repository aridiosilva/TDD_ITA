
package cxeletronico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CaixaEletronicoTest {

	private  static MockHardware _mockHD = new MockHardware(); 
	private  static MockServicoRemoto _mockSR = new MockServicoRemoto();
	private  static CaixaEletronico _cxe = new CaixaEletronico ();
	private  static boolean singleton = true;
	
	@Before
	public void init() {
		if (singleton) {
		   _cxe.adicionarHardware(_mockHD);
		   _cxe.adicionarServicoRemoto(_mockSR);
		   singleton = false;
		}
	}

	@Test
	public void testa01PrimeiroLogin() {
		_mockSR.persistirConta(new ContaCorrente ("22222", 0.0f, "xyz"));
		ContaCorrente _cc = _mockSR.recuperarConta("22222");
		assertEquals ("22222", _cc.getNumeroConta());
		assertEquals (0.0f, _cc.getSaldo());
		assertEquals ("xyz", _cc.getSenha());
		assertEquals ( true, _cxe.logar());  
		_mockSR.exibirDadosContasCadastradas();
	}
	@Test
	public void testa02SegundoLogin() {
		_mockSR.persistirConta(new ContaCorrente ("1234", 100.0f, "senha1"));
		ContaCorrente _cc = _mockSR.recuperarConta("1234");
		assertEquals ("1234", _cc.getNumeroConta());
		assertEquals (100.0f, _cc.getSaldo());
		assertEquals ("senha1", _cc.getSenha());
		assertEquals ( true, _cxe.logar());   
		_mockSR.exibirDadosContasCadastradas();
	}
	@Test
	public void testa03TerceiroLogin() {
		_mockSR.persistirConta(new ContaCorrente ("999999", 200.0f, "Senha99"));
		ContaCorrente _cc = _mockSR.recuperarConta("999999");
		assertEquals ("999999", _cc.getNumeroConta());
		assertEquals (200.0f, _cc.getSaldo());
		assertEquals ("Senha99", _cc.getSenha());
		assertEquals ( true, _cxe.logar());    
		_mockSR.exibirDadosContasCadastradas();
	}
	@Test
	public void testa04QuartoLogin() {
		_mockSR.persistirConta(new ContaCorrente ("777777", 350.0f, "Senha98"));
		ContaCorrente _cc = _mockSR.recuperarConta("777777");
		assertEquals ("777777", _cc.getNumeroConta());
		assertEquals (350.0f, _cc.getSaldo());
		assertEquals ("Senha98", _cc.getSenha());
		assertEquals ( true, _cxe.logar());      	
	}
	@Test
	public void testa05QuintoLogin() {
		_mockSR.persistirConta(new ContaCorrente ("666666", 190.0f, "Senha97"));
		ContaCorrente _cc = _mockSR.recuperarConta("666666");
		assertEquals ("666666", _cc.getNumeroConta());
		assertEquals (190.0f, _cc.getSaldo());
		assertEquals ("Senha97", _cc.getSenha());
		assertEquals ( true, _cxe.logar());      	
	}
	@Test
	public void testa06SextoLogin() {
		_mockSR.persistirConta(new ContaCorrente ("888888", -250.0f, "Senha96"));
		ContaCorrente _cc = _mockSR.recuperarConta("888888");
		assertEquals ("888888", _cc.getNumeroConta());
		assertEquals (-250.0f, _cc.getSaldo());
		assertEquals ("Senha96", _cc.getSenha());
		assertEquals ( true, _cxe.logar());      	
	}
	@Test
	public void testa07SetimoLogin() {
		_mockSR.persistirConta(new ContaCorrente ("555555", 0.0f, "Senha95"));
		ContaCorrente _cc = _mockSR.recuperarConta("555555");
		assertEquals ("555555",  _cc.getNumeroConta());
		assertEquals (0.0f,      _cc.getSaldo());
		assertEquals ("Senha95", _cc.getSenha());
		assertEquals ( true,     _cxe.logar());      	
	}
	@Test
	public void testa08saqueComSaldoSuficienteTeste01() {
		assertEquals ( true, _cxe.sacar("999999", 200.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("999999");
		assertEquals ("999999",  _cc.getNumeroConta());
		assertEquals (0.0f,      _cc.getSaldo());
		assertEquals ("Senha99", _cc.getSenha());
	}
	@Test
	public void testa09saqueComSaldoSuficienteTeste02() {
		assertEquals ( true, _cxe.sacar("777777", 100.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("777777");
		assertEquals ("777777",  _cc.getNumeroConta());
		assertEquals (250.0f,    _cc.getSaldo());
		assertEquals ("Senha98", _cc.getSenha());
	}
	@Test
	public void testa10saqueComSaldoSuficienteTeste03() {
		assertEquals ( true, _cxe.sacar("666666", 40.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("666666");
		assertEquals ("666666",  _cc.getNumeroConta());
		assertEquals (150.0f,    _cc.getSaldo());
		assertEquals ("Senha97", _cc.getSenha());
	}
	@Test
	public void testa11saqueComSaldoNegativoTeste01() {
		assertEquals ( false, _cxe.sacar("888888", 140.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("888888");
		assertEquals ("888888",  _cc.getNumeroConta());
		assertEquals (-250.0f,   _cc.getSaldo());
		assertEquals ("Senha96", _cc.getSenha());
	}
	@Test
	public void testa12saqueComSaldoZeradoTeste01() {
		assertEquals ( false, _cxe.sacar("555555", 80.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("555555");
		assertEquals ("555555",  _cc.getNumeroConta());
		assertEquals (0.0f,      _cc.getSaldo());
		assertEquals ("Senha95", _cc.getSenha());
	}
	@Test
	public void testa13depositoContaSaldoMaiorPositivoTeste01() {
		assertEquals ( true, _cxe.depositar("1234", 500.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("1234");
		assertEquals ("1234",   _cc.getNumeroConta());
		assertEquals (600.0f,   _cc.getSaldo());
		assertEquals ("senha1", _cc.getSenha());
	}
	@Test
	public void testa14depositoContaSaldoMaiorPositivoTeste02() {
		assertEquals ( true, _cxe.depositar("777777", 50.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("777777");
		assertEquals ("777777",  _cc.getNumeroConta());
		assertEquals (300.0f,    _cc.getSaldo());
		assertEquals ("Senha98", _cc.getSenha());
	}
	@Test
	public void testa15depositoContaSaldoMaiorPositivoTeste03() {
		assertEquals ( true, _cxe.depositar("666666", 40.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("666666");
		assertEquals ("666666",  _cc.getNumeroConta());
		assertEquals (190.0f,    _cc.getSaldo());
		assertEquals ("Senha97", _cc.getSenha());
	}
	@Test
	public void testa16depositoContaComSaldoNegativoTeste01() {
		assertEquals ( true, _cxe.depositar("888888", 140.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("888888");
		assertEquals ("888888",  _cc.getNumeroConta());
		assertEquals (-110.0f,   _cc.getSaldo());
		assertEquals ("Senha96", _cc.getSenha());
	}
	@Test
	public void testa17depositoComSaldoZeradoTeste01() {
		assertEquals ( true, _cxe.depositar("555555", 80.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("555555");
		assertEquals ("555555",  _cc.getNumeroConta());
		assertEquals (80.0f,     _cc.getSaldo());
		assertEquals ("Senha95", _cc.getSenha());
	}
	@Test
	public void testa18depositoComSaldoZeradoTeste02() {
		assertEquals ( true, _cxe.depositar("999999", 100.0f));    
		ContaCorrente _cc = _mockSR.recuperarConta("999999");
		assertEquals ("999999",  _cc.getNumeroConta());
		assertEquals (100.0f,     _cc.getSaldo());
		assertEquals ("Senha99", _cc.getSenha());
	}
	@Test
	public void testa19depositoEmContaQueTeveDepositoTeste01() {
		assertEquals ( true,     _cxe.depositar("555555", 80.0f));    
		ContaCorrente _cc =      _mockSR.recuperarConta("555555");
		assertEquals ("555555",  _cc.getNumeroConta());
		assertEquals (160.0f,    _cc.getSaldo());
		assertEquals ("Senha95", _cc.getSenha());
	}
	@Test
	public void testa20saldoPositivoTeste01() {
		assertEquals ( true,     _cxe.saldo ("1234"));    
		ContaCorrente _cc =      _mockSR.recuperarConta("1234");
		assertEquals ("1234",  _cc.getNumeroConta());
		assertEquals (600.0f,    _cc.getSaldo());
		assertEquals ("senha1", _cc.getSenha());
	}
	@Test
	public void testa21saldoNegativoTeste02() {
		assertEquals ( true,     _cxe.saldo ("888888"));    
		ContaCorrente _cc =      _mockSR.recuperarConta("888888");
		assertEquals ("888888",  _cc.getNumeroConta());
		assertEquals (-110.0f,    _cc.getSaldo());
		assertEquals ("Senha96", _cc.getSenha());
	}
	@Test
	public void testa22saldoNuloTeste03() {
		assertEquals ( true,     _cxe.saldo ("22222"));    
		ContaCorrente _cc =      _mockSR.recuperarConta("22222");
		assertEquals ("22222",   _cc.getNumeroConta());
		assertEquals (0.0f,      _cc.getSaldo());
		assertEquals ("xyz",     _cc.getSenha());
	}
	@Test
	public void Testa23depositoDeValorNulo() {
		assertEquals ( false, _cxe.depositar ("1234", 0.0f));    
	}
	@Test
	public void Testa24depositoDeValorNegativo() {
		assertEquals ( false, _cxe.depositar ("777777", -300.0f));    
	}
	@Test
	public void Testa25saqueValorNegativo() {
		assertEquals ( false, _cxe.sacar ("666666", -30.0f));    
	}
	@Test
	public void Testa26saqueValorNulo() {
		assertEquals ( false, _cxe.sacar ("555555", 0.0f));    
		_mockSR.exibirDadosContasCadastradas();
	}
		
}

