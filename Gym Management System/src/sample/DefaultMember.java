package sample;

public class DefaultMember {
    protected String membershipNumber;
    protected String name;
    protected String sex;
    private StartDate dob;

    public DefaultMember(String membershipNumber, String name, String sex) {
        this.membershipNumber = membershipNumber;
        this.name = name;
        this.sex = sex;

    }

    public DefaultMember() {

    }

    public void setDob(StartDate dob){
        this.dob = dob;
    }

    public StartDate getDoB(){
        return dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString(){
        return  getMembershipNumber()  + "," + getName() + "," + getSex() + "," + dob.getDate();
    }

}
