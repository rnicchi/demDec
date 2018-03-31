package it.almavivaitalia.bsn.sh.manager.impl;

import it.almavivaitalia.bilancio.commons.to.AbstractCommonTO;
import it.almavivaitalia.bsn.sh.bo.AbstractBO;
import it.almavivaitalia.bsn.sh.manager.AbstractManager;
import it.almavivaitalia.bsn.sh.utils.DozerDriver;
import it.almavivaitalia.bsn.sh.utils.ResourceBundleMessageSource;

import java.util.List;



public abstract class AbstractManagerImpl implements AbstractManager{

	private DozerDriver dozerDriver;

	protected DozerDriver getDozerDriver() {
		return dozerDriver;
	}

	public void setDozerDriver(DozerDriver dozerDriver) {
		this.dozerDriver = dozerDriver;
	}
	
	
	protected void copyAudit(AbstractCommonTO source, AbstractBO dest){
		dozerDriver.map(source, dest, "AuditFieldsTO_BO");
	}
	protected void copyAudit(AbstractBO source, AbstractBO dest){
		dozerDriver.map(source, dest, "AuditFieldsBO_BO");
	}

	protected void copyAudit(AbstractCommonTO source, List<? extends AbstractBO> dest){
		for (AbstractBO abstractBO : dest) {
			copyAudit(source, abstractBO);
		}
	}
	
}
