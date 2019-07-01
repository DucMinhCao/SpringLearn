package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int lefttoright = 0;
        int righttoleft = 0;
        int[][] items = new int[arr.size()][arr.size()];
        List<Integer> tempList = new ArrayList<>();
        for (List<Integer> arrRowItems : arr) {
            for (int number : arrRowItems) {
                tempList.add(number);
            }
        }
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (count < tempList.size()) {
                    items[i][j] = tempList.get(count);
                    count++;
                }
            }
        }
        for (int row = 0; row < arr.size(); row++) {
            for (int column = 0; column < arr.size(); column++) {
                if (row == column) {
                    lefttoright = lefttoright + items[row][column];
                }
                if (row + column == arr.size() - 1) {
                    righttoleft = righttoleft + items[row][column];
                }
            }
        }
        return Math.abs(lefttoright - righttoleft);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
