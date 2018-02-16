package fr.univbrest.dosi.contolleur;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.business.PromotionBuisness;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/promotions")
public class PromotionController {
	
	private PromotionBuisness buisness ; 
	
	@Autowired
	public  PromotionController (PromotionBuisness  buisness)
	{
		this.buisness = buisness ; 
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public List<Promotion> recupererToutPromotions()
	{
		return buisness.getAllPromotion() ;
	}
	

	
	@RequestMapping(method = RequestMethod.GET , value="/Annee/{annee}/CodeForm/{code}")
	public Promotion recupererUnePromotionById (@PathVariable("annee") String annee, @PathVariable("code") String code)
	{
		PromotionPK pk = new PromotionPK(annee , code) ;
		return buisness.findById(pk);
	}
	@RequestMapping(method = RequestMethod.GET , value="/Ens/{Ens}")
	public List<Promotion> recupererUnePromotionByNumEnseignant (@PathVariable BigDecimal  Ens)
	{
	
		return buisness.getPromotionsByNoEnseignant(Ens) ;
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public Promotion creerPromotion(@RequestBody Promotion promotion ) {
		return buisness.creerPrmotion(promotion) ;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Promotion MajPromotion(@RequestBody Promotion promotion ) {
		return buisness.MajPromotion(promotion) ;
	}
	
	@RequestMapping(method = RequestMethod.DELETE ,  value="/Annee/{annee}/CodeForm/{code}")
	public void  supprimerPromotion(@PathVariable("annee") String annee, @PathVariable("code") String code) {
		
		PromotionPK pk = new PromotionPK(annee , code) ;
		buisness.supprimer(pk); 
		 
	}
	
	
	

}
