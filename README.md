# Palindrome Sequencing
This program will accept a string of integers and return the nearest palindrome. Included in the package are the JUnit tests.

## Problem
A palindrome is a sequence that reads the same backward as forward.

Given a string n representing an integer, return the closest integer (not including itself), which is a palindrome. If there is a tie, return the smaller one.

Example:

Input: n = "123"

Output: "121"

## Installation
1. Download/Clone this repository
2. Open the project in your preferred IDE (Eclipse, VS Code, etc.)
3. Run the [Palindrome.java](src/app/Palindrome.java) file to find the nearest palindrome
4. Run the [PalindromeTest.java](src/tests/PalindromeTest.java) file to test the implementation

## How it works
1. Given an input (string representing an integer), two separate numbers will be generated which are calculated based on +/- of 10^n
2. All three numbers will be converted to their respective palindromes
3. The difference is evaluated between the input and the three palindromes
4. Returns the palindrome that is closest to the input. If there is a tie, the smaller palindrome will be returned instead

## Assumptions
Machine has the following installed:
- Java Development Kit (Java SE 16)
- Integrated Development Environment (IDE)

## Accepted inputs
- Positive integers

## Test cases
- Input is null
```java
Input: null
Expected Output: "An input must be specified"
```

- Input is empty
```java
Input: ""
Expected Output: "An input must be specified"
```

- Input is whitespace
```java
Input: " "
Expected Output: "An input must be specified"
```

- Input includes characters
```java
Input: "abc"
Expected Output: "A valid number must be provided"
```

- Input is wrong format
```java
Input: "-123-?456"
Expected Output: "A valid number must be provided"
```

- Input is a negative number
```java
Input: "-12"
Expected Output: "Negative numbers cannot be a palindrome"
```

- Input is zero
```java
Input: "0"
Expected Output: "Cannot return a palindrome that is less than zero"
```

- Input is a single digit
```java
Input: "8"
Expected Output: "7"
```

- Input is a double digit
```java
Input: "77"
Expected Output: "66"
```

- Input has an even string length
```java
Input: "1001"
Expected Output: "999"
```

- Input has an odd string length
```java
Input: "10001"
Expected Output: "9999"
```

- Input difference is tied
```java
Input: "1056"
Expected Output: "1001"
```

## Author
| [![Jason Cheong](https://avatars.githubusercontent.com/jasonmcheong?s=100)<br /><sub>Jason Cheong<br /></sub>](https://github.com/jasonmcheong)<br /> |
| :---: |
