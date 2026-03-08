# Mediathek

I made this project because i want to learn Java OOP. The idea is a simple media library where you can browse, rate, play and search through Films, Games and Newsletters in a console menu.

---

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


## How to run

1. Clone the repo
2. Open in Eclipse or IntelliJ --> I used Eclipse
3. Run Mediathek.java

Requires Java 8 or higher.

---

## What i learned

- How abstract classes and interfaces work together
- How to pass arrays between methods and keep track of state
- How to handle user input safely with try-catch
- How instanceof and casting works in practice

## Things I noticed

- It's not that hard do get the highest Array position
- Explicit Cast with OOP Classes it ist simple when you did it once

