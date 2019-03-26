/* Populate tabla clientes */

/* Insert users */

-- LANGUAGES
insert into language (id, version, code, image, name) values (1, 0, 'ES', 'http://dummyimage.com/116x168.png/dddddd/000000', 'Spanish');
insert into language (id, version, code, image, name) values (2, 0, 'EN', 'http://dummyimage.com/108x153.bmp/dddddd/000000', 'English');
insert into language (id, version, code, image, name) values (3, 0, 'IT', 'http://dummyimage.com/106x105.png/5fa2dd/ffffff', 'Italian');
insert into language (id, version, code, image, name) values (4, 0, 'FR', 'http://dummyimage.com/111x154.png/ff4444/ffffff', 'French');
insert into language (id, version, code, image, name) values (5, 0, 'DE', 'http://dummyimage.com/195x109.jpg/5fa2dd/ffffff', 'Deutsch');

-- USERS
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location, mother_tongue_id) VALUES (1, 0,'Kelvin', 'Raraty', 'Spain', 'Madrid', 'kraraty0@deliciousdays.com', 'http://zdnet.com', 'http://si.edu', 'Suspendisse potenti.', '2019/02/04', 'Phasellus in felis. Donec semper sapien a libero.', 1);
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location) VALUES (2, 0,'Dorie', 'Tarquini', 'Spain', 'Valladolid', 'dtarquini1@bloglines.com', 'http://reference.com', 'http://zimbio.com', 'Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', '2019/02/26', 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy.');
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location) VALUES (3, 0,'Leslie', 'Yanshinov', 'Spain', 'Valencia', 'lyanshinov2@blog.com', 'http://timesonline.co.uk', 'https://forbes.com', 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique.', '2018/08/12', 'Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis.');
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location) VALUES (4, 0,'Hedwig', 'Vandenhoff', 'Spain', 'Telde', 'hvandenhoff3@umn.edu', 'https://engadget.com', 'https://tinyurl.com', 'Cras pellentesque volutpat dui.', '2018/10/25', 'Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.');
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location) VALUES (5, 0,'Donaugh', 'Colbrun', 'Spain', 'Pamplona/Iruña', 'dcolbrun4@phpbb.com', 'http://istockphoto.com', 'https://github.io', 'Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.', '2018/05/13', 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.');
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location) VALUES (6, 0,'Ivette', 'Tottie', 'Spain', 'Albacete', 'itottie5@hugedomains.com', 'http://cafepress.com', 'https://wordpress.org', 'Suspendisse accumsan tortor quis turpis. Sed ante.', '2018/07/08', 'Morbi a ipsum. Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus.');
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location) VALUES (7, 0,'Hilliard', 'Angrick', 'Spain', 'Toledo', 'hangrick6@blog.com', 'http://storify.com', 'http://cnn.com', 'Integer a nibh. In quis justo.', '2018/05/21', 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque.');
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location) VALUES (8, 0,'Cindra', 'Coventry', 'Spain', 'Sant Cugat Del Valles', 'ccoventry7@pen.io', 'https://deviantart.com', 'http://theguardian.com', 'Nulla mollis molestie lorem.', '2018/08/06', 'Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.');
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location) VALUES (9, 0,'Shae', 'Schole', 'Spain', 'Barcelona', 'sschole8@dion.ne.jp', 'http://domainmarket.com', 'https://phoca.cz', 'Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla.', '2018/08/01', 'Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis.');
INSERT INTO users (id, version, name, surname, country, city, email, personal_pic, profile_back_pic, about_me, birth_day, location) VALUES (10, 0, 'Eva', 'Winfred', 'Spain', 'Pamplona/Iruña', 'ewinfred9@apache.org', 'http://wikia.com', 'http://netscape.com', 'Nullam varius.', '2018/07/21', 'Proin risus. Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.');


-- PAY_DATA
insert into pay_data (id, version, pay_type, title) values (1, 0, 'maestro', 'quis turpis eget elit sodales scelerisque mauris sit amet eros suspendisse accumsan tortor quis turpis sed');
insert into pay_data (id, version, pay_type, title) values (2, 0, 'switch', 'luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec');
insert into pay_data (id, version, pay_type, title) values (3, 0, 'laser', 'lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id');
insert into pay_data (id, version, pay_type, title) values (4, 0, 'jcb', 'tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in');
insert into pay_data (id, version, pay_type, title) values (5, 0, 'instapayment', 'vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam');
insert into pay_data (id, version, pay_type, title) values (6, 0, 'maestro', 'in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna');
insert into pay_data (id, version, pay_type, title) values (7, 0, 'maestro', 'amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus');
insert into pay_data (id, version, pay_type, title) values (8, 0, 'diners-club-enroute', 'justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus');
insert into pay_data (id, version, pay_type, title) values (9, 0, 'visa', 'dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices');
insert into pay_data (id, version, pay_type, title) values (10, 0, 'laser', 'aenean fermentum donec ut mauris eget massa tempor convallis nulla neque');


-- ESTABLISHMENT
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile) values (1, 0, 'Thane', 'Patise', 'Dominican Republic', 'Juncalito Abajo', 'tpatise0@paginegialle.it', 'Ratke-Lind', 'tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis', '31042 Merchant Trail', 'http://dummyimage.com/184x184.jpg/ff4444/ffffff');
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile) values (2, 0, 'Warde', 'Gradly', 'Bangladesh', 'Chilmari', 'wgradly1@columbia.edu', 'Rice-Kuphal', 'lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl', '527 Jackson Lane', 'http://dummyimage.com/147x201.bmp/cc0000/ffffff');
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile) values (3, 0, 'Lauraine', 'Judkins', 'Pakistan', 'Shahpur', 'ljudkins2@php.net', 'Murray, Spencer and Zemlak', 'et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris', '6 Colorado Terrace', 'http://dummyimage.com/145x168.jpg/5fa2dd/ffffff');
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile) values (4, 0, 'Husein', 'Boram', 'Brazil', 'Camocim', 'hboram3@reverbnation.com', 'Nader, Rath and Hagenes', 'aliquam erat volutpat in congue etiam justo etiam pretium iaculis', '8631 Miller Pass', 'http://dummyimage.com/130x249.bmp/ff4444/ffffff');
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile) values (5, 0, 'Stacie', 'Heningam', 'Indonesia', 'Rejoagung', 'sheningam4@sina.com.cn', 'Balistreri, Rath and Kling', 'integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam', '78718 Milwaukee Court', 'http://dummyimage.com/188x203.png/5fa2dd/ffffff');
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile) values (6, 0, 'Tyrone', 'Dy', 'China', 'Shixi', 'tdy5@hp.com', 'Stanton, Heaney and Erdman', 'lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur', '85 Acker Terrace', 'http://dummyimage.com/141x145.png/5fa2dd/ffffff');
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile) values (7, 0, 'Jere', 'Cancellario', 'Indonesia', 'Bunisari', 'jcancellario6@bloglovin.com', 'Leffler, Powlowski and Stanton', 'blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in', '93 Lighthouse Bay Pass', 'http://dummyimage.com/241x226.jpg/dddddd/000000');
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile) values (8, 0, 'Angel', 'Huller', 'Indonesia', 'Panayagan', 'ahuller7@huffingtonpost.com', 'Greenfelder-Aufderhar', 'felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus', '3031 Everett Trail', 'http://dummyimage.com/130x162.png/ff4444/ffffff');
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile) values (9, 0, 'Filberto', 'Ivashin', 'Philippines', 'Abangay', 'fivashin8@1und1.de', 'Lowe, Wolf and Graham', 'nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem', '24001 Harbort Place', 'http://dummyimage.com/207x172.png/dddddd/000000');
insert into establishment (id, version, name, surname, country, city, email, establishment_name, description, address, image_profile) values (10, 0, 'Ernest', 'Condit', 'Indonesia', 'Sindang', 'econdit9@biblegateway.com', 'Predovic and Sons', 'sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor', '39 Briar Crest Trail', 'http://dummyimage.com/112x181.png/ff4444/ffffff');


-- SUBSCRIPTION_DATA
insert into subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) values (1, 0, '2018-09-25 09:05:03', 62.25, 2, 1, 1);
insert into subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) values (2, 0, '2018-04-28 22:33:31', 99.95, 2, 2, 2);
insert into subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) values (3, 0, '2019-01-12 08:45:22', 36.58, 1, 3, 3);
insert into subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) values (4, 0, '2018-06-30 01:20:01', 84.87, 3, 4, 4);
insert into subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) values (5, 0, '2018-06-27 09:11:26', 57.83, 2, 5, 5);
insert into subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) values (6, 0, '2018-11-09 23:38:08', 5.32, 1, 6, 6);
insert into subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) values (7, 0, '2018-05-12 14:02:07', 67.2, 2, 7, 7);
insert into subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) values (8, 0, '2018-07-16 05:29:01', 30.81, 3, 8, 8);
insert into subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) values (9, 0, '2018-10-08 15:27:34', 31.39, 2, 9, 9);
insert into subscription_data (id, version, init_moment, price, subscription_type, establishment_id, paydata_id) values (10, 0, '2018-09-02 11:37:09', 27.92, 1, 10, 10);


-- ESTABLISHMENT_WORKING_HOUR
insert into establishment_working_hours (establishment_id, working_hours) values (1, null);
insert into establishment_working_hours (establishment_id, working_hours) values (2, null);
insert into establishment_working_hours (establishment_id, working_hours) values (3, null);
insert into establishment_working_hours (establishment_id, working_hours) values (4, null);
insert into establishment_working_hours (establishment_id, working_hours) values (5, null);
insert into establishment_working_hours (establishment_id, working_hours) values (6, null);
insert into establishment_working_hours (establishment_id, working_hours) values (7, null);
insert into establishment_working_hours (establishment_id, working_hours) values (8, null);
insert into establishment_working_hours (establishment_id, working_hours) values (9, null);
insert into establishment_working_hours (establishment_id, working_hours) values (10, null);


/* Update sequence, insert last id value  */
UPDATE hibernate_sequences SET next_val=10 WHERE sequence_name="default";
