package tests;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.enit.info.model.Exam;
import com.enit.info.model.Session;
import com.enit.info.model.Speciality;
import com.enit.info.model.Student;
import com.enit.info.services.StudyManagementLocal;
import com.enit.info.services.StudyManagementRemote;
public class ClientEJB {
	public static void main(String[] args) throws NamingException { 
		
		String appName=""; 
		String moduleName="ProjetEjbStudent"; 
		String distinctName="studentProjet"; 
		String viewClassName=StudyManagementRemote.class.getName();
	    System.out.println(viewClassName); 

		Context ctx=new InitialContext(); 
		String ejbRemoteJNDIName="ejb:"+appName+"/"+moduleName+"/"+distinctName+"!"+viewClassName; 
		System.out.println(ejbRemoteJNDIName); 
		
		StudyManagementRemote stub=(StudyManagementRemote)ctx.lookup(ejbRemoteJNDIName);
		System.out.println("stub= "+stub); 
		ctx.close();
		
		/*Student st1 = new Student("01","Eya");
		stub.addStudent(st1);
		Student st2 = new Student("02","yassmine");
		stub.addStudent(st2);
		Speciality sp1 = new Speciality("info");
		stub.addSpeciality(sp1);
		Speciality sp2 = new Speciality("math");
		stub.addSpeciality(sp2);
		Exam ex1=new Exam("Java",stub.findSpecialityById(1));
		stub.addExam(ex1);
		Exam ex2=new Exam("Analyse",stub.findSpecialityById(2));
		stub.addExam(ex2);
		System.out.println(stub.findStudentById("01"));
		System.out.println(stub.findSpecialityById(1));
		Date d1=new Date();
		stub.addSession(d1, stub.findStudentById("01"), stub.findExamById(1));
		Date d2=new Date();
		stub.addSession(d2, stub.findStudentById("02"), stub.findExamById(2));*/
		System.out.println(stub.findSession(new Date(2021-01-05), "01", 1));
		Session se= stub.findSession(new Date(2021-01-05), "01", 1);
		se.setMark(15);
		stub.update(se);
		System.out.println(stub.findSession(new Date(2021-01-05), "01", 1));
	}
}
