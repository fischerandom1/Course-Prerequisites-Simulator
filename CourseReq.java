class CourseReq extends Course implements Prereq {
    private final Maybe<Prereq> prereq;

    CourseReq(String courseName) {
        super(courseName);
        this.prereq = Maybe.empty();
    }

    CourseReq(String courseName, Prereq prereq) {
        super(courseName);
        this.prereq = Maybe.of(prereq);
    }
   

    public boolean satisfiedBy(InfList<Course> courses) {
        return courses.anyMatch(course -> this.equals(course)) &&
            this.prereq.map(p -> p.satisfiedBy(courses)).orElse(true);
    }
}
