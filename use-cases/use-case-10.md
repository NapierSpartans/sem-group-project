# USE CASE: 10 Produce a Report on all Cities in a Country organised from largest population to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

As a Staff Member, I want to view all the cities in a country organised by largest population to smallest.

### Scope

Company.

### Level

Primary task.

### Preconditions

We know the Country.  Database contains current cities data.

### Success End Condition

A report is available.

### Failed End Condition

No report is produced.

### Primary Actor

Staff Member

### Trigger

A request for cities in a country ordered by population is made.

## MAIN SUCCESS SCENARIO

1. A request for cities in a country ordered by population is made.
2. Staff Member captures name of the country to get city data for.
3. Staff member extracts cities of the given country.

## EXTENSIONS

3. **Country does not exist**:
    1. Staff Member is informed such country does not exist.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0