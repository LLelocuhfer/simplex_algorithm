package algorimo_simplex;

public class Algorimo_simplex {

    
    public static void main(String[] args) {
        simplex_vista v = new simplex_vista ();
            v.setVisible(true );
        
package Metodos;

public class Metodos {
    private static double aux [] = new double [15 ]; 
    private static double term [];
    static int maximizar = 0 ; 
    private static int indice;
   
    public static double  [ ] capturar (String entrada)
    {
        int n ; 
        for ( n=0 ; n< aux.length ;n++)
        {
            aux [n]=0 ; 
        }
         maximizar = 0;
        String termino = "";
        indice = 0;
        //insercion del punto final
        entrada = entrada + ":";
        while (entrada.length() - 1 > 0) {

            indice = signo(entrada);
            termino = entrada.substring(0, indice);
            entrada = entrada.substring(indice);
            separar(termino);
        }
        term = new double[maximizar];
        System.arraycopy(aux, 0, term, 0, maximizar);
        return term;
        
    }
    
    
    
      private static int signo(String entrada) {
        int nn = 0;
        for (int i = 1; i <= entrada.length() - 1; i++) {
            if (entrada.charAt(i) == '+' || entrada.charAt(i) == '-' || entrada.charAt(i) == ':') {
                nn = i;
                i = entrada.length();
            }
        }
        return nn;
    }

      
      
    private static void separar(String termino) {
        int ind = 0;
        try {
            if (termino.charAt(0) == '+') {
                termino = termino.substring(1);
            }
            if (termino.charAt(0) == 'x') {
                termino = "1" + termino;
            }
            if (termino.charAt(0) == '-' && termino.charAt(1) == 'x') {
                termino = "-1" + termino.substring(1);
            }
        } catch (Exception ex) {
            System.out.println("ERROR DE TERMINO en separar()");
        }

     
        if (termino.contains("x")) {
            ind = Integer.parseInt(termino.substring(termino.indexOf('x') + 1));
            aux [ind - 1] = Double.parseDouble(termino.substring(0, termino.indexOf('x')));
        }
        if (ind > maximizar) {
            maximizar = ind;
        }
    }
    
    
}

    }
    
}
