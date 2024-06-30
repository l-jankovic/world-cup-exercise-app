INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
              
              
              
              INSERT INTO `world_cup`.`reprezentacija` (`naziv`, `skraceni_naziv`) VALUES ('Zimbabve', 'ZIB');
INSERT INTO `world_cup`.`reprezentacija` (`naziv`, `skraceni_naziv`) VALUES ('Ukrajina', 'UKR');
INSERT INTO `world_cup`.`reprezentacija` (`naziv`, `skraceni_naziv`) VALUES ('Uganda', 'UGD');
INSERT INTO `world_cup`.`reprezentacija` (`naziv`, `skraceni_naziv`) VALUES ('Hrvatska', 'CRO');

INSERT INTO `world_cup`.`igrac` (`ime`, `prezime`, `ukupno_golova`, `reprezentacija_id`) VALUES ('Vlad', 'Kurcin', '0', '4');
INSERT INTO `world_cup`.`igrac` (`ime`, `prezime`, `ukupno_golova`, `reprezentacija_id`) VALUES ('Ante', 'Pavelic', '0', '4');
INSERT INTO `world_cup`.`igrac` (`ime`, `prezime`, `ukupno_golova`, `reprezentacija_id`) VALUES ('Hordar', 'Gord', '0', '3');
INSERT INTO `world_cup`.`igrac` (`ime`, `prezime`, `ukupno_golova`, `reprezentacija_id`) VALUES ('Vordas', 'Bljuvnas', '0', '3');
INSERT INTO `world_cup`.`igrac` (`ime`, `prezime`, `ukupno_golova`, `reprezentacija_id`) VALUES ('Mihael', 'Mihailovski', '0', '2');
INSERT INTO `world_cup`.`igrac` (`ime`, `prezime`, `ukupno_golova`, `reprezentacija_id`) VALUES ('Strocimir', 'Gavrinski', '0', '2');
INSERT INTO `world_cup`.`igrac` (`ime`, `prezime`, `ukupno_golova`, `reprezentacija_id`) VALUES ('Tropad', 'Ugdan', '0', '1');
INSERT INTO `world_cup`.`igrac` (`ime`, `prezime`, `ukupno_golova`, `reprezentacija_id`) VALUES ('Ulfas', 'Trat', '0', '1');



INSERT INTO `world_cup`.`utakmica` (`broj_golovaa`, `broj_golovab`, `reprezentacijaa_id`, `reprezentacijab_id`) VALUES ('10', '20', '4', '3');
INSERT INTO `world_cup`.`utakmica` (`broj_golovaa`, `broj_golovab`, `reprezentacijaa_id`, `reprezentacijab_id`) VALUES ('3', '2', '1', '3');