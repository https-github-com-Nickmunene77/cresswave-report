package com.creswaves.employeereport;

import net.sf.jasperreports.engine.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class EmployeeReportApplication {

	public static void main(String[] args) throws JRException {
		SpringApplication.run(EmployeeReportApplication.class, args);
		String filePath="C:\\Users\\pc\\Desktop\\creswave\\employee-report\\src\\main\\resources\\templates\\EmployeeReport.jrxml";
		Map<String, Object> parameters=new HashMap<>();
		JasperReport report = JasperCompileManager.compileReport(filePath);
		JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\pc\\Desktop\\creswave\\employee-report\\src\\main\\resources\\static\\creswave.pdf");
		System.out.println("REport generated ");
	}

}
