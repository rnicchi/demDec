package it.mef.bilancio.demdec.servizi.client;





public class ParametriInput {


		//******* parametri dal manager al client WS *******
		
		private String urlWS;
		private int timeOutWS;
		
		private String actorWS="http://mef.gov.it/servizi/Common/HeaderAccessoApplicativo";
		private String applicazioneWS="DEMDEC";
		private String clientWS="DEMDEC";
		private String mustUnderstandWS="true";
		private String orgIDWS="1";
		private String tipoUtenteWS="1";
		private String servizioWS="1";
		private String utenteWS;
		private String passwdWS;
		public String getUrlWS() {
			return urlWS;
		}
		public void setUrlWS(String urlWS) {
			this.urlWS = urlWS;
		}
		public int getTimeOutWS() {
			return timeOutWS;
		}
		public void setTimeOutWS(int timeOutWS) {
			this.timeOutWS = timeOutWS;
		}
		public String getActorWS() {
			return actorWS;
		}
		public void setActorWS(String actorWS) {
			this.actorWS = actorWS;
		}
		public String getApplicazioneWS() {
			return applicazioneWS;
		}
		public void setApplicazioneWS(String applicazioneWS) {
			this.applicazioneWS = applicazioneWS;
		}
		public String getClientWS() {
			return clientWS;
		}
		public void setClientWS(String clientWS) {
			this.clientWS = clientWS;
		}
		public String getMustUnderstandWS() {
			return mustUnderstandWS;
		}
		public void setMustUnderstandWS(String mustUnderstandWS) {
			this.mustUnderstandWS = mustUnderstandWS;
		}
		public String getOrgIDWS() {
			return orgIDWS;
		}
		public void setOrgIDWS(String orgIDWS) {
			this.orgIDWS = orgIDWS;
		}
		public String getTipoUtenteWS() {
			return tipoUtenteWS;
		}
		public void setTipoUtenteWS(String tipoUtenteWS) {
			this.tipoUtenteWS = tipoUtenteWS;
		}
		public String getServizioWS() {
			return servizioWS;
		}
		public void setServizioWS(String servizioWS) {
			this.servizioWS = servizioWS;
		}
		public String getUtenteWS() {
			return utenteWS;
		}
		public void setUtenteWS(String utenteWS) {
			this.utenteWS = utenteWS;
		}
		public String getPasswdWS() {
			return passwdWS;
		}
		public void setPasswdWS(String passwdWS) {
			this.passwdWS = passwdWS;
		}			


	}

