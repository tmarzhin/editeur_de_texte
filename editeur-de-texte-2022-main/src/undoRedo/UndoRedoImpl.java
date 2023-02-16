package undoRedo;
import receiver.*;
import java.util.*;
import memento.StateMemento;


public class UndoRedoImpl implements UndoRedo{
	private EngineImpl engine;
    private List<StateMemento> pastStates;
    private List<StateMemento> futurStates;
    
    public UndoRedoImpl(EngineImpl engine) {
    	this.engine = engine;
    	pastStates = new ArrayList<StateMemento>();
    	futurStates = new ArrayList<StateMemento>();
    	
    }

    /**
	 * m�thode annulant la derni�re commande de l'utilisateur similaire au raccourci CTRL + Z
	 */
	public void undo() {
		if(!pastStates.isEmpty()) {
			StateMemento dernier = 	pastStates.get(pastStates.size() - 1);
			this.engine = dernier.getEngine();
			this.engine.setBuffer(dernier.getBuffer());
			Selection selec = this.engine.getSelection();
			selec.setBeginIndex(dernier.getSelection().getBeginIndex());
			selec.setEndIndex(dernier.getSelection().getEndIndex());
			pastStates.remove(dernier);
			futurStates.add(futurStates.size() - 1, dernier);
			
		}else {
			System.out.print("Il n'y a pas de commandes pass�es sauvegard�es");
		}
		
	}
	
	/**
     * m�thode qui refait la derni�re commande de l'utilisateur similaire au raccourci CTRL + Y
     */
	public void redo() {
		if(!futurStates.isEmpty()) {
			StateMemento dernier = 	futurStates.get(futurStates.size() - 1);
			this.engine = dernier.getEngine();
			this.engine.setBuffer(dernier.getBuffer());
			Selection selec = this.engine.getSelection();
			selec.setBeginIndex(dernier.getSelection().getBeginIndex());
			selec.setEndIndex(dernier.getSelection().getEndIndex());
			futurStates.remove(dernier);
			pastStates.add(pastStates.size() - 1, dernier);	
		}
		else {
			System.out.print("Il n'y a pas de commandes futures sauvegard�es");
		}
	}
	
	/**
     * m�thode qui sauvegarde la derni�re commande de l'utilisateur 
     */
	public void store() {
		StateMemento state = new StateMemento();
		StringBuilder buffer = engine.getBuffer();
		Selection selec = engine.getSelection();
		state.setBuffer(buffer);
		state.setSelection(selec);
		pastStates.add(pastStates.size()-1, state);
	}
	
	
}
