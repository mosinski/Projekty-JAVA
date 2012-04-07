insert into pacjenci(imie, nazwisko, plec, pesel, miasto, ulica_dom)
values ('Michał','Wiśniewski','M','88042647360','Sopot','Prosta 13/5');
insert into pacjenci(imie, nazwisko, plec, pesel, miasto, ulica_dom)
values ('Martyna','Wojciechowska','K','71072658169','Warszawa','Modna 3/6');
insert into pacjenci(imie, nazwisko, plec, pesel, miasto, ulica_dom)
values ('Wisława','Udręczona','K','91102125729','Ustka','Krocząca 5');
insert into pacjenci(imie, nazwisko, plec, pesel, miasto, ulica_dom)
values ('Marcin','Kroczący','M','81112268176','Poznań','Widlasta 17a/6');
insert into pacjenci(imie, nazwisko, plec, pesel, miasto, ulica_dom)
values ('Krystian','Mrożek','M','78052234576','Zakopane','Górska 2');
insert into pacjenci(imie, nazwisko, plec, pesel, miasto, ulica_dom)
values ('Wacława','Kowalska','K','86033126575','Gdańsk','Kończąca 32');
insert into pacjenci(imie, nazwisko, plec, pesel, miasto, ulica_dom)
values ('Maciek','Marcinkiewicz','M','72112467341','Gdańsk','Krótka 16');
insert into pacjenci(imie, nazwisko, plec, pesel, miasto, ulica_dom)
values ('Katarzyna','Nowicka','K','89012254319','Ustka','Słowiańska 3a');
insert into pacjenci(imie, nazwisko, plec, pesel, miasto, ulica_dom)
values ('Gerard','Bazior','M','77071934395','Kwidzyn','Odrowskiego 9');




insert into gabinety_zabiegowe(numer_gabinetu, nazwa) values ('223', 'Gabinet zabiegów ortopedycznych');
insert into gabinety_zabiegowe(numer_gabinetu, nazwa) values ('56', 'Gabinet zabiegów ginekologicznych');
insert into gabinety_zabiegowe(numer_gabinetu, nazwa) values ('111', 'Gabinet zabiegów chirurgicznych');
insert into gabinety_zabiegowe(numer_gabinetu, nazwa) values ('65', 'Gabinet zabiegów plastycznych');
insert into gabinety_zabiegowe(numer_gabinetu, nazwa) values ('77', 'Gabinet zabiegów okulistycznych');




insert into lekarze(imie, nazwisko, specjalizacja)
values ('Jan', 'Kowalski', 'Chirurgia plastyczna');
insert into lekarze(imie, nazwisko, specjalizacja)
values ('Janina', 'Szczypior', 'Ginekologia');
insert into lekarze(imie, nazwisko, specjalizacja)
values ('Robert', 'Szczytny', 'Ortopeda');
insert into lekarze(imie, nazwisko, specjalizacja)
values ('Krzysztof', 'Zapominalski', 'Chirurgia plastyczna');
insert into lekarze(imie, nazwisko, specjalizacja)
values ('Zenon', 'Mocny', 'Ginekolog');
insert into lekarze(imie, nazwisko, specjalizacja)
values ('Marta', 'Zimna', 'Okulista');
insert into lekarze(imie, nazwisko, specjalizacja)
values ('Karol', 'Pewny', 'Chirurg');
insert into lekarze(imie, nazwisko, specjalizacja)
values ('Jan', 'Soroczyński', 'Chirurg');



insert into pielegniarki(imie, nazwisko) values ('Zofia', 'Kowalska');
insert into pielegniarki(imie, nazwisko) values ('Aleksandra', 'Szypulska');
insert into pielegniarki(imie, nazwisko) values ('Krystyna', 'Znana');
insert into pielegniarki(imie, nazwisko) values ('Barbara', 'Kaszubska');
insert into pielegniarki(imie, nazwisko) values ('Dagmara', 'Konieczna');
insert into pielegniarki(imie, nazwisko) values ('Emila', 'Miła');
insert into pielegniarki(imie, nazwisko) values ('Franciszka', 'Zachwalska');
insert into pielegniarki(imie, nazwisko) values ('Zuzanna', 'Pierwsza');


insert into operacje(pesel_operowanego, rodzaj_operacji,lekarz_operujący, pieleg_asystujące, data, nr_gabinetu) values ('91102125729','Usunięcie migdałków','8','1','10-03-2011','111');
insert into operacje(pesel_operowanego, rodzaj_operacji,lekarz_operujący, pieleg_asystujące, data, nr_gabinetu) values ('86033126575','Usunięcie wyrostka','7','3','10-06-2011','111');
insert into operacje(pesel_operowanego, rodzaj_operacji,lekarz_operujący, pieleg_asystujące, data, nr_gabinetu) values ('78052234576','Plastyczna korekcja nosa, umożliwienie swobodnego oddychania','1','2','24-03-2012','65');
insert into operacje(pesel_operowanego, rodzaj_operacji,lekarz_operujący, pieleg_asystujące, data, nr_gabinetu) values ('72112467341','Operacja kolana, naprawa rzepki','3','4','11-08-2011','223');
insert into operacje(pesel_operowanego, rodzaj_operacji,lekarz_operujący, pieleg_asystujące, data, nr_gabinetu) values ('71072658169','Operacja prawego jajnika, usunięcie raka','2','5','01-09-2011','56');
insert into operacje(pesel_operowanego, rodzaj_operacji,lekarz_operujący, pieleg_asystujące, data, nr_gabinetu) values ('81112268176','Operacja oka, usunięcie obcego ciała','6','6','06-06-2011','77');
insert into operacje(pesel_operowanego, rodzaj_operacji,lekarz_operujący, pieleg_asystujące, data, nr_gabinetu) values ('89012254319','Operacja stawu łokciowego','3','7','30-07-2011','223');
insert into operacje(pesel_operowanego, rodzaj_operacji,lekarz_operujący, pieleg_asystujące, data, nr_gabinetu) values ('77071934395','Operacja na sercu, naprawa prawej zastawki','7','1','27-10-2011','111');

