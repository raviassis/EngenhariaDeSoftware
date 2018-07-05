
public class Aplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomQueue rq = new RandomQueue();
		for (int i = 0; i < 100; i++) {
			rq.enqueue(i);
		}
		
		for (int i = 0, b = 0; i < 200; i++, b++) {
			if (b == 20) {
				b = 0;
				System.out.println(rq.sample());
			}
			System.out.print(rq.sample() + " - "); 
			
		}
	}

}
