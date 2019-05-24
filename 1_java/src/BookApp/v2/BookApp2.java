package BookApp.v2;

import java.util.Scanner;

public class BookApp2 {

	public static void main(String[] args) {

		BookMgr books = new BookMgr();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("**********************************");
			System.out.println("*********Book Application*********");
			System.out.println("**********************************");
			System.out.println("원하는 메뉴 번호를 입력하세요");
			System.out.println("1. 입	 력");
			System.out.println("2. 수	 정");
			System.out.println("3. 삭	 제");
			System.out.println("4. 검	 색");
			System.out.println("5. 목록보기");
			System.out.println("6. 종	 료");
			System.out.println("**********************************");

			String input = sc.nextLine();
			if (input == null || input.length() == 0)
				input = "99";
			int num = Integer.parseInt(input);

			String cmd;
			switch (num) {

			case 1: // 입력메뉴 이동
				System.out.println("1. 입	력 서비스");
				System.out.println("책 제목과 가격을 입력하세요.");
				System.out.println("ex)노인과 바다/5000");
				cmd = sc.nextLine();
				books.addBook(cmd);
				break;
			case 2: // 수정 메뉴 이동
				System.out.println("2. 수	정 서비스");
				System.out.println("수정할 책 제목과 가격을 입력하세요.");
				System.out.println("ex)노인과 바다/5000");
				cmd = sc.nextLine();
				books.updateBook(cmd);
				break;
			case 3: // 삭제 메뉴 이동
				System.out.println("3. 삭	제 서비스");
				System.out.println("삭제할 책 제목과 가격을 입력하세요.");
				cmd = sc.nextLine();
				books.deleteBook(cmd);
				break;
			case 4: // 검색 메뉴 이동
				System.out.println("4. 검	색 서비스");
				System.out.println("검색할 책 제목을 입력하세요.");
				cmd = sc.nextLine();
				books.searchBook(cmd);
				break;
			case 5: // 목록보기 메뉴 이동
				System.out.println("5. 목 록 보 기 서비스");
				books.printBookList();
				break;
			case 6: // 종료
				System.out.println("Book Application 종료");
				sc.close();
				sc = null;
				System.exit(0);
				break;
			default:
				System.out.println("잘못 입력하셨습다. 1~6 사이의 번호를 입력하세요.");
				continue;
			}

		}

	}

}
