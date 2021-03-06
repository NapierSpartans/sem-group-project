# USE CASE: 12 produce a report on the top 'N' populated capital cities in a continent where 'N' is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Staff Member* I want *to produce a report on the top 'N' populated capital cities in a continent*

### Scope

Company.

### Level

Primary task.

### Preconditions

We know the role.  Database contains current world population data.

### Success End Condition

A report is available for a Staff Member to view top 'N' populated capital cities in a continent.

### Failed End Condition

No report is produced.

### Primary Actor

Staff Member.

### Trigger

A request for top 'N' populated capital cities in a continent is sent to staff member.

## MAIN SUCCESS SCENARIO

1. Request for top 'N' populated capital cities in a continent is sent to Staff Member
2. Staff Member extracts city population information for top 'N' populated capital cities in a continent.
3. Staff Member produces report.

## EXTENSIONS

1. **'N' is out of range**:
    - Staff Member informed that 'N' is out of range.
2. **Continent doesn't exist** :
    - Staff member informed Continent doesn't exist.
    
## SUB-VARIATIONS

None.

## SCHEDULE

**18/02/20**: Release 1.0