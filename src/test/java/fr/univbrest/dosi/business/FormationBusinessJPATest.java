package fr.univbrest.dosi.business;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Formation;

import fr.univbrest.dosi.repositories.FormationRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class FormationBusinessJPATest {
	
	FormationBusinessJPA business;
	
	@Test
	public void doitCreerUneFormation() {
		
		FormationRepository repos = new FormationRepositoryList();
		
		business = new FormationBusinessJPA(repos);
		
		Formation formationACreer = new Formation("33", "M2", "N", BigDecimal.valueOf(2), "DOSI");
		
		Formation resultat = business.creerFormation(formationACreer);
		
		assertThat(resultat.getDebutAccreditation()).isCloseTo(new Date(), 500);
		
		assertThat(repos.count()).isEqualTo(1);
	}
	
	
	
	class FormationRepositoryList implements FormationRepository {
		private List<Formation> data;
		public FormationRepositoryList() {
			data = Lists.newArrayList();
		}
		@Override
		public <S extends Formation> S save(S entity) {
			this.data.add(entity);
			return entity;
		}

		@Override
		public <S extends Formation> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Formation findOne(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean exists(String id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Formation> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Formation> findAll(Iterable<String> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			return data.size();
		}

		@Override
		public void delete(String id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Formation entity) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Iterable<? extends Formation> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Formation> findByNomFormation(String nomFormation) {
			// TODO Auto-generated method stub
			return null;
		}}

}
