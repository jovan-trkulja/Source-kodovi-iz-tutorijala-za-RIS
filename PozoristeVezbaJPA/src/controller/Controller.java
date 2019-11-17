package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Glumac;
import model.Izvodjenje;
import model.Posetilac;
import model.Predstava;
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

}
