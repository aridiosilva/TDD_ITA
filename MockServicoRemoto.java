package cxeletronico;

import java.util.ArrayList;
import java.util.List;

public class MockServicoRemoto implements IServicoRemoto {

 	List<ContaCorrente> _contas = new ArrayList<>();
 	
 	@Override
	public ContaCorrente recuperarConta(String numeroConta) {
		
		for (ContaCorrente cc: _contas) {
			
		    System.out.println("Numero Conta = " + cc.getNumeroConta());
		    System.out.println("Saldo Conta = " + cc.getSaldo() );
		    System.out.println("Senha Conta = " + cc.getSenha());
		    String _dadosConta = (String) cc.getNumeroConta();
		    if ( _dadosConta.contains(numeroConta) ) 
	              return cc;   		
		}
		throw new RuntimeException ("Problema - Conta Corrente Não Existe");	
	}

	@Override
	public void persistirConta(ContaCorrente cc) {
		_contas.add(cc);
	}

}