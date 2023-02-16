package command;

import undoRedo.UndoRedo;

public class Redo implements Command {
	private UndoRedo undoredo;

	public Redo(UndoRedo undoredo) {
		this.undoredo = undoredo;
	}
	
	/** 
	 *méthode permettant de refaire la dernière commande 
	 */
	public void execute() {
        undoredo.redo();
    }
}
