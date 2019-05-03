import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
	public static void main(String[] args) {
	    
		// String to be scanned to find the pattern.
	 Scanner scanner = new Scanner(System. in); 
     System.out.println("Input first String:");
     String line = scanner. nextLine();
      //String line = "aaa";
	 System.out.println("Input second String:");
     String line2 = scanner. nextLine();
     // String line2 = "a*";
      boolean result = stringPatternMatch(line, line2);
      if(result){
          System.out.println("true");
      }else{
          System.out.println("false");
      }
	}
	
	public static boolean stringPatternMatch(String mainString, String pattern){
	    
	  String createdPattern = "";
      
      for(int i=0; i<pattern.length(); i++){
          
          if(pattern.charAt(i)=='.'){
              createdPattern += "(.)";
          }else if(pattern.charAt(i)=='*'){
              createdPattern += "(.*)";
          }else {
              createdPattern += pattern.charAt(i);
          }
          
      }

      // Create a Pattern object
      Pattern r = Pattern.compile(createdPattern);

      // Now create matcher object.
      Matcher m = r.matcher(mainString);
      boolean matchFound = false;
      if (m.find( )) {
          if(m.group(0)==mainString){
              matchFound = true;
          }
         
      }else {
         //System.out.println("NO MATCH");
      }
      
      if(matchFound){
          //System.out.println("true");
          return true;
      }else{
          if(pattern.length()>1){
              return stringPatternMatch(mainString,pattern.substring(1,pattern.length()-1));
          }
      }
        return false;
	}
}

