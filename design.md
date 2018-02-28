Elements de conception du projet

Les différentes URLS rest :
  - GET "/hello" qui retourne la phrase " Hi, how are you today ? "
  - GET "/persons" afin d'afficher toutes les personnes 
  - GET "/persons/{id}" afin d'afficher une personne en fonction de l'ID
  - POST "/createPerson" qui permet de créer un personne
  - GET "/homes" afin d'afficher toutes les maisons 
  - POST "/homes" qui permet de créer une maison
  - GET "/home" qui permet d'afficher une maison
  - GET "/device" qui permet d'afficher une appareil
  - GET "/heater" qui permet d'afficher un chauffage
  
Les différents concepts correspondent à ceux cités dans les tp : 
  - ElectronicDevice
  - Heater
  - Home
  - IntelligentPeripheral
  - Person
  
Il y a deux servlet :
  - Myservlet pour afficher "Hello world SIR"
  - userInfo afin d'afficher le formulaire d'un utilisateur
