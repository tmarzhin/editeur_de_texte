package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import command.*;
import command.Insert;
import invoker.CommandInvoker;
import memento.*;
import memento.RecorderImpl;
import receiver.EngineImpl;
import receiver.Selection;
import undoRedo.UndoRedoImpl;

public class TestRecorder {
	RecorderImpl recorder ;
	EngineImpl engine ;
	CommandInvoker ci;
	UndoRedoImpl undoredo;
	Copy copier;
	Cut couper;
	Delete supprimer;
	Paste coller;
	Insert inserer;
	
	@org.junit.jupiter.api.BeforeEach
    void setUp() {
		recorder = new RecorderImpl();
		engine = new EngineImpl();
		ci = new CommandInvoker();
		undoredo = new UndoRedoImpl(engine);
		copier = new Copy(engine,recorder,undoredo);
		couper = new Cut(engine,recorder,undoredo);
		supprimer = new Delete(engine,recorder,undoredo);
		coller = new Paste(engine,recorder,undoredo);
		inserer = new Insert(engine,recorder,undoredo);
        
    }
	
	@Test
	public void testsetMemento()  {
		InsertMemento m = new InsertMemento("test");
		CopyMemento copym = new CopyMemento();
		CutMemento cutm = new CutMemento();
		PasteMemento pastem = new PasteMemento();
		
		recorder.start();
		inserer.setMemento(m);
		inserer.execute();
		recorder.save(inserer);
		Selection selec = engine.getSelection();
		selec.setBeginIndex(0);
		selec.setEndIndex(4);
		copier.setMemento(copym);
		copier.execute();
		recorder.save(copier);
		selec.setBeginIndex(4);
		selec.setEndIndex(4);
		coller.setMemento(pastem);
		coller.execute();
		recorder.save(coller);
		selec.setBeginIndex(4);
		selec.setEndIndex(8);
		couper.setMemento(cutm);
		couper.execute();
		recorder.save(couper);
		recorder.stop();
		
		Selection selection = engine.getSelection();
		String buffer = engine.getBufferContents();
		String clipboard = engine.getClipboardContents();
		
		assertTrue(buffer.equals("test"));
		assertTrue(clipboard.equals("test"));
		assertTrue(selection.getBeginIndex()==4);
		assertTrue(selection.getEndIndex()==4);
		
	}

	@Test
	public void testsuppr()  {
		InsertMemento m = new InsertMemento("test");
		DeleteMemento delm = new DeleteMemento();
		
		recorder.start();
		inserer.setMemento(m);
		inserer.execute();
		recorder.save(inserer);
		Selection selec = engine.getSelection();
		selec.setBeginIndex(0);
		selec.setEndIndex(4);
		supprimer.setMemento(delm);
		supprimer.execute();
		selec.setBeginIndex(0);
		selec.setEndIndex(0);
		supprimer.execute();
		inserer.execute();
		selec.setBeginIndex(0);
		selec.setEndIndex(1);
		supprimer.execute();
		recorder.stop();
		
		Selection selection = engine.getSelection();
		String buffer = engine.getBufferContents();
		String clipboard = engine.getClipboardContents();
		
		assertTrue(buffer.equals("est"));
		assertTrue(clipboard.equals(""));
		assertTrue(selection.getBeginIndex()==0);
		assertTrue(selection.getEndIndex()==0);
		
	}
	
	@Test
	public void testcopy()  {
		InsertMemento m = new InsertMemento("");
		InsertMemento m1 = new InsertMemento("test");
		CopyMemento copym = new CopyMemento();
		
		
		recorder.start();
		inserer.setMemento(m);
		inserer.execute();
		recorder.save(inserer);
		Selection selec = engine.getSelection();
		selec.setBeginIndex(0);
		selec.setEndIndex(0);
		copier.setMemento(copym);
		copier.execute();
		inserer.setMemento(m1);
		selec.setBeginIndex(0);
		selec.setEndIndex(0);
		inserer.execute();
		selec.setBeginIndex(0);
		selec.setEndIndex(2);
		copier.execute();
		recorder.stop();
		
		Selection selection = engine.getSelection();
		String buffer = engine.getBufferContents();
		String clipboard = engine.getClipboardContents();
		
		assertTrue(buffer.equals("test"));
		assertTrue(clipboard.equals("te"));
		assertTrue(selection.getBeginIndex()==2);
		assertTrue(selection.getEndIndex()==2);
		
	}
	
	@Test
	public void testcut()  {
		InsertMemento m = new InsertMemento("");
		InsertMemento m1 = new InsertMemento("test");
		CutMemento cutm = new CutMemento();

		
		recorder.start();
		inserer.setMemento(m);
		inserer.execute();
		recorder.save(inserer);
		Selection selec = engine.getSelection();
		selec.setBeginIndex(0);
		selec.setEndIndex(0);
		couper.setMemento(cutm);
		couper.execute();
		inserer.setMemento(m1);
		selec.setBeginIndex(0);
		selec.setEndIndex(0);
		inserer.execute();
		selec.setBeginIndex(0);
		selec.setEndIndex(2);
		couper.execute();
		recorder.stop();
		
		Selection selection = engine.getSelection();
		String buffer = engine.getBufferContents();
		String clipboard = engine.getClipboardContents();
		
		assertTrue(buffer.equals("st"));
		assertTrue(clipboard.equals("te"));
		assertTrue(selection.getBeginIndex()==0);
		assertTrue(selection.getEndIndex()==0);
		
	}
	
	@Test
	public void testpaste()  {
		InsertMemento m = new InsertMemento("test");
		PasteMemento pastem = new PasteMemento();
		CopyMemento copym = new CopyMemento();

		
		recorder.start();
		inserer.setMemento(m);
		inserer.execute();
		recorder.save(inserer);
		Selection selec = engine.getSelection();
		selec.setBeginIndex(0);
		selec.setEndIndex(0);
		coller.setMemento(pastem);
		coller.execute();
		selec.setBeginIndex(0);
		selec.setEndIndex(2);
		copier.setMemento(copym);
		copier.execute();
		selec.setBeginIndex(4);
		selec.setEndIndex(4);
		coller.setMemento(pastem);
		coller.execute();
		recorder.stop();
		
		Selection selection = engine.getSelection();
		String buffer = engine.getBufferContents();
		String clipboard = engine.getClipboardContents();
		
		assertTrue(buffer.equals("testte"));
		assertTrue(clipboard.equals("te"));
		assertTrue(selection.getBeginIndex()==6);
		assertTrue(selection.getEndIndex()==6);
		
	}
	
	@Test
	public void testreplay()  {
		InsertMemento m = new InsertMemento("test");
		CopyMemento copym = new CopyMemento();
		CutMemento cutm = new CutMemento();
		PasteMemento pastem = new PasteMemento();
		
		recorder.start();
		inserer.setMemento(m);
		inserer.execute();
		recorder.save(inserer);
		Selection selec = engine.getSelection();
		selec.setBeginIndex(0);
		selec.setEndIndex(4);
		copier.setMemento(copym);
		copier.execute();
		recorder.save(copier);
		selec.setBeginIndex(4);
		selec.setEndIndex(4);
		coller.setMemento(pastem);
		coller.execute();
		recorder.save(coller);
		selec.setBeginIndex(4);
		selec.setEndIndex(8);
		couper.setMemento(cutm);
		couper.execute();
		recorder.save(couper);
		recorder.stop();
		
		Selection selection = engine.getSelection();
		String buffer = engine.getBufferContents();
		String clipboard = engine.getClipboardContents();
		
		assertTrue(buffer.equals("test"));
		assertTrue(clipboard.equals("test"));
		assertTrue(selection.getBeginIndex()==4);
		assertTrue(selection.getEndIndex()==4);
		
		recorder.replay();
		
		assertTrue(buffer.equals("testtest"));
		assertTrue(clipboard.equals("test"));
		assertTrue(selection.getBeginIndex()==4);
		assertTrue(selection.getEndIndex()==4);
	}
	
	
}
