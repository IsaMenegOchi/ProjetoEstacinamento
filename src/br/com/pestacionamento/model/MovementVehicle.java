package br.com.pestacionamento.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import br.com.pestacionamento.util.Util;

public class MovementVehicle {

	private String carCode;
	private String carPlate;
	private String carModel;
	private String carExitHour;
	private String carExitDate;
	private String carEntranceHour;
	private String carEntranceDate;
	private String carPeriod;
	private double amountToPay;
	
	public String getCarCode() {
		return carCode;
	}

	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarExitHour() {
		return carExitHour;
	}

	public void setCarExitHour(String carExitHour) {
		this.carExitHour = carExitHour;
	}

	public String getCarExitDate() {
		return carExitDate;
	}

	public void setCarExitDate(String carExitDate) {
		this.carExitDate = carExitDate;
	}

	public String getCarEntranceHour() {
		return carEntranceHour;
	}

	public void setCarEntranceHour(String carEntranceHour) {
		this.carEntranceHour = carEntranceHour;
	}

	public String getCarEntranceDate() {
		return carEntranceDate;
	}

	public void setCarEntranceDate(String carEntranceDate) {
		this.carEntranceDate = carEntranceDate;
	}

	public String getCarPeriod() {
		return carPeriod;
	}

	public void setCarPeriod(String carPeriod) {
		this.carPeriod = carPeriod;
	}

	public double getAmountToPay() {
		return amountToPay;
	}

	public void setAmountToPay(double amountToPay) {
		
		
		this.amountToPay = amountToPay;
	}

	
	
	
	@Override
	public String toString() 
	{
		return carCode + ";" + carPlate + ";" + carModel + ";" + carEntranceDate + ";"
				+ carEntranceHour + ";" + carExitDate + ";" + carExitHour + ";" + carPeriod + ";" + amountToPay;
	}
	
	public String toStringEntrance() 
	{
		return carCode + ";" + carPlate + ";" + carModel + ";" + carEntranceDate + ";"
				+ carEntranceHour + ";1111-11-11;00:00:00;00:00;00.00";
			//	";00;0;0;0";
		
	}

}
