package javaThread;

import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Ex03_ThreadSleep extends Application {

	private void printMsg(String msg) {
		Platform.runLater(() -> {
			// runLater()의 인자로 runnable 객체가 나와야 함
			textarea.appendText(msg + "\n");
		});
	}

	TextArea textarea;
	Button btn;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성해서 window에 띄우는 코드
		// BorderPane : 화면 기본 layout을 설정 => 화면을 동/서/남/북/중앙 (5개의 영역)으로 분리
		BorderPane root = new BorderPane();
		// BorderPane의 크기를 설정 => 화면에 띄우는 window의 크기 설정
		root.setPrefSize(700, 500);

		// Component를 생성해서 BorderPane에 부착
		// 글 상자 생성
		textarea = new TextArea();
		// 화면의 가운데에 글 상자 위치
		// default size : 전체
		root.setCenter(textarea);

		btn = new Button("버튼 클릭");
		btn.setPrefSize(250, 50);

		// setOnAction(특정 interface를 구현한 객체이고 추상 method를 overriding 하는 코드)
		btn.setOnAction(t -> {
			// 버튼에서 Action이 발생(클릭)했을 때 호출

			IntStream intStream = IntStream.rangeClosed(1, 5);
			// consumer 사용
			intStream.forEach(value -> {
				// 1~5까지 5번 반복
				Thread thread = new Thread(() -> {
					for (int i = 0; i < 5; i++) {
						// Thread block
						try {
							Thread.sleep(3000);
							printMsg(i + " : " + Thread.currentThread().getName());

						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
				thread.setName("ThreadNumber-" + value);
				thread.start();

			});
		});
		// FlowPane : 오른쪽으로 붙이는 layout
		// 안스의 Linear Layout
		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		// FlowPane에 버튼 올리기
		flowpane.getChildren().add(btn);
		root.setBottom(flowpane);

		// 실제 Window에 띄우기 위해 Scene 객체 필요
		Scene scene = new Scene(root);
		// Stage primaryStage : 실제 Window 객체
		primaryStage.setScene(scene);
		primaryStage.setTitle("Thread 예제입니다");
		// Window에 띄우기
		primaryStage.show();

	}

	public static void main(String[] args) {
		// launch() : start()를 실행시키는 함수
		launch();
	}

}
