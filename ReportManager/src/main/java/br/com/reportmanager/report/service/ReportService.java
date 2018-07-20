package br.com.reportmanager.report.service;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.reportmanager.report.Report;

@Service
public class ReportService {

	public byte[] buildReport(Report report) {

		Map<String, Object> params = configureParameters(report);
		report.setParams(params);

		return report.getTypeFormat().download(report);
	}

	private Map<String, Object> configureParameters(Report report) {

		Map<String, Object> params = report.getParams();

		params.forEach((k, v) -> {

			Long value = null;

			try {
				value = Long.parseLong(String.valueOf(v));
			} catch (NumberFormatException e) {
				return;
			}

			params.put(k, value.intValue());

		});

		Map<String, Object> parameters = params.entrySet().stream()
				.collect(Collectors.toMap(e -> e.getKey(), e -> (Long.parseLong(String.valueOf(e.getValue())))));
		
		System.out.println(parameters.get("idFluxoDeCaixa"));

		return parameters;
	}

}
