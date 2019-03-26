#!/bin/bash

NOW=$(date +"%Y-%m-%d")

if [ "$TRAVIS_BRANCH" == "CI" ]; then
  echo "Deploying $TRAVIS_BRANCH to UAT"
  rm src/main/resources/application.properties
  rm src/main/resources/application-ci.properties
  rm src/main/resources/application-prd.properties
  mv src/main/resources/application-uat.properties src/main/resources/application.properties
  mvn clean install -P deploy -Dmaven.test.skip=true
  
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