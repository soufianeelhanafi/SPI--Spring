package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.CandidatRepository;
import fr.univbrest.dosi.repositories.FormationRepository;

public class CandidatBusinessJPATest {

	CandidatBusinessJPA buisness ;
	
	@Test
	public void creerCandidat ()
	{
		CandidatRepository repos = new CandidatRepositoryList ();
		buisness  = new CandidatBusinessJPA(repos);
		Candidat candidat1 = new Candidat("soufiane.elhanafi", "el hanafi", "soufiane", "mekness", "ENSAF") ; 
		Candidat candidat2 = new Candidat("mehdi.regragui", "regragui", "mehdi", "rabat", "ENSAT") ; 
		Candidat res = buisness.creerCandidat(candidat1) ; 
		//buisness.creerCandidat(candidat2) ; 
		System.out.println("+++++++++"+repos.count());
		
		assertThat(res.getNom()).isEqualTo("el hanafi") ; 
		assertThat(repos.count()).isEqualTo(1);
		
	}
	
	
	@Test 
	public void chercherCandidatByUniv ()
	{
		CandidatRepository repos = new CandidatRepositoryList ();
		buisness  = new CandidatBusinessJPA(repos);
		Candidat candidat1 = new Candidat("soufiane.elhanafi", "el hanafi", "soufiane", "mekness", "ENSAF") ; 
		Candidat candidat2 = new Candidat("mehdi.regragui", "regragui", "mehdi", "rabat", "ENSAT") ; 
		buisness.creerCandidat(candidat1) ; 
		buisness.creerCandidat(candidat2) ; 
		
		assertThat(buisness.findByuniversiteOrigine("ENSAT").size()).isEqualTo(1);
		
	}
	@Test 
	public void chercherCandidatByNom()
	{
		CandidatRepository repos = new CandidatRepositoryList ();
		buisness  = new CandidatBusinessJPA(repos);
		Candidat candidat1 = new Candidat("soufiane.elhanafi", "el hanafi", "soufiane", "mekness", "ENSAF") ; 
		Candidat candidat2 = new Candidat("mehdi.regragui", "regragui", "mehdi", "rabat", "ENSAT") ; 
		buisness.creerCandidat(candidat1) ; 
		buisness.creerCandidat(candidat2) ; 
		
		assertThat(buisness.findByNom("el hanafi").size()).isEqualTo(1);
		
		
		
	}
	
	@Test 
	public void SupprimerCandidat ()
	{
		
		CandidatRepository repos = new CandidatRepositoryList ();
		buisness  = new CandidatBusinessJPA(repos);
		Candidat candidat1 = new Candidat("soufiane.elhanafi", "el hanafi", "soufiane", "mekness", "ENSAF") ; 
		Candidat candidat2 = new Candidat("mehdi.regragui", "regragui", "mehdi", "rabat", "ENSAT") ; 
		buisness.creerCandidat(candidat1) ; 
		buisness.creerCandidat(candidat2) ; 
		
		buisness.supprimer(candidat1);
		
		assertThat(repos.count()).isEqualTo(1);
		
		
	}
	class CandidatRepositoryList implements CandidatRepository {

		List <Candidat> data; 
		
		public CandidatRepositoryList ()
		{
			data = Lists.newArrayList();
		}
		
		
		
		@Override
		public void delete (Candidat entity  ) 
		{
			data.remove(entity) ; 	
		}

		
		@Override
		public <S extends Candidat> S save (S entity ) 
		{
		     data.add(entity) ; 
		     return entity ; 
		}
		
		
		@Override
		public long count() {
			return data.size() ; 
		}

		

		@Override
		public void delete(Iterable<? extends Candidat> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean exists(String arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Candidat> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Candidat> findAll(Iterable<String> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Candidat findOne(String arg0) {
			
			return null;
		}

		

		@Override
		public <S extends Candidat> Iterable<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Candidat> findByNom(String nom) {
			
			return data.stream().filter(c -> c.getNom().equals(nom)).collect(Collectors.toList());
			
		}

		@Override
		public List<Candidat> findByuniversiteOrigine(String nomUniversite) {
			return data.stream().filter(c -> c.getUniversiteOrigine().equals(nomUniversite)).collect(Collectors.toList());
		}



		@Override
		public void delete(String arg0) {
			// TODO Auto-generated method stub
			
		}
	
		
		}

	
}
