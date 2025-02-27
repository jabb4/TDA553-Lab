# UPPGIFT 2

Analysera de beroenden som finns med avseende på cohesion och coupling, och Dependency Inversion Principle.
- Vilka beroenden är nödvändiga? 
- Vilka klasser är beroende av varandra som inte borde vara det?
- Finns det starkare beroenden än nödvändigt?
- Kan ni identifiera några brott mot övriga designprinciper vi pratat om i kursen?

### Cohesion:

Vårat project har hög cohesion då vi har försökt dela upp våra delar i flera klasser för att göra projektet mer modulärt.
Detta gör t.ex. att vi lätt kan skapa nya bilar utan att skriva om så mycket kod.

### Coupling:

Vår kod i detta projekt har ganska hög coupling i specifika fall, detta då några av de olika klasserna och modulerna är nära sammanhängande. 
_CarController_ är ett bra exempel på det här, då den skapar olika objekt av _Saab95_, _Volvo240_ och _Scania_, och använder deras funktioner.
Detta leder till att ifall en funktion i _Car_, exempelvis _Gas()_, skulle byta namn till _Drive()_, skulle även funktioner inom CarModel manuellt behöva förändras till _Drive()_.
Även _CarStorage_, och till viss del _TruckCarTransport_, fungerar på detta sätt och har liknande problem.

I dessa fall känns det nödvändigt med använda tight coupling, då vi i _CarController_ behöver använda funktioner ifrån bilarnas klasser.

### Dependency Inversion Principe:

- Vi använder oss av abstract classes för vissa beroenden, exempelvis *Car* och *Truck* för en bättre abstraktion.
- Vi använder oss av interfacet *Movable*.

### Förbättringsmöjligheter:

Vi tycker att vi har en ganska bra balans när det kommer till cohesion, coupling och DIP. Några områden där vi kan förbättra skulle kunna vara:
- CarTransport och TiltingTruck skulle kunna gå att simplisifiera och streamlina då de delar lite funktionallitet med varandra. Detta skulle öka cohesion och samtidigt kunna hålla loose coupleing
- Klasserna CarTransport och CarStorage delar mycket funktionalitet, och skulle kunna kombineras för att förenkla klasshierarkin.
- Vi skulle kunna utgå ifrån Dependency Inversion Principle i vår implementation av CarStorage i Workshop och TruckCarTransport (CarTransport) för att nå en högre level av abstraktion inom programmet. Detta skulle kunna göras genom att skapa ett Interface för storage, och se till så att Workshop tar in en klass som implementar detta interface.

# UPPGIFT 3

Analysera era klasser med avseende på Separation of Concern (SoC) och Single Responsibility Principle (SRP).
- Vilka ansvarsområden har era klasser?
- Vilka anledningar har de att förändras?
- På vilka klasser skulle ni behöva tillämpa dekomposition för att bättre följa SoC och SRP?

### Separation of Concern:

Detta tycker vi att vi har implementerat relativt väl då vi delat upp våra delsystem i mindre delar för att kunna öka återanvändandet av kod. 

### Single Responsibility Principle:

Vi följer SRP i vårt projekt då varje funktion och klass endast har ett enda ansvar. 
_CarStorage_ hanterar lagring av bilar, och varje funktion inom _CarStorage_; _Load()_, _Unload()_, gör en specifik sak.

### Förbättringsmöjligheter:

- Vi kan exempelvis skapa en class IsNear som kan användas i framtiden för andra implementationer som berör checks för koordinater, ex. kollision. Just nu är det bara en if-sats för *load()*.
- Ta bort tiliting funktionalliteten från TruckCarTransport och använd den som finns i TiltingTruck

# UPPGIFT 4

## Justeringar i UML diagram:

- Flytta updateCarCords() : void, och getStorageSize() : int till CarStorage, och ta bort CarTransport. Justerar i samband med detta TruckCarTransport till att ha en CarStorage direkt, istället för att ha en CarTransport. Detta förenklar klasshierarkin och gör det tydligare precis vad funktionerna inom CarStorage (tidigare CarTransport) gör och hur de används.
- Skapat _Storage_ interface, och gjort så att CarStorage implementerar detta. Även gjort så att TruckCarTransport tar in en klass som implementerar _Storage_ interfacet istället för att hårdkoda _CarStorage_. Genom att göra detta ökar vi abstraktionen inom programmet, och gör det möjligt för framtida Trucks att använda andra implementationer av _Storage_.
- Skapat ny class IsNear. Detta för att öka chansen av code reuse för framtida implementationer enligt Separation of Concern.
- Ändra så att TruckCarTransport är en subclass av tilting truck istället för att ge tilting truck ansvar för all tilting funtionallitet (SRP) (FRÅGA: Är detta bra? Det för att man har tillgång till changeTiltAngel i TruckCarTransport även om man inte ska det typ (då man inte ska kunna sätta egen angel))