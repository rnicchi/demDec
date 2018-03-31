package it.mef.bilancio.demdec.utils;

import it.almavivaitalia.bsn.sh.utils.TraceLogger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	
	/* LOCM */
	@SuppressWarnings("unused")
	private final static String sogliaMetriche1= "80";
	@SuppressWarnings("unused")
	private final static String sogliaMetriche2= "80";
	@SuppressWarnings("unused")
	private final static String sogliaMetriche3= "80";
	@SuppressWarnings("unused")
	private final static String sogliaMetriche4= "80";
	@SuppressWarnings("unused")
	private final static String sogliaMetriche5= "80";
	/*end LOCM*/	

	
	public static String saveFile(String fileName,InputStream inputStream) throws Throwable {
		TraceLogger.infoLog("INIZIO salvataggio file" + fileName, FileUtil.class);
		File f=new File(fileName);
		OutputStream out=new FileOutputStream(f);
		byte buf[]=new byte[1024];
    	int len;
        while((len=inputStream.read(buf))>0){
    		  out.write(buf,0,len);
        }
         out.flush();
    	 out.close();
   		TraceLogger.infoLog("FINE salvataggio file" + fileName, FileUtil.class);
 		return fileName;
    	}
	
}
