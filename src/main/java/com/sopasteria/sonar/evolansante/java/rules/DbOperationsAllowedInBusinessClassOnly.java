package com.sopasteria.sonar.evolansante.java.rules;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.java.matcher.MethodMatcher;
import org.sonar.java.model.PackageUtils;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;
import org.sonar.plugins.java.api.tree.PackageDeclarationTree;

@Rule(key = "DbOperationsAllowedInBusinessClassOnly", name = "Database interaction is allowed in business classonly.", description = "Database interaction is allowed in business classonly.", priority = Priority.CRITICAL, tags = {
        "bug_evolansante" })
public class DbOperationsAllowedInBusinessClassOnly extends BaseTreeVisitor implements JavaFileScanner
{
    private static String className  = "com.sopra.mutuelles.businessmodel.impl.com.ISDA";
    private static String methodName = "recordStatement";

    private static String businessPackagekeyword = "business";
    private boolean       isBusinessClass;

    private JavaFileScannerContext context;

    @Override
    public void scanFile(JavaFileScannerContext context)
    {
        this.context = context;

        scan(context.getTree());
    }

    @Override
    public void visitPackage(PackageDeclarationTree tree)
    {
        String packageName = PackageUtils.packageName(tree, ".");
        if (packageName.contains(businessPackagekeyword))
        {
            isBusinessClass = true;
        }
        super.visitPackage(tree);
    }

    @Override
    public void visitMethodInvocation(MethodInvocationTree invocationTree)
    {

        if (!isBusinessClass)
        {
            MethodMatcher methodToAvoid = MethodMatcher.create().typeDefinition(className).name(methodName).withAnyParameters();
            if (methodToAvoid.matches(invocationTree))
            {
                context.reportIssue(this, invocationTree, "Ewww... how can you do that man !!! Database operations are allowed in business class only.");
            }
        }

        super.visitMethodInvocation(invocationTree);

    }

}
