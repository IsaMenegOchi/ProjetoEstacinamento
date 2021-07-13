package br.com.pestacionamento;

import java.time.LocalDate;
import java.time.Period;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import br.com.pestacionamento.ui.MovementFrame;

public class MainParking {
		
		public static void main(String[] args) {
		
			try 
			{
				for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
				{
					if ("Nimbus".equals(info.getName())) 
					{
						UIManager.setLookAndFeel(info.getClassName());
						break;
					}
				}
			} 
			
			catch (UnsupportedLookAndFeelException e) 
			{
				// handle exception
			} 
			catch (ClassNotFoundException e) 
			{
				// handle exception
			} 
			catch (InstantiationException e) 
			{
				// handle exception
			} 
			catch (IllegalAccessException e) 
			{
				// handle exception
			}
			
			
			
			
			
		MovementFrame teste = new MovementFrame();
		teste.createScreen();
		}
	
	
}
