package javaIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

class MyClass implements Serializable {
	// 직렬화와 역직렬화를 할 때 같은 타입인지를
	// 비교하기 위해서 내부적으로 사용
	private static final long serialVersionUID = 1L;

	// 멤버 변수도 직렬화가 가능한 형태여야 함
	// String class는 직렬화가 가능한 형태
	String name;
	int kor;

	// Socket class는 직렬화가 안 됨
	// 하나라도 직렬화가 안 되는 형태의 변수가 있으면 직렬화 불가
	// transient : 직렬화 제외해주는 keyword
	transient Socket socket;

	public MyClass(String name, int kor) {
		super();
		this.name = name;
		this.kor = kor;
	}

}

public class Ex04_Serialization {

	public static void main(String[] args) {
		// ObjectOutStream을 이용해서 File에
		// 내가 만든 instance 저장
		// 1. 저장할 객체를 생성
		MyClass obj = new MyClass("헝길동", 70);

		// 2. 객체를 저장할 파일 객체를 생성
		File file = new File("asset/students.txt");

		try {
			// 3. 파일 객체를 이용해서 ObjectOutputStream을 생성
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// 4.ObjectOutputStream을 이용해서 객체들 파일에 저장
			// 저장할 객체는 반드시 직렬화가 가능한 객체여야 하는데
			// 우리가 생성한 객체는 직렬화가 가능한 객체가 아님

			// 객체 직렬화가 가능하려면 어떻게 해야 할까?
			// -> Serializable interface를 구현하면 됨
			// 클래스의 필드가 모두 직렬화가 가능한 형태여야 함
			oos.writeObject(obj);

			// 5. 저장이 끝나면 stream close
			oos.close();
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
