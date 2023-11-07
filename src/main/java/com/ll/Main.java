package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");

        Scanner  scanner= new Scanner(System.in);
        ArrayList<Myeongeon> list = new ArrayList<Myeongeon>();
        int num = 1;
        int []checkexist = new int[100];


        while(true){
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if(cmd.equals("종료"))
                return;

            if(cmd.equals("등록")){
                System.out.print("명언 : ");
                String myeong = scanner.nextLine();

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                list.add(new Myeongeon(num,myeong,author));
                System.out.println(num + "번 명언이 등록되었습니다.");
                checkexist[num-1]=1;
                num++;

            }

            if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for(int i = list.size()-1; i>=0; i--)
                    list.get(i).get();
            }

            if(cmd.equals("삭제")){
                System.out.print("?id=");
                int id = scanner.nextInt();

                if(checkexist[id-1]==1){
                    list.remove(id-1);
                    System.out.println(id+"번 명언이 삭제되었습니다.");
                    checkexist[id-1]=0;
                }
                else
                    System.out.println(id+"번 명언은 존재하지 않습니다.");
            }

            if(cmd.equals("수정")){
                System.out.print("?id=");
                int id = scanner.nextInt();
                Scanner scanner1= new Scanner(System.in);

                System.out.println("명언(기존) : " + list.get(id-1).myeong);
                System.out.print("명언 : ");
                String myeong = scanner1.nextLine();
                list.get(id-1).myeong = myeong;

                System.out.println("작가(기존) : " + list.get(id-1).author);
                System.out.print("작가 : ");
                String author = scanner1.nextLine();
                list.get(id-1).author = author;
            }
        }
    }
}

class Myeongeon {
    int num;
    String myeong;
    String author;

    Myeongeon(int num, String myeong, String author) {
        this.num = num;
        this.myeong = myeong;
        this.author = author;
    }

    void get() {
        System.out.println(num + " / " + myeong + " / " + author);
    }
}


//        명령) 수정?id=2
//        명언(기존) : 과거에 집착하지 마라.
//        명언 : 현재와 자신을 사랑하라.
//        작가(기존) : 작자미상
//        작가 : 홍길동
//        명령) 목록
//        번호 / 작가 / 명언
//        ----------------------
//        2 / 홍길동 / 현재와 자신을 사랑하라.
//        명령) 종료

