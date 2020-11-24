
package cxeletronico;

import java.util.ArrayList;
import java.util.List;

public class MockServicoRemoto implements IServicoRemoto {

	private static List<ContaCorrente> _contas = new ArrayList<>();

	@Override
	public ContaCorrente recuperarConta(String numeroConta) {

		for (int i = 0; i < _contas.size(); i++) {

			String _numConta = _contas.get(i).getNumeroConta();

			if ( _numConta.equals(numeroConta) ) {

				ContaCorrente _ccItem = new ContaCorrente(
						(String)_contas.get(i).getNumeroConta(),
						(float) _contas.get(i).getSaldo(),
						(String)_contas.get(i).getSenha()  );
				
				return _ccItem;    
			}
		}
		
		exibirDadosContasCadastradas();
		ContaCorrente _ccAux = new ContaCorrente ("", 0.0f, "");
		return _ccAux;
	}

	@Override
	public void persistirConta(ContaCorrente cc) {

		int _CONTA_EXISTE     = 1;
		int _CONTA_NAO_EXISTE = 0;
		int _situacaoConta    = _CONTA_NAO_EXISTE;

		String _numConta      = cc.getNumeroConta();
		float _novoSaldo      = (float) cc.getSaldo();
		
		for (int i = 0; i < _contas.size(); i++) {

			if ( _numConta.equals( _contas.get(i).getNumeroConta() )) {

				_contas.get(i).salvaSaldoAposSaqueOuDeposito(_novoSaldo);
				_situacaoConta = _CONTA_EXISTE;
			}
		}
		if (_situacaoConta == _CONTA_NAO_EXISTE)  
			
			_contas.add(cc);       

	}

	public String devolverNumeroDaConta(int numRegistro) {
		
		if ( _contas.isEmpty() || _contas.size() < numRegistro )		  	 
			 throw new RuntimeException ("Erro - Database Vazio!!!");
		return (String)_contas.get(numRegistro).getNumeroConta();
    }
	
    public String devolverSenhaDaConta(int numRegistro) {
    	
		if ( _contas.isEmpty())
			 throw new RuntimeException ("Erro - Database Vazio!!!");
		if ( _contas.size() < numRegistro )
			 throw new RuntimeException ("Erro - Numero do Registros Inexiste no Database!!!");

		return (String)_contas.get(numRegistro).getSenha();
    }
	
    public int informarQuantDeContasCadastradas () {
          return _contas.size();
    }

    @Override
    public void exibirDadosContasCadastradas () {
    	
    	int i = 0;
		for (ContaCorrente c: _contas) {
			
			System.out.println("\n"+"#" + i++ + 
					           " NumConta = (" + c.getNumeroConta() +
                               ") Saldo =  ("  + c.getSaldo() + 
                               ") Senha =  ("  + c.getSenha() + ")");
		}
    }
    

}



