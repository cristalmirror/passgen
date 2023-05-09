# passgen
This software has been created only with educational and technical purposes, we are not responsible for any malicious uses or modifications that this software receives from users outside the project. Passgen is a software of pentesitng created to create passwords and test in a router or modem and check if is accepted.

Actualy this software are in development and need work and more tools for are complete.

# compilation

For compile this project, you need install maven Framework to Java lenguaje, and next in your CMD or Bash Terminal execute the next commands secuense.
1:
`mvn compile`
2:
`mvn packages`
With this commands the code, has been compiled and you cam execute the .jar result in target directory.

# execution

For Fibertel passwords:

Fibertel have a system to generate passwords based in a DNI numbers, because yor can create up to 50.000.000 of passwords. Well
the command have this parameters:
`java -jar passgen-0.1.jar -fibertel 50000000`

you can use a second parameter of smaller size if you have at aproximated age.

For Telecentro passwords:
`java -jar passgen-0.1.jar -telecentro 0`


