package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.model.*;
import it.polito.tdp.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.*;

public class FXMLController {
	
	Dictionary dizionario = new Dictionary();
	List<String> traduzioni = new ArrayList<String>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClearText;

    @FXML
    private Button btnTraslate;

    @FXML
    private Label labelAT;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtInput;

    @FXML
    void doClearText(ActionEvent event) {
    	txtInput.clear();
    	txtArea.clear();
    	this.txtInput.setDisable(false);

    }

    @FXML
    void doTraslate(ActionEvent event) {
    	String parole = this.txtInput.getText();
    	String s[] = parole.split(" ");
    	
    	if(s.length>1) {
    	
    		String parola = s[0].toLowerCase();
    	    String traduzione = s[1].toLowerCase();
    	
    	if(!parola.matches("[a-zA-Z]*")) {
    		this.txtArea.setText("La parola aliena inserita contiene caratteri non ammessi\n");
    		return;
    	}
    	if(!traduzione.matches("[a-zA-Z]*")) {
    		this.txtArea.appendText("La traduzione inserita contiene caratteri non ammessi\n");
    		return;
    	}
    	
    	ParolaAliena p = new ParolaAliena(parola,traduzione);
    	this.dizionario.aggiungiParola(p);
    	this.txtArea.setText("Inserimento avvenuto correttamente.\nPremere ClearText e iniziare una nuova operazione");
    	this.txtInput.setDisable(true);
    	
    	}else {
    		String parola = s[0].toLowerCase();
    		if(!parola.matches("[a-zA-Z]*")) {
        		this.txtArea.setText("La parola inserita contiene caratteri non ammessi\n");
        		return;
        	}
    		
    		traduzioni = this.dizionario.traduzione(parola);
    		if(traduzioni.size()>0) {
    			if(traduzioni.size()==1) {
    				this.txtArea.setText("La traduzione di "+parole+" e\' "+traduzioni.get(0));
    				this.txtArea.appendText("\nPremere ClearText e iniziare una nuova operazione");
    				this.txtInput.setDisable(true);
    				}else {
    					this.txtArea.setText("Le traduzioni di "+parole+" sono: "+"\n");
    					for(String si:traduzioni) {
    						this.txtArea.appendText(si+"\n");
    					}
    					this.txtArea.appendText("\nPremere ClearText e iniziare una nuova operazione");
        				this.txtInput.setDisable(true);
    				}
    		} else {
    			this.txtArea.setText("La traduzione di "+parole+" non e\' presente nel dizionario");
        		this.txtArea.appendText("\nPremere ClearText e iniziare una nuova operazione");
        		this.txtInput.setDisable(true);
    		}
    	}
    	
    		

    }

    @FXML
    void initialize() {
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTraslate != null : "fx:id=\"btnTraslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert labelAT != null : "fx:id=\"labelAT\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";

    }

} 

