package it.mef.bilancio.demdec.utils;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class AbstractTest {

	
	private ApplicationContext context;
	protected abstract void test(ApplicationContext context) throws Throwable;
	
	
	protected void startupSpring(){
		context =
			new ClassPathXmlApplicationContext(new String[] {
					"META-INF/spring/almavivaitalia.bilancio.commons.xml",
					"META-INF/spring/datasources.xml",
					"META-INF/spring/daos.xml",
					"META-INF/spring/managers.xml",
					"META-INF/spring/aop.xml",
					"META-INF/spring/maps.xml"
			});

	}
	
	public void run() {
		try {
			startupSpring();
			long start = Calendar.getInstance().getTimeInMillis();
			System.out.println("START: "+Calendar.getInstance().getTime());
			test(context);
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("END: "+Calendar.getInstance().getTime());
			System.out.println("EXECUTION TIME: "+(end-start)+" ms");
			
		}catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
}
