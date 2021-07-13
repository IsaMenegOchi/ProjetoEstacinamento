package br.com.pestacionamento.model;

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
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.CarroDao;
import util.Util;

public class FrameEstaciona {
	
	private JLabel labelEntrada;
	private JLabel labelPlacaEntrada;
	private JTextField textPlacaEntrada;
	private JLabel labelModeloEntrada;
	private JTextField textModeloEntrada;
	private JButton buttonEntrar;
	private JLabel labelSaida;
	private JLabel labelPlacaSaida;
	private JTextField textPlacaSaida;
	private JButton buttonBuscar;
	private JLabel labelModeloSaida;
	private JTextField textModeloSaida;
	private JLabel labelDataE;
	private JTextField textDataE;
	private JLabel labelDataS;
	private JTextField textDataS;
	private JLabel labelHoraE;
	private	JTextField textHoraE;
	private	JLabel labelHoraS;
	private JTextField textHoraS;
	private JLabel labelTempo;
	private JTextField textTempo;
	private JLabel labelValorAPagar;
	private JTextField textValorAPagar;
	private JButton buttonEfetuarSaida;
	private JButton buttonFecharSistema;
	
	private JScrollPane scrollTable;
	private JTable tabelaEstacionamento;
	private DefaultTableModel tabelaEstacionamentoModel;
	
	

	public void criarTela(){
		
		Font fontTitulos = new Font("Consolas", Font.BOLD, 24);
		Color roxo = new Color(230,0,250);
		
		JFrame tela = new JFrame();
		tela.setSize(700,620);
		tela.setTitle("Projeto estacionamento");
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
	
		//Entrada
		
		labelEntrada = new JLabel("ENTRADA");
		//eixo x, eixo y, width, high
		labelEntrada.setBounds(30, 10, 100, 25);
		labelEntrada.setFont(fontTitulos);
		labelEntrada.setForeground(roxo);
		
		//Placa
		
		labelPlacaEntrada = new JLabel("PLACA");
		labelPlacaEntrada.setBounds(30, 40, 260, 20);
	
		textPlacaEntrada = new JTextField();
		textPlacaEntrada.setBounds(20, 60, 240, 30);
		
		
		//Modelo
		labelModeloEntrada = new JLabel("MODELO");
		//eixo x, eixo y, width, high
		labelModeloEntrada.setBounds(290, 40, 260, 20);
	
		textModeloEntrada = new JTextField();
		textModeloEntrada.setBounds(280, 60, 240, 30);
		
		//Botão entrar
		buttonEntrar = new JButton();
		buttonEntrar.setText("Entrar");
		buttonEntrar.setBounds(540, 60, 120, 30);

//		SAIDA		

		
		labelSaida = new JLabel("SAÍDA");
		labelSaida.setBounds(30, 300, 100, 30);
		labelSaida.setFont(fontTitulos);
		labelSaida.setForeground(roxo);
		
		//placa Saida
		labelPlacaSaida = new JLabel("PLACA:");
		labelPlacaSaida.setBounds(30, 330, 50, 30);
		
		textPlacaSaida = new JTextField();
		textPlacaSaida.setBounds(20, 360, 120, 30);
		
		//BUTTON bUSCAR
		buttonBuscar = new JButton();
		buttonBuscar.setText("BUSCAR");
		buttonBuscar.setBounds(150, 360, 120, 30);
		
		//Modelo saida
		labelModeloSaida = new JLabel("MODELO:");
		labelModeloSaida.setBounds(30, 400, 260, 30);
		
		textModeloSaida = new JTextField();
		textModeloSaida.setBounds(20, 430, 120, 30);
		
		//Data entrada
		labelDataE = new JLabel("DATA ENTRADA:");
		labelDataE.setBounds(160, 400, 260, 30);
				
		textDataE = new JTextField();
		textDataE.setBounds(150, 430, 120, 30);
		
		//HOra entrada
		labelHoraE = new JLabel("HORA E.:");
		labelHoraE.setBounds(290, 400, 260, 30);
		
		textHoraE = new JTextField();
		textHoraE.setBounds(280, 430, 70, 30);
		
		//Data Saida
		labelDataS = new JLabel("DATA SAÍDA:");
		labelDataS.setBounds(370, 400, 260, 30);
		
		textDataS = new JTextField();
		textDataS.setBounds(360, 430, 120, 30);
		
		
		//Hora saida
		labelHoraS = new JLabel("HORA S.:");
		labelHoraS.setBounds(500, 400, 260, 30);
		
		textHoraS = new JTextField();
		textHoraS.setBounds(490, 430, 70, 30);
		
//	
		//TEMPO
		labelTempo = new JLabel("TEMPO:");
		labelTempo.setBounds(580, 400, 260, 30);
		
		textTempo = new JTextField();
		textTempo.setBounds(570, 430, 90, 30);
		
		//valor a pagar
		labelValorAPagar = new JLabel("VALOR A PAGAR:");
		labelValorAPagar.setBounds(30, 510, 100, 30);
		
		textValorAPagar = new JTextField();
		textValorAPagar.setBounds(150, 500, 150, 50);
		
		//button Efetuar saida
		buttonEfetuarSaida = new JButton();
		buttonEfetuarSaida.setText("EFETUAR SAÍDA");
		buttonEfetuarSaida.setBounds(330, 500, 150, 50);
		
	
		//button fechar sistema
		buttonFecharSistema = new JButton();
		buttonFecharSistema.setText("FECHAR SISTEMA");
		buttonFecharSistema.setBounds(510, 500, 150, 50);
		
		criarTabela();
		
		tela.getContentPane().add(labelEntrada);
		tela.getContentPane().add(textPlacaEntrada);
		tela.getContentPane().add(labelPlacaEntrada);
		tela.getContentPane().add(textModeloEntrada);
		tela.getContentPane().add(labelModeloEntrada);
		tela.getContentPane().add(buttonEntrar);
		tela.getContentPane().add(labelSaida);
		tela.getContentPane().add(labelPlacaSaida);
		tela.getContentPane().add(textPlacaSaida);
		tela.getContentPane().add(buttonBuscar);
		tela.getContentPane().add(textModeloSaida);
		tela.getContentPane().add(labelModeloSaida);
		tela.getContentPane().add(labelDataE);
		tela.getContentPane().add(textDataE);
		tela.getContentPane().add(labelHoraE);
		tela.getContentPane().add(textHoraE);
		tela.getContentPane().add(labelDataS);
		tela.getContentPane().add(textDataS);
		tela.getContentPane().add(labelHoraS);
		tela.getContentPane().add(textHoraS);
		tela.getContentPane().add(labelTempo);
		tela.getContentPane().add(textTempo);
		tela.getContentPane().add(labelValorAPagar);
		tela.getContentPane().add(textValorAPagar);
		tela.getContentPane().add(buttonEfetuarSaida);
		tela.getContentPane().add(buttonFecharSistema);
		tela.getContentPane().add(scrollTable);
		
		
		tela.setVisible(true);
		
		
		buttonEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
							
				 //Obtém LocalDate de hoje
		        LocalDate hoje = LocalDate.now();
		        LocalDateTime agora = LocalDateTime.now();
		        DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH:mm:ss");
		        String hojeFormatado = hoje.format(formatterDay);
		        String agoraFormatado = agora.format(formatterHour);
		        
		        System.out.println("LocalDate depois de formatar: " + hojeFormatado);
				
				if (validarFormulario()) {
					Carro carro = new Carro();
					carro.setPlaca(textPlacaEntrada.getText().toUpperCase());
					carro.setModelo(textModeloEntrada.getText().toUpperCase());
					carro.setCodigo(Util.gerarCodigo());
					carro.setDataEntrada(hojeFormatado);
					carro.setHoraEntrada(agoraFormatado);
					
									
					
					
//					carro.setHoraE(textModeloEntrada.getText().toUpperCase());
					
					
					CarroDao dao = new CarroDao(carro);
					dao.salvar();
					JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso");
					
					
					limparFormularioEntrada(); 
					
					criarTabela();
				}
				
				else {
					JOptionPane.showMessageDialog(null, 
							"Você deve preencher todos so campos", 
							"Atenção", 
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		
		
//		buttonBuscar.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//				if (validarFormulario()) {
//					Carro carro = new Carro();
//					carro.setPlaca(textPlacaEntrada.getText().trim().toUpperCase());
//					carro.setModelo(textModeloEntrada.getText().toUpperCase());
//					carro.setCodigo(Util.gerarCodigo());
//					
//					System.out.println(carro.getPlaca());
//					System.out.println(carro.getCodigo());
//					System.out.println(carro.getModelo());
//				
//					CarroDao dao = new CarroDao(carro);
//					dao.salvar();
//					JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso");
//					
//					
//					limparFormularioEntrada(); 
//					
//					criarTabela();
//				}
//				
//				else {
//					JOptionPane.showMessageDialog(null, 
//							"Você deve preencher todos so campos", 
//							"Atenção", 
//							JOptionPane.WARNING_MESSAGE);
//				}
//			}
//			
//		});
//		
//		
//		
//		// BOTÃO EFETUAR SAIDA
//		
//		
//		buttonEfetuarSaida.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//				if (validarFormulario()) {
//					Carro carro = new Carro();
//					carro.setTempo(textPlacaSaida.getText().toUpperCase());
//					
//					
//					CarroDao dao = new CarroDao(carro);
//					dao.salvar();
//					JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso");
//					
//					
//					limparFormularioEntrada(); 
//					
//					criarTabela();
//				}
//				
//				else {
//					JOptionPane.showMessageDialog(null, 
//							"Você deve preencher todos so campos", 
//							"Atenção", 
//							JOptionPane.WARNING_MESSAGE);
//				}
//			}
//		});
		
		// BOTÃO FECHAR SISTEMA
		
		
		buttonFecharSistema.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				tela.setVisible(false); // fecha a tela

			}
		});
		
		
		// QUANDO CLICAR EM UMA LINHA DA TABELA, FAZER QUE ELE MOSTRE OS DADOS
		
		tabelaEstacionamento.addMouseListener(new MouseListener() {
			
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
				
				String codigo;
				int linha = tabelaEstacionamento.getSelectedRow();
				codigo = tabelaEstacionamento.getModel().getValueAt(linha,0).toString();
			
				CarroDao dao = new CarroDao();
				Carro carro = dao.buscarCarro(codigo);
				
				textPlacaSaida.setText(carro.getPlaca());
				textModeloSaida.setText(carro.getModelo());
				textDataE.setText(String.valueOf(carro.getDataEntrada()));
				textDataS.setText(String.valueOf(carro.getDataSaida()));
				textHoraE.setText(String.valueOf(carro.getHoraEntrada()));
				textHoraS.setText(String.valueOf(carro.getHoraSaida()));
				textTempo.setText(String.valueOf(carro.getTempo()));
				textValorAPagar.setText(String.valueOf(carro.getValorAPagar()));
			}
		});
	}  
	
	private void criarTabela() {
		//passo 1 - Criar o modelo para nossa tabela
		tabelaEstacionamentoModel = new DefaultTableModel();
		
		// Colunas
		tabelaEstacionamentoModel.addColumn("CÓDIGO");
		tabelaEstacionamentoModel.addColumn("PLACA");
		tabelaEstacionamentoModel.addColumn("MODELO");
		tabelaEstacionamentoModel.addColumn("DATA ENTRADA");
		
		CarroDao carroDao = new CarroDao();
		ArrayList<Carro> carros = carroDao.listarCarro();
		
		
		
		//aqui criamos uma lista, ou seja, a cada volta criar um cliente
		for (Carro carro : carros) {
			// Linhas
			 String[] vetorCliente = {carro.getCodigo(), carro.getPlaca(), carro.getModelo(), carro.getDataEntrada()};
			 tabelaEstacionamentoModel.addRow(vetorCliente);
		}
		
		
		 
		// PASSO 2 - Criar tabela
		tabelaEstacionamento = new JTable(tabelaEstacionamentoModel);
		
		
		// Determinar a largura das colunas
		tabelaEstacionamento.getColumnModel().getColumn(0).setPreferredWidth(110);
		tabelaEstacionamento.getColumnModel().getColumn(1).setPreferredWidth(110);
		tabelaEstacionamento.getColumnModel().getColumn(2).setPreferredWidth(110);
		tabelaEstacionamento.getColumnModel().getColumn(3).setPreferredWidth(110);	
		
			//não premite dar o tamanho ou redimentcionar, bem como mudar de ordem
		tabelaEstacionamento.getColumnModel().getColumn(0).setResizable(false);
		tabelaEstacionamento.getTableHeader().setReorderingAllowed(false);
			
			
		// cor na tabela
			//PASSO 3 - COlocar a tabela no painel de rolamento
			scrollTable = new JScrollPane(tabelaEstacionamento);
			scrollTable.setBounds(20,100,640,190);		
	}

	
	private void limparFormularioInteiro() {
		textPlacaEntrada.setText("");
		textPlacaSaida.setText("");		
		textHoraE.setText("");			//
		textDataE.setText("");     
		textDataS.setText("");  // Faz limpar a tela quando precionar "ok" da caixa de textos		//
		textHoraS.setText("");  
		textTempo.setText("");
		textModeloEntrada.setText("");
		textModeloSaida.setText("");  
		textValorAPagar.setText(""); 
		textPlacaEntrada.requestFocus();		// Coloca o cursor ja no nome do cliente
	}
	
	private void limparFormularioEntrada() {
		textPlacaEntrada.setText("");
		textModeloEntrada.setText("");
		textPlacaEntrada.requestFocus();
	}
	
	
	private boolean validarFormulario() {
		
		boolean valido = true;
				
		
		if(textPlacaEntrada.getText().length() == 0) {
			labelPlacaEntrada.setForeground(Color.red);
			valido = false;
			
		}
		
		else if (textModeloEntrada.getText().length() == 0) {
			labelModeloEntrada.setForeground(Color.red);
			valido = false;
		}
		
		return valido;
	}
	


	private static void escreverArquivo(Carro carro){
		Path path = Paths.get("C:/Users/isabe/projetoEstaciona.txt");
		try 
		{
			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.WRITE, StandardOpenOption.APPEND);
			writer.write(carro.getCodigo() 
					+ ";" + carro.getPlaca() 
					+ ";" + carro.getModelo() 
					+ ";" + carro.getDataTeste() 
					+ ";" + carro.getHoraEntrada() 
					+ ";" + carro.getDataSaida() 
					+ ";" + carro.getDataEntrada() 
					+ ";" + carro.getTempo()
					+ ";" + carro.getValorAPagar());
			
			writer.newLine();
			writer.close();
		} 
		catch (Exception e) 
		{
			System.out.println("Não foi possivel gravar os dados");
		}
		
	}
}
