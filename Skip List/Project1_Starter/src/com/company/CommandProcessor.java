package com.company;

//import java.awt.Rectangle;

/**
 * The purpose of this class is to parse a text file into its appropriate, line
 * by line commands for the format specified in the project spec.
 * 
 * @author CS Staff
 * 
 * @version 2021-08-23
 */
public class CommandProcessor {

    // the database object to manipulate the
    // commands that the command processor
    // feeds to it
    private Database data;

    /**
     * The constructor for the command processor requires a database instance to
     * exist, so the only constructor takes a database class object to feed
     * commands to.
     * 
     * @param dataIn
     *            the database object to manipulate
     */
    public CommandProcessor() {
        data = new Database();
    }


    /**
     * This method identifies keywords in the line and calls methods in the
     * database as required. Each line command will be specified by one of the
     * keywords to perform the actions within the database required. These
     * actions are performed on specified objects and include insert, remove,
     * regionsearch, search, intersections, and dump. If the command in the file line is not
     * one of these, an appropriate message will be written in the console. This
     * processor method is called for each line in the file. Note that the
     * methods called will themselves write to the console, this method does
     * not, only calling methods that do.
     * 
     * @param line
     *            a single line from the text file
     */
    public void processor(String line) {
    	//split the line into substrings separated by one or more spaces
    	String[] words=line.split("\\s+");
    	
    	String operation;
    	operation=words[0];
    	
    	if (operation.equals("insert")) {
    		String name=words[1];
    		
    		int x=Integer.parseInt(words[2]);
    		int y=Integer.parseInt(words[3]);
    		int width=Integer.parseInt(words[4]);
    		int height=Integer.parseInt(words[5]);
    		
    		Rectangle rect=new Rectangle(x,y,width,height);
    		
    		KVPair<String,Rectangle>pair= new KVPair(name,rect);
    		
    		data.insert(pair);
    	}
    	else if (operation.equals("remove")) {
    		if (words.length==2) {
    			String name=words[1];
    			data.remove(name);
    		}
    		else {
    			int x=Integer.parseInt(words[1]);
        		int y=Integer.parseInt(words[2]);
        		int w=Integer.parseInt(words[3]);
        		int h=Integer.parseInt(words[4]);
        		
        		data.remove(x,y,w,h);
    		}
    		
    	}
    	else if (operation.equals("regionsearch")) {
    		int x=Integer.parseInt(words[1]);
    		int y=Integer.parseInt(words[2]);
    		int w=Integer.parseInt(words[3]);
    		int h=Integer.parseInt(words[4]);
    		data.regionsearch(x,y,w,h);
    	}
    	else if (operation.equals("intersections")) {
    		data.intersections();
    	}
    	else if (operation.equals("search")) {
    		String name=words[1];
    		data.search(name);
    	}
    	else if (operation.equals("dump")) {
    		data.dump();
    	}
    	
    }

}
