package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Glumac;
import model.Izvodjenje;
import model.Karta;
import model.Posetilac;
import model.Predstava;
import model.Scena;
import model.Uloga;
import model.Zanr;
import util.JPAUtil;

public class Controller {
	
	private static EntityManager em = null;
	private static EntityTransaction et = null;
	
	static {
		
		em = JPAUtil.getEntityManager();
	}
	

	
	public static Posetilac addPosetilac(String ime, String prezime) {
		
		et = em.getTransaction();
		
		try {
			
			et.begin();
			
			Posetilac p = new Posetilac();
			p.setIme(ime);
			p.setPrezime(prezime);
			
			em.persist(p);
			
			em.flush();
			
			et.commit();
			
			return p;
			
		} catch(Exception e) {
			e.printStackTrace();
			et.rollback();
			return null;
		}
	}
	
	public static List<Izvodjenje> getIzvodjenja(String nazPredstave){
		
		String upit = "select i from Izvodjenje i where i.predstava.naziv like :naziv";
		
		return em.createQuery(upit, Izvodjenje.class)
				 .setParameter("naziv", nazPredstave)
				 .getResultList();
	}
	
	public static Glumac addGlumac(String ime, String prezime, String jmbg) {
		
		et = em.getTransaction();
		
		try {
			
			et.begin();
			
			Glumac g = new Glumac();
			g.setPrezime(prezime);
			g.setIme(ime);
			g.setJmbg(jmbg);
			
			em.persist(g);
			
			em.flush();
			
			et.commit();
			
			return g;
			
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
			return null;
		}
	}
	
	public static List<Predstava> getSvePredstave() {
		
		return em.createQuery("select p from Predstava p", Predstava.class).getResultList();
	}
	
	public static Uloga addUloga(String naziv, Glumac g, Predstava p) {
		
		et = em.getTransaction();
		
		try {
			
			et.begin();
			
			Uloga u = new Uloga();
			u.setGlumac(g);
			u.setNaziv(naziv);
			u.setPredstava(p);
			
			em.persist(u);
			
			em.flush();
			
			et.commit();
			
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
			return null;
		}
	}
	
	public static Predstava getPredstava(Integer id) {
		
		return em.find(Predstava.class, id);
	}
	
	public static List<Zanr> getZanrovi(){
		
		return em.createQuery("select z from Zanr z", Zanr.class).getResultList();
	}
	
	public static List<Predstava> getPredstaveZaZanr(Integer idZ){
		
		String upit = "select p from Predstava p where p.zanr.idZanr = :idZanr";
		
		return em.createQuery(upit, Predstava.class)
				 .setParameter("idZanr", idZ)
				 .getResultList();
	}
	
	public static List<Uloga> getUlogeZaPredstavu(Integer idPredstave){
		
		String upit = "select u from Uloga u where u.predstava.idPredstava = :idP";
		
		return em.createQuery(upit, Uloga.class)
				 .setParameter("idP", idPredstave)
				 .getResultList();
	}
	
	//METODE ZA ZADATAK PRIPREMA ZA KOLOKVIJUM ŠTO JE LIDIJA OKACILA
	
	public static List<Uloga> getUloge(String ime, String prez){
		
		String upit = "select u from Uloga u "
					+ "where u.glumac.ime like :ime and u.glumac.prezime like :prez";
		
		return em.createQuery(upit, Uloga.class)
				 .setParameter("ime", ime)
				 .setParameter("prez", prez)
				 .getResultList();
	}
	
	public static Posetilac getPosetilac(Integer idPosetilac) {
		
		return em.find(Posetilac.class, idPosetilac);
	}
	
	public static List<Karta> getRezervisaneKarte(Integer idPosetilac){
		
		String upit = "select k from Karta k "
					+ "where k.posetilac.idPosetilac like :idP and k.datumRezervacije is not null";
		
		return em.createQuery(upit, Karta.class)
				 .setParameter("idP", idPosetilac)
				 .getResultList();
	}
	
	public static boolean isPlacena(Integer idKarta) {
		
		String upit = "select k from Karta k "
					+ "where k.idKarta like :idKarta and k.datumPlacanja is not null";
		
		Karta k = (Karta) em.createQuery(upit, Karta.class)
						    .setParameter("idKarta", idKarta)
						    .getResultList()
						    .stream()
						    .findFirst()
						    .orElseGet(null);
		
		return k != null ? true : false;
	}
	
//	METODE ZA ZARKOV ZADATAK
	
	public static List<Scena> getSveScene() {
			
		return em.createQuery("select s from Scena s", Scena.class).getResultList();
	}
	
	public static List<Izvodjenje> getIzvodjenjaNaSceni(Integer idScena){
		
		String upit = "select i from Izvodjenje i where i.scena.idScena = :idScena";
		
		return em.createQuery(upit, Izvodjenje.class)
				 .setParameter("idScena", idScena)
				 .getResultList();
	}
	
	public static List<Glumac> getGlumciZaPredstavu(Integer idPredstava){
		
		String upit = "select g from Glumac g inner join g.ulogas u "
					+ "where u.predstava.idPredstava like :idP";
		
		return em.createQuery(upit, Glumac.class)
				 .setParameter("idP", idPredstava)
				 .getResultList();
	
	}
	
	public static List<Uloga> getUloge(Integer idPredstava){
		
		String upit = "select u from Uloga u where u.predstava.idPredstava = :idPredstava";
		
		return em.createQuery(upit, Uloga.class).setParameter("idPredstava", idPredstava).getResultList();
	}
	

}
