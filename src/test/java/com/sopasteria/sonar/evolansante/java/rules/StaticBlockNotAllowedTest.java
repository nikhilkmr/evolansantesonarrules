package com.sopasteria.sonar.evolansante.java.rules;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class StaticBlockNotAllowedTest {

    @Test
    public void detected() {

      StaticBlockNotAllowed check = new StaticBlockNotAllowed();
      
      JavaCheckVerifier.verify("src/test/files/evolansante/StaticBlockNotAllowed.java", check);
    }
}
