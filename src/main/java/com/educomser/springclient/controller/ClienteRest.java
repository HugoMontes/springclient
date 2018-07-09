package com.educomser.springclient.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.educomser.springclient.model.Nota;

@Controller
@RequestMapping("/nota")
public class ClienteRest {
	// Obtener el token ingresando a http://localhost:8080/login
	private final String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWFuIn0.uGy77cfxEpQRFSeB7EuobMt6yPej-KQ_TCcK--z6yAu0OFzzRWA_ZDLCu9at82CzBo0S2i3W_RwnxijTjtMEOA";
	private String URL="http://localhost:8080/nota/obtener";
	
	@GetMapping("/all")
	public ModelAndView devolvertodos() {
		ModelAndView mv=new ModelAndView("notas");
		RestTemplate rest=new RestTemplate();
		HttpHeaders headers=new HttpHeaders();
		headers.add("Authorization", token);
		HttpEntity entity=new HttpEntity(headers);
		ResponseEntity<Nota[]> notasEntity=rest.exchange(URL, HttpMethod.GET, entity, Nota[].class);
		Nota[] notas=notasEntity.getBody();
		mv.addObject("notas", notas);
		return mv;
	}
}
