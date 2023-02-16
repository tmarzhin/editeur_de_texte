package memento;

public interface Originator {
	
	/**
	 *méthode permettant d'obtenir un Memento sauvegardant les valeurs des variables de l'objet si cela est nécessaire
	 * @return Soit un Memento soit null
	 */
	public Memento getMemento();
	
	/**
     * méthode permettant d'éditer un mémento de sauvegarde
     * @param m le nouveau Memento devant remplacer l'ancien memento
     */
	public void setMemento(Memento m);

}
