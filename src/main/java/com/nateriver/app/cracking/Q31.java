package com.nateriver.app.cracking;

/**
 * Describe how you could use a single array to implement three stacks.
 */
public class Q31 {

    private static Object[] arr;
    private static Integer top1;
    private static Integer top2;
    private static Integer top3_left;
    private static Integer top3_right;
    private static Boolean isLeft = true;

    public static void newStack(int size){
        arr = new Object[size];
        top1 = 0;
        top2 = size;
        top3_left = size/2;
        isLeft = true;
        top3_right = top3_left + 1;
    }

    public static void push(Integer stackNum,Object val){
        if(stackNum == 0 && top1 != top3_left + 1){
            arr[top1] = val;
            top1 ++;
        }else if (stackNum == 2){
            if(isLeft && top3_left +1 != top1){
                arr[top3_left] = val;
                top3_left--;
            }
            else if(!isLeft && top3_right != top2){
                arr[top3_right] = val;
                top3_right ++;
            }
            isLeft = !isLeft;
        }else if (stackNum ==1 && top2 != top3_right){
            top2 --;
            arr[top2] = val;
        }
    }

    public static Object pop(Integer stackNum){
        Object val = null;
        if(stackNum == 0){
            if(top1 == 0) return val;

            top1 --;
            val = arr[top1];
            arr[top1] = null;

        }else if(stackNum ==1){
            if(top2 == arr.length) return val;

            val = arr[top2];
            arr[top2] = null;
            top2 ++;

        }else if(stackNum == 2){
            if(top3_left + 1 == top3_right) return val;

            if(!isLeft){
                top3_left ++;
                val = arr[top3_left];
                arr[top3_left] = null;

            }else {
                top3_right--;
                val =arr[top3_right];
                arr[top3_right] = null;
            }
            isLeft = !isLeft;
        }

        return val;
    }

    public static Object top(Integer stackNum){
        if(stackNum ==0){
            if(top1 == 0){
                System.out.println("stack 1 is empty");
                return null;
            }
            return arr[top1 -1];
        }
        else if (stackNum == 1){
            if(top2 == arr.length){
                System.out.println("stack 2 is empty");
                return null;
            }
            return arr[top2];
        }
        else if(stackNum == 2){
            if(top3_left + 1 == top3_right){
                System.out.println("stack 3 is empty");
                return null;
            }
            if(isLeft)
                return arr[top3_right - 1];
            else
                return arr[top3_left + 1];
        }
        return null;
    }

    public static void main(String[] args) {
        newStack(5);
        push(0,1);
        push(0,2);
        push(2,6);
        push(2,100);

        System.out.println(top(0));
        System.out.println(top(1));
        System.out.println(top(2));

        System.out.println(pop(0));
        System.out.println(pop(0));
        System.out.println(pop(2));
        System.out.println(pop(2));

    }

}
