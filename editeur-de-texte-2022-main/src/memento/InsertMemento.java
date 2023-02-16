package memento;

public class InsertMemento extends ConcreteMemento implements Memento{
	
	private String texte;
	
	public InsertMemento() {
		this.texte = "";
	}
	
	public InsertMemento(String str) {
		this.texte = str;
	}
	
	public String getText() {
		return this.texte;
	}
	
	public void setText(String txt) {
		this.texte = txt;
	}

}
