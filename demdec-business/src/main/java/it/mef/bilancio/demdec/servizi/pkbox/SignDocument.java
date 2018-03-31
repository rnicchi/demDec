package it.mef.bilancio.demdec.servizi.pkbox;



import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.bsn.sh.utils.TraceLogger;
import it.pkbox.client.Authenticate;
import it.pkbox.client.Envelope;
import it.pkbox.client.PDFDocumentInfo;
import it.pkbox.client.PDFSignatureInfo;
import it.pkbox.client.PKBox;
import it.pkbox.client.PKBoxException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignDocument {
	
	
	/**
	 * Esegue la firma remota automatica invisibile (firma tecnica) tramite le API PKBox. 
	 * @param  signerParam oggetto contenente i dati relativi al firmatario (file da firmare, nome, tokenPin ...)
	 * @return signerParam oggetto contenente il file firmato, codice (0=OK) e 2 tipologie di messaggio 
	 * quello generato da PKBox e quello codificato per l'utente  
	 * @see     SignerParameter
	 */
	public static  SignerParameter remoteInvisibleSign(SignerParameter signerParam)  {
		try{
			TraceLogger.infoLog("PKBoxParameter: "+signerParam.getPkBoxParameter().toString(), SignDocument.class);
			TraceLogger.infoLog("SignerParameter: "+signerParam.toString(), SignDocument.class);
			
			if(signerParam.getFileToBeSigned()!=null && signerParam.getFileToBeSigned().length>0)
			
				TraceLogger.infoLog("Lunghezza file da firmare: "+signerParam.getFileToBeSigned(), SignDocument.class); // ci arrivo in collaudo
			else
				TraceLogger.infoLog("Lunghezza file da firmare: 0", SignDocument.class);
			
			InputStream is = new ByteArrayInputStream(signerParam.getFileToBeSigned());
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			
			TraceLogger.infoLog("PKBox Handler: "+ signerParam.getPkBoxParameter().getPkBoxHandler(), SignDocument.class);
			TraceLogger.infoLog("Secure Pin: "+ signerParam.getPkBoxParameter().getSecurePinFilePath(), SignDocument.class);
	        PKBox pkBox  = new PKBox();
	        pkBox.addServer(signerParam.getPkBoxParameter().getPkBoxHandler(), null, null, null);
	        pkBox.setTimeout(540);
	        //secure pin
	        pkBox.setSecurePINCert(signerParam.getPkBoxParameter().getSecurePinFilePath());
	        TraceLogger.infoLog("istanzio Envelope", SignDocument.class); // ci arrivo in collaudo
			Envelope envelope = new Envelope(pkBox);
			
			TraceLogger.infoLog("effettuo parse documento", SignDocument.class); // ci arrivo in collaudo
			PDFDocumentInfo docInfo = envelope.pdfparse(signerParam.getFileToBeSigned());

			// test per verificare se usando il metodo di firma senza tag firma
			if (signerParam.getTag()==null){
				envelope.pdfsign(is, signerParam.getFileToBeSigned().length, signerParam.getReason(), null, null, signerParam.getAlias(), signerParam.getTokenPin(), signerParam.getPin(),  bos);
	            signerParam.setSignedFile(bos.toByteArray());
	            signerParam.setErrorMessage("");
	            signerParam.setReturnCode(0);
			}

			
			// se non ci campi firma vuoti mi da eccezione 
            PDFSignatureInfo[] tagS = docInfo.getBlankSignatures();
            boolean blankSign = false;
            
            if (tagS != null)
            {
                for(PDFSignatureInfo t:tagS)
                {
                    if ((t.getName().toLowerCase()).equals((signerParam.getTag().toLowerCase())))
                    {
                        blankSign = true;
                        break;
                    }
                }
            }
            
            if (blankSign)
            {
            	TraceLogger.infoLog("Firma Con Tag il documento � stato controllato ed � stato trovato il campo firma: " + signerParam.getTag() + " da valorizzare", SignDocument.class);
            	TraceLogger.infoLog("Invoco  pdfsign passando il file di input che ha lunghezza: " + signerParam.getFileToBeSigned().length + " l'array �: " + signerParam.getFileToBeSigned() + " con Tag: " + signerParam.getTag() + " Signer: " + signerParam.getName() + " PIN: " + signerParam.getTokenPin() + " e SignerPin: " + signerParam.getPin(), SignDocument.class);
            	//envelope.pdfsign(is, signerParam.getFileToBeSigned().length, signerParam.getReason(), null, null, null, signerParam.getName(), signerParam.getTokenPin(), signerParam.getPin(), new Date(), bos);
//            	envelope.pdfsign(is, signerParam.getFileToBeSigned().length, signerParam.getTag(), signerParam.getReason(), null, null, signerParam.getAlias(), signerParam.getTokenPin(), signerParam.getPin(), new Date(), null, 0, 0, 0, 0, 0, bos);
            	if (StringUtil.isEmpty(signerParam.getSignLayout())){
            		envelope.pdfsign(is, signerParam.getFileToBeSigned().length, signerParam.getTag(), signerParam.getReason(), null, null, null, signerParam.getAlias(), signerParam.getTokenPin(), signerParam.getPin(), new Date(), null, 0, 0, 0, 0, 0, bos);
//            		envelope.pdfsign(is, signerParam.getFileToBeSigned().length, signerParam.getTag(), signerParam.getSignLayout(), signerParam.getReason(), null, null, signerParam.getAlias(), signerParam.getTokenPin(), signerParam.getPin(), new Date(), null, 0, 0, 0, 0, 0, bos);
            	} else {
            		envelope.pdfsign(is, signerParam.getFileToBeSigned().length,0, signerParam.getTag(), signerParam.getSignLayout(), signerParam.getReason(), null, null, null, signerParam.getAlias(), signerParam.getTokenPin(), signerParam.getPin(), new Date(), null, 0, 0, 0, 0, 0, bos);
            	}
//            	TraceLogger.infoLog("Ottengo in risposta l'array: " + bos + " di lunghezza: " + bos.size(), SignDocument.class);
            	TraceLogger.infoLog("Ottengo in risposta l'array di lunghezza: " + bos.size(), SignDocument.class);
            }
            else
            {
				signerParam.setDecodedErrorMessage("Non e' stato possibile completare l'operazione di firma");
				signerParam.setErrorMessage("Non � stato trovato il tag di firma");
				signerParam.setReturnCode(1);
				return signerParam;
//            	TraceLogger.infoLog("Eseguo la firma senza tag perch� non � stato trovato dal metodo pdfParse il tag: " + signerParam.getTag(), SignDocument.class);
//            	TraceLogger.infoLog("Invoco  pdfsign passando il file di input che ha lunghezza: " + signerParam.getFileToBeSigned().length + " l'array �: " + signerParam.getFileToBeSigned() + " non ho pi� tag  perch� proviamo a fare la firma senza tag   Signer: " + signerParam.getName() + " PIN: " + signerParam.getTokenPin() + " e SignerPin: " + signerParam.getPin(), SignDocument.class);
//            	envelope.pdfsign(is, signerParam.getFileToBeSigned().length, signerParam.getReason(), null, null, null, signerParam.getAlias(), signerParam.getTokenPin(), signerParam.getPin(), new Date(), bos);
            	//envelope.sign(is, signerParam.getAlias(),signerParam.getPin(), null, 1,   2);
            	//envelope.pdfsign(is, signerParam.getFileToBeSigned().length, null, signerParam.getReason(), null, null, signerParam.getName(), signerParam.getTokenPin(), signerParam.getPin(), new Date(), null, 0, 0, 0, 0, 0, bos);
//            	TraceLogger.infoLog("Ottengo in risposta l'array: " + bos + " di lunghezza: " + bos.size(), SignDocument.class);
//            	TraceLogger.infoLog("Ottengo in risposta l'array di lunghezza: " + bos.size(), SignDocument.class);
            }
            signerParam.setSignedFile(bos.toByteArray());
            signerParam.setErrorMessage("");
            signerParam.setReturnCode(0);

		}	
		catch(PKBoxException ex){
			TraceLogger.errorLog("ErrorCode: "+ex.GetErrorCode(), SignDocument.class, null);
			TraceLogger.errorLog("ErrorMessage: "+ex.getMessage(), SignDocument.class, null);
			signerParam.setDecodedErrorMessage(decodePKBoxErrorCode(ex.GetErrorCode()));
			signerParam.setErrorMessage(ex.getMessage());
			signerParam.setReturnCode(ex.GetErrorCode());
		}catch(Exception ex){
			TraceLogger.errorLog("ErrorMessage: "+ex.getMessage(), SignDocument.class, null);
			signerParam.setDecodedErrorMessage("Non e' stato possibile completare l'operazione di firma");
			signerParam.setErrorMessage(ex.getMessage());
			signerParam.setReturnCode(1);
		}
		return signerParam;
	}	
	
	
	/**
	 * Esegue la firma remota visibile (con o senza tag) tramite le API PKBox. Viene generato OTP, ed i dati relativi al name e alias vengono 
	 * cercati tra le header variables in caso di mancat valorizzazione dell'attributo alias nell'oggetto SignerParameter.
	 * @param  signerParam oggetto contenente i dati relativi al firmatario (file da firmare, nome, tokenPin ...)
	 * @return signerParam oggetto contenente il file firmato, codice (0=OK) e 2 tipologie di messaggio 
	 * quello generato da PKBox e quello codificato per l'utente  
	 * @see    SignerParameter
	 */
	public static SignerParameter digestVisibleSign(SignerParameter signerParam){
		try{
			TraceLogger.infoLog("PKBoxParameter: "+signerParam.getPkBoxParameter().toString(), SignDocument.class);
			TraceLogger.infoLog("SignerParameter: "+signerParam.toString(), SignDocument.class);
			
			if(signerParam.getFileToBeSigned()!=null && signerParam.getFileToBeSigned().length>0) 
				TraceLogger.infoLog("Lunghezza file da firmare: "+signerParam.getFileToBeSigned(), SignDocument.class);
			else
				TraceLogger.infoLog("Lunghezza file da firmare: 0", SignDocument.class);

			InputStream is = new ByteArrayInputStream(signerParam.getFileToBeSigned());
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			TraceLogger.infoLog("istanzio Envelope", SignDocument.class);
			Envelope envelope = new Envelope(signerParam.getPkBoxClient());
			
			TraceLogger.infoLog("effettuo parse documento", SignDocument.class);
			PDFDocumentInfo docInfo = envelope.pdfparse(signerParam.getFileToBeSigned()); // TODO verificare se passargli la lunghezza del file
			 // se non ci campi firma vuoti mi da eccezione 
	        PDFSignatureInfo[] tagS = docInfo.getBlankSignatures();
	        boolean blankSign = false;
	        
	        if (tagS != null)
	        {
	            for(PDFSignatureInfo t:tagS)
	            {
	                if ((t.getName().toLowerCase()).equals((signerParam.getTag().toLowerCase())))
	                {
	                    blankSign = true;
	                    break;
	                }
	            }
	        }
	        
	        TraceLogger.infoLog("Genero l'otp invocando otpGenerate di Authenticate uso come parametri: PROVIDER " + signerParam.getPkBoxParameter().getProvider() + " NAME " + signerParam.getName() + " PIN " + signerParam.getPin(), SignDocument.class);
	        String otp = signerParam.getoTP();
	        if (blankSign)
	        {
	        	TraceLogger.infoLog("il documento � stato controllato ed � stato trovato il campo firma: " + signerParam.getTag() + " da valorizzare", SignDocument.class);
	        	TraceLogger.infoLog("Invoco  pdfsign passando il file di input che ha lunghezza: " + signerParam.getFileToBeSigned().length + " l'array �: " + signerParam.getFileToBeSigned() + " con tag: " + signerParam.getTag() +  " Alias: " + signerParam.getAlias() + " PIN: " + signerParam.getTokenPin() + " e OTP: " + otp, SignDocument.class);
	        	envelope.pdfsign(is, signerParam.getFileToBeSigned().length, 0, signerParam.getTag(), signerParam.getSignLayout(), signerParam.getReason(), null, null, null,  signerParam.getAlias(), signerParam.getTokenPin(), otp, new Date(), null, 0, 0, 0, 0, 0, bos);
//	        	TraceLogger.infoLog("Ottengo in risposta l'array: " + bos + " di lunghezza: " + bos.size(), SignDocument.class);
	        	TraceLogger.infoLog("Ottengo in risposta l'array di lunghezza: " + bos.size(), SignDocument.class);
	        }
	        else
	        {
				signerParam.setDecodedErrorMessage("Non e' stato possibile completare l'operazione di firma");
				signerParam.setErrorMessage("Non � stato trovato il tag di firma");
				signerParam.setReturnCode(1);
				return signerParam;
	        }
	        
	        signerParam.setSignedFile(bos.toByteArray());
	        signerParam.setErrorMessage("");
	        signerParam.setReturnCode(0);
		
		}	
		catch(PKBoxException ex){
			TraceLogger.errorLog("ErrorCode: "+ex.GetErrorCode(), SignDocument.class, null);
			TraceLogger.errorLog("ErrorMessage: "+ex.getMessage(), SignDocument.class, null);
			signerParam.setDecodedErrorMessage(decodePKBoxErrorCode(ex.GetErrorCode()));
			signerParam.setErrorMessage(ex.getMessage());
			signerParam.setReturnCode(ex.GetErrorCode());
		}catch(Exception ex){
			TraceLogger.errorLog("ErrorMessage: "+ex.getMessage(), SignDocument.class, null);
			signerParam.setDecodedErrorMessage("Non e' stato possibile completare l'operazione di firma");
			signerParam.setErrorMessage(ex.getMessage());
			signerParam.setReturnCode(1);
		}
		
		return signerParam;

	}
	

	
	
	/**
	 * Esegue la firma invisibile tramite le API PKBox. Viene generato OTP, ed i dati relativi al name e alias vengono 
	 * cercati tra le header variables, in caso di mancat valorizzazione dell'attributo alias nell'oggetto SignerParameter
	 * (solo senza tag DA VERIFICARE !!!!).
	 * @param  signerParam oggetto contenente i dati relativi al firmatario (file da firmare, nome, tokenPin ...)
	 * @return signerParam oggetto contenente il file firmato, codice (0=OK) e 2 tipologie di messaggio 
	 * quello generato da PKBox e quello codificato per l'utente  
	 * @see    SignerParameter
	 */
	public static SignerParameter digestInvisibleSign(SignerParameter signerParam){
		try{
			TraceLogger.infoLog("PKBoxParameter: "+signerParam.getPkBoxParameter().toString(), SignDocument.class);
			TraceLogger.infoLog("SignerParameter: "+signerParam.toString(), SignDocument.class);

			//if(signerParam.getAlias()==null || signerParam.getAlias().equals("") )
				//signerParam = SignDocument.getSignerByOAMVariables(request, response, signerParam);
			
			
			if(signerParam.getFileToBeSigned()!=null && signerParam.getFileToBeSigned().length>0) 
				TraceLogger.infoLog("Lunghezza file da firmare: "+signerParam.getFileToBeSigned(), SignDocument.class);
			else
				TraceLogger.infoLog("Lunghezza file da firmare: 0", SignDocument.class);

			InputStream is = new ByteArrayInputStream(signerParam.getFileToBeSigned());
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			TraceLogger.infoLog("istanzio Envelope", SignDocument.class);

			Envelope envelope = new Envelope(signerParam.getPkBoxClient());
			TraceLogger.infoLog("effettuo parse documento", SignDocument.class);
			PDFDocumentInfo docInfo = envelope.pdfparse(signerParam.getFileToBeSigned());
			 // se non ci campi firma vuoti mi da eccezione 
	        PDFSignatureInfo[] tagS = docInfo.getBlankSignatures();
	        boolean blankSign = false;
	        
	        if (tagS != null)
	        {
	            for(PDFSignatureInfo t:tagS)
	            {
	                if ((t.getName().toLowerCase()).equals((signerParam.getTag().toLowerCase())))
	                {
	                    blankSign = true;
	                    break;
	                }
	            }
	        }
	        
	        TraceLogger.infoLog("Prelevo l'otp generato usando come parametri: PROVIDER " + signerParam.getPkBoxParameter().getProvider() + " NAME " + signerParam.getName() + " PIN " + signerParam.getPin(), SignDocument.class);
	        String otp = signerParam.getoTP();
	        if (blankSign)
	        {
	        	TraceLogger.infoLog("il documento � stato controllato ed � stato trovato il campo firma: " + signerParam.getTag() + " da valorizzare", SignDocument.class);
	        	TraceLogger.infoLog("Invoco  pdfsign passando il file di input che ha lunghezza: " + signerParam.getFileToBeSigned().length + " l'array �: " + signerParam.getFileToBeSigned() + " con tag: " + signerParam.getTag() +  " Alias: " + signerParam.getAlias() + " PIN: " + signerParam.getTokenPin() + " e OTP: " + otp, SignDocument.class);
	        	envelope.pdfsign(is, signerParam.getFileToBeSigned().length, signerParam.getReason(), null, null, signerParam.getAlias(), signerParam.getTokenPin(), otp, new Date(), bos);
	        	//envelope.getEnvelope().pdfsign(is, signerParam.getFileToBeSigned().length, 0, signerParam.getTag(), signerParam.getSignLayout(), signerParam.getReason(), null, null, null,  signerParam.getAlias(), signerParam.getTokenPin(), otp, new Date(), null, 0, 0, 0, 0, 0, bos);
//	        	TraceLogger.infoLog("Ottengo in risposta l'array: " + bos + " di lunghezza: " + bos.size(), SignDocument.class);
	        	TraceLogger.infoLog("Ottengo in risposta l'array di lunghezza: " + bos.size(), SignDocument.class);
	        }
	        else
	        {
	        	TraceLogger.infoLog("Eseguo la firma senza tag perch� non � stato trovato dal metodo pdfParse il tag: " + signerParam.getTag(), SignDocument.class);
	        	TraceLogger.infoLog("Invoco  pdfsign passando il file di input che ha lunghezza: " + signerParam.getFileToBeSigned().length + " l'array �: " + signerParam.getFileToBeSigned() + " non ho pi� tag e formattazione perch� proviamo a fare la firma senza tag   Alias: " + signerParam.getAlias() + " PIN: " + signerParam.getTokenPin() + " e OTP: " + otp, SignDocument.class);
	        	envelope.pdfsign(is, signerParam.getFileToBeSigned().length, signerParam.getReason(), null, null, signerParam.getAlias(), signerParam.getTokenPin(), otp, new Date(), bos);
//	        	TraceLogger.infoLog("Ottengo in risposta l'array: " + bos + " di lunghezza: " + bos.size(), SignDocument.class);
	        	TraceLogger.infoLog("Ottengo in risposta l'array di lunghezza: " + bos.size(), SignDocument.class);
	        }
	        
	        signerParam.setSignedFile(bos.toByteArray());
	        signerParam.setErrorMessage("");
	        signerParam.setReturnCode(0);
		
		}	
		catch(PKBoxException ex){
			TraceLogger.errorLog("ErrorCode: "+ex.GetErrorCode(), SignDocument.class, null);
			TraceLogger.errorLog("ErrorMessage: "+ex.getMessage(), SignDocument.class, null);
			signerParam.setDecodedErrorMessage(decodePKBoxErrorCode(ex.GetErrorCode()));
			signerParam.setErrorMessage(ex.getMessage());
			signerParam.setReturnCode(ex.GetErrorCode());
		}catch(Exception ex){
			TraceLogger.errorLog("ErrorMessage: "+ex.getMessage(), SignDocument.class, null);
			signerParam.setDecodedErrorMessage("Non e' stato possibile completare l'operazione di firma");
			signerParam.setErrorMessage(ex.getMessage());
			signerParam.setReturnCode(1);
		}
		
		return signerParam;

	}
	
	
	/**
	 * Restituisce il messaggio d'errore in base al codice errore pkbox 
	 * @param code codice errore pkbox
	 * @return msg 
	 * @see    String
	 */
	private static String decodePKBoxErrorCode(int code){
		String msg = "";
		switch(code){
			case 1:
				msg = "URL di connessione non valido contattare l'assistenza";
				break;
			case 769:
		        msg = "Nome firma non valido";
		        break;
			case 1537:
				msg = "Errore connessione con server";
		        break;
		    case 774:
		    	msg = "Nome campo firma non valido";
		        break;
		    case 787:
		    	msg = "Token Pin non valido";
		        break;
		    case 789:
		    	msg = "Pin non valido";
		        break;	  
	        default:
	        	msg = "Errore nella procedura di Firma";
		        break;	  
		}       
		return msg;
	}
	
	
	
	/**
	 * Imposta nell'oggetto signerParam i valori trovati nella request header (tali valori sono impostati da OAM). 
	 * @param  request     oggetto contenente la request
	 * @param  response    oggetto contenente la response
	 * @param  signerParam oggetto contenente i dati relativi al firmatario (file da firmare, nome, tokenPin ...)
	 * @return signerParam oggetto contenente i valori trovati nella request header (tali valori sono impostati da OAM).
	 * @see    SignerParameter
	 */
	public static SignerParameter getSignerByOAMVariables(HttpServletRequest request, HttpServletResponse response)
    {
		TraceLogger.infoLog("CLAUDIO: Sto prendendo i parametri da OAM",SignDocument.class);
		
		SignerParameter signerParam = new SignerParameter();
        try
        {
        	if(request!=null &&
        		response != null){
        		TraceLogger.infoLog("Request valorizzata", SignDocument.class);
            	Cookie[] cookies = request.getCookies();
            	TraceLogger.infoLog("Numero cookies in request: "+cookies.length, SignDocument.class);
            	String value = "";
            	if (cookies != null) {
            		for (Cookie cookie : cookies) {
            			if (cookie.getName().equals("ObSSOCookie")) {
	            		   TraceLogger.infoLog("Cookie ObSSOCookie valorizzato", SignDocument.class);
//	            		   cookie.setHttpOnly(false);
	            		   response.addCookie(cookie);
	            		   value = cookie.getName()+"="+cookie.getValue();
	            		   TraceLogger.infoLog("Valore cookie: "+value, SignDocument.class);
            			}
            		}
            	}
            	signerParam.setPin(value);
            	TraceLogger.infoLog("Pin: "+value, SignDocument.class);
            	//signerParam.setTokenPin(signerParam.getPin().toString());
            	TraceLogger.infoLog("TokenPin: "+signerParam.getTokenPin(), SignDocument.class);
            	signerParam.setAlias(request.getHeader("Alias-FR"));
            	TraceLogger.infoLog("Alias: "+request.getHeader("Alias-FR"), SignDocument.class);
            	signerParam.setName(request.getHeader("SP_SSO_UID"));
            	TraceLogger.infoLog("Name: "+request.getHeader("SP_SSO_UID"), SignDocument.class);
        	}else{
        		if(request==null) TraceLogger.infoLog("Request null", SignDocument.class);
        		if(response==null)TraceLogger.infoLog("Response null", SignDocument.class);
        	}
        }
        catch (Exception ex)
        {
        	signerParam = null;
            TraceLogger.errorLog("Errore durante reperimento valori da OAM e request HEADER", SignDocument.class, null);
        }
        return signerParam;
    }

	
	
	
	
	
	
	
	public static SignerParameter generateOTP(SignerParameter signerParam)
    {
        try
        {
        	TraceLogger.infoLog("CLAUDIO: Sto generando otp",SignDocument.class);
    		TraceLogger.infoLog("PKBox Handler: "+ signerParam.getPkBoxParameter().getPkBoxHandler(), SignDocument.class);
    		TraceLogger.infoLog("Secure Pin: "+ signerParam.getPkBoxParameter().getSecurePinFilePath(), SignDocument.class);
            PKBox pkBox  = new PKBox();
            pkBox.addServer(signerParam.getPkBoxParameter().getPkBoxHandler(), null, null, null);
            pkBox.setTimeout(540);
            //secure pin
            pkBox.setSecurePINCert(signerParam.getPkBoxParameter().getSecurePinFilePath());
            signerParam.setPkBoxClient(pkBox);
            Authenticate auth = new Authenticate(pkBox);
            Properties prop = new Properties();
            prop.load(new FileInputStream(signerParam.getPkBoxParameter().getOtpPropertiesFilePath()));
            auth.loadProperties(prop);
            TraceLogger.infoLog("CLAUDIO: Sto settando otp al signerparam nel metodo generateOTP",SignDocument.class);
        	signerParam.setoTP(auth.otpGenerate(signerParam.getPkBoxParameter().getProvider(), signerParam.getName(), signerParam.getPin(), null));
            TraceLogger.infoLog("Roberto: � stato generato l'otp: " + signerParam.getoTP(),SignDocument.class);
         }
        
		catch(PKBoxException ex){
			TraceLogger.errorLog("CLAUDIO: � stata sollevata una eccezione nel momento della generazine dell' otp",  SignDocument.class, null);
			TraceLogger.errorLog("ErrorCode: "+ex.GetErrorCode(), SignDocument.class, null);
			TraceLogger.errorLog("ErrorMessage: "+ex.getMessage(), SignDocument.class, null);
			signerParam.setDecodedErrorMessage(decodePKBoxErrorCode(ex.GetErrorCode()));
			signerParam.setErrorMessage(ex.getMessage());
			signerParam.setReturnCode(ex.GetErrorCode());
		}catch(Exception ex){
			TraceLogger.errorLog("ErrorMessage: "+ex.getMessage(), SignDocument.class, null);
			signerParam.setDecodedErrorMessage("Non e' stato possibile completare l'operazione di firma");
			signerParam.setErrorMessage(ex.getMessage());
			signerParam.setReturnCode(1);
		}
        return signerParam;
    }
	
	
	
	
	
	public static SignerParameter startTrans(SignerParameter signerParam, int maxTranSize)
    {
        try
        {
            if (signerParam.getPkBoxClient() == null)
            {
            	TraceLogger.infoLog("CLAUDIO: Sto startando la transazione e il pkboxClient � null",SignDocument.class);
            	
            	
            	TraceLogger.infoLog("PKBox Handler: "+ signerParam.getPkBoxParameter().getPkBoxHandler(), SignDocument.class);
        		TraceLogger.infoLog("Secure Pin: "+ signerParam.getPkBoxParameter().getSecurePinFilePath(), SignDocument.class);
                PKBox pkBox  = new PKBox();
                pkBox.addServer(signerParam.getPkBoxParameter().getPkBoxHandler(), null, null, null);
                pkBox.setTimeout(540);
                //secure pin
                pkBox.setSecurePINCert(signerParam.getPkBoxParameter().getSecurePinFilePath());
                signerParam.setPkBoxClient(pkBox);

            }
            
            Envelope enve = new Envelope(signerParam.getPkBoxClient());
            
            TraceLogger.infoLog("CLAUDIO: Sto settando otp al signerParam da startTransaction",SignDocument.class);
            signerParam.setoTP(enve.startTransaction("", signerParam.getAlias(), signerParam.getTokenPin(), signerParam.getoTP(), maxTranSize));     // maxTranSize: numero dei documenti da firmare
            TraceLogger.infoLog("Roberto: l'otp settato al signerparam dal metodo startTransaction: " +signerParam.getoTP(),SignDocument.class);

        }
        catch(PKBoxException ex){
        	 TraceLogger.infoLog("CLAUDIO: Ho preso una eccezione PKBOX mentre starto la transazione",SignDocument.class);
            //errore legato all'OTP non � valido
            //errore 808 se l'utente ripete l'operazione di firma entro 30 secondi...
            // OTP non valido...vuol dire che obbcookie scaduto/non valido oppure sto utilizzando OTP gia utilizzato quindi sono entro i 30 secondi
			TraceLogger.errorLog("ErrorCode: "+ex.GetErrorCode(), SignDocument.class, null);
			TraceLogger.errorLog("ErrorMessage: "+ex.getMessage(), SignDocument.class, null);
			signerParam.setDecodedErrorMessage(decodePKBoxErrorCode(ex.GetErrorCode()));
			signerParam.setErrorMessage(ex.getMessage());
			signerParam.setReturnCode(ex.GetErrorCode());
		}catch(Exception ex){
			TraceLogger.errorLog("ErrorMessage: "+ex.getMessage(), SignDocument.class, null);
			signerParam.setDecodedErrorMessage("Non e' stato possibile completare l'operazione di firma");
			signerParam.setErrorMessage(ex.getMessage());
			signerParam.setReturnCode(1);
		}
        return signerParam;
    }	
	
}
