package com.sopasteria.sonar.evolansante.java.rules;

import java.util.List;

import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ListTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.VariableTree;

import com.google.common.collect.ImmutableList;

@Rule(key = "VariablePermittedInSpecifiedClassTypeOnly")
public class VariablePermittedInSpecifiedClassTypeOnly extends IssuableSubscriptionVisitor//BaseTreeVisitor implements JavaFileScanner 
{ 
//    public static final List<String> SUPER_CLASS_AVOID = ImmutableList.of("org.slf4j.Logger");
//
//    private static final String DEFAULT_VALUE_ENCLOSED_CLASS = "org.apache.struts.action.Action";
//    private static final String DEFAULT_VALUE_VARIABLE_CLASS = "org.apache.struts.action.ActionForm";
//
//    private JavaFileScannerContext context;
//
//    @RuleProperty(key = "enclosedClass", defaultValue = DEFAULT_VALUE_ENCLOSED_CLASS, description = "Name of the Enclosed Class for instance 'org.apache.struts.action.Action'")
//    
//    protected String enclosedClass;
//
//    @RuleProperty(key = "variableClass", defaultValue = DEFAULT_VALUE_VARIABLE_CLASS, description = "Name of the variable's class, for instance 'org.apache.struts.action.ActionForm'")
//    protected String variableClass;
//    
//    private List<String> enclosedClasses;
//    private List<String> variableClasses;
//
//    @Override
//    public void scanFile(JavaFileScannerContext context) {
//	this.context = context;
//	enclosedClasses = ImmutableList.of(enclosedClass);
//	variableClasses = ImmutableList.of(variableClass);
//	
//	scan(context.getTree());
//    }
//
//    @Override
//    public void visitVariable(VariableTree tree) {
//	//if(tree.)
//	super.visitVariable(tree);
//	System.out.println(tree);
//    }
    
    @Override
    public List<Tree.Kind> nodesToVisit() {
      // Register to the kind of nodes you want to be called upon visit.
      return ImmutableList.of(Tree.Kind.VARIABLE);
    }

    @Override
    public void visitNode(Tree tree) {
	System.out.println(tree);
    }
    
    
}
