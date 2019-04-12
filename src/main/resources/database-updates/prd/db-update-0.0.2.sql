--  *********************************************************************
--  Update Database Script
--  *********************************************************************
--  Change Log: D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml
--  Ran at: 12/04/19 23:18
--  Against: barlingo_admin@81.32.230.44@jdbc:mysql://barlingo-app-db.chyacivwlzmm.us-east-1.rds.amazonaws.com:3306/barlingo_prd_db2?useSSL=false&serverTimezone=UTC
--  Liquibase version: 3.4.1
--  *********************************************************************

--  Create Database Lock Table
CREATE TABLE DATABASECHANGELOGLOCK (ID INT NOT NULL, LOCKED BIT(1) NOT NULL, LOCKGRANTED datetime NULL, LOCKEDBY VARCHAR(255) NULL, CONSTRAINT PK_DATABASECHANGELOGLOCK PRIMARY KEY (ID));

--  Initialize Database Lock Table
DELETE FROM DATABASECHANGELOGLOCK;

INSERT INTO DATABASECHANGELOGLOCK (ID, LOCKED) VALUES (1, 0);

--  Lock Database
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 1, LOCKEDBY = 'Jesus-Port (192.168.56.1)', LOCKGRANTED = '2019-04-12 23:18:17.925' WHERE ID = 1 AND LOCKED = 0;

--  Create Database Change Log Table
CREATE TABLE DATABASECHANGELOG (ID VARCHAR(255) NOT NULL, AUTHOR VARCHAR(255) NOT NULL, FILENAME VARCHAR(255) NOT NULL, DATEEXECUTED datetime NOT NULL, ORDEREXECUTED INT NOT NULL, EXECTYPE VARCHAR(10) NOT NULL, MD5SUM VARCHAR(35) NULL, DESCRIPTION VARCHAR(255) NULL, COMMENTS VARCHAR(255) NULL, TAG VARCHAR(255) NULL, LIQUIBASE VARCHAR(20) NULL, CONTEXTS VARCHAR(255) NULL, LABELS VARCHAR(255) NULL);

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-1::jesus (generated)
CREATE TABLE actor_notifications (actor_id INT NOT NULL, notifications_id INT NOT NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-1', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 1, '7:c2e8b09b30fa0a6d07c3f7cd237a4b9f', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-2::jesus (generated)
CREATE TABLE actor_roles (actor_id INT NOT NULL, roles INT NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-2', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 2, '7:8290f2cf3ce02212069e7704a684da31', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-3::jesus (generated)
CREATE TABLE admin (id INT NOT NULL, version INT NOT NULL, city VARCHAR(255) NULL, country VARCHAR(255) NULL, email VARCHAR(255) NULL, name VARCHAR(255) NULL, surname VARCHAR(255) NULL, user_account_id INT NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-3', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 3, '7:e28da822aa35082acacb09ebdc892b12', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-4::jesus (generated)
CREATE TABLE configuration (id INT NOT NULL, version INT NOT NULL, annual_discount DOUBLE NOT NULL, company_name VARCHAR(255) NULL, price_month_subscription DOUBLE NOT NULL, time_join_user_to_exchange INT NOT NULL, time_show_after_discount INT NOT NULL, time_show_before_discount INT NOT NULL, trimestral_discount DOUBLE NOT NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-4', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 4, '7:a92a4ecc3b712cd82c10cf371bd768dd', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-5::jesus (generated)
CREATE TABLE configuration_languages_code (configuration_id INT NOT NULL, languages_code VARCHAR(255) NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-5', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 5, '7:41bcad951fcaeaf12d8b02b2bb491a70', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-6::jesus (generated)
CREATE TABLE establishment (id INT NOT NULL, version INT NOT NULL, city VARCHAR(255) NULL, country VARCHAR(255) NULL, email VARCHAR(255) NULL, name VARCHAR(255) NULL, surname VARCHAR(255) NULL, user_account_id INT NULL, address VARCHAR(255) NULL, description VARCHAR(255) NULL, establishment_name VARCHAR(255) NULL, image_profile VARCHAR(3000) NULL, offer VARCHAR(255) NULL, working_hours VARCHAR(255) NULL, subscription_id INT NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-6', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 6, '7:3af946faa22b8e205c65d0579016ab90', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-7::jesus (generated)
CREATE TABLE establishment_images (establishment_id INT NOT NULL, images VARCHAR(3000) NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-7', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 7, '7:a6b6aaa1ec2f377485c9a771280590d1', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-8::jesus (generated)
CREATE TABLE hibernate_sequences (sequence_name VARCHAR(255) NOT NULL, next_val BIGINT NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-8', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 8, '7:2e6706daf92823ec405ece7183172ff8', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-9::jesus (generated)
CREATE TABLE language_exchange (id INT NOT NULL, version INT NOT NULL, description VARCHAR(255) NULL, exchange_state VARCHAR(255) NOT NULL, moment datetime(6) NOT NULL, number_max_participants INT NOT NULL, title VARCHAR(255) NULL, creator_id INT NOT NULL, establishment_id INT NOT NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-9', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 9, '7:946afdacc4069e84da7a29827e988d56', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-10::jesus (generated)
CREATE TABLE language_exchange_target_langs (language_exchange_id INT NOT NULL, target_langs VARCHAR(255) NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-10', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 10, '7:0927f207e1f03f4651103162f67e15c9', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-11::jesus (generated)
CREATE TABLE notification (id INT NOT NULL, version INT NOT NULL, description VARCHAR(255) NULL, is_read BIT(1) NULL, moment datetime(6) NOT NULL, title VARCHAR(255) NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-11', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 11, '7:217c66a03c13a91b59887797212ed06a', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-12::jesus (generated)
CREATE TABLE pay_data (id INT NOT NULL, version INT NOT NULL, moment datetime(6) NOT NULL, order_id VARCHAR(255) NOT NULL, pay_type VARCHAR(255) NOT NULL, title VARCHAR(255) NOT NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-12', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 12, '7:955568f7405adbcac7ab60e680829bfb', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-13::jesus (generated)
CREATE TABLE subscription_data (id INT NOT NULL, version INT NOT NULL, finish_moment datetime(6) NOT NULL, init_moment datetime(6) NOT NULL, price DOUBLE NOT NULL, subscription_type VARCHAR(255) NULL, paydata_id INT NOT NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-13', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 13, '7:ff69bc0704fe83a1c2dd5f14000b2551', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-14::jesus (generated)
CREATE TABLE user_account (id INT NOT NULL, version INT NOT NULL, active BIT(1) NULL, password VARCHAR(255) NULL, username VARCHAR(255) NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-14', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 14, '7:95244fabf2a8fc2e72da47a0b5fcb9cc', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-15::jesus (generated)
CREATE TABLE user_account_roles (user_account_id INT NOT NULL, roles INT NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-15', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 15, '7:346fa6ac39e96c7b30e82c7c65c0f422', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-16::jesus (generated)
CREATE TABLE user_discount (id INT NOT NULL, version INT NOT NULL, code VARCHAR(255) NULL, exchanged BIT(1) NOT NULL, visible BIT(1) NOT NULL, lang_exchange_id INT NOT NULL, user_id INT NOT NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-16', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 16, '7:095e26c5d6aeb6510b28c217f9f7f739', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-17::jesus (generated)
CREATE TABLE user_langs_to_learn (user_id INT NOT NULL, langs_to_learn VARCHAR(255) NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-17', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 17, '7:72732143dbaa7591576ab160eaa50ef2', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-18::jesus (generated)
CREATE TABLE user_speak_langs (user_id INT NOT NULL, speak_langs VARCHAR(255) NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-18', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 18, '7:15fbde52459c2d165e349ae8fab81ecf', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-19::jesus (generated)
CREATE TABLE users (id INT NOT NULL, version INT NOT NULL, city VARCHAR(255) NULL, country VARCHAR(255) NULL, email VARCHAR(255) NULL, name VARCHAR(255) NULL, surname VARCHAR(255) NULL, user_account_id INT NULL, about_me VARCHAR(255) NULL, birthday date NOT NULL, location VARCHAR(255) NULL, mother_tongue VARCHAR(255) NOT NULL, personal_pic VARCHAR(255) NULL, profile_back_pic VARCHAR(255) NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-19', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 19, '7:4d108e02ea97a9c47e5341e3b475d8a7', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-20::jesus (generated)
CREATE TABLE users_langs_exchanges (participants_id INT NOT NULL, langs_exchanges_id INT NOT NULL);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-20', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 20, '7:29f24fbdc2001904995097784e673fee', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-21::jesus (generated)
ALTER TABLE admin ADD PRIMARY KEY (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-21', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 21, '7:3f17966a21f4f1104d2da312c037442e', 'addPrimaryKey', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-22::jesus (generated)
ALTER TABLE configuration ADD PRIMARY KEY (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-22', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 22, '7:4a08b7667a2b71866daeca57d0441ee8', 'addPrimaryKey', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-23::jesus (generated)
ALTER TABLE establishment ADD PRIMARY KEY (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-23', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 23, '7:688df10a5ead4274a83c26cea86a941b', 'addPrimaryKey', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-24::jesus (generated)
ALTER TABLE hibernate_sequences ADD PRIMARY KEY (sequence_name);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-24', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 24, '7:b9c60814bbaf412f839962972612347c', 'addPrimaryKey', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-25::jesus (generated)
ALTER TABLE language_exchange ADD PRIMARY KEY (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-25', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 25, '7:07093f4145f639f9ac7826623da67074', 'addPrimaryKey', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-26::jesus (generated)
ALTER TABLE notification ADD PRIMARY KEY (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-26', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 26, '7:3341eaf46fc5e4039a67400c0da28198', 'addPrimaryKey', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-27::jesus (generated)
ALTER TABLE pay_data ADD PRIMARY KEY (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-27', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 27, '7:aa3c83de65b76fb8ae8021ed4aa8eafd', 'addPrimaryKey', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-28::jesus (generated)
ALTER TABLE subscription_data ADD PRIMARY KEY (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-28', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 28, '7:afc41f5f4e389c9ca86afe5926d0a5de', 'addPrimaryKey', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-29::jesus (generated)
ALTER TABLE user_account ADD PRIMARY KEY (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-29', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 29, '7:71c1d5d85c1e787d604394ed6276b7e7', 'addPrimaryKey', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-30::jesus (generated)
ALTER TABLE user_discount ADD PRIMARY KEY (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-30', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 30, '7:6417a30dcd4cde7129d275ab86d1034c', 'addPrimaryKey', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-31::jesus (generated)
ALTER TABLE users ADD PRIMARY KEY (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-31', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 31, '7:cb7ebb8975b6e96710c233ae8ed6d330', 'addPrimaryKey', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-32::jesus (generated)
ALTER TABLE user_discount ADD CONSTRAINT UK_991wihuvn1hpjy1dwfqo4ab02 UNIQUE (code);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-32', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 32, '7:62bf87734a1f54fcc458601a06c96891', 'addUniqueConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-33::jesus (generated)
ALTER TABLE subscription_data ADD CONSTRAINT UK_j5crnny10un9ervnv9v4ixvai UNIQUE (paydata_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-33', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 33, '7:a716dc444427c19576d2df23d8968643', 'addUniqueConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-34::jesus (generated)
ALTER TABLE actor_notifications ADD CONSTRAINT UK_s7d1aq44skvefpanjol2vy213 UNIQUE (notifications_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-34', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 34, '7:19201934541e6773947e4e85d8bd7fd6', 'addUniqueConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-35::jesus (generated)
CREATE INDEX FK30kkj4wkg4uasf2ajl4jf0mt1 ON user_langs_to_learn(user_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-35', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 35, '7:92b48b3be0888d9fac429076da61389a', 'createIndex', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-36::jesus (generated)
CREATE INDEX FK3aimjqcvgqm3x1nfv3liy2g5r ON establishment(subscription_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-36', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 36, '7:8a22c8f1e3eba62057fa36093f9fe684', 'createIndex', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-37::jesus (generated)
CREATE INDEX FK6cc3xc86if6k5jnye7ujf835o ON configuration_languages_code(configuration_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-37', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 37, '7:a90ccbebac2e2b01b22ffd4e81ab77ed', 'createIndex', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-38::jesus (generated)
CREATE INDEX FK_134wnbnf754vg81d5nu2wwcuc ON establishment(user_account_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-38', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 38, '7:3db4dc77fcf7e01b6947964ff5c9d62e', 'createIndex', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-39::jesus (generated)
CREATE INDEX FK_jm7fmb3hqmw0m2o58w571egjg ON users(user_account_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-39', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 39, '7:d3c75fef49d195bc32608c2513a8fcd8', 'createIndex', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-40::jesus (generated)
CREATE INDEX FK_pctvkahm11wo6th663udtvigg ON admin(user_account_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-40', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 40, '7:0e1b4b77a2b13d23fbf3662031be7649', 'createIndex', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-41::jesus (generated)
CREATE INDEX FKc97p0nj700btjon7gehjdnuvj ON language_exchange_target_langs(language_exchange_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-41', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 41, '7:ff8554e5fb87f23be8cb0c0b3af0a4ce', 'createIndex', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-42::jesus (generated)
CREATE INDEX FKgi2pqg5x35x2vh1rregocfjk8 ON user_discount(user_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-42', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 42, '7:5e913fac0748deb6dfbad1e1e2976a9c', 'createIndex', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-43::jesus (generated)
CREATE INDEX FKh4qw5hgwjaxdpmft779wlkgsm ON user_speak_langs(user_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-43', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 43, '7:a09d0464b795ce942ccf53f3a9cd2e8d', 'createIndex', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-44::jesus (generated)
CREATE INDEX FKjvkge9ueu7198iiw09j13j0nr ON language_exchange(establishment_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-44', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 44, '7:44189949687f0d3647599a08feb263fe', 'createIndex', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-45::jesus (generated)
CREATE INDEX FKntx1hfwf6w4q0kvfa5lk62e87 ON user_discount(lang_exchange_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-45', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 45, '7:e21febb30319200d885c5ce00934607d', 'createIndex', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-46::jesus (generated)
CREATE INDEX FKovy5i3qivcnock9odgg40wwcu ON users_langs_exchanges(participants_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-46', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 46, '7:483ebd55c98e927074180d607042394d', 'createIndex', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-47::jesus (generated)
CREATE INDEX FKpacca51k3kkqoqs0nbmyugdt2 ON user_account_roles(user_account_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-47', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 47, '7:0da92ec8c34bc3a7c00bf50c68f3ce95', 'createIndex', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-48::jesus (generated)
CREATE INDEX FKrct4vhdcoehqaeo4q3qwr18uj ON language_exchange(creator_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-48', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 48, '7:da95cd3a388296552a6baf90e6475f74', 'createIndex', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-49::jesus (generated)
CREATE INDEX FKswc4qrd1nvn8qank15fqkbyu6 ON establishment_images(establishment_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-49', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 49, '7:33004ce73c2876146e9b59bbdd548bdb', 'createIndex', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-50::jesus (generated)
CREATE INDEX FKtkkcywc6cx0e1dma9u70kwt0r ON users_langs_exchanges(langs_exchanges_id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-50', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 50, '7:5e561b8495dcea73c7ffd29202b2d54b', 'createIndex', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-51::jesus (generated)
ALTER TABLE user_langs_to_learn ADD CONSTRAINT FK30kkj4wkg4uasf2ajl4jf0mt1 FOREIGN KEY (user_id) REFERENCES users (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-51', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 51, '7:a5f828376a0e1a7dae16470450744618', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-52::jesus (generated)
ALTER TABLE establishment ADD CONSTRAINT FK3aimjqcvgqm3x1nfv3liy2g5r FOREIGN KEY (subscription_id) REFERENCES subscription_data (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-52', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 52, '7:30383424385ab821f6b1a1b710b905ba', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-53::jesus (generated)
ALTER TABLE configuration_languages_code ADD CONSTRAINT FK6cc3xc86if6k5jnye7ujf835o FOREIGN KEY (configuration_id) REFERENCES configuration (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-53', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 53, '7:0ae9c52992b4f5a3f9731698b04dd10a', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-54::jesus (generated)
ALTER TABLE actor_notifications ADD CONSTRAINT FK8r6gr4nh8ahboovee2crrn7rj FOREIGN KEY (notifications_id) REFERENCES notification (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-54', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 54, '7:964a1a86b2abdbc13f729c9adb149f3f', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-55::jesus (generated)
ALTER TABLE establishment ADD CONSTRAINT FK_134wnbnf754vg81d5nu2wwcuc FOREIGN KEY (user_account_id) REFERENCES user_account (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-55', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 55, '7:08a10acc02efb13cc7d1b0d363eca287', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-56::jesus (generated)
ALTER TABLE users ADD CONSTRAINT FK_jm7fmb3hqmw0m2o58w571egjg FOREIGN KEY (user_account_id) REFERENCES user_account (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-56', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 56, '7:8e814f23844780ec6697fb71fcc68aa3', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-57::jesus (generated)
ALTER TABLE admin ADD CONSTRAINT FK_pctvkahm11wo6th663udtvigg FOREIGN KEY (user_account_id) REFERENCES user_account (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-57', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 57, '7:a0bae9618bead2b0e4b20d845d2562fe', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-58::jesus (generated)
ALTER TABLE language_exchange_target_langs ADD CONSTRAINT FKc97p0nj700btjon7gehjdnuvj FOREIGN KEY (language_exchange_id) REFERENCES language_exchange (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-58', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 58, '7:1b850c7f941650f04b71f9dd793058f9', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-59::jesus (generated)
ALTER TABLE user_discount ADD CONSTRAINT FKgi2pqg5x35x2vh1rregocfjk8 FOREIGN KEY (user_id) REFERENCES users (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-59', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 59, '7:2d9a8e8a72cb8e45a46ae94934b6842f', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-60::jesus (generated)
ALTER TABLE user_speak_langs ADD CONSTRAINT FKh4qw5hgwjaxdpmft779wlkgsm FOREIGN KEY (user_id) REFERENCES users (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-60', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 60, '7:143e0481a8e2d5b199686240102079b8', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-61::jesus (generated)
ALTER TABLE language_exchange ADD CONSTRAINT FKjvkge9ueu7198iiw09j13j0nr FOREIGN KEY (establishment_id) REFERENCES establishment (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-61', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 61, '7:3c54e62e536ab58f3a77b37b4fc43e8f', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-62::jesus (generated)
ALTER TABLE user_discount ADD CONSTRAINT FKntx1hfwf6w4q0kvfa5lk62e87 FOREIGN KEY (lang_exchange_id) REFERENCES language_exchange (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-62', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 62, '7:736735ee251553b6ab259962f11d101f', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-63::jesus (generated)
ALTER TABLE users_langs_exchanges ADD CONSTRAINT FKovy5i3qivcnock9odgg40wwcu FOREIGN KEY (participants_id) REFERENCES users (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-63', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 63, '7:2016175b6a160c2d7e95cd690b6ff7eb', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-64::jesus (generated)
ALTER TABLE user_account_roles ADD CONSTRAINT FKpacca51k3kkqoqs0nbmyugdt2 FOREIGN KEY (user_account_id) REFERENCES user_account (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-64', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 64, '7:833b1c64cc166d4a54b51ddde55b9f77', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-65::jesus (generated)
ALTER TABLE subscription_data ADD CONSTRAINT FKr8ofkp92b4mvxtlk79ctyco8n FOREIGN KEY (paydata_id) REFERENCES pay_data (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-65', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 65, '7:cf2a96ca19bf46a71dc0ac2de2985363', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-66::jesus (generated)
ALTER TABLE language_exchange ADD CONSTRAINT FKrct4vhdcoehqaeo4q3qwr18uj FOREIGN KEY (creator_id) REFERENCES users (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-66', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 66, '7:2ef64d5bab457b599518ca454aabdaf2', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-67::jesus (generated)
ALTER TABLE establishment_images ADD CONSTRAINT FKswc4qrd1nvn8qank15fqkbyu6 FOREIGN KEY (establishment_id) REFERENCES establishment (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-67', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 67, '7:ee67dfe169a492d0ebcd35c6ce7072b1', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml::1555103889157-68::jesus (generated)
ALTER TABLE users_langs_exchanges ADD CONSTRAINT FKtkkcywc6cx0e1dma9u70kwt0r FOREIGN KEY (langs_exchanges_id) REFERENCES language_exchange (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1555103889157-68', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 68, '7:324487ceebbc3fd333f048540173f1e0', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Release Database Lock
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 0, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

