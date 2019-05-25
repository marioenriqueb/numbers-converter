# numbers-converter project

This app can be used to convert numbers from binary, hex or decimal representation, to its binary, decimal, hexadecimal or roman representation. 

It has a security layer made using the spring security frame. Every user has a userName, a password and a set od roles or permissions. 
The permissions could be:
- HEXADECIMAL (allow to convert from any kind of number representation to hexadecimal one)
- DECIMAL (allow to convert from any kind of number representation to decimal one)
- ROMANO (allow to convert from any kind of number representation to roman one)
- BINARIO (allow to convert from any kind of number representation to binary one)
- MASTER (all of them)

The app uses the framework H2 to persist the users data in memory, and the JPA framework for the persistence layer.

During the application deploy a default user **master** with master permissions **MASTER**.


# Rest
We know a number can have the same representation digits in different systems, for example the number 10. The number 10 is the representation for 2 in the binary system, for 10 in the decimal system and for 16 in the hexadecimal system.

Because of that we created three resources: one for each kind of number representation for the input number: binary, decimal or hexadecimal. Each resource has four conversion methods: to-binary, to-decimal, to-hexadecimal and to-roman. 

For security reasons: the user must be allowed to covert a number to a representation. For example: if the user A wants to convert a number with x respresentation to hexadecimal, it must have HEXADECIMAL permission in its permissions. 

# end-points

**from**: Original number representation (`binario`, `decimal`, `hexa`)

**to**: destination number representation (`binario`, `decimal`, `hexa`, `romano`)
 
`api/<from>/to/<to>/{number}`

#Tests
Some java tests for numbers conversions and user services were created. 

There is also a file called **numbers-converter.json** inside the folder **test/resources**, that could be used to test the different API end-points from any Rest client app.