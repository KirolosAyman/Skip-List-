package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.company.KVPair;
import com.company.Rectangle;
import com.company.SkipList;

class Search {

	static SkipList<String,Rectangle>list;
	ArrayList<KVPair<String,Rectangle>>found;
	KVPair<String,Rectangle>val;
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
	@Test
	public void testSearch1() {
		found=list.search("Red");
		assertEquals(null,found);
	}
	@Test
	public void testSearch2() {
		found=list.search("a");
		assertEquals(2,found.size());
	}
	@Test
	public void testSearch3() {
		found=list.search("abc");
		val=new KVPair("abc",new Rectangle(5,7,100,20));
		assertEquals(1,found.size());
		assertEquals(0,val.compareTo(found.get(0)));
	}
	@Test
	public void testSearch4() {
		found=list.search("ba");
		val=new KVPair("ba",new Rectangle(8,4,3,1));
		assertEquals(1,found.size());
		assertEquals(0,val.compareTo(found.get(0)));
	}
	@Test
	public void testSearch5() {
		found=list.search("cd");
		val=new KVPair("cd",new Rectangle(0,2,1000,1000));
		assertEquals(1,found.size());
		assertEquals(0,val.compareTo(found.get(0)));
	}
	@Test
	public void testSearch6() {
		found=list.search("name");
		val=new KVPair("name",new Rectangle(85,3,493,394));
		assertEquals(1,found.size());
		assertEquals(0,val.compareTo(found.get(0)));
	}
	
}
