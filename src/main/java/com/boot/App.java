package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

// This annotation initializes many other annotations under the covers
// One of the main subpackages allows Spring Boot to scan subprojects and, if Spring compatible, automatically configure them
@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
    	// Starts Spring, sets up Spring context, sets up embedded container
    	SpringApplication.run(App.class, args);
    	
    }
}



// src/main/resources -> class path resource so when you refresh project and do a maven refresh, it will add the folder that you created to the project
// public folder is a Spring Boot folder that stores static files