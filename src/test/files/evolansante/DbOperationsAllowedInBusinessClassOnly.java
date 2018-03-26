package mypackage.pak1.pak2;

import java.sql.Connection;
import java.util.HashMap;

import com.sopra.mutuelles.businessmodel.impl.com.ISDA;

public class DbOperationsAllowedInBusinessClassOnly {
    
    public void method(ISDA com, HashMap<String, String> m) {
	
	com.recordStatement("recordName", "order", ISDA.NONE);
	m.put("", "");
	
    }
    
}