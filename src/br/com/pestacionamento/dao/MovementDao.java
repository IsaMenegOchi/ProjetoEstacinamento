package br.com.pestacionamento.dao;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;

import br.com.pestacionamento.model.MovementVehicle;
import br.com.pestacionamento.util.Util;


public class MovementDao {
	
	private MovementVehicle movement;
	private static final String MOVE_FILE_LOCATION = "C:/Users/isabe/projectParking.txt";
	
	
	public MovementDao()//construtor vazio
	{
	}
	
	public MovementDao(MovementVehicle movement) //construtor com movimentacao
	{
		this.movement = movement;
	}
	
	public MovementVehicle getMovimentacao()
	{
		return movement;
	}
	
	public ArrayList<MovementVehicle> listVehicle() {
		
		Path path = Paths.get(MOVE_FILE_LOCATION);
		
		try { 
			
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));//ou utilizamos ISO-8859-1
			
			String line = reader.readLine();
			ArrayList<MovementVehicle> vehicles = new ArrayList<>();
			
			while (line != null) {
				
				String[] vetorCarro = line.split(";");
				
				movement = new MovementVehicle();
				movement.setCarCode(vetorCarro[0]);
				movement.setCarPlate(vetorCarro[1]);
				movement.setCarModel(vetorCarro[2]);
				
//				pegamos a variavel que criamos la em cima e convertemos em string
//				Neste caso utilizamos o parse, já que ele converte em string
				
				movement.setCarEntranceDate(vetorCarro[3]);
//				movement.setCarEntranceHour(vetorCarro[4]);
//				movement.setCarExitDate(vetorCarro[5]);
//				movement.setCarExitHour(vetorCarro[6]);
				
				vehicles.add(movement);
				line = reader.readLine();
			}
			
			reader.close();
			return vehicles;
		} 
		
	
		catch (Exception e) {
			
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo");
			e.printStackTrace(); //imprime o erro // trace = caminho
			return null;
		}
	}
	
	
//	SALVAR MOVIMENTAÇÃO ENTRADA

	public void saveEntranceMovement()
	{
			Path path = Paths.get(MOVE_FILE_LOCATION);
		try 
			{
				BufferedWriter writer = Files.newBufferedWriter
				  (path, Charset.forName("UTF-8"), StandardOpenOption.WRITE, 
				  StandardOpenOption.APPEND);
						
				writer.write(movement.toStringEntrance()); 
				writer.newLine();
				writer.close();		
			} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
	}
	
	
//	SALVAR MOVIMENTAÇÃO SAIDA
	
	
	public void saveExitMovement()
	{
		
			Path path = Paths.get(MOVE_FILE_LOCATION);//a classe Path acessa os arquivos e a Paths ajuda a encontra-los, ela lê o caminho
						
		try 
			{
				BufferedWriter writer = Files.newBufferedWriter
				  (path, Charset.forName("UTF-8"), StandardOpenOption.WRITE, //deixa o arquivo aberto para escrita
				  StandardOpenOption.APPEND); //acresenta coisas no arquivo,não substitui os conteúdos
						
				writer.write(movement.toString()); //to string do cliente foi configurado em cliente
				writer.newLine(); //cria uma nova linha no arquivo
				writer.close();
						
			} 
					
					catch (Exception e) 
					{
						e.printStackTrace();
						System.out.println("Não foi possivel gravar os dados");
					}
	}

	
//	PROCURAR VEICULO NA TABELA
	
	public MovementVehicle searchVehicleTable (String codigo) {
		
		Path path = Paths.get(MOVE_FILE_LOCATION);
		
		
		try {
			
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));//ou utilizamos ISO-8859-1
			
			String line = reader.readLine();
			MovementVehicle vehicle = new MovementVehicle();
			
			while (line != null) {
				String[] vehicleVetor = line.split(";");
				
				if (vehicleVetor[0].equals(codigo)) {
				
				vehicle.setCarCode(vehicleVetor[0]);
				vehicle.setCarPlate(vehicleVetor[1]);
				vehicle.setCarModel(vehicleVetor[2]);
				vehicle.setCarEntranceDate(vehicleVetor[3]);
				vehicle.setCarEntranceHour(vehicleVetor[4]);
				
				break;
				
				
				}
				line = reader.readLine();
		 }
			
			reader.close();
			return vehicle;
		
		} 
		
		catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo");
			e.printStackTrace(); //imprime o erro // trace = caminho
			return null;
			
		}
	}
	
//	PROCURAR VEICULO NO BUSCAR
	
	public MovementVehicle searchMovement(String searchPlate)
	{
	
			Path path = Paths.get(MOVE_FILE_LOCATION);	
				
			try 
			{
				BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8")); 
					
				String line = reader.readLine();
					
				while (line != null)
				 {
					String[] movementVetor = line.split(";");
						
						
					if (movementVetor[1].equals(searchPlate.toUpperCase())) 
					{
//						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//						
						String totalTime = "Não foi possivel fazer a conta";
						double amountToPay = 0.0;
								
						movement = new MovementVehicle();
						movement.setCarCode(movementVetor[0]); 
						movement.setCarPlate(movementVetor[1]);
						movement.setCarModel(movementVetor[2]);
						movement.setCarEntranceDate(movementVetor[3]);
						movement.setCarEntranceHour(movementVetor[4]);
						movement.setCarExitDate(Util.convertDate(LocalDate.now()));
						movement.setCarExitHour(Util.convertTime(LocalTime.now()));
						movement.setCarPeriod(totalTime);
						movement.setAmountToPay(amountToPay);
						
						break; //sai do looping pq já achou o cliente certo
					}
						
						
					line = reader.readLine(); // lê mais uma e o cursor vai para a próxima....
				 }
			
				reader.close();			
				return movement;
			} 
			
			catch (Exception e) 
			{
				System.out.println("Ocorreu um erro na tentativa de ler o arquivo!");
				e.printStackTrace(); //pega a mensagem do erro p/ o programador || "e" é a variável do erro.
				return null;
			}
	}
}	
