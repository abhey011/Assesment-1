Problem 1

Drone zone:

Four Drones are placed in Grid [x * y] at fixed points. Given a target X on the Grid,
write an algorithm to find a Drone to strike the target. Print the path taken by the
drone to find the Target.
Hint : Use a 2d Matrix for Grid, Dive the drones to zones for scanning the target. If
the drone reaches the target then stop the loop


Problem 2

Monster maker:

In the world of Monsters every monster can have different traits.
The traits include features such as color of eyes, feather color, magical abilities,
size of the Monster, strength, durability, weakness, aggression level etc.
Users should be able to create their own monsters by answering simple questions
on traits by reading from standard input in java. When two monsters are created
by the user, create a baby Monster by coping traits from their parents randomly.
Baby monsters must be unique from the other monsters.

Hint : Use reflection in java to access the traits of the Monster. Use a Scanner to
read the Input



Problem 3

Wayne enterprise is a shipping company that operates on international
waters. Customers place orders for transporting goods across the ocean from
Gotham City to Atlanta and vice versa.
Each Order specifies the cargo weight in tons from 1 to 10. Every Ship must carry a
minimum cargo of 50 tonnes. Each order will be canceled if the Cargo is waiting
for pickup more than a minute. Each order costs $1000 usd and canceled order
sets back by $250
Wayne enterprises has 5 Ships to meet the demand. Each Ship can pick cargo for
one way between Gotham to Atlanta and must pick the return cargo on the way
back. After 5 trips the ship must be sent to maintenance for 1 minute.
Run a simulation to find out the number of trips made to reach 1 one million
dollars

Create 7 Consumer threads to place orders to Wayne enterprises with a small wait
time. (Find the optimized Wait time)
Each order can pick have random cargo between 10 and 50 tonnes and a random
destination (either Gotham/Atlanta)

Create 5 Shipping threads to execute Orders from the customers
Ships can be starting from either Gotham/Atlanta. Ships can leave the port only
with a minimum 50 tonnes of cargo Max Cargo is 300 tonnes.
The application stops on reaching 1 million dollars. Print the total Orders delivered
and Canceled.

Bonus: Customers will leave if 3 of their orders are canceled continuously
