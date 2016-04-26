/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 *
 * @author Lili
 */
public class EstadisticaTest extends TestCase {
    
    public EstadisticaTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
      
    public void testCalcularXDistribucionT() {
        System.out.println("calcularXDistribucionT");
        double p = 0.20;
        int dof = 6;
        double expResult = 0.55340576171875;
        double result = Estadistica.calcularXDistribucionT(p, dof);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of sumatoria method, of class Estadistica.
     */
    public void testSumatoria() {
        System.out.println("sumatoria");
        List<Double> listadoValores = new ArrayList();
        listadoValores.add((double)1);
        listadoValores.add((double)2);
        listadoValores.add((double)3);
        double expResult = 6.0;
        double result = Estadistica.sumatoria(listadoValores);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of calcularFxPrimeraParte method, of class Estadistica.
     */
    public void testCalcularFxPrimeraParte() {
        System.out.println("calcularFxPrimeraParte");
        String resultado="";
        int dof = 10;
        String expResult = "0,389108";
        double result = Estadistica.calcularFxPrimeraParte(dof);
        resultado = Visual.tranformarDecimales(result,6);
        System.out.println("Resultado:"+resultado);
        assertEquals(expResult, resultado);
    }
    
    /**
     * Test of calcularFxSegundaParte method, of class Estadistica.
     */
    public void testCalcularFxSegundaParte() {
        System.out.println("calcularFxSegundaParte");
        int dof = 10;
        float valorIteracion = 0.0F;
        double expResult = 1.0;
        double result = Estadistica.calcularFxSegundaParte(dof, valorIteracion);
        assertEquals(expResult, result, 0.0);
    }
}
