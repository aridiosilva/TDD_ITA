package cxeletronico;

public interface IServicoRemoto {

	public ContaCorrente recuperarConta(String numeroConta);
	public void persistirConta(ContaCorrente cc);	
	public void exibirDadosContasCadastradas ();
	
}
