# USE CASE: 31 Produce a Report on the population of a city

## CHARACTERISTIC INFORMATION

### Goal in Context

As a Staff Member I want to view the population of a city.

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains current city data.

### Success End Condition

A report is available.

### Failed End Condition

No report is produced.

### Primary Actor

Staff Member

### Trigger

A request for city population is made.

## MAIN SUCCESS SCENARIO

1. A request for city population is made.
2. Staff Member extracts city population.

## EXTENSIONS

3. **City does not exist**:
    1. Staff Member is informed such City does not exist.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0