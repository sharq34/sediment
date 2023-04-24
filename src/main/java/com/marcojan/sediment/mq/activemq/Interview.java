package com.marcojan.sediment.mq.activemq;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出下面的一个list
 * [
 *   [1, 3, 2],
 *   [2, 5, 1, 7, 8],
 *   [4, 3],
 *   ...
 *  ]
 * List长度为N，里面每一个元素都是一个List, 长度不固定;
 * 从上述List里面的每一个子List选出一个可以组成长度为N的List, 例如 [1, 2, 4]
 * 求出所有这样的List
 */
public class Interview {

    public static void main(String[] args){
        List arrays = new ArrayList();

        new Interview().subList(null, arrays);

    }

    private List subList(List<List<Integer>> current, List<Integer> others){

        if(current == null){
            current =new ArrayList<List<Integer>>();
            others.get(0);
//            for()
//            current = others.subList(0,1);
        }


        for(int i =0;i<current.size();i++){

            List<Integer> array = current.get(i);

            for(int k = 0;k<others.size();k++){
                List<Integer> t = new ArrayList<Integer>();

            }
        }

        return subList(current, others.subList(1,others.size()-1));
    }

}
