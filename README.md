# Java LRU Cache and HashMap Implementation

This repository contains Java implementations of an **LRU Cache** (Least Recently Used Cache) and a **HashMap**.

## Files
- **LRUCache.java**: Implementation of the LRU Cache using a combination of a HashMap and a doubly-linked list to achieve O(1) time complexity for `get` and `put` operations.
- **MyHashMap.java**: Implementation of a HashMap with basic operations (`put`, `get`, `remove`) using an array-based approach with collision handling.
- **Test.java**: Test file to demonstrate the functionality of both LRU Cache and HashMap implementations.

## Prerequisites
- Java Development Kit (JDK) installed (version 8 or higher recommended).
- A terminal or command-line interface.

## How to Run
1. Clone or download this repository to your local machine.
2. Open a terminal in the directory containing the repository files.
3. Compile the Java files:
   ```bash
   javac *.java
4. To test the LRU Cache:
    ```bash
    java Test 0
5. To test the HashMap:
    ```bash
    java Test 1
