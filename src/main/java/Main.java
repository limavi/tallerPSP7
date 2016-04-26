
import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
import spark.Request;
import spark.Response;

/**
 * Clase que contiene las ejecuciones principales del programa
 * @author Lili
 */
public class Main {
    
    /**
     * Metodo: Logica inicial y principal del programa
     * @param args 
     */
    public static void main(String[] args) {

        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");


        get("/taller07", (Request request, Response response) -> {
            ArrayList<Double> EstimatedProxySize = new ArrayList<Double>(Arrays.asList(130.0,650.0,99.0,150.0,128.0,302.0,95.0,945.0,368.0,961.0));
            ArrayList<Double> PlanAddedandModifiedSize = new ArrayList<Double>(Arrays.asList(163.0,765.0,141.0,166.0,137.0, 355.0, 136.0, 1206.0, 433.0,1130.0));
            ArrayList<Double> ActualAddedandModifiedSize = new ArrayList<Double>(Arrays.asList(186.0,699.0,132.0,272.0,291.0,331.0,199.0,1890.0,788.0,1601.0));
            ArrayList<Double> ActualDevelopmentHours = new ArrayList<Double>(Arrays.asList(15.0,69.9,6.5,22.4,28.4,65.9,19.4,198.7,38.8,138.2));

            ArrayList<Double> xArrayList = new ArrayList<Double>(EstimatedProxySize);
            ArrayList<Double> yArrayList = new ArrayList<Double>(ActualAddedandModifiedSize);

            double xAverage = Estadistica.getAverage(xArrayList);
            double yAverage = Estadistica.getAverage(yArrayList);

            double beta1 = Estadistica.calBeta1(xArrayList,yArrayList,xAverage,yAverage);
            double beta0 = Estadistica.calBeta0(beta1,xAverage,yAverage);
            double r = Estadistica.calR(xArrayList,yArrayList);

            double x = 247.88;
            double y = beta0 + beta1 * x;
            double range = Estadistica.getRange(xArrayList, yArrayList, beta0, beta1, x);
            double tailArea = Estadistica.getTailArea(r, xArrayList);


            String resultado = "r:"+r + ",  r^2:"+ r*r + ",  tailArea:"+ tailArea + ",  beta0:"+beta0 +"  beta1:"+beta1+",  yk:"+y+",  Range:"+range+",  UPI:"+(y+range)+",  LPI:"+(y-range);

            Map<String, Object> atributes = new HashMap<>();
            atributes.put("test1", resultado);
            return new ModelAndView(atributes, "taller07.ftl");

        }, new FreeMarkerEngine());



        get("/taller06", (Request request, Response response) -> {

            double p = 0;
            int dof = 0;
            double x1 = 0;
            double x2 = 0;
            double x3 = 0;

            p = 0.20;
            dof = 6;
            x1 = Estadistica.calcularXDistribucionT(p, dof);

            p = 0.45;
            dof = 15;
            x2 = Estadistica.calcularXDistribucionT(p, dof);

            p = 0.495;
            dof = 4;
            x3 = Estadistica.calcularXDistribucionT(p, dof);

            Map<String, Object> atributes = new HashMap<>();
            atributes.put("x1", Visual.tranformarDecimales(x1,7));
            atributes.put("x2", Visual.tranformarDecimales(x2,7));
            atributes.put("x3", Visual.tranformarDecimales(x3,7));
            return new ModelAndView(atributes, "taller06.ftl");

        }, new FreeMarkerEngine());

        get("/hello", (req, res) -> "Hello World");
    
    }
}