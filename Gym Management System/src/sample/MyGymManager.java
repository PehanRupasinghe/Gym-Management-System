package sample;

import java.io.*;
import java.util.Scanner;

public class MyGymManager implements GymManager{
    private int gymObject;
    File MemberListFile = new File("MemberList.txt");
    File DefaultMemberFile = new File("DefaultMember.txt");
    File studentMemberFile = new File("StudentMember.txt");
    File over60MemberFile = new File("Over60Member.txt");
    File TempDefaultMemberFile = new File("TempDefaultMember.txt");
    File TempstudentMemberFile = new File("TempStudentMember.txt");
    File Tempover60MemberFile = new File("TempOver60Member.txt");
    File TempMemberListFile = new File("TempMemberList.txt");


    protected int ListOfMembers;
    Boolean proceed = false;
    String membershipNumber;
    String name;
    String sex;
    String sSchoolDiscount;
    String oLungDisease;
    String oPersonalInstuctor;
    Integer oAge;


    public void mainProcess(){
        Boolean conti = true;
        Scanner myObject=new Scanner(System.in);
        int option;


        System.out.println("------SELECT 1: ADD MEMBER, SELECT 2: DELETE MEMBER, SELECT 3: PRINT THE MEMBER------");
        option=myObject.nextInt();


        if (option == 1){
            while (conti) {
                if (ListOfMembers <= 100) {
                    addMember();
                    Scanner input = new Scanner(System.in);
                    System.out.println("\n");
                    System.out.println("------Select 1: To Add Another Member, Select 2: To Exit------");
                    int chioce = input.nextInt();
                    if (chioce == 2) {
                        break;

                    }
                } else {
                    System.out.println("\n");
                    System.out.println("------Member list is 100 so can't store any more------");
                }
            }

        }
        else if (option == 2){

            while(conti){
                System.out.println("Enter your membership number");
                Scanner input = new Scanner(System.in);
                String removeMembershipNO = input.next();
                deleteMember(removeMembershipNO);
                System.out.println("\n");
                System.out.println("------Select 1: To Delete Another Member, Select 2: To Exit------");
                int chioce = input.nextInt();
                if (chioce == 2) {
                    break;

                }
            }
        }
        else if(option == 3){
            printMember();
        } else {
            System.out.println("You Enter An Wrong Option");
        }

    }

    public void addMember() {
        Scanner input = new Scanner(System.in);
        int option2;


        Boolean select = true;



        System.out.print("Enter your membership number: ");

        while(select){
            membershipNumber = input.next();

            try {
                BufferedReader buffRead = new BufferedReader(new FileReader(MemberListFile));
                String currentRecode;

                while ((currentRecode = buffRead .readLine()) != null) {
                    String membershipNo= currentRecode.trim().split(",")[0];


                    if (membershipNo.equals(membershipNumber)) {
                        System.out.println("ERROR,  The above membership number exit");
                        System.out.print("Please Enter New Membership Number: ");
                        select=true;

                        break;

                    } else {
                        select=false;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        try {
            FileWriter fw = new FileWriter(MemberListFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(membershipNumber);
            pw.flush();
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(MemberListFile));

            while ((br.readLine()) != null) {
                ListOfMembers = ListOfMembers + 1;
            }
            br.close();

        } catch (IOException e){
            e.printStackTrace();
        }



        System.out.println("\n");
        System.out.println("--------"+(100 -ListOfMembers) +" More Members Can Be Added--------");
        System.out.println("\n");

        System.out.println("------SELECT 1: To add a Default Member, SELECT 2: To add a Student Member, SELECT 3: To add a Member of age over 60------");
        option2 = input.nextInt();

        if (option2 == 1) {



            System.out.print("Enter your name: ");
            name = input.next();


            System.out.print("Enter your Gender(Male/False): ");
            while (proceed == false){
                sex = input.next();
                if(sex.equals("Male")||sex.equals("False")){

                    break;

                }else {
                    System.out.println("------ERROR, Invalid form is entered-------");
                    System.out.print("Please enter your gender in form of (Male/False): ");
                }

            }

            System.out.print("Enter your Day: ");
            int Day = input.nextInt();

            System.out.print("Enter your Month: ");
            int Month = input.nextInt();

            System.out.print("Enter your Year: ");
            int Year = input.nextInt();

            DefaultMember d = new DefaultMember();
            StartDate date = new StartDate(Day,Month,Year);
            d.setMembershipNumber(membershipNumber);
            d.setName(name);
            d.setSex(sex);
            d.setDob(date);




            try {
                FileWriter fw = new FileWriter(DefaultMemberFile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println(d);
                pw.flush();
                pw.close();

                System.out.println("\n");
                System.out.println("------Default Member Is Added------");

            } catch (IOException e) {
                e.printStackTrace();

            }

        }else if (option2 == 2) {
            System.out.print("Enter your name: ");
            name = input.next();

            System.out.print("Enter your Gender(Male/False): ");
            while (proceed == false){
                sex = input.next();
                if(sex.equals("Male")||sex.equals("False")){

                    break;

                }else {
                    System.out.println("------ERROR, Invalid form is entered-------");
                    System.out.print("Please enter your gender in form of (Male/False): ");
                }

            }
            System.out.print("Enter your school name: ");
            String sSchoolName = input.next();
            System.out.print("Enter Yes/No if student discount is available: ");
            while (proceed == false){
                sSchoolDiscount = input.next();
                if(sSchoolDiscount.equals("Yes")||sSchoolDiscount.equals("No")){

                    break;

                }else {
                    System.out.println("------ERROR, Invalid form is entered-------");
                    System.out.print("Please enter student discount is available in form of (Yes/No): ");
                }

            }
            System.out.print("Please enter School location: ");
            String sLocation = input.next();
            StudentMember s = new StudentMember();
            s.setMembershipNumber(membershipNumber);
            s.setName(name);
            s.setSex(sex);
            s.setSchoolName(sSchoolName);
            s.setSchoolDiscount(sSchoolDiscount);
            s.setLocation(sLocation);

            try {
                FileWriter fw = new FileWriter(studentMemberFile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println(s);
                pw.flush();
                pw.close();

                System.out.println("\n");
                System.out.println("-------Studert Member Is Added------");

            } catch (IOException e) {
                e.printStackTrace();

            }
        } else if (option2 == 3) {
            System.out.print("Enter your name: ");
            name = input.next();
            
            System.out.print("Enter your Gender(Male/False): ");
            while (proceed == false){
                sex = input.next();
                if(sex.equals("Male")||sex.equals("False")){

                    break;

                }else {
                    System.out.println("------ERROR, Invalid form is entered-------");
                    System.out.print("Please enter your gender in form of (Male/False): ");
                }

            }
            System.out.println("Enter your age: ");
            while(proceed) {
                oAge = Integer.valueOf(input.next());
                if(oAge >= 60){

                    break;

                }else {
                    System.out.println("Only an age over 60 can be entered ");
                    System.out.print("Please enter your age again: ");
                }
            }

            System.out.print("Enter Present/Absent if member has any lung disease is available: ");
            while(proceed) {
                oLungDisease = input.next();
                if(oLungDisease.equals("Present")||oLungDisease.equals("Absent")){

                    break;

                }else {
                    System.out.println("------ERROR, Invalid form is entered-------");
                    System.out.print("Please enter if you have any lung disease in form of (Present/Absent): ");
                }
            }

            System.out.print("Enter Yes/No if member need a personal Instructor: ");
            while(proceed) {
                oPersonalInstuctor = input.next();
                if(oPersonalInstuctor.equals("Yes")||oPersonalInstuctor.equals("No")){

                    break;

                }else {
                    System.out.println("------ERROR, Invalid form is entered-------");
                    System.out.print("Please enter if you need any personal instructor in form of (Yes/No): ");
                }
            }
            Over60Member o = new Over60Member();
            o.setMembershipNumber(membershipNumber);
            o.setName(name);
            o.setSex(sex);
            o.setAge(oAge);
            o.setLungDisease(oLungDisease);
            o.setPersonalInstuctor(oPersonalInstuctor);


            try {
                FileWriter fw = new FileWriter(over60MemberFile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println(o);
                pw.flush();
                pw.close();

                System.out.println("\n");
                System.out.println("-------Over 60 Member Is Added------");

            } catch (IOException e) {
                System.err.println("Over 60 Member Record Is Not Added" + e.getMessage());

            }
        } else {
            System.out.println("You Enter An Wrong Option");
        }

    }



    public void deleteMember(String removeMembershipNO) {
        Boolean option = false;
        
        try {
            BufferedReader buffRead = new BufferedReader(new FileReader(DefaultMemberFile));
            PrintWriter printWrite = new PrintWriter(new FileWriter(TempDefaultMemberFile));

            String objBuff;

            String recordToRemove = removeMembershipNO;

            while ((objBuff = buffRead.readLine()) != null) {
                String membershipNO = objBuff.trim().split(",")[0];
                if (membershipNO.equals(recordToRemove)) {
                    System.out.println("\n");
                    System.out.println(objBuff);
                    System.out.println("Type Of The Member Is Default");

                }
                if (!objBuff.trim().contains(recordToRemove)) {
                    printWrite.println(objBuff);
                    printWrite.flush();
                    option = true;

                }
            }

            printWrite.close();
            buffRead.close();
            DefaultMemberFile.delete();
            TempDefaultMemberFile.renameTo(DefaultMemberFile);



        } catch (IOException e){
            e.printStackTrace();
        }

        try {
            BufferedReader buffRead = new BufferedReader(new FileReader(studentMemberFile));
            PrintWriter printWrite = new PrintWriter(new FileWriter(TempstudentMemberFile));

            String objBuff;

            String recordToRemove = removeMembershipNO;

            while ((objBuff = buffRead.readLine()) != null) {
                String membershipNO = objBuff.trim().split(",")[0];
                if (membershipNO.equals(recordToRemove)) {
                    System.out.println("\n");
                    System.out.println(objBuff);
                    System.out.println("Type Of The Member Is Student");

                }
                if (!objBuff.trim().contains(recordToRemove)) {
                    printWrite.println(objBuff);
                    printWrite.flush();
                    option = true;

                }
            }

            printWrite.close();
            buffRead.close();
            studentMemberFile.delete();
            TempstudentMemberFile.renameTo(studentMemberFile);
        } catch (IOException e){
            e.printStackTrace();
        }

        try {
            BufferedReader buffRead = new BufferedReader(new FileReader(over60MemberFile));
            PrintWriter printWrite = new PrintWriter(new FileWriter(Tempover60MemberFile));

            String objBuff;

            String recordToRemove = removeMembershipNO;

            while ((objBuff = buffRead.readLine()) != null) {
                String membershipNO = objBuff.trim().split(",")[0];
                if (membershipNO.equals(recordToRemove)) {
                    System.out.println("\n");
                    System.out.println(objBuff);
                    System.out.println("Type Of The Member Is Over60 Member");

                }
                if (!objBuff.trim().contains(recordToRemove)) {
                    printWrite.println(objBuff);
                    printWrite.flush();
                    option = true;

                }option = true;
            }

            printWrite.close();
            buffRead.close();
            over60MemberFile.delete();
            Tempover60MemberFile.renameTo(over60MemberFile);

        } catch (IOException e){
            e.printStackTrace();
        }

        if(option) {

            try {
                BufferedReader buffRead = new BufferedReader(new FileReader(MemberListFile));
                PrintWriter printWrite = new PrintWriter(new FileWriter(TempMemberListFile));

                String objBuff;
                String recordToRemove = removeMembershipNO;

                while ((objBuff = buffRead.readLine()) != null) {
                    if (!objBuff.trim().contains(recordToRemove)) {
                        printWrite.println(objBuff);
                        printWrite.flush();
                    }
                }
                printWrite.close();
                buffRead.close();
                MemberListFile.delete();
                TempMemberListFile.renameTo(MemberListFile);
            } catch (IOException e){
                e.printStackTrace();
            }

            System.out.println("Record Deleted");
            try {
                BufferedReader br = new BufferedReader(new FileReader(MemberListFile));

                while ((br.readLine()) != null) {
                    ListOfMembers = ListOfMembers + 1;
                }
                br.close();
                int avalibleSpace = 0;
                avalibleSpace = 100 - ListOfMembers;
                System.out.println("Number Of Free Spaces Left In The System is "+avalibleSpace);
            } catch (IOException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Error, The Record Is Not Delete");
        }


    }


    public void printMember() {
        Boolean select = false;
        try {


            BufferedReader buffRead = new BufferedReader(new FileReader(DefaultMemberFile));
            String objRecord;

            while ((objRecord = buffRead.readLine()) != null) {
                System.out.println("\n");
                System.out.println(objRecord);
                System.out.println("The Type Of Member Default");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader buffRead = new BufferedReader(new FileReader(studentMemberFile));
            String objRecord;

            while ((objRecord = buffRead.readLine()) != null) {
                System.out.println("\n");
                System.out.println(objRecord);
                System.out.println("The Type Of Member Student ");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        try {


            BufferedReader buffRead = new BufferedReader(new FileReader(over60MemberFile));
            String objRecord;

            while ((objRecord = buffRead.readLine()) != null) {
                System.out.println("\n");
                System.out.println(objRecord);
                System.out.println("The Type Of Member over60 ");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}
