CREATE TABLE house (
    eirCode varChar(30) NOT NULL  PRIMARY KEY,
    address varChar(30) NOT NULL
);

CREATE TABLE person(
    personId int(11)  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    personName varChar(30) NOT NULL,
    age int(11) NOT NULL,
    occupation varChar(30),
    eirCode varChar(30),
    foreign key (eirCode) references house(eirCode)
);