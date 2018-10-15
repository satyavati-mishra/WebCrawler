package com.satya.webcrawler.Services;

import java.io.IOException;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractLinkServiceImpl implements ExtractLinkService{
	private HashSet<String> links;
    public ExtractLinkServiceImpl() {
        links = new HashSet<String>();
    }	
	@Override
    public void extractLink(String URL, String exactMatch) {
        //Check if already crawled the URLs 
        if (!links.contains(URL)) {
            try {
                //If not add it to the index
                if (links.add(URL)) {
                    System.out.println(URL);
                }
                //Fetch the HTML code using Jsoup lib
                Document document = Jsoup.connect(URL).get();
                //Parse the HTML and extract links for URLs
                Elements linksOnPage = document.select("a[href]");                
                //For each extracted URL repeat recursively
                for (Element page : linksOnPage) {
                	//getPageWiseLinks(page.attr("abs:href"));
                	//Extract links that contain the domain prudential.co.uk
    				if(page.attr("href").contains(exactMatch))
    					extractLink(page.attr("abs:href"), exactMatch);                	
                }
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
