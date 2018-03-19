package com.sopasteria.sonar.evolansante.java.rules;

import java.util.List;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.StaticInitializerTree;
import org.sonar.plugins.java.api.tree.Tree;

import com.google.common.collect.ImmutableList;

@Rule(key = "StaticBlockNotAllowed", name = "Use of static block is prohibited.", description = "O! Man, don't you know that use of static block is prohibited in this project. If you are not sure how to avoid it then, talk to your team.", priority = Priority.CRITICAL, tags = {
"bug" })
public class StaticBlockNotAllowed extends IssuableSubscriptionVisitor {
    
    @Override
    public List<Tree.Kind> nodesToVisit() {
	// Register to the kind of nodes you want to be called upon visit.
	return ImmutableList.of(Tree.Kind.STATIC_INITIALIZER);
    }

    @Override
    public void visitNode(Tree tree) {
	StaticInitializerTree staticInitializerTree = (StaticInitializerTree) tree;
	
	reportIssue(tree, "O! Man, don't you know that use of static block is prohibited in this project. If you are not sure how to avoid it then, talk to your team.");

    }
}
