🔹Step 1: Project Setup

Initialize the Spring Boot Project

Use Spring Initializr to generate a Spring Boot project.
Select dependencies: Spring Web, DevTools, Actuator, and Starter Test.
Download and import the project into Eclipse or IntelliJ IDEA as a Maven project.
Install Dependencies

Ensure that Maven downloads the required dependencies by running mvn clean install.

🔹Step 2: Configure API Integration
Choose a Public Exchange Rate API

Use an external API like ExchangeRate-API or Open Exchange Rates to fetch live exchange rates.
Store API Configuration

Save the API base URL and API key in the application.properties file to allow easy configuration.
Implement API Integration Service

Create a service that makes an HTTP request to fetch exchange rates and returns them in a structured format.

🔹Step 3: Implement REST Endpoints
Create an Endpoint to Fetch Exchange Rates

A GET API /api/rates?base=USD allows users to fetch exchange rates based on a given currency.
If no base currency is provided, it defaults to USD.
Create an Endpoint to Convert Currency

A POST API /api/convert takes input data:
From currency
To currency
Amount to convert
It returns the converted amount based on the latest exchange rates.

🔹Step 4: Handle Errors Properly
Manage API Errors

Handle cases where the external API is down or unreachable.
Implement retries or fallback mechanisms.
Validate User Input

Ensure that the provided currency codes are valid.
Return meaningful error messages for invalid or missing data.
Create a Global Exception Handler

Use centralized error handling to respond with clear HTTP status codes and error messages.

🔹Step 5: Write Unit Tests
Test the Service Layer

Mock the external API response and validate the correctness of exchange rate fetching.
Test Currency Conversion Logic

Verify that the conversion formula correctly applies exchange rates.
Test edge cases (e.g., zero amount, negative values, or unsupported currencies).

🔹Step 6: Deployment
Prepare the Application for Deployment

Configure properties for different environments (e.g., development, production).
Store API keys securely using environment variables.
Deploy to a Cloud Platform

Choose a deployment platform (e.g., Heroku, AWS, Azure, or DigitalOcean).
Set up a CI/CD pipeline for automated deployment.

🔹Step 7: Documentation & Submission
Write a README File

Explain how to set up, run, and test the application locally.
Provide details about the API endpoints and expected responses.
Host the Code in a Git Repository

Push the project to GitHub, GitLab, or Bitbucket.
Share the repository URL for submission.

✅ Expected Learning Outcomes
RESTful API development with Spring Boot.
Integrating external services (public APIs).
Error handling and exception management.
Writing unit tests for service layers.
Following best practices in Java and Spring Boot development.
