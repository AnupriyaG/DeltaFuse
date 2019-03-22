package org.yash.deltafuse.dataingestion.controller;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yash.deltafuse.dataingestion.model.Address;
import org.yash.deltafuse.dataingestion.service.PdfReportGenerationService;

@RestController
@RequestMapping("/report")
public class PdfReportController {

	@Autowired
	PdfReportGenerationService generationService;
	
	private  List<Address> addList = null;

	@RequestMapping(value = "/pdfreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> createReport() {
		
		addList = Arrays.asList(
				new Address(1, "Magarpatta", "Tower1", "South Gate", "pune", "411036","Pune","MH","INDIA","+91"),
				new Address(2, "Hadapsar", "Tower4", "Main Gate", "pune", "411035","Solapur","MH","INDIA","+91"),
				new Address(3, "Khadadi", "Eon", "Main Gate", "pune", "411037","Pune","MH","INDIA","+91"),
				new Address(4, "Hinjewadi", "Blue ridge", "Symbiosis ", "pune", "411057","Kolhapur","MH","INDIA","+91"),
				new Address(5, "Keshav nagar", "Florida Estate", "Jai Maha Chowk", "pune", "411036","Shirdi","MH","INDIA","+91"),
				new Address(6, "Wadgaishry", "Viman nagar", "Entry Gate", "pune", "411031","Kolhapur","MH","INDIA","+91"));
		
		ByteArrayInputStream byteArrayInputStream = generationService.generateReport(addList);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=test.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(byteArrayInputStream));
	}

}
