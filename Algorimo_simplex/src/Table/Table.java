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
}
