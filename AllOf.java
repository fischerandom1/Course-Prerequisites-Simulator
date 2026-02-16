class AllOf implements Prereq{
    private final InfList<Prereq> requiredCourses;

    AllOf(InfList<Prereq> requiredCourses) {
        this.requiredCourses = requiredCourses;
    }

    public boolean satisfiedBy(InfList<Course> courses) {
        return requiredCourses.allMatch(reqCourse -> reqCourse.satisfiedBy(courses));
    }
}
