# Vault-engine

Multithreaded prime factorization engine built with Java 27 Virtual Threads and Maven.

## Overview

`vault-engine` decomposes large 64-bit integer values (`long`) into their prime factors concurrently using Java Virtual Threads (`Executors.newVirtualThreadPerTaskExecutor()`).

### Key Components

- **`me.eyxz.PrimeCalculator`**: Implements prime factorization via trial division, extracting factors of `2` first and iterating odd divisors up to `divisor * divisor <= current`.
- **`me.eyxz.Main`**: Runs a 100-task benchmark/stress test over large random `long` values, tracking completed tasks with `LongAdder` and measuring total and average execution times in milliseconds.

## Tech Stack

- **Language & Runtime**: Java 27 (BellSoft Liberica JDK)
- **Build Tool**: Maven
- **IDE**: IntelliJ IDEA
- **Concurrency**: Java Virtual Threads (`newVirtualThreadPerTaskExecutor`)

## Project Structure

```text
src/main/java/me/eyxz/
├── Main.java
├── PrimeCalculator.java
└── VaultEngineApplication.java
