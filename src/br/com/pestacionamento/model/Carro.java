package br.com.pestacionamento.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.Formatter;

import javax.swing.text.DateFormatter;

public class Carro {

	
	private String placa;
	private String modelo;
	private String codigo;
	private String dataTeste;
	private String dataEntrada;
	private LocalDate dataSaida;
	private String horaEntrada;
	private LocalTime horaSaida;
	private Period tempo;
	private double valorAPagar;
	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalTime getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(LocalTime horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Period getTempo() {
		return tempo;
	}

	public void setTempo(Period tempo) {
		this.tempo = tempo;
	}

	public double getValorAPagar() {
		return valorAPagar;
	}

	public void setValorAPagar(double valorAPagar) {
		this.valorAPagar = valorAPagar;
	}

	
	
	public String getDataTeste() {
		return dataTeste;
	}

	public void setDataTeste(String dataTeste) {
		this.dataTeste = dataTeste;
	}

	@Override
	public String toString() {
		return codigo + ";" + placa + ";" 
			+ modelo + ";" + dataEntrada + ";" + horaEntrada + ";" 
			+ dataSaida + ";" + horaSaida + ";" 
			+ tempo + ";" + valorAPagar;
	}

	
}
