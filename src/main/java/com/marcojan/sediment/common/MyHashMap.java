package com.marcojan.sediment.common;

import java.util.HashMap;

public class MyHashMap {

    static class Person{
        int id;
        String name;


        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()){
                return false;
            }
            Person person = (Person) o;

            return this.id == person.id;
        }
    }

    /**
     * 在Map中会先计算HashCode，找到对应的数组下标，然后再进行Equals
     * 如果没有对HashCode进行重写，那么不同对象的hash值对应的是他的内存地址
     * @param args
     */
    public static void main(String []args){
        HashMap<Person,String> map = new HashMap<Person, String>();
        Person person1 = new Person(1234,"乔峰");

        System.out.println(person1.hashCode());
        //put到hashmap中去
        map.put(person1,"天龙八部");

        //get取出，从逻辑上讲应该能输出“天龙八部”
        Person person2 = new Person(1234,"萧峰");
        System.out.println(person2.hashCode());

        System.out.println("结果:"+map.get(person1));
    }
}
