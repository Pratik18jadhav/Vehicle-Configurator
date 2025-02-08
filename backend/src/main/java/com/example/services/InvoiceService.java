package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ComponentDTO;
import com.example.dto.InvoiceDTO;
import com.example.dto.ModelDTO;
import com.example.dto.UserDTO;
import com.example.entities.User;
import com.example.repository.UserRepository;

@Service
public class InvoiceService {

	@Autowired
	UserRepository userRepository;

	public InvoiceDTO generateInvoie(InvoiceDTO invoice) {

		String invoiceNumber = invoice.getInvoiceNumber();
		String manufacturer = invoice.getManufacturer();
		String modelname = invoice.getModelName();
		List<String> componentList = invoice.getComponents();
		String segment = invoice.getSegment(); 

		double baseprice = invoice.getBasePrice();
		double tax = invoice.getTax();
		int quantity = invoice.getQuantity();
		double totalPrice = invoice.getTotalPrice();
		double finalTotalPrice = invoice.getFinalTotalPrice();

		User user = userRepository.findByUsername(invoice.getUsername());

		UserDTO userDTO = new UserDTO(user.getCompanyName(), user.getEmail(), user.getGstNumber(),user.getContactNumber());

		InvoiceDTO invoiceDto = new InvoiceDTO(invoiceNumber,manufacturer,modelname,componentList,segment,baseprice,tax,quantity,totalPrice,finalTotalPrice,userDTO);

		return invoiceDto;
	}

}
