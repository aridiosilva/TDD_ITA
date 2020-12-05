
package courseraita;
import java.util.HashSet;
import java.util.List;

public interface IArmazenamento {
	
	public void armazenarQtePontosDeUmTipoRecebidoPeloUsuario (Usuarios u);
	public HashSet<String> retornarTiposDePontosRegistrados ();
	public List<Usuarios> retornarUsuariosComPontosDiferenteZero ();
	public int recuperarQuantoPontosDeUmTipoTemOUsuario (String tipoPonto, String usuario) throws Exception;

}
