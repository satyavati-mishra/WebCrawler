package com.satya.webcrawler.Services;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsCollectionContaining;

public class ExtractLinkServiceImplTest {
	private HashSet<String> links= new HashSet<String>();
	private Document document;
	private String seedURL;
	@BeforeClass
	public static void beforeClass(){
        //If proxy setting is applied for accessing the URL.
        System.setProperty("http.proxyHost", "172.25.74.10");
        System.setProperty("http.proxyPort", "2006");
	}
	@Before
    public void beforeExtractLink() throws IOException {
		seedURL="http://www.prudential.co.uk/";
		links.add(seedURL);
		document = Jsoup.connect(seedURL).get();
		
	}	
	@Test
    public void extractLinkSeedURL() {
		assertThat(links.size(), Is.is(1));
		assertThat(links, IsCollectionContaining.hasItem(seedURL));
	}
	@Test
    public void linksOnPageTest() {
		assertThat(document.select("a[href]").eachAttr("abs:href"), IsCollectionContaining.hasItem(seedURL));
	
	}	
	@After
    public void afterExtractLink() throws IOException {
		links=null;
		document = null;
	}	
}
