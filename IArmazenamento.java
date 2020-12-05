
package courseraita;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public interface IArmazenamento {

	public void armazenarQtePontosDeUmTipoRecebidoPeloUsuario (Usuarios u);
	public HashSet<String> retornarTiposDePontosRegistrados ();
	public LinkedList<Usuarios> retornarTodosUsuariosComAlgumTipodePonto () throws Exception;
	public int recuperarQuantoPontosDeUmTipoTemOUsuario (String tipoPonto, String usuario) throws Exception;

}
