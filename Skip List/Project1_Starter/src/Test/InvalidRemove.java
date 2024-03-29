package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.company.*;

class InvalidRemove {
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
		list.remove("yz");
		assertEquals(sz,list.getSize());
	}
	@Test
	public void testRemove2() {
		int sz=list.getSize();
		list.remove("any");
		assertEquals(sz,list.getSize());
	}
	@Test
	public void testRemove3() {
		int sz=list.getSize();
		list.remove("factorial");
		assertEquals(sz,list.getSize());
	}
	//remove by value
	@Test
	public void testRemove4() {
		int sz=list.getSize();
		list.removeByValue(new Rectangle(2,4,500,300));
		assertEquals(sz,list.getSize());
	}
	@Test
	public void testRemove5() {
		int sz=list.getSize();
		list.removeByValue(new Rectangle(0,0,700,300));
		assertEquals(sz,list.getSize());
	}
	@Test
	public void testRemove6() {
		int sz=list.getSize();
		list.removeByValue(new Rectangle(200,200,389,658));
		assertEquals(sz,list.getSize());
	}
	
	

}
