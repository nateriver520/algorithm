package com.nateriver.app.leetcode;

import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/simplify-path/
 Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"

 Corner Cases:
 Did you consider the case where path = "/../"?
 In this case, you should return "/".
 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        path = path.replaceAll("\\/+", "/");
        String[] ps = path.split("\\/");
        Stack<String> stack  = new Stack<>();

        if(path.startsWith("/"))
            stack.push("/");

        for(String p : ps){
            switch (p) {
                case "..":
                    if(!stack.isEmpty())
                        stack.pop();
                    break;
                case ".":
                    continue;
                default:
                    stack.push(p);
                    break;
            }
        }

        String res = "";
        for(String s : stack){
            res += s + "/";
        }
        res = "//" + res;
        return res.replaceAll("\\/$", "").replaceAll("\\/+", "/");
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath("/home//foo/"));   //  /home/foo
        System.out.println(sp.simplifyPath("/a/./b/../../c/"));   // /c
        System.out.println(sp.simplifyPath("/../"));         // /
        System.out.println(sp.simplifyPath("/home/"));       // /home
        System.out.println(sp.simplifyPath("/.././tqCEe/..///L/../../././//../../../JGF/../ZUFaY/.///wMzVK//")); // ZUFaY/wMzVK
        System.out.println(sp.simplifyPath("/home/../../.."));  // /
        System.out.println(sp.simplifyPath("/.././em/jl///../.././../E/"));        // /E

    }
}
