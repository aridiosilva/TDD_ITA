package cxeletronico;

import java.util.ArrayList;
import java.util.List;

public class MockServicoRemoto implements IServicoRemoto {

	private static List<ContaCorrente> _contas = new ArrayList<>();

	@Override
	public ContaCorrente recuperarConta(String numeroConta) {

		System.out.println("Conta a Recuperar= (" + numeroConta + ")");
		System.out.println("Ocorrencias da ContaCorrente= (" + _contas.size() + ")");
		for (int i = 0; i < _contas.size(); i++) {
			System.out.println(" SERVREMOTO INDICE DATABASE= (" + i );
		    String _numConta = _contas.get(i).getNumeroConta();
   		    if ( _numConta.contains(numeroConta) ) {
   				System.out.println(" SERVREMOTO NumConta= (" + _contas.get(i).getNumeroConta() +
                          ") Saldo=  (" + _contas.get(i).getSaldo() + 
                          ") Senha=  (" + _contas.get(i).getSenha() + ")");
   				ContaCorrente _ccItem = new ContaCorrente((String)_contas.get(i).getNumeroConta(),
                               							  (float) _contas.get(i).getSaldo(),
                                                          (String)_contas.get(i).getSenha()  );
                return _ccItem;    
   		    }
		}
//		System.out.println ("Problema - Conta Corrente Não Existe >> " + numeroConta);
		throw new RuntimeException ("Problema - Conta Corrente Não Existe");	
	}

	@Override
	public void persistirConta(ContaCorrente cc) {

		ContaCorrente _cctemp = cc;
		String _numConta = cc.getNumeroConta();
		float _novoSaldo = (float) cc.getSaldo();
		int _contaNaoExiste = 1;
		for (int i = 0; i < _contas.size(); i++) {
			String _nConta = _contas.get(i).getNumeroConta();
			if ( _numConta.contains(_nConta) ) {
				 _contas.get(i).salvaSaldoAposSaqueOuDeposito(_novoSaldo);
				 _contaNaoExiste = 0;
			}
		}
		if (_contaNaoExiste == 1)
	         	_contas.add(cc);       
	}

	public String devolverNumConta(int numRegistro) {
		if ( _contas.isEmpty())  
			throw new RuntimeException ("Erro - Database Vazio!!!");
		if (_contas.size() < numRegistro)	
			throw new RuntimeException ("Erro - Database Vazio!!!");
		return (String)_contas.get(numRegistro).getNumeroConta();
    }
	
    public String devolverSenhaConta(int numRegistro) {
		if ( _contas.isEmpty())  
			throw new RuntimeException ("Erro - Database Vazio!!!");
		if (_contas.size() < numRegistro)	
			throw new RuntimeException ("Erro - Database Vazio!!!");
		return (String)_contas.get(numRegistro).getSenha();
    }
	
}


