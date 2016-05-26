package iut.valence.behindbars.character;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Map;



public class NPCsTalks {
	
	public static Map<String,ArrayList<String>> NPCsTalks;
	public static ArrayList<String> talks;
	
	 public static ArrayList<String> add(File file) {
		    try {
		       BufferedInputStream readder = new BufferedInputStream(new FileInputStream(file));
		       StringWriter writter = new StringWriter();
		       int test;
		       while ((test=readder.read()) != -1){
		           writter.write(test);
		       }
		       writter.flush();
		       writter.close();
		       readder.close();
		       talks.add(writter.toString());
		    }
		    catch (IOException ie){
		         ie.printStackTrace(); 
		    }
			return talks;
		}
	 
	 public static void associate(String name){
		 NPCsTalks.put(name, talks);
		 talks=null;
	 }
	 
}
