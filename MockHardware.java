
package cxeletronico;

public class MockHardware implements IHardwareComplementar {

	private static int _indice=-1;

	@Override
	public String pegarNumeroDaConta(String msg) {
		
		if (msg == null)
			throw new RuntimeException ("Problema de Hardware");
		
		MockServicoRemoto _mockSR = new MockServicoRemoto();
		int numtotalContas = _mockSR.informarQuantDeContasCadastradas();

		if (_indice > numtotalContas || _indice < 0)  
			_indice = 0;    else   _indice++;

		return (String) _mockSR.devolverNumeroDaConta(_indice);
	}

	@Override
	public void entregarDinheiro(String msg) {		
		exibirMsgAoUsuarioCaixaEletronico (msg);
	};

	@Override
	public void lerEnvelope(String msg) {
		if (msg == null)
			throw new RuntimeException ("Problema de Hardware");		
		exibirMsgAoUsuarioCaixaEletronico (msg);
	}

	@Override
	public void exibirMsgAoUsuarioCaixaEletronico(String msg) {
		if (msg == null)
			throw new RuntimeException ("Problema de Hardware");		
		System.out.println("msg: " + msg);
	}

	@Override
	public String solicitarSenhaDoUsuario (String msg) {		
		if (msg == null)
			throw new RuntimeException ("Problema de Hardware");		
		MockServicoRemoto _mockSR = new MockServicoRemoto();
		return (String) _mockSR.devolverSenhaDaConta(_indice);
	}

}
