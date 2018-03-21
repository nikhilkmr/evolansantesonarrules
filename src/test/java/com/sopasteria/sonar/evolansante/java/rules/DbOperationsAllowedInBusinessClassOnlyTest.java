package com.sopasteria.sonar.evolansante.java.rules;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class DbOperationsAllowedInBusinessClassOnlyTest
{
    @Test
    public void detected()
    {

        DbOperationsAllowedInBusinessClassOnly check = new DbOperationsAllowedInBusinessClassOnly();
        // by using the following syntax: "// Noncompliant {{EXPECTED_MESSAGE}}"
        JavaCheckVerifier.verify("src/test/files/evolansante/DbOperationsAllowedInBusinessClassOnly.java", check);
    }
}
