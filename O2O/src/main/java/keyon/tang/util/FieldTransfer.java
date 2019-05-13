package keyon.tang.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/8 9:32
 * @Version 1.0
 */

/**
 * 将带下划线的字段保存在.txt文件中， 该程序会在当前文件下追加显示转化为驼峰命名的文件
 */
public class FieldTransfer {


    public static void main(String[] args) throws Exception {
           FileReader reader=new FileReader("data.txt");
          List<String> filedList = readFileds(reader, new ArrayList<String>());
       for(String field: filedList){
            List<Integer> indexList = getIndex("_", field, new ArrayList<Integer>(), 0);
            indexList.add(0);//首字母
            getUpperCase(field,indexList,new File("result.txt"));
         }
    }

    /**
     * 返回字符串中指定子串的索引位置（所有位置）
     * @param index    指定子串
     * @param word     字符串
     * @param indexList  保存索引的集合
     * @param offset   偏移量， 传入0即可
     * @return
     */
    public static List<Integer> getIndex(String index,String word,List<Integer> indexList,int offset){
           int i = word.indexOf(index);
//           根据新子串中的位置计算出实际的位置
           if(offset==0){
               offset=i;
           } else {offset=offset+i+1;}

//    字符串中若没有目标子串就直接返回
            if(i ==-1)  return indexList;
    //若该字符出现在字符串的末尾就直接返回
        if(offset==word.length()-1) return indexList;
//集合中真正保存的是实际位置
        indexList.add(offset);
//        目标数据在substring()方法截去后的子串中会返回在新的子串内的索引，因此必须借助偏移量来记录实际位置
         return getIndex(index, word.substring(i+1), indexList,offset);
    }

    /**
     * 将文件中的字符串一行一行的读取
     * @param reader    流对象
     * @param list   用于保存字符串的集合
     * @return    返回保存字符串的集合
     * @throws IOException
     */
    public static List<String> readFileds(Reader reader,List<String> list) throws IOException {
        LineNumberReader lineNumberReader=new LineNumberReader(reader);
        String field=null;
              while ((field = lineNumberReader.readLine() )!=null){
                  list.add(field);
              }
             return  list;
    }

    /**
     * 将字符串转成驼峰命名的格式后写入原文件
     * @param word  单个字符串
     * @param indexList  保存字符串中_索引的集合
     * @param file   原文件
     * @throws IOException
     */
    public static void getUpperCase(String word, List<Integer> indexList, File file) throws IOException {
        FileWriter fileWriter =new FileWriter(file,true);
        String result = null;
        StringBuilder stringBuilder=new StringBuilder(word);
//        集合中记录的是一个字符串中_的位置
        for (int i=0;i<indexList.size();i++){
            Integer index = indexList.get(i);
//           将_后一个字符转换为大写
            Character ch = stringBuilder.charAt(index+1);
            String replaceCh = ch.toString().toUpperCase();
//            细节：将_和一个小写的字母改成大写会改变字符串的长度，要确保此时字符串的长度要与文件中字符串的长度相当
            stringBuilder.replace(index,index+2,replaceCh);
//            一个不错的方法就是每替换一个_就在字符串的首位添加一个特殊字符来保持字符串长度的不变
            stringBuilder.insert(0,"@");

        }
        String string = stringBuilder.toString();
//        输出之前将添加的所有特殊字符全部替换为空格
        result = string.replaceAll("[@]", "");
        fileWriter.write(result+"\n");
          fileWriter.close();
    }
}

