/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulas;

/**
 *
 * @author qwere
 */
public class formulas {
    private static double terminosAuxiliar[] = new double[15];
    private static double terminos[];
    static int indMax = 0;  //indice maximo en la entrada de datos


    /*
     * OBTENER VALORES
     */
    public static double[] obtenerValores(double [] entrada){
        double[] resultado=new double[entrada.length];
        for(int i=0;i<entrada.length;i++){
            resultado[i]=entrada[i];
        }
        return resultado;
    }


    /*
     * Permite recontar un arreglo al valor de indice descrito
     */
    public static double[] recortarArreglo(double[] entrada, int indice) {
        double ayuda[] = new double[indice];
        for (int i = 0; i < indice; i++) {
            ayuda[i] = entrada[i];
        }
        return ayuda;
    }

    /*
     * Permite recortar una matriz al valor de indices descritos
     */
    public static double[][] cutMatrix(double[][] input, int indx, int indy) {
        double ayuda[][] = new double[indx][indy];
        for (int i = 0; i < indx; i++) {
            for (int ii=0;ii<indy;ii++){
            ayuda[i][ii] = input[i][ii];
            }
        }
        return ayuda;
    }

    // CHARACTER CHAIN ​​CAPTURE SECTION
    static int index = 0;

    /*
     * 
Allows you to capture the values ​​of a series of characters
    symbolizing a term set
     */
    public static double[] capturar(String entrada) {
        for (int n = 0; n < terminosAuxiliar.length; n++) {
            terminosAuxiliar[n] = 0;
        }
        indMax = 0;
        String termino = "";
        index = 0;
        //insercion del punto final
        entrada = entrada + ":";
        while (entrada.length() - 1 > 0) {

            index = nextSign(entrada);
            termino = entrada.substring(0, index);
            entrada = entrada.substring(index);
            separar(termino);
        }
        terminos = new double[indMax];
        System.arraycopy(terminosAuxiliar, 0, terminos, 0, indMax);
        return terminos;
    }

    /**
 
        * It allows to find the index of the following sign
     * @param input: equation in play
     * @return n: index of the sign or beginning of the next term
     */
    private static int nextSign(String input) {
        int nn = 0;
        for (int i = 1; i <= input.length() - 1; i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == ':') {
                nn = i;
                i = input.length();
            }
        }
        return nn;
    }

    /*
     * It allows to separate in Sub-index and exponent to the same term
     * @param term: end of the equation
     */
    private static void separate(String term) {
        int ind = 0;
        try {
            
            if (term.charAt(0) == '+') {
                term = term.substring(1);
            }
            if (term.charAt(0) == 'x') {
                term = "1" + term;
            }
            if (term.charAt(0) == '-' && term.charAt(1) == 'x') {
                term = "-1" + term.substring(1);
            }
        } catch (Exception ex) {
            System.out.println("ERROR DE TERMINO en separar()");
        }

        //2x1
        if (term.contains("x")) {
            ind = Integer.parseInt(term.substring(term.indexOf('x') + 1));
            terminosAuxiliar[ind - 1] = Double.parseDouble(term.substring(0, term.indexOf('x')));
        }
        if (ind > indMax) {
            indMax = ind;
        }
    }

}

