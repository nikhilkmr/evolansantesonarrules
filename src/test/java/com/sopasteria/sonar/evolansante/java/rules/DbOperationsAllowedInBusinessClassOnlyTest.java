package com.sopasteria.sonar.evolansante.java.rules;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class DbOperationsAllowedInBusinessClassOnlyTest
{

    /** JAR dependencies for classpath execution */
    private static final List<File> CLASSPATH_JAR;

    static
    {
        // Jar ClassPath construction. Don't use 'ClassLoader.getSystemClassLoader()', because with Maven+Surefire/Jacoco execution, only
        // surefirebooter.jar & jacoco.agent-version-runtime.jar are on classpath => 'old schoold way'
        CLASSPATH_JAR = new ArrayList<>();
        for (String jar : System.getProperty("java.class.path").split(File.pathSeparator))
        {
            if (jar.endsWith(".jar"))
            {
                CLASSPATH_JAR.add(new File(jar));
            }
        }
    }

    //    @Test
    public void detected()
    {

        DbOperationsAllowedInBusinessClassOnly check = new DbOperationsAllowedInBusinessClassOnly();
        // by using the following syntax: "// Noncompliant {{EXPECTED_MESSAGE}}"
        JavaCheckVerifier.verify("src/test/files/evolansante/DbOperationsAllowedInBusinessClassOnly.java", check, CLASSPATH_JAR);
    }
}
