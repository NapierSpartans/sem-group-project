# USE CASE 2: Produce a Report on the countries inside a given continent, ordered by population (largest to smallest).

## CHARACTERISTIC INFORMATION

### Goal in Context
As a Staff Member, I want to view all the countries in a continent organised by largest population to smallest.

### Scope
Organisation..

### Level
Primary task.

### Preconditions
We know the country and continent.  Database contains current country population data.

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
3. Staff Member gets current population information of all countries inside a continent, ordered by size (biggest to smallest).
4. Staff Member provides report to Manager.

## EXTENSIONS
Country does not exist
-	Staff Member informs Manager that no role exists.