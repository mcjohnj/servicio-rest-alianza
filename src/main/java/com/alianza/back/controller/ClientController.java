package com.alianza.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import com.alianza.back.model.Client;
import com.alianza.back.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping
	private ResponseEntity<List<Client>> getAllClient(){
		return ResponseEntity.ok(clientService.findAll());
	}
	
	@GetMapping(path = "/{sharedKey}")
	private ResponseEntity<List<Client>> getAllSharedKey(@RequestParam("sharedKey") String sharedKey){
		return ResponseEntity.ok(clientService.findBySharedKey(sharedKey));
	}
	
	@PostMapping
	private ResponseEntity<Client> saveClient(@RequestBody Client cliente ){
		try {
			Client client = clientService.save(cliente);
			return ResponseEntity.created(new URI("/clients/"+client.getSharedKey())).body(client);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
