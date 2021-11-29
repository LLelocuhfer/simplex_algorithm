
package Restriction;
import Table.formulate;

public class Restriction {
public double subscripts[];
    public int inequality;
    public double valuez;
     double solution;
     
        public Restriction(double[] subindicesn,int desigualdadn,double valueObj,double valz) {
         
             subscripts=subindicesn;
        inequality=desigualdadn;
        solution=valueObj;
        valuez=valz;
         ladoDerechoPositivo();
    }

    public double[] getSubindices() {
        return subscripts;
    }

    public int getDesigualdad() {
        return inequality;
    }

    public double getValorZ() {
        return valuez;
    }

    public double getSolution() {
        return solution;
    }

    public void setSubindices(double[] subindices) {
        this.subscripts = subindices;
    }

    public void setDesigualdad(int desigualdad) {
        this.inequality = desigualdad;
    }

    public void setvalueZ(double valueZ) {
        this.valuez = valueZ;
    }

    public void setSolucion(double solution) {
        this.solution = solution;
    }
        
        
        
    public Restriction(String subindicesn, String desigualdadn, String valorObj,double valZ){
        //seccion de subindices
        subscripts=formulate.capture(subindicesn);
        ///SECCION DE SIMBOLO DE DESIGUALDAD
        if(desigualdadn.compareTo("<=") == 0){inequality = -1;}
        if(desigualdadn.compareTo(">=") == 0){inequality = 1;}
        if(desigualdadn.compareTo("=") == 0){inequality = 0;}
        //SECCION DE VALOR OBJETIVO
        solution = Integer.parseInt(valorObj);
        valuez=valZ;

        //Se verifica que el lado derecho sea valor positivo o 0
        ladoDerechoPositivo();
        }

    private void ladoDerechoPositivo(){
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
        

  

