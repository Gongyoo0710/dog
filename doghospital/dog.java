package doghospital;

public class dog {
    public int id;
    private String color;
    private int age;
    private int price;
    public dog(int id,String color,int age,int price){
        this.id = id;
        this.age = age;
        this.color = color;
        this.price = price;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public int getPrica(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    @Override
    public String toString(){
         return id+"\t\t"+color+"\t\t"+age+"\t\t"+price;
    }
}