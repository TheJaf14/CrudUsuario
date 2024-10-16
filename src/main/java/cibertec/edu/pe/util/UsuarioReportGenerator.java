package cibertec.edu.pe.util;

import java.io.FileNotFoundException;
import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import cibertec.edu.pe.model.Usuario;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class UsuarioReportGenerator {
	
	public static byte[] exportToPdf(List<Usuario> list) throws JRException, FileNotFoundException {
		
		return JasperExportManager.exportReportToPdf(getReport(list));
	}
	
	private static JasperPrint getReport (List<Usuario> list) throws FileNotFoundException, JRException {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("usersData", new JRBeanCollectionDataSource(list));
		
		JasperPrint report = JasperFillManager.fillReport(JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:userReport.jrxml").getAbsolutePath()), 
				params, new JREmptyDataSource());
		
		return report;
	}

}
