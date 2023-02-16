package command;

import undoRedo.UndoRedo;

public class Redo implements Command {
	private UndoRedo undoredo;

	public Redo(UndoRedo undoredo) {
		this.undoredo = undoredo;
	}
	
	/** 
	 *m�thode permettant de refaire la derni�re commande 
	 */
	public void execute() {
        undoredo.redo();
    }
}
