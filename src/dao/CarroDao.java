package dao;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import br.com.pestacionamento.model.Carro;

public class CarroDao {

private Carro carro;
	
	//lembrar de inverter a barra
	private static final String LOCAL_ARQUIVO = "C:/teste/projetoEstaciona.txt";

	public Carro getCarro() {
		return carro;
	}

	//construtor que pede o carro
	public CarroDao(Carro carro) {
		this.carro = carro;
	}
	
	public CarroDao() {
		
	}
	
	public void salvar(){
		
		Path path = Paths.get(LOCAL_ARQUIVO);
		try 
		{
			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"), 
					StandardOpenOption.WRITE, StandardOpenOption.APPEND); // Coloca o cursor na proxima linha
			
			writer.write(carro.toString());
			writer.newLine();
			writer.close();
		} 
		catch (Exception e) 
		{
			System.out.println("Não foi possivel gravar os dados");
		}
		
	}
	
	public ArrayList<Carro> listarCarro() {
		
		//procedimento para abrir um arquivo para leitura ou escrita
		// Passo 1 - Obter o camino do aquivo
		
		Path path = Paths.get(LOCAL_ARQUIVO);
		
		// Criar o buffer para o arquivo
		try 
		{ // utilizado quando não temos certeza de que dará certo a aplicação
			
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));//ou utilizamos ISO-8859-1
			
			String linha = reader.readLine();
			ArrayList<Carro> carros = new ArrayList<>();
			
			while (linha != null) {
				String[] vetorCarro = linha.split(";");
				
				Carro carro = new Carro();
				carro.setCodigo(vetorCarro[0]);
				carro.setPlaca(vetorCarro[1]);
				carro.setModelo(vetorCarro[2]);
				carro.setDataEntrada(vetorCarro[3]);
				
				System.out.println(carro.getDataTeste());
				
				carros.add(carro);
				linha = reader.readLine();
				
				
			}
			
			reader.close();
			return carros;
		
		} 
		
		catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo");
			e.printStackTrace(); //imprime o erro // trace = caminho
			return null;
			
		}
	}
	
	
	public Carro buscarCarro(String codigo) {
		
		//procedimento para abrir um arquivo para leitura ou escrita
		// Passo 1 - Obter o camino do aquivo
		
		Path path = Paths.get(LOCAL_ARQUIVO);
		
		// Criar o buffer para o arquivo
		try 
		{ // utilizado quando não temos certeza de que dará certo a aplicação
			
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));//ou utilizamos ISO-8859-1
			
			String linha = reader.readLine();
			Carro carro = new Carro();
			
			while (linha != null) {
				String[] vetorCarro = linha.split(";");
				
				if (vetorCarro[0].equals(codigo)) {
				
				carro.setCodigo(vetorCarro[0]);
				carro.setPlaca(vetorCarro[1]);
				carro.setModelo(vetorCarro[2]);
				carro.setDataEntrada(vetorCarro[3]);
				carro.setHoraEntrada(vetorCarro[4]);
				
				break;
				
				
				}
				linha = reader.readLine();
		 }
			
			reader.close();
			return carro;
		
		} 
		
		catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo");
			e.printStackTrace(); //imprime o erro // trace = caminho
			return null;
			
		}
	}
}

