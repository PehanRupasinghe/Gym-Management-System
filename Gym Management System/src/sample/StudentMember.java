package sample;

public class StudentMember extends DefaultMember {
    private String schoolName;
    private String schoolDiscount;
    private String location;

    public StudentMember(){}

    public StudentMember(String schoolName, String schoolDiscount, String location ){
        super();
        this.schoolName = schoolName;
        this.schoolDiscount = schoolDiscount;
        this.location = location;
    }

    public StudentMember(String membershipNumber, String name,String sex, String schoolName, String schoolDiscount, String location){
        this.membershipNumber = membershipNumber;
        this.name = name;
        this.sex = sex;
        this.schoolName = schoolName;
        this.schoolDiscount = schoolDiscount;
        this.location = location;
    }

    public String getSchoolDiscount() {
        return schoolDiscount;
    }

    public void setSchoolDiscount(String schoolDiscount) {
        this.schoolDiscount = schoolDiscount;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString(){
        return super.toString() + "," + getSchoolName()+ "," + getSchoolDiscount()+ "," + getLocation();
    }
}
