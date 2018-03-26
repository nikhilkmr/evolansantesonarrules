package com.sopasteria.sonar.evolansante.java.rules;

import com.sopra.mutuelles.businessmodel.impl.com.ISDA;
import com.sopra.mutuelles.businessmodel.impl.com.ISDATP;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;

public class DbOperationsAllowedInBusinessClassOnly {
    
    
    public void method(ISDA com,HttpServletRequest request ) {
        Class c = this.getClass();
        c.getName();

        com.recordStatement(request); //Noncompliant

    }
}