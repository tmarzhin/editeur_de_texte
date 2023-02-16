package memento;

public interface Originator {
	
	/**
	 *m�thode permettant d'obtenir un Memento sauvegardant les valeurs des variables de l'objet si cela est n�cessaire
	 * @return Soit un Memento soit null
	 */
	public Memento getMemento();
	
	/**
     * m�thode permettant d'�diter un m�mento de sauvegarde
     * @param m le nouveau Memento devant remplacer l'ancien memento
     */
	public void setMemento(Memento m);

}
