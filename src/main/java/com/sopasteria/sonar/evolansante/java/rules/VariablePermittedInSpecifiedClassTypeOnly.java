package com.sopasteria.sonar.evolansante.java.rules;

import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ListTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.VariableTree;

@Rule(key = "VariablePermittedInSpecifiedClassTypeOnly")
public class VariablePermittedInSpecifiedClassTypeOnly extends BaseTreeVisitor implements
	JavaFileScanner { 

    private static final String DEFAULT_VALUE_ENCLOSED_CLASS = "org.apache.struts.action.Action";
    private static final String DEFAULT_VALUE_VARIABLE_CLASS = "org.apache.struts.action.ActionForm";

    private JavaFileScannerContext context;

    @RuleProperty(key = "enclosedClass", defaultValue = DEFAULT_VALUE_ENCLOSED_CLASS, description = "Name of the Enclosed Class for instance 'org.apache.struts.action.Action'")
    
    protected String enclosedClass;

    @RuleProperty(key = "variableClass", defaultValue = DEFAULT_VALUE_VARIABLE_CLASS, description = "Name of the variable's class, for instance 'org.apache.struts.action.ActionForm'")
    protected String variableClass;

    @Override
    public void scanFile(JavaFileScannerContext context) {
	this.context = context;

	scan(context.getTree());
    }

    @Override
    public void visitVariable(VariableTree tree) {
	//if(tree.)
	super.visitVariable(tree);
    }
    
    
}
