package ca.sait;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListTest {

	public static void main(String[] args) {
		// ctl + shift + o, import, bad performance
        ArrayList strings = new ArrayList(); 
        
        strings.add("Test");
        strings.add("hello");
        strings.add(1);
        strings.add(1.0);
        
        for (final Object s: strings) {
        	System.out.println(s);
        }
        
        // the second String is optional
        ArrayList<String> strings1 = new ArrayList<String>(10); // if put the 10, the array has size 10, but if not all 10 initialize, it only print the initialize one, if know size, will be ok, if not, performance is not good.
        LinkedList<String> stringsLinked = new LinkedList<>();
        strings1.add("Test");
        strings1.add("hello");
        strings1.remove("Test");
        strings1.add("Test");
        
        strings.get(1);
        
        for (final String s: strings1) {
        	System.out.println(s);
        }
        
        // can not use primitive type as following, primitive type cannot assign null value like int a = null; but Integer object can assign null like Integer j = null;
        // ArrayList<int> strings2 = new ArrayList<>(); 
        // use Integer - object instead;
        ArrayList<Integer> strings3 = new ArrayList<>();
        
        Integer j = null;
        int k=j;
        Integer l =k; //( switch back get 0 ); don't use this one at all.
        
        stringsLinked.add("Test");
        stringsLinked.add("3214");
        
        // linda express can build the dynamic method
        strings1.forEach(s-> {System.out.println(s);});
        
        strings1.forEach(System.out::println);
        
        // for ArrayList if has size, better than linkList performance, since linkList never has size, and retrieve from index, ArrayList is better like strings.get(2)
        

        
        
       
	}

}
