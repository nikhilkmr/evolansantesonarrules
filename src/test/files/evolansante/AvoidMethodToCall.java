import java.util.ArrayList;


/**
 *This file is the sample code against we run our unit test.
 *It is placed src/test/files in order to not be part of the maven compilation.
 **/
class AvoidMethodToCall {

  

  
  public void aMethod() {
    
      ArrayList list = new ArrayList();
      list.remove(0); // Noncompliant
      
      
  }
  
  

}
