package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;


import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FXMLController {
	
	private Parole elenco ;
	private long tempo0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Label txtTime;
    
    void updateTxt() {
    	List <String> paroleOrdinate = elenco.getElenco();
    	String risultato = "";
    	for (String s : paroleOrdinate)
    		risultato+=" "+s;
    	txtResult.setText(risultato);
    }

    @FXML
    void doInsert(ActionEvent event) {
    	tempo0 = System.nanoTime();
    	// TODO
    	String parola = txtParola.getText();
    	elenco.addParola(parola);
    	txtParola.clear();
    	updateTxt();
    	txtTime.setText("Tempo esecuzione: "+ (System.nanoTime() - tempo0)/1000+" us.");
    }

    @FXML
    void doReset(ActionEvent event) {
    	tempo0 = System.nanoTime();
    	// TODO
    	elenco.reset();
    	txtResult.clear();
    	txtTime.setText("Tempo esecuzione: "+ (System.nanoTime() - tempo0)/1000+" us.");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	tempo0 = System.nanoTime();
    	// TODO
    	String parola = txtResult.getSelectedText();
    	elenco.delParola(parola);
    	updateTxt();
    	txtTime.setText("Tempo esecuzione: "+ (System.nanoTime() - tempo0)/1000+" us.");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
