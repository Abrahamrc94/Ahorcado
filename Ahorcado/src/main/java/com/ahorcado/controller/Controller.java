package com.ahorcado.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahorcado.services.AhorcadoService;

@RestController
@RequestMapping(path = "/ahorcado")
public class Controller {
	
	//Inyección de Servicios
	@Autowired
	private AhorcadoService ahorcadoService;

	
	//Método Post que proporciona una palabra e inicia una partida
	//@CrossOrigin(origins = "localhost:8080")
	@PostMapping("/{palabra}")
	public ResponseEntity<?> crearPartida(@PathVariable String palabra){
		ahorcadoService.crearPartida(palabra, "Jugador");
		return ResponseEntity.ok(ahorcadoService.devuelvePalabra());
	}
	
	//Método Put para enviar una letra en la petición
	@PutMapping("/letra/{letra}")
	public ResponseEntity<?> enviarLetra(@PathVariable char letra){
		return ResponseEntity.ok(ahorcadoService.compruebaLetra(letra));
	}
	
	//Método Put para enviar una palabra en la petición
	@PutMapping("/palabra/{palabra2}")
	public ResponseEntity<?> enviarPalabra(@PathVariable String palabra2){
		boolean ganado = ahorcadoService.adivinarPalabra(palabra2);
		return ResponseEntity.ok(ganado);
	}
	
	
}
