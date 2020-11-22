package cxeletronico;

public class MockHardware implements IHardwareComplementar {

	private static int _indice=-1;
	private int _INDEX_MAXIMO_CONTAS = 14;

	@Override
	public String pegarNumeroDaConta(String msg) {
		if (msg == null)
			throw new RuntimeException ("Problema de Hardware");

		if (_indice > _INDEX_MAXIMO_CONTAS || _indice < 0)  
			_indice = 0;    else   _indice++;

		System.out.println(" HARDWARE indice: " + _indice );
		MockServicoRemoto _mockSR = new MockServicoRemoto();
		return (String) _mockSR.devolverNumConta(_indice);
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
//		System.out.println(" HARDWARE indice: " + _indice );
		MockServicoRemoto _mockSR = new MockServicoRemoto();
		return (String) _mockSR.devolverSenhaConta(_indice);
	}

	@Override
	public String solicitarValorASacar(String msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String solicitarValorADepositar(String msg) {
		// TODO Auto-generated method stub
		return null;
	}

}
