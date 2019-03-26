#!/bin/bash

TARGET_DB_URL=$1
TARGET_DB_USER=$2
TARGET_DB_PASSWORD=$3
SOURCE_DB_URL=$4
SOURCE_DB_USER=$5
SOURCE_DB_PASSWORD=$6
ENVIRONMENT=$7
VERSION=$8

RESOURCES_PATH=src/main/resources

mv "$RESOURCES_PATH/import.sql" "$RESOURCES_PATH/import.sql.bck"
rm "$RESOURCES_PATH/liquibase-diff-changeLog.xml"

mvn liquibase:diff -Ddb.url=$TARGET_DB_URL -Ddb.username=$TARGET_DB_USER -Ddb.password=$TARGET_DB_PASSWORD -Ddb.refurl=$SOURCE_DB_URL -Ddb.refusername=$SOURCE_DB_USER -Ddb.refpassword=$SOURCE_DB_PASSWORD -Dmaven.test.skip=true
mvn liquibase:updateSQL -Ddb.url=$TARGET_DB_URL -Ddb.username=$TARGET_DB_USER -Ddb.password=$TARGET_DB_PASSWORD -Ddb.refurl=$SOURCE_DB_URL -Ddb.refusername=$SOURCE_DB_USER -Ddb.refpassword=$SOURCE_DB_PASSWORD -Ddb.env=$ENVIRONMENT -Ddb.version=$VERSION -Dmaven.test.skip=true

rm "$RESOURCES_PATH/liquibase-diff-changeLog.xml"
mv "$RESOURCES_PATH/import.sql.bck" "$RESOURCES_PATH/import.sql"