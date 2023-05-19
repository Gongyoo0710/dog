package doghospital;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Service service = new Service(100);
            dog[] dogs = service.list();

            A : while (true) {
                 System.out.println("请问你是顾客还是老板" + '\n' + "1---->顾客" + '\n' + "2---->老板" + '\n' + "0---->直接退出本系统");

                 try{
                    int n = scanner.nextInt();
                    if (n == 1) {
                        dogs = new Menu().CusChoose(dogs);

                    } else if (n == 2) {
                        dogs = new Menu().BossChoose(dogs);
                    } else if (n == 0) {
                        break A;
                    } else {
                        System.out.println("输入错误！！！请重新输入");
                    }
                }catch (InputMismatchException e){
                    System.out.println("输入错误！！！");
                    break ;
                }

              // new Menu().Dogs(dogs);
            }
            System.out.println("您已退出本系统，谢谢使用");
        }

}

