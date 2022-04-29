# terminal-usage
The goal of this algorithm is to read terminal usage data from a server at a hypothetical company and 
return the most common user at each terminal as well as their number of uses. Through this project, I 
learned how to implement Maps in Java and gain experience with their JDK classes. 

This project was assigned as a programming project in an Advanced Data Structures and Algorithms course.
The instructions from the assignment are included below.

# Introduction
This assignment was written by Prof. Betty O’Neil (slightly adapted).
It aims to help you:
• Learn about Maps (Symbol Tables), and get experience with their JDK classes
• Think about performance and memory use
• A brief revision of Java
• Introduction to Gradescope (and hopefully to using Java on Unix/Linux)

# Reading
Read S&W Section 3.1 on symbol tables (maps), Section 3.5 on applications including text indexes. Read
the JDK API docs on at least Map, HashMap, and TreeMap

# Project Description
A simple application using JDK collection classes

The main server at your company maintains 500 terminal lines, numbered 1 through 500 inclusive. Every 10
minutes the system appends to a log file the terminal numbers and user name of the person currently logged
on, one terminal number and username per line of text. (Not all terminals are in use at every moment.) A
fragment of the log file looks like this:

   9 ALTEREGO
  12 ALIMONY
 433 HOTTIPS
 433 USERMGR
  12 BLONDIE
 433 HOTTIPS
 354 ALIMONY
 
This log file shows HOTTIPS was on terminal 433 twice but USERMGR was on that terminal at an intervening
time. It also shows that ALIMONY was on terminal 12 at one time and terminal 354 later on. The log does
not display the time at which each line was written. Your job is to write a program in Java that meets the
following specifications.

The program first reads a log file into memory, storing the input data as it encounters it. Read from a
text file! Make sure you know about absolute and relative paths and don’t hard-code the file name. User
names are ASCII (plain text) strings with no embedded whitespace and a maximum length of 40 characters.

After all the data has been read your program should print data about terminal usage: a header line and then
one line of output for each terminal showing the terminal number, the most common user of that terminal
(in the event of a tie, choose one user), and a count of how many times that user was on that terminal. Here
is sample output:

Terminal      Most Common     User Count
1             OPERATOR        174983
2             HANNIBAL        432
3             <NONE>          0
4             SYSMGR          945
...           ...             ...

# Implementation
Create a class named Usage to hold a single username and its count together. It is quite simple. It
should have getters – getUser and getCount (these names specifically). The constructor should get
the name, then the number.
  
Create a class named LineUsage to hold all the data on one particular terminal. In this LineUsage
class, use a Map from the JDK (HashMap or TreeMap), mapping each username to its count, an
Integer. The map’s name should be lines. See the provided program FrequencyCounter.java for an
example of using a Map to hold a count for each of many strings. LineUsage should have methods
addObservation(String username) and Usage findMaxUsage(), which returns the Usage object for
the user with the highest count. Note that Usage is not used in the map, only in the delivery of results
once the Map is full of data.
  
The top-level class LineReport has an array of LineUsage objects to hold all the data on all the
terminal lines. See page 72 of S&W for discussion of an array of objects. LineReport.java should
have several methods (at least two object methods or static methods), including a main() to run the
program and a method loadData(String fname) which reads the data from the input file. Each
method should be commented (a comment above the method to describe what it does).
