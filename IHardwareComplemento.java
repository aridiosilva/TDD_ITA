package cxeletronico;

public interface IHardwareComplementar extends IHardware {
	
	public void exibirMsgAoUsuarioCaixaEletronico(String msg);
	public String solicitarSenhaDoUsuario (String msg);

}
