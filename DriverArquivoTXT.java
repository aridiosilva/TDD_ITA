
package courseraita;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
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

	
	private static File file = new File( "pontuacaoGamificacao.txt" );
	private static final int  ESVAZIAR_ARQUIVO = 1;
	
	private static LinkedList<PontuacaoUsuarios> _pontuacaoUsuarios = new LinkedList<PontuacaoUsuarios>();
	private static HashSet<String>         _diferentesTiposDePontos = new HashSet<String>();

	public void LerArquivoTextoEInicializarCacheMemoria() throws Exception {
		try {

			RandomAccessFile arquivoTXT = new RandomAccessFile("pontuacaoGamificacao.txt", "rw"); 
			if ((int)arquivoTXT.length() != 0) {

				int posicaoInicialReg      = 0;
				int posicaoLeitura         = 0;
				int posicaoProximoRegistro = 0;

				while(true){
					try{
						
						arquivoTXT.seek((long)posicaoLeitura); 				
						int size_registro   = arquivoTXT.readInt();

						System.out.println (" \n Size do Registo lido do Arquivo TXT==> " + size_registro);

						PontuacaoUsuarios p = ExtrairEGravarRegistroPontuacao (posicaoInicialReg,  size_registro);

						System.out.println (" \n DriverTXT reg lido TXT==> " + 
								p.getUsuario()  + ", " +
								p.getTipoPonto() +  ", " 
								+ p.getPontos());

						armazenarPontuacaoDeUmUsuario( p );

						posicaoInicialReg += size_registro;	
						posicaoLeitura    = posicaoInicialReg;

					} catch(EOFException e)
					{
						System.out.println("Fim do Arquivo TXT atingido!!!"); 
					    break;
					}
				    finally
				    {
				    	arquivoTXT.close();
				    }
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

	private void armazenarPontuacaoDeUmUsuario( PontuacaoUsuarios p) throws IOException, Exception {
		
		_pontuacaoUsuarios.add (p);
		
		System.out.println ("\n PONTUAÇAÕ SENDO INCLUIDA A PARTIR DO ARQUIVO TXT: ");
		for (int i=0; i < _pontuacaoUsuarios.size(); i++) {			
			  System.out.print("\n(" + i + ") " +
					  _pontuacaoUsuarios.get(i).getUsuario() + ", " + 
					  _pontuacaoUsuarios.get(i).getTipoPonto() + ", " + 
					  _pontuacaoUsuarios.get(i).getPontos());
		}
		
		if ( p.getPontos() != 0 && !_diferentesTiposDePontos.contains(p._tipoPonto))	
		
			_diferentesTiposDePontos.add (p._tipoPonto);
		
		extendeArquivotextoPontuacao(p);
		
	}
	
	private PontuacaoUsuarios ExtrairEGravarRegistroPontuacao (int posicaoInicialReg, int sizeRegAtual) throws Exception {
		
		try {
			RandomAccessFile fileTXT = new RandomAccessFile("pontuacaoGamificacao.txt", "rw"); 

			fileTXT.seek((long) posicaoInicialReg + SIZE_FIELD_TOTAL_EM_BYTES); 
			int sizeNomeUsuario = fileTXT.readInt();
			System.out.println (" \n DriverTXT size do Nome do Usuario ==> " + sizeNomeUsuario);

			fileTXT.seek((long) posicaoInicialReg + SIZE_FIELD_TOTAL_EM_BYTES + SIZE_FIELD_USERNAME); 
			int sizeNomeTipoPonto   = fileTXT.readInt();
			System.out.println (" TipoUsuario ==> " + sizeNomeTipoPonto);

			fileTXT.seek((long) posicaoInicialReg + SIZE_FIELD_TOTAL_EM_BYTES + SIZE_FIELD_USERNAME + SIZE_FIELD_TIPOPONTO_NOME); 
			int numeroPontos  = fileTXT.readInt();
			System.out.println (" NumPontos ==> " + sizeNomeTipoPonto);

			long offset = (long) (posicaoInicialReg + SIZE_FIELD_TOTAL_EM_BYTES + SIZE_FIELD_USERNAME + 
					SIZE_FIELD_TIPOPONTO_NOME +  SIZE_FIELD_NUMERO_PONTOS);
			byte[] nomeUsuario = new byte[(int) sizeNomeUsuario]; 
			for ( int i=0; i < sizeNomeUsuario; i++ ) {
				fileTXT.seek((long) i + offset); 

				nomeUsuario[i] = fileTXT.readByte();
			}
			System.out.println (" User ==> " + new String(nomeUsuario));
			offset += (long) SIZE_FIELD_NUMERO_PONTOS+SIZE_FIELD_USERNAME;
			byte[] tipoPonto = new byte[(int) sizeNomeTipoPonto];
			for ( int i=0; i < sizeNomeTipoPonto; i++ ) {

				fileTXT.seek((long) i + offset); 
				tipoPonto[i] = fileTXT.readByte();
			}
			System.out.println (" Tipo Ponto ==> " + new String(tipoPonto));

			System.out.println (" \n DriverTXT reg lido TXT==> " + 
					new String(nomeUsuario) + ", " +   
					new String(tipoPonto) +  ", " +
					numeroPontos);

			return( new PontuacaoUsuarios (new String(nomeUsuario), new String(tipoPonto), numeroPontos) );
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
	}

	public void extendeArquivotextoPontuacao(PontuacaoUsuarios p) throws Exception, IOException {
		try {
			RandomAccessFile arquivoTXT = new RandomAccessFile("pontuacaoGamificacao.txt", "rw"); 
			
			int sizeNomeUsuario   = p.getUsuario().length(); 
			int sizeNomeTipoPonto = p.getTipoPonto().length();
			int size_registro     = SIZE_HEADER_REG_PONTUACAO + sizeNomeUsuario + sizeNomeTipoPonto;

			System.out.println ("\n Size NomeUsuario  ======> " + p.getUsuario() + " = "   +  sizeNomeUsuario);
			System.out.println ("\n Size Descr.Tipo Ponto ==> " + p.getTipoPonto() + " = " +  sizeNomeTipoPonto);
			System.out.println ("\n Size Registro Pontuacao=> = "   +  size_registro);
			
			long deslocamentoFimDoArquivo = arquivoTXT.length();
			arquivoTXT.seek(deslocamentoFimDoArquivo); 
			
			arquivoTXT.write ((int)size_registro);
			arquivoTXT.write ((int)sizeNomeUsuario);
			arquivoTXT.write ((int)sizeNomeTipoPonto);
			arquivoTXT.write ((int)p.getPontos());
			arquivoTXT.writeUTF(p.getUsuario());
			arquivoTXT.writeUTF(p.getTipoPonto()); 
			
			arquivoTXT.close();
		} 
		catch (IOException ex) 
		{ 
			ex.printStackTrace(); 
			throw new Exception ("Problema em I/o no Arquivo TXT");
		} 		
    }

	public void deletarArquivoTextoDePontuacao() throws Exception {
		if (file.exists() ) {
			
			  System.out.println("\n size = " + (int) file.length() + " path= " + file.getAbsolutePath() );
			  
			  if(file.delete()) 
			      System.out.println("File deleted successfully"); 
			  else
			      System.out.println("Failed to delete the file");
		}
	}
	
	
}
