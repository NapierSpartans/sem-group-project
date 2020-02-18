# USE CASE: 24 Produce a Report on the population of people living in and out of cities in each region

## CHARACTERISTIC INFORMATION

### Goal in Context
As a Staff Member, I want to view the population of people, people living in cities, and people not living in cities in each region.


### Scope

Company.

### Level

Primary task.

### Preconditions

We know the region.  Database contains the country data.

### Success End Condition

A report is available.

### Failed End Condition

No report is produced.

### Primary Actor

Staff Member.

### Trigger

A request for population inside and outside cities is made.

## MAIN SUCCESS SCENARIO

1. Request population data.
2. Get data of population from inside city.
3. Get data of population from outside city.
4. Provides report to Staff member.

## EXTENSIONS

3. **City does not exist**:
    1. Informs Staff Member no city exists.

## SUB-VARIATIONS

None.

## SCHEDULE