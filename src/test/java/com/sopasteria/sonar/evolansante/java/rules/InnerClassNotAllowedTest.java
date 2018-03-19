package com.sopasteria.sonar.evolansante.java.rules;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class InnerClassNotAllowedTest {
    @Test
    public void detected() {

	InnerClassNotAllowed check = new InnerClassNotAllowed();
	// by using the following syntax: "// Noncompliant {{EXPECTED_MESSAGE}}"
	JavaCheckVerifier.verify(
		"src/test/files/evolansante/InnerClassNotAllowed.java", check);
    }
}
