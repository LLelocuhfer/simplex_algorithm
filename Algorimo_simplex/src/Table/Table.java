/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Table;

/**
 *
 * @author qwere
 */

import simplex_algorithm.menssage;
import Table.formulate;
import Table.Problem;
import Restriction.Restriction;

public class Table {
    // indicates the number of variables in the table
    private int NumVariables;
// indicates the number of existing restrictions "table height"
    private int NumRestrictions;
 // indicates the total amplitude value of the table, including additional variables and z
    private int amplitude;
 // the table to be measured to the corresponding changes
    private double table[][];
    //vector que guarda los resultados a partir de la tabla
    protected double result[];
// value of z
    protected double z;
// value of the big M, where M = average right side * thousand
    private double M;
  // vector that indicates which column contains the artificial variable
    private int[] sameCase;
// save a value of one for the row that has =
        public int getNumVariables() {
        return NumVariables;
    }

    public int getNumRestrictions() {
        return NumRestrictions;
    }

    public int getAmplitude() {
        return amplitude;
    }

    public double[][] getTable() {
        return table;
    }

    public double[] getResult() {
        return result;
    }

    public double getZ() {
        return z;
    }

    public double getM() {
        return M;
    }

    public int[] getSamecase() {
        return sameCase;
    }

    public void setNumVariables(int NumVariables) {
        this.NumVariables = NumVariables;
    }

    public void setNumRestricciones(int NumRestrictions) {
        this.NumRestrictions = NumRestrictions;
    }

    public void setAmplitude(int amplitude) {
        this.amplitude = amplitude;
    }

    public void setTable(double[][] table) {
        this.table = table;
    }

    public void setResultado(double[] result) {
        this.result = result;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setM(double M) {
        this.M = M;
    }

    public void setCasoIgual(int[] sameCase) {
        this.sameCase = sameCase;
    }
    /*
     * TABLE CLASS BUILDER
     */
    public Table(Problem problem) {
        calculateM(problem);
        NumRestrictions = problem.restrictions.size();
        sameCase = new int[NumRestrictions];
        NumVariables = maximumNumSubscripts(problem);
        amplitude = NumVariables +Additionalvariables(problem) + 1;
        table = new double[NumRestrictions][amplitude];
        int k = NumVariables;
        for (int i = 0; i < NumRestrictions; i++) {
            //incorporar subindices
            for (int ii = 0; ii < NumVariables; ii++) {
                try {
                    table[i][ii] = problem.restrictions.get(i).subscripts[ii];
                } catch (Exception ex) {
                    table[i][ii] = 0;
                }
            }
           
    // incorporate slack variables
            if (problem.restrictions.get(i).valuez != 1)/* Except in the objective function */ {
                if (variableBySign(problem.restrictions.get(i).inequality) == 1) {
                    table[i][k] = 1;
                    if (problem.restrictions.get(i).inequality == 0)  {
                        table[0][k] = M;
                        sameCase[i] = 1;
                    }
                    k += 1;
                }
                if (variableBySign(problem.restrictions.get(i).inequality) == 2)/en caso de >=/{
                    table[i][k] = -1;
                    table[i][k + 1] = 1;
                    k += 2;
                }
            }
         
            table[i][amplitude - 1] = problem.restrictions.get(i).valuez;
        }
    }
    /*
     *here we can check if when entering values, there are no negatives
     */
    private boolean testOptimity() {
        boolean r = true;
        for (int i = 0; i < table[0].length; i++) {
            if (table[0][i] < 0) {
                r = false;
                break;
            }
        }
        return r;
    }
    private int calculatecolumnpivot() {
        int indexResult = 0;
        double less = table[0][indexResult];
        for (int i = 0; i < table[0].length - 2; i++) {
      if (table[0][i] <= less && table[0][i] < 0) {
                less = table[0][i];
                indexResult = i;
            }
        }
        return indexResult;
    }
    private int calculaterowpivot(int columnPiv) {
        double values[] = new double[NumRestrictions - 1];
        int index[] = new int[NumRestrictions - 1];
        int cont = 0;
        for (int i = 0; i < NumRestrictions - 1; i++) {
            if (table[i + 1][columnPiv] > 0 && table[i + 1][table[0].length - 2] != 0) {

                index[cont] = i + 1;
                values[cont] = Math.abs(table[i + 1][table[0].length - 2] / table[i + 1][columnPiv]);
                msm(" " + Double.toString(table[i + 1][table[0].length - 2]) + " / " + Double.toString(table[i + 1][columnPiv]) + " = " + Double.toString(values[cont]));
                cont += 1;
            }
        }
        double less = values[0];
        int Pivotrow = 1;
        for (int i = 0; i < cont; i++) {
            if (values[i] <= less && values[i] != 0) {
                less = values[i];
                Pivotrow = index[i];
            }
        }
        System.out.println("pivot row = " + Pivotrow);
        return Pivotrow;

    }
    private void simplifyrowPivot(int pivotRow, double pivotNumber) {
        for (int i = 0; i < table[0].length; i++) {
            table[pivotRow][i] = table[pivotRow][i] / pivotNumber;
        }
    }

    
    private void simplifyAllRowPivot(int pivotRow, int pivotColumn) {
        for (int i = 0; i < table.length; i++) {
            if (table[i][pivotColumn] != 0 && i != pivotRow) {
                if (table[i][pivotColumn] > 0) {
 
                    double factor = table[i][pivotColumn] * -1;
                    for (int j = 0; j < table[0].length; j++) {
                        table[i][j] = table[pivotRow][j] * factor + table[i][j];
                    }
                } else {
       
                    double factor = table[i][pivotColumn] * -1;
                    for (int j = 0; j < table[0].length; j++) {
                        table[i][j] = table[pivotRow][j] * factor + table[i][j];
                    }
                }
            }
        }
    }
    private void setResult() {
        System.out.println(" NumVariables = " + NumVariables);
        result = new double[NumVariables];
        int k=0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < NumVariables; j++) {
                if (table[i][j] == 1) {
                    result[j] = table[i][table[0].length - 2];
                    k=j;
                }
            }
        }
        z=table[0][table[0].length - 2];
        System.out.println("");
        for (int i = 0; i < result.length; i++) {
            System.out.println(" x" + (i + 1) + " = " + result[i]);
        }
    }
    public void solveSimplexMethod(boolean actionMax) {
        int iteration = 1;  
           
        try {
            double[] restador = null;
            for (int i = 0; i < sameCase.length; i++) {
                if (sameCase[i] == 1) {
                    System.out.println("hay = en la fila " + i);
                    restador = formulate.earnValues(table[i]);

                    System.arraycopy(table[i],0,restador,0,table[i].length);
                    for (int k = 0; k < restador.length; k++) {
                        restador[k] *= M;
                        table[0][k] -= restador[k];
                    }
                    sameCase[i] = 0;
                    printTable("The great M in iteration" + iteration);
                    iteration += 1;
                }

            }
        } catch (Exception ex1) {
            System.out.println("Error of copy");
            System.out.println(ex1.getCause());
        }
 
        msm("Entering the optimization while");

boolean tieneRespuesta=true;
        while (testOptimity() != true && tieneRespuesta==true ) {
            int columnPivot = calculatecolumnpivot();
            int filaPivote = calculaterowpivot(columnPivot);
            double numeroPivote = table[filaPivote][columnPivot];
            msm("number pivot: " + numeroPivote + "in the position[" + filaPivote + "][" + columnPivot + "]" + " en iteracion " + iteration);
 
            simplifyrowPivot(filaPivote, numeroPivote);
            printTable("simplified pivot row in iteration " + iteration);
 
            simplifyAllRowPivot(filaPivote, columnPivot);
            printTable("Full simplified in iteration " + iteration);
            iteration += 1;
            if(iteration==100){
                tieneRespuesta=false;
                String s="The problem has no solution!"
                        + "\nCheck equations for inconsistencies "
                        + "that may have caused an infinite loop";
                menssage.show(s);
               
            }
        }
    
        printTable(" SIMPLEX RESULT TABLE");
        
            setResult();
   
    }
}
