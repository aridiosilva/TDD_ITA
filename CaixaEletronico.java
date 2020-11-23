
package cxeletronico;

import java.util.ArrayList;
import java.util.List;

public class CaixaEletronico {

	private List<IHardwareComplementar> _hardware = new ArrayList(); 
	private List<IServicoRemoto> _servRemoto  = new ArrayList();
	private IHardwareComplementar _h; 
	private IServicoRemoto _s; 
	private ContaCorrente _cc;
	
	public Boolean logar() {

		String _LOGIN_OK = "Usuario Autenticado com Sucesso";
		String _LOGIN_FALHOU = "Não foi possivel autenticar usuario";
		String _numeroConta;
		String _senhaUsuario;

		_h = _hardware.get(0);
		_s = _servRemoto.get(0);
		try {
			_numeroConta  = _h.pegarNumeroDaConta("SemErro");
//			System.out.println("Login Conta Lida do Cartão: [" + _numeroConta + "]");
			_cc = _s.recuperarConta(_numeroConta);
//			System.out.println(" RECUPERADA NumConta= (" + _cc.getNumeroConta() +
//                   ") Saldo=  (" + _cc.getSaldo() + ") Senha=  (" + _cc.getSenha() + ")");
			_senhaUsuario = _h.solicitarSenhaDoUsuario("SemErro");
//			System.out.println("Login Senha Obtida: [" + _senhaUsuario + "]");
			String _senhaGravada = _cc.getSenha();
//			System.out.println("Login Senha Gravada: [" + _senhaGravada + "]");
			if ( !_senhaUsuario.contains(_senhaGravada) ) { 
				_h.exibirMsgAoUsuarioCaixaEletronico(_LOGIN_FALHOU);
				return false; 			
			}

		} catch (Exception e) {
			_h.exibirMsgAoUsuarioCaixaEletronico(_LOGIN_FALHOU);
			return false;   
		}
		_h.exibirMsgAoUsuarioCaixaEletronico(_LOGIN_OK);
		return true;
	}

	public void adicionarHardware(IHardwareComplementar hardwareCXE) {
		_hardware.clear();
		_hardware.add(hardwareCXE);
//		System.out.println("MOCK HARDWARE ADICIONADO");
	}

	public void adicionarServicoRemoto(IServicoRemoto servRemoto) {
		_servRemoto.clear();
		_servRemoto.add(servRemoto);
//		System.out.println("MOCK SERVIDOR REMOTO ADICIONADO");
	}
	
	public Boolean sacar(String numConta, float valorDoSaque) {		

		System.out.println("Sacar de CC: " + numConta );
		System.out.println(" Saque = " + valorDoSaque);
		if (_hardware.isEmpty())
			throw new RuntimeException ("Erro Interno Aplicacao");
		if (_servRemoto.isEmpty())
			throw new RuntimeException ("Erro Interno Aplicacao");	
		_h = _hardware.get(0);
		_s = _servRemoto.get(0);
		_cc = _s.recuperarConta(numConta);
		float _saldoCliente = (float) _cc.getSaldo();
		System.out.println(" Saldo Atual = " + _saldoCliente);
		try {
			if (_saldoCliente < valorDoSaque) {
				_h.exibirMsgAoUsuarioCaixaEletronico("Saldo Insuficinte");   
				System.out.println(" Saldo Final = " + _cc.getSaldo());
		        return false;
			}
			_cc.abaterValorSaqueDoSaldo(valorDoSaque);
			System.out.println(" Saldo Final = " + _cc.getSaldo());
			_s.persistirConta (_cc);
			_h.exibirMsgAoUsuarioCaixaEletronico("Retire seu Dinheiro");  
			
		} catch (Exception e) {
			_h.exibirMsgAoUsuarioCaixaEletronico("Problema no Hardware");
	        return false;
		}
		return true;	
	}


	public Boolean depositar(String numConta, float valorADepositar) {		

		System.out.println("Deposita na CC: " + numConta );
		System.out.println("Deposito de = " + valorADepositar);
		if (_hardware.isEmpty())
			throw new RuntimeException ("Erro Interno Aplicacao");
		if (_servRemoto.isEmpty())
			throw new RuntimeException ("Erro Interno Aplicacao");	
		_h = _hardware.get(0);
		_s = _servRemoto.get(0);
		try {
			_cc = _s.recuperarConta(numConta);
			System.out.println(" Saldo Atual = " + _cc.getSaldo());	
			_cc.adicionarValorDepositoAoSaldo( valorADepositar );
			_h.exibirMsgAoUsuarioCaixaEletronico("Insira o Envelope");   
			_s.persistirConta (_cc);
			System.out.println(" Saldo Final = " + _cc.getSaldo());
			_h.exibirMsgAoUsuarioCaixaEletronico("Deposito Recebido com Sucesso");  

		} catch (Exception e) {
			_h.exibirMsgAoUsuarioCaixaEletronico("Problema no Hardware");
	        return false;
		}
		return true;	
	}

	
}


