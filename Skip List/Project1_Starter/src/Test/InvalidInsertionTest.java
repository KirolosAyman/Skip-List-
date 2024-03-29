package Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.company.Database;
import com.company.KVPair;
import com.company.Rectangle;
class InvalidInsertionTest {
	Database data=new Database();
	@Test
	public void testInsert1() {
		int sz=data.getSize();
		String name="a";
		Rectangle rec=new Rectangle(-1,5,20,20);
		data.insert(new KVPair<String,Rectangle>(name,rec));
		assertEquals(sz,data.getSize());
	}
	
	@Test
	public void testInsert2() {
		int sz=data.getSize();
		String name="a";
		Rectangle rec=new Rectangle(5,-1,20,20);
		data.insert(new KVPair<String,Rectangle>(name,rec));
		assertEquals(sz,data.getSize());
	}
	@Test
	public void testInsert3() {
		int sz=data.getSize();
		String name="a";
		Rectangle rec=new Rectangle(0,0,0,0);
		data.insert(new KVPair<String,Rectangle>(name,rec));
		assertEquals(sz,data.getSize());
	}
	@Test
	public void testInsert4() {
		int sz=data.getSize();
		String name="a";
		Rectangle rec=new Rectangle(1,0,1024,1024);
		data.insert(new KVPair<String,Rectangle>(name,rec));
		assertEquals(sz,data.getSize());
	}
	@Test
	public void testInsert5() {
		int sz=data.getSize();
		String name="a";
		Rectangle rec=new Rectangle(0,2,1024,1024);
		data.insert(new KVPair<String,Rectangle>(name,rec));
		assertEquals(sz,data.getSize());
	}
	public void testInsert6() {
		int sz=data.getSize();
		String name="a";
		Rectangle rec=new Rectangle(0,2,1024,1024);
		data.insert(new KVPair<String,Rectangle>(name,rec));
		assertEquals(sz,data.getSize());
	}
		
	
}
