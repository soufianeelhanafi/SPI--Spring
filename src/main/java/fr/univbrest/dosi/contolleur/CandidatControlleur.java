package fr.univbrest.dosi.contolleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.CandidatBusiness;



@RestController
@RequestMapping("/candidats")
public class CandidatControlleur {

	private CandidatBusiness buisness ; 
	
	@Autowired
	public CandidatControlleur (CandidatBusiness buisness )
	{
		this.buisness= buisness ;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Candidat> recupererToutCandidats ()
	{
		return buisness.getAllCandidat() ;
	}
	
	@RequestMapping(method = RequestMethod.GET , value="/nom/{nom}")
	public List<Candidat> recupererUnCandidatsByNom (@PathVariable String nom)
	{
		return buisness.findByNom(nom) ;
	}
	
	@RequestMapping(method = RequestMethod.GET , value="/ID/{id}")
	public Candidat recupererUnCandidatsById (@PathVariable String id)
	{
		return buisness.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET , value="/UnivOrig/{UnivOrig}")
	public List<Candidat>  recupererUnCandidatsByUnivOrig (@PathVariable String UnivOrig)
	{
		return buisness.findByuniversiteOrigine(UnivOrig);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Candidat creerFormtion(@RequestBody Candidat candidat ) {
		return buisness.creerCandidat(candidat); 
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE ,  value="/{id}")
	public void  supprimerCandidat(@PathVariable String id) {
		 buisness.supprimer(id); 
		 
	}
	
	
	
	
}
