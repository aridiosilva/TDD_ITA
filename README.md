# TDD_ITA

This is the results of the practical test related to the Coursera/ITA Platform TDD Course, during the third week, where I must apply mock objects and Test Driven Development to solve and develop the Automatic Teller Machine application requeriments given in the final test of the third week. Below there are the UML Diagrams tha I have produced  during the design, test and coding, and deployment of all classes and interfaces of the software challenge:

# Automatic Automatic Teller Machine Software Development Project Using TDD technique and applying Mocks 

The emphasis of this third week of the TDD Course was about the Mocks and its usage. So, I should apply  Dependency Injection Pattern to replace the external dependencies related to the ATM hardware and the Remote Service that updates and accesses Databases in the cloud. The functional requirements and the functionalities of the first initial release of the application should contains the following operations: user login in the ATM Machine, withdraw cash, deposit cash, and account balance after. Should be used the TDD during the whole appliation development, and must be used the Unit Testing (through JUnit 5) instead of integration test - this is the reason to use mock objects to replace the external dependencies. Must be selected one of the several means variants of Dependency Injection Project Pattern to inject mock objects to replace the external dependencies. I used interfaces to reduce the coupling between the ATM Class and its Class Hardware and Database Remote Access Service, so I could have the mocks and the real external classes with same API to facilitate the use of the Test Doubles in the static binding environment of Java Programming Language choose to develop the app. 

## UML Class Diagram Teller Machine Application


![classdiagram](https://github.com/aridiosilva/TDD_ITA/blob/main/UML_ClassDiagram_Software_CaixaEletronico_AridioSilva_23_NOV-2020-Versao4.jpg)


## UML Sequence Diagram of Use Case - Automatica Teller Machine (ATM)


![umlsequencediagram](https://github.com/aridiosilva/TDD_ITA/blob/main/UML_UseCases_Software_CaixaEletronico_AridioSilva_22_NOV-2020-VERSAO2.jpg)

## UML Use Case Diagram of User Login - Automatica Teller Machine (ATM)

![umlsequencediagram](https://github.com/aridiosilva/TDD_ITA/blob/main/UMLDiagramSequence_LOGIN_CXeletronico_AridioSIlva_20NOV2020-VERSAO_3.jpg)

## UML Sequence Diagram of Withdraw Cash - Automatica Teller Machine (ATM)

![umlsequencediagram](https://github.com/aridiosilva/TDD_ITA/blob/main/UMLDiagramSequence_SACAR_CXeletronico_AridioSIlva_21NOV2020-VERSAO_3.jpg)

## UML Sequence Diagram of Deposit Cash Operantion - Automatica Teller Machine (ATM)

![umlsequencediagram](https://github.com/aridiosilva/TDD_ITA/blob/main/UMLDiagramSequence_DEPOSITAR_CXeletronico_AridioSIlva_22NOV2020-VERSAO_1.jpg)

## UML Sequence Diagram of Check Balance Operation - Automatica Teller Machine (ATM)

![umlsequencediagram](https://github.com/aridiosilva/TDD_ITA/blob/main/UMLDiagramSequence_SALDO_CXeletronico_AridioSIlva_22NOV2020-VERSAO_1.jpg)


