
import java.util.ArrayList;
import java.lang.*;

// Feel free to add any other imports

public class CombObjects{

    public static ArrayList<String> getLexPerm(String str) {

	// initiate and allocate enough room for all elements needed
	ArrayList<String> result = new ArrayList<String>();
	ArrayList<String> temp = new ArrayList<String>();

	if (str.length() > 1) {
		for (int i = 0; i < str.length(); i++) {
			char lastc = str.charAt(i);
	
                        // create new string without character at index i
                        String s = str.substring(0, i) + str.substring(i+1);

	    	        // get Lex Permutation of new string
			temp = getLexPerm(s);

			// add removed character to each string in temp list
			for (int j = 0; j < temp.size(); j++) {
				result.add(lastc + temp.get(j));
			}
		}

	}
	else {
		result.add(str);
	}
	 return result;

    }

    public static ArrayList<String> getMinChgPerm(String str) {

	ArrayList<String> result = new ArrayList<String>();
	ArrayList<String> temp = new ArrayList<String>();   

        if (str.length() >= 1) {
            char x = str.charAt(str.length()-1);                        // get last char
            String s = str.substring(0, str.length() - 1);

            // get permutations of new string;
            temp = getMinChgPerm(s);

	    boolean r2l = true;						// which direction to iterate thru string
			                                                // when iterating through string, alternate direction 
            for (int j = 0; j < temp.size(); j++) {

                String temp_s = temp.get(j);

	    	if (r2l) {
                        // insert removed char into string at each position right to left
	                for (int l = temp_s.length(); l >= 0; l--) {
                            String new_s = temp_s.substring(0,l) + x;

                            if (l != temp_s.length()) {
                                new_s += temp_s.substring(l);
                            }
	                    result.add(new_s);
	                }
		} else {
                        // insert removed char into string again, left to right
		        for (int k = 0; k < temp_s.length() + 1; k++) {
                                    String new_s = temp_s.substring(0,k) + x;
                                    if (k != temp_s.length()) {
                                        new_s += temp_s.substring(k);
                                    }
				    result.add(new_s);
			}
		}
		r2l = !r2l;
            }
        }
        else {
            result.add(str);
        }
        return result;
    }
       
}
