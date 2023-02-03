import java.util.*;

public class Examples04 {
    public static void main(String[] args) {
        ex4();
    }

    static void ex4(){
        MyStack myStack = new MyStack(4);
        System.out.println(myStack.size());
        myStack.push(5);
        myStack.push(4);
        myStack.push(2);
        myStack.push(10);
        myStack.push(7);
        myStack.push(50);
        System.out.println(myStack.peek());
        System.out.println(myStack.peek());
        System.out.println(myStack.peek());

        System.out.println(myStack.size());
        System.out.println();
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

        System.out.println(myStack);
        myStack.push(33);
        System.out.println(myStack);
    }
    static void ex(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);

        int sum = 0;
        for (Integer integer: list){

        }
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            iterator.remove();
            sum += integer;
        }
    }
    static void ex0(){
        /*
        1) Р—Р°РјРµСЂСЊС‚Рµ РІСЂРµРјСЏ, Р·Р° РєРѕС‚РѕСЂРѕРµ РІ ArrayList РґРѕР±Р°РІСЏС‚СЃСЏ 10000 СЌР»РµРјРµРЅС‚РѕРІ.
        2) Р—Р°РјРµСЂСЊС‚Рµ РІСЂРµРјСЏ, Р·Р° РєРѕС‚РѕСЂРѕРµ РІ LinkedList РґРѕР±Р°РІСЏС‚СЃСЏ 10000 СЌР»РµРјРµРЅС‚РѕРІ. РЎСЂР°РІРЅРёС‚Рµ СЃ РїСЂРµРґС‹РґСѓС‰РёРј.
         */

        ArrayList<Integer> list1 = new ArrayList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list1.add(0, 5);
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("ArrayList: " + (finishTime - startTime));

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list2.add(0, 5);
        }
        long finishTime2 = System.currentTimeMillis();
        System.out.println("LinkedList: " + (finishTime2 - startTime2));
    }
    static void ex1(){
        /*
        Р РµР°Р»РёР·РѕРІР°С‚СЊ РєРѕРЅСЃРѕР»СЊРЅРѕРµ РїСЂРёР»РѕР¶РµРЅРёРµ, РєРѕС‚РѕСЂРѕРµ:

        РџСЂРёРЅРёРјР°РµС‚ РѕС‚ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ СЃС‚СЂРѕРєСѓ РІРёРґР°
        text~num
        РќСѓР¶РЅРѕ СЂР°СЃСЃРїР»РёС‚РёС‚СЊ СЃС‚СЂРѕРєСѓ РїРѕ ~, СЃРѕС…СЂР°РЅРёС‚СЊ text РІ СЃРІСЏР·РЅС‹Р№ СЃРїРёСЃРѕРє РЅР° РїРѕР·РёС†РёСЋ num.
        Р•СЃР»Рё РІРІРµРґРµРЅРѕ print~num, РІС‹РІРѕРґРёС‚ СЃС‚СЂРѕРєСѓ РёР· РїРѕР·РёС†РёРё num РІ СЃРІСЏР·РЅРѕРј СЃРїРёСЃРєРµ Рё СѓРґР°Р»СЏРµС‚ РµС‘ РёР· СЃРїРёСЃРєР°.
         */
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> linkedList = new LinkedList<>();

        while (true){
            String line = scanner.nextLine();
            String[] lines = line.split("~");
            if (lines[0].equals("end")){
                break;
            }
            if (!check(linkedList, lines)){
                continue;
            }
            if (lines[0].equals("print")){
                String word = linkedList.get(Integer.parseInt(lines[1]));
                linkedList.remove(Integer.parseInt(lines[1]));
                System.out.println(word);
            } else {
                linkedList.add(Integer.parseInt(lines[1]), lines[0]);
            }
        }
        System.out.println("Р”Рѕ СЃРєРѕСЂРѕР№ РІСЃС‚СЂРµС‡Рё");
    }
    static void ex2(){
        /*
        Р РµР°Р»РёР·РѕРІР°С‚СЊ РєРѕРЅСЃРѕР»СЊРЅРѕРµ РїСЂРёР»РѕР¶РµРЅРёРµ, РєРѕС‚РѕСЂРѕРµ:
        РџСЂРёРЅРёРјР°РµС‚ РѕС‚ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ Рё вЂњР·Р°РїРѕРјРёРЅР°РµС‚вЂќ СЃС‚СЂРѕРєРё.
        Р•СЃР»Рё РІРІРµРґРµРЅРѕ print, РІС‹РІРѕРґРёС‚ СЃС‚СЂРѕРєРё С‚Р°Рє, С‡С‚РѕР±С‹ РїРѕСЃР»РµРґРЅСЏСЏ РІРІРµРґРµРЅРЅР°СЏ Р±С‹Р»Р° РїРµСЂРІРѕР№ РІ СЃРїРёСЃРєРµ, Р° РїРµСЂРІР°СЏ - РїРѕСЃР»РµРґРЅРµР№.
        Р•СЃР»Рё РІРІРµРґРµРЅРѕ revert, СѓРґР°Р»СЏРµС‚ РїСЂРµРґС‹РґСѓС‰СѓСЋ РІРІРµРґРµРЅРЅСѓСЋ СЃС‚СЂРѕРєСѓ РёР· РїР°РјСЏС‚Рё.

         */
    }
    static void ex3(){
        /*
        1) РќР°РїРёСЃР°С‚СЊ РјРµС‚РѕРґ, РєРѕС‚РѕСЂС‹Р№ РїСЂРёРЅРёРјР°РµС‚ РјР°СЃСЃРёРІ СЌР»РµРјРµРЅС‚РѕРІ, РїРѕРјРµС‰Р°РµС‚ РёС… РІ СЃС‚СЌРє
        Рё РІС‹РІРѕРґРёС‚ РЅР° РєРѕРЅСЃРѕР»СЊ СЃРѕРґРµСЂР¶РёРјРѕРµ СЃС‚СЌРєР°.
        2) РќР°РїРёСЃР°С‚СЊ РјРµС‚РѕРґ, РєРѕС‚РѕСЂС‹Р№ РїСЂРёРЅРёРјР°РµС‚ РјР°СЃСЃРёРІ СЌР»РµРјРµРЅС‚РѕРІ,
        РїРѕРјРµС‰Р°РµС‚ РёС… РІ РѕС‡РµСЂРµРґСЊ Рё РІС‹РІРѕРґРёС‚ РЅР° РєРѕРЅСЃРѕР»СЊ СЃРѕРґРµСЂР¶РёРјРѕРµ РѕС‡РµСЂРµРґРё.
         */
        int[] array = new int[]{4,5,6,3,2,1,7};
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < array.length; i++) {
//            stack.push(array[i]);
//        }
//        System.out.println(stack.pop());
//        System.out.println(stack);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            queue.offer(array[i]);
        }
        System.out.println(queue.peek());
        System.out.println(queue);
    }

    static boolean check(LinkedList<String> linkedList, String[] lines){
//        try {
//                    linkedList.add(Integer.parseInt(lines[1]), lines[0]);
//                } catch (Exception e){
//                    System.out.println("Р’РІРµРґРµРЅР° РЅРµРІРµСЂРЅР°СЏ РєРѕРјР°РЅРґР°");
//                      continue;
//                }
        if (!lines[1].matches("[0-9]+")){
            System.out.println("Р’РІРµРґРµРЅР° РЅРµРІРµСЂРЅР°СЏ РєРѕРјР°РЅРґР°");
            return false;
        }
        int index = Integer.parseInt(lines[1]);
        if (index > linkedList.size()){
            System.out.println("Р’РІРµРґРµРЅР° РЅРµРІРµСЂРЅР°СЏ РєРѕРјР°РЅРґР°");
            return false;
        }
        return true;
    }
}
