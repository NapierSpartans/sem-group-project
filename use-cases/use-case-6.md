# USE CASE 6: Produce a Report on the top populated countries in a region, where the user defines the amount of countries they want displayed.

## CHARACTERISTIC INFORMATION

### Goal in Context
As a Staff Member, I want to view the top N populated countries in a region where N is provided by the user.

### Scope
Organisation..

### Level
Primary task.

### Preconditions
We know the country, the region and the number provided by the user.  Database contains current country population data.

### Success End Condition
A report is available for Staff Member to provide to Manager.

### Failed End Condition
No report is produced.

### Primary Actor
Staff Member.

### Trigger
A request for country information is sent to Staff Member.

## MAIN SUCCESS SCENARIO
1. Manager request population information for a given number of countries.
2. Staff Member saves the number of countries to get population information for.
3. Staff Member uses number to get current population information of the highest populated countries in a region.
4. Staff Member provides report to Manager.

## EXTENSIONS
Country does not exist
-	Staff Member informs Manager that no role exists.