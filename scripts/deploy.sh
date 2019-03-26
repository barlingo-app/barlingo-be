#!/bin/bash

NOW=$(date +"%Y-%m-%d")

if [ "$TRAVIS_BRANCH" == "CI" ]; then
  echo "Deploying $TRAVIS_BRANCH to UAT"
  rm src/main/resources/application.properties
  rm src/main/resources/application-ci.properties
  rm src/main/resources/application-prd.properties
  mv src/main/resources/application-uat.properties src/main/resources/application.properties
  mvn clean install -P deploy -Dmaven.test.skip=true
  
  mysql -u$CI_DB_USERNAME -p$CI_DB_PASSWORD -e "drop database ${CI_DB_NAME};"
  mysql -u$CI_DB_USERNAME -p$CI_DB_PASSWORD -e "create database ${CI_DB_NAME};"
  mv src/main/resources/import.sql src/main/resources/import.sql.bck
  mvn clean install -Dspring.profiles.active=ci -Dmaven.test.skip=true
  mv src/main/resources/import.sql.bck src/main/resources/import.sql
  bash scripts/generate-db-update.sh $UAT_DB_URL $UAT_DB_USERNAME $UAT_DB_PASSWORD $CI_DB_URL $CI_DB_USERNAME $CI_DB_PASSWORD uat uat
  mysql -h $DB_HOST -u$DB_USER -D $UAT_DB_NAME -p$DB_PASSWORD < src/main/resources/database-updates/uat/db-update-uat.sql
  
  sshpass -p $DEPLOY_PASSWORD scp -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null target/barlingo-be.war $DEPLOY_USER@$DEPLOY_DOMAIN:~/barlingo-deploy-packages/barlingo-be-uat/barlingo-be.war
  sshpass -p $DEPLOY_PASSWORD ssh -o StrictHostKeyChecking=no $DEPLOY_USER@$DEPLOY_DOMAIN "bash deploy-barlingo-be.sh UAT $TRAVIS_BRANCH 1> ~/barlingo-deploy-logs/barlingo-be-uat/deploy-$NOW.log 2>&1"
elif [ "$TRAVIS_TAG" != "" ]; then
  echo "Deploying $TRAVIS_TAG to PRD"
  rm src/main/resources/application.properties
  rm src/main/resources/application-ci.properties
  rm src/main/resources/application-uat.properties
  mv src/main/resources/application-prd.properties src/main/resources/application.properties
  mvn clean install -P deploy -Dmaven.test.skip=true
  
  sshpass -p $DEPLOY_PASSWORD scp -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null target/barlingo-be.war $DEPLOY_USER@$DEPLOY_DOMAIN:~/barlingo-deploy-packages/barlingo-be-prd/barlingo-be.war
  sshpass -p $DEPLOY_PASSWORD ssh -o StrictHostKeyChecking=no $DEPLOY_USER@$DEPLOY_DOMAIN "bash deploy-barlingo-be.sh PRD $TRAVIS_TAG 1> ~/barlingo-deploy-logs/barlingo-be-prd/deploy-v$TRAVIS_TAG-$NOW.log 2>&1"
fi

exit 0