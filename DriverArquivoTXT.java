
package courseraita;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

public class DriverArquivoTXT {
	
	private static File file = new File( "pontuacao.txt" );
	private final  String SEPARADOR_CAMPOS = "!";
	
	public DriverArquivoTXT (boolean deletarArquivoTXT) throws Exception {
		if (deletarArquivoTXT) {
			deletarArquivoTXT();
		}
	}
	
	public LinkedList<PontuacaoUsuarios> cargaEmCacheApartirArquivoTXT() throws Exception {
		
		LinkedList<PontuacaoUsuarios> _pontuacaoCache = new LinkedList<PontuacaoUsuarios>();
		try {
			if (file.exists()) { 
				RandomAccessFile fileTXT = new RandomAccessFile(file, "rw");				
				
				String bufferLeitura; 
				int numRegsLidos = 0;
				
				while (fileTXT.getFilePointer() < fileTXT.length()) { 

					bufferLeitura = fileTXT.readLine(); 
					String[] splits = bufferLeitura.split("!");
					System.out.println("=> " + splits[0] + "," + splits[1] + "," + splits[2]);
					_pontuacaoCache.add(new PontuacaoUsuarios (splits[0], splits[1] , Integer.parseInt(splits[2] )));

					numRegsLidos++;
					System.out.println("\n Registros Lidos do Arquivo TXT = " + numRegsLidos); 
				} 
				System.out.println(" Foram lidos todos os registros do ArquivoTXT"); 
				fileTXT.close(); 
			}
			else {
				System.out.println(" Arquivo TXT VAZIO - Nada a colocar em CACHE!!!"); 
			}
		} 
		catch (EOFException ex) 
		{ 
			ex.printStackTrace(); 
			throw new Exception ("Fim de Arquivo TXT");
		} 		
		catch (IOException ex) 
		{ 
			ex.printStackTrace(); 
			throw new Exception ("Problema em I/o no Arquivo TXT");
		}
		return _pontuacaoCache; 
	}
 
	public void persisteDadosNoArquivoTXT(PontuacaoUsuarios p) throws Exception, IOException {		
		try { 
			File file = new File("pontuacao.txt"); 
			if (!file.exists()) { 
				file.createNewFile(); 
			} 
			RandomAccessFile fileTXT = new RandomAccessFile(file, "rw"); 

			String buffeGravacao = p.getUsuario() + SEPARADOR_CAMPOS + p.getTipoPonto() 
			                       + SEPARADOR_CAMPOS + String.valueOf(p.getPontos() + SEPARADOR_CAMPOS);
			System.out.println ("\n Registro a Gravar ===> " + 	buffeGravacao);	
			
			fileTXT.seek(fileTXT.length());
			fileTXT.writeBytes(buffeGravacao); 
			fileTXT.writeBytes(System.lineSeparator()); 
			fileTXT.close(); 
			System.out.println(" Pontuacao de Usuario Adicionada ao Arquivo TXTX !!"); 
		} 
		catch (IOException ioe) { 
			System.out.println(ioe); 
		} 
		catch (NumberFormatException nef) { 
			System.out.println(nef); 
		} 
    }

	public void deletarArquivoTXT() throws Exception {
		if (file.exists() ) {
			  System.out.println("\n size = " + (int) file.length() + " path= " + file.getAbsolutePath() );
			  if(file.delete()) 
			      System.out.println("File deleted successfully"); 
			  else
			      System.out.println("Failed to delete the file");
		}
	}
}

