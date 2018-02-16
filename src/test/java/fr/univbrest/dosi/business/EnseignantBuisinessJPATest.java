package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.FormationBusinessJPATest.FormationRepositoryList;
import fr.univbrest.dosi.repositories.EnseignantRepository;
import fr.univbrest.dosi.repositories.FormationRepository;
import junit.framework.Assert;

public class EnseignantBuisinessJPATest {
	
	EnseignantBusiness business ;
	
	@Test
	public void doitCreerUnEnseignant() {
		
		EnseignantRepository repos = new EnseignantRepositoryList();
		
		business = new EnseignantBuisnessJPA(repos);
		
		Enseignant Enseignant1 = new Enseignant(1 , "mekness" ,"soufiane8elhanafi@gamil.com", "el hanafi" , "soufiane") ; 
		
		Enseignant res = business.creerEnseignant(Enseignant1);
		
		assertThat(repos.count()).isEqualTo(1);
	}
	
	@Test
	public void doitsupprimerEnseignat() {
		
		EnseignantRepository repos = new EnseignantRepositoryList();
		
		business = new EnseignantBuisnessJPA(repos);
		
		Enseignant Enseignant1 = new Enseignant(1 , "mekness" ,"soufiane8elhanafi@gamil.com", "el hanafi" , "soufiane") ; 
		Enseignant Enseignant2 = new Enseignant(2, "mekness" ,"soufiane8elhanafi@gamil.com", "el hanafi" , "soufiane") ; 
		
		business.creerEnseignant(Enseignant1);
		business.creerEnseignant(Enseignant2);
		
		business.supprimer(Enseignant1);
		assertThat(repos.count()).isEqualTo(1);
	}
	
	@Test
	public void doitTrouverEnseignatParNom() {
		
		EnseignantRepository repos = new EnseignantRepositoryList();
		
		business = new EnseignantBuisnessJPA(repos);
		
		Enseignant Enseignant1 = new Enseignant(1 , "mekness" ,"soufiane8elhanafi@gamil.com", "el hanafi" , "soufiane") ; 
		Enseignant Enseignant2 = new Enseignant(2, "mekness" ,"soufiane8elhanafi@gamil.com", "regragui" , "mehdi") ; 
		
		business.creerEnseignant(Enseignant1);
		business.creerEnseignant(Enseignant2);
		
		assertThat(repos.findBynom("regragui").size()).isEqualTo(1);
	}
	
	@Test
	public void doitTrouverEnseignatParNoEnseignant() {
		//a voir avec le prof
		EnseignantRepository repos = new EnseignantRepositoryList();
		
		business = new EnseignantBuisnessJPA(repos);
		
		Enseignant Enseignant1 = new Enseignant(1 , "mekness" ,"soufiane8elhanafi@gamil.com", "el hanafi" , "soufiane") ; 
		Enseignant Enseignant2 = new Enseignant(2, "mekness" ,"soufiane8elhanafi@gamil.com", "regragui" , "mehdi") ; 
		
		business.creerEnseignant(Enseignant1);
		business.creerEnseignant(Enseignant2);
	
		assertThat((business.findById((long) 1).getNom().equals("el hanafi")));
	}
	
	@Test
	public void doitTrouverAllEnseignants (){
	
		EnseignantRepository repos = new EnseignantRepositoryList();
		
		business = new EnseignantBuisnessJPA(repos);
		
		Enseignant Enseignant1 = new Enseignant(1 , "mekness" ,"soufiane8elhanafi@gamil.com", "el hanafi" , "soufiane") ; 
		Enseignant Enseignant2 = new Enseignant(2, "mekness" ,"soufiane8elhanafi@gamil.com", "regragui" , "mehdi") ; 
		
		business.creerEnseignant(Enseignant1);
		business.creerEnseignant(Enseignant2);

		 List<Enseignant> data = Lists.newArrayList(); 
		 data.add(Enseignant2) ; 
		 data.add(Enseignant1) ; 
		 
		 assertThat(business.getAllEnseignants().size()).isEqualTo(2);

	}
	
	
	
	
	public class EnseignantRepositoryList implements EnseignantRepository 
	{
		
		private List<Enseignant> data;
		
		public EnseignantRepositoryList() 
		{
			data = Lists.newArrayList(); 
		}

		@Override
		public <S extends Enseignant> S save(S entity) {
			
			data.add(entity) ;
			return entity ; 
		}

		@Override
		public <S extends Enseignant> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Enseignant findOne(Long id) {
			return data.get((int) (long) id ) ;
		
		}

		@Override
		public boolean exists(Long id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public List<Enseignant> findAll() {
			return data ;
		}

		@Override
		public Iterable<Enseignant> findAll(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
		   return 	data.size() ; 
		}

		@Override
		public void delete(Long id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Enseignant entity) {
			data.remove(entity);
			
		}

		@Override
		public void delete(Iterable<? extends Enseignant> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Enseignant> findBynom(String nom) {
			return data.stream().filter(e -> e.getNom().equals(nom)).collect(Collectors.toList());
		}

		@Override
		public Enseignant findBynoEnseignant(Long id) {
		  return (Enseignant) data.stream().filter(e -> e.getNoEnseignant() ==id ).collect(Collectors.toList());
		}

	}
}
