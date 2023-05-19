package doghospital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    int choose;
    private boolean b = true;
    public void Dogs(dog[] dogs) {
        System.out.println("以下是小狗的全部信息：");
        System.out.println("编号\t\t颜色\t\t\t年龄\t\t价格");
        for (int i = 0; i < dogs.length; i++) {
            if (dogs[i] == null) {
                break;
            }
            System.out.printf("%2d\t\t%-6s\t\t%2d\t\t%4d\n",dogs[i].getId(),dogs[i].getColor(),dogs[i].getAge(),dogs[i].getPrica());
        }
    }


    //用户主菜单
    public dog[] BossChoose(dog[] dogs) {

        while (b) {
            System.out.println("      请问您想进行什么操作      ");
            System.out.println("      1    染色");
            System.out.println("      2    买入一只小狗");
            System.out.println("      3    查看钱包");
            System.out.println("      4    直接显示小狗全部信息");
            System.out.println("      5    退出");

            try{
                choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                         System.out.println("请问您想给哪只小狗染色");
                         int n = scanner.nextInt();
                         dogs = Service.change(n);
                         break;
                    case 2:
                        System.out.println("请输入新小狗的颜色");
                        String color = scanner.next();
                        System.out.println("请输入新小狗的年纪");
                       int age = scanner.nextInt();
                       System.out.println("请输入新小狗的售价");
                       int price = scanner.nextInt();
                       int i;
                       for (i = 0; dogs[i] != null; i++);
                       int sign = dogs[i-1].getId()+1;
                       dog Dog = new dog(sign, color, age, price);
                       dogs = Service.add(Dog);
                       break;
                    case 3:
                        System.out.println("您现在余额为" + wallet.getMoney() + "(初始资金为100)");
                        System.out.println(wallet.getTime());
                        break;
                    case 4:
                        new Menu().Dogs(dogs);
                        break;
                    case 5:
                        return dogs;
                    default:
                        System.out.println("输入错误！！！请重新输入");
                }
            }catch (InputMismatchException e){
                System.out.println("输入错误！！！");
                break ;
        }

        }return dogs;
    }
        //老板主菜单
        public dog[] CusChoose(dog[] dogs) {
            //用户主菜单
            while (b) {
                System.out.println("      请问您想按照什么特点来购买宠物      ");
                System.out.println("      1    毛色");
                System.out.println("      2    年龄区间");
                System.out.println("      3    直接显示小狗全部信息");
                System.out.println("      4    直接购买");
                System.out.println("      5    退出");

                try {
                    choose = scanner.nextInt();
                    switch (choose) {
                        case 1:
                            Service.find(1);
                            break;
                        case 2:
                            Service.find(2);
                            break;
                        case 3:
                            new Menu().Dogs(dogs);
                            break;
                        case 4:
                            System.out.println("请选择你要购买的小狗编号");
                            int n = scanner.nextInt();
                            dogs = Service.del(n);
                            break;
                        case 5:
                            return dogs;
                        default:
                            System.out.println("输入错误！！！请重新输入");
                    }
                }catch (InputMismatchException e){
                    System.out.println("输入错误！！！");
                    break ;
                }
            }
            return dogs;
        }

}