
package courseraita;
import java.util.HashSet;
import java.util.LinkedList;

public interface IArmazenamento {

	public void armazenarQtePontosDeUmTipoRecebidoPeloUsuario (Usuarios u);
	
	public HashSet<String> retornarTodosOsTiposDePontosJaRegistradosparaAlgumUsuario ();
	
	public LinkedList<Usuarios> retornarTodosUsuariosComAlgumTipodePonto () throws Exception;
	
	public int recuperarQuantoPontosDeUmTipoTemOUsuario (String tipoPonto, String usuario) throws Exception;

}
