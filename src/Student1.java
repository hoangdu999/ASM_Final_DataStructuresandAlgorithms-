class Student1 {
    private int id;
    private String name;
    private String contactNumber;
    private double marks;
    private String rank;

    public Student1(int id, String name, String contactNumber, double marks) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.marks = marks;
        assignRank();
    }

    // Assign rank based on marks
    public void assignRank() {
        if (marks >= 9.0) rank = "Excellent";
        else if (marks >= 7.5) rank = "Very Good";
        else if (marks >= 6.5) rank = "Good";
        else if (marks >= 5.0) rank = "Medium";
        else rank = "Fail";
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public double getMarks() {
        return marks;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Rank: " + rank;
    }
}