package memento;

public class ConcreteMemento implements Memento {

	private StateMemento state;
	
	public ConcreteMemento(){
		this.state = new StateMemento();
	}
	
	public StateMemento getStateMemento() {
		return this.state;
	}
	
	public void setStateMemento(StateMemento state) {
		this.state = state;
	}
}
