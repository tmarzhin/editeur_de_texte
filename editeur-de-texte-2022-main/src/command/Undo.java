package command;

import undoRedo.UndoRedo;

public class Undo implements Command{
	private UndoRedo undoredo;

	public Undo(UndoRedo undoredo) {
		this.undoredo = undoredo;
	}
	
	/**
	 * méthode permettant l'annulation de la dernière action de l'utilisateur
	 */
	public void execute() {
        undoredo.undo();
    }
}
