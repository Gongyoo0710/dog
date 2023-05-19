package doghospital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Service {
    //创建小狗
    public static dog[] dogs;

    public Service(int num) {
        dogs = new dog[num];
        int i;
        for (i = 0; i < 3; i++)
            dogs[i] = new dog(i, "red", i, i * 100 + 100);
        for (; i < 6; i++)
            dogs[i] = new dog(i, "white", i, i * 100);
        for (; i < 10; i++)
            dogs[i] = new dog(i, "black", i, i * 100);
    }

    public dog[] list() {
        return dogs;
    }

    public static dog[] del(int n) {
        int i;
        int k = 0;
        Boolean judge = false;
        for (i = 0; dogs[i] != null; i++) ;
        for (k = 0; k < i; k++) {
            if (dogs[k].getId() == n) {
                judge = true;
                break;
            }
        }
        if (judge) {
            for (int j = k; j < i - 1; j++) {
                dogs[j] = dogs[j + 1];
            }
            dogs[i - 1] = null;
            System.out.println("您已成功购买到小狗");
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            wallet money = new wallet();
            money.setMoney(money.getMoney() + dogs[n].getPrica());
            money.setTime("你于" + money.getTime() + time + "卖出了小狗" + n + "并获得了" + dogs[n].getPrica() + "元\n");
        } else {
            System.out.println("未找到您要购买的小狗");
        }
        return dogs;
    }


    //查找小狗


    //修改小狗
    public static dog[] change(int n) {
        Scanner scanner1 = new Scanner(System.in);
        int i, sign = 0;
        Boolean judge = false;
        for (i = 0; dogs[i] != null; i++) ;
        for (int k = 0; k < i; k++) {
            if (dogs[k].getId() == n) {
                judge = true;
                sign = k;
                break;
            }
        }
        if (judge) {
            System.out.println("它目前的颜色是" + dogs[sign].getColor() + "请问您想将它改为什么颜色呢？？？");
            String newcolor = scanner1.next();
            dogs[sign].setColor(newcolor);
        } else {
            System.out.println("未找到您要改变的小狗");

        }
        return dogs;
    }

    public static dog[] add(dog Dog) {
        int i;
        for (i = 0; dogs[i] != null; i++);
        dogs[i++] = Dog;
        return dogs;
    }

    public static void find(int n) {
        Scanner scanner1 = new Scanner(System.in);
        int sum;
        Boolean judge = false;
        for (sum = 0; dogs[sum] != null; sum++) ;

        if (n == 1) {
            int j;
            int colorsSum = 0;

            String[] colors = new String[10];
            for (int i = 0; i < sum; i++) {
                for (colorsSum = 0; colors[colorsSum] != null; colorsSum++) ;
                int a = 1;
                for (j = 0; j < colorsSum; j++) {
                    if (dogs[i].getColor().equals(colors[j])) {
                        a = 0;
                    }
                }
                if (a == 1)
                    colors[j] = dogs[i].getColor();
            }
            System.out.print("目前店内有以下几种颜色");
            for (colorsSum = 0; colors[colorsSum] != null; colorsSum++) {
                System.out.print(',' + colors[colorsSum]);
            }
            System.out.print("请输入你想要小狗的毛色：");
            String color = scanner1.next();
            System.out.println("以下是满足条件的小狗：");
            System.out.println("编号\t\t颜色\t\t年龄\t\t价格");
            for (int i = 0; i < sum; i++) {
                if (color.equals(dogs[i].getColor())) {
                    System.out.println(dogs[i]);
                    judge = true;
                }
            }
            if (!judge)
                System.out.println("暂时没有该颜色的小狗呦");
        } else if (n == 2) {
             if (scanner1.hasNextInt() == true) {
                System.out.println("请分别输入你想要小狗的年龄区间（以空格分隔）：");
                int a = scanner1.nextInt();
                int b = scanner1.nextInt();
                System.out.println("以下是满足条件的小狗：");
                System.out.println("编号\t\t颜色\t\t年龄\t\t价格");
                for (int j = 0; j < sum; j++) {
                    if (dogs[j].getAge() >= a && dogs[j].getAge() <= b) {
                        System.out.println(dogs[j]);
                        judge = true;
                    }
                }
                if (!judge)
                    System.out.println("暂时没有该年龄区间的小狗呦");
            } else {
                System.out.println("输入错误！！！");
            }
        }


    }
}