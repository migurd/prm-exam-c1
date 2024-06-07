package com.example.prm_examen_c1;

public class Calculadora {
    private float num1;
    private float num2;

    public Calculadora(float num1, float num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Calculadora() {
        this.num1 = 0.00f;
        this.num2 = 0.00f;
    }

    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }

    public float suma() {
        return num1 + num2;
    }

    public float resta() {
        return num1 - num2;
    }

    public float multiplicacion() {
        return num1 * num2;
    }

    public float division() {
        return num1 / num2;
    }
}
