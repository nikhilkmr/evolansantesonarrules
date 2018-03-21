package com.sopasteria.sonar.evolansante.java.rules;



public class DbOperationsAllowedInBusinessClassOnly {
    
    
    public void method() {
        Class c = this.getClass();
        c.getName();
        com.recordStatement();
    }
}