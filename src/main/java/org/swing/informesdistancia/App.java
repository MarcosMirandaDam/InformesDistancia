package org.swing.informesdistancia;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Marcos Miranda
 */
public class App {

    private static final String PATH="src/main/resources/";                 //creamos PATH porque iran todos los reportes ahi
    private static final String INFORME_SIMPLE="PrimerInforme.jasper";
        
        
    public static void main(String[] args) {
        mostrarInforme();
    }
    
    
    public static void mostrarInforme(){
        String reportName=PATH+INFORME_SIMPLE;
        Map<String,Object> params=new HashMap<>();
        Connection conn=ConnectionManager.getMySqlConnection();
         //params.put("city", "London");   SOLO si tuvieramos que pasarle valores
        try {
           
            JasperPrint print=JasperFillManager.fillReport(reportName,params,conn);
            JasperViewer viewer=new JasperViewer(print);
            viewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
