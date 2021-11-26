/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

/**
 *
 * @author qwere
 */
public class formulate {
    private static double termsAuxiliary[] = new double[15];
    private static double terms[];
    static int indMax = 0;  

/*
     * GET VALUES
     */
    public static double[] earnValues(double [] input){
        double[] result=new double[input.length];
        for(int i=0;i<input.length;i++){
            result[i]=input[i];
        }
        return result;
    }

/*
     * Allows you to recount an array to the described index value
     */
    public static double[] cutArray(double[] entrada, int indice) {
        double ayuda[] = new double[index];
        for (int i = 0; i < index; i++) {
            ayuda[i] = entrada[i];
        }
        return ayuda;
    }

    /*
     * It allows trimming an array to the value of the indices described
     */
    public static double[][] cutMatrix(double[][] input, int indexx, int indexy) {
        double help[][] = new double[indexx][indexy];
        for (int i = 0; i < indexx; i++) {
            for (int ii=0;ii<indexy;ii++){
            help[i][ii] = input[i][ii];
            }
        }
        return help;
    }

  // CHARACTER CHAIN ​​CAPTURE SECTION
    static int index = 0;
    /*
     * Allows you to capture the values ​​of a series of characters
    symbolizing a term set
     */
    public static double[] capture(String input) {
        for (int n = 0; n < termsAuxiliary.length; n++) {
            termsAuxiliary[n] = 0;
        }
        indMax = 0;
        String term = "";
        index = 0;
        //insercion del punto final
        input = input + ":";
        while (input.length() - 1 > 0) {

            index = nextSign(input);
            term = input.substring(0, index);
            input = input.substring(index);
            separar(term);
        }
        terms = new double[indMax];
        System.arraycopy(termsAuxiliary, 0, terms, 0, indMax);
        return terms;
    }

   /*
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
   * end of the equation
     */
    private static void separar(String term) {
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
            System.out.println("TERMINATION ERROR in separating ()");
        }

        //2x1
        if (term.contains("x")) {
            ind = Integer.parseInt(term.substring(term.indexOf('x') + 1));
            termsAuxiliary[ind - 1] = Double.parseDouble(term.substring(0, term.indexOf('x')));
        }
        if (ind > indMax) {
            indMax = ind;
        }
    }

}
