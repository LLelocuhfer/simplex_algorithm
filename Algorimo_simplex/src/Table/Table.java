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
}
