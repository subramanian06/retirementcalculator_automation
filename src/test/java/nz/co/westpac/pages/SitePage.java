package nz.co.westpac.pages;

import nz.co.repository.SiteRepository;

/**
 * 
 * @author Subramanian_K
 *
 */
public class SitePage {

	protected SiteRepository repository;

	/**
	 * SitePage constructor with input parameter of site repository class for
	 * accessing all the page objects
	 * 
	 * @param repository
	 */
	protected SitePage(SiteRepository repository) {
		this.repository = repository;
	}

}
