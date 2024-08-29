<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Management System - README</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 20px;
        }
        h1, h2 {
            color: #2c3e50;
        }
        code {
            background-color: #f4f4f4;
            padding: 2px 4px;
            border-radius: 4px;
            color: #c7254e;
        }
        pre {
            background-color: #f4f4f4;
            padding: 10px;
            border-radius: 4px;
            overflow-x: auto;
        }
        ul {
            margin: 0;
            padding: 0;
            list-style-type: none;
        }
        li {
            margin-bottom: 8px;
        }
    </style>
</head>
<body>
    <h1>Student Management System - README</h1>
    <h2>Introduction</h2>
    <p>This Spring Boot project provides a RESTful API for managing student records, including creation and updates with validation and automatic calculations.</p>
    <h2>Technologies Used</h2>
    <ul>
        <li>Spring Boot</li>
        <li>JPA/Hibernate</li>
        <li>SQL Server</li>
        <li>Java 8 or later</li>
    </ul>
    <h2>API Endpoints</h2>
    <h3>Create a Student</h3>
    <p><strong>Endpoint:</strong> <code>POST /students/create</code></p>
    <p><strong>Request Body:</strong></p>
    <pre><code>
{
  "firstName": "John",
  "lastName": "Doe",
  "dob": "2005-04-12",
  "section": "A",
  "gender": "M",
  "marks1": 85,
  "marks2": 90,
  "marks3": 78
}
    </code></pre>
    <p><strong>Validation:</strong></p>
    <ul>
        <li>ID is auto-generated.</li>
        <li>First and last names must be at least 3 characters.</li>
        <li>Date of birth is mandatory; age must be between 15 and 20 years.</li>
        <li>Marks are optional but must be between 0 and 100 if provided.</li>
        <li>Section must be "A", "B", or "C".</li>
        <li>Gender must be "M" or "F".</li>
        <li>Total, average, and result are calculated automatically.</li>
        <li>Minimum marks for each subject are 35 to pass.</li>
    </ul>
    <p><strong>Response:</strong></p>
    <ul>
        <li><code>200 OK</code> with student details if successful.</li>
        <li><code>400 Bad Request</code> with validation error messages if validation fails.</li>
    </ul>
    <h3>Update Student Marks</h3>
    <p><strong>Endpoint:</strong> <code>PUT /students/update/{id}</code></p>
    <p><strong>Request Body:</strong></p>
    <pre><code>
{
  "marks1": 88,
  "marks2": 92,
  "marks3": 80
}
    </code></pre>
    <p><strong>Validation:</strong></p>
    <ul>
        <li>Marks 1, 2, and 3 are mandatory.</li>
        <li>Marks must be between 0 and 100.</li>
    </ul>
    <p><strong>Response:</strong></p>
    <ul>
        <li><code>200 OK</code> with updated student details if successful.</li>
        <li><code>400 Bad Request</code> with validation error messages if validation fails.</li>
    </ul>
    <h2>Global Exception Handling</h2>
    <p>The application includes a global exception handler for consistent error responses:</p>
    <ul>
        <li>Validation Errors: Returns detailed validation error messages.</li>
        <li>Other Exceptions: Returns a generic error message with a <code>500 Internal Server Error</code> status.</li>
    </ul>
    <h2>Setup and Configuration</h2>
    <p>Ensure that your <code>application.properties</code> or <code>application.yml</code> is configured for SQL Server connection.</p>
    <h2>Conclusion</h2>
    <p>This project demonstrates a basic student management system with endpoints for creating and updating student records. It includes validation, error handling, and automatic calculations for student performance.</p>
</body>
</html>
