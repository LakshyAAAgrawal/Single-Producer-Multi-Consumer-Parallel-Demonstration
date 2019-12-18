# Single Producer-Multi Consumer Parallel Demonstration
## Organisation
This is a single producer-multi consumer based Fibonacci number calculator in Java by using explicit multithreading.  The program starts by asking the user about the total number of consumer threads to generate. This interaction happens on a producer thread that will first create all the consumer threads, and then endlessly loop asking the user to enter the number whose Fibonacci number is to be calculated. When user enters a number whose Fibonacci value is to be calculated, the producer will push this number on a queue shared between the producer and the consumers. One of the consumer thread will take the number out from this queue and will calculate the Fibonacci result recursively. Once it has calculated the result, it would push the result along with its computation time another shared queue between the producer and the consumers. None of the calculations are repeated, by the use of the Flyweight design pattern.

## Possible improvements
The observer pattern is executed in a spinning loop currently, which can be changed by the use of wait and notify Java calls.

## Running
### Compilation
```bash
javac src/com/lakshya/*.java
```
### Execute
```bash
java com.lakshya.Main
```
## Design patters used
* Observer Design Pattern
* Flyweight Design Pattern
* Facade Design Pattern
