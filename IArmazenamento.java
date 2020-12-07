
package courseraita;
import java.util.HashSet;
import java.util.LinkedList;

public interface IArmazenamento {

	public void armazenarPontuacaoDeUmUsuario (PontuacaoUsuarios u);
	
	public HashSet<String> retornarTiposDePontosJaRegistrados ();
	
	public LinkedList<PontuacaoUsuarios> retornarUsuariosComAlgumTipodePonto () throws Exception;
	
	public int recuperarPontosDeUmTipoDeUmUsuario (String tipoPonto, String usuario) throws Exception;

}

