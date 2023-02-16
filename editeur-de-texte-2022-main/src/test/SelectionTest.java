package test;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

import receiver.Selection;
import receiver.SelectionImpl;

import static org.junit.jupiter.api.Assertions.*;


public class SelectionTest {
	
	private Selection selection;
	
	@org.junit.jupiter.api.BeforeEach
    void setUp() {
        selection = new SelectionImpl(new StringBuilder(""));
        
    }
	
	@Test
    @DisplayName("index début doit être égal à 0 après initialisation")
    void getBeginIndex() {
        int b_index = selection.getBeginIndex();
        assertEquals(0,b_index);    
    }
	
	@Test
    @DisplayName("index fin doit être égal à 0 après initialisation")
    void getEndIndex() {
        int e_index = selection.getEndIndex();
        assertEquals(0,e_index);
        
    }
	
	@Test
    @DisplayName("buffer begin index doit être égal à 0 après initialisation")
    void getbbIndex() {
        int bb_index = selection.getBufferBeginIndex();
        assertEquals(0,bb_index);
        
    }
	
	@Test
    @DisplayName("buffer.length doit être égal à 0 après initialisation")
    void getblIndex() {
        int be_index = selection.getBufferEndIndex();
        assertEquals(0,be_index);
        
    }
	
	@Test
    @DisplayName("beginindex doit être positif")
    void beginSuperieurAZero() {
		assertThrows(IndexOutOfBoundsException.class, () -> selection.setBeginIndex(-1));	
        
    }
	
	@Test
    @DisplayName("endindex doit être positif")
    void endSuperieurAZero() {
		assertThrows(IndexOutOfBoundsException.class, () -> selection.setEndIndex(-1));		
        
    }
	
	@Test
    @DisplayName("beginindex doit être dans le buffer")
    void begDansBuffer() {
		
		assertThrows(IndexOutOfBoundsException.class, () -> selection.setBeginIndex(1));	
			
    }
	
	@Test
    @DisplayName("endindex doit être dans le buffer")
    void endDansBuffer() {
		
		assertThrows(IndexOutOfBoundsException.class, () -> selection.setEndIndex(1));	
			
    }
	
	@Test
    @DisplayName("beginindex doit être dans le buffer")
    void begDansBuffer1() {
		
		assertThrows(IndexOutOfBoundsException.class, () -> selection.setBeginIndex(20));	
			
    }
	
	@Test
    @DisplayName("beginindex doit être dans le buffer")
    void endDansBuffer1() {
		
		assertThrows(IndexOutOfBoundsException.class, () -> selection.setEndIndex(20));	
			
    }
	
	@Test
    @DisplayName("beginindex doit être inferieur au endindex")
    void endsupbeg() {
		int b= selection.getBeginIndex();
		int e= selection.getEndIndex();
		
		assertThrows(IndexOutOfBoundsException.class, () -> selection.getBeginIndex());	
			
    }
	
	@Test
    @DisplayName("test position beginindex")
    void testpos1() {
		StringBuilder b = new StringBuilder("t");
		Selection selec= new SelectionImpl(b);
		int begin = selec.getBeginIndex();
		assertEquals(0,begin);
			
    }
	
	@Test
    @DisplayName("test position endindex")
    void testpos2() {
		StringBuilder b = new StringBuilder("t");
		Selection selec= new SelectionImpl(b);
		int end = selec.getEndIndex();
		assertEquals(0,end);
			
    }
	
	@Test
    @DisplayName("test constructeur")
    void testcons() {
		StringBuilder b = new StringBuilder("");
		int beginindex=0;
		int endindex=0;
		SelectionImpl selec = new SelectionImpl(b,beginindex,endindex);
		assertEquals(selec,selection);
    }
	
	@Test
    @DisplayName("test buffer")
    void testbuffer() {
		StringBuilder b = new StringBuilder("");
		SelectionImpl selec = new SelectionImpl(b);
		StringBuilder buf= selec.getBuffer();
	
		assertEquals(buf.toString(),"");
    }
	
	@Test
    @DisplayName("test buffer")
    void testbuffer2() {
		StringBuilder b = new StringBuilder("");
		SelectionImpl selec = new SelectionImpl(b);
		StringBuilder b1 = new StringBuilder("a");
		selec.setBuffer(b1);
		StringBuilder buf= selec.getBuffer();
	
		assertEquals(buf.toString(),"a");
    }
	
	@Test
    void testbegin() {
		StringBuilder b = new StringBuilder("");
		SelectionImpl selec = new SelectionImpl(b);
		
		assertTrue(selec.getBeginIndex()<=selec.getBufferEndIndex());
    }
	
	@Test
    void testbegin1() {
		StringBuilder b = new StringBuilder("");
		SelectionImpl selec = new SelectionImpl(b);
		
		assertTrue(selec.getBeginIndex()>=selec.getBufferBeginIndex());
    }
	
	@Test
    void testbegin2() {
		StringBuilder b = new StringBuilder("");
		SelectionImpl selec = new SelectionImpl(b);
		
		assertTrue(selec.getBeginIndex()<=selec.getEndIndex());
    }

	@Test
    void testend() {
		StringBuilder b = new StringBuilder("");
		SelectionImpl selec = new SelectionImpl(b);
		
		assertTrue(selec.getEndIndex()<=selec.getBufferEndIndex());
    }
	
	@Test
    void testend1() {
		StringBuilder b = new StringBuilder("");
		SelectionImpl selec = new SelectionImpl(b);
		
		assertTrue(selec.getEndIndex()>=selec.getBufferBeginIndex());
    }
}
