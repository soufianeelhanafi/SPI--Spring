package fr.univbrest.dosi.business;

import java.math.BigDecimal;
import java.util.List;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repositories.PromotionRepository;

public interface PromotionBuisness  {
	
	Promotion creerPrmotion( Promotion promotion );
	void supprimer ( PromotionPK id);
	void supprimer ( Promotion promotion ) ;
	List <Promotion> getAllPromotion() ;
	Promotion findById (PromotionPK id) ; 
	Promotion MajPromotion ( Promotion promotion) ; 
	List <Promotion> getPromotionsByNoEnseignant(BigDecimal num ) ;

}
