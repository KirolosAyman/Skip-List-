package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.company.KVPair;
import com.company.Rectangle;
import com.company.SkipList;

class ValidRemove {

	static SkipList<String,Rectangle>list;
	@BeforeAll
	public static void setup() {
		list=new SkipList();
		String name="a";
		Rectangle rec=new Rectangle(0,0,2,2);
		list.insert(new KVPair<String,Rectangle>(name,rec));
		
		name="abc";
		rec.setBounds(5,7,100,20);
		list.insert(new KVPair<String,Rectangle>(name,rec));
		
		name="ba";
		rec.setBounds(8,4,3,1);
		list.insert(new KVPair<String,Rectangle>(name,rec));
		
		name="a";
		rec.setBounds(0,0,1024,1024);
		list.insert(new KVPair<String,Rectangle>(name,rec));
		
		name="cd";
		rec.setBounds(0,2,1000,1000);
		list.insert(new KVPair<String,Rectangle>(name,rec));
		
		name="name";
		rec.setBounds(85,3,493,394);
		list.insert(new KVPair<String,Rectangle>(name,rec));	
			
	}
	
	
	//remove by name
	@Test
	public void testRemove1() {
		int sz=list.getSize();
		KVPair<String, Rectangle> removed=list.remove("abc");
		assertEquals(sz-1,list.getSize());
		assertEquals(0,removed.getKey().compareTo("abc"));
	}
	@Test
	public void testRemove2() {
		int sz=list.getSize();
		KVPair<String, Rectangle> removed=list.remove("ba");
		assertEquals(sz-1,list.getSize());
		assertEquals(0,removed.getKey().compareTo("ba"));
	}
	//remove by value
	@Test
	public void testRemove3() {
		int sz=list.getSize();
		Rectangle rec=new Rectangle(0,2,1000,1000);
		KVPair<String, Rectangle> removed=list.removeByValue(rec);
		assertEquals(sz,list.getSize());
	}
	@Test
	public void testRemove4() {
		int sz=list.getSize();
		Rectangle rec=new Rectangle(85,3,493,394);
		KVPair<String, Rectangle> removed=list.removeByValue(rec);
		assertEquals(sz-1,list.getSize());
		boolean eqOb=(removed.getValue().equals(rec));
		assertTrue(eqOb);
	}
}
