package com.example.controllers;

import java.util.List;
import java.util.function.ObjDoubleConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.InvoiceDTO;
import com.example.services.InvoiceService;

@RestController
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceservice;

	@PostMapping(value = "/generateInvoice")
	public ResponseEntity<InvoiceDTO> generateInvoice(@RequestBody InvoiceDTO invoice) {
		System.out.println(invoice);

		InvoiceDTO objDto = invoiceservice.generateInvoie(invoice);
		System.out.println(objDto);

		return ResponseEntity.ok(objDto);
	}

	@GetMapping(value = "/gethistory/{username}")
	public ResponseEntity<List<InvoiceDTO>> getInvoiceHistory(@PathVariable String username) {
		
		List<InvoiceDTO> history = invoiceservice.gethistory(username);
		if (!history.isEmpty()) 
		{
			return ResponseEntity.ok(history);
		} 
		else 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
