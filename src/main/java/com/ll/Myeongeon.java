package com.ll;

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
