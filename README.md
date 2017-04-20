# Taxicab Numbers

## What is a taxicab number?
A positive integer which can be expressed as the sum of two positive cubes in at least two different ways.

```
n = a³ + b³ = c³ + d³
```

The concept was first mentioned in 1657 by Bernard Frénicle de Bessy, and was made famous and the name is derived from a conversation involving mathematicians G. H. Hardy and Srinivasa Ramanujan.

You may check it out first 3883 taxicab numbers at [taxicab-numbers.txt](taxicab-numbers.txt)

## What is Hardy-Ramanujan number?

1729 is the Hardy–Ramanujan number, named after a famous anecdote of the British mathematician G. H. Hardy regarding a visit to the hospital in about 1919 to see the Indian mathematician Srinivasa Ramanujan. In Hardy's words:

> I remember once going to see him when he was ill at Putney. I had ridden in taxi cab number 1729 and remarked that the number seemed to me rather a dull one, and that I hoped it was not an unfavorable omen. "No," he replied, "it is a very interesting number; it is the smallest number expressible as the sum of two cubes in two different ways."

The two different ways are:

```
1729 = 1³ + 12³ = 9³ + 10³
```

## Implementations

### Loop, calculate and compare based implementations

#### [TaxicabNumbers1](TaxicabNumbers1.java)

Four nested loops, brute-force implementation by looping though all combinations to find where a³ + b³ = c³ + d³

```
for "a" number
  loop though all numbers between 1 and maximum number
  calculate a³

for "b" number
  loop though all numbers between a number and maximum - a³ number
  calculate b³

for "c" number
  loop though all numbers between a + 1 number and a³ + b³ number
  calculate c³

for "d" number
  loop though all numbers between c number and a³ + b³ - c³ number
  calculate d³

if a³ + b³ equals to d³ + c³
  print
```

#### [TaxicabNumbers2](TaxicabNumbers2.java)

This is same as [TaxicabNumbers1](#taxicabnumbers1) implementation, but calculates d³ using Math.cbrt method, instead of looping though all posibble numbers.

```
for "a" number
  loop though all numbers between 1 and maximum number
  calculate a³

for "b" number
  loop though all numbers between a number and maximum - a³ number
  calculate b³

for "c" number
  loop though all numbers between a + 1 number and a³ + b³ number
  calculate c³

calculate d³ = a³ + b³ - c³ 
calculate d using Math.cbrt method
if d does not equal to a, b and greater than or equals to c
  print
```

#### [TaxicabNumbers3](TaxicabNumbers3.java)

This is same as [TaxicabNumbers2](#taxicabnumbers2) implementation, but calculates d³ using Math.pow method.

```
for "a" number
  loop though all numbers between 1 and maximum number
  calculate a³

for "b" number
  loop though all numbers between a number and maximum - a³ number
  calculate b³

for "c" number
  loop though all numbers between a + 1 number and a³ + b³ number
  calculate c³

calculate d³ = a³ + b³ - c³ 
calculate d using Math.pow method
if d does not equal to a, b and greater than or equals to c
  print
```

### Data structure based implementations

#### [TaxicabNumbers4](TaxicabNumbers4.java)
This implementation stores every combination of the sum of a³ + b³ (key) and [ a, b ] pairs (value) in a hash table, and checks it the sum (key) already in the table.

```
for "a" number
  loop though all numbers between 1 and maximum number
  calculate a³

for "b" number
  loop though all numbers between a number and maximum - a³ number
  calculate b³

check if table has sum of a³ and b³
  if yes and pair is not marked
    print
    mark the pair in the table
  if no
    put sum and pair into table
```

#### [TaxicabNumbers5](TaxicabNumbers5.java)
This is same as [TaxicabNumbers4](#taxicabnumbers4) implementation, but uses HashMap class.

```
for "a" number
  loop though all numbers between 1 and maximum number
  calculate a³

for "b" number
  loop though all numbers between a number and maximum - a³ number
  calculate b³

check if map has sum of a³ and b³
  if yes and pair is not marked
    print
    mark the pair in the map
  if no
    put sum and pair into map
```
## Performance

### 4 Loop vs 3 Loops
As expected, when we replace the fourth loop with the calculation d³ = a³ + b³ - c³, code compares values %40 to %90 less.
![Loop executions](chart-2.png)
**X axis :** Maximum taxicab number to to calculate

**Y axis :** The number of times that the loop executes.

**Red line :** Four nested loops, brute-force implementation [TaxicabNumbers1](#taxicabnumbers1).

**Green line :** When we replace the fourth loop with the calculation d³ = a³ + b³ - c³

### Math.cbrt vs Math.pow
Although code executes 40% to 90% less, when we replace the fourth loop with the calculation d³ = a³ + b³ - c³, Math.cbrt and Math.pow methods are slower than looping though all combinations. Suprisingly Four nested loops, brute-force implementation [TaxicabNumbers1](#taxicabnumbers1) is faster than them.

It seems like Math.cbrt(x) method runs 6-9 nano seconds slower than Math.round(Math.pow(x, 1.0 / 3.0)). So when we run the code to the number 1,092,728, Math.cbrt implementaion [TaxicabNumbers2](#taxicabnumbers2) is 6,897,655
 nano seconds slower and Math.pow implementation  [TaxicabNumbers3](#taxicabnumbers3).
![Loop execution times in nanoseconds](chart-1.png)
**X axis :** Maximum taxicab number to to calculate

**Y axis :** Execution time in nano seconds (1,000,000,000 nano seconds is 1 second)

**Red line :** [TaxicabNumbers2](#taxicabnumbers2) implementation which calculates d³ using Math.cbrt method.

**Blue line :** [TaxicabNumbers3](#taxicabnumbers3) implementation which calculates d³ using Math.pow method.

**Green line :** Four nested loops, brute-force implementation [TaxicabNumbers1](#taxicabnumbers1).

### HashTable vs HashMap
Data sutructure based implementations are way more efficient than [Loop, calculate and compare based implementations](#loop-calculate-and-compare-based-implementations)

However Hastable implementation [TaxicabNumbers4](#taxicabnumbers4) executes 474 to 204,179 nano seconds slower than HashMap impementation [TaxicabNumbers5](#taxicabnumbers5)
![Hashtable and HashMap execution times in nanoseconds](chart-3.png)
**X axis :** Maximum taxicab number to to calculate

**Y axis :** Execution time in nano seconds (1,000,000,000 nano seconds is 1 second)

**Red line :** [TaxicabNumbers4](#taxicabnumbers4) implementation which uses Hashtable class

**Green line :** [TaxicabNumbers5](#taxicabnumbers5) implementation which uses HashMap class

## Fun

### Arithmetic with the digits of Hardy-Ramanujan number

Pozitif integer results :

```
1 + 7 + 2 + 9 = 19
1 + 7 + 2 - 9 = 1
1 + 7 + 2 * 9 = 26
1 + 7 - 2 + 9 = 15
1 + 7 - 2 - 9 = -3
1 + 7 - 2 * 9 = -10
1 + 7 * 2 + 9 = 24
1 + 7 * 2 - 9 = 6
1 + 7 * 2 * 9 = 127
1 - 7 + 2 + 9 = 5
1 - 7 + 2 - 9 = -13
1 - 7 + 2 * 9 = 12
1 - 7 - 2 + 9 = 1
1 - 7 - 2 - 9 = -17
1 - 7 - 2 * 9 = -24
1 - 7 * 2 + 9 = -4
1 - 7 * 2 - 9 = -22
1 - 7 * 2 * 9 = -125
1 * 7 + 2 + 9 = 18
1 * 7 + 2 - 9 = 0
1 * 7 + 2 * 9 = 25
1 * 7 - 2 + 9 = 14
1 * 7 - 2 - 9 = -4
1 * 7 - 2 * 9 = -11
1 * 7 * 2 + 9 = 23
1 * 7 * 2 - 9 = 5
1 * 7 * 2 * 9 = 126
```
