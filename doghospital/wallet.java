package doghospital;

public class wallet {
    public static int money = 100;
    public static String time = "";
    public static int getMoney(){
        return money;
    }
    public static void setMoney(int money){
        wallet.money = money;
    }

    public static String getTime(){
        return time;
    }
    public static void setTime(String time){
        wallet.time = time;
    }
}
