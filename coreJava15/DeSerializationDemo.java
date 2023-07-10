package coreJava15;

import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DeSerializationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fis=new FileInputStream("student.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object object=ois.readObject();
			Student stud1=(Student)object;
			stud1.display();
		}catch(ClassNotFoundException |IOException e) {
			e.printStackTrace();
		}

	}

}
