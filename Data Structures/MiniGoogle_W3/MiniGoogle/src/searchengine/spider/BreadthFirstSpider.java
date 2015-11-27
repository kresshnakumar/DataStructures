/**  
 * 
 * Copyright: Copyright (c) 2004 Carnegie Mellon University
 * 
 * This program is part of an implementation for the PARKR project which is 
 * about developing a search engine using efficient Datastructures.
 * 
 * Modified by Mahender on 12-10-2009
 */
package searchengine.spider;

import java.net.*;
import java.util.*;
import searchengine.element.PageElementInterface;
import searchengine.element.PageHref;
import searchengine.element.PageWord;
import searchengine.indexer.Indexer;
import searchengine.parser.PageLexer;
import searchengine.url.URLTextReader;

/** Web-crawling objects.  Instances of this class will crawl a given
 *  web site in breadth-first order.
 */
public class BreadthFirstSpider implements SpiderInterface {

	/** Create a new web spider.
	@param u The URL of the web site to crawl.
	@param i The initial web index object to extend.
	 */

	private Indexer i = null;
	private URL u; 
	Queue<PageHref> q;
	private int count;
	private Vector<PageWord> words;
	Indexer indObj;
	public BreadthFirstSpider (URL u, Indexer i) {
		this.u = u;
		words = new Vector<PageWord>();
		this.i = i;
		q = new LinkedList();
		indObj = new Indexer("hash");
		count = 0;
	}
	
	/** Crawl the web, up to a certain number of web pages.
	@param limit The maximum number of pages to crawl.
	 */
	public Indexer crawl (int limit) {
		
		////////////////////////////////////////////////////////////////////
	    //  Write your Code here as part of Breadth First Spider assignment
	    //  
	    ///////////////////////////////////////////////////////////////////
		
		try {
			URLTextReader ur = new URLTextReader(u);
			PageLexer<PageElementInterface> elts = new PageLexer<PageElementInterface>(ur, u);
			while(elts.hasNext()) {
				PageElementInterface elt = (PageElementInterface)elts.next();
				if(elt instanceof PageHref) {
					if(count < limit) {
						q.add((PageHref)elt);
						count++;
					}
				}
				if(elt instanceof PageWord) {
					//words.add((PageWord)elt);
					//System.out.println((PageWord)elt);
					indObj.addPage(u, (PageWord)elt);
				}
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//for(PageHref s :q)
           // System.out.println(q.peek() + " ");
		return i;
	}

	/** Crawl the web, up to the default number of web pages.
	 */
	public Indexer  crawl() {
		// This redirection may effect performance, but its OK !!
		System.out.println("Crawling: "+u.toString());
		return  crawl(crawlLimitDefault);
	}

	/** The maximum number of pages to crawl. */
	public int crawlLimitDefault = 10;

}
