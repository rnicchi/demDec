package it.mef.bilancio.demdec.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import it.mef.bilancio.demdec.dao.RiepilogoAdDemDao;

import it.mef.bilancio.demdec.to.RiepilogoAdDemTO;
import it.mef.bilancio.demdec.to.StrumentoTO;

import org.hibernate.Query;
public class RiepilogoAdDemDaoImpl extends AbstractDemDaoImpl<RiepilogoAdDemTO> implements RiepilogoAdDemDao {
	
	@Override
	public List<RiepilogoAdDemTO> findRiepilogoAdDemByAnnoTipoNum(Short annoEse, String tipo,Integer num) throws Throwable {
		// TODO Auto-generated method stub
		
		String q=" Select ese_anno_ese, att_nume_tipo, nume_num, flag_pos_neg_01, amm_ese_anno_ese, nume_eos, nume_tit, desc_tit, impo_varcas_eur, impo_varcomp1_eur, impo_varres_eur "+
				 " from D_RIEPILOGO_AD_DEM_PROVA where ese_anno_ese = :annoEse  "+
				" and att_nume_tipo = :tipo  "+
				" and  nume_num = :num "+
				"order by nume_eos,nume_tit, flag_pos_neg_01";
		
		Query query = createSQLQuery(q);
		query.setParameter("annoEse", annoEse)
		.setParameter("tipo", tipo)
		.setParameter("num", num);
		
		List<RiepilogoAdDemTO> listaTO = new ArrayList<RiepilogoAdDemTO>();

		Iterator<Object> iter = query.list().iterator();
		Object[] objArray=null;
		
		RiepilogoAdDemTO to = null;
		
		while (iter.hasNext()) {
			
			objArray= (Object[])iter.next();
			
			if(to == null)
			{
				to = new RiepilogoAdDemTO();
				to.setEseAnnoEse(objArray[0].toString());
				to.setAttNumeTipo(objArray[1].toString());
				to.setNumeNum(objArray[2].toString());
				to.setFlagPosNeg01(objArray[3].toString());
				to.setAmmEseAnnoEse(objArray[4].toString());
				to.setNumeEos(objArray[5].toString());
				to.setNumeTit(objArray[6].toString());
				to.setDescTit((String)objArray[7]);
				
				if(to.getFlagPosNeg01().equals("0"))
				{
					to.setImpoVarCasEurDim(objArray[8].toString());
					to.setImpoVarComp1EurDim(objArray[9].toString());
					to.setImpoVarResEurDim(objArray[10].toString());
				}
				else
				{
					to.setImpoVarCasEur(objArray[8].toString());
					to.setImpoVarComp1Eur(objArray[9].toString());
					to.setImpoVarResEur(objArray[10].toString());
				}
				
			}
			else
			{		
				/*ontrollo per quando non ci sono più elementi nella lista con cui fare confronti
				
				if(objArray[0]==null)
				{
					break;
				}
				*/
				
				if(!(to.getNumeTit().equals(objArray[6].toString())))
				{
							listaTO.add(to);
							
							to = new RiepilogoAdDemTO();
							to.setEseAnnoEse(objArray[0].toString());
							to.setAttNumeTipo(objArray[1].toString());
							to.setNumeNum(objArray[2].toString());
							to.setFlagPosNeg01(objArray[3].toString());
							to.setAmmEseAnnoEse(objArray[4].toString());
							to.setNumeEos(objArray[5].toString());
							to.setNumeTit(objArray[6].toString());
							to.setDescTit((String)objArray[7]);
							
							if(to.getFlagPosNeg01().equals("0"))
							{
								to.setImpoVarCasEurDim(objArray[8].toString());
								to.setImpoVarComp1EurDim(objArray[9].toString());
								to.setImpoVarResEurDim(objArray[10].toString());
							}
							else
							{
								to.setImpoVarCasEur(objArray[8].toString());
								to.setImpoVarComp1Eur(objArray[9].toString());
								to.setImpoVarResEur(objArray[10].toString());
							}
		
				}
				else
				{
					if((to.getNumeEos().equals(objArray[5].toString())))
					{			
					
						if( isEmpty(to.getImpoVarCasEur()))
						{
							to.setImpoVarCasEur(objArray[8].toString());
							to.setImpoVarComp1Eur(objArray[9].toString());
							to.setImpoVarResEur(objArray[10].toString());
						}
						else
						{
							to.setImpoVarCasEurDim(objArray[8].toString());
							to.setImpoVarComp1EurDim(objArray[9].toString());
							to.setImpoVarResEurDim(objArray[10].toString());
						}
						
					}
					else
					{
						listaTO.add(to);
						
						to = new RiepilogoAdDemTO();
						to.setEseAnnoEse(objArray[0].toString());
						to.setAttNumeTipo(objArray[1].toString());
						to.setNumeNum(objArray[2].toString());
						to.setFlagPosNeg01(objArray[3].toString());
						to.setAmmEseAnnoEse(objArray[4].toString());
						to.setNumeEos(objArray[5].toString());
						to.setNumeTit(objArray[6].toString());
						to.setDescTit((String)objArray[7]);
						
						if(to.getFlagPosNeg01().equals("0"))
						{
							to.setImpoVarCasEurDim(objArray[8].toString());
							to.setImpoVarComp1EurDim(objArray[9].toString());
							to.setImpoVarResEurDim(objArray[10].toString());
						}
						else
						{
							to.setImpoVarCasEur(objArray[8].toString());
							to.setImpoVarComp1Eur(objArray[9].toString());
							to.setImpoVarResEur(objArray[10].toString());
						}						
						
					}
					
				//	listaTO.add(to);
					
					
				}		
				
			}
		
			}
		
		listaTO.add(to);//aggiungo l'ultimo to
		
		return listaTO;
	}
	
	@Override
	public StrumentoTO findLeggeByRiepilogoAdDem(String eseAnnoEse, String attNumeTipo, String numeNum) {

		String q=" Select anno_leg as annoLeg, sigla as sigla, nume_leg as numeLeg, nume_art as numeArt, " +
				 " desc_sub_art as descSubArt, nume_comma as numeComma, desc_sub_comma as descSubComma, "+
				 " codi_punto as codiPunto, desc_sub_punto as descSubPunto "+
				 " FROM D_STRUMENTI_DEM where ese_anno_ese = :eseAnnoEse  "+
				" and att_nume_tipo = :attNumeTipo  "+
				" and  nume_num = :numeNum ";
		
		Query query = createSQLQuery(q);
		query.setParameter("eseAnnoEse", eseAnnoEse)
		.setParameter("attNumeTipo", attNumeTipo)
		.setParameter("numeNum", numeNum);
		
//		StrumentoTO strum = (StrumentoTO) query.setResultTransformer(Transformers.aliasToBean(StrumentoTO.class)).uniqueResult();
		Object[] objArray= (Object[])query.uniqueResult();
		StrumentoTO strum = new StrumentoTO();
		strum.setAnnoLeg(objArray[0].toString());
		strum.setSigla(objArray[1].toString());
		strum.setNumeLeg(objArray[2].toString());
		strum.setNumeArt(objArray[3].toString());
		
		if(objArray[4] != null)
			strum.setDescSubArt(objArray[4].toString());
		
		strum.setNumeComma(objArray[5].toString());
		
		if(objArray[6] != null)
			strum.setDescSubComma(objArray[6].toString());
		
		strum.setCodiPunto(objArray[7].toString());
		
		if(objArray[8] != null)
			strum.setDescSubPunto(objArray[8].toString());
			
		return strum;
	}
		
	
	
	
	
	
	
/*
	@Override
	public StrumentoTO findDecretoByAnnoTipoNum(Integer annoEse, Integer tipo,Integer num ) {
		//TODO rivedi campi
		String q=" Select ese_anno_ese as annoEse , att_nume_tipo as attNumeTipo , nume_num as numeNum , stat_status as statStatus, nume_pat as numePatr  "+
				 " from D_STRUMENTI_DEM where ese_anno_ese = :annoEse  "+
				" and att_nume_tipo = :tipo  "+
				" and  nume_num = :num ";
		
		Query query = createSQLQuery(q);
		query.setParameter("annoEse", annoEse)
		.setParameter("tipo", tipo)
		.setParameter("num", num);
		
//		StrumentoTO strum = (StrumentoTO) query.setResultTransformer(Transformers.aliasToBean(StrumentoTO.class)).uniqueResult();
		Object[] res= (Object[])query.uniqueResult();
		StrumentoTO strum = new StrumentoTO();
		strum.setAnnoEse(res != null && res[0] != null ? ((BigDecimal)res[0]).intValue():null);
		strum.setAttNumeTipo(res != null && res[1] != null ? ((BigDecimal)res[1]).intValue():null);
		strum.setNumeNum(res != null && res[2] != null ? ((BigDecimal)res[2]).intValue():null);
		strum.setStatStatus(res != null && res[3] != null ? ((String)res[3]):null);
		strum.setNumePatr(res != null && res[4] != null ? ((String)res[4]):null);
		return strum;
		
	}
	
	
	@SuppressWarnings("unused")
	private void foo(){
	}
	@SuppressWarnings("unused")
	private void foo2(){
	}
	@SuppressWarnings("unused")
	private void foo3(){
	}
	@SuppressWarnings("unused")
	private void foo4(){
	}

	*/


}
