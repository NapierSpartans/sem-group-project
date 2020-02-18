# USE CASE: 28 Produce a Report on the population of a region 

## CHARACTERISTIC INFORMATION

### Goal in Context
As a **Staff Member** I want to view the population of a region.


### Scope

Company.

### Level

Primary task.

### Preconditions

We know the region.  Database contains the continent data.

### Success End Condition

A report is available.

### Failed End Condition

No report is produced.

### Primary Actor

Staff Member.

### Trigger

A request for region population is made.

## MAIN SUCCESS SCENARIO

1. Request region data.
2. Get data of population from region.
3. Provides report to Staff member.

## EXTENSIONS

3. **Region does not exist**:
    1. Informs Staff Member no region exists.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0