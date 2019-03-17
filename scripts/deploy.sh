#!/bin/bash

NOW=$(date +"%Y-%m-%d")

if [ "$TRAVIS_BRANCH" == "CI" ]; then
  echo "Deploying $TRAVIS_BRANCH to UAT"
  sshpass -p $DEPLOY_PASSWORD ssh -o StrictHostKeyChecking=no $DEPLOY_USER@$DEPLOY_DOMAIN "bash deploy-barlingo-be.sh UAT $TRAVIS_BRANCH 1> ~/barlingo-deploy-logs/barlingo-be-uat/deploy-$NOW.log 2>&1"
elif [ "$TRAVIS_TAG" != "" ]; then
  echo "Deploying $TRAVIS_TAG to PRD"
  sshpass -p $DEPLOY_PASSWORD ssh -o StrictHostKeyChecking=no $DEPLOY_USER@$DEPLOY_DOMAIN "bash deploy-barlingo-be.sh PRD $TRAVIS_TAG 1> ~/barlingo-deploy-logs/barlingo-be-prd/deploy-v$TRAVIS_TAG-$NOW.log 2>&1"
fi

exit 0