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

/* Insert establishment */
INSERT INTO establishment (id, version, city, country, email, name, surname, address, description, establishment_name, image_profile) VALUES (21, 0, 'Ferrol', 'Spain', 'mmongeot0@accuweather.com', 'Yóu', 'Mongeot', '418 Fieldstone Park', 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.', 'Howe and Sons', 'Schmitt-Reilly');
INSERT INTO establishment (id, version, city, country, email, name, surname, address, description, establishment_name, image_profile) VALUES (22, 0, 'Valladolid', 'Spain', 'vtirrey1@xinhuanet.com', 'Agnès', 'Tirrey', '4 International Crossing', 'Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.', 'Roberts Inc', 'Considine, Kling and Corkery');
INSERT INTO establishment (id, version, city, country, email, name, surname, address, description, establishment_name, image_profile) VALUES (23, 0, 'Madrid', 'Spain', 'lduffy2@businessinsider.com', 'Solène', 'Duffy', '740 Bartillon Street', 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', 'Durgan Inc', 'Mueller-Bernhard');/* Insert languageExchange */
INSERT INTO establishment (id, version, city, country, email, name, surname, address, description, establishment_name, image_profile) VALUES (24, 0, 'Barcelona', 'Spain', 'wjessup3@ezinearticles.com', 'Håkan', 'Jessup', '8457 Dapin Junction', 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', 'Moore-Beier', 'Breitenberg-Lynch');
INSERT INTO establishment (id, version, city, country, email, name, surname, address, description, establishment_name, image_profile) VALUES (25, 0, 'Lugo', 'Spain', 'mpinke4@ezinearticles.com', 'Maëlla', 'Pinke', '70 Mosinee Hill', 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.', 'Jerde, Parisian and Schneider', 'Macejkovic Inc');
INSERT INTO establishment (id, version, city, country, email, name, surname, address, description, establishment_name, image_profile) VALUES (26, 0, 'Zaragoza', 'Spain', 'icrippin5@icq.com', 'Publicité', 'Crippin', '827 Thierer Junction', 'Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', 'Kub LLC', 'Wolff-Pfannerstill');/* Insert userDiscounts */
INSERT INTO establishment (id, version, city, country, email, name, surname, address, description, establishment_name, image_profile) VALUES (27, 0, 'Murcia', 'Spain', 'mmacarthur6@yale.edu', 'Esbjörn', 'MacArthur', '378 4th Plaza', 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.', 'Ondricka Group', 'Altenwerth-Bogisich');
INSERT INTO establishment (id, version, city, country, email, name, surname, address, description, establishment_name, image_profile) VALUES (28, 0, 'Getafe', 'Spain', 'hcushworth7@ucsd.edu', 'Geneviève', 'Cushworth', '36040 Southridge Avenue', 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 'Wehner, Maggio and Mayer', 'Thompson, Gislason and Paucek');
INSERT INTO establishment (id, version, city, country, email, name, surname, address, description, establishment_name, image_profile) VALUES (29, 0, 'Ceuta', 'Spain', 'coleshunin8@theatlantic.com', 'Naëlle', 'Oleshunin', '55300 Bartelt Alley', 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', 'Crist Group', 'Flatley, Stark and Nader');
INSERT INTO establishment (id, version, city, country, email, name, surname, address, description, establishment_name, image_profile) VALUES (30, 0, 'Dos Hermanas', 'Spain', 'dreisenstein9@phpbb.com', 'Gösta', 'Reisenstein', '28 Talmadge Crossing', 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', 'Torphy Group', 'Lemke-Fay');

/* Insert payData */
INSERT INTO pay_data (id, version, pay_type, title) VALUES (41, 0, 'jcb', 'thinkins0');
INSERT INTO pay_data (id, version, pay_type, title) VALUES (42, 0, 'china-unionpay', 'iellse1');
INSERT INTO pay_data (id, version, pay_type, title) VALUES (43, 0, 'visa', 'ktorry2');
INSERT INTO pay_data (id, version, pay_type, title) VALUES (44, 0, 'mastercard', 'cmatthius3');
INSERT INTO pay_data (id, version, pay_type, title) VALUES (45, 0, 'jcb', 'truddle4');
INSERT INTO pay_data (id, version, pay_type, title) VALUES (46, 0, 'switch', 'wmcmenamin5');
INSERT INTO pay_data (id, version, pay_type, title) VALUES (47, 0, 'diners-club-carte-blanche', 'bklauer6');
INSERT INTO pay_data (id, version, pay_type, title) VALUES (48, 0, 'diners-club-carte-blanche', 'hmcclurg7');
INSERT INTO pay_data (id, version, pay_type, title) VALUES (49, 0, 'jcb', 'gcrockatt8');
INSERT INTO pay_data (id, version, pay_type, title) VALUES (50, 0, 'china-unionpay', 'wtwinn9');

/* Insert subscriptionData */
INSERT INTO subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) VALUES (51, 0, '2019-01-01 5:02', '6.99', 'MONTHLY', 21, 41);
INSERT INTO subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) VALUES (52, 0, '2019-01-01 15:03', '6.99', 'MONTHLY', 22, 42);
INSERT INTO subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) VALUES (53, 0, '2019-01-01 22:41', '18.99', 'QUARTERLY', 23, 43);
INSERT INTO subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) VALUES (54, 0, '2019-01-01 18:42', '18.99', 'QUARTERLY', 24, 44);
INSERT INTO subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) VALUES (55, 0, '2019-01-01 12:51', '62.99', 'ANNUAL', 25, 45);
INSERT INTO subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) VALUES (56, 0, '2019-01-01 21:57', '62.99', 'ANNUAL', 26, 46);
INSERT INTO subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) VALUES (57, 0, '2019-01-01 17:37', '6.99', 'MONTHLY', 27, 47);
INSERT INTO subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) VALUES (58, 0, '2019-01-01 3:57', '6.99', 'MONTHLY', 28, 48);
INSERT INTO subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) VALUES (59, 0, '2019-01-01 20:53', '18.99', 'QUARTERLY', 29, 49);
INSERT INTO subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) VALUES (60, 0, '2019-01-01 14:44', '18.99', 'QUARTERLY', 30, 50);

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
INSERT INTO user_discount (id, version, code, exchanged, is_visible, lang_exchange_id, user_id) VALUES (80, 0, 'au', 0, 0, 70, 11);
