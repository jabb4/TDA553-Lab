## Refaktoriseringsplan

- Skapa nytt interface Storage, och justera så att CarStorage implementerar detta.
    - CarStorage: Flytta updateCarCords och getStorageSize från CarTransport till CarStorage. Ta bort classen CarTransport.

- Utils: Skapa som ny klass. Skapa en metod i klassen som tar in 3 parametrar, två koordinater av två objekt och hur "känslig" funktionen är.
    - Ta bort carTransport klassen. Justera TruckCarTransport så att den tar in en klass som implementerar Storage. Använd isNear från Utils istället för långa if satser för att kolla om den kan load/unload.
    - Ändra TiltingTruck till en vanlig class med namnet Tilt. Ta bort move().
        - Ändra så att TruckCarTransport och Scania tar in en instans av Tilt. Skapa metoderna changeTiltAngel, isTilted, Move för Scania och changeTiltState, isTilted, Move för TruckCarTransport. Gör så att de använder sig av tilt för att uppnå denna funtionallitet.

- Döp om CarController till CarModel då CarControllers funktionalitet ska finnas där. Skapa ny CarController som istället kommer att hantera alla action listeners; alltså funktionen av knapparna. CarView kommer att hantera att måla upp världen och bilarna.
    - ActionListeners i CarView flyttas till en ny class: CarController
      - Det som nu finns i DrawPanel ska flyttas in i CarView.
        - ta bort DrawPanel