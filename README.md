# spring-boot-excel-and-restTemplate
An API that can consume 3rd party APIs, save them to a database, and export them as an Excel file
<p>
This project send a get request to <a>https://jsonplaceholder.typicode.com/posts</a> link , save the all post to h2-db.
Also, user can be able to the export all data in the database to the Excel File
</p>

## Excel File 
To be able to generate excel file you have to add  these dependencies
```
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi</artifactId>
			<version>5.0.0</version>
		</dependency>
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>5.0.0</version>
		</dependency>
		<dependency>
```


## Dependencies
<ul>
<li>h2-database</>
<li>Lombok</>
<li>poi-ooxml</li>
<li>poi</li>
</ul>
