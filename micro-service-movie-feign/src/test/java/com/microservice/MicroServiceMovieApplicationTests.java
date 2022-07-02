package com.microservice;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MicroServiceMovieApplicationTests {

   public static void main(String[] args) {
       System.out.println(demo());
   }

    public static int demo() {
        try {
            int a= 1/0;
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        } finally {
            return 0;
        }
    }

}
