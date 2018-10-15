# WebCrawler
## What is this repository for?
## How do I get set up?
### Application set up
## What next if more time
* What is this repository for?
This repository is for navigating the Web and finds new or updated pages for indexing. The Crawler starts with seed websites or a wide range of popular URLs (also known as the frontier) and searches in depth and width for hyperlinks to extract.
In the repository user can add the seed url from main arguments. The crawler can be restricted to single domain search only. In repository developer can add the exact match as the argument.

* How do I get set up?
**This is simple java application.
**Install java 5 or above
**Download jsoup.jar
**Clone the class file, add the files in proper packages


*Application set up
**Compile and run BasicWebCrawler.java with arguments passed as the seed url and exact match
** OR use editors like eclipse and run as Run Configurations, set Program arguments
**You may get proxy error, set you proxy by System.setProperty("http.proxyHost", "x.x.x.x");                 System.setProperty("http.proxyPort", "x");

*If more Time this can be made a mavenized spring boot application as a microservice. 
*Create Angular SPA and get exact match from user and use this as company specific Web crawler for providing Department specific pdfs etc.
