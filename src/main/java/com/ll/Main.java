package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");

        Scanner  scanner= new Scanner(System.in);
        ArrayList<Myeongeon> list = new ArrayList<Myeongeon>();
        int num = 1;

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
                num++;

            }
        }

    }
}

class Myeongeon {
    int num;
    String Myeong;
    String author;

    Myeongeon(int num, String myeong, String author){
        this.num = num;
        this.Myeong = myeong;
        this.author = author;
    }
}
