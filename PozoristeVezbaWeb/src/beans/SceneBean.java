package beans;

import java.util.List;

import controller.Controller;
import model.Scena;

public class SceneBean {
	
	private List<Scena> scene;
	
	public SceneBean() {
		
		this.scene = Controller.getSveScene();
	}
	
	public void setScene(List<Scena> scene) {
		this.scene = scene;
	}
	
	public List<Scena> getScene(){
		return scene;
	}

}
