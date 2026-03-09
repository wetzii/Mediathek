
## Mediathek – Digital Media Library
A console-based Java application that manages a collection of digital media and newsletters.

## How to Run

### Option 1 – Run from Source
1. Clone the repo
2. Open in Eclipse or IntelliJ
3. Run `Mediathek.java` as Java Application

### Option 2 – Run the JAR
1. Download the latest release from the [Releases]() tab
2. Open your terminal and navigate to the download folder
3. Run:
```
java -jar Mediathek.jar
```
> Requires Java 8 or higher


### What it can do
The app lets you browse and interact with a library of films and games. You can rate any media from 1 to 5, view average ratings and the number of ratings, and play media which tracks the total and maximum play minutes across your session. For films specifically there is a keyword search feature that searches through the film description. Newsletters can be read or searched by keyword as well.
Exception Handling
User input is validated through a central scanInt method which throws custom exceptions – InvalidInputException for out of range numbers and WrongTypeException for wrong data types like letters instead of numbers.
Media Types

Film – has a title, genre, duration and description
Game – has a title, genre, duration and supported platforms
Newsletter – has a title, content and an edition number

## Tech
Pure Java, no external libraries
Custom exception classes
Object oriented structure with inheritance

## Project Structure

```
DigitalMedia  (abstract class)
├-- Film      (extends DigitalMedia, implements SearchInterface)
|--Game      (extends DigitalMedia)

Newsletter    (implements SearchInterface)

SearchInterface  (interface)
Mediathek        (main class)
```

---

## What it can do

- Films and Games are stored in a shared DigitalMedia array
- Newsletters are a separate array
- You can rate any media from 1-5 stars, max 5 ratings per item
- When you play something the minutes get saved in an array (max 10 entries)
- You can search Films and Newsletters by keyword
- You can get the total played minutes or the longest single session



## What i learned

- How abstract classes and interfaces work together
- How to pass arrays between methods and keep track of state
- How to handle user input safely with try-catch
- How instanceof and casting works in practice

## Things I noticed

- It's not that hard do get the highest Array position
- Explicit Cast with OOP Classes it ist simple when you did it once


