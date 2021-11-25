/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulate;

/**
 *
 * @author qwere
 */
public class formulate {
    private static double termAuxiliary[] = new double[15];
    private static double terms[];
    static int indMax = 0;  //indice maximo en la entrada de datos


    /*
     * OBTENER VALORES
     */
    public static double[] getValues(double [] inputp){
        double[] result=new double[inputp.length];
        for(int i=0;i<inputp.length;i++){
            result[i]=inputp[i];
        }
        return result;
    }


    
    /*
     * Allows you to recount an arrangement to the index value described
     */
    public static double[] cutArray(double[] input, int index) {
        double help[] = new double[index];
        for (int i = 0; i < index; i++) {
            help[i] = input[i];
        }
        return help;
    }

   /*
     * Allows trimming an array to the value of indices described
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
    public static double[] capture(String entrada) {
        for (int n = 0; n < termAuxiliary.length; n++) {
            termAuxiliary[n] = 0;
        }
        indMax = 0;
        String termino = "";
        index = 0;
     
        // insert end point
        entrada = entrada + ":";
        while (entrada.length() - 1 > 0) {

            index = nextSign(entrada);
            termino = entrada.substring(0, index);
            entrada = entrada.substring(index);
            apart(termino);
        }
        terms = new double[indMax];
        System.arraycopy(termAuxiliary, 0, terms, 0, indMax);
        return terms;
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
    private static void apart(String term) {
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
            termAuxiliary[ind - 1] = Double.parseDouble(term.substring(0, term.indexOf('x')));
        }
        if (ind > indMax) {
            indMax = ind;
        }
    }

}
