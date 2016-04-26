
import java.sql.*;
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