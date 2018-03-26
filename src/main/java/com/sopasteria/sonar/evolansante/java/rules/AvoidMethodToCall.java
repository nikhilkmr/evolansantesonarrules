package com.sopasteria.sonar.evolansante.java.rules;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.java.matcher.MethodMatcher;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;

/*
 * Nikhil Kumar
 */
@Rule(key = "AvoidMethodToCall", name = "Specified methods of given class is not allowed in EvolanSante.", description = "Specified methods of given class is not allowed in EvolanSante.", priority = Priority.CRITICAL, tags = {
        "bug_evolansante" })
public class AvoidMethodToCall extends BaseTreeVisitor implements JavaFileScanner
{

    private static final String DEFAULT_VALUE_CLASS  = "java.util.ArrayList";
    private static final String DEFAULT_VALUE_METHOD = "remove";

    private JavaFileScannerContext context;

    @RuleProperty(key = "className", defaultValue = DEFAULT_VALUE_CLASS, description = "Name of the Class for which a method to be avoided for instance 'ArrayList'")
    protected String className;

    @RuleProperty(key = "methodName", defaultValue = DEFAULT_VALUE_METHOD, description = "Name of the method of specified class, for instance 'remove'")
    protected String methodName;

    @Override
    public void scanFile(JavaFileScannerContext context)
    {
        this.context = context;

        scan(context.getTree());
    }

    @Override
    public void visitMethodInvocation(MethodInvocationTree tree)
    {
        super.visitMethodInvocation(tree);
        MethodMatcher methodToAvoid = MethodMatcher.create().typeDefinition(className).name(methodName).withAnyParameters();

        if (methodToAvoid.matches(tree))
        {
            context.reportIssue(this, tree, "Arrrr... " + DEFAULT_VALUE_METHOD + " of " + DEFAULT_VALUE_CLASS +" is strictly not allowed to use.");

        }
    }
}
