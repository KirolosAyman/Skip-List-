package com.company;
import java.util.ArrayList;
import java.util.Iterator;

//import java.awt.Rectangle;

/**
 * This class is responsible for interfacing between the command processor and
 * the SkipList. The responsibility of this class is to further interpret
 * variations of commands and do some error checking of those commands. This
 * class further interpreting the command means that the two types of remove
 * will be overloaded methods for if we are removing by name or by coordinates.
 * Many of these methods will simply call the appropriate version of the
 * SkipList method after some preparation.
 * 
 * @author CS Staff
 * 
 * @version 2021-08-23
 */
public class Database {

    // this is the SkipList object that we are using
    // a string for the name of the rectangle and then
    // a rectangle object, these are stored in a KVPair,
    // see the KVPair class for more information
    private SkipList<String, Rectangle> list;

    /**
     * The constructor for this class initializes a SkipList object with String
     * and Rectangle a its parameters.
     */
    public Database() {
        list = new SkipList<String, Rectangle>();
    }


    /**
     * Inserts the KVPair in the SkipList if the rectangle has valid coordinates
     * and dimensions, that is that the coordinates are non-negative and that
     * the rectangle object has some area (not 0, 0, 0, 0). This insert will
     * insert the KVPair specified into the sorted SkipList appropriately
     * 
     * @param pair
     *            the KVPair to be inserted
     */
    public void insert(KVPair<String, Rectangle> pair) {
    	if (pair.getValue().validRectangle()) {
    		list.insert(pair);
    		System.out.print("Rectangle inserted: ");
    	}
    	else {
    		System.out.print("Rectangle rejected: ");
    	}
		System.out.println(pair);

    }


    /**
     * Removes a rectangle with the name "name" if available. If not an error
     * message is printed to the console.
     * 
     * @param name
     *            the name of the rectangle to be removed
     */
    public void remove(String name) {
    	KVPair<String,Rectangle> removed=list.remove(name);
    	if (removed==null) {
    		System.out.println("Rectangle not removed: ("+name+")");
    	}
    	else {
    		
    		System.out.println("Rectangle removed: "+removed);
    	}

    }


    /**
     * Removes a rectangle with the specified coordinates if available. If not
     * an error message is printed to the console.
     * 
     * @param x
     *            x-coordinate of the rectangle to be removed
     * @param y
     *            x-coordinate of the rectangle to be removed
     * @param w
     *            width of the rectangle to be removed
     * @param h
     *            height of the rectangle to be removed
     */
    public void remove(int x, int y, int w, int h) {
    	Rectangle rect=new Rectangle(x,y,w,h);
    	KVPair<String,Rectangle> removed=list.removeByValue(rect);
    	if (removed==null) {
    		System.out.println("Rectangle rejected: "+"("+rect+")");
    	}
    	else {
    		System.out.println("Rectangle removed: "+removed);
    	}

    }


    /**
     * Displays all the rectangles inside the specified region. The rectangle
     * must have some area inside the area that is created by the region,
     * meaning, Rectangles that only touch a side or corner of the region
     * specified will not be said to be in the region. You will need a SkipList Iterator for this 
     * 
     * @param x
     *            x-Coordinate of the region
     * @param y
     *            y-Coordinate of the region
     * @param w
     *            width of the region
     * @param h
     *            height of the region
     */
    public void regionsearch(int x, int y, int w, int h) {
    	Rectangle reg=new Rectangle(x,y,w,h);
    	if (reg.validRegion()) {
    		System.out.println("Rectangles intersecting region "+"("+reg+"):");
    		Iterator<KVPair<String, Rectangle>>it=list.iterator();
    		KVPair<String,Rectangle>cur;
    		while(it.hasNext()) {
    			cur=it.next();
    			if (reg.intersects(cur.getValue())) {
    				System.out.println(cur);
    			}
    		}
    	}
    	else {
    		System.out.println("Rectangle rejected: "+"("+reg+")");
    	}
    	

    }



    /**
     * Prints out all the rectangles that Intersect each other by calling the
     * SkipList method for intersections. You will need to use two SkipList Iterators for this
     */
    public void intersections() {
    	System.out.println("Intersection pairs:");
    	Iterator<KVPair<String, Rectangle>>cur=list.iterator(),it;
    	KVPair<String,Rectangle>curNode,itNode;
    	while (cur.hasNext()) {
    		curNode=cur.next();
    		it=list.iterator();
    		while (it.hasNext()) {
    			itNode=it.next();
    			if (curNode==itNode)continue;
    			if (curNode.getValue().intersects(itNode.getValue())) {
    				System.out.print("("+curNode.getKey()+", "+curNode.getValue()+" | ");
    				System.out.println(itNode.getKey()+", "+itNode.getValue()+")");
    			}
    		}
    	}

    }


    /**
     * Prints out all the rectangles with the specified name in the SkipList.
     * This method will delegate the searching to the SkipList class completely.
     * 
     * @param name
     *            name of the Rectangle to be searched for
     */
    public void search(String name) {
    	ArrayList<KVPair<String, Rectangle>>res=list.search(name);
    	if (res==null) {
    		System.out.println("Rectangle not found: "+name);
    	}
    	else {
    		System.out.println("Rectangles found:");
    		for (int i=0;i<res.size();i++) {
    			System.out.println((res.get(i)));
    		}
    	}

    }


    /**
     * Prints out a dump of the SkipList which includes information about the
     * size of the SkipList and shows all of the contents of the SkipList. This
     * will all be delegated to the SkipList.
     */
    public void dump() {
        list.dump();
    }
    public int getSize() {
    	return list.getSize();
    }

}
