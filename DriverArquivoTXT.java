
package courseraita;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class DriverArquivoTXT {
	
	// Layout do registro de Pontuacao do usuario no Arquivo TXT:  (A)(B)(C)9D)(E)(F)

	final int SIZE_FIELD_TOTAL_EM_BYTES = 4;     // A = 4 bytes para variavel int
	final int SIZE_FIELD_USERNAME       = 4;     // B 
    final int SIZE_FIELD_TIPOPONTO_NOME = 4;     // C = contem o numero de pontos em int
	final int SIZE_FIELD_NUMERO_PONTOS  = 4;     // D = 4 bytes para variavel int
	final int SIZE_HEADER_REG_PONTUACAO = 
			SIZE_FIELD_TOTAL_EM_BYTES + SIZE_FIELD_USERNAME + 
			SIZE_FIELD_TIPOPONTO_NOME + SIZE_FIELD_NUMERO_PONTOS;    
    
	// FIELD NOME DO USUARIO VARIAVEL               E = TAMANHO VARIAVEL - o numero de bytes do nome  
    // FIELD NOME DO TIPO DO PONTO                  F = TAMANHO VARIAVEL - o numero de bytes do nome 

	
	File file = new File( "pontuacaoGamificacao.txt" );
	
	private static final int  ESVAZIAR_ARQUIVO = 1;
	
	private Armazenamento _a;

	public DriverArquivoTXT (int acao, Armazenamento a) throws IOException, Exception {
		
		this._a = a;
		try {
			if (!file.exists()) 	 
				file.createNewFile();
			else {
				if (acao == ESVAZIAR_ARQUIVO) {
					if(file.delete()) 
						System.out.println("File deleted successfully"); 
					else
						System.out.println("Failed to delete the file");
				} else { LerArquivoTextoEInicializarCacheMemoria(); }
			}
		}
		catch (IOException ioe) { 
			throw new Exception ("Problema na Leitura do Arquivo TEXTO");
		}
	}

	public void LerArquivoTextoEInicializarCacheMemoria() throws Exception {
		try {

			RandomAccessFile arquivoTXT = new RandomAccessFile("pontuacaoGamificacao.txt", "rw"); 
			if (arquivoTXT.length() != 0) {

				int posicaoALer = 0;
				arquivoTXT.seek(posicaoALer); 				
				int size_registro   = arquivoTXT.readInt();
				
				int posicaoProximoRegistro = posicaoALer + size_registro;					
				boolean bytesALer = true;
				
				while ( bytesALer ) {
					
					if ( arquivoTXT.length() >= arquivoTXT.length() ) {

						PontuacaoUsuarios p = ExtrairEGravarRegistroPontuacao ( arquivoTXT, posicaoALer,  size_registro);
						_a.armazenarPontuacaoDeUmUsuario( p );

					}	
					else  bytesALer = false;
						
				}
				arquivoTXT.close();
			}
		} 
		catch (IOException ex) 
		{ 
			System.out.println("Problema em I/o no Arquivo TXT"); 
			ex.printStackTrace(); 
			throw new Exception ("Problema em I/o no Arquivo TXT");
		} 
	}

	private PontuacaoUsuarios ExtrairEGravarRegistroPontuacao (RandomAccessFile fileTXT, 
	  		                                      int posicaoNoFile, int size_reg) throws IOException {
		
		int posicaoALer = posicaoNoFile;
		posicaoALer += SIZE_FIELD_TOTAL_EM_BYTES;
		fileTXT.seek(posicaoALer); 
		int sizeNomeUsuario = fileTXT.readInt();

		posicaoALer += SIZE_FIELD_USERNAME;
		fileTXT.seek(posicaoALer); 
		int sizeNomeTipoPonto   = fileTXT.readInt();

		posicaoALer += SIZE_FIELD_TIPOPONTO_NOME;
		fileTXT.seek(posicaoALer); 
		int numeroPontos  = fileTXT.readInt();

		posicaoALer += SIZE_FIELD_NUMERO_PONTOS;
		fileTXT.seek(posicaoALer); 
		byte[] nomeUsuario = new byte[(int) sizeNomeUsuario]; 
		
		for ( int i=0; i < sizeNomeUsuario; i++ ) {
			fileTXT.seek(posicaoALer + i); 
			nomeUsuario[i] = fileTXT.readByte();
		}

		posicaoALer += SIZE_FIELD_USERNAME;
		fileTXT.seek(posicaoALer); 
		byte[] tipoPonto = new byte[(int) sizeNomeTipoPonto]; 
		
		for ( int i=0; i < sizeNomeTipoPonto; i++ ) {
			fileTXT.seek(posicaoALer + i); 
			tipoPonto[i] = fileTXT.readByte();
		}
		return( new PontuacaoUsuarios (new String(nomeUsuario), new String(tipoPonto), numeroPontos) );
	}

	public void extendeArquivotextoPontuacao(PontuacaoUsuarios p) throws Exception, IOException {
		try {
			RandomAccessFile arquivoTXT = new RandomAccessFile("pontuacaoGamificacao.txt", "rw"); 
			
			int sizeNomeUsuario   = p.getUsuario().length(); 
			int sizeNomeTipoPonto = p.getTipoPonto().length();
			int size_registro     = SIZE_HEADER_REG_PONTUACAO + sizeNomeUsuario + sizeNomeTipoPonto;

			long deslocamentoFimDoArquivo = arquivoTXT.length();
			arquivoTXT.seek(deslocamentoFimDoArquivo); 
			
			arquivoTXT.write (size_registro);
			arquivoTXT.write (sizeNomeUsuario);
			arquivoTXT.write (sizeNomeTipoPonto);
			arquivoTXT.write (p.getPontos());
			arquivoTXT.writeUTF(p.getUsuario());
			arquivoTXT.writeUTF(p.getTipoPonto()); 
			
			arquivoTXT.close();
		} 
		catch (IOException ex) 
		{ 
			System.out.println("Problema em I/o no Arquivo TXT"); 
			ex.printStackTrace(); 
			throw new Exception ("Problema em I/o no Arquivo TXT");
		} 		
    }

	public void deletarArquivoTextoDePontuacao() throws Exception {
		if (!file.exists()) {
			  if(file.delete()) 
			      System.out.println("File deleted successfully"); 
			  else
			      System.out.println("Failed to delete the file");
		}
	}
	
	
}
