import static org.junit.Assert.*;

import org.junit.Test;

public class DequeTest {

	@Test
	public void testIsEmpty() {
		Deque dq = new Deque();
		assertTrue("Expected True",dq.isEmpty());
	}
	
	@Test
	public void testIsNotEmpty() {
		Deque dq = new Deque();
		dq.pushRight(10);
		assertFalse("Expected False", dq.isEmpty());
	}
	
	@Test
	public void testSize0() {
		Deque dq = new Deque();
		assertEquals(0, dq.size());
	}
	
	@Test
	public void testSize10() {
		Deque dq = new Deque();
		for (int i = 0; i < 15; i++) dq.pushLeft(i);
		for (int i = 0; i < 5; i++) dq.popRight();
		assertEquals(10, dq.size());
	}
	
	@Test
	public void testPushLeft() {
		Deque dq = new Deque();
		int item = 10;
		dq.pushLeft(item);
		assertEquals(item,(int) dq.popLeft());
	}

}
