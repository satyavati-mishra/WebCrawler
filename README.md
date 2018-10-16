# WebCrawler
## What is this repository for?
* What is this repository for?
This repository is for navigating the Web and finds new or updated pages for indexing. The Crawler starts with seed websites or a wide range of popular URLs (also known as the frontier) and searches in depth and width for hyperlinks to extract.
In the repository user can add the seed url from main arguments. The crawler can be restricted to single domain search only. In repository developer can add the exact match as the argument.

## How do I get set up?
**This is simple java application.
**Install java 5 or above
**Download jsoup.jar
**Clone the class file, add the files in proper packages
### What is required for JUnit?
*Download
**junit_4.12.jar
**hancrest-core.1.3.jar
**Add to classpath or add as extrenal jar in eclipse

### Application set up
**Compile and run BasicWebCrawler.java with arguments passed as the seed url and exact match
** OR use editors like eclipse and run as Run Configurations, set Program arguments
**You may get proxy error, set you proxy by System.setProperty("http.proxyHost", "x.x.x.x");                 System.setProperty("http.proxyPort", "x");

## What next if more time
*If more Time this can be made a mavenized spring boot application as a microservice. 
*Create Angular SPA and get exact match from user and use this as company specific Web crawler for providing Department specific pdfs etc.
