import java.util.Scanner;

/**
 * Created by qiqi on 2016/9/19.
 */
class Person {
    int age;
    boolean gender;// false --> male, true --> female

    Person(int age, boolean gender) {
        this.age = age;
        this.gender = gender;
    }
}

public class Assignment2 {
    // Assignment
    /**
     * Write a Computer program to find the type of a person and print the type.
     * Infant : If the age is less than 1 year
     * Toddler : If the age is less than 3 and greater than 1
     * Pre Schooler : If the age is less than 5 and greater than 3
     * KG Girl : If the age is greater than 5 and less than 6 and the gender is female
     * KG Boy : If the age is greater than 5 and less than 6 and the gender is male
     */
    public void personType(Person person) {
        if (person == null) {
            System.out.println("No person input");
            return;
        }
        String type = "";
        int age = person.age;
        if (age < 0) {
            type = "Invalid input";
        } else if (age >= 0 && age <= 1) {
            type = "Infant";
        } else if (age > 1 && age <= 3) {
            type = "Toddler";
        } else if (age > 3 && age <= 5) {
            type = "Pre Schooler";
        } else if (age > 5 && age <= 6 && person.gender) {
            type = "KG Girl";
        } else if (age > 5 && age <= 6 && !person.gender) {
            type = "KG Boy";
        } else {
            type = "Undefined type person";
        }
        System.out.println(type);
    }

    /**
     * Given an integer N as input, check the following: If N is odd, print
     * "Weird". If N is even and, in between the range of 2 and 5(inclusive),
     * print "Not Weird". If N is even and, in between the range of 6 and
     * 20(inclusive), print "Weird". If N is even and N>20, print "Not Weird".
     */
    public void weirdNumber(int n) {
        if (n <= 0) {
            System.out.println("Undefined");
            return;
        }
        boolean isWeird = false;
        if (n % 2 == 1) {
            isWeird = true;
        } else {
            if (n >= 2 && n <= 5) {
                isWeird = false;
            }
            if (n >= 6 && n <= 20) {
                isWeird = true;
            }
            if (n > 20) {
                isWeird = false;
            }
        }
        if (isWeird) {
            System.out.println("Weird");
        } else {
            System.out.println("Not weird");
        }
    }

    /**
     * Write a method to determine whether a number is prime
     */
    public void isPrime(int n) {
        boolean isPrimeOrNot = false;
        if (n < 2) {
            System.out.println(n + " is not a Prime");
            return;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println(n + " is not a Prime");
                return;
            }
        }
        System.out.println(n + " is a Prime");
    }

    /**
     * Find N fibonacci numbers Fibonacci Number: f(N) = f(N-1)+f(N-2).
     * Typically, f(0)=f(1)=1.
     */
    public int[] fibonacciNumber(int n) {
        if (n < 0)
        return null;
        int[] result = new int[n+1];
        result[0] = 1;
        if (n == 0) return result;
        result[1] = 1;
        if (n == 1) return result;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result;
    }

    /**
     * Write a function that takes a string as input and returns the string
     * reversed. Given s = "hello", return "olleh".
     */
    public String reverseString(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        // s = s.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /**
     * Given an array of nums, write a function to find the largest two integer.
     */
    public int[] findTheLargestTwo(int[] nums) { // one pass, On
        if (nums == null || nums.length == 0)
           return null;
        int n = nums.length;
        if (n == 1) {
            System.out.println("Only one number exits");
            return nums;
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
                continue;
            }
            else if (nums[i] > secondLargest){
                secondLargest = nums[i];
                continue;
            }
        }
        int[] result = new int[2];
        result[0] = largest;
        result[1] = secondLargest;
        return result;
    }

    /**
     * Given an array nums, write a function to move all 0's to the end of it
     * while maintaining the relative order of the non-zero elements. For
     * example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
     * should be [1, 3, 12, 0, 0].
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        int i = 0, j = 0;
        while (j < n) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        for (; i < n; i++) {
            nums[i] = 0;
        }
        for(int number : nums) {
            System.out.println(number);
        }
        return;
    }



    // Bonus
    /**
     * Given a non-negative integer n, repeatedly add all its digits until the
     * result has only one digit. For example: Given n = 38, the process is
     * like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    public int addDigits(int n) {
        if (n < 0){
            return 0;
        }
        int sum = n;
        while (sum / 10 != 0) {
            int temp = 0;
            while (sum / 10 != 0) {
                temp += sum % 10;
                sum = sum / 10;
            }
            temp += sum;
            sum = temp;
        }
        return sum;
    }

    /**
     * Write a program to check whether a given number is an ugly number. Ugly
     * numbers are positive numbers whose prime factors only include 2, 3, 5.
     * For example, 6, 8 are ugly, while 14 is not ugly since it includes
     * another prime factor 7. Note that 1 is typically treated as an ugly
     * number.
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n != 1) {
            if (n % 5 == 0) {
                n /= 5;
            }
            if (n % 3 == 0) {
                n /= 3;
            }
            if (n % 2 == 0) {
                n /= 2;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Assignment2 assignment = new Assignment2();

        System.out.println("Test: personType");
        Person rose = new Person(22, true);
        assignment.personType(rose); //Undefined type person
        Person jack = new Person(6, false);
        assignment.personType(jack); //KG Boy

        System.out.println("Test: weirdNumber");
        assignment.weirdNumber(-1); //Undefined
        assignment.weirdNumber(0);  //Undefined
        assignment.weirdNumber(4);  //Not weird
        assignment.weirdNumber(24); //Not weird

        System.out.println("Test: isPrime");
        assignment.isPrime(-2); //-2 is not a Prime
        assignment.isPrime(0);  //0 is not a Prime
        assignment.isPrime(2);  //2 is a Prime
        assignment.isPrime(5);  //5 is a Prime
        assignment.isPrime(10); //10 is not a Prime

        System.out.println("Test: fibonacciNumber");
        int[] result1 = assignment.fibonacciNumber(0);
        int[] result2 = assignment.fibonacciNumber(9);
        System.out.println("n = 0, fibonacciNumber is :");
        if (result1 == null || result1.length == 0) {
            System.out.println("Invalid n, no output");
        } else {
            for(int idx : result1) {
                System.out.println(idx);
            }
        }
        System.out.println("n = 9, fibonacciNumber is :");
        if (result2 == null || result2.length == 0) {
            System.out.println("Invalid n, no output");
        } else {
            for(int idx : result2) {
                System.out.println(idx);
            }
        }

        System.out.println("Test: reverseString");
        System.out.println("Enter the string");
        Scanner s = new Scanner(System.in);
        String word = s.nextLine();
        System.out.println(assignment.reverseString(word));

        System.out.println("Test: findTheLargestTwo");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the count of numbers in the array: ");
        int n = scanner.nextInt();
        int[] nums1 = new int[n];
        System.out.println("Enter all numbers: ");
        for (int i = 0; i < n; i++) {
            nums1[i] = scanner.nextInt();
        }
        int[] findTheLargestTwoArray = assignment.findTheLargestTwo(nums1);
        System.out.println("the largest two number is : ");
        System.out.println(findTheLargestTwoArray[0] +" , " +findTheLargestTwoArray[1]);

        System.out.println("Test: moveZeroes");
        assignment.moveZeroes(nums1);

        System.out.println("Test: addDigits");
        System.out.println(1001 + "addDigits result is : " + assignment.addDigits(1001)); //2
        System.out.println(1009 + "addDigits result is : " + assignment.addDigits(1009)); //1

        System.out.println("Test: isUgly");
        System.out.println(-2 + " is ugly number or not : " + assignment.isUgly(-2));  //false
        System.out.println(14 + " is ugly number or not : " + assignment.isUgly(14));  //false
        System.out.println(20 + " is ugly number or not : " + assignment.isUgly(20)); //true
    }
}