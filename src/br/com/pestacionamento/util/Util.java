package br.com.pestacionamento.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.swing.text.DateFormatter;

public class Util {
	
	public static String generateCode()
	{
		return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
		//cria um código em HEXA, transforma em String, pega os 8 primeiros caracteres e os apresenta em letras maisusculas
	}
	
	
	public static String convertDate(LocalDate day)
	{
        String formatDay = day.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return formatDay;
	}
	
	public static String convertTime (LocalTime hour){
		
		String formatHour = hour.format(DateTimeFormatter.ofPattern("HH:mm"));
		return formatHour;
	}
	
}
