
package regularExpression;

import java.util.regex.Pattern;

/**
 *
 * @author Hancie Phago
 */

public class RegularExpression {
    
    public boolean isInteger(String contentString){
        String patternString = "[0-9]+";
        Pattern pattern = Pattern.compile(patternString);        
        boolean isMatch = pattern.matcher(contentString).matches();
        return isMatch;
    }
    
    public boolean isFloat(String contentString){        
        String patternString = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";
        Pattern pattern = Pattern.compile(patternString);        
        boolean isMatch = pattern.matcher(contentString).matches();
        return isMatch;
    }
    
    public boolean isAlphabets(String contentString){        
        //String patternString = "^[a-zA-Z]*$";
        String patternString = "^[a-zA-Z\\s]+";
        Pattern pattern = Pattern.compile(patternString);        
        boolean isMatch = pattern.matcher(contentString).matches();
        return isMatch;
    }
    
    public boolean isEmail(String contentString){        
        String patternString = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(patternString);        
        boolean isMatch = pattern.matcher(contentString).matches();
        return isMatch;
    }
    
}
