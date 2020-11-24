
package cxeletronico;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CaixaEletronico {

	private  List<IHardwareComplementar> _hardware = new ArrayList(); 
	private  List<IServicoRemoto> _servRemoto  = new ArrayList();
	private  IHardwareComplementar _h; 
	private  IServicoRemoto _s; 
	private  ContaCorrente _account = new ContaCorrente(null, 0.0f, null);
	
	public Boolean logar() {

		String _LOGIN_OK     = "Usuario Autenticado com Sucesso";
		String _LOGIN_FALHOU = "Não foi possivel autenticar usuario";
		String _numeroConta;
		String _senhaUsuario;

		_h = _hardware.get(0);
		_s = _servRemoto.get(0);
		try {
			_numeroConta  = _h.pegarNumeroDaConta("SemErro");
			_account = _s.recuperarConta(_numeroConta);
			_senhaUsuario = _h.solicitarSenhaDoUsuario("SemErro");
			String _senhaGravada = _account.getSenha();
			if ( !_senhaUsuario.equals(_senhaGravada) ) { 
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

	public Boolean sacar(String numConta, float valorDoSaque) {		

		if (_hardware.isEmpty() || _servRemoto.isEmpty() )
			throw new RuntimeException ("Erro Interno Aplicacao");	
		try {
			_h = _hardware.get(0);
			_s = _servRemoto.get(0);		
			_h.lerEnvelope("Insira o Envelope");
			_account = _s.recuperarConta(numConta);
			float _saldoCliente = (float) _account.getSaldo();
			if (valorDoSaque <= 0.0f ) {
				_h.exibirMsgAoUsuarioCaixaEletronico("Saque de Valor Zero ou Negativo não é possível");
	            return false;
			}
			if (_saldoCliente < valorDoSaque) {
				_h.exibirMsgAoUsuarioCaixaEletronico("Saldo Insuficinte");   
		        return false;
			}
			_account.abaterValorSaqueDoSaldo(valorDoSaque);
			_s.persistirConta (_account);
			_h.exibirMsgAoUsuarioCaixaEletronico("Retire seu Dinheiro");  
			
		} catch (Exception e) {
			_h.exibirMsgAoUsuarioCaixaEletronico("Problema no Hardware");
	        return false;
		}
		return true;	
	}


	public Boolean depositar(String numConta, float valorADepositar) {		

		if (_hardware.isEmpty() || _servRemoto.isEmpty()) 
			throw new RuntimeException ("Erro Interno Aplicacao");
		_h = _hardware.get(0);
		_s = _servRemoto.get(0);
		try {
			_account = _s.recuperarConta(numConta);
			if (valorADepositar <= 0.0f ) {
				_h.exibirMsgAoUsuarioCaixaEletronico("Deposito de Valor Zero ou Negativo não é possível");
	            return false;
			}
			_account.adicionarValorDepositoAoSaldo( valorADepositar );
			_h.exibirMsgAoUsuarioCaixaEletronico("Insira o Envelope");   
			_s.persistirConta (_account);
			_h.entregarDinheiro("Deposito Recebido com Sucesso");  

		} catch (Exception e) {
			_h.exibirMsgAoUsuarioCaixaEletronico("Problema no Hardware");
	        return false;
		}
		return true;	
	}

	public Boolean saldo (String numConta) {

		String _prefixo = "O Saldo é de R$";

		if (_hardware.isEmpty() || _servRemoto.isEmpty()) 
			throw new RuntimeException ("Erro Interno Aplicacao");
		_h = _hardware.get(0);
		_s = _servRemoto.get(0);
		try {
			_account = _s.recuperarConta(numConta);
			_h.exibirMsgAoUsuarioCaixaEletronico(_prefixo.concat(String.format("%,.2f",_account.getSaldo())));
			return true;

		} catch (Exception e) {
			_h.exibirMsgAoUsuarioCaixaEletronico("Problema no Hardware");
	        return false;
		}		
	}

	public void adicionarHardware(IHardwareComplementar hardwareCXE) {
		_hardware.clear();
		_hardware.add(hardwareCXE);
		System.out.println("MOCK HARDWARE ADICIONADO");
	}

	public void adicionarServicoRemoto(IServicoRemoto servRemoto) {
		_servRemoto.clear();
		_servRemoto.add(servRemoto);
		System.out.println("MOCK SERVIDOR REMOTO ADICIONADO");
	}

}



