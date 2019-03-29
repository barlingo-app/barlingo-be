/* Populate tabla clientes */

/* Update sequence, insert last id value  */                             
UPDATE hibernate_sequences SET next_val=82 WHERE sequence_name="default";

/* Insert language */
INSERT INTO language (id, version, code, image, name) VALUES (1, 0, 'ES', 'http://dummyimage.com/209x163.bmp/ff4444/ffffff', 'Aymara');
INSERT INTO language (id, version, code, image, name) VALUES (2, 0, 'EN', 'http://dummyimage.com/206x115.bmp/cc0000/ffffff', 'Fijian');
INSERT INTO language (id, version, code, image, name) VALUES (3, 0, 'CN', 'http://dummyimage.com/172x180.jpg/ff4444/ffffff', 'Greek');
INSERT INTO language (id, version, code, image, name) VALUES (4, 0, 'NG', 'http://dummyimage.com/110x203.png/dddddd/000000', 'Mongolian');
INSERT INTO language (id, version, code, image, name) VALUES (5, 0, 'KR', 'http://dummyimage.com/182x179.bmp/cc0000/ffffff', 'Ndebele');
INSERT INTO language (id, version, code, image, name) VALUES (6, 0, 'ID', 'http://dummyimage.com/193x223.png/cc0000/ffffff', 'Armenian');
INSERT INTO language (id, version, code, image, name) VALUES (7, 0, 'ID', 'http://dummyimage.com/110x241.png/dddddd/000000', 'Tsonga');
INSERT INTO language (id, version, code, image, name) VALUES (8, 0, 'ID', 'http://dummyimage.com/105x222.bmp/dddddd/000000', 'Tetum');
INSERT INTO language (id, version, code, image, name) VALUES (9, 0, 'CO', 'http://dummyimage.com/237x118.bmp/cc0000/ffffff', 'Armenian');
INSERT INTO language (id, version, code, image, name) VALUES (10, 0, 'UA', 'http://dummyimage.com/247x200.jpg/dddddd/000000', 'Mongolian');

/* Insert users */
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location, mother_tongue_id) VALUES (11, 0,'Kelvin', 'Raraty', 'Spain', 'Madrid', 'kraraty0@deliciousdays.com', 'http://zdnet.com', 'http://si.edu', 'Suspendisse potenti.', '2019/02/04', 'Phasellus in felis. Donec semper sapien a libero.', 1);
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location, mother_tongue_id) VALUES (12, 0,'Dorie', 'Tarquini', 'Spain', 'Valladolid', 'dtarquini1@bloglines.com', 'http://reference.com', 'http://zimbio.com', 'Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', '2019/02/26', 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy.', 1);
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location, mother_tongue_id) VALUES (13, 0,'Leslie', 'Yanshinov', 'Spain', 'Valencia', 'lyanshinov2@blog.com', 'http://timesonline.co.uk', 'https://forbes.com', 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique.', '2018/08/12', 'Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis.', 2);
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location, mother_tongue_id) VALUES (14, 0,'Hedwig', 'Vandenhoff', 'Spain', 'Telde', 'hvandenhoff3@umn.edu', 'https://engadget.com', 'https://tinyurl.com', 'Cras pellentesque volutpat dui.', '2018/10/25', 'Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.',2 );
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location, mother_tongue_id) VALUES (15, 0,'Donaugh', 'Colbrun', 'Spain', 'Pamplona/Iruña', 'dcolbrun4@phpbb.com', 'http://istockphoto.com', 'https://github.io', 'Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.', '2018/05/13', 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', 3);
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location, mother_tongue_id) VALUES (16, 0,'Ivette', 'Tottie', 'Spain', 'Albacete', 'itottie5@hugedomains.com', 'http://cafepress.com', 'https://wordpress.org', 'Suspendisse accumsan tortor quis turpis. Sed ante.', '2018/07/08', 'Morbi a ipsum. Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus.', 1);
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location, mother_tongue_id) VALUES (17, 0,'Hilliard', 'Angrick', 'Spain', 'Toledo', 'hangrick6@blog.com', 'http://storify.com', 'http://cnn.com', 'Integer a nibh. In quis justo.', '2018/05/21', 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque.', 2);
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location, mother_tongue_id) VALUES (18, 0,'Cindra', 'Coventry', 'Spain', 'Sant Cugat Del Valles', 'ccoventry7@pen.io', 'https://deviantart.com', 'http://theguardian.com', 'Nulla mollis molestie lorem.', '2018/08/06', 'Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', 3);
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location, mother_tongue_id) VALUES (19, 0,'Shae', 'Schole', 'Spain', 'Barcelona', 'sschole8@dion.ne.jp', 'http://domainmarket.com', 'https://phoca.cz', 'Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla.', '2018/08/01', 'Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis.', 4);
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location, mother_tongue_id) VALUES (20, 0, 'Eva', 'Winfred', 'Spain', 'Pamplona/Iruña', 'ewinfred9@apache.org', 'http://wikia.com', 'http://netscape.com', 'Nullam varius.', '2018/07/21', 'Proin risus. Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', 5);

-- USERS_LANGS_TO_LEARN
INSERT INTO users_langs_to_learn (user_id, langs_to_learn_id) VALUES (11, 5);
INSERT INTO users_langs_to_learn (user_id, langs_to_learn_id) VALUES (12, 5);
INSERT INTO users_langs_to_learn (user_id, langs_to_learn_id) VALUES (13, 4);
INSERT INTO users_langs_to_learn (user_id, langs_to_learn_id) VALUES (14, 4);
INSERT INTO users_langs_to_learn (user_id, langs_to_learn_id) VALUES (15, 1);
INSERT INTO users_langs_to_learn (user_id, langs_to_learn_id) VALUES (16, 2);
INSERT INTO users_langs_to_learn (user_id, langs_to_learn_id) VALUES (17, 3);
INSERT INTO users_langs_to_learn (user_id, langs_to_learn_id) VALUES (18, 4);
INSERT INTO users_langs_to_learn (user_id, langs_to_learn_id) VALUES (19, 1);
INSERT INTO users_langs_to_learn (user_id, langs_to_learn_id) VALUES (20, 2);

-- USERS_SPEAK_LANGS
INSERT INTO users_speak_langs (user_id, speak_langs_id) VALUES (11, 1);
INSERT INTO users_speak_langs (user_id, speak_langs_id) VALUES (12, 1);
INSERT INTO users_speak_langs (user_id, speak_langs_id) VALUES (13, 2);
INSERT INTO users_speak_langs (user_id, speak_langs_id) VALUES (14, 2);
INSERT INTO users_speak_langs (user_id, speak_langs_id) VALUES (15, 3);
INSERT INTO users_speak_langs (user_id, speak_langs_id) VALUES (16, 1);
INSERT INTO users_speak_langs (user_id, speak_langs_id) VALUES (17, 2);
INSERT INTO users_speak_langs (user_id, speak_langs_id) VALUES (18, 3);
INSERT INTO users_speak_langs (user_id, speak_langs_id) VALUES (19, 4);
INSERT INTO users_speak_langs (user_id, speak_langs_id) VALUES (20, 5);

-- PAY_DATA
insert into pay_data (id, version, pay_type, title) values (41, 0, 'maestro', 'quis turpis eget elit sodales scelerisque mauris sit amet eros suspendisse accumsan tortor quis turpis sed');
insert into pay_data (id, version, pay_type, title) values (42, 0, 'switch', 'luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec');
insert into pay_data (id, version, pay_type, title) values (43, 0, 'laser', 'lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id');
insert into pay_data (id, version, pay_type, title) values (44, 0, 'jcb', 'tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in');
insert into pay_data (id, version, pay_type, title) values (45, 0, 'instapayment', 'vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam');
insert into pay_data (id, version, pay_type, title) values (46, 0, 'maestro', 'in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna');
insert into pay_data (id, version, pay_type, title) values (47, 0, 'maestro', 'amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus');
insert into pay_data (id, version, pay_type, title) values (48, 0, 'diners-club-enroute', 'justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus');
insert into pay_data (id, version, pay_type, title) values (49, 0, 'visa', 'dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices');
insert into pay_data (id, version, pay_type, title) values (50, 0, 'laser', 'aenean fermentum donec ut mauris eget massa tempor convallis nulla neque');

-- SUBSCRIPTION_DATA

insert into subscription_data (id, version, init_moment, price, subscription_type, paydata_id) values (51, 0, '2018-09-25 09:05:03', 62.25, 'MONTHLY', 41);
insert into subscription_data (id, version, init_moment, price, subscription_type, paydata_id) values (52, 0, '2018-04-28 22:33:31', 99.95, 'MONTHLY', 42);
insert into subscription_data (id, version, init_moment, price, subscription_type, paydata_id) values (53, 0, '2019-01-12 08:45:22', 36.58, 'MONTHLY', 43);
insert into subscription_data (id, version, init_moment, price, subscription_type, paydata_id) values (54, 0, '2018-06-30 01:20:01', 84.87, 'MONTHLY', 44);
insert into subscription_data (id, version, init_moment, price, subscription_type, paydata_id) values (55, 0, '2018-06-27 09:11:26', 57.83, 'MONTHLY', 45);
insert into subscription_data (id, version, init_moment, price, subscription_type, paydata_id) values (56, 0, '2018-11-09 23:38:08', 5.32, 'MONTHLY', 46);
insert into subscription_data (id, version, init_moment, price, subscription_type, paydata_id) values (57, 0, '2018-05-12 14:02:07', 67.2, 'MONTHLY', 47);
insert into subscription_data (id, version, init_moment, price, subscription_type, paydata_id) values (58, 0, '2018-07-16 05:29:01', 30.81, 'MONTHLY', 48);
insert into subscription_data (id, version, init_moment, price, subscription_type, paydata_id) values (59, 0, '2018-10-08 15:27:34', 31.39, 'MONTHLY', 49);
insert into subscription_data (id, version, init_moment, price, subscription_type, paydata_id) values (60, 0, '2018-09-02 11:37:09', 27.92, 'MONTHLY', 50);

-- ESTABLISHMENT
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile, working_hours, subscription_id) values (21, 0, 'Thane', 'Patise', 'Dominican Republic', 'Juncalito Abajo', 'tpatise0@paginegialle.it', 'Ratke-Lind', 'tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis', '31042 Merchant Trail', 'http://dummyimage.com/184x184.jpg/ff4444/ffffff','M - F: 10:00AM - 23:00PM, S - U: 08:00AM - 02:00AM',51);
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile, working_hours, subscription_id) values (22, 0, 'Warde', 'Gradly', 'Bangladesh', 'Chilmari', 'wgradly1@columbia.edu', 'Rice-Kuphal', 'lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl', '527 Jackson Lane', 'http://dummyimage.com/147x201.bmp/cc0000/ffffff','M - F: 10:00AM - 23:00PM, S - U: 08:00AM - 02:00AM',52);
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile, working_hours, subscription_id) values (23, 0, 'Lauraine', 'Judkins', 'Pakistan', 'Shahpur', 'ljudkins2@php.net', 'Murray, Spencer and Zemlak', 'et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris', '6 Colorado Terrace', 'http://dummyimage.com/145x168.jpg/5fa2dd/ffffff','M - F: 10:00AM - 23:00PM, S - U: 08:00AM - 02:00AM',53);
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile, working_hours, subscription_id) values (24, 0, 'Husein', 'Boram', 'Brazil', 'Camocim', 'hboram3@reverbnation.com', 'Nader, Rath and Hagenes', 'aliquam erat volutpat in congue etiam justo etiam pretium iaculis', '8631 Miller Pass', 'http://dummyimage.com/130x249.bmp/ff4444/ffffff','M - F: 10:00AM - 23:00PM, S - U: 08:00AM - 02:00AM',54);
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile, working_hours, subscription_id) values (25, 0, 'Stacie', 'Heningam', 'Indonesia', 'Rejoagung', 'sheningam4@sina.com.cn', 'Balistreri, Rath and Kling', 'integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam', '78718 Milwaukee Court', 'http://dummyimage.com/188x203.png/5fa2dd/ffffff','M - F: 10:00AM - 23:00PM, S - U: 08:00AM - 02:00AM',55);
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile, working_hours, subscription_id) values (26, 0, 'Tyrone', 'Dy', 'China', 'Shixi', 'tdy5@hp.com', 'Stanton, Heaney and Erdman', 'lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur', '85 Acker Terrace', 'http://dummyimage.com/141x145.png/5fa2dd/ffffff','M - F: 10:00AM - 23:00PM, S - U: 08:00AM - 02:00AM',56);
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile, working_hours, subscription_id) values (27, 0, 'Jere', 'Cancellario', 'Indonesia', 'Bunisari', 'jcancellario6@bloglovin.com', 'Leffler, Powlowski and Stanton', 'blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in', '93 Lighthouse Bay Pass', 'http://dummyimage.com/241x226.jpg/dddddd/000000','M - F: 10:00AM - 23:00PM, S - U: 08:00AM - 02:00AM',57);
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile, working_hours, subscription_id) values (28, 0, 'Angel', 'Huller', 'Indonesia', 'Panayagan', 'ahuller7@huffingtonpost.com', 'Greenfelder-Aufderhar', 'felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus', '3031 Everett Trail', 'http://dummyimage.com/130x162.png/ff4444/ffffff','M - F: 10:00AM - 23:00PM, S - U: 08:00AM - 02:00AM',58);
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile, working_hours, subscription_id) values (29, 0, 'Filberto', 'Ivashin', 'Philippines', 'Abangay', 'fivashin8@1und1.de', 'Lowe, Wolf and Graham', 'nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem', '24001 Harbort Place', 'http://dummyimage.com/207x172.png/dddddd/000000','M - F: 10:00AM - 23:00PM, S - U: 08:00AM - 02:00AM',59);
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile, working_hours, subscription_id) values (30, 0, 'Ernest', 'Condit', 'Indonesia', 'Sindang', 'econdit9@biblegateway.com', 'Predovic and Sons', 'sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor', '39 Briar Crest Trail', 'http://dummyimage.com/112x181.png/ff4444/ffffff','M - F: 10:00AM - 23:00PM, S - U: 08:00AM - 02:00AM',60);
/* Insert exchange states */
INSERT INTO exchange_state (id, version, name) VALUES(81, 0, 'OPEN');
INSERT INTO exchange_state (id, version, name) VALUES(82, 0, 'CLOSED');

/* Insert languageExchange */
INSERT INTO language_exchange (id, version, description, moment, title, creator_id, establishment_id, exchange_state_id) VALUES (61, 0, 'dolor in reprehenderit', '1989-09-24 17:57:51.000','dolore eu fugiat nulla pariatur. Excepteur ', 18, 23, 81);
INSERT INTO language_exchange (id, version, description, moment, title, creator_id, establishment_id, exchange_state_id) VALUES (62, 0, 'dolor sit ame', '1981-10-27 18:48:28.000', 'in voluptate velit esse cillum dolore eu fugiat nulla pariat', 15, 23, 81);
INSERT INTO language_exchange (id, version, description, moment, title, creator_id, establishment_id, exchange_state_id) VALUES (63, 0, 'exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis ', '2004-08-02 02:10:16.000', 'occaecat cupidatat non proident, sunt in culpa qui offic', 11, 25, 81);
INSERT INTO language_exchange (id, version, description, moment, title, creator_id, establishment_id, exchange_state_id) VALUES (64, 0, 'sed do eiusmod temp', '1992-08-30 13:36:54.000', 'incididunt ut labore et dolore magna aliqua. Ut enim ad minim ven', 17, 25, 81);
INSERT INTO language_exchange (id, version, description, moment, title, creator_id, establishment_id, exchange_state_id) VALUES (65, 0, 'Duis aute irure ', '1996-05-14 06:48:50.000', 'pariatur. Excepteur sint occaecat cu', 20, 27, 81);
INSERT INTO language_exchange (id, version, description, moment, title, creator_id, establishment_id, exchange_state_id) VALUES (66, 0, 'tempor incididunt ut la', '2018-05-31 06:20:12.000', 'veniam, quis nostrud exercitation ull', 16, 27, 81);
INSERT INTO language_exchange (id, version, description, moment, title, creator_id, establishment_id, exchange_state_id) VALUES (67, 0, 'quis nostrud exercitation ullamco laboris ', '2008-01-05 02:51:43.000', 'aute irure dolor in reprehenderit in vol', 18, 22, 81);
INSERT INTO language_exchange (id, version, description, moment, title, creator_id, establishment_id, exchange_state_id) VALUES (68, 0, 'ullamco laboris nisi ut aliquip ex ea commodo consequat', '2015-08-09 09:00:37.000', 'in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupida', 13, 26, 81);
INSERT INTO language_exchange (id, version, description, moment, title, creator_id, establishment_id, exchange_state_id) VALUES (69, 0, 'tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exerci','2012-08-10 13:12:28.000', 'ullamco laboris ', 17, 29, 81);
INSERT INTO language_exchange (id, version, description, moment, title, creator_id, establishment_id, exchange_state_id) VALUES (70, 0, 'officia deserunt mollit anim id est laborum.Lorem ipsum dolor sit amet, consectetur a', '1992-06-26 03:09:59.000', 'sit amet, consectetur adipiscing elit, sed do eius', 11, 29, 81);

/* language_exchange_target_langs  */
INSERT INTO language_exchange_target_langs(language_exchange_id, target_langs_id) VALUES (61,3);
INSERT INTO language_exchange_target_langs(language_exchange_id, target_langs_id) VALUES (62,3);
INSERT INTO language_exchange_target_langs(language_exchange_id, target_langs_id) VALUES (63,1);
INSERT INTO language_exchange_target_langs(language_exchange_id, target_langs_id) VALUES (64,2);
INSERT INTO language_exchange_target_langs(language_exchange_id, target_langs_id) VALUES (65,5);
INSERT INTO language_exchange_target_langs(language_exchange_id, target_langs_id) VALUES (66,1);
INSERT INTO language_exchange_target_langs(language_exchange_id, target_langs_id) VALUES (67,3);
INSERT INTO language_exchange_target_langs(language_exchange_id, target_langs_id) VALUES (68,2);
INSERT INTO language_exchange_target_langs(language_exchange_id, target_langs_id) VALUES (69,2);
INSERT INTO language_exchange_target_langs(language_exchange_id, target_langs_id) VALUES (70,1);

/* users_langs_exchanges*/

INSERT INTO users_langs_exchanges(participants_id,langs_exchanges_id) VALUES (18,61);
INSERT INTO users_langs_exchanges(participants_id,langs_exchanges_id) VALUES (15,62);
INSERT INTO users_langs_exchanges(participants_id,langs_exchanges_id) VALUES (11,63);
INSERT INTO users_langs_exchanges(participants_id,langs_exchanges_id) VALUES (17,64);
INSERT INTO users_langs_exchanges(participants_id,langs_exchanges_id) VALUES (20,65);
INSERT INTO users_langs_exchanges(participants_id,langs_exchanges_id) VALUES (16,66);
INSERT INTO users_langs_exchanges(participants_id,langs_exchanges_id) VALUES (18,67);
INSERT INTO users_langs_exchanges(participants_id,langs_exchanges_id) VALUES (13,68);
INSERT INTO users_langs_exchanges(participants_id,langs_exchanges_id) VALUES (17,69);
INSERT INTO users_langs_exchanges(participants_id,langs_exchanges_id) VALUES (11,70);

/* Insert userDiscount */
INSERT INTO user_discount (id, version, code, exchanged, is_visible, lang_exchange_id, user_id) VALUES (71, 0, 'e', 0, 0, 61, 15);
INSERT INTO user_discount (id, version, code, exchanged, is_visible, lang_exchange_id, user_id) VALUES (72, 0, 'aute ', 0, 0, 62, 17);
INSERT INTO user_discount (id, version, code, exchanged, is_visible, lang_exchange_id, user_id) VALUES (73, 0, 'c', 0, 0, 63, 18);
INSERT INTO user_discount (id, version, code, exchanged, is_visible, lang_exchange_id, user_id) VALUES (74, 0, 'es', 0, 0, 64, 11);
INSERT INTO user_discount (id, version, code, exchanged, is_visible, lang_exchange_id, user_id) VALUES (75, 0, 'ame', 0, 0, 65, 18);
INSERT INTO user_discount (id, version, code, exchanged, is_visible, lang_exchange_id, user_id) VALUES (76, 0, 'utal', 0, 0, 66, 19);
INSERT INTO user_discount (id, version, code, exchanged, is_visible, lang_exchange_id, user_id) VALUES (77, 0, 'inci', 0, 0, 67, 12);
INSERT INTO user_discount (id, version, code, exchanged, is_visible, lang_exchange_id, user_id) VALUES (78, 0, 'dolor', 0, 0, 68, 15);
INSERT INTO user_discount (id, version, code, exchanged, is_visible, lang_exchange_id, user_id) VALUES (79, 0, 'enim ', 0, 0, 69, 16);


