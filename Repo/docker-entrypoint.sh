#!/bin/bash

# Start Xvfb
Xvfb :99 -screen 0 1920x1080x24 &
sleep 2

# Change directory to where the pom.xml is located
cd /app || exit 1  # Exit the script if 'cd /app' fails

# Execute tests based on the LANGUAGE environment variable
case ${LANGUAGE:-java} in
  java)
    echo "Running Java tests..."
    mvn test
    ;;
  *)
    echo "Unsupported language: $LANGUAGE"
    exit 1
    ;;
esac
