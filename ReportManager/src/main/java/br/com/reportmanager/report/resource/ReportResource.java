package br.com.reportmanager.report.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reportmanager.report.Report;
import br.com.reportmanager.report.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportResource {

	@Autowired
	private ReportService service;

	@PostMapping
	public ResponseEntity<byte[]> testando(@RequestBody Report report) {
		
		byte[] pdfReport = service.buildReport(report);

		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "pdf"));
		header.set("Content-Disposition", "inline; filename=report.pdf");
		header.setContentLength(pdfReport == null ? 0 : pdfReport.length);

		return new ResponseEntity<byte[]>(pdfReport, header, HttpStatus.OK);

	}

}
