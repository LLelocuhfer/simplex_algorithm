 
package Restriction;
import Table.formulate;

public class Restriction {
public double subscripts[];
    public int inequality;
    public double valuez;
     double solution;
     
        public Restriction(double[] subscriptsn,int inequalityn,double valueObj,double valz) {
         
             subscripts=subscriptsn;
        inequality=inequalityn;
        solution=valueObj;
        valuez=valz;
         positiVerightSide();
    }
        
    public Restriction(String subindicesn, String inequalityn, String valorObj,double valZ){
        //seccion de subindices
        subscripts=formulate.capture(subindicesn);
        ///SECCION DE SIMBOLO DE DESIGUALDAD
        if(inequalityn.compareTo("<=") == 0){inequality = -1;}
        if(inequalityn.compareTo(">=") == 0){inequality = 1;}
        if(inequalityn.compareTo("=") == 0){inequality = 0;}
        //SECCION DE VALOR OBJETIVO
        solution = Integer.parseInt(valorObj);
        valuez=valZ;

        //Se verifica que el lado derecho sea valor positivo o 0
        positiVerightSide();
        }

    private void positiVerightSide(){
        if(solution<0){
            solution*=-1;
            inequality*=-1;
            for(int i=0;i<subscripts.length;i++){
               if(subscripts[i]!=0){
                    subscripts[i]*=-1;
                }
            }
        }
        }
    }
        

  


