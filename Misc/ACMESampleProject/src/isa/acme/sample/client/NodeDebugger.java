package isa.acme.sample.client;

import isa.acme.toolkit.client.IOtypes.INtype;
import isa.acme.toolkit.client.widgetInterfaces.AWidget;
import acme.client.core.Node.NodeController;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;

/**
 * 
 * Ejemplo de un widget para mostrar informaci�n de un nodo. Se mostrar�, con un
 * estilo m�nimo, informaci�n del nodo (elegida aleatoriamente a modo de ilustraci�n).
 * 
 */

public class NodeDebugger extends AWidget implements INtype<NodeController>{
	
	/** El panel que englobar� los elementos de informaci�n que queramos a�adir. */
	private Panel debuggerPanel = new AbsolutePanel();
	
	public NodeDebugger() {
		
		//Podemos asignar aqu� el estilo por defecto del widget. Se recomienda, si se
		//est� creando un widget gen�rico para ACME, nombrar el estilo como:
		//	ACME-<nombre de la clase>
		setStyleName("ACME-NodeDebugger");
		
		//IMPORTANTE: todos las clases que extiendan a AWidget, heredan el campo "widgetPanel".
		//Es aqu� donde se deben a�adir todos los Widget (me refiero a widgets de GWT).
		
		//A�adimos una etiqueta que har� las veces de t�tulo para el widget.
		this.widgetPanel.add(new Label("Debugger panel"));
		
		//Despu�s de la etiqueta a�adimos el panel que ir� cambiando de contenido
		//cuando el nodo que se observa se modifique.
		this.widgetPanel.add(debuggerPanel);
	}
	
	/** M�todo privado para ayudarnos a rellenar el widget.*/
	private void showNodeContents(NodeController target) {
		
		//Borramos el contenido actual (o anterior, seg�n se vea) del panel.
		this.debuggerPanel.clear();
		
		//A�adimos 3 etiquetas con informaci�n elegida al azar (n�mero de hijos,
		//n�mero de instancia de ese tipo de nodo en el �rbol, y el nombre del tipo de nodo).
		this.debuggerPanel.add( new Label("Children all count: "+target.getAllChildren().size()) );
		this.debuggerPanel.add( new Label("Instance num: "+target.getInst()) );
		this.debuggerPanel.add( new Label("Type: "+target.getNodeType().getDisplayName()) );
	}

	
	/** Este es el m�todo que se ejecutar� cuando el observado cambie. En nuestro caso
	 * tenemos que actualizar la interfaz con la informaci�n del nodo "target". Por lo tanto
	 * llamamos al m�todo privado que hemos definido anteriormente, con el nodo "target" como
	 * par�metro. */
	@Override
	public void updateObserver(NodeController target) {
		this.showNodeContents(target);	
	}

	

}
