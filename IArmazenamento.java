
package courseraita;
import java.util.List;

public interface IArmazenamento {
	
	public boolean armazenarQtePontosDeUmTipoRecebidoPeloUsuario (Usuarios u);
	public List<String> retornarTiposDePontosRegistrados ();
	public List<String> retornarUsuariosComPontosDiferenteZero ();
	public int recuperarQuantoPontosDeUmTipoTemOUsuario (String tipoPonto, String Usuario);

}
