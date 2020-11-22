package cxeletronico;

public class ContaCorrente {
	
	private String _numeroConta;
	private float _saldoConta;
	private String _senhaConta;
	
	public ContaCorrente (String numeroConta, float saldoConta, String senhaConta) {
 	  this._numeroConta = numeroConta;
 	  this._saldoConta = saldoConta;
 	  this._senhaConta = senhaConta;	  
	}

	public Object getNumeroConta() {
		return _numeroConta;
	}
	
	public Object getSaldo() {
		return _saldoConta;
	}

	public Object getSenha() {
		return _senhaConta;
	}
		
	
}
