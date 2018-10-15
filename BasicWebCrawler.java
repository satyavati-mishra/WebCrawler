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
    public void getPageWiseLinks(String URL) {
        //Check if already crawled the URLs 
        if (!links.contains(URL)) {
            try {
                //If not add it to the index
                if (links.add(URL)) {
                    System.out.println(URL);
                }
                
                //If proxy setting is applied for accessing the URL.
                System.setProperty("http.proxyHost", "172.25.74.10");
                System.setProperty("http.proxyPort", "2006");

                //Fetch the HTML code using Jsoup lib
                Document document = Jsoup.connect(URL).get();
                //Parse the HTML and extract links for URLs
                Elements linksOnPage = document.select("a[href]");                
                //For each extracted URL repeat recursively
                for (Element page : linksOnPage) {
                	//getPageWiseLinks(page.attr("abs:href"));
                	//Extract links that contain the domain prudential.co.uk
    				if(page.attr("href").contains("prudential.co.uk"))
    					getPageWiseLinks(page.attr("abs:href"));                	
                }
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
                e.printStackTrace();
            }
        }
    }    
    public static void main(String[] args) {
        //1. Pick a URL from the frontier
        new BasicWebCrawler().getPageWiseLinks("https://www.prudential.co.uk/");
    }
}
