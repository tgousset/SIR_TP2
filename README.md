# Le projet 

  Le projet permet de comprendre le fonctionnement de JPA.
  L'objectif du sujet étant de contruire une application type réseau social permettant de comparer
la consommation électrique avec ses amis, ses voisins, ... On utilise un modèle métier simple avec
un concept de Person, Home, ElectronicDevices et Heater. 
  De plus le projet permet de comprendre les mécanismes des Servlet ainsi qu'une architecture Rest.
  

# L'utilisation du projet

  Dans une première partie on commence à utiliser JPA avec la base de données HSQL.
  Pour ce faire il faut lancer le script "run-hsqldb-server.sh" puis le script "show-hsqldb.sh". 
  Ensuite pour se connecter à la base de données il faut rentrer les informations suivantes : 
    login : sa ; aucun mot de passe ; URl de connexion : jdbc:hsqldb:hsql://localhost/
  
  Pour insérer des informations dans la base de données on utilise la classe JpaTest.java  qui va 
nous permmettre d'ajouter,de modifier ou de supprimer des objets pour Person, Home, ElectronicDevices 
et Hearter. 

 Ensuite on utilise la base de données Mysql. 
 Pour ce faire il suffit juste de modifier dans le fichier persistence.xml les informations concernant mysql
afin de se connecter à la base de données voulue. 
