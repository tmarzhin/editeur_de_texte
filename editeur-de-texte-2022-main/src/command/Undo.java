package command;

import undoRedo.UndoRedo;

public class Undo implements Command{
	private UndoRedo undoredo;

	public Undo(UndoRedo undoredo) {
		this.undoredo = undoredo;
	}
	
	/**
	 * m�thode permettant l'annulation de la derni�re action de l'utilisateur
	 */
	public void execute() {
        undoredo.undo();
    }
}
