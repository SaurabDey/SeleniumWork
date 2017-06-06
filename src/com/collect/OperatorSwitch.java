package com.collect;

import java.util.HashMap;
import java.util.Map;


public class OperatorSwitch {
  
  private Map<Character, Character> operatorMap = new HashMap<Character, Character>();
  
  public OperatorSwitch() {
    operatorMap.put('+', '*');
    operatorMap.put('-', '/');
    operatorMap.put('*', '+');
    operatorMap.put('/', '-');
  }

  public String switchOperators(String input) {
    System.out.println("\ninput = " + input);
    char[] charArray = new char[input.length()]; 
    input.getChars(0, input.length(), charArray, 0);
    for(int i = 0; i < charArray.length; i++) {
      if(operatorMap.containsKey(charArray[i])){
        charArray[i] = operatorMap.get(charArray[i]);
      }
    }
    String output = new String(charArray);
    System.out.println("output = " + output);
    return output;
  }
  
  public static void main(String[] args) {
    OperatorSwitch os = new OperatorSwitch();
    String output = os.switchOperators("125+83-55*120");
    String output1 = os.switchOperators(output);
    os.switchOperators(output1);
  }
}
