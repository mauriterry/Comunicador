/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.sistemas.modelo;

/**
 *
 * @author Maru
 */
public class Num_prim {
    
    public Num_prim(int num){
        prim(num);
    }
    private double elapsedTime;
    private void prim(int num){
        if(ValidarDigitos(num)){
            int max = (int) Math.pow(10, num);
            //System.out.println("Se captura timestamp inicial");
            double ti = System.currentTimeMillis();
            contador(max);
            double tf = System.currentTimeMillis();
            this.elapsedTime = tf - ti;
            this.elapsedTime = (this.elapsedTime / 1000.0);
            
            //System.out.println("El tiempo transcurrido es de: " + Double.toString(elapsedTime));
        }else{
            //System.out.println("El digito ingresado es incorrecto\nRecuerde que debe estar entre 2 y 6");
        }
    }
    
    public String getResultado() {
       return Double.toString(elapsedTime);
   }
    
    private int contador(int n){
        int tope = (int) Math.floor(Math.sqrt(n));
        boolean[] primos = new boolean[n + 1];
        for (int i = 2; i <= tope; i++) {
            if (primos[i] == false) {
                for (int j = i; j <= n / i; j++) {
                    primos[j * i] = true;
                }
            }
        }
        int count = 1;
        for (int i = 2; i < n; i++) {
            if (primos[i] == false) {
                count++;
              //  System.out.printf("%10d", i);
            }
            if (count == 10) {
                count = 1;
              //  System.out.println("\n");
            }
        }
        return count;
    }
    
    private boolean ValidarDigitos(int num) {
        boolean nu = false;
        if (num >=2 && num <= 6) {
            nu = true;
        }
        return nu;
    }
}
