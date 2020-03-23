package test;
//文件名 :fileStreamTest2.java
import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class second {

    //计算字符数
    public  static void count(String filepart) throws IOException {
        int count = 0;
        File file = new File(filepart);//利用File效率更好一点
        BufferedReader br = new BufferedReader(new FileReader(file));
        String a, b;//设置a,b进行判断
            while((a = br.readLine()) != null)
            {       //排除空白符影响，s表示匹配任何空白字符，包括空格、制表符、换页符等等
                    b = a.replaceAll("\\s+", "");
                    count += b.length();
            }
        System.out.println("字符数为:" + count);
        br.close();//关闭流并释放资源
        return;
    }

    //计算行数
    public   static void linecount(String filepart)throws IOException {
        int linecount = 0;
        File file = new File(filepart);
        BufferedReader br = new BufferedReader(new FileReader(file));
            while(br.readLine() != null)
                linecount++;
        System.out.println("行数为:" + linecount);
        br.close();
        return;
        }

     //计算词数
    public   static void wordcount(String filepart  )throws IOException {
        int wordcount = 0;
        File file = new File(filepart);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
            while((line = br.readLine()) != null) {
                String[] str = line.split("\\w+");//\\w 匹配包括下划线的任何单词字符
                for(String word : str) {
                    if(!"".equals(line))//检查是否有空字符
                        wordcount++;
                }
            }
            System.out.println("词数为:" + wordcount);
            br.close();
            return;
    }
    //返回空行数，代码行数，注释行数
    public  static void  extracounts(String filepart) throws IOException{
        int number1 = 0,number2=0,number3=0;
        FileInputStream file = new FileInputStream(filepart);//此时用FileInputStream效果更加
        FileReader fr = new FileReader(filepart);
        BufferedReader br = new BufferedReader(fr);
        String line;
            while((line=br.readLine())!=null){
                //利用匹配与正则表达式来获取空行：^为起始，*为零次或多次，？为是否匹配，$终止
                   if(Pattern.compile("^\\s*\\S?\\s*$").matcher(line).matches())
                            number1++;
                else
                    if (line.contains("//"))
                            number2++;
                else
                            number3++;
            }
        System.out.println("空行:" +number1);
        System.out.println("注释行:" +number2);
        System.out.println("代码行:" +number3);
        br.close();
        return;
        }


        //主
        public static void main (String[]args) throws IOException {
           //读取文件
            Scanner scan = new Scanner(System.in);
                System.out.println("请输入目标源文件地址");//输入（"g/练习程序/java.*)
            String uri = scan.next();//定义uri
                FileInputStream f = new FileInputStream(uri);//此时用字节效果较好
                FileReader fr = new FileReader(uri);
                BufferedReader br = new BufferedReader(fr);
            String test;
                if ((test = br.readLine()) != null)
                    System.out.println("读取成功哦");
                else
                    System.out.println("不存在文件呀！");
            //实现功能
            linecount(uri);
            count(uri);
            wordcount(uri);
            extracounts(uri);
                }
            }









