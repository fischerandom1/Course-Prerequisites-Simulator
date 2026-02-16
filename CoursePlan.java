class CoursePlan {
    private final InfList<CourseReq> courses;

    public CoursePlan(InfList<CourseReq> courseList) {
        InfList<Course> taken = courseList.map(c -> this.upcastToCourse(c));
        this.courses = courseList.filter(course -> course.satisfiedBy(taken));
    }

    private Course upcastToCourse(CourseReq courseReq) {
        return courseReq; // implicit upcast (CourseReq is-a Course)
    }

    public int numOfCourses() {
        return this.courses.reduce(0, (x, y) -> x + 1);
    }

    public CoursePlan drop(Course droppedCourse) {
        return new CoursePlan(this.courses.filter(course -> !course.equals(droppedCourse)));
    }

    @Override
    public String toString() {
        return this.courses.findFirst()
            .map(n -> this.courses.reduce("", (x, y) -> x + y))
            .orElse("no courses");
    }
}
