package com.sopasteria.sonar.evolansante.java.rules;

import java.lang.String;

import org.apache.struts.action.ActionForm;

public class VariablePermittedInSpecifiedClassTypeOnly {

    ActionForm str; // Noncompliant
    Map<String, ActionForm> map;

}
