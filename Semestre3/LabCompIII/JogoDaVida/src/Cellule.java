
public class Cellule {
	private State state;
	
	public Cellule() {
		this.state = State.DEAD;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public void live() {
		this.state = State.ALIVE;
	}
	
	public void die() {
		this.state = State.DEAD;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return state == State.ALIVE ? "1" : "0";
	}
	
	
	
}
