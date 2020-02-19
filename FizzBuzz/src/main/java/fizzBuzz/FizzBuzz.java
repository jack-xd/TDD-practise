package fizzBuzz;

/**
 * 任务需求：
 * <p>
 * 1.打印出从1到100的数字，
 * <p>
 * 2.将其中3的倍数替换成“Fizz”，
 * <p>
 * 3.5的倍数替换成“Buzz”，
 * <p>
 * 4.既能被3整除、又能被5整除的数则替换成“FizzBuzz”。
 * <p>
 * 很简单对吗？以下是这道题目的其他要求：
 * <p>
 * 1.代码整洁，没有重复代码
 * <p>
 * 2.有单元测试，单元测试覆盖率100%
 * <p>
 * 3.10分钟内完成
 * <p>
 * 开始前请拿出表计时，记录下你第一次完成这个项目的时间
 */

public class FizzBuzz {

    public void printFizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
