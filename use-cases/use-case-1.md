# USE CASE 1: Produce a Report on Country information, ordered by population (largest to smallest).

## CHARACTERISTIC INFORMATION

### Goal in Context
As a Staff Member, I want to view all the countries in the world organised by largest population to smallest.

### Scope
Organisation..

### Level
Primary task.

### Preconditions
We know the Country. Database contains current Country population data.

### Success End Condition
A report is available for Staff Member to provide to Manager.

### Failed End Condition
No report is produced.

### Primary Actor
Staff Member.

### Trigger
A request for country information is sent to Staff Member.

## MAIN SUCCESS SCENARIO
1. Manager request population information for a given country.
2. Staff Member saves name of the country to get population information for.
3. Staff Member gets current population information of all countries ordered by size (biggest to smallest).
4. Staff Member provides report to Manager.

## EXTENSIONS
Country does not exist
-	Staff Member informs Manager that no role exists.
