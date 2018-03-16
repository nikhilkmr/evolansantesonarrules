package com.sopasteria.sonar.evolansante.java.rules;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class VariablePermittedInSpecifiedClassTypeOnlyTest {
    
    /** JAR dependencies for classpath execution */
    private static final List<File> CLASSPATH_JAR;

    static {
      // Jar ClassPath construction. Don't use 'ClassLoader.getSystemClassLoader()', because with Maven+Surefire/Jacoco execution, only
      // surefirebooter.jar & jacoco.agent-version-runtime.jar are on classpath => 'old schoold way'
      CLASSPATH_JAR = new ArrayList<>();
      for (String jar : System.getProperty("java.class.path").split(File.pathSeparator)) {
        if (jar.endsWith(".jar")) {
          CLASSPATH_JAR.add(new File(jar));
        }
      }
    }
    
    @Test
    public void detected() {

      // Use an instance of the check under test to raise the issue.
	VariablePermittedInSpecifiedClassTypeOnly check = new VariablePermittedInSpecifiedClassTypeOnly();

      // define the forbidden annotation name
//      check.enclosedClass = "org.apache.struts.action.Action";
//      check.variableClass = "org.apache.struts.action.ActionForm";

      // Verifies that the check will raise the adequate issues with the expected message.
      // In the test file, lines which should raise an issue have been commented out
      // by using the following syntax: "// Noncompliant {{EXPECTED_MESSAGE}}"
      JavaCheckVerifier.verify("src/test/files/evolansante/VariablePermittedInSpecifiedClassTypeOnly.java", check, CLASSPATH_JAR);
    }

}
