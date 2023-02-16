package memento;

import receiver.*;
import receiver.Selection;
import receiver.SelectionImpl;

public class StateMemento {
	private EngineImpl engine;
	private Selection selection;
	private StringBuilder buffer;
	
	public StateMemento() {
		this.engine = new EngineImpl();
		this.buffer = new StringBuilder();
		this.selection = new SelectionImpl(this.buffer);
		this.selection.setBeginIndex(0);
		this.selection.setEndIndex(0);
	}
	
	public StateMemento(EngineImpl en,Selection s,StringBuilder b) {
		this.engine = en;
		this.selection = s;
		this.buffer = b;
	}
	
	public EngineImpl getEngine() {
		return this.engine;
	}
	
	public Selection getSelection() {
		return this.selection;
	}
	
	public StringBuilder getBuffer() {
		return this.buffer;
	}
	
	
	public void setSelection(Selection s) {
		this.selection = s;
	}
	
	public void setBuffer(StringBuilder b) {
		this.buffer = b;
	}
}
