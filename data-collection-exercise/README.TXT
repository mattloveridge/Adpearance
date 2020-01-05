# Adpearance Data Collection Java Developer Coding Exercise

A major component of Data Collection is importing inventory directly from a client's website without the convenience of an API or direct database access.  

The purpose of this exercise is to simulate the entire life cycle of a client's inventory from the initial scrape, to persisting the inventory in a relational database, and finally
making the data searchable through GraphQL.

This project contains all of the necessary Maven dependencies in the pom.xml to complete this project.  Although some Java classes have been provided for you others have been intentionally omitted.  Update the existing files with missing logic and create new ones when necessary.

The inventory for this exercise is hosted on a dummy client site located at:
http://exercise.fourbot.io/index.html

For this exercise you will be importing Cars which are already defined for you.

The project already contains a method for loading the website via an Http request.  
You are expected to make use of Jsoup for parsing the HTML and extracting the inventory.  Documentation for Jsoup can be found at: https://jsoup.org/

Jsoup relies on CSS style selectors for searching for tags and content within a static HTML page.  This is not to be confused with a headless browser.

Once you've scraped all of the inventory from the website you will persist it via JPA into a MySQL database that has been provided for you at the following endpoint: 
fourbot-sandbox.cxleghuzmjdj.us-west-2.rds.amazonaws.com

schema name is in the form of <first name>-<last name>
username is your first name    password is your last name

Update the provided application.properties file with the necessary values to connect to the database.

The schema is empty and you have the necessary permissions to create the necessary tables to persist the inventory.  
Use MySQL Workbench or a similar tool to connect to the database to create tables and access the underlying inventory.

The project includes a Controller and Service for invoking the scrape.  
Please wire everything up so that the Controller invokes the Service and passes in the URL of the page to be scraped.  
Output can simply be an HTTP status code indicating success or failure.

Project also includes a GraphQL Resolver for performing inventory searches.  
Please wire this up so that it makes use of JPA to query inventory.  
Additionally update the Search so that it supports simple filtering by make and ordering by price from low to high.  
Project already includes a graphqls file located at:
src/main/resources/graphql/datacollectionexcercise.graphqls

The project includes the GraphiQL browser which can be accessed while the project is running.  Just point your web browser at:  localhost/graphiql
You can use this to test your GraphQL.

In addition to scraping for car inventory I would like you to also scrape for Client contact info.  
There is no code provided for this.  Please create the necessary classes to persist and search for this data.

My expectation is for a data type along the lines of: Id   domain   mailing address   phone number   email address

Since we have only provided you with a single website to scrape I would only expect there to be only one record in the database.  Use Jsoup to scrape for this data as well.





# Adpearance Data Collection Java Developer Coding Exercise

A major component of Data Collection is importing inventory directly from a client's website without the convenience of an API or direct database access.  
The purpose of this exercise is to simulate the entire life cycle of a client's inventory from the initial scrape, 
to persisting the inventory in a relational database, and finally
making the data searchable through GraphQL.

This project contains all of the necessary Maven dependencies in the pom.xml to complete this project.  
Although some Java classes have been provided for you others have been intentionally omitted.  Update the existing
files with missing logic and create new ones when necessary.

The inventory for this exercise is hosted on a dummy client site located at:

http://exercise.fourbot.io/index.html

For this exercise you will be importing Cars which are already defined for you in:

com.adpearance.datacollectionexercise.model.Car

The project already contains a method for loading the website via an Http request.  
You are expected to make use of Jsoup for parsing the HTML and extracting the inventory.  Documentation for Jsoup can be found at:

https://jsoup.org/

Jsoup relies on CSS style selectors for searching for tags and content within a static HTML page.  This is not to be confused with a headless browser.

Once you've scraped all of the inventory from the website you will persist it via JPA into a MySQL database 
that has been provided for you at the following endpoint:

fourbot-sandbox.cxleghuzmjdj.us-west-2.rds.amazonaws.com

schema name is in the form of <first name>-<last name>
username is your first name
password is your last name

Update the provided application.properties file with the necessary values to connect to the database.

The schema is empty and you have the necessary permissions to create the necessary tables to persist the inventory.  
Use MySQL Workbench or a similar tool to connect to the database to create tables and access the underlying inventory.

The project includes a Controller and Service for invoking the scrape.  
Please wire everything up so that the Controller invokes the Service and passes in the URL of the page to be scraped.  
Output can simply be an HTTP status code indicating success or failure.

Project also includes a GraphQL Resolver for performing inventory searches.  
Please wire this up so that it makes use of JPA to query inventory.  
Additionally update the Search so that it supports simple filtering by make and ordering by price from low to high.  
Project already includes a graphqls file located at:

src/main/resources/graphql/datacollectionexcercise.graphqls

The project includes the GraphiQL browser which can be accessed while the project is running.  Just point your web browser at:

localhost/graphiql

You can use this to test your GraphQL.

In addition to scraping for car inventory I would like you to also scrape for Client contact info.  
There is no code provided for this.  Please create the necessary classes to persist and search for this data.

My expectation is for a data type along the lines of:

id
domain
mailing address
phone number
email address

Since we have only provided you with a single website to scrape I would only expect there to be only one record in the database.  
Use Jsoup to scrape for this data as well.



