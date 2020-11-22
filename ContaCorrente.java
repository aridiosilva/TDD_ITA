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

	public String getNumeroConta() {
		return _numeroConta;
	}

	public Object getSaldo() {
		return (float) _saldoConta;
	}

	public String getSenha() {
		return _senhaConta;
	}
	
	public void abateSaqueDoSaldo(float valorDoSaque) {
		_saldoConta += valorDoSaque;
	}
	
	public void acresceValorDoDepositoNoSaldo(float valorDoDeposito) {
		_saldoConta += valorDoDeposito;
	}
	
}