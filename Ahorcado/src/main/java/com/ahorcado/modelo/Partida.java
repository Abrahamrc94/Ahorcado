package com.ahorcado.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Partida {
	private static final int MAX_ERRORES = 5;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPartida;
	
	private List<Jugador> jugadores;
	private String palabraSecreta;
	private StringBuilder palabraCodificada;
	private boolean acertada;
	
	public Partida() {
		super();
		this.jugadores = new ArrayList<>();
	}
	public Partida(String palabraSecreta, StringBuilder palabraCodificada) {
		super();
		this.jugadores = new ArrayList<>();
		this.palabraSecreta = palabraSecreta;
		this.palabraCodificada = palabraCodificada;
		this.acertada = false;
	}
	public long getIdPartida() {
		return idPartida;
	}
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public String getPalabraSecreta() {
		return palabraSecreta;
	}
	public void setPalabraSecreta(String palabraSecreta) {
		this.palabraSecreta = palabraSecreta;
	}
	public StringBuilder getPalabraCodificada() {
		return palabraCodificada;
	}
	public void setPalabraCodificada(StringBuilder palabraCodificada) {
		this.palabraCodificada = palabraCodificada;
	}
	public boolean isAcertada() {
		return acertada;
	}
	public void setAcertada(boolean acertada) {
		this.acertada = acertada;
	}
	public static int getMaxErroresPalabras() {
		return MAX_ERRORES;
	}
	
	
}
