# USE CASE 8: Produce a Report on the cities inside a given continent, ordered by population (largest to smallest).

## CHARACTERISTIC INFORMATION

### Goal in Context
As a Staff Member, I want to all view the cities in a continent organised by largest population to smallest.

### Scope
Organisation..

### Level
Primary task.

### Preconditions
We know the city and continent.  Database contains current country population data.

### Success End Condition
A report is available for Staff Member to provide to Manager.

### Failed End Condition
No report is produced.

### Primary Actor
Staff Member.

### Trigger
A request for cities information is sent to Staff Member.

## MAIN SUCCESS SCENARIO
1. Manager request population information for a given city.
2. Staff Member saves name of the city to get population information for.
3. Staff Member gets current population information of all cities inside a continent, ordered by size (biggest to smallest).
4. Staff Member provides report to Manager.

## EXTENSIONS
City does not exist
-	Staff Member informs Manager that no role exists.