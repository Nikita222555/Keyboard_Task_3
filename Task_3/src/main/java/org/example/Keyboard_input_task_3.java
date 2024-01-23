/**
 *  Программа Keyboard_input_task_3 реализует
 *  алгоритм, вычисляющий минимальное количество
 *  пар линз, необходимых для удовлетворения всех
 *  поступивших заказов
 *  Организован ввод данных с клавиатуры
 *
 *  @атор Томилов Н.С.
 *  @версия 1.0
 *  @от 2024-01-23
 */
package org.example;
import java.util.Scanner;

public class Keyboard_input_task_3 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите количество пришельцев: ");
    int n = sc.nextInt();
    System.out.println("Введите диоптрии для каждого n-го пришельца: ");
    int[] arr = new int[n];

        for (int i=0; i<n; i++){        // Заполняем массив данными
            arr[i] = sc.nextInt();      // с клавиатуры + 'Enter'
        }

        int count = 0;                  // Счетчик для линз
        int a,b,t;                      // Переменные для сортировки массива

        for ( a=1; a < n; a++) {             // Сортировка "пузырьки"
            for (b = n - 1; b >= a; b--) {
                if (arr[b - 1] > arr[b]) {
                    t = arr[b - 1];
                    arr[b - 1] = arr[b];
                    arr[b] = t;
                }
            }
        }

        System.out.println("Отсортированный массив: \n");
        for(int i=0; i<n; i++){         // Вывод отсортированного массива для наглядности
            System.out.print(" "+arr[i]);
        }
        System.out.println();

        int i = 0;                      // Индекс элемента в массиве

        while (i < n){                  // Цикл для поиска оптимальных вариантов покупки
            if(i+1<n && arr[i+1]-arr[i]<=2){
                count += 1;
                i += 2;
            } else {
                count += 1;
                i += 1;
            }
        }

        System.out.println("\nНеобходимо закупить комплектов: "+count); // Ответ

    }
}