/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.disenio.rest.model;



public class Visita {
    private String sal;
    private String exp;
    private String tem;
    private String ubi;

    public Visita() {
    }
    

    public Visita(String sal, String exp, String tem, String ubi) {
        this.sal = sal;
        this.exp = exp;
        this.tem = tem;
        this.ubi = ubi;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String getUbi() {
        return ubi;
    }

    public void setUbi(String ubi) {
        this.ubi = ubi;
    }

    @Override
    public String toString() {
        return "Room{" + "sal=" + sal + ", exp=" + exp + ", tem=" + tem + ", ubi=" + ubi + '}';
    }
    
}
