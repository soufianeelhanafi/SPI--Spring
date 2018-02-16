package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.business.EnseignantBuisinessJPATest.EnseignantRepositoryList;
import fr.univbrest.dosi.repositories.EnseignantRepository;
import fr.univbrest.dosi.repositories.PromotionRepository;

public class PromotionBusinessJPATest {

	
	
	PromotionBuisness buisiness ; 
	
	@Test
	public void doitCreerUnePromotion() {
		
		PromotionRepository repos = new PromotionRepositoryList();
		
		buisiness = new PromotionBusinessJPA(repos);
		
		Promotion  Promotion1 = new Promotion( new PromotionPK ( "2014-2015" , "M2DOSI") ) ; 
		
		Promotion  Promotion2 = new Promotion( new PromotionPK ( "2015-2016" , "M2DOSI") ) ; 
		
		buisiness.creerPrmotion(Promotion1);
		buisiness.creerPrmotion(Promotion2);
		
		
		assertThat(repos.count()).isEqualTo(2);
	}
	
	@Test
	public void doitSupprimerUnePromotion() {
		
		PromotionRepository repos = new PromotionRepositoryList();
		
		buisiness = new PromotionBusinessJPA(repos);
		
		Promotion  Promotion1 = new Promotion( new PromotionPK ( "2014-2015" , "M2DOSI") ) ; 
		
		Promotion  Promotion2 = new Promotion( new PromotionPK ( "2015-2016" , "M2DOSI") ) ; 
		
		buisiness.creerPrmotion(Promotion1);
		buisiness.creerPrmotion(Promotion2);
		
		buisiness.supprimer(Promotion1);
		
		assertThat(repos.count()).isEqualTo(1);
	}
	
	@Test
	public void doitRechercherUnePromotionById() {
		
		PromotionRepository repos = new PromotionRepositoryList();
		
		buisiness = new PromotionBusinessJPA(repos);
		
		Promotion  Promotion1 = new Promotion( new PromotionPK ( "2014-2015" , "M2DOSI2") ) ; 
		
		Promotion  Promotion2 = new Promotion( new PromotionPK ( "2015-2016" , "M2DOSI") ) ; 
		
		buisiness.creerPrmotion(Promotion1);
		buisiness.creerPrmotion(Promotion2);
		
		
		
		assertThat(buisiness.findById(new PromotionPK ( "2015-2016" , "M2DOSI")).getId().getCodeFormation()).isEqualTo("M2DOSI");
	}
	
	

	@Test
	public void doitReccupererToutPromotions() {
		
		PromotionRepository repos = new PromotionRepositoryList();
		
		buisiness = new PromotionBusinessJPA(repos);
		
		Promotion  Promotion1 = new Promotion( new PromotionPK ( "2014-2015" , "M2DOSI") ) ; 
		
		Promotion  Promotion2 = new Promotion( new PromotionPK ( "2015-2016" , "M2DOSI") ) ; 
		
		buisiness.creerPrmotion(Promotion1);
		buisiness.creerPrmotion(Promotion2);
		
		
		assertThat(buisiness.getAllPromotion().size()).isEqualTo(2);
	}
	
	@Test
	public void doitReccupererToutPromotionsByNoEnseignant() {
		
		PromotionRepository repos = new PromotionRepositoryList();
		
		buisiness = new PromotionBusinessJPA(repos);
		
		Promotion  Promotion1 = new Promotion( new PromotionPK ( "2014-2015" , "M2DOSI")  , BigDecimal.valueOf(1).movePointLeft(2) ) ; 
		
		Promotion  Promotion2 = new Promotion( new PromotionPK ( "2015-2016" , "M2DOSI") , BigDecimal.valueOf(2).movePointLeft(2) ) ; 
		
		buisiness.creerPrmotion(Promotion1);
		buisiness.creerPrmotion(Promotion2);
		
		
		assertThat(buisiness.getPromotionsByNoEnseignant(BigDecimal.valueOf(1).movePointLeft(2)).size()).isEqualTo(1);
	}



public class PromotionRepositoryList implements  PromotionRepository
{

	
	private List<Promotion> data;
	
	public PromotionRepositoryList() 
	{
		data = Lists.newArrayList(); 
	}

	@Override
	public <S extends Promotion> S save(S entity) {

		data.add(entity) ;
		return entity ;
	}

	@Override
	public <S extends Promotion> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Promotion findOne(PromotionPK id) 
	{
		for ( Promotion promo : data)
		{
			if (promo.getId().equals(id))
			return promo ;
		}
		return null ; 
	}

	@Override
	public boolean exists(PromotionPK id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Promotion> findAll() 
	{
		return data ; 
	}

	@Override
	public Iterable<Promotion> findAll(Iterable<PromotionPK> ids) {
		return data ; 
	}

	@Override
	public long count() {
		return 	data.size() ;
	}

	@Override
	public void delete(PromotionPK id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Promotion entity) {
		data.remove(entity);
		
	}

	@Override
	public void delete(Iterable<? extends Promotion> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Promotion> findPromotionById(PromotionPK id) {
		return data.stream().filter(e -> e.getId().equals(id)).collect(Collectors.toList());
	}

	@Override
	public List<Promotion> findPromotionBynoEnseignant(BigDecimal num) {
		return data.stream().filter(e -> e.getNoEnseignant().equals(num)).collect(Collectors.toList());
	}


}
}
