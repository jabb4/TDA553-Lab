## Refaktoriseringsplan

- [x]  Skapa nytt interface Storage, och justera så att CarStorage implementerar detta.
    - [x] CarStorage: Flytta updateCarCords och getStorageSize från CarTransport till CarStorage. Ta bort classen CarTransport.

- [x] Utils: Skapa som ny klass. Skapa en metod i klassen som tar in 3 parametrar, två koordinater av två objekt och hur "känslig" funktionen är.
    - [x]  Ta bort carTransport klassen. Justera TruckCarTransport så att den tar in en klass som implementerar Storage. Använd isNear från Utils istället för långa if satser för att kolla om den kan load/unload.
    - Ändra TiltingTruck till en vanlig class med namnet Tilt. Ta bort move().
        - Ändra så att TruckCarTransport och Scania tar in en instans av Tilt. Skapa metoderna changeTiltAngel, isTilted, Move för Scania och changeTiltState, isTilted, Move för TruckCarTransport. Gör så att de använder sig av tilt för att uppnå denna funtionallitet.

- [x] Döp om CarController till CarModel då CarControllers funktionalitet ska finnas där. Skapa ny CarController som istället kommer att hantera alla action listeners; alltså funktionen av knapparna. CarView kommer att hantera att måla upp världen och bilarna.
    - [x] ActionListeners i CarView flyttas till en ny class: CarController
      - [x] Det som nu finns i CarView ska flyttas in i CarView.
        - [x] ta bort DrawPanel


# Composite Pattern
- [x]  Gör om så att workshops skapas via en ArrayList i CarModel likt hur bilar hanteras i nuläget. Detta enligt Composite Pattern för att förenkla att lägga till nya workshops. 
- Carview gör vi en lista med alla grafik bilar, en annan lista med alla grafik workshop

# Factory Pattern
- [x]  Implementera detta på skapandet av nya bilar. Skapa en car factory, sen en scania factory, volvo factory, saab factory
   - Se till så att detta fungerar vid användning av "Create Car" knapp som kommer att skapas senare

# Observer Pattern
- Observer Pattern skulle kunna implementeras för knapparna vi använder för att kontrollera bilarna. Detta genom att lägga in varje enskild bil som en observer, och på det sättet välja vilka bilar som lyssnar på vilka knappar. Detta är för överflödigt och vi väljer att inte implmentera det.

# State Pattern
- Många ställen där vi använder oss av states men utan att implementera state patterns så har vi typ bara två states som isTilted True/False så vi känner att det blir överflödigt att implementera state paterns eftersom det inte är relevant att lägga till states.
