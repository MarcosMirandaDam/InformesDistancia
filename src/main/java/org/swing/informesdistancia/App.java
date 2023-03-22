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
    private static final String INFORME_PELICULAS_POR_ACTOR="PeliculasPorActor.jasper";
    private static final String INFORME_TABLAS_CRUZADAS="TablaCruzadad.jasper";
    private static final String INFORME_TARTA="informeTarta.jasper";
    private static final String INFORME_PELICULAS_CIUDAD="Tarea1.jasper";
        
    public static void main(String[] args) {
        mostrarInforme();
    }
    
    
    // mostramos el String deseado segun el informe que queramos mostrar
    
    public static void mostrarInforme(){
        //String reportName=PATH+INFORME_SIMPLE;                //aqui elegimos el reporte deseado para generar
        //String reportName=PATH+INFORME_PELICULAS_POR_ACTOR; 
        // String reportName=PATH+INFORME_TABLAS_CRUZADAS; 
        String reportName=PATH+INFORME_PELICULAS_CIUDAD;
        //String reportName=PATH+INFORME_TARTA; 
        Map<String,Object> params=new HashMap<>();
        //params.put("Identificador de autor", 5);                           //pasamos nombre parámetro y valor deseado
        params.put("cityParameter", "London");
        Connection conn=ConnectionManager.getMySqlConnection();
         
        try {
           
            JasperPrint print=JasperFillManager.fillReport(reportName,params,conn);
            JasperViewer viewer=new JasperViewer(print);
            viewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
