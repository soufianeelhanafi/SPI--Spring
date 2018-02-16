package fr.univbrest.dosi.business;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repositories.PromotionRepository;

@Service
public class PromotionBusinessJPA  implements PromotionBuisness
{

	PromotionRepository repos ; 
	
	@Autowired
	public PromotionBusinessJPA ( PromotionRepository repos )
	{
		this.repos = repos ; 
	}

	@Override
	public Promotion creerPrmotion(Promotion promotion) {
		
		return this.repos.save(promotion) ; 
	}

	@Override
	public void supprimer(PromotionPK id) {
		
		 this.repos.delete(id);
		
	}

	@Override
	public void supprimer(Promotion promotion) {
		
		this.repos.delete(promotion);
	}

	@Override
	public List<Promotion> getAllPromotion() {
		// TODO Auto-generated method stub
		return (List<Promotion>) this.repos.findAll() ; 
	}

	@Override
	public Promotion findById(PromotionPK id) {
		
		return this.repos.findOne(id);
	}

	@Override
	public Promotion MajPromotion(Promotion promotion) {
		return this.repos.save(promotion) ; 
	}

	@Override
	public List<Promotion> getPromotionsByNoEnseignant(BigDecimal num) {
		
		return this.repos.findPromotionBynoEnseignant(num) ;
	}


	
}
