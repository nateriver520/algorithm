package com.nateriver.app.quiz;

/**
 * Double to chinese
 * 1000000001.9 => 壹十亿零壹点玖
 */
public class DoubleToChinese {
    private final static String[] UNITS = {"", "十", "百", "千", "万", "亿"};
    private final static String[] NUMBERS = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private final static String[] GROUP_UNITS = {"","万","亿"};

    public String transform(String number){
        String[] numberArr = number.split("\\.");
        StringBuilder sb = new StringBuilder();
        String beforePoint = numberArr[0];
        sb.append(handleBeforePoint(beforePoint));

        if(numberArr.length == 2){
            String afterPoint = numberArr[1];
            sb.append(handleAfterPoint(afterPoint));
        }
        return sb.toString();
    }

    public String clearBeforeZero(String str){
        return str.replaceAll("^0+","");
    }

    public String handleAfterPoint(String aferPoint){
        if(clearBeforeZero(aferPoint).isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < aferPoint.length(); i++){
            int value = aferPoint.charAt(i) - '0';
            res.append(NUMBERS[value]);
        }
        return "点" + res.toString();
    }

    public String handleBeforePoint(String beforePoint){
        if(beforePoint.contains("0") && clearBeforeZero(beforePoint).isEmpty()){
            return NUMBERS[0];
        }
        beforePoint = clearBeforeZero(beforePoint);
        StringBuilder res = new StringBuilder();
        int mod = beforePoint.length()%4;
        int group = beforePoint.length()/4;

        res.append(
                tranform4(
                        beforePoint.substring(0, mod),
                        GROUP_UNITS[group]
                )
        );

        for(int i = 0; i < group; i++){
            int from = mod + i*4;
            int to = from + 4;
            res.append(
                    tranform4(
                            beforePoint.substring(from, to),
                            GROUP_UNITS[group -1 - i]
                    )
            );
        }

        return res.toString();
    }

    public String tranform4(String number, String unit){
        StringBuilder res = new StringBuilder();
        char[] chars = number.toCharArray();
        Integer length = chars.length;

        for(int i = 0 ; i < length; i++){
            Integer value = chars[i] - '0';
            if(value != 0){
                res.append(NUMBERS[value]).append(UNITS[length - 1 - i]);
            }

            if(value == 0){
                int j;
                for(j = i +1 ; j < length; j++){
                    //break 0
                    if(chars[j] != '0'){
                        res.append(NUMBERS[value]);
                        j--;
                        break;
                    }
                }
                i = j;
            }
        }
        if(res.toString().isEmpty()) return "";
        return res.toString() + unit;
    }


    public static void main(String[] args) {
        DoubleToChinese tn = new DoubleToChinese();
        System.out.println(tn.transform("1001"));
    }
}
