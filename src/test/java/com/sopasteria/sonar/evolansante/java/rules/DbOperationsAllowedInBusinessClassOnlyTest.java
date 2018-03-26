package com.sopasteria.sonar.evolansante.java.rules;

import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class DbOperationsAllowedInBusinessClassOnlyTest {
    // @Test
    public void detected() {

      // Use an instance of the check under test to raise the issue.
	DbOperationsAllowedInBusinessClassOnly check = new DbOperationsAllowedInBusinessClassOnly();

      

      // Verifies that the check will raise the adequate issues with the expected message.
      // In the test file, lines which should raise an issue have been commented out
      // by using the following syntax: "// Noncompliant {{EXPECTED_MESSAGE}}"
      JavaCheckVerifier.verify("src/test/files/evolansante/DbOperationsAllowedInBusinessClassOnly.java", check);
    }
}
