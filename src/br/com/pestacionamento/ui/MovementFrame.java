package br.com.pestacionamento.ui;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.pestacionamento.dao.MovementDao;
import br.com.pestacionamento.model.MovementVehicle;
import br.com.pestacionamento.util.Util;

public class MovementFrame {
	private JLabel labelEntrance;
	private JLabel labelEntrancePlate;
	private JTextField textEntrancePlate;
	private JLabel labelEntranceModel;
	private JTextField textEntranceModel;
	private JButton buttonEntrance;
	
	private JLabel labelExit;
	private JLabel labelExitPlate;
	private JTextField textExitPlate;
	private JButton buttonSearch;
	private JLabel labelExitModel;
	private JTextField textExitModel;
	private JLabel labelDateEn;
	private JTextField textDateEn;
	private JLabel labelDateEx;
	private JTextField textDateEx;
	private JLabel labelHourEn;
	private	JTextField textHourEn;
	private	JLabel labelHourEx;
	private JTextField textHourEx;
	private JLabel labelPeriod;
	private JTextField textPeriod;
	private JLabel labelAmountToPay;
	private JTextField textAmountToPay;
	private JButton buttonCheckOut;
	private JButton buttonCloseSystem;
	
	private JScrollPane scrollTable;
	private JTable tableParking;
	private DefaultTableModel tableParkingModel;


	public void createScreen(){
	    
		Font fontTable = new Font("Ebrima", Font.PLAIN, 13);
		Font fontTitulos = new Font("Consolas", Font.BOLD, 24);
		Color roxo = new Color(230,0,250);
		
		JFrame screen = new JFrame();
		screen.setSize(700,620);
		screen.setTitle("Projeto estacionamento");
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setLayout(null);
	
		
		//Entrada
		
		labelEntrance = new JLabel("ENTRADA");
		//eixo x, eixo y, width, high
		labelEntrance.setBounds(30, 10, 100, 25);
		labelEntrance.setFont(fontTitulos);
		labelEntrance.setForeground(roxo);
		
		
		//Placa
		
		labelEntrancePlate = new JLabel("PLACA");
		labelEntrancePlate.setBounds(30, 40, 260, 20);
	
		textEntrancePlate = new JTextField();
		textEntrancePlate.setBounds(20, 60, 240, 30);
		
		
		
		//Modelo
		labelEntranceModel = new JLabel("MODELO");
		//eixo x, eixo y, width, high
		labelEntranceModel.setBounds(290, 40, 260, 20);
	
		textEntranceModel = new JTextField();
		textEntranceModel.setBounds(280, 60, 240, 30);
		
		
		//Botão entrar
		buttonEntrance = new JButton();
		buttonEntrance.setText("Entrar");
		buttonEntrance.setBounds(540, 60, 120, 30);

		
	
		
		
//		SAIDA		

		labelExit = new JLabel("SAÍDA");
		labelExit.setBounds(30, 300, 100, 30);
		labelExit.setFont(fontTitulos);
		labelExit.setForeground(roxo);
		
		
		//placa Saida
		labelExitPlate = new JLabel("PLACA:");
		labelExitPlate.setBounds(30, 330, 50, 30);
		
		textExitPlate = new JTextField();
		textExitPlate.setBounds(20, 360, 120, 30);
		
		
		//BUTTON bUSCAR
		buttonSearch = new JButton();
		buttonSearch.setText("BUSCAR");
		buttonSearch.setBounds(150, 360, 120, 30);
		
		
		//Modelo saida
		labelExitModel = new JLabel("MODELO:");
		labelExitModel.setBounds(30, 400, 260, 30);
		
		textExitModel = new JTextField();
		textExitModel.setBounds(20, 430, 120, 30);
		
		
		//Data entrada
		labelDateEn = new JLabel("DATA ENTRADA:");
		labelDateEn.setBounds(160, 400, 260, 30);
				
		textDateEn = new JTextField();
		textDateEn.setBounds(150, 430, 120, 30);
		
		
		//HOra entrada
		labelHourEn = new JLabel("HORA E.:");
		labelHourEn.setBounds(290, 400, 260, 30);
		
		textHourEn = new JTextField();
		textHourEn.setBounds(280, 430, 70, 30);
		
		
		//Data Saida
		labelDateEx = new JLabel("DATA SAÍDA:");
		labelDateEx.setBounds(370, 400, 260, 30);
		
		textDateEx = new JTextField();
		textDateEx.setBounds(360, 430, 120, 30);
		
		
		//Hora saida
		labelHourEx = new JLabel("HORA S.:");
		labelHourEx.setBounds(500, 400, 260, 30);
		
		textHourEx = new JTextField();
		textHourEx.setBounds(490, 430, 70, 30);
		

		//TEMPO
		labelPeriod = new JLabel("TEMPO:");
		labelPeriod.setBounds(580, 400, 260, 30);
		
		textPeriod = new JTextField();
		textPeriod.setBounds(570, 430, 90, 30);
		
		
		//valor a pagar
		labelAmountToPay = new JLabel("VALOR A PAGAR:");
		labelAmountToPay.setBounds(30, 510, 100, 30);
		
		textAmountToPay = new JTextField();
		textAmountToPay.setBounds(150, 500, 150, 50);
		
		
		//button Efetuar saida
		buttonCheckOut = new JButton();
		buttonCheckOut.setText("EFETUAR SAÍDA");
		buttonCheckOut.setBounds(330, 500, 150, 50);
		
	
		//button fechar sistema
		buttonCloseSystem = new JButton();
		buttonCloseSystem.setText("FECHAR SISTEMA");
		buttonCloseSystem.setBounds(510, 500, 150, 50);
		
		createTable();
	
		screen.getContentPane().add(labelEntrance);
		screen.getContentPane().add(textEntrancePlate);
		screen.getContentPane().add(labelEntrancePlate);
		screen.getContentPane().add(textEntranceModel);
		screen.getContentPane().add(labelEntranceModel);
		screen.getContentPane().add(buttonEntrance);
		screen.getContentPane().add(labelExit);
		screen.getContentPane().add(labelExitPlate);
		screen.getContentPane().add(textExitPlate);
		screen.getContentPane().add(buttonSearch);
		screen.getContentPane().add(textExitModel);
		screen.getContentPane().add(labelExitModel);
		screen.getContentPane().add(labelDateEn);
		screen.getContentPane().add(textDateEn);
		screen.getContentPane().add(labelHourEn);
		screen.getContentPane().add(textHourEn);
		screen.getContentPane().add(labelDateEx);
		screen.getContentPane().add(textDateEx);
		screen.getContentPane().add(labelHourEx);
		screen.getContentPane().add(textHourEx);
		screen.getContentPane().add(labelPeriod);
		screen.getContentPane().add(textPeriod);
		screen.getContentPane().add(labelAmountToPay);
		screen.getContentPane().add(textAmountToPay);
		screen.getContentPane().add(buttonCheckOut);
		screen.getContentPane().add(buttonCloseSystem);
		screen.getContentPane().add(scrollTable);
		
		
		screen.setVisible(true);

		buttonEntrance.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						
				
				 //Obtém LocalDate de hoje
				
				if (validateEntrance()) {
					MovementVehicle movementEntrance = new MovementVehicle();
					movementEntrance.setCarCode(Util.generateCode());
					movementEntrance.setCarPlate(textEntrancePlate.getText().toUpperCase());
					movementEntrance.setCarModel(textEntranceModel.getText().toUpperCase());
					movementEntrance.setCarEntranceDate(Util.convertDate(LocalDate.now()));
					movementEntrance.setCarEntranceHour(Util.convertTime(LocalTime.now()));
					
					MovementDao dao = new MovementDao(movementEntrance);
					dao.saveExitMovement();
					
					JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso");
	
					cleanAllForm(); 
					
					createTable();
					
					
				}
				
				else {
					JOptionPane.showMessageDialog
						(null, 
						"Você deve preencher todos so campos", 
						"Atenção", 
						JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		
//		BOTÃO BUSCAR
		
		buttonSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						
				
				 //Obtém LocalDate de hoje
				
				String searchVehicle = textExitPlate.getText();
			
				MovementDao dao = new MovementDao();
				MovementVehicle vehicle = dao.searchMovement(searchVehicle);
			
				textExitModel.setText(vehicle.getCarModel());
				textDateEn.setText(String.valueOf(vehicle.getCarEntranceDate()));
				textDateEx.setText(String.valueOf(vehicle.getCarExitDate()));
				textHourEn.setText(String.valueOf(vehicle.getCarEntranceHour()));
				textHourEx.setText(String.valueOf(vehicle.getCarExitHour()));
				textPeriod.setText(String.valueOf(vehicle.getCarPeriod()));
				textAmountToPay.setText(String.valueOf(vehicle.getAmountToPay()));
	
			}
		});
		
//		BOTÃO EFETUAR SAIDA
		
		
		buttonCheckOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						
				
				 //Obtém LocalDate de hoje
				
				if (validateExit()) {
					MovementVehicle movementEntrance = new MovementVehicle();
					
					movementEntrance.setCarPlate(textExitPlate.getText().toUpperCase());
					movementEntrance.setCarModel(textExitModel.getText().toUpperCase());
			
					movementEntrance.setCarEntranceDate(textDateEn.getText());
					movementEntrance.setCarEntranceHour(textHourEn.getText());
					movementEntrance.setCarExitDate(textHourEx.getText());
					movementEntrance.setCarExitHour(textDateEn.getText());
					movementEntrance.setCarPeriod(textPeriod.getText());
					movementEntrance.setAmountToPay(Double.parseDouble(textAmountToPay.getText()));
					
					MovementDao dao = new MovementDao(movementEntrance);
					dao.saveExitMovement();
					
					JOptionPane.showMessageDialog(null, "Saida Efetuada com sucesso");
	
					cleanAllForm(); 
					
					createTable();
					
					
				}
				
				else {
					JOptionPane.showMessageDialog
						(null, 
						"Você deve preencher todos so campos", 
						"Atenção", 
						JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		
		// BOTÃO FECHAR SISTEMA
		
		
		buttonCloseSystem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				screen.setVisible(false); // fecha a tela

			}
		});
		
	tableParking.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			//quando clicamos na linha ele chama e mostra
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				String code;
				int line = tableParking.getSelectedRow();
				code = tableParking.getModel().getValueAt(line,0).toString();
			
				MovementDao dao = new MovementDao();
				MovementVehicle vehicle = dao.searchVehicleTable(code);
				
				textExitPlate.setText(vehicle.getCarPlate());
				textExitModel.setText(vehicle.getCarModel());
				textDateEn.setText(String.valueOf(vehicle.getCarEntranceDate()));
				textDateEx.setText(Util.convertDate(LocalDate.now()));
				textHourEn.setText(String.valueOf(vehicle.getCarEntranceHour()));
				textHourEx.setText(Util.convertTime(LocalTime.now()));
//				textPeriod.setText(String.valueOf(vehicle.getCarPeriod()));
//				textAmountToPay.setText(String.valueOf(vehicle.getAmountToPay()));
			}
		});
	}
		
	
//	LIMPAR O FORMULARIO
	
	private void cleanAllForm() {
		textEntrancePlate.setText("");
		textExitPlate.setText("");		
		textHourEn.setText("");			//
		textDateEn.setText("");     
		textDateEx.setText("");  // Faz limpar a tela quando precionar "ok" da caixa de textos		//
		textHourEn.setText("");  
		textPeriod.setText("");
		textEntranceModel.setText("");
		textExitModel.setText("");  
		textAmountToPay.setText(""); 
		textEntrancePlate.requestFocus();		// Coloca o cursor ja no nome do cliente
	}
	
//	VALIDAR FOMULARIO 
	
	private boolean validateEntrance() {
		
		boolean valido = true;
				
		
		if(textEntrancePlate.getText().length() == 0) {
			labelEntrancePlate.setForeground(Color.red);
			valido = false;
			
		}
		
		else if (textEntranceModel.getText().length() == 0) {
			labelEntranceModel.setForeground(Color.red);
			valido = false;
		}
		
		return valido;
	}
	
private boolean validateExit() {
		
		boolean valido = true;
				
		
		if(textExitPlate.getText().length() == 0) {
			labelEntrancePlate.setForeground(Color.red);
			valido = false;
			
		}
		
		else if (textExitModel.getText().length() == 0) {
			labelEntranceModel.setForeground(Color.red);
			valido = false;
		}
		
		else if (textDateEn.getText().length() == 0) {
			labelDateEn.setForeground(Color.red);
			valido = false;
		}
		
		else if (textDateEx.getText().length() == 0) {
			labelDateEx.setForeground(Color.red);
			valido = false;
		}
		
		else if (textHourEn.getText().length() == 0) {
			labelHourEn.setForeground(Color.red);
			valido = false;
		}
		
		else if (textHourEx.getText().length() == 0) {
			labelHourEx.setForeground(Color.red);
			valido = false;
		}
		
		else if (textPeriod.getText().length() == 0) {
			labelPeriod.setForeground(Color.red);
			valido = false;
		}
		
		else if (textAmountToPay.getText().length() == 0) {
			labelAmountToPay.setForeground(Color.red);
			valido = false;
		}
		
		return valido;
	}
	
	
//	CRIAR TABELA
	
	
	private void createTable() {
		//passo 1 - Criar o modelo para nossa tabela
		tableParkingModel = new DefaultTableModel();
		
		// Colunas
		tableParkingModel.addColumn("CÓDIGO");
		tableParkingModel.addColumn("PLACA");
		tableParkingModel.addColumn("MODELO");
		tableParkingModel.addColumn("DATA ENTRADA");
		
		MovementDao vehicleDao = new MovementDao();
		ArrayList<MovementVehicle> vehicles = vehicleDao.listVehicle();
		
		
		
		//aqui criamos uma lista, ou seja, a cada volta criar um cliente
		for (MovementVehicle vehicle : vehicles) {
			// Linhas
			 String[] vehicleVetor = {vehicle.getCarCode(), vehicle.getCarPlate(), vehicle.getCarModel(), vehicle.getCarEntranceDate()};
			 tableParkingModel.addRow(vehicleVetor);
		}
		
		
		 
		// PASSO 2 - Criar tabela
		tableParking = new JTable(tableParkingModel);
		
		
		// Determinar a largura das colunas
		tableParking.getColumnModel().getColumn(0).setPreferredWidth(110);
		tableParking.getColumnModel().getColumn(1).setPreferredWidth(110);
		tableParking.getColumnModel().getColumn(2).setPreferredWidth(110);
		tableParking.getColumnModel().getColumn(3).setPreferredWidth(110);	
		
			//não premite dar o tamanho ou redimentcionar, bem como mudar de ordem
		tableParking.getColumnModel().getColumn(0).setResizable(false);
		tableParking.getTableHeader().setReorderingAllowed(false);
			
			
		// cor na tabela
			//PASSO 3 - COlocar a tabela no painel de rolamento
			scrollTable = new JScrollPane(tableParking);
			scrollTable.setBounds(20,100,640,190);		
	}
	
	
	
//	private static void escreverArquivo(MovementVehicle vehicle){
//		Path path = Paths.get("C:/Users/isabe/projetoEstaciona.txt");
//		try 
//		{
//			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.WRITE, StandardOpenOption.APPEND);
//			writer.write(vehicle.getCarCode() 
//					+ ";" + vehicle.getCarPlate() 
//					+ ";" + vehicle.getCarModel() 
//					+ ";" + vehicle.getCarEntranceHour() 
//					+ ";" + vehicle.getCarEntranceDate()
//					+ ";" + vehicle.getCarExitHour() 
//					+ ";" + vehicle.getCarExitDate() 
//					+ ";" + vehicle.getCarPeriod()
//					+ ";" + vehicle.getAmountToPay());
//			
//			writer.newLine();
//			writer.close();
//		} 
//		catch (Exception e) 
//		{
//			System.out.println("Não foi possivel gravar os dados");
//		}
//		
//	}


}
