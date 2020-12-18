package com.ahorcado.services;


import org.springframework.stereotype.Service;

import com.ahorcado.modelo.Jugador;
import com.ahorcado.modelo.Partida;

@Service
public class AhorcadoService {
	
	Partida partida;
	Jugador jugador;
	
	// Creamos la partida añadiendo la palabra que tenemos que adivinar y el nombre del jugador
	//El servicio llama a 
	public void crearPartida(String palabra, String nombre) {
		StringBuilder palabraCodificada = codificaPalabra(palabra);
		partida = new Partida(palabra,palabraCodificada);
		jugador = new Jugador(nombre);
		partida.getJugadores().add(jugador);
	}
	
	//Introducimos una letra y si la palabra la contiene cambiamos la palabra codificada a una con las letras descubiertas,
	//si no aumentamos fallos
	public StringBuilder compruebaLetra(char letra) {
		if(contieneLetra(letra, partida.getPalabraSecreta())) {
			partida.setPalabraCodificada(exponCodificada(letra, partida.getPalabraSecreta(), partida.getPalabraCodificada()));
			jugador.setIntentos(jugador.getIntentos()+1);
		}else {
			jugador.setIntentosFallidos(jugador.getIntentosFallidos()+1);
		}
		return partida.getPalabraCodificada();
	}
	
	//Introducimos palabra, si la adivinamos devolvemos true, si no aumentamos el número de fallos
	public boolean adivinarPalabra(String palabra) {
		boolean ganado = false;
		if(compruebaPalabra(palabra, partida.getPalabraSecreta())) {
			ganado = true;
		}else {
			jugador.setIntentosFallidos(jugador.getIntentosFallidos()+1);
		}
		return ganado;
	}
	
	
	public StringBuilder devuelvePalabra() {
		return partida.getPalabraCodificada();
	}
	
	// Este método codifica la palabra dada al inicio de la partida
	private StringBuilder codificaPalabra(String palabra) {
		StringBuilder palabraGuion = new StringBuilder();
		for(int i=0; i<palabra.length(); i++) {
			palabraGuion.append("_");
		}
		return palabraGuion;
	}
	
	//Este método comprueba si la letra dada está contenida en la palabra codificada
	private boolean contieneLetra(char letraDada, String palabra) {	
		boolean contiene = false;
		char[] arrayletras = palabra.toCharArray();
		for(char letra: arrayletras) {
			if(letraDada== letra) {
				contiene = true;
			}
		}
		return contiene;
	}
	
	//Este método descubre las letras acertadas en la palabra codificada
	private StringBuilder exponCodificada(char letr, String palabra, StringBuilder palabraguion){
		String letra = "" + letr;
		char[] arrayletras = palabra.toCharArray();
		for(int i=0 ; i<palabra.length(); i++) {
			if(letr == arrayletras[i]) {
				palabraguion.replace(i, i+1, letra);
			}else {
			}
		}
		return palabraguion;
	}
	
	//Este método comprueba las palabras, si ambas coinciden devuelve true
	private boolean compruebaPalabra(String palabra, String palabraAdivinar) {
		boolean contiene = false;
		if(palabra.equals(palabraAdivinar)) {
			contiene = true;
		}
		return contiene;
	}
	
	
	
}
