# USE CASE: 14 Produce a Report on the top N populated cities in a region (where N is povided by the user)

## CHARACTERISTIC INFORMATION

### Goal in Context
As a Staff Member, I want to view the top N populated cities in a region where N is provided by the user.


### Scope

Company.

### Level

Primary task.

### Preconditions

We know the cities and region.  Database contains the country and continent data.

### Success End Condition

A report is available.

### Failed End Condition

No report is produced.

### Primary Actor

Staff Member.

### Trigger

A request for population of cities in region is made.

## MAIN SUCCESS SCENARIO

1. Request population data.
2. Get data of population of cities.
3. Filter to region
4. Provides report to Staff member.

## EXTENSIONS

3. **City does not exist**:
    1. Informs Staff Member no city exists.

## SUB-VARIATIONS

None.

## SCHEDULE