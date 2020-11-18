package com.example.no_brain___my_pain.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "pain")
public class Pain implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    private double operand_1;
    private double operand_2;
    private double result;
    private char operation;

    public int getId(){
        return id;
    }

    public double getOperand_1(){
        return operand_1;
    }

    public double getOperand_2(){
        return operand_2;
    }

    public double getResult(){
        return result;
    }

    public char getOperation(){
        return operation;
    }

    public void setId(@NonNull int _id){
        this.id = _id;
    }

    public void setOperand_1(double op1){
        this.operand_1 = op1;
    }

    public void setOperand_2(double op2){
        this.operand_2 = op2;
    }

    public void setResult(double res){
        this.result = res;
    }

    public void setOperation(char op){
        this.operation = op;
    }

}
