package beans;

import java.util.List;

import controller.Controller;
import model.Zanr;

public class ZanrBean {
	
	private List<Zanr> zanrovi;
	
	public ZanrBean() {
		
		zanrovi = Controller.getZanrovi();
	}

	public List<Zanr> getZanrovi() {
		return zanrovi;
	}

	public void setZanrovi(List<Zanr> zanrovi) {
		this.zanrovi = zanrovi;
	}
	

}
