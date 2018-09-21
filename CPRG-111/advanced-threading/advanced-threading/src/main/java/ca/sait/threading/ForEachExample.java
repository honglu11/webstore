package ca.sait.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForEachExample extends BaseThreadExample{
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
	  new ForEachExample().run();
	}
		
	public void run() {
		//final ArrayList<Integer> arrays = new ArrayList<>(100); // don't change to double 
		final List<String> dobs = generateDOBS() ;
//		for (int i = 0; i < 110; i++) {
//			//arrays.add(new Integer(i));
//			arrays.add(Integer.valueOf(i));
//		}
		
		logger.info("Populated arrays");		
		//arrays.forEach(i -> logger.info("I = {}", i));
		
		//final Stream<Integer> stream;
		final Stream<String> stream;
		if (dobs.size() < 100) 
			stream = dobs.stream();
		    //stream = arrays.stream();
		else
			stream = dobs.parallelStream();
		    //stream = arrays.parallelStream();
		
		
//		if (arrays.size() < 100) 
//			stream = dobs.stream();
//		    //stream = arrays.stream();
//		else
//			stream = dobs.parallelStream();
//		    //stream = arrays.parallelStream();
		//arrays.parallelStream().forEach(i -> logger.info("I = {}", i)); // paralelStream is multiplethread, add lots of overhead at the begining
		//stream.sorted().sequential().sorted().forEach(i -> logger.info("I = {}", i)); // if put i<50, in order use steam only, if i<110 use 
		stream.sorted().sequential().sorted().forEach(dob -> logger.info("dob = {}", dob)); 

	}


}
