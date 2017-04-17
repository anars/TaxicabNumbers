# Taxicab Numbers

## What is a taxicab number?
A positive integer which can be expressed as the sum of two positive cubes in at least two different ways.

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

#### TaxicabNumbers1.java

#### TaxicabNumbers2.java

#### TaxicabNumbers3.java

### Data structure based implementations

#### TaxicabNumbers4.java

#### TaxicabNumbers5.java

## Performance

### 4 Loop vs 3 Loops

![Loop executions](chart-2.png)

### Math.cbrt vs Math.pow

![Loop execution times in nanoseconds](chart-1.png)

### HashTable vs HashMap

![Hashtable and Hashmap execution times in nanoseconds](chart-3.png)
