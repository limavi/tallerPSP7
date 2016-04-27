import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 * Created by lili on 27/04/16.
 */
public class Test extends TestCase {

    public void test1CalculoPrograma7() throws Exception {
        System.out.println("test1 CalculoPrograma7");
        ArrayList<Double> EstimatedProxySize = new ArrayList<Double>(Arrays.asList(130.0,650.0,99.0,150.0,128.0,302.0,95.0,945.0,368.0,961.0));
        ArrayList<Double> ActualAddedandModifiedSize = new ArrayList<Double>(Arrays.asList(186.0,699.0,132.0,272.0,291.0,331.0,199.0,1890.0,788.0,1601.0));
        String expResult= "r:0.9544965741046826,  r^2:0.9110637099775758,  tailArea:1.7751922070985415E-5,  beta0:-22.55253275203438  beta1:1.7279324262069864,  yk:644.4293837638623,  Range:230.00172610114413,  UPI:874.4311098650064,  LPI:414.4276576627182";
        String resultado = Estadistica.calculoPrograma7(EstimatedProxySize,ActualAddedandModifiedSize,386.0);
        assertEquals(expResult, resultado);
    }

    public void test2CalculoPrograma7() throws Exception {
        System.out.println("test2 CalculoPrograma7");
        ArrayList<Double> EstimatedProxySize = new ArrayList<Double>(Arrays.asList(130.0,650.0,99.0,150.0,128.0,302.0,95.0,945.0,368.0,961.0));
        ArrayList<Double> ActualDevelopmentHours = new ArrayList<Double>(Arrays.asList(15.0,69.9,6.5,22.4,28.4,65.9,19.4,198.7,38.8,138.2));
        String expResult= "r:0.9333068981405511,  r^2:0.871061766116737,  tailArea:7.982103462012002E-5,  beta0:-4.038881574687579  beta1:0.168126649881629,  yk:60.858005279621224,  Range:27.557648239487744,  UPI:88.41565351910897,  LPI:33.30035704013348";
        String resultado = Estadistica.calculoPrograma7(EstimatedProxySize,ActualDevelopmentHours,386.0);
        assertEquals(expResult, resultado);
    }

    public void test3CalculoPrograma7() throws Exception {
        System.out.println("test3 CalculoPrograma7");
        ArrayList<Double> EstimatedProxySize = new ArrayList<Double>(Arrays.asList(125.0, 51.3,108.0,81.1));
        ArrayList<Double> ActualAddedandModifiedSizes = new ArrayList<Double>(Arrays.asList(0.0, 324.0, 566.0,41.0));
        String expResult= "r:-0.15511211254079396,  r^2:0.02405976745686793,  tailArea:0.8448878873299417,  beta0:349.1135217292316  beta1:-1.2738207085849105,  yk:-142.58127178454384,  Range:2395.1418579493975,  UPI:2252.5605861648537,  LPI:-2537.7231297339413";
        String resultado = Estadistica.calculoPrograma7(EstimatedProxySize,ActualAddedandModifiedSizes,386.0);
        assertEquals(expResult, resultado);
    }

    public void test4CalculoPrograma7() throws Exception {
        System.out.println("test4 CalculoPrograma7");
        ArrayList<Double> EstimatedProxySize = new ArrayList<Double>(Arrays.asList(125.0, 51.3,108.0,81.1));
        ArrayList<Double> ActualDevelopmentHours = new ArrayList<Double>(Arrays.asList(5.77,3.77,8.03,4.0));
        String expResult= "r:0.7122026250734874,  r^2:0.5072325791615665,  tailArea:0.28779740107826557,  beta0:1.4125661432497258  beta1:0.04356796778051751,  yk:18.229801706529486,  Range:12.677737745846745,  UPI:30.90753945237623,  LPI:5.552063960682741";
        String resultado = Estadistica.calculoPrograma7(EstimatedProxySize,ActualDevelopmentHours,386.0);
        assertEquals(expResult, resultado);
    }


}