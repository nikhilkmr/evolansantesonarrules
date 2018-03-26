package com.sopasteria.sonar.evolansante.java.rules;

public class InnerClassNotAllowed
{

    Runnable annonymousClass = new Runnable() { // Noncompliant

        @Override
        public void run()
        {
            // TODO Auto-generated method stub

        }
    };

    class classInClass // Noncompliant
    { 

    }

    public void method()
    {
        class ClassInMethod // Noncompliant
        { 

        }
    }

}