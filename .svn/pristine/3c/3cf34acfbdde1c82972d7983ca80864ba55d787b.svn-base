package it.almavivaitalia.bilancio.commons.manager.impl;


import static it.almavivaitalia.bsn.sh.utils.ReflectionUtilLev2.getInputStreamFromClasspath;
import it.almavivaitalia.bilancio.commons.manager.DownloadFileManager;

import java.io.InputStream;
import java.io.OutputStream;


public class DownloadFileManagerImpl extends AbstractCommonManagerImpl implements DownloadFileManager 
{
	public void downloadFile(InputStream inpStr, OutputStream outStr) throws Throwable
	{	byte[] b = new byte[1024];
		int read = inpStr.read(b);
		while(read>0){
			outStr.write(b, 0, read);
			outStr.flush();
			read = inpStr.read(b);
		}
		
		outStr.close();
	}
	
	
	public void downloadFile(String nomeFile, OutputStream outStr) throws Throwable
	{	
		InputStream inpStr = getInputStreamFromClasspath(nomeFile);
		this.downloadFile(inpStr, outStr);
	}	
}