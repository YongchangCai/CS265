import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class gIntTest extends TestCase{
	
	@Test
	public void testReal() throws Exception{
		gInt actual1 = new gInt(10);
		gInt actual2 = new gInt(5,2);
		
		assertEquals("Real method wrong",10,actual1.real());
		assertEquals("Real method wrong",5,actual2.real());
	}
	
	@Test
	public void testImag() throws Exception{
		gInt actual1 = new gInt(5,2);
		
		assertEquals("Imag method wrong",2,actual1.imag());
	}
	
	@Test
	public void testAdd() throws Exception{
		gInt x = new gInt(1);
		gInt y = new gInt(3,5);
		gInt expected = new gInt(4,5);
		
		assertEquals("Add method real number wrong",expected.real(),x.add(y).real());
		assertEquals("Add method image number wrong",expected.imag(),x.add(y).imag());
	}
	
	@Test
	public void testMultiply() throws Exception{
		gInt x = new gInt(2,4);
		gInt y = new gInt(3,5);
		gInt expected = new gInt(-14,22);
		
		assertEquals("Multiply method real number wrong",expected.real(),x.multiply(y).real());
		assertEquals("Multiply method image number wrong",expected.imag(),x.multiply(y).imag());
	}
	
	@Test
	public void testNorm() throws Exception{
		gInt actual = new gInt(3,2);
		
		assertEquals("Norm method wrong",(float)Math.sqrt(13),actual.norm());
	}

}
