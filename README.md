# Java Course Prerequisite Validator

A small Java project that models university courses and verifies whether a student's taken courses satisfy prerequisite rules. The project also supports trimming a course plan into an eventual list of graded courses using different S/U policies.

## Key Ideas
- **Courses** are represented by course codes (case-sensitive).
- **Prerequisites** are modeled as composable rules via a shared interface:
  - `CourseReq`: a course that may depend on another prerequisite
  - `OneOf`: at least one prerequisite must be satisfied (OR)
  - `AllOf`: all prerequisites must be satisfied (AND)
- **CoursePlan** can validate and filter to keep only satisfiable courses, and can apply **S/U trimming policies**.

## Features
- ✅ Course identity + equality by course code (`Course`)
- ✅ Prerequisite checking via polymorphism (`Prereq`)
- ✅ Nested prerequisite trees using `AllOf` / `OneOf`
- ✅ Lazy evaluation pipelines with `InfList`

## Example Usage (JShell)
```java
CourseReq cs1010 = new CourseReq("cs1010");
CourseReq cs2030 = new CourseReq("cs2030", cs1010);
CourseReq cs2040 = new CourseReq("cs2040", cs1010);

Prereq oneOf2030 = new OneOf(InfList.of(cs2030, new CourseReq("cs2030s", cs1010)));

oneOf2030.satisfiedBy(InfList.of(cs1010, cs2030)); // true

