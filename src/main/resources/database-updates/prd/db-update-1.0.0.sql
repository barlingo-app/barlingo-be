--  *********************************************************************
--  Update Database Script
--  *********************************************************************
--  Change Log: D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml
--  Ran at: 3/05/19 23:55
--  Against: root@localhost@jdbc:mysql://localhost/barlingo_db?useSSL=false&serverTimezone=UTC
--  Liquibase version: 3.4.1
--  *********************************************************************

--  Create Database Lock Table
CREATE TABLE DATABASECHANGELOGLOCK (ID INT NOT NULL, LOCKED BIT(1) NOT NULL, LOCKGRANTED datetime NULL, LOCKEDBY VARCHAR(255) NULL, CONSTRAINT PK_DATABASECHANGELOGLOCK PRIMARY KEY (ID));

--  Initialize Database Lock Table
DELETE FROM DATABASECHANGELOGLOCK;

INSERT INTO DATABASECHANGELOGLOCK (ID, LOCKED) VALUES (1, 0);

--  Lock Database
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 1, LOCKEDBY = 'Jesus-Port (192.168.56.1)', LOCKGRANTED = '2019-05-03 23:55:58.235' WHERE ID = 1 AND LOCKED = 0;

--  Create Database Change Log Table
CREATE TABLE DATABASECHANGELOG (ID VARCHAR(255) NOT NULL, AUTHOR VARCHAR(255) NOT NULL, FILENAME VARCHAR(255) NOT NULL, DATEEXECUTED datetime NOT NULL, ORDEREXECUTED INT NOT NULL, EXECTYPE VARCHAR(10) NOT NULL, MD5SUM VARCHAR(35) NULL, DESCRIPTION VARCHAR(255) NULL, COMMENTS VARCHAR(255) NULL, TAG VARCHAR(255) NULL, LIQUIBASE VARCHAR(20) NULL, CONTEXTS VARCHAR(255) NULL, LABELS VARCHAR(255) NULL);

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-1::jesus (generated)
ALTER TABLE user_langs_to_learn DROP FOREIGN KEY FK30kkj4wkg4uasf2ajl4jf0mt1;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-1', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 1, '7:ad3e8e0adebb377760624268b674d39c', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-2::jesus (generated)
ALTER TABLE establishment DROP FOREIGN KEY FK3aimjqcvgqm3x1nfv3liy2g5r;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-2', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 2, '7:d604b078cf4d6ff5e03469a16bf4ff0d', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-3::jesus (generated)
ALTER TABLE configuration_languages_code DROP FOREIGN KEY FK6cc3xc86if6k5jnye7ujf835o;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-3', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 3, '7:8d53ca2ed883920e09c27e86f68ab575', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-4::jesus (generated)
ALTER TABLE establishment DROP FOREIGN KEY FK_134wnbnf754vg81d5nu2wwcuc;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-4', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 4, '7:4af87a6027868f929affda9bb86c929c', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-5::jesus (generated)
ALTER TABLE users DROP FOREIGN KEY FK_jm7fmb3hqmw0m2o58w571egjg;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-5', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 5, '7:7bf812e0a0374b8dbcabdbf8f599151b', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-6::jesus (generated)
ALTER TABLE admin DROP FOREIGN KEY FK_pctvkahm11wo6th663udtvigg;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-6', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 6, '7:44a402b8956d7f42d43d7ce261a00b73', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-7::jesus (generated)
ALTER TABLE language_exchange_target_langs DROP FOREIGN KEY FKc97p0nj700btjon7gehjdnuvj;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-7', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 7, '7:c7e58bf0b8ec0d5432c27f2770acfe06', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-8::jesus (generated)
ALTER TABLE user_discount DROP FOREIGN KEY FKgi2pqg5x35x2vh1rregocfjk8;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-8', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 8, '7:23f44b39d9f3ce76b7bffec70a252d53', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-9::jesus (generated)
ALTER TABLE user_speak_langs DROP FOREIGN KEY FKh4qw5hgwjaxdpmft779wlkgsm;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-9', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 9, '7:5a3a23228d8834ecc0251e09d831ed6f', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-10::jesus (generated)
ALTER TABLE language_exchange DROP FOREIGN KEY FKjvkge9ueu7198iiw09j13j0nr;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-10', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 10, '7:67416ff89bc930e98708de5b31888120', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-11::jesus (generated)
ALTER TABLE notification_receiver DROP FOREIGN KEY FKmkh5n7otyogidkltg6oh64psj;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-11', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 11, '7:3edc6c3bf9b2482898d1432ac1983a40', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-12::jesus (generated)
ALTER TABLE user_discount DROP FOREIGN KEY FKntx1hfwf6w4q0kvfa5lk62e87;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-12', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 12, '7:ed70e7a61ede8003f2a643baa78f50f7', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-13::jesus (generated)
ALTER TABLE users_langs_exchanges DROP FOREIGN KEY FKovy5i3qivcnock9odgg40wwcu;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-13', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 13, '7:9d76b0de6579f74b11e2f6a8d5fc441b', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-14::jesus (generated)
ALTER TABLE user_account_roles DROP FOREIGN KEY FKpacca51k3kkqoqs0nbmyugdt2;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-14', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 14, '7:cc5df2c23b8d5c32a8e430ea182d6f03', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-15::jesus (generated)
ALTER TABLE subscription_data DROP FOREIGN KEY FKr8ofkp92b4mvxtlk79ctyco8n;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-15', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 15, '7:822501f35ca4c0cad634199cbd61c1c4', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-16::jesus (generated)
ALTER TABLE language_exchange DROP FOREIGN KEY FKrct4vhdcoehqaeo4q3qwr18uj;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-16', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 16, '7:9d4e72d98e0acb42488a0bc53bde6834', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-17::jesus (generated)
ALTER TABLE establishment_images DROP FOREIGN KEY FKswc4qrd1nvn8qank15fqkbyu6;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-17', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 17, '7:fa9e80fe9ca3b96a117f5a20d10861a9', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-18::jesus (generated)
ALTER TABLE users_langs_exchanges DROP FOREIGN KEY FKtkkcywc6cx0e1dma9u70kwt0r;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-18', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 18, '7:6c55df0585daf4689f41fbf9c42eccb6', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-19::jesus (generated)
ALTER TABLE user_discount DROP KEY UK_991wihuvn1hpjy1dwfqo4ab02;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-19', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 19, '7:32c6d3e9e0f04c5266741a6972727e6d', 'dropUniqueConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-20::jesus (generated)
ALTER TABLE subscription_data DROP KEY UK_j5crnny10un9ervnv9v4ixvai;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-20', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 20, '7:9807b130ef1f02eaf1cc85ef554d8590', 'dropUniqueConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-21::jesus (generated)
DROP TABLE admin;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-21', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 21, '7:e4ebf9b2d7730e1981d7c7d7e25a880d', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-22::jesus (generated)
DROP TABLE configuration;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-22', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 22, '7:babdf250a9b28d152d0bcc8751d7fa4c', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-23::jesus (generated)
DROP TABLE configuration_languages_code;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-23', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 23, '7:f908444ffd78249ec9bf2627ee61d1fd', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-24::jesus (generated)
DROP TABLE establishment;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-24', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 24, '7:07beb0b1c77702b9915b0f7a564fa9d8', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-25::jesus (generated)
DROP TABLE establishment_images;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-25', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 25, '7:2fee3cb804714cde71f27935eb5f2fd1', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-26::jesus (generated)
DROP TABLE hibernate_sequences;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-26', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 26, '7:6d64c32c1ab5d78a31c07027bd6ccd75', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-27::jesus (generated)
DROP TABLE language_exchange;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-27', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 27, '7:e555c0fcf018942a10264c58ea56bc8b', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-28::jesus (generated)
DROP TABLE language_exchange_target_langs;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-28', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 28, '7:540119d5cd67c392964fc272f4a0d5ac', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-29::jesus (generated)
DROP TABLE notification;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-29', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 29, '7:9098397773d01fd892797b3b1751098f', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-30::jesus (generated)
DROP TABLE notification_receiver;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-30', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 30, '7:b3c27dbb9139e6219a4441dad63a4a32', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-31::jesus (generated)
DROP TABLE pay_data;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-31', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 31, '7:0d887de7c3c311a1d89318c12c8efbb7', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-32::jesus (generated)
DROP TABLE subscription_data;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-32', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 32, '7:a35e74b85525b3c371cb6ff6004a5d06', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-33::jesus (generated)
DROP TABLE user_account;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-33', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 33, '7:0310f051fb399079ec1c8419ba9d8d00', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-34::jesus (generated)
DROP TABLE user_account_roles;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-34', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 34, '7:82ee5e1a1ac8213ea0083c5fcbee3876', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-35::jesus (generated)
DROP TABLE user_discount;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-35', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 35, '7:1ac643c108833f766bcad749e2da3459', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-36::jesus (generated)
DROP TABLE user_langs_to_learn;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-36', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 36, '7:fa993553145fc65fcd0335e4bf3501de', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-37::jesus (generated)
DROP TABLE user_speak_langs;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-37', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 37, '7:68d48a3009a268e9117d0b478b49901e', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-38::jesus (generated)
DROP TABLE users;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-38', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 38, '7:a89c630e21595d535dd3a61387701049', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml::1556920546800-39::jesus (generated)
DROP TABLE users_langs_exchanges;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1556920546800-39', 'jesus (generated)', 'D:/Users/jesus/Projects/barlingo/workspace/barlingo-be-2/src/main/resources/liquibase-diff-changeLog.xml', NOW(), 39, '7:2837cd6b9f425c7d0b7c9370a214720c', 'dropTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Release Database Lock
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 0, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

