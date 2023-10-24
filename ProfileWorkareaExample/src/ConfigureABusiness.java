/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;

import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;

import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import org.mindrot.jbcrypt.BCrypt;


/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Information Systems");

// Create Persons
      PersonDirectory persondirectory = business.getPersonDirectory();
// person representing sales organization

        Person xeroxadminperson001 = persondirectory.newPerson("Admin", "admin", "admin@gamil.com", "00");
        Person student01  = persondirectory.newPerson("Nikesh", "Biraggari", "nikhil@gmail.com", "01");
        Person student02 = persondirectory.newPerson("Kusumanth","Gali", "kusumanth@gmail.com", "02");
        Person student03 = persondirectory.newPerson("Revanth", "Padala", "revanth@gmail.com", "03");
      /*  Person xeroxmarketingperson001 = persondirectory.newPerson("Xerox marketing");
        Person xeroxadminperson001 = persondirectory.newPerson("Xerox admin");

// Create person objects to represent customer organizations. 
        Person person005 = persondirectory.newPerson("Dell");
        Person person006 = persondirectory.newPerson("Microsoft");
        Person person007 = persondirectory.newPerson("Google");
        Person person008 = persondirectory.newPerson("JP Morgan");
        Person person009 = persondirectory.newPerson("State street"); //we use this as customer
*/
// Create Customers


// Create Admins to manage the business
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(xeroxadminperson001);
        
        StudentDirectory studentdirectory = business.getStudentDirectory();
        StudentProfile studentProfile01 = studentdirectory.newStudentProfile(student01);
        StudentProfile studentProfile02 = studentdirectory.newStudentProfile(student02);
        StudentProfile studentProfile03 = studentdirectory.newStudentProfile(student03);
        
        

   
// Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "admin", BCrypt.hashpw("admin", BCrypt.gensalt()),true); /// order products for one of the customers and performed by a sales person
        UserAccount ua4 = uadirectory.newUserAccount(studentProfile01, "nikesh", BCrypt.hashpw("nikesh", BCrypt.gensalt()),false); 
        UserAccount ua5 = uadirectory.newUserAccount(studentProfile02, "kusumanth", BCrypt.hashpw("kusumanth", BCrypt.gensalt()),false); 
        UserAccount ua6 = uadirectory.newUserAccount(studentProfile03, "revanth", BCrypt.hashpw("revanth", BCrypt.gensalt()),false); 
        
        System.out.println(BCrypt.hashpw("admin", BCrypt.gensalt()));
        return business;

        
    }
    
   

}
