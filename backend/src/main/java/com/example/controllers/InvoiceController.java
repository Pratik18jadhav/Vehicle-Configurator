package com.example.controllers;

import java.util.function.ObjDoubleConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<InvoiceDTO> generateInvoice(@RequestBody InvoiceDTO invoice)
	{
		System.out.println(invoice);
		
		InvoiceDTO objDto = invoiceservice.generateInvoie(invoice);
		System.out.println(objDto);
		
		
		return ResponseEntity.ok(objDto);
	}
}
