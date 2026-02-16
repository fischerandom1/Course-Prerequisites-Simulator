class OneOf implements Prereq{
    private final InfList<Prereq> requiredCourses;

    OneOf(InfList<Prereq> requiredCourses) {
        this.requiredCourses = requiredCourses;
    }

    public boolean satisfiedBy(InfList<Course> courses) {
        return requiredCourses.anyMatch(reqCourse -> reqCourse.satisfiedBy(courses));
    }
}
