import static org.junit.Assert.*;

import org.junit.Test;

public class RandomQueueTest {

	@Test
	public void testIsEmpty() {
		RandomQueue rq = new RandomQueue();
		assertTrue("Expected True",rq.isEmpty());
	}
	
	@Test
	public void testIsNotEmpty() {
		RandomQueue rq = new RandomQueue();
		rq.enqueue(5);
		assertFalse("Expected False",rq.isEmpty());
	}
	
	@Test
	public void testAddItem() {
		RandomQueue rq = new RandomQueue();
		int i = 5;
		rq.enqueue(i);
		assertEquals(i,rq.sample());
	}
	
	@Test
	public void testRemoveItem() {
		RandomQueue rq = new RandomQueue();
		int i = 10;
		rq.enqueue(i);
		assertEquals(i, rq.dequeue());
	}
	
	@Test
	public void testRandomDequeue() {
		RandomQueue rq = new RandomQueue();
		int tam = 10;
		int [] vetor = new int[tam];
		Object [] vetor2 = new Object[tam];
		Object [] a = {1,2,3,4,5,1};
		Object [] b = {1,5,4,3,2,1};
  		for (int i = 0; i < tam; i++) {
			rq.enqueue(i);
			vetor[i] = i;
		}
  		
  		for (int i= 0; i < a.length; i++) {
  			assertTrue(checkItemsArray(b, a[i])); 
  		}
		
		for (int i = 0; i < tam; i++) vetor2[i] = rq.dequeue();		
		
		
		for (int i= 0; i < vetor.length; i++) {
  			assertTrue(checkItemsArray( vetor2, vetor[i])); 
  		}				
		
	}
	
	private boolean checkItemsArray(Object [] vetor, Object item) {
		// TODO Auto-generated method stub
		for (int i = 0 ; i < vetor.length; i++) {
			if ( vetor[i] != null && (int)vetor[i] == (int)item ) {
				vetor[i] = null;
				return true;
			}
		}
		return false;
		
	}


}
