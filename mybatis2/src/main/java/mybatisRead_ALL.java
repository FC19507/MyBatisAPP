
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mybatisRead_ALL { 

   public static void main(String args[]) throws IOException{

      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
      SqlSession session = sqlSessionFactory.openSession();
      
      //select contact all contacts		
      
      //selectAllStudent(session);
     //updateStudent(session);
      //SelectStudent(1,session);
       // deleteStudent(1 ,session);   
   
      
      System.out.println("Records Read Successfully ");          
      session.commit();   
      session.close();			
   }
   private static void deleteStudent(int id ,SqlSession session) { 
	   //Delete operation
	      session.delete("Student.deleteById", id);  
   }
   private static  void SelectStudent(int id ,SqlSession session) {
	   Student student =session.selectOne("Student.getById",id);
	   if(student!=null)
	   System.out.println(student.getEmail());
   }
   private static void selectAllStudent(SqlSession session) {
	   List<Student> student = session.selectList("Student.getAll");
       
	      for(Student st : student ){    	  
	         System.out.println(st.getId());
	         System.out.println(st.getName());
	         System.out.println(st.getBranch());
	         System.out.println(st.getPercentage());         
	         System.out.println(st.getEmail());        
	         System.out.println(st.getPhone());   
	      }  
			
   }
   private static void updateStudent(SqlSession session) {
	   Student student = (Student) session.selectOne("Student.getById", 1);
	      System.out.println("Current details of the student are" );
	      System.out.println(student.toString());  
	      //Set new values to the mail and phone number of the student
	       student.setEmail("mohamad123@yahoo.com");
	       student.setPhone(90000000);
	       session.update("Student.update",student);
	       
   }
}