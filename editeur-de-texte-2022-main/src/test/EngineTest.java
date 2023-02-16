package test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import receiver.Engine;
import receiver.EngineImpl;
import receiver.Selection;
import receiver.SelectionImpl;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {

    private Engine engine;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        engine = new EngineImpl();
    }

    @Test
    @DisplayName("Buffer must be empty after initialisation")
    void getSelection() {
        Selection selection = engine.getSelection();
        assertEquals(selection.getBufferBeginIndex(),selection.getBeginIndex());
        assertEquals("",engine.getBufferContents());
    }
    
    @Test
    @DisplayName("BUFFER_BEGIN_INDEX must be smaller than beginindex")
    void getSelection1() {
        Selection selection = engine.getSelection();
        assertEquals(selection.getBufferBeginIndex(),selection.getBeginIndex());
        assertEquals("",engine.getBufferContents());
    }
    
    @Test
    void testconstructeur() {
      String s = engine.getClipboardContents();
      assertEquals(s,"");
    }
    
    @Test
    void testconstructeur1() {
      String s = engine.getBufferContents();
      assertEquals(s,"");
    }
    
    @Test
    void testconstructeur2etselection() {
      Selection s = engine.getSelection();
    int beg= s.getBeginIndex();
    int end = s.getEndIndex();
    assertEquals(beg,0);
    assertEquals(end,0);
    }
    
    @Test
    void testcouper() {
     EngineImpl engine = new EngineImpl();
     StringBuilder buffer = new StringBuilder();
     engine.setBuffer(buffer);
     Selection s = engine.getSelection();
     s.setBeginIndex(0);
     s.setEndIndex(0);
     engine.cutSelectedText();
     StringBuilder nbuffer = new StringBuilder();
     assertEquals(buffer,nbuffer);
    }
    
    
    @Test
    void testcouper2() {
     EngineImpl engine = new EngineImpl();
     StringBuilder buffer = new StringBuilder("t");
     engine.setBuffer(buffer);
     Selection s = engine.getSelection();
     s.setBeginIndex(0);
     s.setEndIndex(0);
     engine.cutSelectedText();
     StringBuilder nbuffer = new StringBuilder();
     assertEquals(buffer,nbuffer);
    }
    
    @Test
    void testcouper3() {
     EngineImpl engine = new EngineImpl();
     StringBuilder buffer = new StringBuilder("t");
     engine.setBuffer(buffer);
     Selection s = engine.getSelection();
     s.setBeginIndex(0);
     s.setEndIndex(1);
     engine.cutSelectedText();
    String clipboard= engine.getClipboardContents();
     assertEquals(clipboard,"t");
     assertEquals(buffer,"");
     int beg = s.getBeginIndex();
     int end = s.getEndIndex();
     assertEquals(beg,0);
     assertEquals(end,0);
    }
    
    @Test
    void testcouper4() {
     EngineImpl engine = new EngineImpl();
     StringBuilder buffer = new StringBuilder("toto");
     engine.setBuffer(buffer);
     Selection s = engine.getSelection();
     s.setBeginIndex(0);
     s.setEndIndex(1);
     engine.cutSelectedText();
    String clipboard= engine.getClipboardContents();
     assertEquals(clipboard,"t");
     assertEquals(buffer,"oto");
     int beg = s.getBeginIndex();
     int end = s.getEndIndex();
     assertEquals(beg,0);
     assertEquals(end,0);
    }
    
    @Test
    void testcouper5() {
     EngineImpl engine = new EngineImpl();
     StringBuilder buffer = new StringBuilder("toto");
     engine.setBuffer(buffer);
     Selection s = engine.getSelection();
     s.setBeginIndex(1);
     s.setEndIndex(2);
     engine.cutSelectedText();
    String clipboard= engine.getClipboardContents();
     assertEquals(clipboard,"o");
     assertEquals(buffer,"tto");
     int beg = s.getBeginIndex();
     int end = s.getEndIndex();
     assertEquals(beg,1);
     assertEquals(end,1);
    }
    
    @Test
    void testcopy() {
     EngineImpl engine = new EngineImpl();
     StringBuilder buffer = new StringBuilder();
     engine.setBuffer(buffer);
     Selection s = engine.getSelection();
     s.setBeginIndex(0);
     s.setEndIndex(0);
     engine.copySelectedText();
    String clipboard= engine.getClipboardContents();
     assertEquals(clipboard,"");
     assertEquals(buffer,"");
     int beg = s.getBeginIndex();
     int end = s.getEndIndex();
     assertEquals(beg,0);
     assertEquals(end,0);
    }
    
    @Test
    void testcopy1() {
     EngineImpl engine = new EngineImpl();
     StringBuilder buffer = new StringBuilder("t");
     engine.setBuffer(buffer);
     Selection s = engine.getSelection();
     s.setBeginIndex(0);
     s.setEndIndex(0);
     engine.copySelectedText();
    String clipboard= engine.getClipboardContents();
     assertEquals(clipboard,"");
     assertEquals(buffer,"t");
     int beg = s.getBeginIndex();
     int end = s.getEndIndex();
     assertEquals(beg,0);
     assertEquals(end,0);
    }
    
    @Test
    void testcopy2() {
     EngineImpl engine = new EngineImpl();
     StringBuilder buffer = new StringBuilder("t");
     engine.setBuffer(buffer);
     Selection s = engine.getSelection();
     s.setBeginIndex(0);
     s.setEndIndex(1);
     engine.copySelectedText();
    String clipboard= engine.getClipboardContents();
     assertEquals(clipboard,"t");
     assertEquals(buffer,"t");
     int beg = s.getBeginIndex();
     int end = s.getEndIndex();
     assertEquals(beg,1);
     assertEquals(end,1);
    }
    
    @Test
    void testcopy3() {
     EngineImpl engine = new EngineImpl();
     StringBuilder buffer = new StringBuilder("toto");
     engine.setBuffer(buffer);
     Selection s = engine.getSelection();
     s.setBeginIndex(1);
     s.setEndIndex(2);
     engine.copySelectedText();
    String clipboard= engine.getClipboardContents();
     assertEquals(clipboard,"o");
     assertEquals(buffer,"toto");
     int beg = s.getBeginIndex();
     int end = s.getEndIndex();
     assertEquals(beg,2);
     assertEquals(end,2);
    }
    
    @Test
    void testpaste() {
     EngineImpl engine = new EngineImpl();
     StringBuilder buffer = new StringBuilder("");
     engine.setBuffer(buffer);
     Selection s = engine.getSelection();
     s.setBeginIndex(0);
     s.setEndIndex(0);
     engine.pasteClipboard();
    String clipboard= engine.getClipboardContents();
     assertEquals(clipboard,"");
     assertEquals(buffer,"");
     int beg = s.getBeginIndex();
     int end = s.getEndIndex();
     assertEquals(beg,0);
     assertEquals(end,0);
    }
    
    @Test
    void testpaste1() {
     EngineImpl engine = new EngineImpl();
     StringBuilder buffer = new StringBuilder("t");
     engine.setBuffer(buffer);
     Selection s = engine.getSelection();
     s.setBeginIndex(0);
     s.setEndIndex(1);
     engine.copySelectedText();
     engine.pasteClipboard();
    String clipboard= engine.getClipboardContents();
     assertEquals(clipboard,"");
     assertEquals(buffer,"tt");
     int beg = s.getBeginIndex();
     int end = s.getEndIndex();
     assertEquals(beg,2);
     assertEquals(end,2);
    }
    
    @Test
    void testpaste2() {
     EngineImpl engine = new EngineImpl();
     StringBuilder buffer = new StringBuilder("toto");
     engine.setBuffer(buffer);
     Selection s = engine.getSelection();
     s.setBeginIndex(1);
     s.setEndIndex(2);
     engine.copySelectedText();
     engine.pasteClipboard();
    String clipboard= engine.getClipboardContents();
     assertEquals(clipboard,"");
     assertEquals(buffer,"tooto");
     int beg = s.getBeginIndex();
     int end = s.getEndIndex();
     assertEquals(beg,3);
     assertEquals(end,3);
    }
    
    @Test
    void testpaste3() {
     EngineImpl engine = new EngineImpl();
     StringBuilder buffer = new StringBuilder("toto");
     engine.setBuffer(buffer);
     Selection s = engine.getSelection();
     s.setBeginIndex(1);
     s.setEndIndex(2);
     engine.pasteClipboard();
    String clipboard= engine.getClipboardContents();
     assertEquals(clipboard,"");
     assertEquals(buffer,"toto");
    }
    
    @Test
    void testinseert() {
    	 EngineImpl engine = new EngineImpl();
         StringBuilder buffer = new StringBuilder("");
         engine.setBuffer(buffer);
         Selection s = engine.getSelection();
         s.setBeginIndex(0);
         s.setEndIndex(0);
         engine.insert("");
        String clipboard= engine.getClipboardContents();
         assertEquals(clipboard,"");
         assertEquals(buffer,"");
         int beg = s.getBeginIndex();
         int end = s.getEndIndex();
         assertEquals(beg,0);
         assertEquals(end,0);
    }
    
    @Test
    void testinseert1() {
    	 EngineImpl engine = new EngineImpl();
         StringBuilder buffer = new StringBuilder("");
         engine.setBuffer(buffer);
         Selection s = engine.getSelection();
         s.setBeginIndex(0);
         s.setEndIndex(0);
         engine.insert("a");
         assertEquals(buffer,"");
         int beg = s.getBeginIndex();
         int end = s.getEndIndex();
         assertEquals(beg,0);
         assertEquals(end,0);
    }
    
    @Test
    void testinseert2() {
    	 EngineImpl engine = new EngineImpl();
         StringBuilder buffer = new StringBuilder("");
         engine.setBuffer(buffer);
         Selection s = engine.getSelection();
         s.setBeginIndex(0);
         s.setEndIndex(1);
         engine.insert("a");
         assertEquals(buffer,"a");
         int beg = s.getBeginIndex();
         int end = s.getEndIndex();
         assertEquals(beg,1);
         assertEquals(end,1);
    }
    
    @Test
    void testinseert3() {
    	 EngineImpl engine = new EngineImpl();
         StringBuilder buffer = new StringBuilder("toto");
         engine.setBuffer(buffer);
         Selection s = engine.getSelection();
         s.setBeginIndex(0);
         s.setEndIndex(1);
         engine.insert("a");
         assertEquals(buffer,"aoto");
         int beg = s.getBeginIndex();
         int end = s.getEndIndex();
         assertEquals(beg,1);
         assertEquals(end,1);
    }
    
    @Test
    void testinseert4() {
    	 EngineImpl engine = new EngineImpl();
         StringBuilder buffer = new StringBuilder("toto");
         engine.setBuffer(buffer);
         Selection s = engine.getSelection();
         s.setBeginIndex(4);
         s.setEndIndex(4);
         engine.insert("a");
         assertEquals(buffer,"toto");
         int beg = s.getBeginIndex();
         int end = s.getEndIndex();
         assertEquals(beg,4);
         assertEquals(end,4);
    }
    
    @Test
    void testdelete() {
    	 EngineImpl engine = new EngineImpl();
         StringBuilder buffer = new StringBuilder("");
         engine.setBuffer(buffer);
         Selection s = engine.getSelection();
         s.setBeginIndex(0);
         s.setEndIndex(0);
         engine.delete();
         assertEquals(buffer,"");
         int beg = s.getBeginIndex();
         int end = s.getEndIndex();
         assertEquals(beg,0);
         assertEquals(end,0);
    }
    
    @Test
    void testdelete1() {
    	 EngineImpl engine = new EngineImpl();
         StringBuilder buffer = new StringBuilder("t");
         engine.setBuffer(buffer);
         Selection s = engine.getSelection();
         s.setBeginIndex(0);
         s.setEndIndex(0);
         engine.delete();
         assertEquals(buffer,"");
         int beg = s.getBeginIndex();
         int end = s.getEndIndex();
         assertEquals(beg,0);
         assertEquals(end,0);
    }
    
    @Test
    void testdelete2() {
    	 EngineImpl engine = new EngineImpl();
         StringBuilder buffer = new StringBuilder("t");
         engine.setBuffer(buffer);
         Selection s = engine.getSelection();
         s.setBeginIndex(0);
         s.setEndIndex(1);
         engine.delete();
         assertEquals(buffer,"");
         int beg = s.getBeginIndex();
         int end = s.getEndIndex();
         assertEquals(beg,0);
         assertEquals(end,0);
    }
    
    @Test
    void testdelete3() {
    	 EngineImpl engine = new EngineImpl();
         StringBuilder buffer = new StringBuilder("toto");
         engine.setBuffer(buffer);
         Selection s = engine.getSelection();
         s.setBeginIndex(1);
         s.setEndIndex(1);
         engine.delete();
         assertEquals(buffer,"toto");
         int beg = s.getBeginIndex();
         int end = s.getEndIndex();
         assertEquals(beg,1);
         assertEquals(end,1);
    }
    
    @Test
    void testdelete4() {
    	 EngineImpl engine = new EngineImpl();
         StringBuilder buffer = new StringBuilder("toto");
         engine.setBuffer(buffer);
         Selection s = engine.getSelection();
         s.setBeginIndex(1);
         s.setEndIndex(2);
         engine.delete();
         assertEquals(buffer,"tto");
         int beg = s.getBeginIndex();
         int end = s.getEndIndex();
         assertEquals(beg,1);
         assertEquals(end,1);
    }
    
    @Test
    void testdelete5() {
    	 EngineImpl engine = new EngineImpl();
         StringBuilder buffer = new StringBuilder("toto");
         engine.setBuffer(buffer);
         Selection s = engine.getSelection();
         s.setBeginIndex(0);
         s.setEndIndex(4);
         engine.delete();
         assertEquals(buffer,"");
         int beg = s.getBeginIndex();
         int end = s.getEndIndex();
         assertEquals(beg,0);
         assertEquals(end,0);
    }
    
    @Test
    void testgetbuffer() {
    	EngineImpl engine = new EngineImpl();
        StringBuilder buffer = new StringBuilder("");
        engine.setBuffer(buffer);
         String s = engine.getBuffer().toString();
         assertEquals(s,"");
         
    }
    
    @Test
    void testgetbuffer1() {
    	EngineImpl engine = new EngineImpl();
        StringBuilder buffer = new StringBuilder("t");
        engine.setBuffer(buffer);
         String s = engine.getBuffer().toString();
         assertEquals(s,"t");
         
    }
    
    @Test
    void testgetbuffer2() {
    	EngineImpl engine = new EngineImpl();
        StringBuilder buffer = new StringBuilder("toto");
        engine.setBuffer(buffer);
         String s = engine.getBuffer().toString();
         assertEquals(s,"toto");
         
    }
    
    @Test
    void testsetbuffer() {
    	EngineImpl engine = new EngineImpl();
        StringBuilder buffer = new StringBuilder("");
        engine.setBuffer(buffer);
        StringBuilder buffer1 = new StringBuilder("t");
        engine.setBuffer(buffer1);
         String s = engine.getBuffer().toString();
         assertEquals(s,"t");
         
    }

   

   

   
}