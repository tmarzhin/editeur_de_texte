package receiver;

public class SelectionImpl implements Selection{

	private StringBuilder buffer;
	private int beginindex;
	private int endindex;
	private static final int BUFFER_BEGIN_INDEX = 0;

	public SelectionImpl(StringBuilder b) {
		this.buffer=b;
		this.beginindex=0;
		this.endindex=0;
	}

	public SelectionImpl(StringBuilder newBuffer,int newBeginIndex,int newEndIndex) {
		this.buffer=newBuffer;
		this.beginindex=newBeginIndex;
		this.endindex=newEndIndex;
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
	 * @param buff modifie le contenu du buffer
	 */
	public void setBuffer(StringBuilder buff) {
		this.buffer=buff;
	}

	/**
	 * retourne l'index du début de la sélection
	 */
	public int getBeginIndex() {
		return beginindex;
	}

	/**
	 * retourne l'index de la fin de la sélection
	 */
	public int getEndIndex() {
		return endindex;
	}

	/**
	 * retourne l'index du début du buffer
	 */
	public int getBufferBeginIndex() {
		return BUFFER_BEGIN_INDEX;
	}

	/**
	 * retourne la taille du buffer
	 */
	public int getBufferEndIndex() {
		return buffer.length();
	}

	/**
	 * @param le nouveau index du début de la sélection
	 * modifie l'index du début de la sélection et assure qu'il soit dans le buffer et < au endIndex
	 */
	public void setBeginIndex(int beginIndex) {
		if((beginIndex>=BUFFER_BEGIN_INDEX)&&(beginIndex<=getBufferEndIndex())) {
			if(beginIndex<=getEndIndex()) {
				this.beginindex=beginIndex;
			}else {
				throw new IndexOutOfBoundsException("le beginindex doit Ãªtre infÃ©rieur au endindex");
			}
		}else {
			throw new IndexOutOfBoundsException("vous devez indiquer un beginindex dans le buffer");
		}
	}
		

	/**
	 * @param le nouveau index de la fin de la sélection
	 * modifie l'index de la fin de la sélection et assure qu'il soit dans le buffer et > au beginIndex
	 */
	public void setEndIndex(int endIndex) {
		if((endIndex>=BUFFER_BEGIN_INDEX)&&(endIndex<=getBufferEndIndex())) {
			if(endIndex>=getBeginIndex()) {
				this.endindex=endIndex;
			}else {
				throw new IndexOutOfBoundsException("le endindex doit Ãªtre supÃ©rieur au beginindex");
			}
		}else {
			throw new IndexOutOfBoundsException("vous devez indiquer un endindex dans le buffer");
		}
	}
}
