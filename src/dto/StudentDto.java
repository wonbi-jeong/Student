package dto;

import java.util.Scanner;

// Data Transfer Object : 데이터 단위의 클래스
// VO(Value Object)
public class StudentDto { // 학생 수만큼 생성
	// 학생의 항목들
	// 학생 기록부
	private String name;
	private int age;
	private double height;
	private String address;
	private int kor;
	private int eng;
	private int math;
	
	public StudentDto() {

	}
	
	// source - generate constructor => 바로 생성
	public StudentDto(String name, int age, double height, String address, int kor, int eng, int math) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.address = address;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	// source - generate getters and setters => 바로 생성
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	// source - generate toString => 바로 생성
	@Override
	public String toString() {
		return "StudentDto [name=" + name + ", age=" + age + ", height=" + height + ", address=" + address + " , kor="
				+ kor + ", eng=" + eng + ", math=" + math + "]";
	}
	
	public void print() {
		System.out.println("이름:" + name + "나이:" + age + " 신장:" + height + " 주소:" + address + " + 국어:"
				+ kor + " 영어: " + eng + " 수학:" + math);
	}
		
	
}
