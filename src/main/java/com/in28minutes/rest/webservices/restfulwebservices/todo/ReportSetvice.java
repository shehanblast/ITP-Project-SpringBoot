package com.in28minutes.rest.webservices.restfulwebservices.todo;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportSetvice {

    @Autowired
    private TodoJpaRepo todoJpaRepo;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        List<Todo> todos=todoJpaRepo.findAll();

        File file= ResourceUtils.getFile("classpath:medicine.jrxml");
        JasperReport jasperReport= JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(todos);
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("Created by","java");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);

        if ("html".equalsIgnoreCase(reportFormat)){
          JasperExportManager.exportReportToHtmlFile(jasperPrint,"C:\\Users\\shiha\\Desktop\\report"+"\\medicine.html");
        }
        if ("pdf".equalsIgnoreCase(reportFormat)){
            JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\shiha\\Desktop\\report"+"\\medicine.pdf");
        }

        return "Report generate in ";
    }
}
