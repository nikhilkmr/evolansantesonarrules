/*
 * Creation : 20 avr. 2015
 */
package org.sonar.samples.java;

import org.slf4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.taglib.bean.CookieTag;
/**
 * A class with extends another class outside the JVM but in classpath
 */
public class AvoidSuperClassCheck extends ActionForm { // Noncompliant {{The usage of super class org.slf4j.Logger is forbidden}}

    CookieTag gh;
  protected AvoidSuperClassCheck(String name) {
    super(name);
  }

}
