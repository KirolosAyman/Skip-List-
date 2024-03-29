package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.company.Database;
import com.company.KVPair;
import com.company.Rectangle;

class ValidInsertionTest {

	Database data=new Database();
	@Test
	public void testInsert1() {
		int sz=data.getSize();
		String name="a";
		Rectangle rec=new Rectangle(0,0,2,2);
		data.insert(new KVPair<String,Rectangle>(name,rec));
		assertEquals(sz+1,data.getSize());
	}
	
	@Test
	public void testInsert2() {
		int sz=data.getSize();
		String name="abc";
		Rectangle rec=new Rectangle(5,7,100,20);
		data.insert(new KVPair<String,Rectangle>(name,rec));
		assertEquals(sz+1,data.getSize());
	}
	@Test
	public void testInsert3() {
		int sz=data.getSize();
		String name="ba";
		Rectangle rec=new Rectangle(8,4,3,1);
		data.insert(new KVPair<String,Rectangle>(name,rec));
		assertEquals(sz+1,data.getSize());
	}
	@Test
	public void testInsert4() {
		int sz=data.getSize();
		String name="a";
		Rectangle rec=new Rectangle(0,0,1024,1024);
		data.insert(new KVPair<String,Rectangle>(name,rec));
		assertEquals(sz+1,data.getSize());
	}
	@Test
	public void testInsert5() {
		int sz=data.getSize();
		String name="cd";
		Rectangle rec=new Rectangle(0,2,1000,1000);
		data.insert(new KVPair<String,Rectangle>(name,rec));
		assertEquals(sz+1,data.getSize());
	}
	public void testInsert6() {
		int sz=data.getSize();
		String name="name";
		Rectangle rec=new Rectangle(85,3,493,394);
		data.insert(new KVPair<String,Rectangle>(name,rec));
		assertEquals(sz,data.getSize());
	}

}
