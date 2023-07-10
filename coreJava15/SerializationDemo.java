package coreJava15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Student student=new Student(101, "Bala", 92.25f);
		FileOutputStream fos=new FileOutputStream("student.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(student);
		System.out.println("Serialization done");
		oos.close();
		fos.close();
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
