package com.example.MiniProjectEmployeeManagementSystem.util;

public class Test {
    public static void main(String args[]) {
        String str = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6InRlc3QuY29tIiwiaWF0IjoxNzE2NDMxNDg2LCJleHAiOjE3MTY0MzE3ODZ9.MqvhUkjy_AVguS4Bq1wFxPSjUhhHBni_t1Nen59ZI9Y";
        String[] arr = str.split(" ");
    System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

}