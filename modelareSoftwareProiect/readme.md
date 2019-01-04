##  Itinerar web application

#Swagger
- If you want to access swagger documentation:
		a)  .../v2/api-docs
		b) .../swagger-ui.html

#H2
	- If you want to access the H2 db :
	http://localhost:8080/h2-console/
		
		
		
Authentication examples you can use:
- DIGEST
- OAR 2


		
## Story Telling
Album
Travelbook
Travel album
life


E 
- automat pozele de adauga la o locatie pe harta in functie de coordonatele GPS
Modalitate de monetizare(ca si la facebook): anunturi publicitare

Un fel de …. Ne-a dat el idea ca sa mentinem un istoric...aaaa. Al pozelor… calatorii
Si sa facem ca la facebook aaaa un filmulet pe baza pozelor. 
sa folosim tehnologii video de a transpune pozele din 2D in 3D si sa facem un filmulet
Harta a lumii cu poze la locatii in fct de check-in
Profil cu scroll infinit (ca la facebook)
Oferte de calatorii intr-o sectiune speciala de la firmele de turism
Calatorii relatate de alte persoane (de la pana la, preturi, trenuri, masini, poze) in format tabular.(gen Organizare calatorie)
Creare automata album in functie de locatia in care au fost postate (folosind gps)
----------------------------------
Dpdv al clientului
Analiza pietei



O vorba transmisa de la un mare imperiu: “ Toate drumurile duc la Roma”
Te intrebi de ce?`
Pentru ca la vremea respectiva era creata o comunitate culturala foarte bine documentata si foarte mult apreciata. Ceea ce se intampla si in acest moment cu reteaua de socializare facebook, in care toate drumurile duc la facebook.
Ce intalnim noi aici foarte mult? => Oamenii de diverse categorii sociale care isi prezinta ideile prin imagini, locuri, momente frumoase din viata, trairi si vise.
Ce ar fii omenirea fara vise, fara idei, fara povesti?
O lume inchisa, depresiva si anxioasa, dar noi homo sapiens dorim sa comunicam, sa ne impartasim trairile si visele, sa ascultam povesti si sa ne imaginam o lume plina de aventuri. Aici vreau sa ajung si sa scot prin aplicatia care o dezvoltam, aventurile, locurile precum si experientele personale din locurile pe unde au trecuti fiecare individ din comunitatea nou creata.
Cu un click pe o locatie selectata, vreau sa pot vedea cati din prietenii mei au fost in zona, ce parare au avut si ce recomandari privind zona turistica, puncte de interes, bucatarie si conditii de cazare.
Este strict o aplicatie de calatorie prin care putem scoate in evidenta punctele forte ale zonei pe care dorim sa o vizitam.



Enuntul temei:
Tema aleasa este adresata iubitorilor de calatorii si acopera un spectru larg, 




--------------------------------------------------------------------------------------------------------------------------------
Module(facebook/instagram):
login/registrare
Sistem adaugare prieteni
Pagina de profil ( albume + date personale, cronologie)
postare poze
comentarii la poze
Likuri la poze
Vizualizare poze prieteni + publice (inifinite scroll)
-----------------------------
Module(aplicatia noastra):
Pagina de profil 
sa avem o harta cu zone, cand dam click pe o zona, sa putem vizualiza ce poze de ale mele/prieteni ar putea fii acolo)
Creare automata de album in fct de locatia gps (ex: Piatra Craiului etc)
Offers page/button- 
Client views an offer (like aventurescu.ro)
User can click on a button (start journey) and automatically a journey is started on his profile
Every picture is added on that journey as long it is opened.
Sectiune de construire al unui traseu ( jurnal cu afisare pe harta)
Adaugare poze
Adaugare informatii suplimentare. Un fel de mini blog post
Checkpoints (de unde pleaca, unde ajunge, poposiri)
Mijloace de transport folosite
Plati (sau cati bani a cheltuit pe traseu)
Orele de plecare etc
Ptr aplicatie mobile buton start traseu ptr contorizare ore, locatie, poze prin GPS
Scor sau thumbs up  (cate pers apreciaza traseul)
#Tehnologii:
Database: MySQL, JPA
Front-end: Angular
Back-end: Java Spring Boot REST


1 - Database entities + JOINS - amandoi
2 - Bogdan + Hibernate = LOVE
3 - 

Dpdv logare
Profil
Postari
Harta
Locatii
Calatorie



Database:
https://stackoverflow.com/questions/1009025/facebook-database-design

Profile -> Album (1:M)
Profile -> Profile (M:M) :  Profile -> FriendRelation(1:M)  <- Profile
Profile -> Photo (1:M)
Location -> Photo (1:M)
Photo -> Likes (1:M)
Photo -> Comment(1:M)


Profile
	ID
	Description (about me)
	Activities
	Picture
	Email
	Password
	birthDate
	timestamp(createdAt, updatedAt)
	address
FriendRelation
	ProfileID (user 1)
	ProfileID (user 2)
Album
	Id
	UserID
	Name
	Location
	Timestamps (createdAt, updatedAt)

Photo
id 
AlbumID
description
Link
Timestamps (createdAt, updatedAt)
LocationID
PhotoStatusID
PhotoStatus
Id
name
Location
City
Country
State
Street
Likes
PhotoID
UserID
Comment
Id
UserID
PhotoID
		