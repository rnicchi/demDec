package it.almavivaitalia.bilancio.commons.web.security.spring;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * A LocalContext that define a ContextSingletonBeanFactoryLocator key for
 * application context spring beans.
 */
public class LocalContext implements BeanFactoryAware {
	/**
	 * Default logger.
	 */
	private static Log logger = LogFactory.getLog(LocalContext.class);

	private static BeanFactory beanFactory;

	/**
	 * Context id associated to the application and used to point to the correct
	 * bean factory from a ContextSingletonBeanFactoryLocator.
	 */
	private static final String CONTEXT_ID = "it.mef.bilancio.common.business.spring.applicationContext";

	/**
	 * Return the bean factory from the ContextSingletonBeanFactoryLocator and
	 * with associated CONTEXT_ID.
	 * 
	 * @return singletone bean factory associated to the local context
	 * @see LocalContext
	 * @see GlobalContext
	 */
	public static BeanFactory getBeanFactory() {
		if (beanFactory == null) {
			beanFactory = GlobalContext.getBeanFactoryLocator()
					.useBeanFactory(CONTEXT_ID).getFactory();
		}
		return beanFactory;
	}

	/**
	 * Set the beanFactory in the local context.
	 * 
	 * @param factory
	 *            to store into local context.
	 */
	public void setBeanFactory(BeanFactory factory) {
		// Set the beanFactory in the local context
		if (beanFactory == null) {
			logger.info("Loading " + CONTEXT_ID + " from beanFactory:"
					+ factory);
			beanFactory = factory;
		} else {
			logger.warn("Local Context:" + CONTEXT_ID
					+ " already initialized thru:" + beanFactory);
			logger.warn("Given new Context discarded !!! New context:"
					+ factory);
		}
	}

	/**
	 * Get the current data source.
	 * 
	 * @return data source associated to the local context.
	 */
	public static DataSource getDataSource() {
		// Get the current data source
		return (DataSource) getBeanFactory().getBean("dataSource");
	}

	/**
	 * Get the bean instance associated to the given name.
	 * 
	 * @param beanName
	 *            name of the bean to be get
	 * @return instance object of the bean requested
	 * @see #getBeanFactory
	 */
	public static Object getBean(String beanName) {
		// Get the bean instance associated to the given name
		return getBeanFactory().getBean(beanName);
	}

	/**
	 * Get the bean instance associated to the given name, by checking the
	 * correct class type.
	 * 
	 * @param beanName
	 *            name of the bean to be get.
	 * @param requiredType
	 *            class type of the bean to be retrieved.
	 * @return instance object of the bean requested.
	 * @see #getBeanFactory
	 */
	public static Object getBean(String beanName, Class<?> requiredType) {
		// Get the bean instance associated to the given name, by checking
		// the correct class type

		return getBeanFactory().getBean(beanName, requiredType);
	}

	@SuppressWarnings("unused")
	private String metr1 = null;
	@SuppressWarnings("unused")
	private String metr2 = null;
	@SuppressWarnings("unused")
	private String metr3 = null;

}
