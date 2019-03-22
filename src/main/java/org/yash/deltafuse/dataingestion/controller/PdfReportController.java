package org.yash.deltafuse.dataingestion.controller;

import java.io.ByteArrayInputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yash.deltafuse.dataingestion.service.ReportService;

@RestController
@RequestMapping("/report")
public class PdfReportController {

	@Autowired
	ReportService reportService;

	@RequestMapping(value = "/pdfreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> createReport() {

		ByteArrayInputStream byteArrayInputStream = reportService.getAllMobileData();
		String test = "report-" + String.valueOf(new Date().getTime());

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=" + test + ".pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(byteArrayInputStream));
	}

}
