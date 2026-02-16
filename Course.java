class Course {
    private final String name;

    Course(String name) {
        this.name = name;
    } 

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Course course) {
            return this.name == course.name;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + this.name + "]";
    }
}

