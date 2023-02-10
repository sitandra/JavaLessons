/*
1. Продумайте структуру класса Кот. Какие поля и методы будут актуальны для приложения, которое является
а) информационной системой ветеринарной клиники
б) архивом выставки котов
в) информационной системой Театра кошек Ю. Д. Куклачёва
Можно записать в текстовом виде, не обязательно реализовывать в java.
 */
public class Cat {
    String name;
    int age;
    String ownerName;
    String doctorName;

    void sayMayu(){
        System.out.println("Мяу-мяу");
    }

    String getName() {
        return name;
    }

    public String toString() {
        return name + ", " + age + " лет, хозяин: " + ownerName;
    }

    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Cat)){
            return false;
        }
        Cat cat = (Cat) obj;
        if (name.equals(cat.name) && age == cat.age && ownerName.equals(cat.ownerName)){
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return name.hashCode() + 7*age + 13*ownerName.hashCode();
    }
}
