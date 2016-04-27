/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.special.Gamma;

/**
 * Esta clase se utiliza para realizar las operaciones matematicas y
 * estadisticas
 *
 * @author Lili
 */
public class Estadistica {

     /**
     * Metodo  para obtener el promedio
     * param  lista de valores  a la que se le va a calcular el promedio
     * @return el promedio
     */
    public static double getAverage(ArrayList<Double> cal){
        double sumFloat = 0;
        double averageFloat = 0;
        for (int i = 0; i < cal.size(); i++){
            sumFloat += cal.get(i);
        }
        averageFloat = sumFloat / cal.size();
        return averageFloat;
    }

    /**
     * Metodo  para obtener el valor Beta 0
     * param  valor Beta1, el promedio de x y el promedio de y
     * @return el valor de Beta 0
     */
    public static double calBeta0(double beta1, double xAverage, double yAverage){
        double cal = yAverage - beta1*xAverage;
        return cal;
    }

    /**
     * Metodo  para obtener el valor Beta 1
     * param  dos listas de valores (xArrayList,ArrayList) con los  promedios (xAverage,yAverage)
     * @return el valor de Beta 1
     */
    public static double calBeta1(ArrayList<Double> xArrayList, ArrayList<Double> yArrayList, double xAverage, double yAverage){
        double cal = 0;
        cal = multiple(xArrayList, yArrayList)-(xArrayList.size()*xAverage*yAverage);
        cal = cal / (multiple(xArrayList, xArrayList) - xArrayList.size()*xAverage*xAverage);
        return cal;
    }

    /**
     * Metodo  para calcular r
     * param  dos listas de valores (xArrayList,ArrayList)
     * @return el valor de r
     */
    public static double calR(ArrayList<Double> xArrayList, ArrayList<Double> yArrayList){
        double cal = 0;
        cal = xArrayList.size()*multiple(xArrayList, yArrayList)-multiple(xArrayList)*multiple(yArrayList);
        double minus = 0;
        minus = xArrayList.size()*multiple(xArrayList, xArrayList)-multiple(xArrayList)*multiple(xArrayList);
        minus *= yArrayList.size()*multiple(yArrayList, yArrayList)-multiple(yArrayList)*multiple(yArrayList);
        cal = cal / Math.sqrt(minus);
        return cal;
    }

    /**
     * Metodo  multiple
     * param  dos listas de valores (xArrayList,ArrayList)
     * @return
     */
    public static double multiple(ArrayList<Double> xArrayList, ArrayList<Double> yArrayList){
        double cal = 0;
        for (int i = 0; i < xArrayList.size(); i++){
            cal += xArrayList.get(i)*yArrayList.get(i);
        }
        return cal;
    }

    /**
     * Metodo  multiple
     * param  una lista de valores (xArrayList)
     * @return
     */
    public static double multiple(ArrayList<Double> xArrayList){
        double cal = 0;
        for (int i = 0; i < xArrayList.size(); i++){
            cal += xArrayList.get(i);
        }
        return cal;
    }

    /**
     * Metodo calcular el valor gamma
     * param  una valor double
     * @return el valor gamma
     */
    public static double gamma(double x){
        double ans = 1;
        while (x > 1){
            x = x - 1;
            ans = ans * x;
        }
        if (Math.abs(x-1/2)< 1) return ans*Math.sqrt(Math.PI); else return ans;
    }


    /**
     * Metodo calcular el valor f
     * param  dos valores double x y dof
     * @return el valor f
     */
    public static double f(double x,double dof){
        double cal = 0;
        cal = Math.pow((1 + x * x / dof), -(dof + 1) / 2) * gamma((dof + 1) / 2);
        cal = cal / (Math.sqrt(dof * Math.PI) * gamma(dof / 2));
        return cal;
    }

    /**
     * Metodo calcular el valor getTailArea - significancia
     * param  un valor double y una lista de valores
     * @return el valor getTailArea
     */
    public static double getTailArea(double r, ArrayList<Double> arrayList){
        double x = Math.abs(r) * Math.sqrt(arrayList.size() - 2) / Math.sqrt(1 - r * r);
        return 1 - 2 * cal(x, arrayList.size() - 2);
    }

    /**
     * Metodo cal
     * param  dos valores double
     * @return cal
     */
    public static double cal(double x,double dof){
        int num_seg = 10;
        final double E = 0.00001;
        double answer_old = 0, answer_new = 0;
        do{
            double w = x / num_seg;
            answer_old = answer_new;
            answer_new = 0;
            for (int i = 1; i < num_seg; i++){
                if (i % 2 == 0){
                    answer_new += 2 * f(i*w,dof);
                }else{
                    answer_new += 4 * f(i*w,dof);
                }
            }
            answer_new += f(0,dof) + f(x,dof);
            answer_new *= w / 3;
            num_seg *= 2;
        }while(Math.abs(answer_old - answer_new) > E);
        return answer_new;
    }

    /**
     * Metodo getx
     * param  dos valores double
     * @return getx
     */
    public static double getX(double p,double dof){
        double x = 1.0;
        double d = 0.5;
        boolean isBig = false;
        int num_seg = 1000;
        final double E = 0.00000001;
        double answer = 0;
        while(Math.abs(answer - p) > E){
            double w = x / num_seg;
            answer = 0;
            for (int i = 1; i < num_seg; i++){
                if (i % 2 == 0){
                    answer += 2 * f(i*w,dof);
                }else{
                    answer += 4 * f(i*w,dof);
                }
            }
            answer += f(0,dof) + f(x,dof);
            answer *= w / 3;
            if (Math.abs(answer - p) > E){
                if (isBig){
                    if (answer <= p) {
                        d /= 2;
                        isBig = !isBig;
                    }
                    x -= d;
                }else{
                    if (answer >= p) {
                        d /= 2;
                        isBig = !isBig;
                    }
                    x += d;
                }
            }
        }
        return x;
    }

    /**
     * Metodo calular sigma
     * param  dos listas de valores, dos valores double double
     * @return sigma
     */
    public static double getSigma(ArrayList<Double> xArrayList, ArrayList<Double> yArrayList,double b0, double b1){
        ArrayList<Double> cal = new ArrayList<Double>();
        for (int i = 0; i < xArrayList.size(); i++){
            cal.add(yArrayList.get(i) - b0 - b1 * xArrayList.get(i));
        }
        return Math.sqrt(multiple(cal,cal) / (xArrayList.size() - 2));
    }

    /**
     * Metodo calular el rango
     * param  dos listas de valores, dos valores double double
     * @return rango
     */
    public static double getRange(ArrayList<Double> xArrayList, ArrayList<Double> yArrayList,double b0, double b1,double xk){
        double range = getX(0.35, xArrayList.size() - 2) * getSigma(xArrayList, yArrayList, b0, b1);
        ArrayList<Double> cal = new ArrayList<Double>();
        for (int i = 0; i < xArrayList.size(); i++){
            cal.add(xArrayList.get(i) - getAverage(xArrayList));
        }
        return range * Math.sqrt( 1 + (1.0 / xArrayList.size()) + ((xk - getAverage(xArrayList)) * (xk - getAverage(xArrayList)) / multiple(cal,cal)));
    }

    /**
     * Metodo calculo solicitado para el programa 7
     * param  dos listas de valores
     * @return un string con los resultados solicitados.
     */
    public static String calculoPrograma7(ArrayList<Double> xArrayList, ArrayList<Double> yArrayList, double x){
        double xAverage = Estadistica.getAverage(xArrayList);
        double yAverage = Estadistica.getAverage(yArrayList);

        double beta1 = Estadistica.calBeta1(xArrayList,yArrayList,xAverage,yAverage);
        double beta0 = Estadistica.calBeta0(beta1,xAverage,yAverage);
        double r = Estadistica.calR(xArrayList,yArrayList);
        double y = beta0 + beta1 * x;
        double range = Estadistica.getRange(xArrayList, yArrayList, beta0, beta1, x);
        double tailArea = Estadistica.getTailArea(r, xArrayList);


        String resultado = "r:"+r + ",  r^2:"+ r*r + ",  tailArea:"+ tailArea + ",  beta0:"+beta0 +"  beta1:"+beta1+",  yk:"+y+",  Range:"+range+",  UPI:"+(y+range)+",  LPI:"+(y-range);
        return  resultado;
    }

}
