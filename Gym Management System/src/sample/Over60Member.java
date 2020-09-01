package sample;

public class Over60Member extends DefaultMember  {
    private int age;
    private String lungDisease;
    private String personalInstuctor;


    public Over60Member(){}

    public Over60Member(int age, String lungDisease, String personalInstuctor){
        super();
        this.age = age;
        this.lungDisease = lungDisease;
        this.personalInstuctor = personalInstuctor;
    }

    public Over60Member(String membershipNumber, String name,String sex, int age, String lungDisease, String personalInstuctor){
        this.membershipNumber = membershipNumber;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.lungDisease = lungDisease;
        this.personalInstuctor = personalInstuctor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLungDisease() {
        return lungDisease;
    }

    public void setLungDisease(String lungDisease) {
        this.lungDisease = lungDisease;
    }

    public String getPersonalInstuctor() {
        return personalInstuctor;
    }

    public void setPersonalInstuctor(String personalInstuctor) {
        this.personalInstuctor = personalInstuctor;
    }

    @Override
    public String toString(){
        return super.toString() + "," + getAge()+"," + getLungDisease()+"," + getPersonalInstuctor();
    }
}
