package com.sopasteria.sonar.evolansante.java.rules;

import java.util.List;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

import com.google.common.collect.ImmutableList;

@Rule(key = "InnerClassNotAllowed", name = "Use of inner class is prohibited.", description = "Oh! boy, dont you know that use of inner class is prohibited in this project.if you are not sure how to avoid it then, talk to the smart guy of your team.", priority = Priority.CRITICAL, tags = {
"bug" })
public class InnerClassNotAllowed extends IssuableSubscriptionVisitor {

    @Override
    public List<Tree.Kind> nodesToVisit() {
	// Register to the kind of nodes you want to be called upon visit.
	return ImmutableList.of(Tree.Kind.CLASS);
    }

    @Override
    public void visitNode(Tree tree) {
	ClassTree classTree = (ClassTree) tree;
	if (!classTree.parent().is(Kind.COMPILATION_UNIT))
	    reportIssue(tree, "Oh! boy, dont you know that use of inner class is prohibited in this project.if you are not sure how to avoid it then, talk to the smart guy of your team.");

    }
}
