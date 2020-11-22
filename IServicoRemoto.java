package cxeletronico;

public interface IServicoRemoto {
	
    public Object recuperarConta(String numeroConta);
    
    public void persistirConta (Object contaCorrente);

}
