package dao;

import dto.StudentDto;
import file.FileIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import dto.StudentDto;

// Data Access Object : 데이터를 취급하는 클래스
public class StudentDao {
	Scanner sc = new Scanner(System.in);
	
	// 학생 데이터 관리 배열
	private StudentDto student[];
	
	private int count;
		
	private FileIO fio;

	// 추가, 삭제, 검색, 수정(CRUD)
	public StudentDao() {
		fio = new FileIO("student");
		fio.create();
		
		count = 0;
		
		student = new StudentDto[10]; // 변수만 생성
		// StudentDto student1, student2, student3 ,,,
		
		// dto를 생성
//		for (int i = 0; i < student.length; i++) {
//			student[i] = new StudentDto(); // 생성은 추가할 때마다 입력
//		}
	}
	
	
	public void insert() {
		System.out.println("학생 정보 입력입니다");

		System.out.print("이름 >> ");
		String name = sc.next();

		System.out.print("나이 >> ");
		int age = sc.nextInt();

		System.out.print("신장 >> ");
		double height = sc.nextDouble();

		System.out.print("주소 >> ");
		String address = sc.next();

		System.out.print("국어 >> ");
		int kor = sc.nextInt();

		System.out.print("영어 >> ");
		int eng = sc.nextInt();

		System.out.print("수학 >> ");
		int math = sc.nextInt();
		
		student[count] = new StudentDto(name, age, height, address, kor, eng, math);
		
		count++;	// 배열의 다음으로 이동

	}
	
	public void delete() {
		System.out.print("삭제하고 싶은 학생의 이름 >> ");
		String name = sc.next();
		
		// 검색
		int index = search(name);

		if(index == -1) {
			System.out.println("학생정보를 찾을 수 없습니다");
			return;
		}
			student[index].setName("");
			student[index].setAge(0);
			student[index].setHeight(0.0);
			student[index].setAddress("");
			student[index].setKor(0);
			student[index].setEng(0);
			student[index].setMath(0);
		
			System.out.println(name + "정상적으로 삭제되었습니다");
	}
	
	public void select() {
		Scanner sc = new Scanner(System.in);
		// 이름입력
		System.out.println("검색하고 싶은 학생의 이름 >>");
		String name = sc.next();
		
		for (int i = 0; i < student.length; i++) {
			StudentDto dto = student[i];
			if(dto != null && dto.getName().equals("") == false) {
				if(name.equals(dto.getName())) {
						dto.print();
				}
			}	
		}
	}
	
	public void update() {
		System.out.println("수정하고 싶은 학생의 이름 >>");
		String name = sc.next();
		
		int index = search(name);
		
		if(index == -1) {
			System.out.println("학생정보를 찾을 수 없습니다");
			return;
		}
		
		// 국어, 영어, 수학 점수 수정
		System.out.println("수정할 데이터를 찾았습니다");
		
		System.out.print("국어 >> ");
		int kor = sc.nextInt();
		
		System.out.print("영어 >> ");
		int eng = sc.nextInt();
		
		System.out.print("수학 >> ");
		int math = sc.nextInt();
		
		student[index].setKor(kor);
		student[index].setEng(eng);
		student[index].setMath(math);
		
		System.out.println("성공적으로 수정되었습니다");
	}
	
	public int search(String name) {
		int index = -1;
		for (int i = 0; i < student.length; i++) {
			StudentDto dto = student[i];
			if(dto != null) {
				if(name.equals(dto.getName())) {	// 찾았다!
					index = i;
					break;
				}
			}
		}
		return index;
	}
	

	
	public void allData() {
		for (int i = 0; i < student.length; i++) {
			StudentDto dto = student[i];
			if(dto != null && !dto.getName().equals("")) {
				System.out.println(dto.toString());
			}
		}
	}
	public void save() {
		
		//실제로 삭제된 데이터를 제외한 (정상적인)데이터가 몇개?
		int ci = 0;
		for (int i = 0; i < student.length; i++) {
			if(student[i] != null
					&& student[i].getName().equals("") == false) {
				ci++;
			}
		}
		
		// 배열
		String arr[] = new String[ci];
		int j = 0;
		for (int i = 0; i < student.length; i++) {
			if(student[i] != null
					&& student[i].getName().equals("") == false) {
				
				arr[j] = student[i].toString();
				j++;
			}
		}
		fio.dataSave(arr);
	}
		
		public void load() {
			String arr[] = fio.dataLoad();
			
			if(arr == null || arr.length == 0) {
				count = 0;
				return;
			}
			
			// string[] -> student[]
			for (int i = 0; i < arr.length; i++) {
				//문자열 자르기
				String split[] = arr[i].split("-");
				
				// 자른 문자열을 dto에 저장하기 위한 처리
				String name = split[0];
				int age = Integer.parseInt(split[1]);
				double height = Double.parseDouble(split[2]);
				String address = split[3];
				int kor = Integer.parseInt(split[4]);
				int eng = Integer.parseInt(split[5]);
				int math = Integer.parseInt(split[6]);
				
				student[i] = new StudentDto(name, age, height, address, kor, eng, math);
			}
			System.out.println("데이터로드 성공!");

	}
}
