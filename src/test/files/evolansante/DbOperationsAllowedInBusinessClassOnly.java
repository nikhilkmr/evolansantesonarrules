package mypackage.pak1.pak2;

import java.sql.Connection;

public class DbOperationsAllowedInBusinessClassOnly {
    
    public void method() {
	Class c = getClass();
	c.getCanonicalName();
    }
    
}