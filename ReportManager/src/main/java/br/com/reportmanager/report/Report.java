package br.com.reportmanager.report;

import java.util.Map;

public class Report {

	private Database database;

	private FTP ftp;

	private Map<String, Object> params;

	public Report(Database database, FTP ftp, Map<String, Object> params) {
		this.database = database;
		this.ftp = ftp;
		this.params = params;
	}
	
	public Report() {
		
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public FTP getFtp() {
		return ftp;
	}

	public void setFtp(FTP ftp) {
		this.ftp = ftp;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}
