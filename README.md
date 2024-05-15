//使用方法-
-将该java文件导入lib添加库使用
-将All字符串内数字通过该方法输出为整数int数组,可区分正负数.
String_IntArray mod = new String_IntArray();
        String str = "String类型字符串,10-10.10";
        int[] it = mod.StringIntArray(str);
        for(int a : it){
            System.out.println(a);
        }
        //10 , -10 , 10
