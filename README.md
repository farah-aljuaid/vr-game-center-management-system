# VR Game Center Management System

A console-based Java application for managing a VR game center: registering members, browsing games, and reserving and completing game sessions.

Team project developed for a university programming course.

## Features
- Register members with auto-generated IDs
- List available games
- Reserve a game for a member and complete the session (check-in)
- View members and their reservations
- Remove a member (blocked while they have an active reservation)
- Clone a member

## Object-oriented concepts demonstrated
- **Abstraction:** `Game` is an abstract base class for all games
- **Interfaces:** `Borrowable` defines `checkOut()` and `checkIn()`
- **Inheritance and polymorphism:** `CarRacingX` and `SpaceShooter` extend `Game` and override its behavior
- **Aggregation:** a `Member` holds a list of `Reservation` objects
- **Cloning:** `Member` implements `Cloneable`
- **Encapsulation:** private fields with getters
- **Custom exception:** `GameNotFoundException`

## Project structure
```
src/
├── interfaces/   Borrowable
├── exceptions/   GameNotFoundException
├── models/       Game, CarRacingX, SpaceShooter, Member, Reservation
└── system/       GameCenterManager, VRGameCenter (main)
```

## Run it
1. Open the project in NetBeans (or any Java IDE), or compile the `src` folder with `javac`.
2. Run `system.VRGameCenter`.
3. Use the menu in the console.

**Tools:** Java, OOP
