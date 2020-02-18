# USE CASE: 29 Produce a Report on the population of a country

## CHARACTERISTIC INFORMATION

### Goal in Context
As a **Staff Member** I want to view the population of a country.


### Scope

Company.

### Level

Primary task.

### Preconditions

We know the country.  Database contains the continent data.

### Success End Condition

A report is available.

### Failed End Condition

No report is produced.

### Primary Actor

Staff Member.

### Trigger

A request for country population is made.

## MAIN SUCCESS SCENARIO

1. Request country data.
2. Get data of population from country.
3. Provides report to Staff member.

## EXTENSIONS

3. **Country does not exist**:
    1. Informs Staff Member no country exists.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0