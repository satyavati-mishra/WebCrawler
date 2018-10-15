package com.satya.webcrawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashSet;
public class BasicWebCrawler {
    private HashSet<String> links;

    public BasicWebCrawler() {
        links = new HashSet<String>();
    }
    public void getPageWiseLinks(String URL, String exactMatch) {
        //Check if already crawled the URLs 
        if (!links.contains(URL)) {
            try {
                //If not add it to the index
                if (links.add(URL)) {
                    System.out.println(URL);
                }
                //Fetch the HTML code using Jsoup lib
                Document document = fetchHTMLCode(URL);
                //Parse the HTML and extract links for URLs
                extractLink(document, exactMatch);
            } catch (Exception e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    public Document fetchHTMLCode(String URL){

        //Fetch the HTML code using Jsoup lib
        Document document=null;
        try {
        	document = Jsoup.connect(URL).get();
        } catch (IOException e) {
        	e.printStackTrace();
        }
        return document; 
    }
    public void extractLink(Document document, String exactMatch){
        //Parse the HTML and extract links for URLs
        Elements linksOnPage = document.select("a[href]");                
        //For each extracted URL repeat recursively
        for (Element page : linksOnPage) {
        	//getPageWiseLinks(page.attr("abs:href"));
        	//Extract links that contain the domain prudential.co.uk
			if(page.attr("href").contains(exactMatch))
				getPageWiseLinks(page.attr("abs:href"), exactMatch);                	
        }    	
    }
    public static void main(String[] args) {
        //1. Pick a URL "https://www.prudential.co.uk/" from the frontier 
    	if(args.length>0 && args.length<=1){
        	new BasicWebCrawler().getPageWiseLinks(args[0], "");
        }else if(args.length>0 && args.length<1){
        	new BasicWebCrawler().getPageWiseLinks(args[0], args[1]);
        } else {
        	System.out.println("No Basic URL provided");
        }    	
    }
}
