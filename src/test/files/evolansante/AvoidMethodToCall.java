import java.util.List;
import java.util.ArrayList;

import org.apache.commons.io.filefilter.IOFileFilter;


/**
 *This file is the sample code against we run our unit test.
 *It is placed src/test/files in order to not be part of the maven compilation.
 **/
class AvoidMethodToCall {

  

  
  public void aMethod() {
    
      List l = new ArrayList();
      l.remove("0");
      IOFileFilter ff;
      ff.notify();
      
  }
  
  void ml(){};

}
