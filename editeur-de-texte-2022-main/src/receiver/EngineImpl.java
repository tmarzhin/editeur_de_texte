package receiver;

public class EngineImpl implements Engine {
	/**
	 * Provides access to the selection control object
	 *
	 * @return the selection object
	 */

	private StringBuilder buffer; 
	private String clipboard; 
	private SelectionImpl selection; 

	public EngineImpl() {
		this.setBuffer(new StringBuilder());
		this.selection= new SelectionImpl(getBuffer());
		this.clipboard="";		
	}


	@Override
	public Selection getSelection() {
		return this.selection;
	}

	/**
	 * Provides the whole contents of the buffer, as a string
	 *
	 * @return a copy of the buffer's contents
	 */
	@Override
	public String getBufferContents() {
		return getBuffer().toString();
	}

	/**
	 * Provides the clipboard contents
	 *
	 * @return a copy of the clipboard's contents
	 */
	@Override
	public String getClipboardContents() {
		return clipboard;
	}

	/**
	 * Removes the text within the interval
	 * specified by the selection control object,
	 * from the buffer.
	 */
	@Override
	public void cutSelectedText() {
		if(selection.getBeginIndex() != selection.getEndIndex()) {
			if(selection.getBeginIndex() < selection.getEndIndex()) {
				String contenubuffer = getBuffer().substring(selection.getBeginIndex(),selection.getEndIndex());
				clipboard=clipboard + contenubuffer;
				this.getBuffer().delete(selection.getBeginIndex(), selection.getEndIndex());
				selection.setEndIndex(selection.getBeginIndex());  
			}
		}	
	}

	/**
	 * Copies the text within the interval
	 * specified by the selection control object
	 * into the clipboard.
	 */
	@Override
	public void copySelectedText() {
		if(selection.getBeginIndex() != selection.getEndIndex()) {
			if(selection.getBeginIndex() < selection.getEndIndex()) {
				String contenubuffer = getBuffer().substring(selection.getBeginIndex(),selection.getEndIndex());
				clipboard=clipboard + contenubuffer;
				selection.setBeginIndex(selection.getEndIndex());
			}
		}
	}

	/**
	 * Replaces the text within the interval specified by the selection object with
	 * the contents of the clipboard.
	 */
	@Override
	public void pasteClipboard() {
		if(selection.getBeginIndex() <= selection.getEndIndex()) {
			getBuffer().replace(selection.getBeginIndex(),selection.getEndIndex(),getClipboardContents());
			int positionCurseur = selection.getBeginIndex() + clipboard.length();
			selection.setBeginIndex(positionCurseur);
			selection.setEndIndex(positionCurseur);
		}
	}

	/**
	 * Inserts a string in the buffer, which replaces the contents of the selection
	 *
	 * @param s the text to insert
	 */
	@Override
	public void insert(String s) {
		if(selection.getBeginIndex() <= selection.getEndIndex()) {
			getBuffer().replace(selection.getBeginIndex(),selection.getEndIndex(),s);
			int positionCurseur = selection.getBeginIndex() + s.length();
			selection.setBeginIndex(positionCurseur);
			selection.setEndIndex(positionCurseur);
		}
	}

	/**
	 * Removes the contents of the selection in the buffer
	 */
	@Override
	public void delete() { 
		if(selection.getBeginIndex() != selection.getEndIndex()) {
			int taille = selection.getEndIndex()- selection.getBeginIndex();
			if(taille>0) {
				this.getBuffer().delete(selection.getBeginIndex(), selection.getEndIndex());
				selection.setEndIndex(selection.getBeginIndex());
			}
		}
	}

  /**
   * 
   * @return le contenu du buffer
   */
	public StringBuilder getBuffer() {
		return buffer;
	}

    /**
     * 
     * @param buffer le nouveau buffer qui remplaçera l'ancien
     */
	public void setBuffer(StringBuilder buffer) {
		this.buffer = buffer;
	}
}