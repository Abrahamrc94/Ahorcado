package com.ahorcado.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



public class Jugador {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idJugador;
	
	private String name;
	private int intentos;
	private int intentosFallidos;
	
	public Jugador() {
		super();
	}
	
	public Jugador(String name) {
		super();
		this.name = name;
		this.intentos = 0;
		this.intentosFallidos = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	public int getIntentosFallidos() {
		return intentosFallidos;
	}

	public void setIntentosFallidos(int intentosFallidos) {
		this.intentosFallidos = intentosFallidos;
	}

	public long getIdJugador() {
		return idJugador;
	}
}
