/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;


import java.awt.List;
import java.util.ArrayList;
import Restriction.Restriction;


/**
 *
 * @author qwere
 */
public class Problem {
    Table process;
   boolean  actionMax; //maximizar = true , minimizar = false
    ArrayList<Restriction> restrictions = new ArrayList<Restriction>();

   public Problem(boolean max){
       actionMax=max;
   }

    public void newRestriction(String subindicesn,String desigualdadn,String valorObjn){
        try{
        restrictions.add(new Restriction(subindicesn, desigualdadn, valorObjn,0));
        }catch(Exception ex){System.out.println("Restriction problem "+restrictions.size());}
        }

    public void setFunctionObjective(double[] funcObj){
         for(int i=0;i<funcObj.length;i++){
             try{
            funcObj[i] = funcObj[i] * -1;
             }catch(Exception ex){
             System.out.println("Error in Problema.setFuncionObjetivo");
             }
         }
        restrictions.add(new Restriction(funcObj, 0, 0, 1));
    }

/*
 * prepara el problema
 */
    public void prepare(){
        process=new Table(this);
        process.imprimirTabla("PREPARATION PHASE ");
    }

    public void solveMethodSimplex(List list) {
        process.solveSimplexMethod(actionMax);
        //mensaje("numero de resultados . "+proceso.resultado.length);
        for(int i=0;i<process.result.length;i++){
                list.add(" x"+(i+1)+" = "+process.result[i]);
        }
        list.add(" z = "+process.z);
    }

    public void deleteAll(){
     restrictions.clear();
     message("The problem has been cleared ");
    }

    public void printAll(){
          System.out.println("Objective Function");
             System.out.println("Restrictions");
        for (int i=0;i<restrictions.size();i++){
            System.out.println("    restriccion "+(i+1));
            System.out.println("  subscripts");
            for(int j=0;j<restrictions.get(i).subscripts.length;j++){
              System.out.print(restrictions.get(i).subscripts[j]+"  ,  ");
            }
            System.out.println("    inequality");
            System.out.println(restrictions.get(i).inequality);
            System.out.println("    values");
      //      System.out.println(restrictions.get(i).solucion);
        }


    }

    private void message(String msm){
        System.out.println("::::::::::Information:::::::: ");
        System.out.println(" : --> " + msm);
        System.out.println("");
    }


}
