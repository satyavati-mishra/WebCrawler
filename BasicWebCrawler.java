package com.satya.webcrawler;
import com.satya.webcrawler.Services.*;
public class BasicWebCrawler {

    public static void main(String[] args) {
       
        //1. Pick a URL "https://www.prudential.co.uk/" and  prudential.co.uk as exact match from the frontier 
    	if(args.length==1){
    		new ExtractLinkServiceImpl().extractLink(args[0], "");
        }else if(args.length==2){
        	new ExtractLinkServiceImpl().extractLink(args[0], args[1]);
        } else {
        	System.out.println("No Proper args passed");
        }         
    }
}
