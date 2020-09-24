package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

public class Controller {

    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }


    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }


    public HTMLDocument getDocument() {
        return document;
    }


    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();

    }

    public void setPlainText(String text){
        resetDocument();
        try {
            StringReader stringReader = new StringReader(text);
            new HTMLEditorKit().read(stringReader, document,0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        try {
            StringWriter stringWriter = new StringWriter();

           new HTMLEditorKit().write(stringWriter, document,0, document.getLength());
           return stringWriter.toString();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return null;
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;

    }
    public void openDocument(){

    }

    public void saveDocument(){

    }
    public void saveDocumentAs(){

    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();

    }




}
