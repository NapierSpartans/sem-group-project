# USE CASE: 30 Produce a Report on the population of a district 

## CHARACTERISTIC INFORMATION

### Goal in Context
As a **Staff Member** I want to view the population of a district.


### Scope

Company.

### Level

Primary task.

### Preconditions

We know the district.  Database contains the country data.

### Success End Condition

A report is available.

### Failed End Condition

No report is produced.

### Primary Actor

Staff Member.

### Trigger

A request for district population is made.

## MAIN SUCCESS SCENARIO

1. Request district data.
2. Get data of population from districts
3. Provides report to Staff member.

## EXTENSIONS

3. **District does not exist**:
    1. Informs Staff Member no district exists.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0