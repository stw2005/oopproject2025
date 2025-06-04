#!/bin/bash

echo "Starting Hospital Management System Admin Portal..."
echo "Java Version:"
java -version
echo ""
echo "Starting application on port 8200..."
echo "H2 Console will be available at: http://localhost:8200/adminportal/h2-console"
echo "Admin Portal will be available at: http://localhost:8200/adminportal"
echo ""
echo "To stop the application, press Ctrl+C"
echo ""

java -jar target/adminportal-0.0.1-SNAPSHOT.jar
