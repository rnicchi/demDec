package it.mef.bilancio.demdec.servizi.client;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;

import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.mef.bilancio.demdec.manager.InitManager;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.FadDemBilTO;
import it.mef.bilancio.demdec.servizi.to.RaccoltaProvvisoriaRedTO;
import it.mef.bilancio.demdec.to.RicercaRedTO;
import it.mef.bilancio.demdec.utils.AbstractTest;
import it.mef.bilancio.demdec.utils.Constants;

public class TestClient extends AbstractTest{

	
	public static void main(String[] args) {
		
		TestClient tc= new TestClient();
		InterfacciaAttoDecretoDEMBILClient interfaccia=new InterfacciaAttoDecretoDEMBILClient();
		tc.run();
	
		
		
		// TODO Auto-generated method stub

	}
	

	
	
	protected void test(ApplicationContext context) throws Throwable {
		//createFascicoloAttoDecreto
		FadDemBilTO fad = new FadDemBilTO();
		InitManager inMan =(InitManager )context.getBean("initManager");
		CodeDescriptionTO amm = new CodeDescriptionTO("020","Ministrero");
		fad.setAmm(amm);
		fad.setAnnoDec(2014);
		fad.setDescDec("ciao");
		fad.setNumeroDec(new Integer(100));
		fad.setNumPatr(new Integer(200));
		fad.setTipoDec(new Integer(22));
		fad.setDescDec("Decreto");
		CodeDescriptionTO tipologiaDec = new CodeDescriptionTO("1","Tipologia");
		fad.setTipologiaDec(tipologiaDec);
		CodeDescriptionTO titolo = new CodeDescriptionTO("1","MultiTitolo");
		fad.setTitolo(titolo);
		CodeDescriptionTO ucb = new CodeDescriptionTO("020","Ucb 020");
		fad.setUcbRts(ucb);
		CodeDescriptionTO ufficio = new CodeDescriptionTO("3","Ufficio III");
		fad.setUfficioCapofila(ufficio);
		fad.setUfficioCreatore(ufficio);
		CodeDescriptionTO utenteCreatore = new CodeDescriptionTO("Paperino","Paperino");
		fad.setUtenteCreatore(utenteCreatore);				
		CodeDescriptionTO siglaDec = new CodeDescriptionTO("DIM","Decreto Interministeriale");
		fad.setSiglaTipoDec(siglaDec);				

		
		fad.setGuid(UUID.randomUUID().toString());
//		GestioneFadManager fadManager=(GestioneFadManager)context.getBean("gestioneFadManager");
//		fadManager.creaFAD(new GestioneFadTO());

		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();

		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient( inMan.leggiParametriInputDemBil(),fad,null);

		ResponseDEMBILClient resp= client.createFascicoloAttoDecreto(requestDEMBILClient);
		
		System.out.append(resp.getEsitoTo().getCodice());
	
		
	}
	
	protected void testCreateFascicoloAttoDecreto(ApplicationContext context) throws Throwable {
		//createFascicoloAttoDecreto
		FadDemBilTO fad = new FadDemBilTO();
		InitManager inMan =(InitManager )context.getBean("initManager");
		CodeDescriptionTO amm = new CodeDescriptionTO("020","Ministero");
		fad.setAmm(amm);
		fad.setAnnoDec(2014);
		fad.setDescDec("ciao");
		fad.setNumeroDec(new Integer(100));
		fad.setNumPatr(new Integer(200));
		fad.setTipoDec(new Integer(22));
		CodeDescriptionTO tipologiaDec = new CodeDescriptionTO("1","Tipologia");
		fad.setTipologiaDec(tipologiaDec);
		CodeDescriptionTO titolo = new CodeDescriptionTO("1","MultiTitolo");
		fad.setTitolo(titolo);
		CodeDescriptionTO ucb = new CodeDescriptionTO("020","Ucb 020");
		fad.setUcbRts(ucb);
		CodeDescriptionTO ufficio = new CodeDescriptionTO("3","Ufficio III");
		fad.setUfficioCapofila(ufficio);
		fad.setUfficioCreatore(ufficio);
		CodeDescriptionTO utenteCreatore = new CodeDescriptionTO("Paperino","Paperino");
		fad.setUtenteCreatore(utenteCreatore);				
		CodeDescriptionTO siglaDec = new CodeDescriptionTO("DIM","Decreto Interministeriale");
		fad.setSiglaTipoDec(siglaDec);				

		
		fad.setGuid(UUID.randomUUID().toString());
//		GestioneFadManager fadManager=(GestioneFadManager)context.getBean("gestioneFadManager");
//		fadManager.creaFAD(new GestioneFadTO());

		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();

		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient( inMan.leggiParametriInputDemBil(),fad,null);

		ResponseDEMBILClient resp= client.modifyMetadatiFascicoloAttoDecreto(requestDEMBILClient);
		
		System.out.append(resp.getEsitoTo().getCodice());
	
		
	}
	

	protected void testSearchFascicoliRaccolteProvvisorie(ApplicationContext context) throws Throwable {
//	protected void testSearchFascicoliRaccolteProvvisorie(ApplicationContext context) throws Throwable {
		//searchFascicoliRaccolteProvvisorie
		RicercaRedTO ric = new RicercaRedTO();
		InitManager inMan =(InitManager )context.getBean("initManager");
		CodeDescriptionTO amm = new CodeDescriptionTO("020","Ministrero");
		ric.setAmministrazione("020");
		ric.setAnnoEse("2014");
		ric.setDataArrivoDa("01/01/2014");
		ric.setDataArrivoA("01/02/2014");
		ric.setDataRedDa("01/03/2014");
		ric.setDataRedA("01/04/2014");
		ric.setIdRed("1111111");
		ric.setProtocolloRed("1000000");
		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();

		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient( inMan.leggiParametriInputDemBil(),ric,null);
		ResponseDEMBILClient resp= client.searchFascicoliRaccolteProvvisorie(requestDEMBILClient);
		System.out.append(resp.getEsitoTo().getCodice());
	

		
	}
	

	

	protected void testGetFascicoloRaccoltaProvvisoria(ApplicationContext context) throws Throwable {
		
		InitManager inMan =(InitManager )context.getBean("initManager");
		RaccoltaProvvisoriaRedTO ric = new RaccoltaProvvisoriaRedTO();
		ric.setIdFascicoloRaccoltaProvvisoria("159a0230-1b26-11e5-b939-0800200c9a66");
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(inMan.leggiParametriInputDemBil(),ric,null);
		requestDEMBILClient.setTipoEstrazioneFascicolo(DEMBILConstants.TIPO_ESTRAZIONE_NONE);
		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
		ResponseDEMBILClient resp= client.getFascicoloRaccoltaProvvisoria(requestDEMBILClient);
		System.out.append(resp.getEsitoTo().getCodice());
		RaccoltaProvvisoriaRedTO rp=(RaccoltaProvvisoriaRedTO)resp.getOutputTO();
		System.out.println(" raccolta to" + rp);

		

		
	}
	

	protected void testDownloadDocumentoFascicoloAttoDecreto(ApplicationContext context) throws Throwable {
		//downloadDocumentoFascicoloAttoDecreto
		
		InitManager inMan =(InitManager )context.getBean("initManager");
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(inMan.leggiParametriInputDemBil());
		requestDEMBILClient.setIdFascicolo("159a0230-1b26-11e5-b939-0800200c9a65");
		requestDEMBILClient.setIdDocumento("159a0230-1b26-11e5-b939-0800200c9a66");
	
		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
		ResponseDEMBILClient resp= client.downloadDocumentoFascicoloAttoDecreto(requestDEMBILClient);
		System.out.append(resp.getEsitoTo().getCodice());
		DocumentContentTO docContent=(DocumentContentTO)resp.getOutputTO();
		FileOutputStream output = new FileOutputStream(new File("c:/appo/mio.docx"));
		IOUtils.write(docContent.getHash(), output);
		
		

		
	}


	protected void testDownloadDocumentoRaccoltaProvvisoria(ApplicationContext context) throws Throwable {
		//downloadDocumentoFascicoloAttoDecreto
		
		InitManager inMan =(InitManager )context.getBean("initManager");
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(inMan.leggiParametriInputDemBil());
		requestDEMBILClient.setIdFascicolo("159a0230-1b26-11e5-b939-0800200c9a65");
		requestDEMBILClient.setIdDocumento("159a0230-1b26-11e5-b939-0800200c9a66");
	
		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
		ResponseDEMBILClient resp= client.downloadDocumentoRaccoltaProvvisoria(requestDEMBILClient);
		System.out.append(resp.getEsitoTo().getCodice());
		DocumentContentTO docContent=(DocumentContentTO)resp.getOutputTO();
		FileOutputStream output = new FileOutputStream(new File("c:/appo/mio.docx"));
		IOUtils.write(docContent.getHash(), output);
		

		
	}
	

	protected void testAddDocumentoFascicoloAttoDecreto(ApplicationContext context) throws Throwable {
		//downloadDocumentoFascicoloAttoDecreto
		
		InitManager inMan =(InitManager )context.getBean("initManager");
		DocumentTO documentoTo = new DocumentTO();	
		documentoTo.setAmministrazione(new CodeDescriptionTO("020","Ministero"));
		documentoTo.setAttivo(true);
		documentoTo.setCondivisibile(true);
		documentoTo.setDaInviare(true);
		documentoTo.setAttivo(true);
		documentoTo.setDescrizione("documento iniziole");
		
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(inMan.leggiParametriInputDemBil(),documentoTo);
		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
		ResponseDEMBILClient resp= client.addDocumentoFascicoloAttoDecreto(requestDEMBILClient);
		System.out.append(resp.getEsitoTo().getCodice());
	
		

		
	}
	
	
	protected void testGetDocumentoRaccoltaProvvisoria(ApplicationContext context) throws Throwable {
		//downloadDocumentoFascicoloAttoDecreto
		
		InitManager inMan =(InitManager )context.getBean("initManager");
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(inMan.leggiParametriInputDemBil());
		requestDEMBILClient.setIdFascicolo("159a0230-1b26-11e5-b939-0800200c9a65");
		requestDEMBILClient.setIdDocumento("159a0230-1b26-11e5-b939-0800200c9a66");
		requestDEMBILClient.setTipoEstrazioneDocumenti(DEMBILConstants.TIPO_ESTRAZIONE_METADATA);
	
		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
		ResponseDEMBILClient resp= client.getDocumentoRaccoltaProvvisoria(requestDEMBILClient);
		System.out.append(resp.getEsitoTo().getCodice());
		DocumentTO doc=(DocumentTO)resp.getOutputTO();
		System.out.println(" documento to" + doc);

		
	}
	

}
