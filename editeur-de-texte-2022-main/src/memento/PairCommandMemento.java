package memento;

import command.Command;

/**
 * classe associant une commande et un mémento
 *
 */

public class PairCommandMemento {
	
private Command command;

private Memento memento;

public PairCommandMemento() {
	this.command = null;
	this.memento = null;
}

public PairCommandMemento(Command c, Memento m) {
	this.command = c;
	this.memento = m;
}


public Command getCommand() {
	return this.command;
}

public Memento getMemento() {
	return this.memento;
}

public void setCommand(Command c) {
	this.command = c;
}

public void setMemento(Memento m) {
	this.memento = m;
}

}
