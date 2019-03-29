#!/bin/bash

NOT_PR=false

echo "Source branch: $TRAVIS_PULL_REQUEST_BRANCH"
echo "Target branch: $TRAVIS_BRANCH"

if [ "$TRAVIS_PULL_REQUEST" != "$NOT_PR" ]; then
  echo "Merging PR into $TRAVIS_BRANCH"

  git remote set-url origin https://$GITHUB_TOKEN@github.com/$TRAVIS_REPO_SLUG.git

  git fetch origin
  git checkout $TRAVIS_PULL_REQUEST_BRANCH
  git merge $TRAVIS_BRANCH
  
  git checkout $TRAVIS_BRANCH
  git merge --no-ff $TRAVIS_PULL_REQUEST_BRANCH
  git push origin $TRAVIS_BRANCH

  git push --delete origin $TRAVIS_PULL_REQUEST_BRANCH
fi

exit 0