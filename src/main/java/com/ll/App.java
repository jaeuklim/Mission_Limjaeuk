package com.ll;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class App {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Myeongeon> list = new ArrayList<Myeongeon>();
    int num = 1;
    int[] checkexist = new int[100];

    void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                System.out.println();
                System.out.println("프로그램 다시 시작...");
                System.out.println();
                run();
            }


            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String myeong = scanner.nextLine();

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                list.add(new Myeongeon(num, myeong, author));
                System.out.println(num + "번 명언이 등록되었습니다.");
                checkexist[num - 1] = 1;
                num++;

            }

            if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = list.size() - 1; i >= 0; i--)
                    list.get(i).get();
            }

            if (cmd.equals("삭제")) {
                System.out.print("?id=");
                int id = scanner.nextInt();

                if (checkexist[id - 1] == 1) {
                    list.remove(id - 1);
                    System.out.println(id + "번 명언이 삭제되었습니다.");
                    checkexist[id - 1] = 0;
                } else
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
            }

            if (cmd.equals("수정")) {
                System.out.print("?id=");
                int id = scanner.nextInt();
                Scanner scanner1 = new Scanner(System.in);

                System.out.println("명언(기존) : " + list.get(id - 1).myeong);
                System.out.print("명언 : ");
                String myeong = scanner1.nextLine();
                list.get(id - 1).myeong = myeong;

                System.out.println("작가(기존) : " + list.get(id - 1).author);
                System.out.print("작가 : ");
                String author = scanner1.nextLine();
                list.get(id - 1).author = author;
            }

            if (cmd.equals("빌드")) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                // Java 객체를 JSON 문자열로 변환
                String json = gson.toJson(list);

                try {
                    // JSON 데이터를 파일에 쓰기
                    FileWriter writer = new FileWriter("data.json");
                    writer.write(json);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("data.json 파일의 내용이 갱신되었습니다.");
            }
        }
    }
}
