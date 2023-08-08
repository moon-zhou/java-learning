package org.moonzhou.trycatch;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * 任何执行try 或者catch中的return语句之前，都会先执行finally语句，如果finally存在的话。
 * 如果try中有return时，会将return的值临时保存起来，当finally执行完毕后，再return临时保存的值，如果return值是基本数据类型，finally执行不会影响，如果是引用类型的值，则在finally中修改内容的话会影响。
 * 如果finally中有return语句，那么程序就return了，所以finally中的return是一定会被return的，编译器把finally中的return实现为一个warning。但是程序依然会走try/catch里面的retrun语句。
 * @date 2023/8/8 21:26
 */
public class Demo001 {
    public static void main(String[] args) {
        System.out.println(test1());

        System.out.println();
        System.out.println(test2());

        System.out.println();
        System.out.println(test3());

        System.out.println();
        System.out.println(test4());

        System.out.println();
        System.out.println(test5());

        System.out.println();
        System.out.println(test6());

        System.out.println();
        System.out.println(test7());

        System.out.println();
        System.out.println(test8());
    }

    /**
     * try里有异常+finally里面无retun块 ：先执行完finally里面的代码后，再执行catch中的return语句。
     *
     * @return
     */
    private static String test1() {
        String s = null;
        try {
            System.out.println("我是try里面的语句");
            System.out.println(s.length());// 空指针异常
            return "我是try里的return语句";
        } catch (NullPointerException e) {
            System.out.println("我是catch语句里面语句1");
            return "我是catch语句里面的return语句1";
        } catch (Exception e) {
            System.out.println("我是catch语句里面语句2");
            return "我是catch语句里面的return语句2";
        } finally {
            System.out.println("我是finally里面的执行语句");
        }
    }

    /**
     * try里无异常+finally里面无retun块 ：先执行完finally里面的代码后，再执行try里面的return语句。
     *
     * @return
     */
    private static String test2() {
        String s = "333";
        try {
            System.out.println("我是try里面的语句");
            System.out.println(s.length());
            return "我是try里的return语句";
        } catch (NullPointerException e) {
            System.out.println("我是catch语句里面语句1");
            return "我是catch语句里面的return语句1";
        } catch (Exception e) {
            System.out.println("我是catch语句里面语句2");
            return "我是catch语句里面的return语句2";
        } finally {
            System.out.println("我是finally里面的执行语句");
        }
    }

    /**
     * try里面无异常+finally里有return：执行完finally后，直接执行finally里面的return语句，程序结束
     *
     * @return
     */
    private static String test3() {
        String s = "333";
        try {
            System.out.println("我是try里面的语句");
            System.out.println(s.length());
            return "我是try里的return语句";
        } catch (NullPointerException e) {
            System.out.println("我是catch语句里面语句1");
            return "我是catch语句里面的return语句1";
        } catch (Exception e) {
            System.out.println("我是catch语句里面语句2");
            return "我是catch语句里面的return语句2";
        } finally {
            System.out.println("我是finally里面的执行语句");
            return "我是finally里面的return语句";
        }
    }

    /**
     * try里面有异常 +finally里有return：执行完finally后，直接执行finally里面的return语句，程序结束
     *
     * @return
     */
    private static String test4() {
        String s = null;
        try {
            System.out.println("我是try里面的语句");
            System.out.println(s.length());// 空指针异常
            return "我是try里的return语句";
        } catch (NullPointerException e) {
            System.out.println("我是catch语句里面语句1");
            return "我是catch语句里面的return语句1";
        } catch (Exception e) {
            System.out.println("我是catch语句里面语句2");
            return "我是catch语句里面的return语句2";
        } finally {
            System.out.println("我是finally里面的执行语句");
            return "我是finally里面的return语句";
        }
    }

    /**
     * try / catch里面的return语句不会被输出打印，但是程序还是会走这步的，只不过我们遇到return语句就代表程序结束，所以我们只能最后输出finally块里面的return语句。
     *
     * @return
     */
    private static int test5() {
        int i = 0;
        try {
            i++;
            i = i / 0;
            return i++;
        } catch (Exception e) {
            i++;
            return i++;
        } finally {
            return ++i;
        }
    }

    private static int test6() {
        int i = 0;
        try {
            i++;
            i = i / 0;
            // return i++;
        } catch (Exception e) {
            i++;
            return i = 7;
        } finally {
            // return ++i; // return catch result+1=8
            return i++; // return catch result 7
        }
    }

    private static int test7() {
        int a = 10;
        try {
            System.out.println(a / 0);
            a = 20;
        } catch (ArithmeticException e) {
            a = 30;
            /*
             * return a 在程序执行到这一步的时候，这里不是return a 而是 return 30；这个返回路径就形成了
             * 但是呢，它发现后面还有finally，所以继续执行finally的内容，a=40
             * 再次回到以前的路径,继续走return 30，形成返回路径之后，这里的a就不是a变量了，而是常量30
             *
             * 基本数据类型finally中修改不会影响，如果是引用类型，finally中修改则会影响
             */
            return a;
        } finally {
            a = 40;
        }
        return a;
    }

    private static int test8() {
        int a = 10;
        try {
            System.out.println(a / 0);
            a = 20;
        } catch (ArithmeticException e) {
            a = 30;
            return a;
        } finally {
            a = 40;
            // 如果这样，就又重新形成了一条返回路径，由于只能通过1个return返回，所以这里直接返回40
            return a;
        }
    }
}
