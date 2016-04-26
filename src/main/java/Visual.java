
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Esta clase permite realizar la tranformacion de los numeros double con el fin 
 * que se pueda mostrar detalladamente con decimales.
 * @author Lili
 */
public class Visual {
    
    
    /**
     * Metodo: Permite tranformar un listado de double a string conservando sus decimales
     * @param listadoValores la lista con valores double a ser transformados
     * @param numDecimales numeros de decimales a conservar, va desde 1 hasta 8 
     * por defecto toma 8
     * @return Una lista con los valores tranformados, la lista es tipo String
     */
    public static List tranformarDecimales(List<Double> listadoValores, int numDecimales){
        String parametroDecimales="0.00000000";
        switch(numDecimales){
            case 1:
                parametroDecimales = "0.0";
                break;
            case 2:
                parametroDecimales = "0.00";
                break;
            case 3:
                parametroDecimales = "0.000";
                break;
            case 4:
                parametroDecimales = "0.0000";
                break;
            case 5:
                parametroDecimales = "0.00000";
                break;
            case 6:
                parametroDecimales = "0.000000";
                break;
            case 7:
                parametroDecimales = "0.0000000";
                break;
            case 8:
                parametroDecimales = "0.00000000";
                break;
        }
        List valoresTranformados = new ArrayList();
        DecimalFormat decimales = new DecimalFormat(parametroDecimales);
        String valorConvertido;
        for (int i = 0; i < listadoValores.size(); i++) {
            valorConvertido = decimales.format(listadoValores.get(i));
            valoresTranformados.add(valorConvertido);
        }
        return valoresTranformados;
    }
    
    /**
     * Metodo: Permite tranformar un valor double a string conservando sus decimales 
     * @param valorTransformar valor double al que se le desea realizar la tranformacion
     * @param numDecimales numeros de decimales a conservar, va desde 1 hasta 8 
     * por defecto toma 8
     * @return 
     */
    public static String tranformarDecimales(double valorTransformar, int numDecimales){
        String parametroDecimales="0.00000000";
        switch(numDecimales){
            case 1:
                parametroDecimales = "0.0";
                break;
            case 2:
                parametroDecimales = "0.00";
                break;
            case 3:
                parametroDecimales = "0.000";
                break;
            case 4:
                parametroDecimales = "0.0000";
                break;
            case 5:
                parametroDecimales = "0.00000";
                break;
            case 6:
                parametroDecimales = "0.000000";
                break;
            case 7:
                parametroDecimales = "0.0000000";
                break;
            case 8:
                parametroDecimales = "0.00000000";
                break;
        }
       
        DecimalFormat decimales = new DecimalFormat(parametroDecimales);  
        return decimales.format(valorTransformar);
    }
            
    
}
